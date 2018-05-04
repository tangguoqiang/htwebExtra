package com.ht.extra.pojo.comm;

public class PatAdmConditionDict {
    private String patConditionCode;

    private Short serialNo;

    private String patConditionName;

    private String inputCode;

    public String getPatConditionCode() {
        return patConditionCode;
    }

    public void setPatConditionCode(String patConditionCode) {
        this.patConditionCode = patConditionCode == null ? null : patConditionCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatConditionName() {
        return patConditionName;
    }

    public void setPatConditionName(String patConditionName) {
        this.patConditionName = patConditionName == null ? null : patConditionName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}