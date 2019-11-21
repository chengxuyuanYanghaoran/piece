package com.hlwxy.xr_piece.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;


/**
 * 金额统计表返回封装
 */
public class ReturnDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//封装金额
	private BigDecimal moneys;
	//封装人员
    private String peoples;
    //核算期间
    private Date accDatas;
    //页面显示的期间
    private String accDataStr;

    public ReturnDO() {
    }

    public ReturnDO(BigDecimal moneys, String peoples, Date accDatas, String accDataStr) {
        this.moneys = moneys;
        this.peoples = peoples;
        this.accDatas = accDatas;
        this.accDataStr = accDataStr;
    }

    public String getAccDataStr() {
        return accDataStr;
    }

    public void setAccDataStr(String accDataStr) {
        this.accDataStr = accDataStr;
    }

    public BigDecimal getMoneys() {
        return moneys;
    }

    public void setMoneys(BigDecimal moneys) {
        this.moneys = moneys;
    }

    public String getPeoples() {
        return peoples;
    }

    public void setPeoples(String peoples) {
        this.peoples = peoples;
    }

    public Date getAccDatas() {
        return accDatas;
    }

    public void setAccDatas(Date accDatas) {
        this.accDatas = accDatas;
    }
}
