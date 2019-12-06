package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.YieldHeaderDao;
import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import com.hlwxy.xr_piece.system.service.YieldHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class YieldHeaderServiceImpl implements YieldHeaderService {
	@Autowired
	private YieldHeaderDao yieldHeaderDao;
	
	@Override
	public YieldHeaderDO get(Integer id){
		return yieldHeaderDao.get(id);
	}
	
	@Override
	public List<YieldHeaderDO> list(Map<String, Object> map){
		return yieldHeaderDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return yieldHeaderDao.count(map);
	}
	
	@Override
	public int save(YieldHeaderDO yieldHeader){
		return yieldHeaderDao.save(yieldHeader);
	}
	
	@Override
	public int update(YieldHeaderDO yieldHeader){
		return yieldHeaderDao.update(yieldHeader);
	}
	
	@Override
	public int remove(Integer id){
		return yieldHeaderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return yieldHeaderDao.batchRemove(ids);
	}

	@Override
	public List<YieldHeaderDO> findByUsername(YieldHeaderDO YieldHeaderDO) {
		return yieldHeaderDao.findByUsername(YieldHeaderDO);
	}


}
