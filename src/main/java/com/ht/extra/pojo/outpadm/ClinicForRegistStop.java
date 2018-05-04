package com.ht.extra.pojo.outpadm;

import java.util.Date;

public class ClinicForRegistStop extends ClinicForRegistStopKey {
    private String operator;

    private Date operDatetime;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperDatetime() {
        return operDatetime;
    }

    public void setOperDatetime(Date operDatetime) {
        this.operDatetime = operDatetime;
    }
}