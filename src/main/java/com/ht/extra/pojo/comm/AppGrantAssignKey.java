package com.ht.extra.pojo.comm;

public class AppGrantAssignKey {
    private String application;

    private String grantCode;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getGrantCode() {
        return grantCode;
    }

    public void setGrantCode(String grantCode) {
        this.grantCode = grantCode == null ? null : grantCode.trim();
    }
}