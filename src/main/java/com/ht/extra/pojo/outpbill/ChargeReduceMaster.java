package com.ht.extra.pojo.outpbill;

import java.math.BigDecimal;
import java.util.Date;

public class ChargeReduceMaster {
    private Integer serialNo;

    private String rcptNo;

    private String patientId;

    private Short visitId;

    private String name;

    private String chargeType;

    private String unit;

    private String cardNo;

    private BigDecimal reduceAmount;

    private String reduceCause;

    private String ratifier;

    private String undertaker;

    private String undertakerUnit;

    private String operNo;

    private String operName;

    private Date operDateTime;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public String getReduceCause() {
        return reduceCause;
    }

    public void setReduceCause(String reduceCause) {
        this.reduceCause = reduceCause == null ? null : reduceCause.trim();
    }

    public String getRatifier() {
        return ratifier;
    }

    public void setRatifier(String ratifier) {
        this.ratifier = ratifier == null ? null : ratifier.trim();
    }

    public String getUndertaker() {
        return undertaker;
    }

    public void setUndertaker(String undertaker) {
        this.undertaker = undertaker == null ? null : undertaker.trim();
    }

    public String getUndertakerUnit() {
        return undertakerUnit;
    }

    public void setUndertakerUnit(String undertakerUnit) {
        this.undertakerUnit = undertakerUnit == null ? null : undertakerUnit.trim();
    }

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo == null ? null : operNo.trim();
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public Date getOperDateTime() {
        return operDateTime;
    }

    public void setOperDateTime(Date operDateTime) {
        this.operDateTime = operDateTime;
    }
}