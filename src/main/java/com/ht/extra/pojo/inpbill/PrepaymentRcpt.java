package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class PrepaymentRcpt {
    private String rcptNo;

    private String patientId;

    private BigDecimal amount;

    private String payWay;

    private String bank;

    private String checkNo;

    private String transactType;

    private Timestamp transactDate;

    private String operatorNo;

    private String refundedRcptNo;

    private String acctNo;

    private String outpOrInp;

    private String superOperatorNo;

    private Short visitId;

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo == null ? null : checkNo.trim();
    }

    public String getTransactType() {
        return transactType;
    }

    public void setTransactType(String transactType) {
        this.transactType = transactType == null ? null : transactType.trim();
    }

    public Date getTransactDate() {
        return transactDate;
    }


    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getRefundedRcptNo() {
        return refundedRcptNo;
    }

    public void setRefundedRcptNo(String refundedRcptNo) {
        this.refundedRcptNo = refundedRcptNo == null ? null : refundedRcptNo.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getOutpOrInp() {
        return outpOrInp;
    }

    public void setOutpOrInp(String outpOrInp) {
        this.outpOrInp = outpOrInp == null ? null : outpOrInp.trim();
    }

    public String getSuperOperatorNo() {
        return superOperatorNo;
    }

    public void setSuperOperatorNo(String superOperatorNo) {
        this.superOperatorNo = superOperatorNo == null ? null : superOperatorNo.trim();
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public void setTransactDate(Timestamp transactDate) {
        this.transactDate = transactDate;
    }
}