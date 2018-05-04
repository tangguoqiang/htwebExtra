package com.ht.extra.pojo.comm;

public class ApplicationConfig extends ApplicationConfigKey {
    private String value;

    private String memo;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}