package com.ht.extra.pojo.comm;

public class OuterCodeDict extends OuterCodeDictKey {
    private String outerCode;

    public String getOuterCode() {
        return outerCode;
    }

    public void setOuterCode(String outerCode) {
        this.outerCode = outerCode == null ? null : outerCode.trim();
    }
}