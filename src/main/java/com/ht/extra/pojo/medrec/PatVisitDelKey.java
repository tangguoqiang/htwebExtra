package com.ht.extra.pojo.medrec;

import java.util.Date;

public class PatVisitDelKey {
    private String patientId;

    private Short visitId;

    private Date delDateTime;

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

    public Date getDelDateTime() {
        return delDateTime;
    }

    public void setDelDateTime(Date delDateTime) {
        this.delDateTime = delDateTime;
    }
}