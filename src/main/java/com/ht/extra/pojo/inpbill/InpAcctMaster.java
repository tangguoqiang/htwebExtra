package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.util.Date;

public class InpAcctMaster {
    private String acctNo;

    private String operatorNo;

    private Date acctDate;

    private String minRcptNo;

    private String maxRcptNo;

    private Short rcptsNum;

    private Short freeOfChargeNum;

    private Short refundedNum;

    private Short invalidNum;

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

    public String getMinRcptNo() {
        return minRcptNo;
    }

    public void setMinRcptNo(String minRcptNo) {
        this.minRcptNo = minRcptNo == null ? null : minRcptNo.trim();
    }

    public String getMaxRcptNo() {
        return maxRcptNo;
    }

    public void setMaxRcptNo(String maxRcptNo) {
        this.maxRcptNo = maxRcptNo == null ? null : maxRcptNo.trim();
    }

    public Short getRcptsNum() {
        return rcptsNum;
    }

    public void setRcptsNum(Short rcptsNum) {
        this.rcptsNum = rcptsNum;
    }

    public Short getFreeOfChargeNum() {
        return freeOfChargeNum;
    }

    public void setFreeOfChargeNum(Short freeOfChargeNum) {
        this.freeOfChargeNum = freeOfChargeNum;
    }

    public Short getRefundedNum() {
        return refundedNum;
    }

    public void setRefundedNum(Short refundedNum) {
        this.refundedNum = refundedNum;
    }

    public Short getInvalidNum() {
        return invalidNum;
    }

    public void setInvalidNum(Short invalidNum) {
        this.invalidNum = invalidNum;
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