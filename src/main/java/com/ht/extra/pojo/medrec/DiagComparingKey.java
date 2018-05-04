package com.ht.extra.pojo.medrec;

public class DiagComparingKey {
    private String patientId;

    private Short visitId;

    private String diagCompareGroup;

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

    public String getDiagCompareGroup() {
        return diagCompareGroup;
    }

    public void setDiagCompareGroup(String diagCompareGroup) {
        this.diagCompareGroup = diagCompareGroup == null ? null : diagCompareGroup.trim();
    }
}