package com.ht.extra.pojo.comm;

public class QaEventTypeDict {
    private String qaEventType;

    private Short serialNo;

    private String inputCode;

    public String getQaEventType() {
        return qaEventType;
    }

    public void setQaEventType(String qaEventType) {
        this.qaEventType = qaEventType == null ? null : qaEventType.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}