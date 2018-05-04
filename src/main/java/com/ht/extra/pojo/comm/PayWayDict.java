package com.ht.extra.pojo.comm;

public class PayWayDict {
    private String payWayCode;

    private Short serialNo;

    private String payWayName;

    private Short acctingIndicator;

    private Short outpIndicator;

    private Short inpIndicator;

    private String inputCode;

    public String getPayWayCode() {
        return payWayCode;
    }

    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode == null ? null : payWayCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPayWayName() {
        return payWayName;
    }

    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName == null ? null : payWayName.trim();
    }

    public Short getAcctingIndicator() {
        return acctingIndicator;
    }

    public void setAcctingIndicator(Short acctingIndicator) {
        this.acctingIndicator = acctingIndicator;
    }

    public Short getOutpIndicator() {
        return outpIndicator;
    }

    public void setOutpIndicator(Short outpIndicator) {
        this.outpIndicator = outpIndicator;
    }

    public Short getInpIndicator() {
        return inpIndicator;
    }

    public void setInpIndicator(Short inpIndicator) {
        this.inpIndicator = inpIndicator;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}