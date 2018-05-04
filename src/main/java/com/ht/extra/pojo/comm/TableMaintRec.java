package com.ht.extra.pojo.comm;

public class TableMaintRec extends TableMaintRecKey {
    private String tableChineseName;

    private String contentBeforeMaint;

    private String contentAfterMaint;

    private String correlativeSoftware;

    private String memo;

    public String getTableChineseName() {
        return tableChineseName;
    }

    public void setTableChineseName(String tableChineseName) {
        this.tableChineseName = tableChineseName == null ? null : tableChineseName.trim();
    }

    public String getContentBeforeMaint() {
        return contentBeforeMaint;
    }

    public void setContentBeforeMaint(String contentBeforeMaint) {
        this.contentBeforeMaint = contentBeforeMaint == null ? null : contentBeforeMaint.trim();
    }

    public String getContentAfterMaint() {
        return contentAfterMaint;
    }

    public void setContentAfterMaint(String contentAfterMaint) {
        this.contentAfterMaint = contentAfterMaint == null ? null : contentAfterMaint.trim();
    }

    public String getCorrelativeSoftware() {
        return correlativeSoftware;
    }

    public void setCorrelativeSoftware(String correlativeSoftware) {
        this.correlativeSoftware = correlativeSoftware == null ? null : correlativeSoftware.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}