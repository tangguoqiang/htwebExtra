package com.ht.extra.pojo.inpbill;

public class CasherNoRec {
    private String localNo;

    private String userId;

    public String getLocalNo() {
        return localNo;
    }

    public void setLocalNo(String localNo) {
        this.localNo = localNo == null ? null : localNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}