package com.ht.extra.pojo.comm;

public class JobClassDict {
    private String jobClassName;

    private Short serialNo;

    private String jobClassCode;

    private String inputCode;

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName == null ? null : jobClassName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getJobClassCode() {
        return jobClassCode;
    }

    public void setJobClassCode(String jobClassCode) {
        this.jobClassCode = jobClassCode == null ? null : jobClassCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}