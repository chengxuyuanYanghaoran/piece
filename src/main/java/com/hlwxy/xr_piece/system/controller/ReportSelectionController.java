package com.hlwxy.xr_piece.system.controller;

import com.hlwxy.xr_piece.system.dao.ReportSelectionDao;
import com.hlwxy.xr_piece.system.domain.*;
import com.hlwxy.xr_piece.system.service.UserService;
import com.hlwxy.xr_piece.utils.PageUtils;
import com.hlwxy.xr_piece.utils.Query;
import com.hlwxy.xr_piece.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:51
 */
 
@Controller
@RequestMapping("/system/reportSelection")
public class ReportSelectionController {
	@Autowired
	private ReportSelectionDao reportSelectionDao;

	//查询部门
	@ResponseBody
	@GetMapping("/findDepartmentName")
	public Map<String,Object> findDepartmentName(){
		Map<String,Object> map=new HashMap<>();
		try{
			//查询列表数据
			List<DepartmentDO> departmentDOS = reportSelectionDao.findDepartmentName();
			map.put("departmentDOS",departmentDOS);
			map.put("code",1);
			map.put("msg","查询部门成功！");
		}catch (Exception e){
			map.put("code",-1);
			map.put("msg","查询部门失败！");
		}
		return map;
	}

	//查询人员
	@ResponseBody
	@GetMapping("/findPeopleName")
	public Map<String,Object> findPeopleName(){
		Map<String,Object> map=new HashMap<>();
		try{
			//查询列表数据
			List<PeopleDO> peopleDOS = reportSelectionDao.findPeopleName();
			map.put("peopleDOS",peopleDOS);
			map.put("code",1);
			map.put("msg","查询人员成功！");
		}catch (Exception e){
			map.put("code",-1);
			map.put("msg","查询人员失败！");
		}
		return map;
	}

	//查询工序
	@ResponseBody
	@GetMapping("/findProcedureName")
	public Map<String,Object> findProcedureName(){
		Map<String,Object> map=new HashMap<>();
		try{
			//查询列表数据
			List<ProcedureDO> procedureDOS = reportSelectionDao.findProcedureName();
			map.put("procedureDOS",procedureDOS);
			map.put("code",1);
			map.put("msg","查询工序成功！");
		}catch (Exception e){
			map.put("code",-1);
			map.put("msg","查询工序失败！");
		}
		return map;
	}

	//查询产品
	@ResponseBody
	@GetMapping("/findProductName")
	public Map<String,Object> findProductName(){
		Map<String,Object> map=new HashMap<>();
		try{
			//查询列表数据
			List<ProductDO> productDOS = reportSelectionDao.findProductName();
			map.put("productDOS",productDOS);
			map.put("code",1);
			map.put("msg","查询工序成功！");
		}catch (Exception e){
			map.put("code",-1);
			map.put("msg","查询工序失败！");
		}
		return map;
	}

}
