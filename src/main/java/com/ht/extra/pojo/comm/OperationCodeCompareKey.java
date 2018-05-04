package com.ht.extra.pojo.comm;

public class OperationCodeCompareKey {
    private String oldCode;

    private String oldName;

    public String getOldCode() {
        return oldCode;
    }

    public void setOldCode(String oldCode) {
        this.oldCode = oldCode == null ? null : oldCode.trim();
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName == null ? null : oldName.trim();
    }
}