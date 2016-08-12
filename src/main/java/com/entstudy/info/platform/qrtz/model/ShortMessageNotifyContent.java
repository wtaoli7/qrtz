package com.entstudy.info.platform.qrtz.model;

/**
 * @ClassName: ShortMessageNotifyContent
 * @Description: 短信通知内容
 * @author liwt
 * @date 2016年7月26日 下午2:11:22
 * 
 */
public class ShortMessageNotifyContent {

	private String student = "";
	private String teacher = "";
	private String subject = "";
	private String startTime = "";
	private String fnumberFoot = "";

	private ShortMessageNotifyContent(Builder b) {
		student = b.student;
		teacher = b.teacher;
		subject = b.subject;
		startTime = b.startTime;
		fnumberFoot = b.fnumberFoot;
	}

	public static class Builder {
		private String student;
		private String teacher;
		private String subject;
		private String startTime;
		private String fnumberFoot;

		public Builder() {

		}
		
		//构造器入口  
        public ShortMessageNotifyContent build(){  
            return new ShortMessageNotifyContent(this);  
        }  

		public Builder student(String student) {
			this.student = student;
			return this;
		}

		public Builder teacher(String teacher) {
			this.teacher = teacher;
			return this;
		}

		public Builder subject(String subject) {
			this.subject = subject;
			return this;
		}

		public Builder startTime(String startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder fnumberFoot(String fnumberFoot) {
			this.fnumberFoot = fnumberFoot;
			return this;
		}

	}

	public String content() {
		// message.setContent("未考勤通知：\n学生:王一涵 \n老师:王洁然 \n科目:化学\n上课时间:10:00 "
		// + "\n排课单据编号尾数:36631");
		StringBuffer sb = new StringBuffer("未考勤通知：");
		sb.append("\n");
		sb.append("学生:").append(this.student);
		sb.append("\n");
		sb.append("老师:").append(this.teacher);
		sb.append("\n");
		sb.append("科目:").append(this.subject);
		sb.append("\n");
		sb.append("上课时间:").append(this.startTime);
		sb.append("\n");
		sb.append("排课单据编号尾数:").append(this.fnumberFoot);
		return sb.toString();
	}

	/**
	 * @return the student
	 */
	public String getStudent() {
		return student;
	}

	/**
	 * @param student
	 *            the student to set
	 */
	public void setStudent(String student) {
		this.student = student;
	}

	/**
	 * @return the teacher
	 */
	public String getTeacher() {
		return teacher;
	}

	/**
	 * @param teacher
	 *            the teacher to set
	 */
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the fnumberFoot
	 */
	public String getFnumberFoot() {
		return fnumberFoot;
	}

	/**
	 * @param fnumberFoot
	 *            the fnumberFoot to set
	 */
	public void setFnumberFoot(String fnumberFoot) {
		this.fnumberFoot = fnumberFoot;
	}

}
