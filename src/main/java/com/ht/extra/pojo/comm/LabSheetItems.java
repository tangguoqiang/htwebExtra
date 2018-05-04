package com.ht.extra.pojo.comm;

public class LabSheetItems extends LabSheetItemsKey {
    private Short labItemNo;

    private String labItemName;

    private String chargeItemClass;

    private String chargeItemCode;

    private String speciman;

    public Short getLabItemNo() {
        return labItemNo;
    }

    public void setLabItemNo(Short labItemNo) {
        this.labItemNo = labItemNo;
    }

    public String getLabItemName() {
        return labItemName;
    }

    public void setLabItemName(String labItemName) {
        this.labItemName = labItemName == null ? null : labItemName.trim();
    }

    public String getChargeItemClass() {
        return chargeItemClass;
    }

    public void setChargeItemClass(String chargeItemClass) {
        this.chargeItemClass = chargeItemClass == null ? null : chargeItemClass.trim();
    }

    public String getChargeItemCode() {
        return chargeItemCode;
    }

    public void setChargeItemCode(String chargeItemCode) {
        this.chargeItemCode = chargeItemCode == null ? null : chargeItemCode.trim();
    }

    public String getSpeciman() {
        return speciman;
    }

    public void setSpeciman(String speciman) {
        this.speciman = speciman == null ? null : speciman.trim();
    }
}