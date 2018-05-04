package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class LabReportItemDict {
    private String itemCode;

    private Short serialNo;

    private String itemName;

    private String resultType;

    private BigDecimal lowerLimit;

    private BigDecimal upperLimit;

    private String units;

    private String printContext;

    private BigDecimal miniIncrement;

    private String notes;

    private String defaultValue;

    private String inputCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType == null ? null : resultType.trim();
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(BigDecimal upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getPrintContext() {
        return printContext;
    }

    public void setPrintContext(String printContext) {
        this.printContext = printContext == null ? null : printContext.trim();
    }

    public BigDecimal getMiniIncrement() {
        return miniIncrement;
    }

    public void setMiniIncrement(BigDecimal miniIncrement) {
        this.miniIncrement = miniIncrement;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}