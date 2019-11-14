package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.YieldDao;
import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.service.YieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class YieldServiceImpl implements YieldService {
	@Autowired
	private YieldDao yieldDao;
	
	@Override
	public YieldDO get(Integer id){
		return yieldDao.get(id);
	}
	
	@Override
	public List<YieldDO> list(Map<String, Object> map){
		return yieldDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return yieldDao.count(map);
	}
	
	@Override
	public int save(YieldDO yield){
		return yieldDao.save(yield);
	}
	
	@Override
	public int update(YieldDO yield){
		return yieldDao.update(yield);
	}
	
	@Override
	public int remove(Integer id){
		return yieldDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return yieldDao.batchRemove(ids);
	}
	
}
