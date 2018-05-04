package com.ht.extra.pojo.comm;

public class SettleTransTypeDict {
    private String transactTypeCode;

    private Short serialNo;

    private String transactTypeName;

    private String inputCode;

    public String getTransactTypeCode() {
        return transactTypeCode;
    }

    public void setTransactTypeCode(String transactTypeCode) {
        this.transactTypeCode = transactTypeCode == null ? null : transactTypeCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getTransactTypeName() {
        return transactTypeName;
    }

    public void setTransactTypeName(String transactTypeName) {
        this.transactTypeName = transactTypeName == null ? null : transactTypeName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}