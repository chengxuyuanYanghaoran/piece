package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.WagesHeaderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-19 10:26:57
 */
@Mapper
public interface WagesHeaderDao {

	WagesHeaderDO get(Integer id);
	
	List<WagesHeaderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WagesHeaderDO wagesHeader);
	
	int update(WagesHeaderDO wagesHeader);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
