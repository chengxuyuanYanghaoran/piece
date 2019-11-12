package com.hlwxy.xr_piece.system.service;


import com.hlwxy.xr_piece.system.domain.DepartmentDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:05
 */
public interface DepartmentService {
	
	DepartmentDO get(Integer id);
	
	List<DepartmentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(DepartmentDO department);
	
	int update(DepartmentDO department);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
