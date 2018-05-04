package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class StandardVsPrice extends StandardVsPriceKey {
    private String standardCode;

    private String standardName;

    private String standardMeaning;

    private String standardExceptionContent;

    private String standardUnits;

    private String standardPrice;

    private String standardMemo;

    private String itemName;

    private BigDecimal price;

    private String inputcode;

    private String standardMaterialName;

    private String materialSign;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getInputcode() {
        return inputcode;
    }

    public void setInputcode(String inputcode) {
        this.inputcode = inputcode == null ? null : inputcode.trim();
    }

    public String getStandardMaterialName() {
        return standardMaterialName;
    }

    public void setStandardMaterialName(String standardMaterialName) {
        this.standardMaterialName = standardMaterialName == null ? null : standardMaterialName.trim();
    }

    public String getMaterialSign() {
        return materialSign;
    }

    public void setMaterialSign(String materialSign) {
        this.materialSign = materialSign == null ? null : materialSign.trim();
    }
}