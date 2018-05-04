package com.ht.extra.pojo.comm;

public class PatientSourceDict {
    private String patientSourceCode;

    private Short serialNo;

    private String patientSourceName;

    private String inputCode;

    public String getPatientSourceCode() {
        return patientSourceCode;
    }

    public void setPatientSourceCode(String patientSourceCode) {
        this.patientSourceCode = patientSourceCode == null ? null : patientSourceCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatientSourceName() {
        return patientSourceName;
    }

    public void setPatientSourceName(String patientSourceName) {
        this.patientSourceName = patientSourceName == null ? null : patientSourceName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}