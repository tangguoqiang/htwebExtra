package com.ht.extra.pojo.comm;

public class OutpRcptFeeDict {
    private String feeClassCode;

    private Short serialNo;

    private String feeClassName;

    private String inputCode;

    public String getFeeClassCode() {
        return feeClassCode;
    }

    public void setFeeClassCode(String feeClassCode) {
        this.feeClassCode = feeClassCode == null ? null : feeClassCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getFeeClassName() {
        return feeClassName;
    }

    public void setFeeClassName(String feeClassName) {
        this.feeClassName = feeClassName == null ? null : feeClassName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}