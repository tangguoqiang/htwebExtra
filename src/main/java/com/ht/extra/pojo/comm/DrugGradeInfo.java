package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DrugGradeInfo extends DrugGradeInfoKey {
    private String drugName;

    private String drugForm;

    private String class1;

    private String class2;

    private String class3;

    private String class4;

    private String class5;

    private String class6;

    private BigDecimal dosePerUnit;

    private String doseUnits;

    private BigDecimal dosePerDay;

    private String administration;

    private Short validStatus;

    private Short catalogStatus;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getDrugForm() {
        return drugForm;
    }

    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm == null ? null : drugForm.trim();
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1 == null ? null : class1.trim();
    }

    public String getClass2() {
        return class2;
    }

    public void setClass2(String class2) {
        this.class2 = class2 == null ? null : class2.trim();
    }

    public String getClass3() {
        return class3;
    }

    public void setClass3(String class3) {
        this.class3 = class3 == null ? null : class3.trim();
    }

    public String getClass4() {
        return class4;
    }

    public void setClass4(String class4) {
        this.class4 = class4 == null ? null : class4.trim();
    }

    public String getClass5() {
        return class5;
    }

    public void setClass5(String class5) {
        this.class5 = class5 == null ? null : class5.trim();
    }

    public String getClass6() {
        return class6;
    }

    public void setClass6(String class6) {
        this.class6 = class6 == null ? null : class6.trim();
    }

    public BigDecimal getDosePerUnit() {
        return dosePerUnit;
    }

    public void setDosePerUnit(BigDecimal dosePerUnit) {
        this.dosePerUnit = dosePerUnit;
    }

    public String getDoseUnits() {
        return doseUnits;
    }

    public void setDoseUnits(String doseUnits) {
        this.doseUnits = doseUnits == null ? null : doseUnits.trim();
    }

    public BigDecimal getDosePerDay() {
        return dosePerDay;
    }

    public void setDosePerDay(BigDecimal dosePerDay) {
        this.dosePerDay = dosePerDay;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration == null ? null : administration.trim();
    }

    public Short getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Short validStatus) {
        this.validStatus = validStatus;
    }

    public Short getCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(Short catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
}