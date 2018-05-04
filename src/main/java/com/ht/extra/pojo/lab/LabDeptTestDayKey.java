package com.ht.extra.pojo.lab;

import java.util.Date;

public class LabDeptTestDayKey {
    private Date stDate;

    private String orderingDeptCode;

    private String assayDeptCode;

    private String itemCode;

    public Date getStDate() {
        return stDate;
    }

    public void setStDate(Date stDate) {
        this.stDate = stDate;
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