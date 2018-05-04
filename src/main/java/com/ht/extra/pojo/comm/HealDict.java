package com.ht.extra.pojo.comm;

public class HealDict {
    private String healName;

    private Short serialNo;

    private String healCode;

    private String inputCode;

    public String getHealName() {
        return healName;
    }

    public void setHealName(String healName) {
        this.healName = healName == null ? null : healName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getHealCode() {
        return healCode;
    }

    public void setHealCode(String healCode) {
        this.healCode = healCode == null ? null : healCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}