package com.ht.extra.pojo.comm;

public class ArmedServicesDict {
    private String armedServicesName;

    private Short serialNo;

    private String armedServicesCode;

    private String inputCode;

    public String getArmedServicesName() {
        return armedServicesName;
    }

    public void setArmedServicesName(String armedServicesName) {
        this.armedServicesName = armedServicesName == null ? null : armedServicesName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getArmedServicesCode() {
        return armedServicesCode;
    }

    public void setArmedServicesCode(String armedServicesCode) {
        this.armedServicesCode = armedServicesCode == null ? null : armedServicesCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}