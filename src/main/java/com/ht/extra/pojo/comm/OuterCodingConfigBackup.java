package com.ht.extra.pojo.comm;

import java.util.Date;

public class OuterCodingConfigBackup extends OuterCodingConfigBackupKey {
    private String itemClass;

    private Short outerCodeLength;

    private Short textLength;

    private Short stdCodeLength;

    private String dictFileName;

    private Date lastUpdtDateTime;

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
}