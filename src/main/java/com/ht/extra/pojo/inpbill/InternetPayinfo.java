package com.ht.extra.pojo.inpbill;

import java.util.Date;

public class InternetPayinfo {
    private String tradeNo;

    private String recptNo;

    private String patientId;

    private Date changeDateTime;

    private String inoutFlag;

    private String payMethod;

    private String mchId;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getRecptNo() {
        return recptNo;
    }

    public void setRecptNo(String recptNo) {
        this.recptNo = recptNo == null ? null : recptNo.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Date getChangeDateTime() {
        return changeDateTime;
    }

    public void setChangeDateTime(Date changeDateTime) {
        this.changeDateTime = changeDateTime;
    }

    public String getInoutFlag() {
        return inoutFlag;
    }

    public void setInoutFlag(String inoutFlag) {
        this.inoutFlag = inoutFlag == null ? null : inoutFlag.trim();
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod == null ? null : payMethod.trim();
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId == null ? null : mchId.trim();
    }
}