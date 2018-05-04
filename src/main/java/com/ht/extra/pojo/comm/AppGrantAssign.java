package com.ht.extra.pojo.comm;

public class AppGrantAssign extends AppGrantAssignKey {
    private String grantName;

    private String grantDesc;

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName == null ? null : grantName.trim();
    }

    public String getGrantDesc() {
        return grantDesc;
    }

    public void setGrantDesc(String grantDesc) {
        this.grantDesc = grantDesc == null ? null : grantDesc.trim();
    }
}