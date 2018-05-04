package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class PriceStandardJswj {
    private String itemCode;

    private String itemName;

    private String itemContent;

    private String itemExceptContent;

    private String unit;

    private BigDecimal threeSouthPrice;

    private BigDecimal thirdMiddlePrice;

    private BigDecimal thirdNorthPrice;

    private BigDecimal twoSouthPrice;

    private BigDecimal twoMiddlePrice;

    private BigDecimal twoNorthPrice;

    private BigDecimal oneSouthPrice;

    private BigDecimal oneMiddlePrice;

    private BigDecimal oneNorthPrice;

    private String memo;

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

    public String getItemContent() {
        return itemContent;
    }

    public void setItemContent(String itemContent) {
        this.itemContent = itemContent == null ? null : itemContent.trim();
    }

    public String getItemExceptContent() {
        return itemExceptContent;
    }

    public void setItemExceptContent(String itemExceptContent) {
        this.itemExceptContent = itemExceptContent == null ? null : itemExceptContent.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getThreeSouthPrice() {
        return threeSouthPrice;
    }

    public void setThreeSouthPrice(BigDecimal threeSouthPrice) {
        this.threeSouthPrice = threeSouthPrice;
    }

    public BigDecimal getThirdMiddlePrice() {
        return thirdMiddlePrice;
    }

    public void setThirdMiddlePrice(BigDecimal thirdMiddlePrice) {
        this.thirdMiddlePrice = thirdMiddlePrice;
    }

    public BigDecimal getThirdNorthPrice() {
        return thirdNorthPrice;
    }

    public void setThirdNorthPrice(BigDecimal thirdNorthPrice) {
        this.thirdNorthPrice = thirdNorthPrice;
    }

    public BigDecimal getTwoSouthPrice() {
        return twoSouthPrice;
    }

    public void setTwoSouthPrice(BigDecimal twoSouthPrice) {
        this.twoSouthPrice = twoSouthPrice;
    }

    public BigDecimal getTwoMiddlePrice() {
        return twoMiddlePrice;
    }

    public void setTwoMiddlePrice(BigDecimal twoMiddlePrice) {
        this.twoMiddlePrice = twoMiddlePrice;
    }

    public BigDecimal getTwoNorthPrice() {
        return twoNorthPrice;
    }

    public void setTwoNorthPrice(BigDecimal twoNorthPrice) {
        this.twoNorthPrice = twoNorthPrice;
    }

    public BigDecimal getOneSouthPrice() {
        return oneSouthPrice;
    }

    public void setOneSouthPrice(BigDecimal oneSouthPrice) {
        this.oneSouthPrice = oneSouthPrice;
    }

    public BigDecimal getOneMiddlePrice() {
        return oneMiddlePrice;
    }

    public void setOneMiddlePrice(BigDecimal oneMiddlePrice) {
        this.oneMiddlePrice = oneMiddlePrice;
    }

    public BigDecimal getOneNorthPrice() {
        return oneNorthPrice;
    }

    public void setOneNorthPrice(BigDecimal oneNorthPrice) {
        this.oneNorthPrice = oneNorthPrice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}