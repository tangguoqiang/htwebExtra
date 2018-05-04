package com.ht.extra.pojo.comm;

public class AppGrantsKey {
    private String application;

    private String userId;

    private String capability;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability == null ? null : capability.trim();
    }
}