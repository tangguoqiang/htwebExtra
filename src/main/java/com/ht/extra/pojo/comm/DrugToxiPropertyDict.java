package com.ht.extra.pojo.comm;

public class DrugToxiPropertyDict {
    private String toxiName;

    private Short serialNo;

    private String toxiCode;

    private String inputCode;

    public String getToxiName() {
        return toxiName;
    }

    public void setToxiName(String toxiName) {
        this.toxiName = toxiName == null ? null : toxiName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getToxiCode() {
        return toxiCode;
    }

    public void setToxiCode(String toxiCode) {
        this.toxiCode = toxiCode == null ? null : toxiCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}