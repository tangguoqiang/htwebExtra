package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class InputSetting extends InputSettingKey {
    private String dataTable;

    private String inputCode;

    private String dataTitle;

    private String flagShow;

    private BigDecimal showSort;

    private String flagIsname;

    private BigDecimal resultSort;

    private Short showWidth;

    public String getDataTable() {
        return dataTable;
    }

    public void setDataTable(String dataTable) {
        this.dataTable = dataTable == null ? null : dataTable.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle == null ? null : dataTitle.trim();
    }

    public String getFlagShow() {
        return flagShow;
    }

    public void setFlagShow(String flagShow) {
        this.flagShow = flagShow == null ? null : flagShow.trim();
    }

    public BigDecimal getShowSort() {
        return showSort;
    }

    public void setShowSort(BigDecimal showSort) {
        this.showSort = showSort;
    }

    public String getFlagIsname() {
        return flagIsname;
    }

    public void setFlagIsname(String flagIsname) {
        this.flagIsname = flagIsname == null ? null : flagIsname.trim();
    }

    public BigDecimal getResultSort() {
        return resultSort;
    }

    public void setResultSort(BigDecimal resultSort) {
        this.resultSort = resultSort;
    }

    public Short getShowWidth() {
        return showWidth;
    }

    public void setShowWidth(Short showWidth) {
        this.showWidth = showWidth;
    }
}