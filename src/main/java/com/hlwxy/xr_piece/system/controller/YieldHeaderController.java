package com.hlwxy.xr_piece.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import com.hlwxy.xr_piece.system.service.YieldHeaderService;
import com.hlwxy.xr_piece.system.service.YieldService;
import com.hlwxy.xr_piece.utils.PageUtils;
import com.hlwxy.xr_piece.utils.Query;
import com.hlwxy.xr_piece.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-19 09:49:10
 */
 
@Controller
@RequestMapping("/system/yieldHeader")
public class YieldHeaderController {
	@Autowired
	private YieldHeaderService yieldHeaderService;

	@Autowired
	private YieldService yieldService;
	
	@GetMapping()
	String YieldHeader(){
	    return "system/yieldHeader/yieldHeader";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<YieldHeaderDO> yieldHeaderList = yieldHeaderService.list(query);
		int total = yieldHeaderService.count(query);
		PageUtils pageUtils = new PageUtils(yieldHeaderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "system/yieldHeader/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		YieldHeaderDO yieldHeader = yieldHeaderService.get(id);
		model.addAttribute("yieldHeader", yieldHeader);
	    return "system/yieldHeader/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveTable")
	public R save(YieldHeaderDO yieldHeader){
		yieldHeader.setYieldDate(yieldHeader.getYieldDate()+"-01");
		if(yieldHeaderService.save(yieldHeader)>0){
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( YieldHeaderDO yieldHeader){
		yieldHeaderService.update(yieldHeader);
		return R.ok();
	}
	

	
}
