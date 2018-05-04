package com.ht.extra.pojo.comm;

public class LabListResultDictKey {
    private String reportItemCode;

    private Short resultNo;

    public String getReportItemCode() {
        return reportItemCode;
    }

    public void setReportItemCode(String reportItemCode) {
        this.reportItemCode = reportItemCode == null ? null : reportItemCode.trim();
    }

    public Short getResultNo() {
        return resultNo;
    }

    public void setResultNo(Short resultNo) {
        this.resultNo = resultNo;
    }
}