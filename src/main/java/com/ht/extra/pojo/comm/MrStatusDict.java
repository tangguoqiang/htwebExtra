package com.ht.extra.pojo.comm;

public class MrStatusDict {
    private String mrStatusCode;

    private Short serialNo;

    private String mrStatusName;

    private String inputCode;

    public String getMrStatusCode() {
        return mrStatusCode;
    }

    public void setMrStatusCode(String mrStatusCode) {
        this.mrStatusCode = mrStatusCode == null ? null : mrStatusCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getMrStatusName() {
        return mrStatusName;
    }

    public void setMrStatusName(String mrStatusName) {
        this.mrStatusName = mrStatusName == null ? null : mrStatusName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}