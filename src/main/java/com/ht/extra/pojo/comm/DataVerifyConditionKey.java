package com.ht.extra.pojo.comm;

public class DataVerifyConditionKey {
    private String verifyType;

    private Short conditionNo;

    public String getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(String verifyType) {
        this.verifyType = verifyType == null ? null : verifyType.trim();
    }

    public Short getConditionNo() {
        return conditionNo;
    }

    public void setConditionNo(Short conditionNo) {
        this.conditionNo = conditionNo;
    }
}