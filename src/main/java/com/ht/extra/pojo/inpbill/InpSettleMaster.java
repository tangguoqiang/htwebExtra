package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.util.Date;

public class InpSettleMaster {
    private String rcptNo;

    private String patientId;

    private Short visitId;

    private Date settlingDate;

    private BigDecimal costs;

    private BigDecimal charges;

    private BigDecimal payments;

    private String reducedCause;

    private String transactType;

    private String refundedRcptNo;

    private String operatorNo;

    private String acctNo;

    private String insurRcptNo;

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

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public Date getSettlingDate() {
        return settlingDate;
    }

    public void setSettlingDate(Date settlingDate) {
        this.settlingDate = settlingDate;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public BigDecimal getPayments() {
        return payments;
    }

    public void setPayments(BigDecimal payments) {
        this.payments = payments;
    }

    public String getReducedCause() {
        return reducedCause;
    }

    public void setReducedCause(String reducedCause) {
        this.reducedCause = reducedCause == null ? null : reducedCause.trim();
    }

    public String getTransactType() {
        return transactType;
    }

    public void setTransactType(String transactType) {
        this.transactType = transactType == null ? null : transactType.trim();
    }

    public String getRefundedRcptNo() {
        return refundedRcptNo;
    }

    public void setRefundedRcptNo(String refundedRcptNo) {
        this.refundedRcptNo = refundedRcptNo == null ? null : refundedRcptNo.trim();
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getInsurRcptNo() {
        return insurRcptNo;
    }

    public void setInsurRcptNo(String insurRcptNo) {
        this.insurRcptNo = insurRcptNo == null ? null : insurRcptNo.trim();
    }
}