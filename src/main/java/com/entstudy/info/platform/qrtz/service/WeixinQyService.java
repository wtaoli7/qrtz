package com.entstudy.info.platform.qrtz.service;

import com.entstudy.info.platform.qrtz.model.WeixinNotifyContent;

/**
 * @ClassName: WeixinQyDepartmentService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月25日 下午5:36:34
 * 
 */
public interface WeixinQyService {

	/**
	 * 
	 * @Description: 同步部门信息
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public void syncDepartmentInfo() throws Exception;

	/**
	 * 
	 * @Description: 同步部门成员信息
	 * @param departId
	 *            部门ID
	 * @param fetchChild
	 *            1/0：是否递归获取子部门下面的成员
	 * @param status
	 *            0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加，未填写则默认为4
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public void syncUserList(Integer departId, Boolean fetchChild,
			Integer status) throws Exception;

	
	/**
	 * 
	* @Description: 发送微信通知
	* @param userId
	* @param content
	* @throws Exception    设定文件  
	* @throws
	 */
	public void sendNotify(String userId, WeixinNotifyContent content) throws Exception;
}
