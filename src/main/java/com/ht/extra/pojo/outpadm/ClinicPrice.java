package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;

public class ClinicPrice {
    private String chargeType;

    private BigDecimal price;

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