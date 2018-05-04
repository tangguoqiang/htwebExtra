package com.ht.extra.pojo.medrec;

import java.util.Date;

public class MrOnLine extends MrOnLineKey {
    private String status;

    private String requestDoctorId;

    private Date requestDateTime;

    private String parentDoctorId;

    private String superDoctorId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRequestDoctorId() {
        return requestDoctorId;
    }

    public void setRequestDoctorId(String requestDoctorId) {
        this.requestDoctorId = requestDoctorId == null ? null : requestDoctorId.trim();
    }

    public Date getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(Date requestDateTime) {
        this.requestDateTime = requestDateTime;
    }

    public String getParentDoctorId() {
        return parentDoctorId;
    }

    public void setParentDoctorId(String parentDoctorId) {
        this.parentDoctorId = parentDoctorId == null ? null : parentDoctorId.trim();
    }

    public String getSuperDoctorId() {
        return superDoctorId;
    }

    public void setSuperDoctorId(String superDoctorId) {
        this.superDoctorId = superDoctorId == null ? null : superDoctorId.trim();
    }
}