package com.ht.extra.pojo.comm;

public class DeptOiAttrDict {
    private Short oiAttrCode;

    private Short serialNo;

    private String oiAttrName;

    private String inputCode;

    public Short getOiAttrCode() {
        return oiAttrCode;
    }

    public void setOiAttrCode(Short oiAttrCode) {
        this.oiAttrCode = oiAttrCode;
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getOiAttrName() {
        return oiAttrName;
    }

    public void setOiAttrName(String oiAttrName) {
        this.oiAttrName = oiAttrName == null ? null : oiAttrName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}