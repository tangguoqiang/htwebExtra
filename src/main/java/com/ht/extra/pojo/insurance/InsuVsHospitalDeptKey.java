package com.ht.extra.pojo.insurance;

public class InsuVsHospitalDeptKey {
    private String insuDeptCode;

    private String deptCode;

    public String getInsuDeptCode() {
        return insuDeptCode;
    }

    public void setInsuDeptCode(String insuDeptCode) {
        this.insuDeptCode = insuDeptCode == null ? null : insuDeptCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }
}