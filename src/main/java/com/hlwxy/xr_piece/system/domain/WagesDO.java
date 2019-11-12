package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:25:00
 */
public class WagesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//单据编号
	private String billCode;
	//单据日期
	private Date billDate;
	//核算期间（日期型，只显示年月）
	private Date accDate;
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
	//审核人
	private String auditor;
	//审核日期
	private Date auditDate;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：单据编号
	 */
	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}
	/**
	 * 获取：单据编号
	 */
	public String getBillCode() {
		return billCode;
	}
	/**
	 * 设置：单据日期
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	/**
	 * 获取：单据日期
	 */
	public Date getBillDate() {
		return billDate;
	}
	/**
	 * 设置：核算期间（日期型，只显示年月）
	 */
	public void setAccDate(Date accDate) {
		this.accDate = accDate;
	}
	/**
	 * 获取：核算期间（日期型，只显示年月）
	 */
	public Date getAccDate() {
		return accDate;
	}
	/**
	 * 设置：日期
	 */
	public void setDateMark(Date dateMark) {
		this.dateMark = dateMark;
	}
	/**
	 * 获取：日期
	 */
	public Date getDateMark() {
		return dateMark;
	}
	/**
	 * 设置：人员编码
	 */
	public void setPeopleCode(String peopleCode) {
		this.peopleCode = peopleCode;
	}
	/**
	 * 获取：人员编码
	 */
	public String getPeopleCode() {
		return peopleCode;
	}
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：工序编码
	 */
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	/**
	 * 获取：工序编码
	 */
	public String getProCode() {
		return proCode;
	}
	/**
	 * 设置：工序名称
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * 获取：工序名称
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * 设置：产品编码
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * 获取：产品编码
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：产量
	 */
	public void setHarvest(Integer harvest) {
		this.harvest = harvest;
	}
	/**
	 * 获取：产量
	 */
	public Integer getHarvest() {
		return harvest;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * 设置：金额
	 */
	public void setMoney(Integer money) {
		this.money = money;
	}
	/**
	 * 获取：金额
	 */
	public Integer getMoney() {
		return money;
	}
	/**
	 * 设置：审核人
	 */
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	/**
	 * 获取：审核人
	 */
	public String getAuditor() {
		return auditor;
	}
	/**
	 * 设置：审核日期
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}
	/**
	 * 获取：审核日期
	 */
	public Date getAuditDate() {
		return auditDate;
	}
}
