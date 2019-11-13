package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:41
 */
public class ProcedureDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//工序编码
	private String proCode;
	//工序名称
	private String proName;
	//工序计件单价
	private BigDecimal proPrice;

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

	public BigDecimal getProPrice() {
		return proPrice;
	}

	public void setProPrice(BigDecimal proPrice) {
		this.proPrice = proPrice;
	}
}
