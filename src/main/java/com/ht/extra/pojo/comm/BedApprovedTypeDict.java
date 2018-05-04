package com.ht.extra.pojo.comm;

public class BedApprovedTypeDict {
    private String bedApprovedTypeCode;

    private Short serialNo;

    private String bedApprovedTypeName;

    private String inputCode;

    public String getBedApprovedTypeCode() {
        return bedApprovedTypeCode;
    }

    public void setBedApprovedTypeCode(String bedApprovedTypeCode) {
        this.bedApprovedTypeCode = bedApprovedTypeCode == null ? null : bedApprovedTypeCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getBedApprovedTypeName() {
        return bedApprovedTypeName;
    }

    public void setBedApprovedTypeName(String bedApprovedTypeName) {
        this.bedApprovedTypeName = bedApprovedTypeName == null ? null : bedApprovedTypeName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}