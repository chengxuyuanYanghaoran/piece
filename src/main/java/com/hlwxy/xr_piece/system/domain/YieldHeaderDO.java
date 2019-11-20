package com.hlwxy.xr_piece.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-19 09:49:10
 */
public class YieldHeaderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//产量统计表  id
	private Integer id;
	//单据编号
	private String yieldCode;
	//单据日期
	private String yieldDate;
	//审核人
	private String auditor;
	//审核日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
	private Date auditDate;

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
	 * 设置：单据日期
	 */
	public void setYieldDate(String yieldDate) {
		this.yieldDate = yieldDate;
	}
	/**
	 * 获取：单据日期
	 */
	public String getYieldDate() {
		return yieldDate;
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
