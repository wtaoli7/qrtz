package com.entstudy.info.platform.qrtz.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entstudy.info.platform.qrtz.mapper.GxhAttendenceInfoMapper;
import com.entstudy.info.platform.qrtz.mapper.SignRecordMapper;
import com.entstudy.info.platform.qrtz.model.GxhAttendenceInfo;
import com.entstudy.info.platform.qrtz.model.SignRecord;
import com.entstudy.info.platform.qrtz.service.GxhAttendenceInfoService;
import com.entstudy.info.platform.qrtz.service.NotifyService;

/**
 * @ClassName: AttendenceInfoServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月23日 下午3:29:23
 * 
 */
@Service
public class GxhAttendenceInfoServiceImpl implements GxhAttendenceInfoService {

	private static final Logger logger = LoggerFactory
			.getLogger(GxhAttendenceInfoServiceImpl.class);

	@Autowired
	private GxhAttendenceInfoMapper attendenceInfoMapper;

	@Autowired
	private SignRecordMapper signRecordMapper;

	@Autowired
	private NotifyService notifyService;

	/**
	 * 
	 * @Description: 排课信息同步到考勤表
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public int syncAttendenceInfo() throws Exception {
		int size = 0;
		String currentDate = DateFormatUtils.format(Calendar.getInstance(),
				"yyyy-MM-dd");
		// String currentDate = DateFormatUtils.format(
		// DateUtils.addDays(Calendar.getInstance().getTime(), -1),
		// "yyyy-MM-dd");
		List<GxhAttendenceInfo> list = null;
		logger.info("currentDate:" + currentDate);
		try {
			list = attendenceInfoMapper.queryWxGxhAttendInfoFromV3(currentDate);
		} catch (Exception e) {
			logger.error("Exception:", e);
			return 0;
		}
		if (list != null && !list.isEmpty()) {
			size = list.size();
			for (GxhAttendenceInfo info : list) {
				try {
					info.setStartTime(info.parseStartTime());
					info.setEndTime(info.parseEndTime());
					attendenceInfoMapper.attendenceInfoSaveOrUpdate(info);
				} catch (Exception e) {
					logger.error("保存或者更新排课信息异常:" + info);
					logger.error("Exception:", e);
				}
			}
		}

		logger.info("新增或者更新排课信息" + size + " 条");
		return size;
	}

	/*
	 * 已考勤的排课，给学生家长发送短信通知
	 * 
	 * sendStudentNotify()
	 */
	@Override
	public int sendParentNotify() throws Exception {
		String currentDate = DateFormatUtils.format(Calendar.getInstance(),
				"yyyy-MM-dd");
		// String currentDate = DateFormatUtils.format(
		// DateUtils.addDays(Calendar.getInstance().getTime(), -1),
		// "yyyy-MM-dd");
		logger.info("currentDate:" + currentDate);
		List<GxhAttendenceInfo> infoList = null;
		try {
			infoList = this.attendenceInfoMapper
					.queryAttendedUnNotifyInfos(currentDate);
		} catch (Exception e) {
			logger.error("Exception:", e);
			return 0;
		}

		if (infoList != null && !infoList.isEmpty()) {
			for (GxhAttendenceInfo info : infoList) {
				logger.info("AttendenceInfo:" + info);
				try {
					notifyService.sendParentNotify(info);
				} catch (Exception e) {
					logger.error("Exception:", e);
				}
			}
		} else {
			logger.info("没有考勤完成未发送通知的排课信息");
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * 已开始上课未考勤的排课，需要发送微信通知给学管师 sendManagerNotify()
	 */
	@Override
	public int sendManagerNotify() throws Exception {
		String onDate = DateFormatUtils.format(Calendar.getInstance(),
				"yyyy-MM-dd");
		String currentTime = DateFormatUtils.format(Calendar.getInstance(),
				"yyyy-MM-dd HH:mm:ss");
		Map<String, String> params = new HashMap<String, String>();
		params.put("onDate", onDate);
		params.put("currentTime", currentTime);
		List<GxhAttendenceInfo> infoList = attendenceInfoMapper
				.queryUnAttendedUnNotifyInfos(params);
		logger.info("Un Notify Manager infoList:" + infoList.size());
		if (infoList != null && !infoList.isEmpty()) {
			for (GxhAttendenceInfo info : infoList) {
				logger.debug(info.toString());
				// notifyService.sendManagerNoAttendNotify(info);
			}
			notifyService.sendManagerNoAttendNotify(infoList.get(0));

			attendenceInfoMapper.updateAttendenceInfoManagerNotify(infoList
					.get(0));
		}

		return 0;
	}

	/*
	 * (non-Javadoc) 处理当天未签到的排课信息
	 */
	@Override
	public int handleUnSignAttendenceInfo() throws Exception {
		String onDate = DateFormatUtils.format(Calendar.getInstance(),
				"yyyy-MM-dd");
		List<GxhAttendenceInfo> infoList = attendenceInfoMapper
				.queryUnSignAttendedInfos(onDate);
		logger.info("UnSignAttendenceInfoList:" + infoList.size());
		if (infoList != null && !infoList.isEmpty()) {
			for (GxhAttendenceInfo info : infoList) {
				logger.debug(info.toString());
				String teaSingFlag = info.getTea_sign_flag();
				String stuSingFlag = info.getStu_sign_flag();

				// 处理老师未签到
				if (StringUtils.isNotBlank(teaSingFlag)
						&& teaSingFlag.equalsIgnoreCase("N")) {
					this.handleTeaUnSignInfo(info);
				}

				// 处理学生未签到
				if (StringUtils.isNotBlank(stuSingFlag)
						&& stuSingFlag.equalsIgnoreCase("N")) {
					this.handleStuUnSignInfo(info);
				}
			}
		}
		return 0;
	}

	/**
	 * 
	 * @Description: 老师未签到，查询是否有对应的签到信息
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	private void handleTeaUnSignInfo(GxhAttendenceInfo info) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		// 上课前1小时刷卡 到 课程结束前都是有效刷卡
		String endTime = info.getEndTime();
		String startTime = DateFormatUtils.format(
				DateUtils.addHours(DateUtils.parseDate(info.getStartTime(),
						"yyyy-MM-dd HH:mm:ss"), -1), "yyyy-MM-dd HH:mm:ss");
		String teacherId = info.getTeacherId();

		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("teacherId", teacherId);
		// 查询符合时间条件的签到信息
		List<SignRecord> recordList = signRecordMapper
				.queryTeacherSignRecord(params);
		if (recordList != null && !recordList.isEmpty()) {
			SignRecord record = recordList.get(0);
			info.setTea_sign_flag("Y");
			info.setTea_sign_type("1");
			info.setTea_sign_id(record.getId());
			attendenceInfoMapper.updateAttendenceInfoTeStatus(info);
		} else {
			logger.error("handle teacher unKnow sign info:" + info.getFid());
		}
	}

	/**
	 * 
	 * @Description:学生未签到，查询是否有对应的签到信息
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	private void handleStuUnSignInfo(GxhAttendenceInfo info) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		// 上课前1小时刷卡 到 课程结束前都是有效刷卡
		String endTime = info.getEndTime();
		String startTime = DateFormatUtils.format(
				DateUtils.addHours(DateUtils.parseDate(info.getStartTime(),
						"yyyy-MM-dd HH:mm:ss"), -1), "yyyy-MM-dd HH:mm:ss");
		String studentNo = info.getStudentNo();

		params.put("startTime", startTime);
		params.put("endTime", endTime);
		params.put("studentNo", studentNo);
		// 查询符合时间条件的签到信息
		List<SignRecord> recordList = signRecordMapper
				.queryStudentSignRecord(params);
		if (recordList != null && !recordList.isEmpty()) {
			SignRecord record = recordList.get(0);
			info.setStu_sign_flag("Y");
			info.setStu_sign_type("1");
			info.setStu_sign_id(record.getId());
			attendenceInfoMapper.updateAttendenceInfoStStatus(info);
		} else {
			logger.error("handle student unKnow sign info:" + info.getFid());
		}
	}

}
