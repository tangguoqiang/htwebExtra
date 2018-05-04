package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;

public class InsuVsPrice extends InsuVsPriceKey {
    private String insuCode;

    private String insuName;

    private String insuNameAlias;

    private String itemName;

    private BigDecimal price;

    private String insuPhamProducingArea;

    private String insuPhamProducingAreaSign;

    private String insuItemsCode;

    public String getInsuCode() {
        return insuCode;
    }

    public void setInsuCode(String insuCode) {
        this.insuCode = insuCode == null ? null : insuCode.trim();
    }

    public String getInsuName() {
        return insuName;
    }

    public void setInsuName(String insuName) {
        this.insuName = insuName == null ? null : insuName.trim();
    }

    public String getInsuNameAlias() {
        return insuNameAlias;
    }

    public void setInsuNameAlias(String insuNameAlias) {
        this.insuNameAlias = insuNameAlias == null ? null : insuNameAlias.trim();
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

    public String getInsuPhamProducingArea() {
        return insuPhamProducingArea;
    }

    public void setInsuPhamProducingArea(String insuPhamProducingArea) {
        this.insuPhamProducingArea = insuPhamProducingArea == null ? null : insuPhamProducingArea.trim();
    }

    public String getInsuPhamProducingAreaSign() {
        return insuPhamProducingAreaSign;
    }

    public void setInsuPhamProducingAreaSign(String insuPhamProducingAreaSign) {
        this.insuPhamProducingAreaSign = insuPhamProducingAreaSign == null ? null : insuPhamProducingAreaSign.trim();
    }

    public String getInsuItemsCode() {
        return insuItemsCode;
    }

    public void setInsuItemsCode(String insuItemsCode) {
        this.insuItemsCode = insuItemsCode == null ? null : insuItemsCode.trim();
    }
}