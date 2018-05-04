package com.ht.extra.pojo.exam;

public class ExamItemsKey {
    private String examNo;

    private Short examItemNo;

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
}