package com.ht.extra.pojo.outpdoct;

import java.util.Date;

public class OutpConsultationDetail extends OutpConsultationDetailKey {
    private String patientId;

    private String consultationDept;

    private String consultationDoctor;

    private Date applyDateTime;

    private String consultationIdea;

    private Date commitDateTime;

    private Short consultationCommit;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getConsultationDept() {
        return consultationDept;
    }

    public void setConsultationDept(String consultationDept) {
        this.consultationDept = consultationDept == null ? null : consultationDept.trim();
    }

    public String getConsultationDoctor() {
        return consultationDoctor;
    }

    public void setConsultationDoctor(String consultationDoctor) {
        this.consultationDoctor = consultationDoctor == null ? null : consultationDoctor.trim();
    }

    public Date getApplyDateTime() {
        return applyDateTime;
    }

    public void setApplyDateTime(Date applyDateTime) {
        this.applyDateTime = applyDateTime;
    }

    public String getConsultationIdea() {
        return consultationIdea;
    }

    public void setConsultationIdea(String consultationIdea) {
        this.consultationIdea = consultationIdea == null ? null : consultationIdea.trim();
    }

    public Date getCommitDateTime() {
        return commitDateTime;
    }

    public void setCommitDateTime(Date commitDateTime) {
        this.commitDateTime = commitDateTime;
    }

    public Short getConsultationCommit() {
        return consultationCommit;
    }

    public void setConsultationCommit(Short consultationCommit) {
        this.consultationCommit = consultationCommit;
    }
}