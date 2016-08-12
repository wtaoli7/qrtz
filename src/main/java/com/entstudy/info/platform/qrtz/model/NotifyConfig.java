package com.entstudy.info.platform.qrtz.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * @ClassName: NotifyConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月23日 下午6:49:06
 * 
 */
@Component
@ConfigurationProperties(prefix = "notify", locations = "classpath:config/notifyConfig.properties")
public class NotifyConfig {

	private String shortMessageCenter;

	private String shortMessageContent;

	/**
	 * @return the shortMessageCenter
	 */
	public String getShortMessageCenter() {
		return shortMessageCenter;
	}

	/**
	 * @param shortMessageCenter
	 *            the shortMessageCenter to set
	 */
	public void setShortMessageCenter(String shortMessageCenter) {
		this.shortMessageCenter = shortMessageCenter;
	}

	/**
	 * @return the shortMessageContent
	 */
	public String getShortMessageContent() {
		return shortMessageContent;
	}

	/**
	 * @param shortMessageContent
	 *            the shortMessageContent to set
	 */
	public void setShortMessageContent(String shortMessageContent) {
		this.shortMessageContent = shortMessageContent;
	}

}
