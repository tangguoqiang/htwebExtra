package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class UnitInContract {
    private String unitCode;

    private String unitName;

    private String inputCode;

    private String address;

    private String unitType;

    private String subordinateTo;

    private BigDecimal distanceToHospital;

    private Short regularNum;

    private Short tempNum;

    private Short retiredNum;

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getSubordinateTo() {
        return subordinateTo;
    }

    public void setSubordinateTo(String subordinateTo) {
        this.subordinateTo = subordinateTo == null ? null : subordinateTo.trim();
    }

    public BigDecimal getDistanceToHospital() {
        return distanceToHospital;
    }

    public void setDistanceToHospital(BigDecimal distanceToHospital) {
        this.distanceToHospital = distanceToHospital;
    }

    public Short getRegularNum() {
        return regularNum;
    }

    public void setRegularNum(Short regularNum) {
        this.regularNum = regularNum;
    }

    public Short getTempNum() {
        return tempNum;
    }

    public void setTempNum(Short tempNum) {
        this.tempNum = tempNum;
    }

    public Short getRetiredNum() {
        return retiredNum;
    }

    public void setRetiredNum(Short retiredNum) {
        this.retiredNum = retiredNum;
    }
}