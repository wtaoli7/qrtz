package com.entstudy.info.platform.qrtz.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entstudy.info.platform.qrtz.mapper.GxhAttendenceInfoMapper;
import com.entstudy.info.platform.qrtz.mapper.V3StudentInfoMapper;
import com.entstudy.info.platform.qrtz.model.GxhAttendenceInfo;
import com.entstudy.info.platform.qrtz.model.NotifyConfig;
import com.entstudy.info.platform.qrtz.model.V3StudentInfo;
import com.entstudy.info.platform.qrtz.model.WeixinNotifyContent;
import com.entstudy.info.platform.qrtz.service.NotifyService;
import com.entstudy.info.platform.qrtz.service.WeixinQyService;
import com.entstudy.info.platform.qrtz.util.HttpClientUtil;

/**
 * @ClassName: NotifyServiceImpl
 * @Description: 考勤通知服务，调用短信或者微信接口，完成考勤通知
 * @author liwt
 * @date 2016年7月23日 下午6:28:53
 * 
 */
@Service
public class NotifyServiceImpl implements NotifyService {

	private static final Logger logger = LoggerFactory
			.getLogger(NotifyServiceImpl.class);

	@Autowired
	private V3StudentInfoMapper v3StudentInfoMapper;

	@Autowired
	private GxhAttendenceInfoMapper attendenceInfoMapper;

	@Autowired
	private NotifyConfig config;

	@Autowired
	private WeixinQyService weixinQyService;

	/*
	 * 发送学生家长短信通知
	 * 
	 * @see
	 */
	@Override
	public boolean sendParentNotify(GxhAttendenceInfo info) throws Exception {
		if (info != null) {
			String studentNo = info.getStudentNo();
			V3StudentInfo studnetInfo = v3StudentInfoMapper
					.queryV3StudentInfo(studentNo);
			if (studnetInfo != null) {
				String phoneNumber = studnetInfo.getCfcontactinfo();
				String content = config.getShortMessageContent()
						.replace("#student#", info.getStudentName())
						.replace("#onDate#", info.getOnDate())
						.replace("#startTime#", info.getStartTimeHour())
						.replace("#endTime#", info.getEndTimeHour())
						.replace("#subject#", info.getSubjectName())
						.replace("#managerName#", info.getManagerName());
				boolean flag = HttpClientUtil.sendShortMessage(
						config.getShortMessageCenter(), "15221581425", content);
				if (flag) {
					attendenceInfoMapper.updateAttendenceInfoParentNotify(info);
				} else {
					logger.error("发送短信失败：" + phoneNumber);
				}

			} else {
				logger.error("学生编码：" + studentNo + ",没找到对应的学生信息");
			}
		} else {
			logger.error("入参  AttendenceInfo 为null");
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.entstudy.info.platform.qrtz.service.NotifyService#
	 * sendManagerNoAttendNotify
	 * (com.entstudy.info.platform.qrtz.model.GxhAttendenceInfo)
	 */
	@Override
	public boolean sendManagerNoAttendNotify(GxhAttendenceInfo info)
			throws Exception {
		String userId = info.getManagerNo();
		String fNumber = info.getfNumber();
		WeixinNotifyContent content = new WeixinNotifyContent.Builder()
				.student(info.getStudentName()).teacher(info.getTeacherName())
				.subject(info.getSubjectName()).startTime(info.getStartTime())
				.fnumberFoot(fNumber.substring(fNumber.length() - 5)).build();

		weixinQyService.sendNotify("mfy", content);
		return false;
	}

}
