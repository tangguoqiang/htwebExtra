package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class PriceStandardJsxnh {
    private String itemNo;

    private String memo;

    private String itemCode;

    private String itemName;

    private String itemContent;

    private String unit;

    private BigDecimal outpRate;

    private BigDecimal inpRate;

    private BigDecimal oneLimitPrice;

    private BigDecimal twoLimitPrice;

    private BigDecimal thirdLimitPrice;

    private String itemClassXnh;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getOutpRate() {
        return outpRate;
    }

    public void setOutpRate(BigDecimal outpRate) {
        this.outpRate = outpRate;
    }

    public BigDecimal getInpRate() {
        return inpRate;
    }

    public void setInpRate(BigDecimal inpRate) {
        this.inpRate = inpRate;
    }

    public BigDecimal getOneLimitPrice() {
        return oneLimitPrice;
    }

    public void setOneLimitPrice(BigDecimal oneLimitPrice) {
        this.oneLimitPrice = oneLimitPrice;
    }

    public BigDecimal getTwoLimitPrice() {
        return twoLimitPrice;
    }

    public void setTwoLimitPrice(BigDecimal twoLimitPrice) {
        this.twoLimitPrice = twoLimitPrice;
    }

    public BigDecimal getThirdLimitPrice() {
        return thirdLimitPrice;
    }

    public void setThirdLimitPrice(BigDecimal thirdLimitPrice) {
        this.thirdLimitPrice = thirdLimitPrice;
    }

    public String getItemClassXnh() {
        return itemClassXnh;
    }

    public void setItemClassXnh(String itemClassXnh) {
        this.itemClassXnh = itemClassXnh == null ? null : itemClassXnh.trim();
    }
}