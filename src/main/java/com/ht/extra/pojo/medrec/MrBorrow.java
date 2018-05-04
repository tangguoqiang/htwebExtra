package com.ht.extra.pojo.medrec;

import java.util.Date;

public class MrBorrow extends MrBorrowKey {
    private String inpNo;

    private Date mrBorrowDate;

    private String mrBorrower;

    private Date mrLendDate;

    private String mrLender;

    private Date mrReturnDate;

    private String mrReturner;

    private String mrConfirmer;

    private String mrMeno;

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
    }

    public Date getMrBorrowDate() {
        return mrBorrowDate;
    }

    public void setMrBorrowDate(Date mrBorrowDate) {
        this.mrBorrowDate = mrBorrowDate;
    }

    public String getMrBorrower() {
        return mrBorrower;
    }

    public void setMrBorrower(String mrBorrower) {
        this.mrBorrower = mrBorrower == null ? null : mrBorrower.trim();
    }

    public Date getMrLendDate() {
        return mrLendDate;
    }

    public void setMrLendDate(Date mrLendDate) {
        this.mrLendDate = mrLendDate;
    }

    public String getMrLender() {
        return mrLender;
    }

    public void setMrLender(String mrLender) {
        this.mrLender = mrLender == null ? null : mrLender.trim();
    }

    public Date getMrReturnDate() {
        return mrReturnDate;
    }

    public void setMrReturnDate(Date mrReturnDate) {
        this.mrReturnDate = mrReturnDate;
    }

    public String getMrReturner() {
        return mrReturner;
    }

    public void setMrReturner(String mrReturner) {
        this.mrReturner = mrReturner == null ? null : mrReturner.trim();
    }

    public String getMrConfirmer() {
        return mrConfirmer;
    }

    public void setMrConfirmer(String mrConfirmer) {
        this.mrConfirmer = mrConfirmer == null ? null : mrConfirmer.trim();
    }

    public String getMrMeno() {
        return mrMeno;
    }

    public void setMrMeno(String mrMeno) {
        this.mrMeno = mrMeno == null ? null : mrMeno.trim();
    }
}