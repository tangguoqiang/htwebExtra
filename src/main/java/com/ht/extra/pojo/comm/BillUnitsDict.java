package com.ht.extra.pojo.comm;

public class BillUnitsDict {
    private String billUnitsCode;

    private Short serialNo;

    private String billUnitsName;

    private String inputCode;

    public String getBillUnitsCode() {
        return billUnitsCode;
    }

    public void setBillUnitsCode(String billUnitsCode) {
        this.billUnitsCode = billUnitsCode == null ? null : billUnitsCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getBillUnitsName() {
        return billUnitsName;
    }

    public void setBillUnitsName(String billUnitsName) {
        this.billUnitsName = billUnitsName == null ? null : billUnitsName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}