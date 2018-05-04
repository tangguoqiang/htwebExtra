package com.ht.extra.pojo.medrec;

import java.util.Date;

public class InpMrRec {
    private String patientId;

    private String inpNo;

    private String inpMrType;

    private String location;

    private Date mrCreateDate;

    private String mrStatus;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
    }

    public String getInpMrType() {
        return inpMrType;
    }

    public void setInpMrType(String inpMrType) {
        this.inpMrType = inpMrType == null ? null : inpMrType.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getMrCreateDate() {
        return mrCreateDate;
    }

    public void setMrCreateDate(Date mrCreateDate) {
        this.mrCreateDate = mrCreateDate;
    }

    public String getMrStatus() {
        return mrStatus;
    }

    public void setMrStatus(String mrStatus) {
        this.mrStatus = mrStatus == null ? null : mrStatus.trim();
    }
}