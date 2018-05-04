package com.ht.extra.pojo.insurance;

public class InsuOutpClinicMaster extends InsuOutpClinicMasterKey {
    private String insuCardNo;

    private String patientId;

    private String orderedByDoctorCode;

    private String orderedByDoctor;

    private String diagnosisCode;

    private String diagnosisName;

    private String visitDeptInsuCode;

    private String visitDeptInsuName;

    private String operatorNo;

    private String rcptNo;

    private String insuType;

    private String refundedRcptNo;

    private String deptCode;

    private String deptName;

    public String getInsuCardNo() {
        return insuCardNo;
    }

    public void setInsuCardNo(String insuCardNo) {
        this.insuCardNo = insuCardNo == null ? null : insuCardNo.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getOrderedByDoctorCode() {
        return orderedByDoctorCode;
    }

    public void setOrderedByDoctorCode(String orderedByDoctorCode) {
        this.orderedByDoctorCode = orderedByDoctorCode == null ? null : orderedByDoctorCode.trim();
    }

    public String getOrderedByDoctor() {
        return orderedByDoctor;
    }

    public void setOrderedByDoctor(String orderedByDoctor) {
        this.orderedByDoctor = orderedByDoctor == null ? null : orderedByDoctor.trim();
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode == null ? null : diagnosisCode.trim();
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName == null ? null : diagnosisName.trim();
    }

    public String getVisitDeptInsuCode() {
        return visitDeptInsuCode;
    }

    public void setVisitDeptInsuCode(String visitDeptInsuCode) {
        this.visitDeptInsuCode = visitDeptInsuCode == null ? null : visitDeptInsuCode.trim();
    }

    public String getVisitDeptInsuName() {
        return visitDeptInsuName;
    }

    public void setVisitDeptInsuName(String visitDeptInsuName) {
        this.visitDeptInsuName = visitDeptInsuName == null ? null : visitDeptInsuName.trim();
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getInsuType() {
        return insuType;
    }

    public void setInsuType(String insuType) {
        this.insuType = insuType == null ? null : insuType.trim();
    }

    public String getRefundedRcptNo() {
        return refundedRcptNo;
    }

    public void setRefundedRcptNo(String refundedRcptNo) {
        this.refundedRcptNo = refundedRcptNo == null ? null : refundedRcptNo.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}