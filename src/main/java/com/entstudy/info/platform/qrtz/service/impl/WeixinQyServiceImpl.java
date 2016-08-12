package com.entstudy.info.platform.qrtz.service.impl;

import javax.annotation.PostConstruct;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.cp.api.WxCpInMemoryConfigStorage;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpServiceImpl;
import me.chanjar.weixin.cp.bean.WxCpMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entstudy.info.platform.qrtz.model.WeixinNotifyContent;
import com.entstudy.info.platform.qrtz.model.WeixinQyConfig;
import com.entstudy.info.platform.qrtz.service.WeixinQyService;

/**
 * @ClassName: WeixinQyServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月26日 上午9:59:02
 * 
 */
@Service
public class WeixinQyServiceImpl implements WeixinQyService {

	private static final Logger logger = LoggerFactory
			.getLogger(WeixinQyServiceImpl.class);

	private static WxCpService wxCpService = null;

	@Autowired
	private WeixinQyConfig wxConfig;

	public WeixinQyServiceImpl() {

	}

	@PostConstruct
	public void init() {
		logger.info("WeixinQyServiceImpl init");
		WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
		config.setCorpId(wxConfig.getCorpId()); // 设置微信企业号的appid
		config.setCorpSecret(wxConfig.getCorpSecret()); // 设置微信企业号的app
														// corpSecret
		config.setAgentId(wxConfig.getAgentId()); // 设置微信企业号应用ID
		config.setToken(wxConfig.getToken()); // 设置微信企业号应用的token
		config.setAesKey(wxConfig.getAesKey()); // 设置微信企业号应用的EncodingAESKey
		wxCpService = new WxCpServiceImpl();
		wxCpService.setWxCpConfigStorage(config);
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public void syncDepartmentInfo() throws Exception {
		if (wxCpService == null) {
			init();
		}
		
		
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public void syncUserList(Integer departId, Boolean fetchChild,
			Integer status) throws Exception {
		if (wxCpService == null) {
			init();
		}

	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public void sendNotify(String userId, WeixinNotifyContent content)
			throws Exception {
		WxCpMessage message = new WxCpMessage();
		message.setAgentId(wxConfig.getAgentId());
		message.setMsgType(WxConsts.CUSTOM_MSG_TEXT);
		message.setContent(content.content());
		message.setToUser(userId);
		wxCpService.messageSend(message);
	}

}
