package com.ht.extra.pojo.comm;

public class DrugExportClassDict {
    private String exportClass;

    private Short serialNo;

    public String getExportClass() {
        return exportClass;
    }

    public void setExportClass(String exportClass) {
        this.exportClass = exportClass == null ? null : exportClass.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }
}