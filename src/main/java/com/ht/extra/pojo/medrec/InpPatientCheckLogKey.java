package com.ht.extra.pojo.medrec;

public class InpPatientCheckLogKey {
    private String patientId;

    private Short visitId;

    private Short sNo;

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

    public Short getsNo() {
        return sNo;
    }

    public void setsNo(Short sNo) {
        this.sNo = sNo;
    }
}