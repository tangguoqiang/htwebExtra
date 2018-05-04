package com.ht.extra.pojo.lab;

public class FormularDict {
    private String computedCode;

    private Short serialNo;

    private String computingCode1;

    private String computingCode2;

    private String computingCode3;

    private String computingCode4;

    private String computingCode5;

    private String formular;

    public String getComputedCode() {
        return computedCode;
    }

    public void setComputedCode(String computedCode) {
        this.computedCode = computedCode == null ? null : computedCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getComputingCode1() {
        return computingCode1;
    }

    public void setComputingCode1(String computingCode1) {
        this.computingCode1 = computingCode1 == null ? null : computingCode1.trim();
    }

    public String getComputingCode2() {
        return computingCode2;
    }

    public void setComputingCode2(String computingCode2) {
        this.computingCode2 = computingCode2 == null ? null : computingCode2.trim();
    }

    public String getComputingCode3() {
        return computingCode3;
    }

    public void setComputingCode3(String computingCode3) {
        this.computingCode3 = computingCode3 == null ? null : computingCode3.trim();
    }

    public String getComputingCode4() {
        return computingCode4;
    }

    public void setComputingCode4(String computingCode4) {
        this.computingCode4 = computingCode4 == null ? null : computingCode4.trim();
    }

    public String getComputingCode5() {
        return computingCode5;
    }

    public void setComputingCode5(String computingCode5) {
        this.computingCode5 = computingCode5 == null ? null : computingCode5.trim();
    }

    public String getFormular() {
        return formular;
    }

    public void setFormular(String formular) {
        this.formular = formular == null ? null : formular.trim();
    }
}