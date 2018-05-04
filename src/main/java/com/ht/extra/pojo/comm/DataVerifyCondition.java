package com.ht.extra.pojo.comm;

public class DataVerifyCondition extends DataVerifyConditionKey {
    private String relativeTables;

    private String primaryColumn;

    private String primaryColumnChinese;

    private String relativeColumns;

    private Short conditionType;

    private String conditionSql;

    private String conditionPb;

    private Short errorLevel;

    private String errorMessage;

    private String memo;

    private Short enableIndicator;

    public String getRelativeTables() {
        return relativeTables;
    }

    public void setRelativeTables(String relativeTables) {
        this.relativeTables = relativeTables == null ? null : relativeTables.trim();
    }

    public String getPrimaryColumn() {
        return primaryColumn;
    }

    public void setPrimaryColumn(String primaryColumn) {
        this.primaryColumn = primaryColumn == null ? null : primaryColumn.trim();
    }

    public String getPrimaryColumnChinese() {
        return primaryColumnChinese;
    }

    public void setPrimaryColumnChinese(String primaryColumnChinese) {
        this.primaryColumnChinese = primaryColumnChinese == null ? null : primaryColumnChinese.trim();
    }

    public String getRelativeColumns() {
        return relativeColumns;
    }

    public void setRelativeColumns(String relativeColumns) {
        this.relativeColumns = relativeColumns == null ? null : relativeColumns.trim();
    }

    public Short getConditionType() {
        return conditionType;
    }

    public void setConditionType(Short conditionType) {
        this.conditionType = conditionType;
    }

    public String getConditionSql() {
        return conditionSql;
    }

    public void setConditionSql(String conditionSql) {
        this.conditionSql = conditionSql == null ? null : conditionSql.trim();
    }

    public String getConditionPb() {
        return conditionPb;
    }

    public void setConditionPb(String conditionPb) {
        this.conditionPb = conditionPb == null ? null : conditionPb.trim();
    }

    public Short getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(Short errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Short getEnableIndicator() {
        return enableIndicator;
    }

    public void setEnableIndicator(Short enableIndicator) {
        this.enableIndicator = enableIndicator;
    }
}