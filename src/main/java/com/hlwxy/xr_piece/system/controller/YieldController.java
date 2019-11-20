package com.hlwxy.xr_piece.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.service.YieldService;
import com.hlwxy.xr_piece.utils.PageUtils;
import com.hlwxy.xr_piece.utils.Query;
import com.hlwxy.xr_piece.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-13 11:31:00
 */
 
@Controller
@RequestMapping("/system/yield")
public class YieldController {
	@Autowired
	private YieldService yieldService;

	@GetMapping()
	String Yield() {
		return "system/yield/yield";
	}

	@ResponseBody
	@PostMapping("/validateByCard")
	public String validateByCard(YieldDO yieldDO) {
		Map<String,Object> map=new HashMap<>(4);
		map.put("yieldCode",yieldDO.getYieldCode());
		map.put("peopleCode",yieldDO.getPeopleCode());
		map.put("proCode",yieldDO.getProCode());
		map.put("productCode",yieldDO.getProductCode());
		List<YieldDO> list = yieldService.list(map);
		if(list.size()>0){
			return "false";
		}
		return "true";
	}

	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		List<YieldDO> yieldList = yieldService.list(query);
		int total = yieldService.count(query);
		PageUtils pageUtils = new PageUtils(yieldList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	String add() {
		return "system/yield/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id, Model model) {
		YieldDO yield = yieldService.get(id);
		model.addAttribute("yield", yield);
		return "system/yield/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(YieldDO yield) {
		if (yieldService.save(yield) > 0) {
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(YieldDO yield) {
		yieldService.update(yield);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	public R remove(Integer id) {
		if (yieldService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] ids) {
		yieldService.batchRemove(ids);
		return R.ok();
	}


}

