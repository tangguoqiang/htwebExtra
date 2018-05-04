package com.ht.extra.pojo.lab;

import java.util.Date;

public class LabResultTempKey {
    private String workingId;

    private Short itemNo;

    private Date resultDateTime;

    public String getWorkingId() {
        return workingId;
    }

    public void setWorkingId(String workingId) {
        this.workingId = workingId == null ? null : workingId.trim();
    }

    public Short getItemNo() {
        return itemNo;
    }

    public void setItemNo(Short itemNo) {
        this.itemNo = itemNo;
    }

    public Date getResultDateTime() {
        return resultDateTime;
    }

    public void setResultDateTime(Date resultDateTime) {
        this.resultDateTime = resultDateTime;
    }
}