package com.ht.extra.pojo.comm;

public class BloodTypeDict {
    private String bloodTypeName;

    private Short serialNo;

    private String bloodTypeCode;

    public String getBloodTypeName() {
        return bloodTypeName;
    }

    public void setBloodTypeName(String bloodTypeName) {
        this.bloodTypeName = bloodTypeName == null ? null : bloodTypeName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getBloodTypeCode() {
        return bloodTypeCode;
    }

    public void setBloodTypeCode(String bloodTypeCode) {
        this.bloodTypeCode = bloodTypeCode == null ? null : bloodTypeCode.trim();
    }
}