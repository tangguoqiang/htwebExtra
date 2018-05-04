package com.ht.extra.pojo.comm;

public class DischargeDispositionDict {
    private String dischargeDispositionCode;

    private Short serialNo;

    private String dischargeDispositionName;

    private String inputCode;

    private String insurDistypeCode;

    public String getDischargeDispositionCode() {
        return dischargeDispositionCode;
    }

    public void setDischargeDispositionCode(String dischargeDispositionCode) {
        this.dischargeDispositionCode = dischargeDispositionCode == null ? null : dischargeDispositionCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getDischargeDispositionName() {
        return dischargeDispositionName;
    }

    public void setDischargeDispositionName(String dischargeDispositionName) {
        this.dischargeDispositionName = dischargeDispositionName == null ? null : dischargeDispositionName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getInsurDistypeCode() {
        return insurDistypeCode;
    }

    public void setInsurDistypeCode(String insurDistypeCode) {
        this.insurDistypeCode = insurDistypeCode == null ? null : insurDistypeCode.trim();
    }
}