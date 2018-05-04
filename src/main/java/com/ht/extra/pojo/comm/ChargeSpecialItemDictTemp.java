package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class ChargeSpecialItemDictTemp extends ChargeSpecialItemDictTempKey {
    private Short proportionNumerator;

    private Short proportionDenominator;

    private BigDecimal freeLimit;

    public Short getProportionNumerator() {
        return proportionNumerator;
    }

    public void setProportionNumerator(Short proportionNumerator) {
        this.proportionNumerator = proportionNumerator;
    }

    public Short getProportionDenominator() {
        return proportionDenominator;
    }

    public void setProportionDenominator(Short proportionDenominator) {
        this.proportionDenominator = proportionDenominator;
    }

    public BigDecimal getFreeLimit() {
        return freeLimit;
    }

    public void setFreeLimit(BigDecimal freeLimit) {
        this.freeLimit = freeLimit;
    }
}