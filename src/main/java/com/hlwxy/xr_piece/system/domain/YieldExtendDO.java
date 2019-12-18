package com.hlwxy.xr_piece.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * 
 * @author yang
 * @email 1992lcg@163.com
 * @date 2019-11-13 11:31:00
 */
public class YieldExtendDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//产量统计表  id
	private Integer id;
	//单据编号
	private String yieldCode;
	//日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
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
	//工序单价
	private BigDecimal proPrice;
	//产品单价
	private BigDecimal productPrice;
	//金额
	private BigDecimal money;

	public YieldExtendDO() {
	}

	public YieldExtendDO(Integer id, String yieldCode, Date dateMark, String peopleCode, String name, String proCode, String proName, String productCode, String productName, Integer harvest, BigDecimal proPrice, BigDecimal productPrice, BigDecimal money) {
		this.id = id;
		this.yieldCode = yieldCode;
		this.dateMark = dateMark;
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

	public String getYieldCode() {
		return yieldCode;
	}

	public void setYieldCode(String yieldCode) {
		this.yieldCode = yieldCode;
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
}
