package com.hlwxy.xr_piece.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
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

    private String accountingDate;
    //日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
	private String billDate;
	//审核人
	private String auditor;
	//审核日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
	private Date auditDate;

   
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

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
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

    @Override
    public String toString() {
        return "WagesHeaderDO{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", accountingDate=" + accountingDate +
                ", billDate=" + billDate +
                ", auditor='" + auditor + '\'' +
                ", auditDate=" + auditDate +
                '}';
    }
}
