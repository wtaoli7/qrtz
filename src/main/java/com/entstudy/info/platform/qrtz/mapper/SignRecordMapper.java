package com.entstudy.info.platform.qrtz.mapper;

import java.util.List;
import java.util.Map;

import com.entstudy.info.platform.qrtz.model.SignRecord;

/**
 * @ClassName: SignRecordMapper
 * @Description: 签到信息Dao
 * @author liwt
 * @date 2016年7月19日 下午4:36:33
 * 
 */
public interface SignRecordMapper {



	/**
	 * 
	* @Description: 查询老师的签到信息 
	* @param params
	* @return
	* @throws Exception    设定文件  
	* @throws
	 */
	public List<SignRecord> queryTeacherSignRecord(Map<String, Object> params)
			throws Exception;
	
	/**
	 * 
	* @Description: 查询学生的签到信息 
	* @param params
	* @return
	* @throws Exception    设定文件  
	* @throws
	 */
	public List<SignRecord> queryStudentSignRecord(Map<String, Object> params)
			throws Exception;

}
