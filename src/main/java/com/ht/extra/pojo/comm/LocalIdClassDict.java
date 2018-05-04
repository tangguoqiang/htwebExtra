package com.ht.extra.pojo.comm;

public class LocalIdClassDict {
    private String localIdClassCode;

    private Short serialNo;

    private String localIdClassName;

    private String inputCode;

    public String getLocalIdClassCode() {
        return localIdClassCode;
    }

    public void setLocalIdClassCode(String localIdClassCode) {
        this.localIdClassCode = localIdClassCode == null ? null : localIdClassCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getLocalIdClassName() {
        return localIdClassName;
    }

    public void setLocalIdClassName(String localIdClassName) {
        this.localIdClassName = localIdClassName == null ? null : localIdClassName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}