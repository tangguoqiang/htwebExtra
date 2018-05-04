package com.ht.extra.pojo.comm;

public class OperationScaleDict {
    private String operationScaleCode;

    private Short serialNo;

    private String operationScaleName;

    private String inputCode;

    public String getOperationScaleCode() {
        return operationScaleCode;
    }

    public void setOperationScaleCode(String operationScaleCode) {
        this.operationScaleCode = operationScaleCode == null ? null : operationScaleCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getOperationScaleName() {
        return operationScaleName;
    }

    public void setOperationScaleName(String operationScaleName) {
        this.operationScaleName = operationScaleName == null ? null : operationScaleName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}