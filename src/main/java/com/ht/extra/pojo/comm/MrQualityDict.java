package com.ht.extra.pojo.comm;

public class MrQualityDict {
    private String mrQualityName;

    private Short serialNo;

    private String mrQualityCode;

    private String inputCode;

    public String getMrQualityName() {
        return mrQualityName;
    }

    public void setMrQualityName(String mrQualityName) {
        this.mrQualityName = mrQualityName == null ? null : mrQualityName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getMrQualityCode() {
        return mrQualityCode;
    }

    public void setMrQualityCode(String mrQualityCode) {
        this.mrQualityCode = mrQualityCode == null ? null : mrQualityCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}