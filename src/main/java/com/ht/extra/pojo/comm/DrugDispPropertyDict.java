package com.ht.extra.pojo.comm;

public class DrugDispPropertyDict {
    private String dispensingProperty;

    private Short serialNo;

    private String drugAdministrations;

    public String getDispensingProperty() {
        return dispensingProperty;
    }

    public void setDispensingProperty(String dispensingProperty) {
        this.dispensingProperty = dispensingProperty == null ? null : dispensingProperty.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getDrugAdministrations() {
        return drugAdministrations;
    }

    public void setDrugAdministrations(String drugAdministrations) {
        this.drugAdministrations = drugAdministrations == null ? null : drugAdministrations.trim();
    }
}