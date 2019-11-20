package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-19 09:49:10
 */
@Mapper
public interface YieldHeaderDao {

	YieldHeaderDO get(Integer id);
	
	List<YieldHeaderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(YieldHeaderDO yieldHeader);
	
	int update(YieldHeaderDO yieldHeader);
	
	int remove(Integer id);

	int batchRemove(Integer[] ids);
}
