package com.ht.extra.pojo.medrec;

import java.util.Date;

public class MrAddDaysKey {
    private String dateType;

    private Date inputTime;

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType == null ? null : dateType.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }
}