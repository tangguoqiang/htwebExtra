package com.ht.extra.pojo.comm;

public class Metadict {
    private String tableName;

    private String tableDescription;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getTableDescription() {
        return tableDescription;
    }

    public void setTableDescription(String tableDescription) {
        this.tableDescription = tableDescription == null ? null : tableDescription.trim();
    }
}