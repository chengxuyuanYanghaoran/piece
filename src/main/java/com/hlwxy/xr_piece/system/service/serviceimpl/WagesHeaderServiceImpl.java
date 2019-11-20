package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.WagesHeaderDao;
import com.hlwxy.xr_piece.system.domain.WagesHeaderDO;
import com.hlwxy.xr_piece.system.service.WagesHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class WagesHeaderServiceImpl implements WagesHeaderService {
	@Autowired
	private WagesHeaderDao wagesHeaderDao;
	
	@Override
	public WagesHeaderDO get(Integer id){
		return wagesHeaderDao.get(id);
	}
	
	@Override
	public List<WagesHeaderDO> list(Map<String, Object> map){
		return wagesHeaderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return wagesHeaderDao.count(map);
	}
	
	@Override
	public int save(WagesHeaderDO wagesHeader){
		return wagesHeaderDao.save(wagesHeader);
	}
	
	@Override
	public int update(WagesHeaderDO wagesHeader){
		return wagesHeaderDao.update(wagesHeader);
	}
	
	@Override
	public int remove(Integer id){
		return wagesHeaderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return wagesHeaderDao.batchRemove(ids);
	}
	
}
