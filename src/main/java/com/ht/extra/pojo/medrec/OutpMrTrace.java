package com.ht.extra.pojo.medrec;

import java.util.Date;

public class OutpMrTrace extends OutpMrTraceKey {
    private String borrowedType;

    private Date returnedDate;

    public String getBorrowedType() {
        return borrowedType;
    }

    public void setBorrowedType(String borrowedType) {
        this.borrowedType = borrowedType == null ? null : borrowedType.trim();
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }
}