package com.ht.extra.pojo.comm;

public class DeptClinicAttrDict {
    private Short clinicAttrCode;

    private Short serialNo;

    private String clinicAttrName;

    private String inputCode;

    public Short getClinicAttrCode() {
        return clinicAttrCode;
    }

    public void setClinicAttrCode(Short clinicAttrCode) {
        this.clinicAttrCode = clinicAttrCode;
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getClinicAttrName() {
        return clinicAttrName;
    }

    public void setClinicAttrName(String clinicAttrName) {
        this.clinicAttrName = clinicAttrName == null ? null : clinicAttrName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}