package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.ExamineYieDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-12-04 20:21:00
 */
@Mapper
public interface ExamineYieDao {

	ExamineYieDO get(Integer id);
	
	List<ExamineYieDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ExamineYieDO examineYie);
	
	int update(ExamineYieDO examineYie);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	int removeById(Integer id);
}
