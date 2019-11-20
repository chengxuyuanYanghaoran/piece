package com.hlwxy.xr_piece.system.service;


import com.hlwxy.xr_piece.system.domain.YieldDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-13 11:31:00
 */
public interface YieldService {
	
	YieldDO get(Integer id);
	
	List<YieldDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(YieldDO yield);
	
	int update(YieldDO yield);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);



}
