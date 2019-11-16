package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;
import java.sql.Date;


/**
 * 工资核算表
 */
public class WagesExtendDO extends WagesHeaderDO implements Serializable{
	private static final long serialVersionUID = 1L;

	//id
	private Integer id;
	//单据编号
	private String billCode;
	//日期
	private Date dateMark;
	//人员编码
	private String peopleCode;
	//姓名
	private String name;
	//工序编码
	private String proCode;
	//工序名称
	private String proName;
	//产品编码
	private String productCode;
	//产品名称
	private String productName;
	//产量
	private Integer harvest;
	//单价
	private Double price;
	//金额
	private Integer money;

	public WagesExtendDO() {
	}

	public WagesExtendDO(Integer id, String billCode, Date billDate, String auditor, Date auditDate) {
		super(id, billCode, billDate, auditor, auditDate);
	}

	public WagesExtendDO(Integer id, String billCode, Date dateMark, String peopleCode, String name, String proCode, String proName, String productCode, String productName, Integer harvest, Double price, Integer money) {
		this.id = id;
		this.billCode = billCode;
		this.dateMark = dateMark;
		this.peopleCode = peopleCode;
		this.name = name;
		this.proCode = proCode;
		this.proName = proName;
		this.productCode = productCode;
		this.productName = productName;
		this.harvest = harvest;
		this.price = price;
		this.money = money;
	}

	public WagesExtendDO(Integer id, String billCode, Date billDate, String auditor, Date auditDate, Integer id1, String billCode1, Date dateMark, String peopleCode, String name, String proCode, String proName, String productCode, String productName, Integer harvest, Double price, Integer money) {
		super(id, billCode, billDate, auditor, auditDate);
		this.id = id1;
		this.billCode = billCode1;
		this.dateMark = dateMark;
		this.peopleCode = peopleCode;
		this.name = name;
		this.proCode = proCode;
		this.proName = proName;
		this.productCode = productCode;
		this.productName = productName;
		this.harvest = harvest;
		this.price = price;
		this.money = money;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getBillCode() {
		return billCode;
	}

	@Override
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public Date getDateMark() {
		return dateMark;
	}

	public void setDateMark(Date dateMark) {
		this.dateMark = dateMark;
	}

	public String getPeopleCode() {
		return peopleCode;
	}

	public void setPeopleCode(String peopleCode) {
		this.peopleCode = peopleCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getHarvest() {
		return harvest;
	}

	public void setHarvest(Integer harvest) {
		this.harvest = harvest;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
}
