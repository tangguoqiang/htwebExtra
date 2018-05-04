package com.ht.extra.pojo.comm;

public class ExamResultStatusDict {
    private String examResultStatusCode;

    private Short serialNo;

    private String examResultStatusName;

    private String inputCode;

    public String getExamResultStatusCode() {
        return examResultStatusCode;
    }

    public void setExamResultStatusCode(String examResultStatusCode) {
        this.examResultStatusCode = examResultStatusCode == null ? null : examResultStatusCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getExamResultStatusName() {
        return examResultStatusName;
    }

    public void setExamResultStatusName(String examResultStatusName) {
        this.examResultStatusName = examResultStatusName == null ? null : examResultStatusName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}