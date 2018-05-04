package com.ht.extra.pojo.comm;

public class TimeIntervalDict {
    private String timeIntervalName;

    private Short serialNo;

    private String timeIntervalCode;

    private String inputCode;

    public String getTimeIntervalName() {
        return timeIntervalName;
    }

    public void setTimeIntervalName(String timeIntervalName) {
        this.timeIntervalName = timeIntervalName == null ? null : timeIntervalName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getTimeIntervalCode() {
        return timeIntervalCode;
    }

    public void setTimeIntervalCode(String timeIntervalCode) {
        this.timeIntervalCode = timeIntervalCode == null ? null : timeIntervalCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}