package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class MeasuresDict extends MeasuresDictKey {
    private Short serialNo;

    private String measuresCode;

    private String baseUnits;

    private BigDecimal conversionRatio;

    private String inputCode;

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getMeasuresCode() {
        return measuresCode;
    }

    public void setMeasuresCode(String measuresCode) {
        this.measuresCode = measuresCode == null ? null : measuresCode.trim();
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