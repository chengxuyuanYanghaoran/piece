package com.hlwxy.xr_piece.system.service.serviceimpl;

import com.hlwxy.xr_piece.system.dao.PeopleDao;
import com.hlwxy.xr_piece.system.domain.PeopleDO;
import com.hlwxy.xr_piece.system.dto.PeopleDTO;
import com.hlwxy.xr_piece.system.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;





@Service
public class PeopleServiceImpl implements PeopleService {
	@Autowired
	private PeopleDao peopleDao;
	
	@Override
	public PeopleDO get(Integer id){
		return peopleDao.get(id);
	}
	
	@Override
	public List<PeopleDO> list(Map<String, Object> map){
		return peopleDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return peopleDao.count(map);
	}
	
	@Override
	public int save(PeopleDO people){
		return peopleDao.save(people);
	}
	
	@Override
	public int update(PeopleDO people){
		return peopleDao.update(people);
	}
	
	@Override
	public int remove(Integer id){
		return peopleDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return peopleDao.batchRemove(ids);
	}

	@Override
	public List<PeopleDTO> listAll(Map<String, Object> map) {
		return peopleDao.listAll(map);
	}

}
