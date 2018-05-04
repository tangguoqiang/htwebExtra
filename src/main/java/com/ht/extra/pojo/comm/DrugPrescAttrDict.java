package com.ht.extra.pojo.comm;

public class DrugPrescAttrDict {
    private String prescAttrName;

    private Short serialNo;

    private String prescAttrCode;

    public String getPrescAttrName() {
        return prescAttrName;
    }

    public void setPrescAttrName(String prescAttrName) {
        this.prescAttrName = prescAttrName == null ? null : prescAttrName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPrescAttrCode() {
        return prescAttrCode;
    }

    public void setPrescAttrCode(String prescAttrCode) {
        this.prescAttrCode = prescAttrCode == null ? null : prescAttrCode.trim();
    }
}