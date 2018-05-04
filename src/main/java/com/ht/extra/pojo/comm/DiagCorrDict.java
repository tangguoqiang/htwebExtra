package com.ht.extra.pojo.comm;

public class DiagCorrDict {
    private String diagCorrCode;

    private Short serialNo;

    private String diagCorrName;

    private String inputCode;

    public String getDiagCorrCode() {
        return diagCorrCode;
    }

    public void setDiagCorrCode(String diagCorrCode) {
        this.diagCorrCode = diagCorrCode == null ? null : diagCorrCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getDiagCorrName() {
        return diagCorrName;
    }

    public void setDiagCorrName(String diagCorrName) {
        this.diagCorrName = diagCorrName == null ? null : diagCorrName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}