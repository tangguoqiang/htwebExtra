package com.ht.extra.pojo.comm;

import java.math.BigDecimal;
import java.util.Date;

public class CurrentPriceList {
    private String itemClass;

    private String itemCode;

    private String itemName;

    private String itemSpec;

    private String units;

    private BigDecimal price;

    private BigDecimal preferPrice;

    private BigDecimal foreignerPrice;

    private String performedBy;

    private Short feeTypeMask;

    private String classOnInpRcpt;

    private String classOnOutpRcpt;

    private String classOnReckoning;

    private String subjCode;

    private String classOnMr;

    private String memo;

    private String operator;

    private Date enterDate;

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

    public BigDecimal getPreferPrice() {
        return preferPrice;
    }

    public void setPreferPrice(BigDecimal preferPrice) {
        this.preferPrice = preferPrice;
    }

    public BigDecimal getForeignerPrice() {
        return foreignerPrice;
    }

    public void setForeignerPrice(BigDecimal foreignerPrice) {
        this.foreignerPrice = foreignerPrice;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public Short getFeeTypeMask() {
        return feeTypeMask;
    }

    public void setFeeTypeMask(Short feeTypeMask) {
        this.feeTypeMask = feeTypeMask;
    }

    public String getClassOnInpRcpt() {
        return classOnInpRcpt;
    }

    public void setClassOnInpRcpt(String classOnInpRcpt) {
        this.classOnInpRcpt = classOnInpRcpt == null ? null : classOnInpRcpt.trim();
    }

    public String getClassOnOutpRcpt() {
        return classOnOutpRcpt;
    }

    public void setClassOnOutpRcpt(String classOnOutpRcpt) {
        this.classOnOutpRcpt = classOnOutpRcpt == null ? null : classOnOutpRcpt.trim();
    }

    public String getClassOnReckoning() {
        return classOnReckoning;
    }

    public void setClassOnReckoning(String classOnReckoning) {
        this.classOnReckoning = classOnReckoning == null ? null : classOnReckoning.trim();
    }

    public String getSubjCode() {
        return subjCode;
    }

    public void setSubjCode(String subjCode) {
        this.subjCode = subjCode == null ? null : subjCode.trim();
    }

    public String getClassOnMr() {
        return classOnMr;
    }

    public void setClassOnMr(String classOnMr) {
        this.classOnMr = classOnMr == null ? null : classOnMr.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
}