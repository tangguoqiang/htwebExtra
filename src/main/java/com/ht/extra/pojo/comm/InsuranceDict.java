package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class InsuranceDict {
    private Integer insuNo;

    private String insuItemCode;

    private String insuItemName;

    private String unit;

    private String itemCode;

    private BigDecimal price;

    private String inputCode;

    public Integer getInsuNo() {
        return insuNo;
    }

    public void setInsuNo(Integer insuNo) {
        this.insuNo = insuNo;
    }

    public String getInsuItemCode() {
        return insuItemCode;
    }

    public void setInsuItemCode(String insuItemCode) {
        this.insuItemCode = insuItemCode == null ? null : insuItemCode.trim();
    }

    public String getInsuItemName() {
        return insuItemName;
    }

    public void setInsuItemName(String insuItemName) {
        this.insuItemName = insuItemName == null ? null : insuItemName.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}