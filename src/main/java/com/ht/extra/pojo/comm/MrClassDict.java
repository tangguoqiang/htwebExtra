package com.ht.extra.pojo.comm;

public class MrClassDict {
    private String mrClassCode;

    private Short serialNo;

    private String mrClassName;

    private String mrNoName;

    private String inputCode;

    public String getMrClassCode() {
        return mrClassCode;
    }

    public void setMrClassCode(String mrClassCode) {
        this.mrClassCode = mrClassCode == null ? null : mrClassCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getMrClassName() {
        return mrClassName;
    }

    public void setMrClassName(String mrClassName) {
        this.mrClassName = mrClassName == null ? null : mrClassName.trim();
    }

    public String getMrNoName() {
        return mrNoName;
    }

    public void setMrNoName(String mrNoName) {
        this.mrNoName = mrNoName == null ? null : mrNoName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}