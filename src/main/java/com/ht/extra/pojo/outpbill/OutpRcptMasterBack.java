package com.ht.extra.pojo.outpbill;

import java.math.BigDecimal;
import java.util.Date;

public class OutpRcptMasterBack {
    private String rcptNo;

    private String patientId;

    private String name;

    private String namePhonetic;

    private String identity;

    private String chargeType;

    private String unitInContract;

    private Date visitDate;

    private BigDecimal totalCosts;

    private BigDecimal totalCharges;

    private String operatorNo;

    private Short chargeIndicator;

    private String refundedRcptNo;

    private String acctNo;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNamePhonetic() {
        return namePhonetic;
    }

    public void setNamePhonetic(String namePhonetic) {
        this.namePhonetic = namePhonetic == null ? null : namePhonetic.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getUnitInContract() {
        return unitInContract;
    }

    public void setUnitInContract(String unitInContract) {
        this.unitInContract = unitInContract == null ? null : unitInContract.trim();
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public BigDecimal getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(BigDecimal totalCosts) {
        this.totalCosts = totalCosts;
    }

    public BigDecimal getTotalCharges() {
        return totalCharges;
    }

    public void setTotalCharges(BigDecimal totalCharges) {
        this.totalCharges = totalCharges;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public Short getChargeIndicator() {
        return chargeIndicator;
    }

    public void setChargeIndicator(Short chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
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
}