package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 工资核算表，表头
 */
public class WagesHeaderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//单据编号
	private String billCode;
	//核算期间
	private Date billDate;
	//审核人
	private String auditor;
	//审核日期
	private Date auditDate;

    public WagesHeaderDO() {
    }

    public WagesHeaderDO(Integer id, String billCode, Date billDate, String auditor, Date auditDate) {
        this.id = id;
        this.billCode = billCode;
        this.billDate = billDate;
        this.auditor = auditor;
        this.auditDate = auditDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
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
}
