package com.ht.extra.pojo.medrec;

import java.util.Date;

public class OutpMrTraceKey {
    private String patientId;

    private String borrowedDept;

    private Date borrowedDate;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getBorrowedDept() {
        return borrowedDept;
    }

    public void setBorrowedDept(String borrowedDept) {
        this.borrowedDept = borrowedDept == null ? null : borrowedDept.trim();
    }

    public Date getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate) {
        this.borrowedDate = borrowedDate;
    }
}