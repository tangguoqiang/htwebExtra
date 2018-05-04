package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;

public class InsuranceDiagnosis extends InsuranceDiagnosisKey {
    private String icdName;

    private String imePinyin;

    private String imeWubi;

    private BigDecimal marks;

    private String description;

    public String getIcdName() {
        return icdName;
    }

    public void setIcdName(String icdName) {
        this.icdName = icdName == null ? null : icdName.trim();
    }

    public String getImePinyin() {
        return imePinyin;
    }

    public void setImePinyin(String imePinyin) {
        this.imePinyin = imePinyin == null ? null : imePinyin.trim();
    }

    public String getImeWubi() {
        return imeWubi;
    }

    public void setImeWubi(String imeWubi) {
        this.imeWubi = imeWubi == null ? null : imeWubi.trim();
    }

    public BigDecimal getMarks() {
        return marks;
    }

    public void setMarks(BigDecimal marks) {
        this.marks = marks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}