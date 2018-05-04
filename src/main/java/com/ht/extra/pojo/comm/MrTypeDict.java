package com.ht.extra.pojo.comm;

public class MrTypeDict {
    private String mrTypeCode;

    private Short serialNo;

    private String mrTypeName;

    private String inputCode;

    public String getMrTypeCode() {
        return mrTypeCode;
    }

    public void setMrTypeCode(String mrTypeCode) {
        this.mrTypeCode = mrTypeCode == null ? null : mrTypeCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getMrTypeName() {
        return mrTypeName;
    }

    public void setMrTypeName(String mrTypeName) {
        this.mrTypeName = mrTypeName == null ? null : mrTypeName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}