package com.ht.extra.pojo.comm;

public class DayOfWeekDict {
    private Short dayNumber;

    private Short serialNo;

    private String daySymbol;

    public Short getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(Short dayNumber) {
        this.dayNumber = dayNumber;
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getDaySymbol() {
        return daySymbol;
    }

    public void setDaySymbol(String daySymbol) {
        this.daySymbol = daySymbol == null ? null : daySymbol.trim();
    }
}