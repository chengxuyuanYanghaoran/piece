package com.hlwxy.xr_piece.system.controller;

import com.hlwxy.xr_piece.system.domain.ConditionDo;
import com.hlwxy.xr_piece.system.domain.ReturnDO;
import com.hlwxy.xr_piece.system.domain.WagesDO;
import com.hlwxy.xr_piece.system.service.reportFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.text.SimpleDateFormat;

/**
 * 报表控制
 */
@Controller
@RequestMapping("/system/reportForm")
public class reportFormController {

    @Autowired
    private reportFormService reportFormService;

    //工资统计表
    @GetMapping("/getstatistics")
    public String getstatistics() {
        return "system/report/statistics";
    }

    //工资明细表
    @GetMapping("/statisticsTwo")
    public String statisticsTwo() {
        return "system/report/statistics_two";
    }

    //工资统计
    @GetMapping("/statisticsThree")
    public String statisticsThree() {
        return "system/report/statistics_three";
    }

    //工资明细表  @RequestParam("file")
    @RequestMapping("/detailed")
    @ResponseBody
    public Map<String,Object> findDetailed(ConditionDo conditionDo) {
        Map<String,Object> map=new HashMap<>();
        conditionDo=conditionDoHandle(conditionDo);
        //计算开始检索位置
        conditionDo.setPc(conditionDo.getLimit()*(conditionDo.getPage()-1));
        try{

            Integer pp=reportFormService.countDetailed(conditionDo);
            List<WagesDO> list=reportFormService.findDetailed(conditionDo);
            if (!conditionDo.getMode().equals("0")){ //工序计价
                for (WagesDO wagesDO:list){
                    wagesDO.setProductPrice(wagesDO.getProPrice());
                }
            }
            map.put("data", list);
            map.put("count",pp);
            map.put("code",0);
            map.put("msg","查询工资明细表成功！");
        }catch (Exception e){
            map.put("code",-1);
            map.put("msg","查询工资明细表失败！");
        }

        return map;
    }

    //工资统计
    @RequestMapping("/statistics")
    @ResponseBody
    public Map<String,Object> findStatistics(ConditionDo conditionDo) {
        Map<String,Object> map=new HashMap<>();
        conditionDo=conditionDoHandle2(conditionDo);
        //计算开始检索位置
        conditionDo.setPc(conditionDo.getLimit()*(conditionDo.getPage()-1));
        conditionDo.setComDataOn(null);
        try{
            List<ReturnDO> list=reportFormService.findStatistics(conditionDo);
            list=uodateDccDatas(list);
            Integer pp=reportFormService.countFindStatistics(conditionDo).size();
            map.put("data",list);
            map.put("count",pp);
            map.put("code",0);
            map.put("msg","查询工资统计成功！");
        }catch (Exception e){
            map.put("code",-1);
            map.put("msg","查询工资统计失败！");
        }
        return map;
    }

    //工资统计表
    @RequestMapping("/statisticsTable")
    @ResponseBody
    public Map<String,Object> findStatisticsTable(ConditionDo conditionDo) {
        Map<String,Object> map=new HashMap<>();
        conditionDo=conditionDoHandle(conditionDo);
        //计算开始检索位置
        conditionDo.setPc(conditionDo.getLimit()*(conditionDo.getPage()-1));
        try{
            List<ReturnDO> list=reportFormService.findStatisticsTable(conditionDo);
            list=uodateDccDatas(list);
            Integer pp=reportFormService.countStatisticsTable(conditionDo).size();
            map.put("data",list);
            map.put("count",pp);
            map.put("code",0);
            map.put("msg","查询工资统计表成功！");
        }catch (Exception e){
            map.put("code",-1);
            map.put("msg","查询工资统计表失败！");
        }
        return map;
    }

    //查询条件处理一（工资明细表、工资共计表）
    private ConditionDo conditionDoHandle(ConditionDo conditionDo){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
        try {
            //核算期间
            if (conditionDo.getAccountingOn()!=null&&!conditionDo.getAccountingOn().equals("")){
                conditionDo.setAccountingOn(conditionDo.getAccountingOn()+"-30");
                //核算区间上限
                Date f = new Date(String.valueOf(sdf.parse(conditionDo.getAccountingOn())));
                java.sql.Date resultDate = new java.sql.Date(f.getTime());
                conditionDo.setAccDataOn(resultDate);
            }
            if (conditionDo.getAccountingOff()!=null&&!conditionDo.getAccountingOff().equals("")){
                conditionDo.setAccountingOff(conditionDo.getAccountingOff()+"-01");
                //核算区间下限
                Date f = new Date(String.valueOf(sdf.parse(conditionDo.getAccountingOff())));
                java.sql.Date resultDate = new java.sql.Date(f.getTime());
                conditionDo.setAccDataOff(resultDate);
            }

            //完工期间
            if (conditionDo.getCompletionOn()!=null&&!conditionDo.getCompletionOn().equals("")){
                conditionDo.setCompletionOn(conditionDo.getCompletionOn());
                //完工期间上限
                Date f = new Date(String.valueOf(sdf.parse(conditionDo.getCompletionOn())));
                java.sql.Date resultDate = new java.sql.Date(f.getTime());
                conditionDo.setComDataOn(resultDate);
            }
            if (conditionDo.getCompletionOff()!=null&&!conditionDo.getCompletionOff().equals("")){
                conditionDo.setCompletionOff(conditionDo.getCompletionOff());
                //完工期间下限
                Date f = new Date(String.valueOf(sdf.parse(conditionDo.getCompletionOff())));
                java.sql.Date resultDate = new java.sql.Date(f.getTime());
                conditionDo.setComDataOff(resultDate);
            }

            conditionDo=conditionDoHandleUtils(conditionDo);

        } catch (Exception e) {
            System.out.println("时间格式错误！");
            e.printStackTrace();
        }
        return conditionDo;
    }

