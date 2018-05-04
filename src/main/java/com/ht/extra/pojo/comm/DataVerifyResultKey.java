package com.ht.extra.pojo.comm;

import java.util.Date;

public class DataVerifyResultKey {
    private Date verifyDateTime;

    private Short resultNo;

    public Date getVerifyDateTime() {
        return verifyDateTime;
    }

    public void setVerifyDateTime(Date verifyDateTime) {
        this.verifyDateTime = verifyDateTime;
    }

    public Short getResultNo() {
        return resultNo;
    }

    public void setResultNo(Short resultNo) {
        this.resultNo = resultNo;
    }
}