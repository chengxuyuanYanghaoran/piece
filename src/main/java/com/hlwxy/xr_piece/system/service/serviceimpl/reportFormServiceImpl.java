package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.reportFormDao;
import com.hlwxy.xr_piece.system.domain.ConditionDo;
import com.hlwxy.xr_piece.system.domain.ReturnDO;
import com.hlwxy.xr_piece.system.domain.WagesDO;
import com.hlwxy.xr_piece.system.domain.WagesExtendDO;
import com.hlwxy.xr_piece.system.service.reportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;


@Service
public class reportFormServiceImpl implements reportFormService {

	@Autowired
	private reportFormDao reportFormDao;

	//工资明细表
	@Override
	public List<WagesDO> findDetailed(ConditionDo conditionDo) {
		return reportFormDao.findDetailed(conditionDo);
	}

	@Override
	public Integer countDetailed(ConditionDo conditionDo) {
		return reportFormDao.countDetailed(conditionDo);
	}

	//工资统计
	@Override
	public List<ReturnDO> findStatistics(ConditionDo conditionDo) {
		conditionDo.setComDataOn(null);
		conditionDo.setComDataOff(null);
		List<ReturnDO> list = reportFormDao.findStatistics(conditionDo);

		return list;
	}

	@Override
	public List<ReturnDO> countFindStatistics(ConditionDo conditionDo) {
		conditionDo.setComDataOn(null);
		conditionDo.setComDataOff(null);
		return reportFormDao.countFindStatistics(conditionDo);
	}

	@Override
	public List<ReturnDO> findStatisticsTable(ConditionDo conditionDo) {
		return reportFormDao.findStatisticsTable(conditionDo);
	}

	@Override
	public List<ReturnDO> countStatisticsTable(ConditionDo conditionDo) {
		return reportFormDao.countStatisticsTable(conditionDo);
	}


}
