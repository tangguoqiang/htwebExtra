package com.ht.extra.pojo.comm;

public class DiagnosisTypeDict {
    private String diagnosisTypeCode;

    private Short serialNo;

    private String diagnosisTypeName;

    private String inputCode;

    public String getDiagnosisTypeCode() {
        return diagnosisTypeCode;
    }

    public void setDiagnosisTypeCode(String diagnosisTypeCode) {
        this.diagnosisTypeCode = diagnosisTypeCode == null ? null : diagnosisTypeCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getDiagnosisTypeName() {
        return diagnosisTypeName;
    }

    public void setDiagnosisTypeName(String diagnosisTypeName) {
        this.diagnosisTypeName = diagnosisTypeName == null ? null : diagnosisTypeName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}