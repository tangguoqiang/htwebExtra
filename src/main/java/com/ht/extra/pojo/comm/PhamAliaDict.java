package com.ht.extra.pojo.comm;

public class PhamAliaDict extends PhamAliaDictKey {
    private Short stdIndicator;

    private String phoneticHeadCode;

    private String fourConerCode;

    public Short getStdIndicator() {
        return stdIndicator;
    }

    public void setStdIndicator(Short stdIndicator) {
        this.stdIndicator = stdIndicator;
    }

    public String getPhoneticHeadCode() {
        return phoneticHeadCode;
    }

    public void setPhoneticHeadCode(String phoneticHeadCode) {
        this.phoneticHeadCode = phoneticHeadCode == null ? null : phoneticHeadCode.trim();
    }

    public String getFourConerCode() {
        return fourConerCode;
    }

    public void setFourConerCode(String fourConerCode) {
        this.fourConerCode = fourConerCode == null ? null : fourConerCode.trim();
    }
}