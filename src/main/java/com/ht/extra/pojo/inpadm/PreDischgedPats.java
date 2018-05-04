package com.ht.extra.pojo.inpadm;

import java.util.Date;

public class PreDischgedPats {
    private String patientId;

    private Date dischargeDateExpcted;

    private Date createDateTime;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Date getDischargeDateExpcted() {
        return dischargeDateExpcted;
    }

    public void setDischargeDateExpcted(Date dischargeDateExpcted) {
        this.dischargeDateExpcted = dischargeDateExpcted;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}