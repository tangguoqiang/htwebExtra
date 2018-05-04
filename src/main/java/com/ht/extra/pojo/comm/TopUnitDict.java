package com.ht.extra.pojo.comm;

public class TopUnitDict {
    private String topUnitCode;

    private Short serialNo;

    private String topUnitName;

    public String getTopUnitCode() {
        return topUnitCode;
    }

    public void setTopUnitCode(String topUnitCode) {
        this.topUnitCode = topUnitCode == null ? null : topUnitCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getTopUnitName() {
        return topUnitName;
    }

    public void setTopUnitName(String topUnitName) {
        this.topUnitName = topUnitName == null ? null : topUnitName.trim();
    }
}