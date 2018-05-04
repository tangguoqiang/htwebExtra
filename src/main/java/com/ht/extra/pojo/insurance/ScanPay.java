package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;
import java.util.Date;

public class ScanPay {
    private BigDecimal id;

    private String ipAddr;

    private String userId;

    private String patientName;

    private String authCode;

    private String operaterId;

    private String patientId;

    private String clinicLabel;

    private Date visitDate;

    private String amPm;

    private String totalCosts;

    private String chargeType;

    private String payWay;

    private String hospitalMark;

    private String trandeNo;

    private String rcptNo;

    private String resultComment;

    private String origTradeNo;

    private Short visitId;

    private String operDate;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode == null ? null : authCode.trim();
    }

    public String getOperaterId() {
        return operaterId;
    }

    public void setOperaterId(String operaterId) {
        this.operaterId = operaterId == null ? null : operaterId.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel == null ? null : clinicLabel.trim();
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getAmPm() {
        return amPm;
    }

    public void setAmPm(String amPm) {
        this.amPm = amPm == null ? null : amPm.trim();
    }

    public String getTotalCosts() {
        return totalCosts;
    }

    public void setTotalCosts(String totalCosts) {
        this.totalCosts = totalCosts == null ? null : totalCosts.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public String getHospitalMark() {
        return hospitalMark;
    }

    public void setHospitalMark(String hospitalMark) {
        this.hospitalMark = hospitalMark == null ? null : hospitalMark.trim();
    }

    public String getTrandeNo() {
        return trandeNo;
    }

    public void setTrandeNo(String trandeNo) {
        this.trandeNo = trandeNo == null ? null : trandeNo.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getResultComment() {
        return resultComment;
    }

    public void setResultComment(String resultComment) {
        this.resultComment = resultComment == null ? null : resultComment.trim();
    }

    public String getOrigTradeNo() {
        return origTradeNo;
    }

    public void setOrigTradeNo(String origTradeNo) {
        this.origTradeNo = origTradeNo == null ? null : origTradeNo.trim();
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public String getOperDate() {
        return operDate;
    }

    public void setOperDate(String operDate) {
        this.operDate = operDate == null ? null : operDate.trim();
    }
}