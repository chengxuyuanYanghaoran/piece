package com.hlwxy.xr_piece.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-13 11:31:00
 */
public class YieldDO implements Serializable {
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

	private Set<YieldHeaderDO> users = new HashSet<>();

	public Set<YieldHeaderDO> getUsers() {
		return users;
	}

	public void setUsers(Set<YieldHeaderDO> users) {
		this.users = users;
	}

	/**
	 * 设置：产量统计表  id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：产量统计表  id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：单据编号
	 */
	public void setYieldCode(String yieldCode) {
		this.yieldCode = yieldCode;
	}
	/**
	 * 获取：单据编号
	 */
	public String getYieldCode() {
		return yieldCode;
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
	public Integer getHarvest() {
		return harvest;
	}

	public void setHarvest(Integer harvest) {
		this.harvest = harvest;
	}
}
