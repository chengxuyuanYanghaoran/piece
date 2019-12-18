package com.hlwxy.xr_piece.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * @author lu
 * @email 1992lcg@163.com
 * @date 2019-11-19 09:49:10
 */

public class YieldHeaderDO  implements Serializable  {
	private static final long serialVersionUID = 1L;

	//id
	private Integer id;
	//单据编号
	private String yieldCode;
	//核算期间
	//日期

	private String yieldDate;
	private java.sql.Date yieldDate2;
	//审核人
	private String auditor;
	//审核日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
	private Date auditDate;
	//审核状态
	private Integer stats;
	//是否已添加到核算表单
	private Integer stats2;

	private Set<YieldDO> roles = new HashSet<>();



	public YieldHeaderDO() {
	}

	public YieldHeaderDO(Integer id, String yieldCode, String yieldDate, java.sql.Date yieldDate2, String auditor, Date auditDate, Integer stats, Integer stats2) {
		this.id = id;
		this.yieldCode = yieldCode;
		this.yieldDate = yieldDate;
		this.yieldDate2 = yieldDate2;
		this.auditor = auditor;
		this.auditDate = auditDate;
		this.stats = stats;
		this.stats2 = stats2;
	}

	public Set<YieldDO> getRoles() {
		return roles;
	}

	public void setRoles(Set<YieldDO> roles) {
		this.roles = roles;
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

	public String getYieldDate() {
		return yieldDate;
	}

	public void setYieldDate(String yieldDate) {
		this.yieldDate = yieldDate;
	}

	public java.sql.Date getYieldDate2() {
		return yieldDate2;
	}

	public void setYieldDate2(java.sql.Date yieldDate2) {
		this.yieldDate2 = yieldDate2;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public Integer getStats() {
		return stats;
	}

	public void setStats(Integer stats) {
		this.stats = stats;
	}

	public Integer getStats2() {
		return stats2;
	}

	public void setStats2(Integer stats2) {
		this.stats2 = stats2;
	}
}
