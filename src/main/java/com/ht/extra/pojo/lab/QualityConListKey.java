package com.ht.extra.pojo.lab;

import java.util.Date;

public class QualityConListKey {
    private String itemCode;

    private Date qcDate;

    private Integer controlNo;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public Date getQcDate() {
        return qcDate;
    }

    public void setQcDate(Date qcDate) {
        this.qcDate = qcDate;
    }

    public Integer getControlNo() {
        return controlNo;
    }

    public void setControlNo(Integer controlNo) {
        this.controlNo = controlNo;
    }
}