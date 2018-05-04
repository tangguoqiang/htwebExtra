package com.ht.extra.pojo.medrec;

public class OperationKey {
    private String patientId;

    private Short visitId;

    private Short operationNo;

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

    public Short getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(Short operationNo) {
        this.operationNo = operationNo;
    }
}