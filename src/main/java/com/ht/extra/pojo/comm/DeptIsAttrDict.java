package com.ht.extra.pojo.comm;

public class DeptIsAttrDict {
    private Short isAttrCode;

    private Short serialNo;

    private String isAttrName;

    private String inputCode;

    public Short getIsAttrCode() {
        return isAttrCode;
    }

    public void setIsAttrCode(Short isAttrCode) {
        this.isAttrCode = isAttrCode;
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getIsAttrName() {
        return isAttrName;
    }

    public void setIsAttrName(String isAttrName) {
        this.isAttrName = isAttrName == null ? null : isAttrName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}