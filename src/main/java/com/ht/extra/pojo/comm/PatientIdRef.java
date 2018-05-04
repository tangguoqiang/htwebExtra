package com.ht.extra.pojo.comm;

public class PatientIdRef extends PatientIdRefKey {
    private String relatedColumnName;

    private String operType;

    private Short serialNo;

    public String getRelatedColumnName() {
        return relatedColumnName;
    }

    public void setRelatedColumnName(String relatedColumnName) {
        this.relatedColumnName = relatedColumnName == null ? null : relatedColumnName.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }
}