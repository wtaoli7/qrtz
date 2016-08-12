package com.entstudy.info.platform.qrtz.model;

/** 
 * @ClassName: V3StudentInfo 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liwt
 * @date 2016年7月24日 下午4:54:43 
 *  
 */
public class V3StudentInfo {
	
	//学生ID
	private String fid;
	
	//学生编码
	private String fnumber;
	
	//学生姓名
	private String cfstudentname;
	
	//地址
	private String cfaddress;
	
	// 0-男生；1-女生
	private String cfgender;
	
	//联系方式，一般是手机号
	private String cfcontactinfo;

	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
	}

	/**
	 * @return the fnumber
	 */
	public String getFnumber() {
		return fnumber;
	}

	/**
	 * @param fnumber the fnumber to set
	 */
	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	/**
	 * @return the cfstudentname
	 */
	public String getCfstudentname() {
		return cfstudentname;
	}

	/**
	 * @param cfstudentname the cfstudentname to set
	 */
	public void setCfstudentname(String cfstudentname) {
		this.cfstudentname = cfstudentname;
	}

	/**
	 * @return the cfaddress
	 */
	public String getCfaddress() {
		return cfaddress;
	}

	/**
	 * @param cfaddress the cfaddress to set
	 */
	public void setCfaddress(String cfaddress) {
		this.cfaddress = cfaddress;
	}

	/**
	 * @return the cfgender
	 */
	public String getCfgender() {
		return cfgender;
	}

	/**
	 * @param cfgender the cfgender to set
	 */
	public void setCfgender(String cfgender) {
		this.cfgender = cfgender;
	}

	/**
	 * @return the cfcontactinfo
	 */
	public String getCfcontactinfo() {
		return cfcontactinfo;
	}

	/**
	 * @param cfcontactinfo the cfcontactinfo to set
	 */
	public void setCfcontactinfo(String cfcontactinfo) {
		this.cfcontactinfo = cfcontactinfo;
	}

}
