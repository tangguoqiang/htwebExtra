package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class InsuranceVsPrice {
    private Integer insuNo;

    private String insuItemCode;

    private String insuItemName;

    private String insuUnits;

    private String itemCode;

    private String itemName;

    private String itemSpec;

    private String units;

    private BigDecimal price;

    private String inputCode;

    private String inputCodeWb;

    private String inputCodeSj;

    private String inputCodeJx;

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

    public String getInsuUnits() {
        return insuUnits;
    }

    public void setInsuUnits(String insuUnits) {
        this.insuUnits = insuUnits == null ? null : insuUnits.trim();
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

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getInputCodeWb() {
        return inputCodeWb;
    }

    public void setInputCodeWb(String inputCodeWb) {
        this.inputCodeWb = inputCodeWb == null ? null : inputCodeWb.trim();
    }

    public String getInputCodeSj() {
        return inputCodeSj;
    }

    public void setInputCodeSj(String inputCodeSj) {
        this.inputCodeSj = inputCodeSj == null ? null : inputCodeSj.trim();
    }

    public String getInputCodeJx() {
        return inputCodeJx;
    }

    public void setInputCodeJx(String inputCodeJx) {
        this.inputCodeJx = inputCodeJx == null ? null : inputCodeJx.trim();
    }
}