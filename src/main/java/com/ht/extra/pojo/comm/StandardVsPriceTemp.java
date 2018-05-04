package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class StandardVsPriceTemp {
    private Integer serialNo;

    private String standardCode;

    private String standardName;

    private String standardMeaning;

    private String standardExceptionContent;

    private String standardUnits;

    private String standardPrice;

    private String standardMemo;

    private String itemClass;

    private String itemCode;

    private String itemName;

    private String itemSpec;

    private String units;

    private BigDecimal price;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode == null ? null : standardCode.trim();
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName == null ? null : standardName.trim();
    }

    public String getStandardMeaning() {
        return standardMeaning;
    }

    public void setStandardMeaning(String standardMeaning) {
        this.standardMeaning = standardMeaning == null ? null : standardMeaning.trim();
    }

    public String getStandardExceptionContent() {
        return standardExceptionContent;
    }

    public void setStandardExceptionContent(String standardExceptionContent) {
        this.standardExceptionContent = standardExceptionContent == null ? null : standardExceptionContent.trim();
    }

    public String getStandardUnits() {
        return standardUnits;
    }

    public void setStandardUnits(String standardUnits) {
        this.standardUnits = standardUnits == null ? null : standardUnits.trim();
    }

    public String getStandardPrice() {
        return standardPrice;
    }

    public void setStandardPrice(String standardPrice) {
        this.standardPrice = standardPrice == null ? null : standardPrice.trim();
    }

    public String getStandardMemo() {
        return standardMemo;
    }

    public void setStandardMemo(String standardMemo) {
        this.standardMemo = standardMemo == null ? null : standardMemo.trim();
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec == null ? null : itemSpec.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}