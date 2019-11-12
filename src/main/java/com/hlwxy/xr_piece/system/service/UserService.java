package com.hlwxy.xr_piece.system.service;


import com.hlwxy.xr_piece.system.domain.UserDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:51
 */
public interface UserService {
	
	UserDO get(Integer id);
	
	List<UserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserDO user);
	
	int update(UserDO user);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	UserDO findByUsername(UserDO userDO);
}
