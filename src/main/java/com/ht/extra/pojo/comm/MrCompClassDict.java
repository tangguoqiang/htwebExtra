package com.ht.extra.pojo.comm;

public class MrCompClassDict {
    private String compClass;

    private Short serialNo;

    private String compName;

    private String inputCode;

    public String getCompClass() {
        return compClass;
    }

    public void setCompClass(String compClass) {
        this.compClass = compClass == null ? null : compClass.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}