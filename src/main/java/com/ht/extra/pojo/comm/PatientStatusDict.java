package com.ht.extra.pojo.comm;

public class PatientStatusDict {
    private String patientStatusCode;

    private Short serialNo;

    private String patientStatusName;

    private String inputCode;

    public String getPatientStatusCode() {
        return patientStatusCode;
    }

    public void setPatientStatusCode(String patientStatusCode) {
        this.patientStatusCode = patientStatusCode == null ? null : patientStatusCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatientStatusName() {
        return patientStatusName;
    }

    public void setPatientStatusName(String patientStatusName) {
        this.patientStatusName = patientStatusName == null ? null : patientStatusName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}