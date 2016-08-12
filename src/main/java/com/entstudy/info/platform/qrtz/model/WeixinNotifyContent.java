package com.entstudy.info.platform.qrtz.model;

/**
 * @ClassName: WeixinNotifyContent
 * @Description: 微信通知内容
 * @author liwt
 * @date 2016年7月26日 下午2:11:22
 * 
 */
public class WeixinNotifyContent {

	private String student = "";
	private String teacher = "";
	private String subject = "";
	private String startTime = "";
	//排课单据尾数
	private String fnumberFoot = "";

	private WeixinNotifyContent(Builder b) {
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
        public WeixinNotifyContent build(){  
            return new WeixinNotifyContent(this);  
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
		sb.append("学生：").append(this.student);
		sb.append("\n");
		sb.append("老师：").append(this.teacher);
		sb.append("\n");
		sb.append("科目：").append(this.subject);
		sb.append("\n");
		sb.append("上课时间：").append(this.startTime);
		sb.append("\n");
		sb.append("排课单据编号尾数：").append(this.fnumberFoot);
		return sb.toString();
	}

}
