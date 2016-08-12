package com.entstudy.info.platform.qrtz.model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: AttendenceInfo
 * @Description: 考勤信息表
 * @author liwt
 * @date 2016年7月19日 下午4:36:42
 * 
 */
public class GxhAttendenceInfo {

	private static final Logger logger = LoggerFactory
			.getLogger(GxhAttendenceInfo.class);

	// 考勤单据id
	private String fid;

	// 考勤单据编号
	private String fNumber;
	// 老师姓名
	private String teacherName;
	// 老师姓名
	private String teacherId;
	// 科目
	private String subjectName;
	// 课程名称
	private String courseName;

	// 上课日期
	private String onDate;
	// 上课时间
	private String startTime;
	// 下课时间
	private String endTime;
	// 课时
	private String useTime;
	// 科目ID
	private String subjectId;

	// 课程ID
	private String courseId;

	// 学生ID
	private String studentNo;
	// 学生姓名
	private String studentName;
	// 地区ID
	private String orgId;
	// 地区名称
	private String orgName;
	// 年级
	private String grade;
	// 学管师ID
	private String managerId;
	
	//学管师账号
	private String managerNo;
	
	// 学管师姓名
	private String managerName;

	// 课程状态 1-正常，0-无效
	private String status;
	
	private String tea_sign_flag;
	private String tea_sign_type;
	private long tea_sign_id;
	
	private String stu_sign_flag;
	private String stu_sign_type;
	private long stu_sign_id;
	
	private String p_notify;
	private String p_notice_time;
	
	private String manager_notify;
	private String manager_notify_time;
	
	private int count;
	
	
	private String startTimeHour;
	
	private String endTimeHour;
	
	
	
	/**
	 * @return the startTimeHour
	 */
	public String getStartTimeHour() {
		return startTimeHour;
	}

	/**
	 * @param startTimeHour the startTimeHour to set
	 */
	public void setStartTimeHour(String startTimeHour) {
		this.startTimeHour = startTimeHour;
	}

	/**
	 * @return the endTimeHour
	 */
	public String getEndTimeHour() {
		return endTimeHour;
	}

	/**
	 * @param endTimeHour the endTimeHour to set
	 */
	public void setEndTimeHour(String endTimeHour) {
		this.endTimeHour = endTimeHour;
	}

	/**
	 * @return the managerNo
	 */
	public String getManagerNo() {
		return managerNo;
	}

