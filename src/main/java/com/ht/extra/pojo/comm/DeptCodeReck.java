package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DeptCodeReck extends DeptCodeReckKey {
    private String scepNo;

    private String inputCode;

    private BigDecimal deptTcbl;

    private BigDecimal jmbl;

    private String attrOnHs;

    private String attrOnCb;

    public String getScepNo() {
        return scepNo;
    }

    public void setScepNo(String scepNo) {
        this.scepNo = scepNo == null ? null : scepNo.trim();
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

    public String getAttrOnHs() {
        return attrOnHs;
    }

    public void setAttrOnHs(String attrOnHs) {
        this.attrOnHs = attrOnHs == null ? null : attrOnHs.trim();
    }

    public String getAttrOnCb() {
        return attrOnCb;
    }

    public void setAttrOnCb(String attrOnCb) {
        this.attrOnCb = attrOnCb == null ? null : attrOnCb.trim();
    }
}