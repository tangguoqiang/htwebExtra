package com.ht.extra.pojo.comm;

public class ClinicVsChargeBackup extends ClinicVsChargeBackupKey {
    private String chargeItemClass;

    private String chargeItemCode;

    private String chargeItemSpec;

    private Short amount;

    private String units;

    public String getChargeItemClass() {
        return chargeItemClass;
    }

    public void setChargeItemClass(String chargeItemClass) {
        this.chargeItemClass = chargeItemClass == null ? null : chargeItemClass.trim();
    }

    public String getChargeItemCode() {
        return chargeItemCode;
    }

    public void setChargeItemCode(String chargeItemCode) {
        this.chargeItemCode = chargeItemCode == null ? null : chargeItemCode.trim();
    }

    public String getChargeItemSpec() {
        return chargeItemSpec;
    }

    public void setChargeItemSpec(String chargeItemSpec) {
        this.chargeItemSpec = chargeItemSpec == null ? null : chargeItemSpec.trim();
    }

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }
}