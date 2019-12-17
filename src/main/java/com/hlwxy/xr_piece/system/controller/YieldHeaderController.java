package com.hlwxy.xr_piece.system.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hlwxy.xr_piece.system.dao.ExamineYieDao;
import com.hlwxy.xr_piece.system.domain.*;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * 
 * @author lu/yanghaoran
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

	@Autowired
	private ExamineYieDao examineYieDao;

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

	/*
	* 统计表表单的编辑方法
	* */
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){

		YieldHeaderDO yieldHeader = yieldHeaderService.get(id);
		//判断该表单是否审核，已审核返回error2，未审核继续执行
		if (0==yieldHeader.getStats()){
			//保存该该表单的表头
			model.addAttribute("yieldHeader", yieldHeader);
     //		知道了审核人id，查询关联的产品
			Map<String,Object> map=new HashMap<>(1);
			//保存该表单的id
			map.put("headerId",id);
			//查询中间表
			List<ExamineYieDO> list = examineYieDao.list(map);
			Integer [] ids=new Integer[list.size()];
			//遍历中间表，封装表体的id
			for(int i=0;i<list.size();i++){
				ids[i]=list.get(i).getYieId();
			}
			//保存表体id的数组
			model.addAttribute("ids", ids);
			return "system/yieldHeader/edit";
		}else {
			return "system/error/error2";
		}

	}

	/*
	* 统计表表单的查看方法
	* */
    @GetMapping("/resetPwd/{id}")
    String resetPwd(@PathVariable("id") Integer id,Model model){
        YieldHeaderDO yieldHeader = yieldHeaderService.get(id);
		model.addAttribute("yieldHeader", yieldHeader);
		//知道了审核人id，查询关联的产品
		Map<String,Object> map=new HashMap<>(1);
		map.put("headerId",id);
		List<ExamineYieDO> list = examineYieDao.list(map);
		Integer [] ids=new Integer[list.size()];
		//封装表体的id
		for(int i=0;i<list.size();i++) {
			ids[i] = list.get(i).getYieId();
		}
        model.addAttribute("ids", ids);
        return "system/yieldHeader/edit2";
    }

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/saveTable")
	public R save(YieldHeaderDO yieldHeader,Integer[] ids) throws ParseException {
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sfd.parse(yieldHeader.getYieldDate());
		YieldDO yieldDO=new YieldDO();
		if(yieldHeaderService.save(yieldHeader)>0){
			for (int i:ids){ //遍历表体的id
				yieldDO.setId(i);//设置id
				yieldDO.setYieldCode(yieldHeader.getYieldCode());//设置表体的code
				yieldService.update(yieldDO);//根据表体的id修改表体code值
				examineYieDao.save(new ExamineYieDO(i,yieldHeader.getId()));

			}
			return R.ok();
		}
		return R.error();
	}


	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( YieldHeaderDO yieldHeader,Integer[] ids){
		if(yieldHeaderService.update(yieldHeader)>0) {
			examineYieDao.removeById(yieldHeader.getId());
			for (int i : ids) {
				examineYieDao.save(new ExamineYieDO(i, yieldHeader.getId()));
			}
		}

		return R.ok();
	}
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		if(yieldHeaderService.remove(id)>0){
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] ids) {
		for(int i:ids){
			int remove = yieldHeaderService.remove(i);
			if(remove>0){
				Map<String,Object> map=new HashMap<>(1);
				map.put("headerId",i);
				List<ExamineYieDO> list = examineYieDao.list(map);
				for (ExamineYieDO yieldHeader:list){
					yieldService.remove(yieldHeader.getYieId());
					examineYieDao.removeById(yieldHeader.getHeaderId());
				}
			}
		}
		return R.ok();
	}

	//审核
	@PostMapping( "/examine")
	@ResponseBody
	public R examine(@RequestParam("ids[]") Integer[] ids) {
			for (Integer o :ids) {
				YieldHeaderDO yieldHeaderDO = yieldHeaderService.get(o);
				if (0==yieldHeaderDO.getStats()){
					yieldHeaderDO.setStats(1);
					yieldHeaderService.update(yieldHeaderDO);
				}
            }
		return R.ok();
	}

	//弃审
	@PostMapping( "/examine2")
	@ResponseBody
	public R examine2(@RequestParam("ids[]") Integer[] ids) {
		for (Integer o :ids) {
			YieldHeaderDO yieldHeaderDO = yieldHeaderService.get(o);
			if (1==yieldHeaderDO.getStats()){
				yieldHeaderDO.setStats(0);
				yieldHeaderService.update(yieldHeaderDO);
			}
		}
		return R.ok();
	}


	@ResponseBody
	@PostMapping("/validateByCard")
	public String validateByCard(YieldHeaderDO yieldHeaderDO) {
		Map<String,Object> map=new HashMap<>(1);
		map.put("yieldCode",yieldHeaderDO.getYieldCode());
		List<YieldHeaderDO> list = yieldHeaderService.list(map);
		if(list.size()>0){
			return "false";
		}
		return "true";
	}
}
