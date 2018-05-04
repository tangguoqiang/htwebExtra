package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;

public class ClinicTypeDict20151030 {
    private Short serialNo;

    private String clinicType;

    private BigDecimal price;

    private String clinicTypeName;

    private String clinicTypeCode;

    private String chargeItem;

    private String priceItem;

    private String clinicItemSpec;

    private String clinicItemUnits;

    private String priceItemSpec;

    private String priceItemUnits;

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType == null ? null : clinicType.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getClinicTypeName() {
        return clinicTypeName;
    }

    public void setClinicTypeName(String clinicTypeName) {
        this.clinicTypeName = clinicTypeName == null ? null : clinicTypeName.trim();
    }

    public String getClinicTypeCode() {
        return clinicTypeCode;
    }

    public void setClinicTypeCode(String clinicTypeCode) {
        this.clinicTypeCode = clinicTypeCode == null ? null : clinicTypeCode.trim();
    }

    public String getChargeItem() {
        return chargeItem;
    }

    public void setChargeItem(String chargeItem) {
        this.chargeItem = chargeItem == null ? null : chargeItem.trim();
    }

    public String getPriceItem() {
        return priceItem;
    }

    public void setPriceItem(String priceItem) {
        this.priceItem = priceItem == null ? null : priceItem.trim();
    }

    public String getClinicItemSpec() {
        return clinicItemSpec;
    }

    public void setClinicItemSpec(String clinicItemSpec) {
        this.clinicItemSpec = clinicItemSpec == null ? null : clinicItemSpec.trim();
    }

    public String getClinicItemUnits() {
        return clinicItemUnits;
    }

    public void setClinicItemUnits(String clinicItemUnits) {
        this.clinicItemUnits = clinicItemUnits == null ? null : clinicItemUnits.trim();
    }

    public String getPriceItemSpec() {
        return priceItemSpec;
    }

    public void setPriceItemSpec(String priceItemSpec) {
        this.priceItemSpec = priceItemSpec == null ? null : priceItemSpec.trim();
    }

    public String getPriceItemUnits() {
        return priceItemUnits;
    }

    public void setPriceItemUnits(String priceItemUnits) {
        this.priceItemUnits = priceItemUnits == null ? null : priceItemUnits.trim();
    }
}