package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-12-06 14:41:55
 */
public class ExamineWagesDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//表体id
	private Integer wagesId;
	//表头表尾id
	private Integer headerId;

	public ExamineWagesDO() {
	}

	public ExamineWagesDO(Integer wagesId, Integer headerId) {
		this.wagesId = wagesId;
		this.headerId = headerId;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：表体id
	 */
	public void setWagesId(Integer wagesId) {
		this.wagesId = wagesId;
	}
	/**
	 * 获取：表体id
	 */
	public Integer getWagesId() {
		return wagesId;
	}
	/**
	 * 设置：表头表尾id
	 */
	public void setHeaderId(Integer headerId) {
		this.headerId = headerId;
	}
	/**
	 * 获取：表头表尾id
	 */
	public Integer getHeaderId() {
		return headerId;
	}
}
