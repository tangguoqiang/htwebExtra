package com.ht.extra.pojo.comm;

public class TreatingResultDict {
    private String treatingResultName;

    private Short serialNo;

    private String treatingResultCode;

    private String inputCode;

    public String getTreatingResultName() {
        return treatingResultName;
    }

    public void setTreatingResultName(String treatingResultName) {
        this.treatingResultName = treatingResultName == null ? null : treatingResultName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getTreatingResultCode() {
        return treatingResultCode;
    }

    public void setTreatingResultCode(String treatingResultCode) {
        this.treatingResultCode = treatingResultCode == null ? null : treatingResultCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}