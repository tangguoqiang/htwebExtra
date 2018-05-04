package com.ht.extra.pojo.comm;

public class InputSettingKey {
    private String dictType;

    private String dataCol;

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public String getDataCol() {
        return dataCol;
    }

    public void setDataCol(String dataCol) {
        this.dataCol = dataCol == null ? null : dataCol.trim();
    }
}