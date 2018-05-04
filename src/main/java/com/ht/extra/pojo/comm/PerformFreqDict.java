package com.ht.extra.pojo.comm;

public class PerformFreqDict {
    private String freqDesc;

    private Short serialNo;

    private Short freqCounter;

    private Short freqInterval;

    private String freqIntervalUnits;

    public String getFreqDesc() {
        return freqDesc;
    }

    public void setFreqDesc(String freqDesc) {
        this.freqDesc = freqDesc == null ? null : freqDesc.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public Short getFreqCounter() {
        return freqCounter;
    }

    public void setFreqCounter(Short freqCounter) {
        this.freqCounter = freqCounter;
    }

    public Short getFreqInterval() {
        return freqInterval;
    }

    public void setFreqInterval(Short freqInterval) {
        this.freqInterval = freqInterval;
    }

    public String getFreqIntervalUnits() {
        return freqIntervalUnits;
    }

    public void setFreqIntervalUnits(String freqIntervalUnits) {
        this.freqIntervalUnits = freqIntervalUnits == null ? null : freqIntervalUnits.trim();
    }
}