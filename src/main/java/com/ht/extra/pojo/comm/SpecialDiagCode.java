package com.ht.extra.pojo.comm;

public class SpecialDiagCode {
    private String specialDiagName;

    private Short serialNo;

    private String specialDiagCode;

    private String inputCode;

    private String insurType;

    public String getSpecialDiagName() {
        return specialDiagName;
    }

    public void setSpecialDiagName(String specialDiagName) {
        this.specialDiagName = specialDiagName == null ? null : specialDiagName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getSpecialDiagCode() {
        return specialDiagCode;
    }

    public void setSpecialDiagCode(String specialDiagCode) {
        this.specialDiagCode = specialDiagCode == null ? null : specialDiagCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getInsurType() {
        return insurType;
    }

    public void setInsurType(String insurType) {
        this.insurType = insurType == null ? null : insurType.trim();
    }
}