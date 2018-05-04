package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class PriceStandardGlyynj {
    private String itemNo;

    private String itemCode;

    private String itemName;

    private String itemContent;

    private String itemExceptContent;

    private String unit;

    private BigDecimal oldPrice;

    private BigDecimal twoPrice;

    private BigDecimal threePrice;

    private String memo;

    private String itemCodeBd;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
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

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getTwoPrice() {
        return twoPrice;
    }

    public void setTwoPrice(BigDecimal twoPrice) {
        this.twoPrice = twoPrice;
    }

    public BigDecimal getThreePrice() {
        return threePrice;
    }

    public void setThreePrice(BigDecimal threePrice) {
        this.threePrice = threePrice;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getItemCodeBd() {
        return itemCodeBd;
    }

    public void setItemCodeBd(String itemCodeBd) {
        this.itemCodeBd = itemCodeBd == null ? null : itemCodeBd.trim();
    }
}