package com.ht.extra.pojo.comm;

public class PhamDict {
    private String phamStdCode;

    private String phamName;

    private String phamSpec;

    private String phamUnit;

    private String phamForm;

    private String toxicologyProperty;

    private Long stdDose;

    private String materialProperty;

    private Integer dividePackDose;

    private String conditionOfStorage;

    public String getPhamStdCode() {
        return phamStdCode;
    }

    public void setPhamStdCode(String phamStdCode) {
        this.phamStdCode = phamStdCode == null ? null : phamStdCode.trim();
    }

    public String getPhamName() {
        return phamName;
    }

    public void setPhamName(String phamName) {
        this.phamName = phamName == null ? null : phamName.trim();
    }

    public String getPhamSpec() {
        return phamSpec;
    }

    public void setPhamSpec(String phamSpec) {
        this.phamSpec = phamSpec == null ? null : phamSpec.trim();
    }

    public String getPhamUnit() {
        return phamUnit;
    }

    public void setPhamUnit(String phamUnit) {
        this.phamUnit = phamUnit == null ? null : phamUnit.trim();
    }

    public String getPhamForm() {
        return phamForm;
    }

    public void setPhamForm(String phamForm) {
        this.phamForm = phamForm == null ? null : phamForm.trim();
    }

    public String getToxicologyProperty() {
        return toxicologyProperty;
    }

    public void setToxicologyProperty(String toxicologyProperty) {
        this.toxicologyProperty = toxicologyProperty == null ? null : toxicologyProperty.trim();
    }

    public Long getStdDose() {
        return stdDose;
    }

    public void setStdDose(Long stdDose) {
        this.stdDose = stdDose;
    }

    public String getMaterialProperty() {
        return materialProperty;
    }

    public void setMaterialProperty(String materialProperty) {
        this.materialProperty = materialProperty == null ? null : materialProperty.trim();
    }

    public Integer getDividePackDose() {
        return dividePackDose;
    }

    public void setDividePackDose(Integer dividePackDose) {
        this.dividePackDose = dividePackDose;
    }

    public String getConditionOfStorage() {
        return conditionOfStorage;
    }

    public void setConditionOfStorage(String conditionOfStorage) {
        this.conditionOfStorage = conditionOfStorage == null ? null : conditionOfStorage.trim();
    }
}