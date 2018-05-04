package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class InsuPhamDict {
    private Integer insuNo;

    private String insuPhamCode;

    private String insuPhamName;

    private String insuPhamNameAlias;

    private String itemCode;

    private String itemName;

    private String itemSpec;

    private String units;

    private BigDecimal price;

    public Integer getInsuNo() {
        return insuNo;
    }

    public void setInsuNo(Integer insuNo) {
        this.insuNo = insuNo;
    }

    public String getInsuPhamCode() {
        return insuPhamCode;
    }

    public void setInsuPhamCode(String insuPhamCode) {
        this.insuPhamCode = insuPhamCode == null ? null : insuPhamCode.trim();
    }

    public String getInsuPhamName() {
        return insuPhamName;
    }

    public void setInsuPhamName(String insuPhamName) {
        this.insuPhamName = insuPhamName == null ? null : insuPhamName.trim();
    }

    public String getInsuPhamNameAlias() {
        return insuPhamNameAlias;
    }

    public void setInsuPhamNameAlias(String insuPhamNameAlias) {
        this.insuPhamNameAlias = insuPhamNameAlias == null ? null : insuPhamNameAlias.trim();
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