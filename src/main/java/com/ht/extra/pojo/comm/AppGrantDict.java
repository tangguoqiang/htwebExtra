package com.ht.extra.pojo.comm;

public class AppGrantDict extends AppGrantDictKey {
    private String grantDesc;

    public String getGrantDesc() {
        return grantDesc;
    }

    public void setGrantDesc(String grantDesc) {
        this.grantDesc = grantDesc == null ? null : grantDesc.trim();
    }
}