package com.ht.extra.pojo.outpbill;

public class OutpOrderDescBack extends OutpOrderDescBackKey {
    private String patientId;

    private Short prescIndicator;

    private String orderedByDept;

    private String orderedByDoctor;

    private String rcptNo;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Short getPrescIndicator() {
        return prescIndicator;
    }

    public void setPrescIndicator(Short prescIndicator) {
        this.prescIndicator = prescIndicator;
    }

    public String getOrderedByDept() {
        return orderedByDept;
    }

    public void setOrderedByDept(String orderedByDept) {
        this.orderedByDept = orderedByDept == null ? null : orderedByDept.trim();
    }

    public String getOrderedByDoctor() {
        return orderedByDoctor;
    }

    public void setOrderedByDoctor(String orderedByDoctor) {
        this.orderedByDoctor = orderedByDoctor == null ? null : orderedByDoctor.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }
}