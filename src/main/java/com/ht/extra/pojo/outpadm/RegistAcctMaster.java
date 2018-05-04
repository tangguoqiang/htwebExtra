package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;
import java.util.Date;

public class RegistAcctMaster {
    private String acctNo;

    private String operatorNo;

    private Date acctDate;

    private BigDecimal registNum;

    private BigDecimal refundNum;

    private BigDecimal refundAmount;

    private BigDecimal totalCosts;

    private BigDecimal totalIncomes;

    private Date tallyDate;

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public Date getAcctDate() {
        return acctDate;
    }

    public void setAcctDate(Date acctDate) {
        this.acctDate = acctDate;
    }

    public BigDecimal getRegistNum() {
        return registNum;
    }

    public void setRegistNum(BigDecimal registNum) {
        this.registNum = registNum;
    }

    public BigDecimal getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(BigDecimal refundNum) {
        this.refundNum = refundNum;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(BigDecimal totalCosts) {
        this.totalCosts = totalCosts;
    }

    public BigDecimal getTotalIncomes() {
        return totalIncomes;
    }

    public void setTotalIncomes(BigDecimal totalIncomes) {
        this.totalIncomes = totalIncomes;
    }

    public Date getTallyDate() {
        return tallyDate;
    }

    public void setTallyDate(Date tallyDate) {
        this.tallyDate = tallyDate;
    }
}