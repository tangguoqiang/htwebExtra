package com.ht.extra.pojo.comm;

public class ExamSubclassDict {
    private String examSubclassName;

    private Short serialNo;

    private String examClassName;

    private String inputCode;

    public String getExamSubclassName() {
        return examSubclassName;
    }

    public void setExamSubclassName(String examSubclassName) {
        this.examSubclassName = examSubclassName == null ? null : examSubclassName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getExamClassName() {
        return examClassName;
    }

    public void setExamClassName(String examClassName) {
        this.examClassName = examClassName == null ? null : examClassName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}