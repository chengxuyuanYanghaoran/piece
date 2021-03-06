package com.hlwxy.xr_piece.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.DepartmentDO;
import com.hlwxy.xr_piece.system.domain.PeopleDO;
import com.hlwxy.xr_piece.system.dto.PeopleDTO;
import com.hlwxy.xr_piece.system.service.DepartmentService;
import com.hlwxy.xr_piece.system.service.PeopleService;
import com.hlwxy.xr_piece.utils.PageUtils;
import com.hlwxy.xr_piece.utils.Query;
import com.hlwxy.xr_piece.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:26
 */
 
@Controller
@RequestMapping("/system/people")
public class PeopleController {
	@Autowired
	private PeopleService peopleService;

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping()
	String People(){
	    return "system/people/people";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PeopleDTO> peopleList = peopleService.listAll(query);
		int total = peopleService.count(query);
		PageUtils pageUtils = new PageUtils(peopleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(Model model){
        List<DepartmentDO> departmentList = departmentService.list(null);
        model.addAttribute("departmentList",departmentList);
        return "system/people/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
        List<DepartmentDO> departmentList = departmentService.list(null);
        model.addAttribute("departmentList",departmentList);

		PeopleDO people = peopleService.get(id);
		model.addAttribute("people", people);
	    return "system/people/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(PeopleDO people){
		if(peopleService.save(people)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( PeopleDO people){
		peopleService.update(people);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		if(peopleService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] ids){
		peopleService.batchRemove(ids);
		return R.ok();
	}
	@ResponseBody
	@PostMapping("/validateByCard")
	public String validateByCard(PeopleDO peopleDO) {
		Map<String,Object> map=new HashMap<>(2);
		map.put("peopleCode",peopleDO.getPeopleCode());
		map.put("peopleName",peopleDO.getPeopleName());
		List<PeopleDO> list = peopleService.list(map);
		if(list.size()>0){
			return "false";
		}
		return "true";
	}
}
