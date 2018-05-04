package com.ht.extra.pojo.insurance;

public class InsuranceVsDiagnosisKey {
    private String interfacecode;

    private String diagnosisCode;

    private String icdType;

    public String getInterfacecode() {
        return interfacecode;
    }

    public void setInterfacecode(String interfacecode) {
        this.interfacecode = interfacecode == null ? null : interfacecode.trim();
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode == null ? null : diagnosisCode.trim();
    }

    public String getIcdType() {
        return icdType;
    }

    public void setIcdType(String icdType) {
        this.icdType = icdType == null ? null : icdType.trim();
    }
}