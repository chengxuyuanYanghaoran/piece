package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-12-04 20:21:00
 */
public class ExamineYieDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer  id;
	//产品id
	private Integer yieId;
	//审核表id
	private Integer headerId;


	public ExamineYieDO() {
	}

	public ExamineYieDO(Integer yieId, Integer headerId) {
		this.yieId = yieId;
		this.headerId = headerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 设置：产品id
	 */
	public void setYieId(Integer yieId) {
		this.yieId = yieId;
	}
	/**
	 * 获取：产品id
	 */
	public Integer getYieId() {
		return yieId;
	}
	/**
	 * 设置：审核表id
	 */
	public void setHeaderId(Integer headerId) {
		this.headerId = headerId;
	}
	/**
	 * 获取：审核表id
	 */
	public Integer getHeaderId() {
		return headerId;
	}
}
