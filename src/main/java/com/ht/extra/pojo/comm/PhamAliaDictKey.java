package com.ht.extra.pojo.comm;

public class PhamAliaDictKey {
    private String phamCode;

    private String phamName;

    public String getPhamCode() {
        return phamCode;
    }

    public void setPhamCode(String phamCode) {
        this.phamCode = phamCode == null ? null : phamCode.trim();
    }

    public String getPhamName() {
        return phamName;
    }

    public void setPhamName(String phamName) {
        this.phamName = phamName == null ? null : phamName.trim();
    }
}