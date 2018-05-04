package com.ht.extra.pojo.comm;

public class LabSheetMaster {
    private String labSheetId;

    private String performedBy;

    private String sheetTitle;

    private String chargeItemClass;

    private String chargeItemCode;

    private String chargeItemSpec;

    private String inputCode;

    private String className;

    public String getLabSheetId() {
        return labSheetId;
    }

    public void setLabSheetId(String labSheetId) {
        this.labSheetId = labSheetId == null ? null : labSheetId.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public String getSheetTitle() {
        return sheetTitle;
    }

    public void setSheetTitle(String sheetTitle) {
        this.sheetTitle = sheetTitle == null ? null : sheetTitle.trim();
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

    public String getChargeItemSpec() {
        return chargeItemSpec;
    }

    public void setChargeItemSpec(String chargeItemSpec) {
        this.chargeItemSpec = chargeItemSpec == null ? null : chargeItemSpec.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}