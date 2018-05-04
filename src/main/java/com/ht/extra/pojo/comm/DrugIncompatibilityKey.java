package com.ht.extra.pojo.comm;

public class DrugIncompatibilityKey {
    private String drugACode;

    private String drugBCode;

    public String getDrugACode() {
        return drugACode;
    }

    public void setDrugACode(String drugACode) {
        this.drugACode = drugACode == null ? null : drugACode.trim();
    }

    public String getDrugBCode() {
        return drugBCode;
    }

    public void setDrugBCode(String drugBCode) {
        this.drugBCode = drugBCode == null ? null : drugBCode.trim();
    }
}