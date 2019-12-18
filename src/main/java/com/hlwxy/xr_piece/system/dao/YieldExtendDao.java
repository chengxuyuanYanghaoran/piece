package com.hlwxy.xr_piece.system.dao;


import com.hlwxy.xr_piece.system.domain.YieldExtendDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author yang
 * @email 1992lcg@163.com
 * @date 2019-11-13 11:31:00
 */
@Mapper
public interface YieldExtendDao {

	List<Integer> list();
	YieldExtendDO get(Integer id);
	void add(@Param("yieldExtendDOS") List<YieldExtendDO> yieldExtendDOS);
	Integer getHeaderId(Integer id);
	void updateStats2(Integer id);
	List<Integer> findWagesId(@Param("code")String code);

}
