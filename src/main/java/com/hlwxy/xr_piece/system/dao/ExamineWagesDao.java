package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.ExamineWagesDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-12-06 14:41:55
 */
@Mapper
public interface ExamineWagesDao {

	ExamineWagesDO get(Integer id);
	
	List<ExamineWagesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExamineWagesDO examineWages);
	
	int update(ExamineWagesDO examineWages);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	int removeById(Integer id);
}
