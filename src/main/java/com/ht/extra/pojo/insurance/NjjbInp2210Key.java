package com.ht.extra.pojo.insurance;

public class NjjbInp2210Key {
    private String patientId;

    private Integer visitId;

    private String inName1;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getInName1() {
        return inName1;
    }

    public void setInName1(String inName1) {
        this.inName1 = inName1 == null ? null : inName1.trim();
    }
}