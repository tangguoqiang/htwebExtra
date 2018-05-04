package com.ht.extra.pojo.comm;

public class NursingClassDict {
    private String nursingClassCode;

    private Short serialNo;

    private String nursingClassName;

    private String inputCode;

    public String getNursingClassCode() {
        return nursingClassCode;
    }

    public void setNursingClassCode(String nursingClassCode) {
        this.nursingClassCode = nursingClassCode == null ? null : nursingClassCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getNursingClassName() {
        return nursingClassName;
    }

    public void setNursingClassName(String nursingClassName) {
        this.nursingClassName = nursingClassName == null ? null : nursingClassName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}