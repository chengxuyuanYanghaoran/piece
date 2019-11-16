package com.hlwxy.xr_piece.system.dao;


import com.hlwxy.xr_piece.system.domain.DepartmentDO;
import com.hlwxy.xr_piece.system.domain.PeopleDO;
import com.hlwxy.xr_piece.system.domain.ProcedureDO;
import com.hlwxy.xr_piece.system.domain.ProductDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:51
 */
@Mapper
public interface ReportSelectionDao {
	//查询部门
	List<DepartmentDO> findDepartmentName();
	//查询人员
	List<PeopleDO> findPeopleName();
	//查询工序
	List<ProcedureDO> findProcedureName();
	//查询产品
	List<ProductDO> findProductName();
}
