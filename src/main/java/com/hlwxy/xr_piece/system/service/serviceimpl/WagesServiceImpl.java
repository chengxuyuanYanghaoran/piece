package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.WagesDao;
import com.hlwxy.xr_piece.system.domain.WagesDO;
import com.hlwxy.xr_piece.system.service.WagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class WagesServiceImpl implements WagesService {
	@Autowired
	private WagesDao wagesDao;
	
	@Override
	public WagesDO get(Integer id){
		return wagesDao.get(id);
	}
	
	@Override
	public List<WagesDO> list(Map<String, Object> map){
		return wagesDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wagesDao.count(map);
	}
	
	@Override
	public int save(WagesDO wages){
		return wagesDao.save(wages);
	}
	
	@Override
	public int update(WagesDO wages){
		return wagesDao.update(wages);
	}
	
	@Override
	public int remove(Integer id){
		return wagesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wagesDao.batchRemove(ids);
	}
	
}
