package com.ht.extra.pojo.inpadm;

import java.util.Date;

public class MedicalQcMsgKey {
    private String patientId;

    private Short visitId;

    private String qcMsgCode;

    private Date issuedDateTime;

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

    public String getQcMsgCode() {
        return qcMsgCode;
    }

    public void setQcMsgCode(String qcMsgCode) {
        this.qcMsgCode = qcMsgCode == null ? null : qcMsgCode.trim();
    }

    public Date getIssuedDateTime() {
        return issuedDateTime;
    }

    public void setIssuedDateTime(Date issuedDateTime) {
        this.issuedDateTime = issuedDateTime;
    }
}