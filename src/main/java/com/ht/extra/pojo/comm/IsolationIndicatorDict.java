package com.ht.extra.pojo.comm;

public class IsolationIndicatorDict {
    private Short isolationIndicatorCode;

    private Short serialNo;

    private String isolationIndicatorName;

    public Short getIsolationIndicatorCode() {
        return isolationIndicatorCode;
    }

    public void setIsolationIndicatorCode(Short isolationIndicatorCode) {
        this.isolationIndicatorCode = isolationIndicatorCode;
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getIsolationIndicatorName() {
        return isolationIndicatorName;
    }

    public void setIsolationIndicatorName(String isolationIndicatorName) {
        this.isolationIndicatorName = isolationIndicatorName == null ? null : isolationIndicatorName.trim();
    }
}