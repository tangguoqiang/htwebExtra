package com.ht.extra.pojo.comm;

import java.util.Date;

public class OuterCodingConfig extends OuterCodingConfigKey {
    private String itemClass;

    private Short outerCodeLength;

    private Short textLength;

    private Short stdCodeLength;

    private String dictFileName;

    private Date lastUpdtDateTime;

    private String dataFilter;

    private String dictTableName;

    private String outerCodeField;

    private String stdCodeField;

    private String textField;

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public Short getOuterCodeLength() {
        return outerCodeLength;
    }

    public void setOuterCodeLength(Short outerCodeLength) {
        this.outerCodeLength = outerCodeLength;
    }

    public Short getTextLength() {
        return textLength;
    }

    public void setTextLength(Short textLength) {
        this.textLength = textLength;
    }

    public Short getStdCodeLength() {
        return stdCodeLength;
    }

    public void setStdCodeLength(Short stdCodeLength) {
        this.stdCodeLength = stdCodeLength;
    }

    public String getDictFileName() {
        return dictFileName;
    }

    public void setDictFileName(String dictFileName) {
        this.dictFileName = dictFileName == null ? null : dictFileName.trim();
    }

    public Date getLastUpdtDateTime() {
        return lastUpdtDateTime;
    }

    public void setLastUpdtDateTime(Date lastUpdtDateTime) {
        this.lastUpdtDateTime = lastUpdtDateTime;
    }

    public String getDataFilter() {
        return dataFilter;
    }

    public void setDataFilter(String dataFilter) {
        this.dataFilter = dataFilter == null ? null : dataFilter.trim();
    }

    public String getDictTableName() {
        return dictTableName;
    }

    public void setDictTableName(String dictTableName) {
        this.dictTableName = dictTableName == null ? null : dictTableName.trim();
    }

    public String getOuterCodeField() {
        return outerCodeField;
    }

    public void setOuterCodeField(String outerCodeField) {
        this.outerCodeField = outerCodeField == null ? null : outerCodeField.trim();
    }

    public String getStdCodeField() {
        return stdCodeField;
    }

    public void setStdCodeField(String stdCodeField) {
        this.stdCodeField = stdCodeField == null ? null : stdCodeField.trim();
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField == null ? null : textField.trim();
    }
}