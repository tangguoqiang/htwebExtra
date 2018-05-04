package com.ht.extra.pojo.outpadm;

import java.util.Date;

public class ClinicAppointsKey {
    private Date visitDateAppted;

    private String clinicLabel;

    private String patientId;

    private String visitTimeAppted;

    public Date getVisitDateAppted() {
        return visitDateAppted;
    }

    public void setVisitDateAppted(Date visitDateAppted) {
        this.visitDateAppted = visitDateAppted;
    }

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel == null ? null : clinicLabel.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getVisitTimeAppted() {
        return visitTimeAppted;
    }

    public void setVisitTimeAppted(String visitTimeAppted) {
        this.visitTimeAppted = visitTimeAppted == null ? null : visitTimeAppted.trim();
    }
}