package com.ht.extra.pojo.medrec;

import java.util.Date;

public class OutpMrRec {
    private String patientId;

    private Date mrCreateDate;

    private String outpMrType;

    private String location;

    private String mrStatus;

    private String outpNo;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Date getMrCreateDate() {
        return mrCreateDate;
    }

    public void setMrCreateDate(Date mrCreateDate) {
        this.mrCreateDate = mrCreateDate;
    }

    public String getOutpMrType() {
        return outpMrType;
    }

    public void setOutpMrType(String outpMrType) {
        this.outpMrType = outpMrType == null ? null : outpMrType.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getMrStatus() {
        return mrStatus;
    }

    public void setMrStatus(String mrStatus) {
        this.mrStatus = mrStatus == null ? null : mrStatus.trim();
    }

    public String getOutpNo() {
        return outpNo;
    }

    public void setOutpNo(String outpNo) {
        this.outpNo = outpNo == null ? null : outpNo.trim();
    }
}