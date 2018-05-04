package com.ht.extra.pojo.exam;

public class ExamBillItemsKey {
    private String examNo;

    private Short examItemNo;

    private Short chargeItemNo;

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo == null ? null : examNo.trim();
    }

    public Short getExamItemNo() {
        return examItemNo;
    }

    public void setExamItemNo(Short examItemNo) {
        this.examItemNo = examItemNo;
    }

    public Short getChargeItemNo() {
        return chargeItemNo;
    }

    public void setChargeItemNo(Short chargeItemNo) {
        this.chargeItemNo = chargeItemNo;
    }
}