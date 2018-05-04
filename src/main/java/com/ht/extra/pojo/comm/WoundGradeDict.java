package com.ht.extra.pojo.comm;

public class WoundGradeDict {
    private String woundGradeCode;

    private Short serialNo;

    private String woundGradeName;

    private String inputCode;

    public String getWoundGradeCode() {
        return woundGradeCode;
    }

    public void setWoundGradeCode(String woundGradeCode) {
        this.woundGradeCode = woundGradeCode == null ? null : woundGradeCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getWoundGradeName() {
        return woundGradeName;
    }

    public void setWoundGradeName(String woundGradeName) {
        this.woundGradeName = woundGradeName == null ? null : woundGradeName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}