package com.ht.extra.pojo.outpdoct;

public class OutpMr extends OutpMrKey {
    private String patientId;

    private String illnessDesc;

    private String anamnesis;

    private String familyIll;

    private String marrital;

    private String individual;

    private String menses;

    private String medHistory;

    private String bodyExam;

    private String diagDesc;

    private String advice;

    private String doctor;

    private String operationRecord;

    private String medicalRecord;

    private String diagCode;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc == null ? null : illnessDesc.trim();
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis == null ? null : anamnesis.trim();
    }

    public String getFamilyIll() {
        return familyIll;
    }

    public void setFamilyIll(String familyIll) {
        this.familyIll = familyIll == null ? null : familyIll.trim();
    }

    public String getMarrital() {
        return marrital;
    }

    public void setMarrital(String marrital) {
        this.marrital = marrital == null ? null : marrital.trim();
    }

    public String getIndividual() {
        return individual;
    }

    public void setIndividual(String individual) {
        this.individual = individual == null ? null : individual.trim();
    }

    public String getMenses() {
        return menses;
    }

    public void setMenses(String menses) {
        this.menses = menses == null ? null : menses.trim();
    }

    public String getMedHistory() {
        return medHistory;
    }

    public void setMedHistory(String medHistory) {
        this.medHistory = medHistory == null ? null : medHistory.trim();
    }

    public String getBodyExam() {
        return bodyExam;
    }

    public void setBodyExam(String bodyExam) {
        this.bodyExam = bodyExam == null ? null : bodyExam.trim();
    }

    public String getDiagDesc() {
        return diagDesc;
    }

    public void setDiagDesc(String diagDesc) {
        this.diagDesc = diagDesc == null ? null : diagDesc.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getOperationRecord() {
        return operationRecord;
    }

    public void setOperationRecord(String operationRecord) {
        this.operationRecord = operationRecord == null ? null : operationRecord.trim();
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public String getDiagCode() {
        return diagCode;
    }

    public void setDiagCode(String diagCode) {
        this.diagCode = diagCode == null ? null : diagCode.trim();
    }
}