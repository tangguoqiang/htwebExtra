package com.ht.extra.pojo.insurance;

public class InsuranceDiagnosisKey {
    private String interfacecode;

    private String icdCode;

    private String icdType;

    public String getInterfacecode() {
        return interfacecode;
    }

    public void setInterfacecode(String interfacecode) {
        this.interfacecode = interfacecode == null ? null : interfacecode.trim();
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode == null ? null : icdCode.trim();
    }

    public String getIcdType() {
        return icdType;
    }

    public void setIcdType(String icdType) {
        this.icdType = icdType == null ? null : icdType.trim();
    }
}