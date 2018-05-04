package com.ht.extra.pojo.exam;

public class ExamIntervalKey {
    private String examClass;

    private String examGroup;

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass == null ? null : examClass.trim();
    }

    public String getExamGroup() {
        return examGroup;
    }

    public void setExamGroup(String examGroup) {
        this.examGroup = examGroup == null ? null : examGroup.trim();
    }
}