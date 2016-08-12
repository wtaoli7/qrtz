package com.entstudy.info.platform.qrtz.mapper;

import java.util.List;
import java.util.Map;

import com.entstudy.info.platform.qrtz.model.GxhAttendenceInfo;

/**
 * @ClassName: AttendenceInfoMapper
 * @Description: 考勤信息表DAO
 * @author liwt
 * @date 2016年7月19日 下午4:36:33
 * 
 */
public interface GxhAttendenceInfoMapper {

	/**
	 * 
	 * @Description: 从V3数据库里查询当天所有排课信息包括有效和无效的
	 * @param onDate
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public List<GxhAttendenceInfo> queryWxGxhAttendInfoFromV3(String onDate)
			throws Exception;
	
	
	
	/**
	 * 
	 * @Description: 查询当天老师或者学生未签到的排课信息
	 * @param onDate
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public List<GxhAttendenceInfo> queryUnSignAttendedInfos(String onDate)
			throws Exception;

	/**
	 * 
	 * @Description: 查询当天已考勤，未做通知的排课信息
	 * @param onDate
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public List<GxhAttendenceInfo> queryAttendedUnNotifyInfos(String onDate)
			throws Exception;

	/**
	 * 
	 * @Description: 查询当天已经开始上课但是未考勤的排课信息
	 * @param currentTime
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public List<GxhAttendenceInfo> queryUnAttendedUnNotifyInfos(
			Map<String, String> params) throws Exception;

	/**
	 * 
	 * @Description: 查询老师未签到的排课信息
	 * @param teacherId
	 * @param signTime
	 *            刷卡时间
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public List<GxhAttendenceInfo> queryTeacherUnSignAttendenceInfo(
			Map<String, Object> paramter) throws Exception;

	/**
	 * 
	 * @Description: 查询学生未签到的排课信息
	 * @param signTime
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public List<GxhAttendenceInfo> queryStudentUnSignAttendenceInfo(
			Map<String, Object> paramter) throws Exception;

	/**
	 * 
	 * @Description: 新增或者更新排课信息
	 * @param info
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public void attendenceInfoSaveOrUpdate(GxhAttendenceInfo info)
			throws Exception;

	/**
	 * 
	 * @Description: 更新老师考勤状态
	 * @param fid
	 *            排课单据ID
	 * @param signType
	 *            签到方式：1-刷卡；2-补考勤
	 * @param signRecorId
	 *            签到记录ID
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public int updateAttendenceInfoTeStatus(GxhAttendenceInfo attentInfo)
			throws Exception;

	/**
	 * 
	 * @Description: 更新学生考勤状态
	 * @param fid
	 *            排课单据ID
	 * @param signType
	 *            签到方式：1-刷卡；2-补考勤
	 * @param signRecorId
	 *            签到记录ID
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public int updateAttendenceInfoStStatus(GxhAttendenceInfo attentInfo)
			throws Exception;

	/**
	 * 
	 * @Description: 更新学生家长短信通知状态
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public int updateAttendenceInfoParentNotify(GxhAttendenceInfo info)
			throws Exception;
	
	
	/**
	 * 
	 * @Description: 更新学管师通知状态
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public int updateAttendenceInfoManagerNotify(GxhAttendenceInfo info)
			throws Exception;

}