    //查询条件处理二（工资统计）
    private ConditionDo conditionDoHandle2(ConditionDo conditionDo){
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd" );
        try {
            //核算期间
            if (conditionDo.getAccountingOn()!=null&&!conditionDo.getAccountingOn().equals("")){
                conditionDo.setAccountingOn(conditionDo.getAccountingOn()+"-12-30");
                //核算区间上限
                Date f = new Date(String.valueOf(sdf.parse(conditionDo.getAccountingOn())));
                java.sql.Date resultDate = new java.sql.Date(f.getTime());
                conditionDo.setAccDataOn(resultDate);
            }
            if (conditionDo.getAccountingOff()!=null&&!conditionDo.getAccountingOff().equals("")){
                conditionDo.setAccountingOff(conditionDo.getAccountingOff()+"-01-01");
                //核算区间下限
                Date f = new Date(String.valueOf(sdf.parse(conditionDo.getAccountingOff())));
                java.sql.Date resultDate = new java.sql.Date(f.getTime());
                conditionDo.setAccDataOff(resultDate);
            }

            conditionDo=conditionDoHandleUtils(conditionDo);
        } catch (Exception e) {
            System.out.println("时间格式错误！");
            e.printStackTrace();
        }
        return conditionDo;
    }

    //共有的查询条件处理
    private ConditionDo conditionDoHandleUtils(ConditionDo conditionDo){
        try{
            //部门条件处理
            if (conditionDo.getDepartment()!=null&&!conditionDo.getDepartment().equals("")){
                conditionDo.setDepartment(conditionDo.getDepartment().substring(0,conditionDo.getDepartment().length()-1));
                String[] s=conditionDo.getDepartment().split(",");
//                if (s.length<=1){
//                    s=conditionDo.getDepartment().split(" ");
//                }
                conditionDo.setDepartments(Arrays.asList(s));
            }
            //人员条件处理
            if (conditionDo.getPeople()!=null&&!conditionDo.getPeople().equals("")){
                conditionDo.setPeople(conditionDo.getPeople().substring(0,conditionDo.getPeople().length()-1));
                String[] s2=conditionDo.getPeople().split(",");
//                if (s2.length<=1){
//                    s2=conditionDo.getPeople().split(" ");
//                }
                conditionDo.setPeoples(Arrays.asList(s2));
            }
            //工序条件处理
            if (conditionDo.getProcedure()!=null&&!conditionDo.getProcedure().equals("")){
                conditionDo.setProcedure(conditionDo.getProcedure().substring(0,conditionDo.getProcedure().length()-1));//设置工序
                String[] s3=conditionDo.getProcedure().split(",");
//                if (s3.length<=1){
//                    s3=conditionDo.getProcedure().split(" ");
//                }
                conditionDo.setProcedures(Arrays.asList(s3));
            }
            //产品条件处理
            if (conditionDo.getProduct()!=null&&!conditionDo.getProduct().equals("")){
                conditionDo.setProduct(conditionDo.getProduct().substring(0,conditionDo.getProduct().length()-1));//设置产品
                String[] s4=conditionDo.getProduct().split(",");
//                if (s4.length<=1){
//                    s4=conditionDo.getProduct().split(" ");
//                }
                conditionDo.setProducts(Arrays.asList(s4));
            }
        }catch (Exception e){
            System.out.println("请输入正确的查询条件");
            e.printStackTrace();
        }
        return conditionDo;
    }

    //返回页面的时间处理
    private List<ReturnDO> uodateDccDatas(List<ReturnDO> list){
        try {
            for (ReturnDO returnDO:list) {
                returnDO.setAccDataStr((String.valueOf(returnDO.getAccDatas())).substring(0,7));
            }
        }catch (Exception e){
            System.out.println("返回页面的时间处理失败");
        }

        return list;
    }

}
