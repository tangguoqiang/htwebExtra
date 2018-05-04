package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class PhamBasicTemp {
    private String phamStdCode;

    private String phamName;

    private String phamCode;

    private String phamSpec;

    private String packageSpec;

    private String drugSpec;

    private Integer amountPerPackage;

    private String minUnit;

    private String firmId;

    private String phamUnit;

    private String phamForm;

    private BigDecimal tradePrice;

    private BigDecimal retailPrice;

    private Long highLimit;

    private Long lowLimit;

    private String toxicologyProperty;

    private String priceProperty;

    private BigDecimal dosePerUnit;

    private String doseUnit;

    public String getPhamStdCode() {
        return phamStdCode;
    }

    public void setPhamStdCode(String phamStdCode) {
        this.phamStdCode = phamStdCode == null ? null : phamStdCode.trim();
    }

    public String getPhamName() {
        return phamName;
    }

    public void setPhamName(String phamName) {
        this.phamName = phamName == null ? null : phamName.trim();
    }

    public String getPhamCode() {
        return phamCode;
    }

    public void setPhamCode(String phamCode) {
        this.phamCode = phamCode == null ? null : phamCode.trim();
    }

    public String getPhamSpec() {
        return phamSpec;
    }

    public void setPhamSpec(String phamSpec) {
        this.phamSpec = phamSpec == null ? null : phamSpec.trim();
    }

    public String getPackageSpec() {
        return packageSpec;
    }

    public void setPackageSpec(String packageSpec) {
        this.packageSpec = packageSpec == null ? null : packageSpec.trim();
    }

    public String getDrugSpec() {
        return drugSpec;
    }

    public void setDrugSpec(String drugSpec) {
        this.drugSpec = drugSpec == null ? null : drugSpec.trim();
    }

    public Integer getAmountPerPackage() {
        return amountPerPackage;
    }

    public void setAmountPerPackage(Integer amountPerPackage) {
        this.amountPerPackage = amountPerPackage;
    }

    public String getMinUnit() {
        return minUnit;
    }

    public void setMinUnit(String minUnit) {
        this.minUnit = minUnit == null ? null : minUnit.trim();
    }

    public String getFirmId() {
        return firmId;
    }

    public void setFirmId(String firmId) {
        this.firmId = firmId == null ? null : firmId.trim();
    }

    public String getPhamUnit() {
        return phamUnit;
    }

    public void setPhamUnit(String phamUnit) {
        this.phamUnit = phamUnit == null ? null : phamUnit.trim();
    }

    public String getPhamForm() {
        return phamForm;
    }

    public void setPhamForm(String phamForm) {
        this.phamForm = phamForm == null ? null : phamForm.trim();
    }

    public BigDecimal getTradePrice() {
        return tradePrice;
    }

    public void setTradePrice(BigDecimal tradePrice) {
        this.tradePrice = tradePrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Long getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(Long highLimit) {
        this.highLimit = highLimit;
    }

    public Long getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(Long lowLimit) {
        this.lowLimit = lowLimit;
    }

    public String getToxicologyProperty() {
        return toxicologyProperty;
    }

    public void setToxicologyProperty(String toxicologyProperty) {
        this.toxicologyProperty = toxicologyProperty == null ? null : toxicologyProperty.trim();
    }

    public String getPriceProperty() {
        return priceProperty;
    }

    public void setPriceProperty(String priceProperty) {
        this.priceProperty = priceProperty == null ? null : priceProperty.trim();
    }

    public BigDecimal getDosePerUnit() {
        return dosePerUnit;
    }

    public void setDosePerUnit(BigDecimal dosePerUnit) {
        this.dosePerUnit = dosePerUnit;
    }

    public String getDoseUnit() {
        return doseUnit;
    }

    public void setDoseUnit(String doseUnit) {
        this.doseUnit = doseUnit == null ? null : doseUnit.trim();
    }
}