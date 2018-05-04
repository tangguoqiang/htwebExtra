package com.ht.extra.pojo.comm;

public class SpecimanDict {
    private String specimanCode;

    private Short serialNo;

    private String specimanName;

    private String inputCode;

    private String deptCode;

    public String getSpecimanCode() {
        return specimanCode;
    }

    public void setSpecimanCode(String specimanCode) {
        this.specimanCode = specimanCode == null ? null : specimanCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getSpecimanName() {
        return specimanName;
    }

    public void setSpecimanName(String specimanName) {
        this.specimanName = specimanName == null ? null : specimanName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }
}