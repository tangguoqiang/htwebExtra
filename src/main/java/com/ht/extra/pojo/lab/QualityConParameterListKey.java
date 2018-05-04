package com.ht.extra.pojo.lab;

public class QualityConParameterListKey {
    private String itemCode;

    private Short qcYear;

    private Short qcMonth;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public Short getQcYear() {
        return qcYear;
    }

    public void setQcYear(Short qcYear) {
        this.qcYear = qcYear;
    }

    public Short getQcMonth() {
        return qcMonth;
    }

    public void setQcMonth(Short qcMonth) {
        this.qcMonth = qcMonth;
    }
}