	/**
	 * @param managerNo the managerNo to set
	 */
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}

	/**
	 * @return the tea_sign_flag
	 */
	public String getTea_sign_flag() {
		return tea_sign_flag;
	}

	/**
	 * @param tea_sign_flag the tea_sign_flag to set
	 */
	public void setTea_sign_flag(String tea_sign_flag) {
		this.tea_sign_flag = tea_sign_flag;
	}

	/**
	 * @return the tea_sign_type
	 */
	public String getTea_sign_type() {
		return tea_sign_type;
	}

	/**
	 * @param tea_sign_type the tea_sign_type to set
	 */
	public void setTea_sign_type(String tea_sign_type) {
		this.tea_sign_type = tea_sign_type;
	}

	/**
	 * @return the tea_sign_id
	 */
	public long getTea_sign_id() {
		return tea_sign_id;
	}

	/**
	 * @param tea_sign_id the tea_sign_id to set
	 */
	public void setTea_sign_id(long tea_sign_id) {
		this.tea_sign_id = tea_sign_id;
	}

	/**
	 * @return the stu_sign_flag
	 */
	public String getStu_sign_flag() {
		return stu_sign_flag;
	}

	/**
	 * @param stu_sign_flag the stu_sign_flag to set
	 */
	public void setStu_sign_flag(String stu_sign_flag) {
		this.stu_sign_flag = stu_sign_flag;
	}

	/**
	 * @return the stu_sign_type
	 */
	public String getStu_sign_type() {
		return stu_sign_type;
	}

	/**
	 * @param stu_sign_type the stu_sign_type to set
	 */
	public void setStu_sign_type(String stu_sign_type) {
		this.stu_sign_type = stu_sign_type;
	}

	/**
	 * @return the stu_sign_id
	 */
	public long getStu_sign_id() {
		return stu_sign_id;
	}

	/**
	 * @param stu_sign_id the stu_sign_id to set
	 */
	public void setStu_sign_id(long stu_sign_id) {
		this.stu_sign_id = stu_sign_id;
	}

	/**
	 * @return the p_notify
	 */
	public String getP_notify() {
		return p_notify;
	}

	/**
	 * @param p_notify the p_notify to set
	 */
	public void setP_notify(String p_notify) {
		this.p_notify = p_notify;
	}

	/**
	 * @return the p_notice_time
	 */
	public String getP_notice_time() {
		return p_notice_time;
	}

	/**
	 * @param p_notice_time the p_notice_time to set
	 */
	public void setP_notice_time(String p_notice_time) {
		this.p_notice_time = p_notice_time;
	}

	/**
	 * @return the manager_notify
	 */
	public String getManager_notify() {
		return manager_notify;
	}

	/**
	 * @param manager_notify the manager_notify to set
	 */
	public void setManager_notify(String manager_notify) {
		this.manager_notify = manager_notify;
	}

	/**
	 * @return the manager_notify_time
	 */
	public String getManager_notify_time() {
		return manager_notify_time;
	}

	/**
	 * @param manager_notify_time the manager_notify_time to set
	 */
	public void setManager_notify_time(String manager_notify_time) {
		this.manager_notify_time = manager_notify_time;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the fid
	 */
	public String getFid() {
		return fid;
	}

	/**
	 * @param fid
	 *            the fid to set
	 */
	public void setFid(String fid) {
		this.fid = fid;
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
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName
	 *            the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the onDate
	 */
	public String getOnDate() {
		return onDate;
	}

	/**
	 * @param onDate
	 *            the onDate to set
	 */
	public void setOnDate(String onDate) {
		this.onDate = onDate;
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
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the useTime
	 */
	public String getUseTime() {
		return useTime;
	}

	/**
	 * @param useTime
	 *            the useTime to set
	 */
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}

	/**
	 * @return the subjectId
	 */
	public String getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId
	 *            the subjectId to set
	 */
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName
	 *            the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId
	 *            the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the teacherId
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId
	 *            the teacherId to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return the studentNo
	 */
	public String getStudentNo() {
		return studentNo;
	}

	/**
	 * @param studentNo
	 *            the studentNo to set
	 */
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName
	 *            the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the managerId
	 */
	public String getManagerId() {
		return managerId;
	}

	/**
	 * @param managerId
	 *            the managerId to set
	 */
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}

	/**
	 * @param managerName
	 *            the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String parseStartTime() {
		String sDate = null;
		try {
			Date attDate = DateUtils.parseDate(this.onDate,
					"yyyy-MM-dd HH:mm:ss");
			Date attStartTime = DateUtils.parseDate(this.startTime,
					"yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(attStartTime);
			attDate = DateUtils.setHours(attDate, calendar.get(Calendar.HOUR_OF_DAY));
			sDate = DateFormatUtils.format(attDate, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			logger.error("ParseException:", e);
		}
		return sDate;
	}
	
	public String parseEndTime() {
		String sDate = null;
		try {
			Date attDate = DateUtils.parseDate(this.onDate,
					"yyyy-MM-dd HH:mm:ss");
			Date attEndTime = DateUtils.parseDate(this.endTime,
					"yyyy-MM-dd HH:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(attEndTime);
			attDate = DateUtils.setHours(attDate, calendar.get(Calendar.HOUR_OF_DAY));
			sDate = DateFormatUtils.format(attDate, "yyyy-MM-dd HH:mm:ss");
		} catch (ParseException e) {
			logger.error("ParseException:", e);
		}
		return sDate;
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
