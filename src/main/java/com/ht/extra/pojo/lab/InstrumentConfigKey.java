package com.ht.extra.pojo.lab;

public class InstrumentConfigKey {
    private String instrumentId;

    private String instrumentItemCode;

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId == null ? null : instrumentId.trim();
    }

    public String getInstrumentItemCode() {
        return instrumentItemCode;
    }

    public void setInstrumentItemCode(String instrumentItemCode) {
        this.instrumentItemCode = instrumentItemCode == null ? null : instrumentItemCode.trim();
    }
}