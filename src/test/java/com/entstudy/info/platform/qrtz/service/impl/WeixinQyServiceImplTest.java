package com.entstudy.info.platform.qrtz.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entstudy.info.platform.qrtz.Application;
import com.entstudy.info.platform.qrtz.model.WeixinNotifyContent;
import com.entstudy.info.platform.qrtz.service.WeixinQyService;

/**
 * @ClassName: AttendenceInfoServiceImplTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月23日 下午4:04:33
 * 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public final class WeixinQyServiceImplTest {

	@Autowired
	private WeixinQyService service;

	@Test
	public void sendNotifyTest() {
		try {
			String user = "lwt";
			WeixinNotifyContent content1 = new WeixinNotifyContent.Builder()
					.student("王一涵").teacher("王洁然").subject("化学")
					.startTime("10:00").fnumberFoot("36631").build();
			service.sendNotify(user, content1);
		} catch (Exception e) {
			
		}

	}

}
