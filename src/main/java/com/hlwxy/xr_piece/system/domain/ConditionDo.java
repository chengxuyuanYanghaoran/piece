package com.hlwxy.xr_piece.system.domain;

import java.sql.Date;
import java.io.Serializable;
import java.util.List;


/**
 * 报表查询条件
 */
public class ConditionDo implements Serializable {
	private static final long serialVersionUID = 1L;

	//封装部门
	private List<String> departments;
    private String department;
	//封装人员
    private List<String> peoples;
    private String people;
    //封装工序
    private List<String> procedures;
    private String procedure;
    //封装产品
    private List<String> products;
    private String product;

    //核算期间上限
    private String accountingOn;
    private Date accDataOn;
    //核算区间下限
    private String accountingOff;
    private Date accDataOff;
    //完工日期上限
    private String completionOn;
    private Date comDataOn;
    //完工日期下限
    private String completionOff;
    private Date comDataOff;
    //分页参数
    private Integer limit;//每页显示多少条
    private Integer page;//当前页数
    private Integer pp;//总记录数
    private Integer pc;//开始检索位置

    public ConditionDo() {
    }

    public ConditionDo(List<String> departments, String department, List<String> peoples, String people, List<String> procedures, String procedure, List<String> products, String product, String accountingOn, Date accDataOn, String accountingOff, Date accDataOff, String completionOn, Date comDataOn, String completionOff, Date comDataOff, Integer limit, Integer page, Integer pp, Integer pc) {
        this.departments = departments;
        this.department = department;
        this.peoples = peoples;
        this.people = people;
        this.procedures = procedures;
        this.procedure = procedure;
        this.products = products;
        this.product = product;
        this.accountingOn = accountingOn;
        this.accDataOn = accDataOn;
        this.accountingOff = accountingOff;
        this.accDataOff = accDataOff;
        this.completionOn = completionOn;
        this.comDataOn = comDataOn;
        this.completionOff = completionOff;
        this.comDataOff = comDataOff;
        this.limit = limit;
        this.page = page;
        this.pp = pp;
        this.pc = pc;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public Integer getPc() {
        return pc;
    }

    public void setPc(Integer pc) {
        this.pc = pc;
    }

    public Date getAccDataOn() {
        return accDataOn;
    }

    public void setAccDataOn(Date accDataOn) {
        this.accDataOn = accDataOn;
    }

    public Date getAccDataOff() {
        return accDataOff;
    }

    public void setAccDataOff(Date accDataOff) {
        this.accDataOff = accDataOff;
    }

    public Date getComDataOn() {
        return comDataOn;
    }

    public void setComDataOn(Date comDataOn) {
        this.comDataOn = comDataOn;
    }

    public Date getComDataOff() {
        return comDataOff;
    }

    public void setComDataOff(Date comDataOff) {
        this.comDataOff = comDataOff;
    }

    public List<String> getDepartments() {
        return departments;
    }

    public void setDepartments(List<String> departments) {
        this.departments = departments;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<String> getPeoples() {
        return peoples;
    }

    public void setPeoples(List<String> peoples) {
        this.peoples = peoples;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public List<String> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<String> procedures) {
        this.procedures = procedures;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAccountingOn() {
        return accountingOn;
    }

    public void setAccountingOn(String accountingOn) {
        this.accountingOn = accountingOn;
    }

    public String getAccountingOff() {
        return accountingOff;
    }

    public void setAccountingOff(String accountingOff) {
        this.accountingOff = accountingOff;
    }

    public String getCompletionOn() {
        return completionOn;
    }

    public void setCompletionOn(String completionOn) {
        this.completionOn = completionOn;
    }

    public String getCompletionOff() {
        return completionOff;
    }

    public void setCompletionOff(String completionOff) {
        this.completionOff = completionOff;
    }
}
