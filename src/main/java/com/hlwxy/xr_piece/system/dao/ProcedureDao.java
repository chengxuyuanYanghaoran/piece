package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.ProcedureDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:41
 */
@Mapper
public interface ProcedureDao {

	ProcedureDO get(Integer id);
	
	List<ProcedureDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ProcedureDO procedure);
	
	int update(ProcedureDO procedure);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
