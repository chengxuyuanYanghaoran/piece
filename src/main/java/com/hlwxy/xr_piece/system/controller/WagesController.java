package com.hlwxy.xr_piece.system.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hlwxy.xr_piece.system.domain.*;
import com.hlwxy.xr_piece.system.service.PeopleService;
import com.hlwxy.xr_piece.system.service.ProcedureService;
import com.hlwxy.xr_piece.system.service.ProductService;
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
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:25:00
 */

@Controller
@RequestMapping("/system/wages")
public class WagesController {
    @Autowired
    private WagesService wagesService;
    @Autowired
    private PeopleService peopleService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProcedureService procedureService;

    @GetMapping()
    String Wages() {
        return "system/wages/wages";
    }

    @ResponseBody
    @RequestMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        String state = (String) query.get("state");
        List<WagesDO> wagesList = wagesService.list(query);
        if ("0".equals(state)) {
            for (WagesDO d : wagesList) {
                BigDecimal productPrice = d.getProductPrice();
                productPrice.setScale(2);
                BigDecimal bigDecimal = new BigDecimal(d.getHarvest());
                d.setMoney(productPrice.multiply(bigDecimal));
                wagesService.update(d);
            }
        } else {
            for (WagesDO d : wagesList) {
                BigDecimal productPrice = d.getProPrice();
                productPrice.setScale(2);
                BigDecimal bigDecimal = new BigDecimal(d.getHarvest());
                d.setMoney(productPrice.multiply(bigDecimal));
                wagesService.update(d);
            }
        }
        int total = wagesService.count(query);
        PageUtils pageUtils = new PageUtils(wagesList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add(Model model) {
        List<PeopleDO> peopleDOList = peopleService.list(null);
        model.addAttribute("peopleDOList", peopleDOList);
        List<ProductDO> productDOList = productService.list(null);
        model.addAttribute("productDOList", productDOList);
        List<ProcedureDO> procedureDOList = procedureService.list(null);
        model.addAttribute("procedureDOList", procedureDOList);
        return "system/wages/add";
    }

    @GetMapping("/add1")
    String add1(Model model) {
        List<PeopleDO> peopleDOList = peopleService.list(null);
        model.addAttribute("peopleDOList", peopleDOList);
        List<ProcedureDO> procedureDOList = procedureService.list(null);
        model.addAttribute("procedureDOList", procedureDOList);
        return "system/wages/add1";
    }

    @GetMapping("/edit/{id}")
    String edit(@PathVariable("id") Integer id, Model model) {
        WagesDO wages = wagesService.get(id);
        model.addAttribute("wages", wages);
        return "system/wages/edit";
    }

    @GetMapping("/edit1/{id}")
    String edit1(@PathVariable("id") Integer id, Model model) {
        WagesDO wages = wagesService.get(id);
        model.addAttribute("wages", wages);
        return "system/wages/edit1";
    }

    /**
     * s
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    public R save(WagesDO wages, String item) {
        if ("0".equals(item)) {
            BigDecimal productPrice = wages.getProductPrice();
            productPrice.setScale(2);
            BigDecimal bigDecimal = new BigDecimal(wages.getHarvest());
            wages.setMoney(productPrice.multiply(bigDecimal));
        } else if ("1".equals(item)) {
            BigDecimal productPrice = wages.getProPrice();
				productPrice.setScale(2);
				BigDecimal bigDecimal = new BigDecimal(wages.getHarvest());
				wages.setMoney(productPrice.multiply(bigDecimal));
        }
        if (wagesService.save(wages) > 0) {
            return R.ok(wages.getId().toString());
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    public R update(WagesDO wages) {
        wagesService.update(wages);
        return R.ok();
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    public R remove(Integer id) {
        if (wagesService.remove(id) > 0) {
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
        wagesService.batchRemove(ids);
        return R.ok();
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    WagesDO get(@PathVariable("id") Integer id) {
        WagesDO wagesDO = wagesService.get(id);
        return wagesDO;
    }

    @PostMapping("/getByIds")
    @ResponseBody
    public List<WagesDO> getByIds(@RequestParam("ids[]") Integer[] ids) {
        List<WagesDO> list = new ArrayList<>();
        for (int i : ids) {
            WagesDO wagesDO = wagesService.get(i);
            list.add(wagesDO);
        }
        return list;
    }


}
