package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;


/**
 * 报表查询条件
 */
public class ConditionDo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//人员编号
	private String peopleCode;
	//人员姓名
	private String peopleName;
	//所属部门
	private Integer bmId;

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
	 * 设置：人员编号
	 */
	public void setPeopleCode(String peopleCode) {
		this.peopleCode = peopleCode;
	}
	/**
	 * 获取：人员编号
	 */
	public String getPeopleCode() {
		return peopleCode;
	}
	/**
	 * 设置：人员姓名
	 */
	public void setPeopleName(String peopleName) {
		this.peopleName = peopleName;
	}
	/**
	 * 获取：人员姓名
	 */
	public String getPeopleName() {
		return peopleName;
	}
	/**
	 * 设置：所属部门
	 */
	public void setBmId(Integer bmId) {
		this.bmId = bmId;
	}
	/**
	 * 获取：所属部门
	 */
	public Integer getBmId() {
		return bmId;
	}
}
