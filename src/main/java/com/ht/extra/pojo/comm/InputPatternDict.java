package com.ht.extra.pojo.comm;

public class InputPatternDict extends InputPatternDictKey {
    private Short serialNo;

    private String inputItemContent;

    private String inputCode;

    private Short userDefine;

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getInputItemContent() {
        return inputItemContent;
    }

    public void setInputItemContent(String inputItemContent) {
        this.inputItemContent = inputItemContent == null ? null : inputItemContent.trim();
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