package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DeptHouse {
    private String deptCode;

    private BigDecimal house;

    private BigDecimal costHouse;

    private String bz;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public BigDecimal getHouse() {
        return house;
    }

    public void setHouse(BigDecimal house) {
        this.house = house;
    }

    public BigDecimal getCostHouse() {
        return costHouse;
    }

    public void setCostHouse(BigDecimal costHouse) {
        this.costHouse = costHouse;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}