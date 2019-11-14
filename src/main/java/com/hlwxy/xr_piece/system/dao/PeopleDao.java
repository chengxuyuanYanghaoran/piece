package com.hlwxy.xr_piece.system.dao;


import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.PeopleDO;
import com.hlwxy.xr_piece.system.dto.PeopleDTO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:26
 */
@Mapper
public interface PeopleDao {

	PeopleDO get(Integer id);
	
	List<PeopleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PeopleDO people);
	
	int update(PeopleDO people);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<PeopleDTO> listAll(Map<String, Object> map);
}
