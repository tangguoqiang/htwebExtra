package com.ht.extra.pojo.comm;

public class ChargeTypeDict {
    private String chargeTypeName;

    private Short serialNo;

    private String chargeTypeCode;

    private Short chargePriceIndicator;

    private String checkDrug;

    public String getChargeTypeName() {
        return chargeTypeName;
    }

    public void setChargeTypeName(String chargeTypeName) {
        this.chargeTypeName = chargeTypeName == null ? null : chargeTypeName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getChargeTypeCode() {
        return chargeTypeCode;
    }

    public void setChargeTypeCode(String chargeTypeCode) {
        this.chargeTypeCode = chargeTypeCode == null ? null : chargeTypeCode.trim();
    }

    public Short getChargePriceIndicator() {
        return chargePriceIndicator;
    }

    public void setChargePriceIndicator(Short chargePriceIndicator) {
        this.chargePriceIndicator = chargePriceIndicator;
    }

    public String getCheckDrug() {
        return checkDrug;
    }

    public void setCheckDrug(String checkDrug) {
        this.checkDrug = checkDrug == null ? null : checkDrug.trim();
    }
}