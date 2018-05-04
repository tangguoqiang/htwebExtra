package com.ht.extra.pojo.comm;

public class SpecialManDict {
    private String manName;

    private Short serialNo;

    private String manCode;

    private String inputCode;

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName == null ? null : manName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getManCode() {
        return manCode;
    }

    public void setManCode(String manCode) {
        this.manCode = manCode == null ? null : manCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}