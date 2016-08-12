package com.entstudy.info.platform.qrtz.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: SignRecord
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author liwt
 * @date 2016年7月22日 下午7:17:17
 * 
 */
public final class SignRecord {

	private long id;
	// 签到时间
	private String signTime;
	// 老师ID或者学生编号
	private String fNumber;
	// 老师或者学生 te or st
	private String roleType;
	// 处理状态 0-未处理 1-已处理，并且找到对应的排课；2-已处理，未找到排课信息
	private String handleStatus;
	// 处理时间
	private String handleTime;
	// 处理信息
	private String handleMsg;

	public enum HandleStatus {
		NO("未处理", 0), YES("已处理", 1), CONTINUE("未处理", 2);
		// 成员变量
		private String name;
		private int flag;
		

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the flag
		 */
		public int getFlag() {
			return flag;
		}

		// 覆盖方法
		@Override
		public String toString() {
			return this.name + "_" + this.flag;
		}

		// 构造方法
		private HandleStatus(String name, int index) {
			this.name = name;
			this.flag = index;
		}
	}
	

	/**
	 * @return the handleMsg
	 */
	public String getHandleMsg() {
		return handleMsg;
	}

	/**
	 * @param handleMsg
	 *            the handleMsg to set
	 */
	public void setHandleMsg(String handleMsg) {
		this.handleMsg = handleMsg;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the signTime
	 */
	public String getSignTime() {
		return signTime;
	}

	/**
	 * @param signTime
	 *            the signTime to set
	 */
	public void setSignTime(String signTime) {
		this.signTime = signTime;
	}

	/**
	 * @return the fNumber
	 */
	public String getfNumber() {
		return fNumber;
	}

	/**
	 * @param fNumber
	 *            the fNumber to set
	 */
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	/**
	 * @return the roleType
	 */
	public String getRoleType() {
		return roleType;
	}

	/**
	 * @param roleType
	 *            the roleType to set
	 */
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	/**
	 * @return the handleStatus
	 */
	public String getHandleStatus() {
		return handleStatus;
	}

	/**
	 * @param handleStatus
	 *            the handleStatus to set
	 */
	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	/**
	 * @return the handleTime
	 */
	public String getHandleTime() {
		return handleTime;
	}

	/**
	 * @param handleTime
	 *            the handleTime to set
	 */
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
