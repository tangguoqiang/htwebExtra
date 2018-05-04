package com.ht.extra.pojo.comm;

public class ClassCodingRuleKey {
    private String item;

    private Short codeLevel;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
    }

    public Short getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Short codeLevel) {
        this.codeLevel = codeLevel;
    }
}