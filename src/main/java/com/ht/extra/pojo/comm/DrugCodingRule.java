package com.ht.extra.pojo.comm;

public class DrugCodingRule {
    private Short codeLevel;

    private Short levelWidth;

    private String className;

    public Short getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(Short codeLevel) {
        this.codeLevel = codeLevel;
    }

    public Short getLevelWidth() {
        return levelWidth;
    }

    public void setLevelWidth(Short levelWidth) {
        this.levelWidth = levelWidth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }
}