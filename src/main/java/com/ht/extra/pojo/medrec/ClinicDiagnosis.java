package com.ht.extra.pojo.medrec;

import java.util.Date;

public class ClinicDiagnosis {
    private String patientId;

    private Short visitId;

    private Short diagnosisNo;

    private String diagnosisDesc;

    private Date diagnosisDate;

    private Short treatDays;

    private String treatResult;

    private Short operTreatIndicator;

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

    public Short getDiagnosisNo() {
        return diagnosisNo;
    }

    public void setDiagnosisNo(Short diagnosisNo) {
        this.diagnosisNo = diagnosisNo;
    }

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc == null ? null : diagnosisDesc.trim();
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public Short getTreatDays() {
        return treatDays;
    }

    public void setTreatDays(Short treatDays) {
        this.treatDays = treatDays;
    }

    public String getTreatResult() {
        return treatResult;
    }

    public void setTreatResult(String treatResult) {
        this.treatResult = treatResult == null ? null : treatResult.trim();
    }

    public Short getOperTreatIndicator() {
        return operTreatIndicator;
    }

    public void setOperTreatIndicator(Short operTreatIndicator) {
        this.operTreatIndicator = operTreatIndicator;
    }
}