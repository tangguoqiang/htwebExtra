package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DeptCodeSr {
    private String deptCode;

    private String scepNo;

    private String deptName;

    private String inputCode;

    private BigDecimal deptTcbl;

    private BigDecimal jmbl;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getScepNo() {
        return scepNo;
    }

    public void setScepNo(String scepNo) {
        this.scepNo = scepNo == null ? null : scepNo.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public BigDecimal getDeptTcbl() {
        return deptTcbl;
    }

    public void setDeptTcbl(BigDecimal deptTcbl) {
        this.deptTcbl = deptTcbl;
    }

    public BigDecimal getJmbl() {
        return jmbl;
    }

    public void setJmbl(BigDecimal jmbl) {
        this.jmbl = jmbl;
    }
}