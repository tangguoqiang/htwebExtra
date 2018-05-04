package com.ht.extra.pojo.comm;

public class AdmissionCauseDict {
    private String admissionCauseName;

    private Short serialNo;

    private String admissionCauseCode;

    private String inputCode;

    public String getAdmissionCauseName() {
        return admissionCauseName;
    }

    public void setAdmissionCauseName(String admissionCauseName) {
        this.admissionCauseName = admissionCauseName == null ? null : admissionCauseName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getAdmissionCauseCode() {
        return admissionCauseCode;
    }

    public void setAdmissionCauseCode(String admissionCauseCode) {
        this.admissionCauseCode = admissionCauseCode == null ? null : admissionCauseCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}