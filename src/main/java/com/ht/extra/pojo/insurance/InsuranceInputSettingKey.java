package com.ht.extra.pojo.insurance;

public class InsuranceInputSettingKey {
    private String interfacecode;

    private String dictType;

    private String dataCol;

    public String getInterfacecode() {
        return interfacecode;
    }

    public void setInterfacecode(String interfacecode) {
        this.interfacecode = interfacecode == null ? null : interfacecode.trim();
    }

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