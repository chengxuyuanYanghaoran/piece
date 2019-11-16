package com.hlwxy.xr_piece.system.dao;

import com.hlwxy.xr_piece.system.domain.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 报表模块DAO
 */
@Mapper
public interface reportFormDao {
	//工资明细
	List<WagesDO> findDetailed(ConditionDo conditionDo);
	Integer countDetailed(ConditionDo conditionDo);
	//工资统计 count
	List<ReturnDO> findStatistics(ConditionDo conditionDo);
	//工资统计总条数
	List<ReturnDO> countFindStatistics(ConditionDo conditionDo);
	//工资统计表
	List<ReturnDO> findStatisticsTable(ConditionDo conditionDo);
	//工资统计表总条数
	List<ReturnDO> countStatisticsTable(ConditionDo conditionDo);
}
