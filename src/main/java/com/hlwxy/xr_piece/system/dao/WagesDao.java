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
	//产品
	List<WagesDO> list(Map<String, Object> map);
	//工序
	List<WagesDO> list2(Map<String, Object> map);
	//产品
	int count(Map<String, Object> map);
	//工序
	int count2(Map<String, Object> map);
	
	int save(WagesDO wages);
	
	int update(WagesDO wages);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
