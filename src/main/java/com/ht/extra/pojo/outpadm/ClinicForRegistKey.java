package com.ht.extra.pojo.outpadm;

import java.util.Date;

public class ClinicForRegistKey {
    private Date clinicDate;

    private String clinicLabel;

    private String timeDesc;

    public Date getClinicDate() {
        return clinicDate;
    }

    public void setClinicDate(Date clinicDate) {
        this.clinicDate = clinicDate;
    }

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel == null ? null : clinicLabel.trim();
    }

    public String getTimeDesc() {
        return timeDesc;
    }

    public void setTimeDesc(String timeDesc) {
        this.timeDesc = timeDesc == null ? null : timeDesc.trim();
    }
}