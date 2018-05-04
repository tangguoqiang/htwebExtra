package com.ht.extra.pojo.comm;

public class BedClassDict {
    private String bedClassCode;

    private Short serialNo;

    private String bedClassName;

    private String inputCode;

    public String getBedClassCode() {
        return bedClassCode;
    }

    public void setBedClassCode(String bedClassCode) {
        this.bedClassCode = bedClassCode == null ? null : bedClassCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getBedClassName() {
        return bedClassName;
    }

    public void setBedClassName(String bedClassName) {
        this.bedClassName = bedClassName == null ? null : bedClassName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}