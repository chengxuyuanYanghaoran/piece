package com.hlwxy.xr_piece.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hlwxy.xr_piece.system.dao.ExamineWagesDao;
import com.hlwxy.xr_piece.system.domain.ExamineWagesDO;
import com.hlwxy.xr_piece.system.domain.ExamineYieDO;
import com.hlwxy.xr_piece.system.domain.WagesHeaderDO;
import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import com.hlwxy.xr_piece.system.service.WagesHeaderService;
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
 * @date 2019-11-19 10:26:57
 */
 
@Controller
@RequestMapping("/system/wagesHeader")
public class WagesHeaderController {
	@Autowired
	private WagesHeaderService wagesHeaderService;
	@Autowired
	private ExamineWagesDao examineWagesDao;
	@GetMapping()
	String WagesHeader(){
	    return "system/wagesHeader/wagesHeader";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WagesHeaderDO> wagesHeaderList = wagesHeaderService.list(query);
		int total = wagesHeaderService.count(query);
		PageUtils pageUtils = new PageUtils(wagesHeaderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "system/wagesHeader/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		WagesHeaderDO wagesHeader = wagesHeaderService.get(id);
		model.addAttribute("wagesHeader", wagesHeader);
	    return "system/wagesHeader/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveTable")
	public R save(WagesHeaderDO wagesHeader,Integer[] ids) throws ParseException {
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sfd.parse(wagesHeader.getAccountingDate());
		wagesHeader.setBillDate(wagesHeader.getBillDate()+"-01");
		if(wagesHeaderService.save(wagesHeader)>0){
			return R.ok();
		}
           return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( WagesHeaderDO wagesHeader){
		wagesHeaderService.update(wagesHeader);
		examineWagesDao.removeById(wagesHeader.getId());
		return R.ok();
}
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		if(wagesHeaderService.remove(id)>0){
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
		wagesHeaderService.batchRemove(ids);
		return R.ok();
	}



	@ResponseBody
	@PostMapping("/validateByCard")
	public String validateByCard(WagesHeaderDO wagesHeaderDO) {
		Map<String,Object> map=new HashMap<>(1);
		map.put("billCode",wagesHeaderDO.getBillCode());
		List<WagesHeaderDO> list = wagesHeaderService.list(map);
		if(list.size()>0){
			return "false";
		}
		return "true";
	}
	
}
