package com.entstudy.info.platform.qrtz.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: WeixinCpConfig
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月25日 下午5:04:40
 * 
 */
@Component
@ConfigurationProperties(prefix = "weixinQy", locations = "classpath:config/weixinQyConfig.properties")
public class WeixinQyConfig {

	private String agentId;

	private String corpSecret;

	private String token;

	private String aesKey;
	
	private String corpId;

	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the corpSecret
	 */
	public String getCorpSecret() {
		return corpSecret;
	}

	/**
	 * @param corpSecret the corpSecret to set
	 */
	public void setCorpSecret(String corpSecret) {
		this.corpSecret = corpSecret;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the aesKey
	 */
	public String getAesKey() {
		return aesKey;
	}

	/**
	 * @param aesKey the aesKey to set
	 */
	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

	/**
	 * @return the corpId
	 */
	public String getCorpId() {
		return corpId;
	}

	/**
	 * @param corpId the corpId to set
	 */
	public void setCorpId(String corpId) {
		this.corpId = corpId;
	}

}
