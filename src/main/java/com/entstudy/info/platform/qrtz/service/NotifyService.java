package com.entstudy.info.platform.qrtz.service;

import com.entstudy.info.platform.qrtz.model.GxhAttendenceInfo;

/**
 * @ClassName: NotifyService
 * @Description: 考勤通知服务
 * @author liwt
 * @date 2016年7月23日 下午6:18:38
 * 
 */
public interface NotifyService {

	/**
	 * 
	 * @Description: 给学生家长发送已考勤通知
	 * @param mobile
	 *            手机号
	 * @param courseName
	 *            课程名称
	 * @param attendTime
	 *            考勤时间
	 * @return 设定文件
	 * @throws
	 */
	public boolean sendParentNotify(GxhAttendenceInfo info) throws Exception;


	/**
	 * 
	 * @Description: 给学管师未考勤通知
	 * @param managerId
	 * @param attendId
	 * @return 设定文件
	 * @throws
	 */
	public boolean sendManagerNoAttendNotify(GxhAttendenceInfo info)
			throws Exception;

}
