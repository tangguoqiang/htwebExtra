package com.ht.extra.pojo.comm;

public class PatientClassDict {
    private String patientClassCode;

    private Short serialNo;

    private String patientClassName;

    private String inputCode;

    public String getPatientClassCode() {
        return patientClassCode;
    }

    public void setPatientClassCode(String patientClassCode) {
        this.patientClassCode = patientClassCode == null ? null : patientClassCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatientClassName() {
        return patientClassName;
    }

    public void setPatientClassName(String patientClassName) {
        this.patientClassName = patientClassName == null ? null : patientClassName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}