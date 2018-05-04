package com.ht.extra.pojo.inpbill;

import java.util.Date;

public class CasherWorkingLogKey {
    private String operNo;

    private Date operDateTime;

    public String getOperNo() {
        return operNo;
    }

    public void setOperNo(String operNo) {
        this.operNo = operNo == null ? null : operNo.trim();
    }

    public Date getOperDateTime() {
        return operDateTime;
    }

    public void setOperDateTime(Date operDateTime) {
        this.operDateTime = operDateTime;
    }
}