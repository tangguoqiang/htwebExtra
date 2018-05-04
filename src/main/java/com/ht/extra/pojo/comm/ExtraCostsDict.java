package com.ht.extra.pojo.comm;

public class ExtraCostsDict extends ExtraCostsDictKey {
    private String extraItemClass;

    private String extraItemCode;

    private String extraItemSpec;

    public String getExtraItemClass() {
        return extraItemClass;
    }

    public void setExtraItemClass(String extraItemClass) {
        this.extraItemClass = extraItemClass == null ? null : extraItemClass.trim();
    }

    public String getExtraItemCode() {
        return extraItemCode;
    }

    public void setExtraItemCode(String extraItemCode) {
        this.extraItemCode = extraItemCode == null ? null : extraItemCode.trim();
    }

    public String getExtraItemSpec() {
        return extraItemSpec;
    }

    public void setExtraItemSpec(String extraItemSpec) {
        this.extraItemSpec = extraItemSpec == null ? null : extraItemSpec.trim();
    }
}