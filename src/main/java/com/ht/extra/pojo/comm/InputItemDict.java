package com.ht.extra.pojo.comm;

public class InputItemDict extends InputItemDictKey {
    private Short serialNo;

    private String inputItemCode;

    private String inputCode;

    private Short userDefine;

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getInputItemCode() {
        return inputItemCode;
    }

    public void setInputItemCode(String inputItemCode) {
        this.inputItemCode = inputItemCode == null ? null : inputItemCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public Short getUserDefine() {
        return userDefine;
    }

    public void setUserDefine(Short userDefine) {
        this.userDefine = userDefine;
    }
}