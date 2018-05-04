package com.ht.extra.pojo.comm;

public class OuterGeneration {
    private String dictFileName;

    private String dataTableName;

    private String dataInputField;

    private String dataCodeField;

    private String dataNameField;

    private String dataFilter;

    private Short updtMethod;

    private byte[] dictTxtFile;

    public String getDictFileName() {
        return dictFileName;
    }

    public void setDictFileName(String dictFileName) {
        this.dictFileName = dictFileName == null ? null : dictFileName.trim();
    }

    public String getDataTableName() {
        return dataTableName;
    }

    public void setDataTableName(String dataTableName) {
        this.dataTableName = dataTableName == null ? null : dataTableName.trim();
    }

    public String getDataInputField() {
        return dataInputField;
    }

    public void setDataInputField(String dataInputField) {
        this.dataInputField = dataInputField == null ? null : dataInputField.trim();
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

    public Short getUpdtMethod() {
        return updtMethod;
    }

    public void setUpdtMethod(Short updtMethod) {
        this.updtMethod = updtMethod;
    }

    public byte[] getDictTxtFile() {
        return dictTxtFile;
    }

    public void setDictTxtFile(byte[] dictTxtFile) {
        this.dictTxtFile = dictTxtFile;
    }
}