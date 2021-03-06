package com.hlwxy.xr_piece.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 工资核算表，标题
 */
public class WagesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//单据编号
	private String billCode;
	//日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
	private Date dateMark;
	private java.sql.Date dateMark2;
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
	//工序单价
	private BigDecimal proPrice;
	//产品单价
	private BigDecimal productPrice;
	//金额
	private BigDecimal money;

	public WagesDO() {
	}


	public WagesDO(Integer id, String billCode, Date dateMark, java.sql.Date dateMark2, String peopleCode, String name, String proCode, String proName, String productCode, String productName, Integer harvest, BigDecimal proPrice, BigDecimal productPrice, BigDecimal money) {
		this.id = id;
		this.billCode = billCode;
		this.dateMark = dateMark;
		this.dateMark2 = dateMark2;
		this.peopleCode = peopleCode;
		this.name = name;
		this.proCode = proCode;
		this.proName = proName;
		this.productCode = productCode;
		this.productName = productName;
		this.harvest = harvest;
		this.proPrice = proPrice;
		this.productPrice = productPrice;
		this.money = money;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillCode() {
		return billCode;
	}

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

	public BigDecimal getProPrice() {
		return proPrice;
	}

	public void setProPrice(BigDecimal proPrice) {
		this.proPrice = proPrice;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public java.sql.Date getDateMark2() {
		return dateMark2;
	}

	public void setDateMark2(java.sql.Date dateMark2) {
		this.dateMark2 = dateMark2;
	}
}
