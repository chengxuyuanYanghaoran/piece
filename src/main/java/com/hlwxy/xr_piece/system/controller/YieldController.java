package com.hlwxy.xr_piece.system.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import com.hlwxy.xr_piece.system.dao.ExamineYieDao;
import com.hlwxy.xr_piece.system.domain.ConditionDo;
import com.hlwxy.xr_piece.system.domain.WagesDO;
import com.hlwxy.xr_piece.system.domain.YieldDO;
import com.hlwxy.xr_piece.system.domain.YieldHeaderDO;
import com.hlwxy.xr_piece.system.service.YieldService;
import com.hlwxy.xr_piece.utils.PageUtils;
import com.hlwxy.xr_piece.utils.Query;
import com.hlwxy.xr_piece.utils.R;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
	@Autowired
	private ExamineYieDao examineYieDao;

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



	@ResponseBody
	@GetMapping("/get/{id}")
	YieldDO get(@PathVariable("id") Integer id) {
		YieldDO yieldDO = yieldService.get(id);
		return yieldDO;
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(YieldDO yield) {
		if (yieldService.save(yield) > 0) {
			return R.ok(yield.getId().toString());
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

	@PostMapping("/getByIds")
	@ResponseBody
	public List<YieldDO> getByIds(@RequestParam("ids[]") Integer[] ids) {
		List<YieldDO> list=new ArrayList<>();
		for (int i:ids){
			YieldDO yieldDO = yieldService.get(i);
			list.add(yieldDO);
		}
		return list;
	}


	/**
	 * 导入Exal表格，还需要传入计价方式的状态值
	 *
	 * , @RequestParam("yieldCode") String yieldCode,
	 * @RequestParam("yieldDate") String yieldDate, @RequestParam("auditor") String auditor,
	 * @RequestParam("auditDate") String auditDate, @RequestParam("mode") String mode
	 */
	@RequestMapping("/import")
	@ResponseBody
	public Map<String, Object> findDetailed(@RequestParam("file") MultipartFile file,@RequestParam("mode") String mode) {
		Map<String, Object> map = new HashMap<>();
//		YieldHeaderDO yieldHeaderDO =yieldHeaderData(yieldDate,auditDate);//核算区间、审核时间
//		yieldHeaderDO.setYieldCode(yieldCode);//单据编号
//        yieldHeaderDO.setAuditor(auditor);//审核人
		try{
			InputStream inputStream=file.getInputStream();
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//			,yieldHeaderDO,mode
			yieldService.importTable(workbook,mode);
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


    //时间处理
    private YieldHeaderDO yieldHeaderData(String yieldDate, String auditDate){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
        YieldHeaderDO yieldHeaderDO=new YieldHeaderDO();
        try {
            yieldDate=yieldDate+"-01";
//            String f = new Date(String.valueOf(sdf.parse(yieldDate)));
            yieldHeaderDO.setYieldDate(yieldDate);
//            auditDate=auditDate+"-01";
            Date f2 = new Date(String.valueOf(sdf.parse(auditDate)));
            yieldHeaderDO.setAuditDate(f2);
        } catch (Exception e) {
            System.out.println("时间格式错误！");
            e.printStackTrace();
        }
        return yieldHeaderDO;
    }

}

