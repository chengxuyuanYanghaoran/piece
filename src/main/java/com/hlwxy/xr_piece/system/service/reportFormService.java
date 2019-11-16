package com.hlwxy.xr_piece.system.service;


import com.hlwxy.xr_piece.system.domain.*;

import java.util.List;
import java.util.Map;

/**
 * 报表模块业务逻辑
 */
public interface reportFormService {
	//工资明细表
	List<WagesDO> findDetailed(ConditionDo conditionDo);
	Integer countDetailed(ConditionDo conditionDo);
	//工资统计
	List<ReturnDO> findStatistics(ConditionDo conditionDo);
	//工资统计总条数
	List<ReturnDO> countFindStatistics(ConditionDo conditionDo);
	//工资统计表
	List<ReturnDO> findStatisticsTable(ConditionDo conditionDo);
	//工资统计表总条数
	List<ReturnDO> countStatisticsTable(ConditionDo conditionDo);
}
