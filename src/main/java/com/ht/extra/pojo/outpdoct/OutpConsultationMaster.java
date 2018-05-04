package com.ht.extra.pojo.outpdoct;

import java.util.Date;

public class OutpConsultationMaster extends OutpConsultationMasterKey {
    private String patientId;

    private Short consultationType;

    private String consultationExplain;

    private Date applyDateTime;

    private Date endDateTime;

    private String consultationApplyDoctor;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Short getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(Short consultationType) {
        this.consultationType = consultationType;
    }

    public String getConsultationExplain() {
        return consultationExplain;
    }

    public void setConsultationExplain(String consultationExplain) {
        this.consultationExplain = consultationExplain == null ? null : consultationExplain.trim();
    }

    public Date getApplyDateTime() {
        return applyDateTime;
    }

    public void setApplyDateTime(Date applyDateTime) {
        this.applyDateTime = applyDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getConsultationApplyDoctor() {
        return consultationApplyDoctor;
    }

    public void setConsultationApplyDoctor(String consultationApplyDoctor) {
        this.consultationApplyDoctor = consultationApplyDoctor == null ? null : consultationApplyDoctor.trim();
    }
}