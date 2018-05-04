package com.ht.extra.pojo.lab;

public class LabDeptTestMonth extends LabDeptTestMonthKey {
    private String itemName;

    private Short completedNum;

    private Short outpOrInp;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Short getCompletedNum() {
        return completedNum;
    }

    public void setCompletedNum(Short completedNum) {
        this.completedNum = completedNum;
    }

    public Short getOutpOrInp() {
        return outpOrInp;
    }

    public void setOutpOrInp(Short outpOrInp) {
        this.outpOrInp = outpOrInp;
    }
}