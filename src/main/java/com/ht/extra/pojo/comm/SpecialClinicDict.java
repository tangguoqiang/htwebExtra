package com.ht.extra.pojo.comm;

public class SpecialClinicDict {
    private String specialClinicName;

    private Short serialNo;

    private String specialClinicCode;

    private String inputCode;

    public String getSpecialClinicName() {
        return specialClinicName;
    }

    public void setSpecialClinicName(String specialClinicName) {
        this.specialClinicName = specialClinicName == null ? null : specialClinicName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getSpecialClinicCode() {
        return specialClinicCode;
    }

    public void setSpecialClinicCode(String specialClinicCode) {
        this.specialClinicCode = specialClinicCode == null ? null : specialClinicCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}