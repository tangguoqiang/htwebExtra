package com.ht.extra.pojo.medrec;

import java.util.Date;

public class InpMrTrace extends InpMrTraceKey {
    private String borrower;

    private String borrowedType;

    private Date returnedDate;

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower == null ? null : borrower.trim();
    }

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