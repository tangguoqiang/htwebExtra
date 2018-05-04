package com.ht.extra.pojo.comm;

public class MrFeeClassDict {
    private String mrFeeClassCode;

    private Short serialNo;

    private String mrFeeClassName;

    private String inputCode;

    public String getMrFeeClassCode() {
        return mrFeeClassCode;
    }

    public void setMrFeeClassCode(String mrFeeClassCode) {
        this.mrFeeClassCode = mrFeeClassCode == null ? null : mrFeeClassCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getMrFeeClassName() {
        return mrFeeClassName;
    }

    public void setMrFeeClassName(String mrFeeClassName) {
        this.mrFeeClassName = mrFeeClassName == null ? null : mrFeeClassName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}