package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DosageUnitsDict {
    private String dosageUnits;

    private Short serialNo;

    private String baseUnits;

    private BigDecimal conversionRatio;

    private String inputCode;

    public String getDosageUnits() {
        return dosageUnits;
    }

    public void setDosageUnits(String dosageUnits) {
        this.dosageUnits = dosageUnits == null ? null : dosageUnits.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getBaseUnits() {
        return baseUnits;
    }

    public void setBaseUnits(String baseUnits) {
        this.baseUnits = baseUnits == null ? null : baseUnits.trim();
    }

    public BigDecimal getConversionRatio() {
        return conversionRatio;
    }

    public void setConversionRatio(BigDecimal conversionRatio) {
        this.conversionRatio = conversionRatio;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}