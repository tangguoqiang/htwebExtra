package com.ht.extra.pojo.comm;

import java.math.BigDecimal;
import java.util.Date;

public class PhamBasicInfo {
    private String phamStdCode;

    private String phamName;

    private String phamCode;

    private String phamSpec;

    private String phamUnit;

    private String phamForm;

    private BigDecimal tradePrice;

    private BigDecimal retailPrice;

    private String storageNumber;

    private String allocation;

    private Long highLimit;

    private Long lowLimit;

    private String toxicologyProperty;

    private String materialProperty;

    private String marketSupply;

    private String priceProperty;

    private String drugUseLevel;

    private String supplyLevel;

    private String manageLevel;

    private BigDecimal priceRatio;

    private Long stdDose;

    private BigDecimal doseRatio;

    private Integer dividePackDose;

    private BigDecimal dosePerUnit;

    private String doseUnit;

    private Date enterDate;

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

    public String getStorageNumber() {
        return storageNumber;
    }

    public void setStorageNumber(String storageNumber) {
        this.storageNumber = storageNumber == null ? null : storageNumber.trim();
    }

    public String getAllocation() {
        return allocation;
    }

    public void setAllocation(String allocation) {
        this.allocation = allocation == null ? null : allocation.trim();
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

    public String getMaterialProperty() {
        return materialProperty;
    }

    public void setMaterialProperty(String materialProperty) {
        this.materialProperty = materialProperty == null ? null : materialProperty.trim();
    }

    public String getMarketSupply() {
        return marketSupply;
    }

    public void setMarketSupply(String marketSupply) {
        this.marketSupply = marketSupply == null ? null : marketSupply.trim();
    }

    public String getPriceProperty() {
        return priceProperty;
    }

    public void setPriceProperty(String priceProperty) {
        this.priceProperty = priceProperty == null ? null : priceProperty.trim();
    }

    public String getDrugUseLevel() {
        return drugUseLevel;
    }

    public void setDrugUseLevel(String drugUseLevel) {
        this.drugUseLevel = drugUseLevel == null ? null : drugUseLevel.trim();
    }

    public String getSupplyLevel() {
        return supplyLevel;
    }

    public void setSupplyLevel(String supplyLevel) {
        this.supplyLevel = supplyLevel == null ? null : supplyLevel.trim();
    }

    public String getManageLevel() {
        return manageLevel;
    }

    public void setManageLevel(String manageLevel) {
        this.manageLevel = manageLevel == null ? null : manageLevel.trim();
    }

    public BigDecimal getPriceRatio() {
        return priceRatio;
    }

    public void setPriceRatio(BigDecimal priceRatio) {
        this.priceRatio = priceRatio;
    }

    public Long getStdDose() {
        return stdDose;
    }

    public void setStdDose(Long stdDose) {
        this.stdDose = stdDose;
    }

    public BigDecimal getDoseRatio() {
        return doseRatio;
    }

    public void setDoseRatio(BigDecimal doseRatio) {
        this.doseRatio = doseRatio;
    }

    public Integer getDividePackDose() {
        return dividePackDose;
    }

    public void setDividePackDose(Integer dividePackDose) {
        this.dividePackDose = dividePackDose;
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

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
}