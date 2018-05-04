package com.ht.extra.pojo.comm;

import java.util.Date;

public class UserWorkingLogKey {
    private String userId;

    private Date operDateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getOperDateTime() {
        return operDateTime;
    }

    public void setOperDateTime(Date operDateTime) {
        this.operDateTime = operDateTime;
    }
}