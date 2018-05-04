package com.ht.extra.pojo.comm;

public class ClassCodingConfig {
    private String item;

    private Short codeLevel;

    private String wizardTableName;

    private String wizardCodeField;

    private String wizardNameField;

    private String wizardFilter;

    private String dataTableName;

    private String dataCodeField;

    private String dataNameField;

    private String dataFilter;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public Short getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Short codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getWizardTableName() {
        return wizardTableName;
    }

    public void setWizardTableName(String wizardTableName) {
        this.wizardTableName = wizardTableName == null ? null : wizardTableName.trim();
    }

    public String getWizardCodeField() {
        return wizardCodeField;
    }

    public void setWizardCodeField(String wizardCodeField) {
        this.wizardCodeField = wizardCodeField == null ? null : wizardCodeField.trim();
    }

    public String getWizardNameField() {
        return wizardNameField;
    }

    public void setWizardNameField(String wizardNameField) {
        this.wizardNameField = wizardNameField == null ? null : wizardNameField.trim();
    }

    public String getWizardFilter() {
        return wizardFilter;
    }

    public void setWizardFilter(String wizardFilter) {
        this.wizardFilter = wizardFilter == null ? null : wizardFilter.trim();
    }

    public String getDataTableName() {
        return dataTableName;
    }

    public void setDataTableName(String dataTableName) {
        this.dataTableName = dataTableName == null ? null : dataTableName.trim();
    }

    public String getDataCodeField() {
        return dataCodeField;
    }

    public void setDataCodeField(String dataCodeField) {
        this.dataCodeField = dataCodeField == null ? null : dataCodeField.trim();
    }

    public String getDataNameField() {
        return dataNameField;
    }

    public void setDataNameField(String dataNameField) {
        this.dataNameField = dataNameField == null ? null : dataNameField.trim();
    }

    public String getDataFilter() {
        return dataFilter;
    }

    public void setDataFilter(String dataFilter) {
        this.dataFilter = dataFilter == null ? null : dataFilter.trim();
    }
}