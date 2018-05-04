package com.ht.extra.pojo.comm;

public class DiagCompGroupDict {
    private String diagCompGroupCode;

    private Short serialNo;

    private String diagCompGroupName;

    private String inputCode;

    public String getDiagCompGroupCode() {
        return diagCompGroupCode;
    }

    public void setDiagCompGroupCode(String diagCompGroupCode) {
        this.diagCompGroupCode = diagCompGroupCode == null ? null : diagCompGroupCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getDiagCompGroupName() {
        return diagCompGroupName;
    }

    public void setDiagCompGroupName(String diagCompGroupName) {
        this.diagCompGroupName = diagCompGroupName == null ? null : diagCompGroupName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}