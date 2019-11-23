package com.hlwxy.xr_piece.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.DepartmentDO;
import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.service.DepartmentService;
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
 * @date 2019-11-11 17:24:05
 */
 
@Controller
@RequestMapping("/system/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping()
	String Department(){
	    return "system/department/department";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<DepartmentDO> departmentList = departmentService.list(query);
		int total = departmentService.count(query);
		PageUtils pageUtils = new PageUtils(departmentList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "system/department/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		DepartmentDO department = departmentService.get(id);
		model.addAttribute("department", department);
	    return "system/department/edit";
	}


	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(DepartmentDO department){
		if(departmentService.save(department)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( DepartmentDO department){
		departmentService.update(department);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		if(departmentService.remove(id)>0){
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
		departmentService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/validateByCard")
	public String validateByCard(DepartmentDO departmentDO) {
		Map<String,Object> map=new HashMap<>(1);
		map.put("bmCode",departmentDO.getBmCode());
		List<DepartmentDO> list = departmentService.list(map);
		if(list.size()>0){
			return "false";
		}
		return "true";
	}
	
}
