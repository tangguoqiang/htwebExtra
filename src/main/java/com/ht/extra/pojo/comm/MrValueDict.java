package com.ht.extra.pojo.comm;

public class MrValueDict {
    private String mrValueName;

    private Short serialNo;

    private String mrValueCode;

    private String inputCode;

    public String getMrValueName() {
        return mrValueName;
    }

    public void setMrValueName(String mrValueName) {
        this.mrValueName = mrValueName == null ? null : mrValueName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getMrValueCode() {
        return mrValueCode;
    }

    public void setMrValueCode(String mrValueCode) {
        this.mrValueCode = mrValueCode == null ? null : mrValueCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}