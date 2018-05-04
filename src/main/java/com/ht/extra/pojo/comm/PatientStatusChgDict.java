package com.ht.extra.pojo.comm;

public class PatientStatusChgDict {
    private String patientStatusChgCode;

    private Short serialNo;

    private String patientStatusChgName;

    private String inputCode;

    public String getPatientStatusChgCode() {
        return patientStatusChgCode;
    }

    public void setPatientStatusChgCode(String patientStatusChgCode) {
        this.patientStatusChgCode = patientStatusChgCode == null ? null : patientStatusChgCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatientStatusChgName() {
        return patientStatusChgName;
    }

    public void setPatientStatusChgName(String patientStatusChgName) {
        this.patientStatusChgName = patientStatusChgName == null ? null : patientStatusChgName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}