package com.entstudy.info.platform.qrtz.mapper;

import com.entstudy.info.platform.qrtz.model.V3StudentInfo;

/**
 * @ClassName: AttendenceInfoMapper
 * @Description: 考勤信息表DAO
 * @author liwt
 * @date 2016年7月19日 下午4:36:33
 * 
 */
public interface V3StudentInfoMapper {

	/**
	 * 
	 * @Description: 从V3数据库里查询学生信息
	 * @param onDate
	 * @return
	 * @throws Exception
	 *             设定文件
	 * @throws
	 */
	public V3StudentInfo queryV3StudentInfo(String fNumber)
			throws Exception;

}
