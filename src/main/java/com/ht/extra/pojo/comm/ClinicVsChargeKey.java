package com.ht.extra.pojo.comm;

public class ClinicVsChargeKey {
    private String clinicItemClass;

    private String clinicItemCode;

    private Short chargeItemNo;

    public String getClinicItemClass() {
        return clinicItemClass;
    }

    public void setClinicItemClass(String clinicItemClass) {
        this.clinicItemClass = clinicItemClass == null ? null : clinicItemClass.trim();
    }

    public String getClinicItemCode() {
        return clinicItemCode;
    }

    public void setClinicItemCode(String clinicItemCode) {
        this.clinicItemCode = clinicItemCode == null ? null : clinicItemCode.trim();
    }

    public Short getChargeItemNo() {
        return chargeItemNo;
    }

    public void setChargeItemNo(Short chargeItemNo) {
        this.chargeItemNo = chargeItemNo;
    }
}