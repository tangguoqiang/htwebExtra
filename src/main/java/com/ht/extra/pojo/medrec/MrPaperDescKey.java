package com.ht.extra.pojo.medrec;

public class MrPaperDescKey {
    private String paperSize;

    private String bindPosition;

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize == null ? null : paperSize.trim();
    }

    public String getBindPosition() {
        return bindPosition;
    }

    public void setBindPosition(String bindPosition) {
        this.bindPosition = bindPosition == null ? null : bindPosition.trim();
    }
}