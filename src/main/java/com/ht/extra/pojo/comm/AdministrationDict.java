package com.ht.extra.pojo.comm;

public class AdministrationDict {
    private String administrationName;

    private Short serialNo;

    private String administrationCode;

    private String inputCode;

    public String getAdministrationName() {
        return administrationName;
    }

    public void setAdministrationName(String administrationName) {
        this.administrationName = administrationName == null ? null : administrationName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getAdministrationCode() {
        return administrationCode;
    }

    public void setAdministrationCode(String administrationCode) {
        this.administrationCode = administrationCode == null ? null : administrationCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}