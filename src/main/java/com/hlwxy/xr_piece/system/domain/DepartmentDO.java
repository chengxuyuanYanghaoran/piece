package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-11 17:24:05
 */
public class DepartmentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//部门编码
	private String bmCode;
	//部门名称
	private String bmName;

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
	 * 设置：部门编码
	 */
	public void setBmCode(String bmCode) {
		this.bmCode = bmCode;
	}
	/**
	 * 获取：部门编码
	 */
	public String getBmCode() {
		return bmCode;
	}
	/**
	 * 设置：部门名称
	 */
	public void setBmName(String bmName) {
		this.bmName = bmName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getBmName() {
		return bmName;
	}
}
