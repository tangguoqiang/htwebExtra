package com.ht.extra.pojo.medrec;

public class MrFileIndexKey {
    private String patientId;

    private Short visitId;

    private Short fileNo;

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

    public Short getFileNo() {
        return fileNo;
    }

    public void setFileNo(Short fileNo) {
        this.fileNo = fileNo;
    }
}