package com.ht.extra.pojo.comm;

public class BedStatusDict {
    private String bedStatusCode;

    private Short serialNo;

    private String bedStatusName;

    private String inputCode;

    public String getBedStatusCode() {
        return bedStatusCode;
    }

    public void setBedStatusCode(String bedStatusCode) {
        this.bedStatusCode = bedStatusCode == null ? null : bedStatusCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getBedStatusName() {
        return bedStatusName;
    }

    public void setBedStatusName(String bedStatusName) {
        this.bedStatusName = bedStatusName == null ? null : bedStatusName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}