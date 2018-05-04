package com.ht.extra.pojo.lab;

public class LabTestItems extends LabTestItemsKey {
    private String itemName;

    private String itemCode;

    private String labSheetId;

    private String className;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getLabSheetId() {
        return labSheetId;
    }

    public void setLabSheetId(String labSheetId) {
        this.labSheetId = labSheetId == null ? null : labSheetId.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}