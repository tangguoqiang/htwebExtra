package com.ht.extra.pojo.comm;

public class ServiceSystemDict {
    private Short serviceSystemCode;

    private Short serialNo;

    private String serviceSystemName;

    private String inputCode;

    public Short getServiceSystemCode() {
        return serviceSystemCode;
    }

    public void setServiceSystemCode(Short serviceSystemCode) {
        this.serviceSystemCode = serviceSystemCode;
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getServiceSystemName() {
        return serviceSystemName;
    }

    public void setServiceSystemName(String serviceSystemName) {
        this.serviceSystemName = serviceSystemName == null ? null : serviceSystemName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}