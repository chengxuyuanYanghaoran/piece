package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.ProcedureDao;
import com.hlwxy.xr_piece.system.domain.ProcedureDO;
import com.hlwxy.xr_piece.system.service.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class ProcedureServiceImpl implements ProcedureService {
	@Autowired
	private ProcedureDao procedureDao;
	
	@Override
	public ProcedureDO get(Integer id){
		return procedureDao.get(id);
	}
	
	@Override
	public List<ProcedureDO> list(Map<String, Object> map){
		return procedureDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return procedureDao.count(map);
	}
	
	@Override
	public int save(ProcedureDO procedure){
		return procedureDao.save(procedure);
	}
	
	@Override
	public int update(ProcedureDO procedure){
		return procedureDao.update(procedure);
	}
	
	@Override
	public int remove(Integer id){
		return procedureDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return procedureDao.batchRemove(ids);
	}
	
}
