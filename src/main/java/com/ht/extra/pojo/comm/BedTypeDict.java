package com.ht.extra.pojo.comm;

public class BedTypeDict {
    private String bedTypeCode;

    private Short serialNo;

    private String bedTypeName;

    private String inputCode;

    public String getBedTypeCode() {
        return bedTypeCode;
    }

    public void setBedTypeCode(String bedTypeCode) {
        this.bedTypeCode = bedTypeCode == null ? null : bedTypeCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getBedTypeName() {
        return bedTypeName;
    }

    public void setBedTypeName(String bedTypeName) {
        this.bedTypeName = bedTypeName == null ? null : bedTypeName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}