package com.ht.extra.pojo.comm;

public class ChargetypeVsMedpayway extends ChargetypeVsMedpaywayKey {
    private Short serialNo;

    private String payWayName;

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName == null ? null : payWayName.trim();
    }
}