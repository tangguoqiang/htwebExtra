package com.ht.extra.pojo.comm;

public class CheckLabelDict {
    private String checkLabelCode;

    private Short serialNo;

    private String checkLabelName;

    private String inputCode;

    public String getCheckLabelCode() {
        return checkLabelCode;
    }

    public void setCheckLabelCode(String checkLabelCode) {
        this.checkLabelCode = checkLabelCode == null ? null : checkLabelCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getCheckLabelName() {
        return checkLabelName;
    }

    public void setCheckLabelName(String checkLabelName) {
        this.checkLabelName = checkLabelName == null ? null : checkLabelName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}