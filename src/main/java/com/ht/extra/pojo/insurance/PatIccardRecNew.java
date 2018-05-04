package com.ht.extra.pojo.insurance;

import java.util.Date;

public class PatIccardRecNew {
    private String iccardNo;

    private String patientId;

    private Date regDatetime;

    public String getIccardNo() {
        return iccardNo;
    }

    public void setIccardNo(String iccardNo) {
        this.iccardNo = iccardNo == null ? null : iccardNo.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Date getRegDatetime() {
        return regDatetime;
    }

    public void setRegDatetime(Date regDatetime) {
        this.regDatetime = regDatetime;
    }
}