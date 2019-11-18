package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.YieldDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-13 11:31:00
 */
@Mapper
public interface YieldDao {

	YieldDO get(Integer id);
	
	List<YieldDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(YieldDO yield);
	
	int update(YieldDO yield);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}