package com.ht.extra.pojo.comm;

public class QueryConditionKey {
    private String application;

    private String queryTitle;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getQueryTitle() {
        return queryTitle;
    }

    public void setQueryTitle(String queryTitle) {
        this.queryTitle = queryTitle == null ? null : queryTitle.trim();
    }
}