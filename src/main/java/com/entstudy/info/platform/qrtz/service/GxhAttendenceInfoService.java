package com.entstudy.info.platform.qrtz.service;


/**
 * @ClassName: AttentenceInfoService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月19日 下午7:55:44
 * 
 */
public interface GxhAttendenceInfoService {

	/**
	 * 
	 * @Description: 排课信息转存到考勤表
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public int syncAttendenceInfo() throws Exception;
	
	
	/**
	 * 
	* @Description: 排课信息处理
	* @throws Exception    设定文件  
	* @throws
	 */
	public int handleUnSignAttendenceInfo() throws Exception;
	
	
	/**
	 * 
	* @Description: 给家长发送已考勤通知
	* @return
	* @throws Exception    设定文件  
	* @throws
	 */
	public int sendParentNotify()throws Exception;
	
	/**
	 * 
	* @Description: 给学管师发送未考勤通知
	* @return
	* @throws Exception    设定文件  
	* @throws
	 */
	public int sendManagerNotify()throws Exception;


}
