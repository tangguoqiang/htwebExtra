package com.ht.extra.pojo.inpbill;

import java.util.Date;

public class NeedBillingPats {
    private String patientId;

    private Short visitId;

    private Date billingDateTime;

    private Short billedIndicator;

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

    public Date getBillingDateTime() {
        return billingDateTime;
    }

    public void setBillingDateTime(Date billingDateTime) {
        this.billingDateTime = billingDateTime;
    }

    public Short getBilledIndicator() {
        return billedIndicator;
    }

    public void setBilledIndicator(Short billedIndicator) {
        this.billedIndicator = billedIndicator;
    }
}