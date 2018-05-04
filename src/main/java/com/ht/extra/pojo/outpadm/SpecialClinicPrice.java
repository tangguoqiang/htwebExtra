package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;

public class SpecialClinicPrice {
    private String clinicType;

    private String chargeType;

    private BigDecimal price;

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType == null ? null : clinicType.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}