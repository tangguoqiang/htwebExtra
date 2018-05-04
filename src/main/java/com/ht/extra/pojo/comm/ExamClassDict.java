package com.ht.extra.pojo.comm;

public class ExamClassDict {
    private String examClassName;

    private Short serialNo;

    private String examClassCode;

    private String inputCode;

    public String getExamClassName() {
        return examClassName;
    }

    public void setExamClassName(String examClassName) {
        this.examClassName = examClassName == null ? null : examClassName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getExamClassCode() {
        return examClassCode;
    }

    public void setExamClassCode(String examClassCode) {
        this.examClassCode = examClassCode == null ? null : examClassCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}