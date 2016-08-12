package com.entstudy.info.platform.qrtz.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entstudy.info.platform.qrtz.Application;
import com.entstudy.info.platform.qrtz.service.GxhAttendenceInfoService;

/**
 * @ClassName: AttendenceInfoServiceImplTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月23日 下午4:04:33
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public final class AttendenceInfoServiceImplTest {

	@Autowired
	private GxhAttendenceInfoService service;

	@Test
	public void syncAttendenceInfoTest() {
		try {
			service.syncAttendenceInfo();
		} catch (Exception e) {

		}
	}

	@Test
	public void handleUnSignAttendenceInfoTest() {
		try {
			service.handleUnSignAttendenceInfo();
		} catch (Exception e) {

		}
	}

	@Test
	public void sendParentNotifyTest() {
		try {
			service.sendParentNotify();
		} catch (Exception e) {

		}
	}

	@Test
	public void sendManagerNotifyTest() {
		try {
			service.sendManagerNotify();
		} catch (Exception e) {

		}
	}

}
