package com.ht.extra.pojo.lab;

public class LabDeptTestMonthKey {
    private String stMonth;

    private String orderingDeptCode;

    private String assayDeptCode;

    private String itemCode;

    public String getStMonth() {
        return stMonth;
    }

    public void setStMonth(String stMonth) {
        this.stMonth = stMonth == null ? null : stMonth.trim();
    }

    public String getOrderingDeptCode() {
        return orderingDeptCode;
    }

    public void setOrderingDeptCode(String orderingDeptCode) {
        this.orderingDeptCode = orderingDeptCode == null ? null : orderingDeptCode.trim();
    }

    public String getAssayDeptCode() {
        return assayDeptCode;
    }

    public void setAssayDeptCode(String assayDeptCode) {
        this.assayDeptCode = assayDeptCode == null ? null : assayDeptCode.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }
}