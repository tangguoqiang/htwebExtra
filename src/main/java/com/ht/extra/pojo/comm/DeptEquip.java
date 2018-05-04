package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DeptEquip {
    private String deptCode;

    private BigDecimal sbzj;

    private BigDecimal costSbzj;

    private BigDecimal sbbx;

    private BigDecimal costSbbx;

    private String bz;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public BigDecimal getSbzj() {
        return sbzj;
    }

    public void setSbzj(BigDecimal sbzj) {
        this.sbzj = sbzj;
    }

    public BigDecimal getCostSbzj() {
        return costSbzj;
    }

    public void setCostSbzj(BigDecimal costSbzj) {
        this.costSbzj = costSbzj;
    }

    public BigDecimal getSbbx() {
        return sbbx;
    }

    public void setSbbx(BigDecimal sbbx) {
        this.sbbx = sbbx;
    }

    public BigDecimal getCostSbbx() {
        return costSbbx;
    }

    public void setCostSbbx(BigDecimal costSbbx) {
        this.costSbbx = costSbbx;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}