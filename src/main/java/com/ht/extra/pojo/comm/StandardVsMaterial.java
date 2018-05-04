package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class StandardVsMaterial extends StandardVsMaterialKey {
    private String standardCode;

    private String standardName;

    private String standardMaterialName;

    private String itemName;

    private BigDecimal price;

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

    public String getStandardMaterialName() {
        return standardMaterialName;
    }

    public void setStandardMaterialName(String standardMaterialName) {
        this.standardMaterialName = standardMaterialName == null ? null : standardMaterialName.trim();
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
}