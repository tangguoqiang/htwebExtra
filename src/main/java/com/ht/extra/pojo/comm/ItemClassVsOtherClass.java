package com.ht.extra.pojo.comm;

public class ItemClassVsOtherClass {
    private String itemClass;

    private String itemCode;

    private String classOnInpRcpt;

    private String classOnOutpRcpt;

    private String classOnReckoning;

    private String subjCode;

    private String classOnMr;

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getClassOnInpRcpt() {
        return classOnInpRcpt;
    }

    public void setClassOnInpRcpt(String classOnInpRcpt) {
        this.classOnInpRcpt = classOnInpRcpt == null ? null : classOnInpRcpt.trim();
    }

    public String getClassOnOutpRcpt() {
        return classOnOutpRcpt;
    }

    public void setClassOnOutpRcpt(String classOnOutpRcpt) {
        this.classOnOutpRcpt = classOnOutpRcpt == null ? null : classOnOutpRcpt.trim();
    }

    public String getClassOnReckoning() {
        return classOnReckoning;
    }

    public void setClassOnReckoning(String classOnReckoning) {
        this.classOnReckoning = classOnReckoning == null ? null : classOnReckoning.trim();
    }

    public String getSubjCode() {
        return subjCode;
    }

    public void setSubjCode(String subjCode) {
        this.subjCode = subjCode == null ? null : subjCode.trim();
    }

    public String getClassOnMr() {
        return classOnMr;
    }

    public void setClassOnMr(String classOnMr) {
        this.classOnMr = classOnMr == null ? null : classOnMr.trim();
    }
}