package com.ht.extra.pojo.comm;

public class DrugImportClassDict {
    private String importClass;

    private Short serialNo;

    public String getImportClass() {
        return importClass;
    }

    public void setImportClass(String importClass) {
        this.importClass = importClass == null ? null : importClass.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }
}