package com.entstudy.info.platform.qrtz.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entstudy.info.platform.qrtz.Application;

/**
 * @ClassName: NotifyConfigTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月23日 下午6:51:03
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class NotifyConfigTest {

	@Autowired
	private NotifyConfig service;

	@Test
	public void shortMessageCenterConfigTest() {
		try {
			String ddString = service.getShortMessageCenter();
			String ddString1 = service.getShortMessageContent();
			System.out.println(ddString1);
		} catch (Exception e) {

		}

	}

}
