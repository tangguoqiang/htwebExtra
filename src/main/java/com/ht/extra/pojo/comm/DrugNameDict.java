package com.ht.extra.pojo.comm;

public class DrugNameDict extends DrugNameDictKey {
    private Short stdIndicator;

    private String inputCode;

    private String ybapplyFlag;

    public Short getStdIndicator() {
        return stdIndicator;
    }

    public void setStdIndicator(Short stdIndicator) {
        this.stdIndicator = stdIndicator;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getYbapplyFlag() {
        return ybapplyFlag;
    }

    public void setYbapplyFlag(String ybapplyFlag) {
        this.ybapplyFlag = ybapplyFlag == null ? null : ybapplyFlag.trim();
    }
}