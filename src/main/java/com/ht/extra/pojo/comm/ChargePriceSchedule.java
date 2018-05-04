package com.ht.extra.pojo.comm;

public class ChargePriceSchedule {
    private String chargeType;

    private Short priceCoeffNumerator;

    private Short priceCoeffDenominator;

    private Short chargeSpecialIndicator;

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public Short getPriceCoeffNumerator() {
        return priceCoeffNumerator;
    }

    public void setPriceCoeffNumerator(Short priceCoeffNumerator) {
        this.priceCoeffNumerator = priceCoeffNumerator;
    }

    public Short getPriceCoeffDenominator() {
        return priceCoeffDenominator;
    }

    public void setPriceCoeffDenominator(Short priceCoeffDenominator) {
        this.priceCoeffDenominator = priceCoeffDenominator;
    }

    public Short getChargeSpecialIndicator() {
        return chargeSpecialIndicator;
    }

    public void setChargeSpecialIndicator(Short chargeSpecialIndicator) {
        this.chargeSpecialIndicator = chargeSpecialIndicator;
    }
}