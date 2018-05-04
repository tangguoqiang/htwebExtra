package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;

public class OutpOtherHospitalDrugInfo extends OutpOtherHospitalDrugInfoKey {
    private String drugName;

    private String drugSpec;

    private BigDecimal amount;

    private String units;

    private String inuranceNo;

    private String insuranceNo;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getDrugSpec() {
        return drugSpec;
    }

    public void setDrugSpec(String drugSpec) {
        this.drugSpec = drugSpec == null ? null : drugSpec.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getInuranceNo() {
        return inuranceNo;
    }

    public void setInuranceNo(String inuranceNo) {
        this.inuranceNo = inuranceNo == null ? null : inuranceNo.trim();
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo == null ? null : insuranceNo.trim();
    }
}