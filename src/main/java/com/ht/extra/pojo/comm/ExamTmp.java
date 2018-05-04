package com.ht.extra.pojo.comm;

public class ExamTmp {
    private String examNo;

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo == null ? null : examNo.trim();
    }
}