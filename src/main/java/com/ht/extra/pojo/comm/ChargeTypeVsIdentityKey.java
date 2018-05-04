package com.ht.extra.pojo.comm;

public class ChargeTypeVsIdentityKey {
    private String chargeType;

    private Short identitySerialNo;

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public Short getIdentitySerialNo() {
        return identitySerialNo;
    }

    public void setIdentitySerialNo(Short identitySerialNo) {
        this.identitySerialNo = identitySerialNo;
    }
}