package com.ht.extra.pojo.comm;

public class AnaesthesiaDict {
    private String anaesthesiaName;

    private Short serialNo;

    private String anaesthesiaCode;

    private String inputCode;

    public String getAnaesthesiaName() {
        return anaesthesiaName;
    }

    public void setAnaesthesiaName(String anaesthesiaName) {
        this.anaesthesiaName = anaesthesiaName == null ? null : anaesthesiaName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getAnaesthesiaCode() {
        return anaesthesiaCode;
    }

    public void setAnaesthesiaCode(String anaesthesiaCode) {
        this.anaesthesiaCode = anaesthesiaCode == null ? null : anaesthesiaCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}