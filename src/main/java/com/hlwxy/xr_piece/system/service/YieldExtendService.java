package com.hlwxy.xr_piece.system.service;


import com.hlwxy.xr_piece.system.domain.YieldExtendDO;

import java.util.List;

/**
 * 
 * 
 * @author yang
 * @email 1992lcg@163.com
 * @date 2019-11-13 11:31:00
 */
public interface YieldExtendService {

	List<YieldExtendDO> list(String mode);
	YieldExtendDO get(int id,String mode);
	void getHeaderId(Integer[] ids);
	void add(List<YieldExtendDO> yieldExtendDOS);
	List<Integer> findWagesId(String code);
}
