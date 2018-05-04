package com.ht.extra.pojo.comm;

public class PriceNoVsInsu extends PriceNoVsInsuKey {
    private String insuCode;

    private String itemName;

    public String getInsuCode() {
        return insuCode;
    }

    public void setInsuCode(String insuCode) {
        this.insuCode = insuCode == null ? null : insuCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }
}