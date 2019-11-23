package com.hlwxy.xr_piece.system.service;


import com.hlwxy.xr_piece.system.domain.WagesDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:25:00
 */
public interface WagesService {
	
	WagesDO get(Integer id);

	List<WagesDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(WagesDO wages);
	
	int update(WagesDO wages);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
