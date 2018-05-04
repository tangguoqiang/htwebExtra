package com.ht.extra.pojo.comm;

public class TimeUnitsDict {
    private String timeUnitsName;

    private Short serialNo;

    private String timeUnitsCode;

    private String inputCode;

    public String getTimeUnitsName() {
        return timeUnitsName;
    }

    public void setTimeUnitsName(String timeUnitsName) {
        this.timeUnitsName = timeUnitsName == null ? null : timeUnitsName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getTimeUnitsCode() {
        return timeUnitsCode;
    }

    public void setTimeUnitsCode(String timeUnitsCode) {
        this.timeUnitsCode = timeUnitsCode == null ? null : timeUnitsCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}