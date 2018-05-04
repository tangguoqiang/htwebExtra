package com.ht.extra.pojo.outpdoct;

public class TreatProjectMaster {
    private String treatProjectId;

    private String title;

    private String deptCode;

    private String diagnosis;

    private String illnessDesc;

    private String medHistory;

    private String bodyExam;

    private String advice;

    private String creator;

    public String getTreatProjectId() {
        return treatProjectId;
    }

    public void setTreatProjectId(String treatProjectId) {
        this.treatProjectId = treatProjectId == null ? null : treatProjectId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc == null ? null : illnessDesc.trim();
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

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }
}