package com.ht.extra.pojo.comm;

public class DataVerifySchema {
    private String schemaCode;

    private Integer serialNo;

    private String schemaName;

    private String schemaSource;

    private String schemaSourceExt1;

    private String schemaSourceExt2;

    private String fatalErrorLevels;

    public String getSchemaCode() {
        return schemaCode;
    }

    public void setSchemaCode(String schemaCode) {
        this.schemaCode = schemaCode == null ? null : schemaCode.trim();
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName == null ? null : schemaName.trim();
    }

    public String getSchemaSource() {
        return schemaSource;
    }

    public void setSchemaSource(String schemaSource) {
        this.schemaSource = schemaSource == null ? null : schemaSource.trim();
    }

    public String getSchemaSourceExt1() {
        return schemaSourceExt1;
    }

    public void setSchemaSourceExt1(String schemaSourceExt1) {
        this.schemaSourceExt1 = schemaSourceExt1 == null ? null : schemaSourceExt1.trim();
    }

    public String getSchemaSourceExt2() {
        return schemaSourceExt2;
    }

    public void setSchemaSourceExt2(String schemaSourceExt2) {
        this.schemaSourceExt2 = schemaSourceExt2 == null ? null : schemaSourceExt2.trim();
    }

    public String getFatalErrorLevels() {
        return fatalErrorLevels;
    }

    public void setFatalErrorLevels(String fatalErrorLevels) {
        this.fatalErrorLevels = fatalErrorLevels == null ? null : fatalErrorLevels.trim();
    }
}