package com.ht.extra.pojo.lab;

import java.math.BigDecimal;

public class InstrumentConfig extends InstrumentConfigKey {
    private String reportItemCode;

    private BigDecimal deviation;

    public String getReportItemCode() {
        return reportItemCode;
    }

    public void setReportItemCode(String reportItemCode) {
        this.reportItemCode = reportItemCode == null ? null : reportItemCode.trim();
    }

    public BigDecimal getDeviation() {
        return deviation;
    }

    public void setDeviation(BigDecimal deviation) {
        this.deviation = deviation;
    }
}