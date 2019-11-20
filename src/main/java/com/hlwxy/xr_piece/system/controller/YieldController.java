package com.hlwxy.xr_piece.system.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.ConditionDo;
import com.hlwxy.xr_piece.system.domain.WagesDO;
import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import com.hlwxy.xr_piece.system.service.YieldService;
import com.hlwxy.xr_piece.utils.PageUtils;
import com.hlwxy.xr_piece.utils.Query;
import com.hlwxy.xr_piece.utils.R;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


/**
 * 
 * 
 * @author lu/yang
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


//	@ResponseBody
//	@PostMapping("/validateByCard")
//	public String validateByCard(String yieldCode) {
//		if(yieldCode!=null){
//			return "false";
//		}
//		return "true";
//	}

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


	/**
	 * 导入Exal表格，还需要传入计价方式的状态值
	 */
	@RequestMapping("/import")
	@ResponseBody
	public Map<String, Object> findDetailed(@RequestParam("file") MultipartFile file,@RequestParam("yieldCode") String yieldCode,
											@RequestParam("yieldDate") String yieldDate,@RequestParam("auditor") String auditor,@RequestParam("auditDate") String auditDate) {
		Map<String, Object> map = new HashMap<>();
		YieldHeaderDO yieldHeaderDO = new YieldHeaderDO();
		yieldHeaderDO.setYieldCode("666");
		try{
			InputStream inputStream=file.getInputStream();
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//			yieldService.importTable(workbook,yieldHeaderDO);
			System.out.println("结束");
			map.put("code", 0);
			map.put("msg", "表格导入成功！");
		}catch (Exception e){
			System.out.println(e.getMessage());
			map.put("code", -1);
			map.put("msg", "请检查您提交的表格数据和页面数据是否正确！");
		}

		return map;
	}

}

