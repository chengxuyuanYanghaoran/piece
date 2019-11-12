package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.DepartmentDao;
import com.hlwxy.xr_piece.system.domain.DepartmentDO;
import com.hlwxy.xr_piece.system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	
	@Override
	public DepartmentDO get(Integer id){
		return departmentDao.get(id);
	}
	
	@Override
	public List<DepartmentDO> list(Map<String, Object> map){
		return departmentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return departmentDao.count(map);
	}
	
	@Override
	public int save(DepartmentDO department){
		return departmentDao.save(department);
	}
	
	@Override
	public int update(DepartmentDO department){
		return departmentDao.update(department);
	}
	
	@Override
	public int remove(Integer id){
		return departmentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return departmentDao.batchRemove(ids);
	}
	
}
