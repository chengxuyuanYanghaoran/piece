package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.WagesDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:25:00
 */
@Mapper
public interface WagesDao {

	WagesDO get(Integer id);
	
	List<WagesDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WagesDO wages);
	
	int update(WagesDO wages);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
