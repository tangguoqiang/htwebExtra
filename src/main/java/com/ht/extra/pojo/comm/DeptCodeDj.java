package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DeptCodeDj extends DeptCodeDjKey {
    private BigDecimal tcbl;

    private BigDecimal fcbl;

    private String deptCodehz;

    public BigDecimal getTcbl() {
        return tcbl;
    }

    public void setTcbl(BigDecimal tcbl) {
        this.tcbl = tcbl;
    }

    public BigDecimal getFcbl() {
        return fcbl;
    }

    public void setFcbl(BigDecimal fcbl) {
        this.fcbl = fcbl;
    }

    public String getDeptCodehz() {
        return deptCodehz;
    }

    public void setDeptCodehz(String deptCodehz) {
        this.deptCodehz = deptCodehz == null ? null : deptCodehz.trim();
    }
}