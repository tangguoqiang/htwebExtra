package com.ht.extra.pojo.comm;

public class DrugDictKey {
    private String drugCode;

    private String drugSpec;

    private Short drugIndicator;

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCode = drugCode == null ? null : drugCode.trim();
    }

    public String getDrugSpec() {
        return drugSpec;
    }

    public void setDrugSpec(String drugSpec) {
        this.drugSpec = drugSpec == null ? null : drugSpec.trim();
    }

    public Short getDrugIndicator() {
        return drugIndicator;
    }

    public void setDrugIndicator(Short drugIndicator) {
        this.drugIndicator = drugIndicator;
    }
}