package com.ht.extra.pojo.lab;

public class LabResultTemp extends LabResultTempKey {
    private Short printOrder;

    private String reportItemName;

    private String reportItemCode;

    private String result;

    private String units;

    private String abnormalIndicator;

    private String instrumentId;

    public Short getPrintOrder() {
        return printOrder;
    }

    public void setPrintOrder(Short printOrder) {
        this.printOrder = printOrder;
    }

    public String getReportItemName() {
        return reportItemName;
    }

    public void setReportItemName(String reportItemName) {
        this.reportItemName = reportItemName == null ? null : reportItemName.trim();
    }

    public String getReportItemCode() {
        return reportItemCode;
    }

    public void setReportItemCode(String reportItemCode) {
        this.reportItemCode = reportItemCode == null ? null : reportItemCode.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getAbnormalIndicator() {
        return abnormalIndicator;
    }

    public void setAbnormalIndicator(String abnormalIndicator) {
        this.abnormalIndicator = abnormalIndicator == null ? null : abnormalIndicator.trim();
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId == null ? null : instrumentId.trim();
    }
}