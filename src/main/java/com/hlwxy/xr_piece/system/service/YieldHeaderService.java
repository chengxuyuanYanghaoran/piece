package com.hlwxy.xr_piece.system.service;


import com.hlwxy.xr_piece.system.domain.PeopleDO;
import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-19 09:49:10
 */
public interface YieldHeaderService {
	
	YieldHeaderDO get(Integer id);
	
	List<YieldHeaderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(YieldHeaderDO yieldHeader);
	
	int update(YieldHeaderDO YieldHeaderDO);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<YieldHeaderDO> findByUsername(YieldHeaderDO YieldHeaderDO);
}
