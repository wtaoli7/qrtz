package com.entstudy.info.platform.qrtz.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.entstudy.info.platform.qrtz.service.GxhAttendenceInfoService;

/**
 * @ClassName: ScheduledTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月19日 上午9:56:29
 * 
 */

@Component
public class AutoAttendenceSchedule {

	private static final Logger logger = LoggerFactory
			.getLogger(AutoAttendenceSchedule.class);

	@Autowired
	private GxhAttendenceInfoService attendenceInfoService;

	/**
	 * 
	 * @Description: 排课信息同步任务 凌晨2点，中午12 点；晚上11点 各跑一次
	 * @throws
	 */
//	@Scheduled(cron = "0 0 2,12,23 * * ?")
//	@Scheduled(cron = "0/30 * * * * ?")
	@Scheduled(cron = "${spring.job.synctask.cron}")
	public void syncAttendenceInfoTask() {
		logger.info("syncAttendenceInfoTask start....");
		try {
			attendenceInfoService.syncAttendenceInfo();
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
	}

	/**
	 * 每个整点的05分 跑一次 签到信息处理 根据老师ID或者学生编号，找对应的排课信息
	 * 
	 */
	@Scheduled(cron = "${spring.job.recordhandletask.cron}")
	public void signRecordHandleTask() {
		logger.info("signRecordHandlerTask start....");
		try {
			attendenceInfoService.handleUnSignAttendenceInfo();
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
	}

	/**
	 * 每个整点20分，已完成考勤的排课信息，给家长发送短信通知；已开始上课，未考勤的排课信息，给学管师发送微信通知
	 * 
	 */
	@Scheduled(cron = "${spring.job.notifytask.cron}")
	public void sendNotifyTask() {
		logger.info("sendNotifyTask start....");
		try {
			attendenceInfoService.sendParentNotify();
			attendenceInfoService.sendManagerNotify();
		} catch (Exception e) {
			logger.error("Exception:", e);
		}
	}

}
