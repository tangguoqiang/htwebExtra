package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DrugDict extends DrugDictKey {
    private String drugName;

    private String units;

    private String drugForm;

    private String toxiProperty;

    private BigDecimal dosePerUnit;

    private String doseUnits;

    private String inputCode;

    private String administration;

    private String frequency;

    private String notes;

    private BigDecimal perAmount;

    private String memos;

    private String specialSign;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getDrugForm() {
        return drugForm;
    }

    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm == null ? null : drugForm.trim();
    }

    public String getToxiProperty() {
        return toxiProperty;
    }

    public void setToxiProperty(String toxiProperty) {
        this.toxiProperty = toxiProperty == null ? null : toxiProperty.trim();
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

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration == null ? null : administration.trim();
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public BigDecimal getPerAmount() {
        return perAmount;
    }

    public void setPerAmount(BigDecimal perAmount) {
        this.perAmount = perAmount;
    }

    public String getMemos() {
        return memos;
    }

    public void setMemos(String memos) {
        this.memos = memos == null ? null : memos.trim();
    }

    public String getSpecialSign() {
        return specialSign;
    }

    public void setSpecialSign(String specialSign) {
        this.specialSign = specialSign == null ? null : specialSign.trim();
    }
}