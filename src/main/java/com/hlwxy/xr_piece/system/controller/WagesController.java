package com.hlwxy.xr_piece.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.WagesDO;
import com.hlwxy.xr_piece.system.domain.WagesHeaderDO;
import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.service.WagesService;
import com.hlwxy.xr_piece.utils.PageUtils;
import com.hlwxy.xr_piece.utils.Query;
import com.hlwxy.xr_piece.utils.R;
import org.apache.ibatis.annotations.Param;
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
 * @date 2019-11-11 17:25:00
 */
 
@Controller
@RequestMapping("/system/wages")
public class WagesController {
	@Autowired
	private WagesService wagesService;
	
	@GetMapping()
	String Wages(){
	    return "system/wages/wages";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WagesDO> wagesList = wagesService.list(query);
		int total = wagesService.count(query);
		PageUtils pageUtils = new PageUtils(wagesList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "system/wages/add";
	}

	@GetMapping("/add1")
	String add1(){
		return "system/wages/add1";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		WagesDO wages = wagesService.get(id);
		model.addAttribute("wages", wages);
	    return "system/wages/edit";
	}

	@GetMapping("/edit1/{id}")
	String edit1(@PathVariable("id") Integer id,Model model){
		WagesDO wages = wagesService.get(id);
		model.addAttribute("wages",wages);
		return "system/wages/edit1";
	}
	
	/**s
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(WagesDO wages){
		if(wagesService.save(wages)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 判断
	 */
	@GetMapping("/toPage/{id}")
	public String  toPage(@PathVariable("id") Integer id,Model model){
		model.addAttribute("index",id);
		return "/system/wages/wages";
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( WagesDO wages){
		wagesService.update(wages);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		if(wagesService.remove(id)>0){
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
		wagesService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/validateByCard")
	public String validateByCard(WagesDO wagesDO) {
		Map<String,Object> map=new HashMap<>(4);
		map.put("billCode",wagesDO.getBillCode());
		map.put("proCode",wagesDO.getProCode());
		map.put("productCode",wagesDO.getProductCode());
		List<WagesDO> list = wagesService.list(map);
		if(list.size()>0){
			return "false";
		}
		return "true";
	}


}
