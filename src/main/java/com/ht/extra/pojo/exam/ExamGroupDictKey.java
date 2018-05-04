package com.ht.extra.pojo.exam;

public class ExamGroupDictKey {
    private String examGroup;

    private String examClass;

    public String getExamGroup() {
        return examGroup;
    }

    public void setExamGroup(String examGroup) {
        this.examGroup = examGroup == null ? null : examGroup.trim();
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass == null ? null : examClass.trim();
    }
}