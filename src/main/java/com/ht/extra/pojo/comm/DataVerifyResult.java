package com.ht.extra.pojo.comm;

import java.util.Date;

public class DataVerifyResult extends DataVerifyResultKey {
    private String verifyType;

    private Short conditionNo;

    private String errorIndicator;

    private Date rectifyDateTime;

    private String operator;

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

    public String getErrorIndicator() {
        return errorIndicator;
    }

    public void setErrorIndicator(String errorIndicator) {
        this.errorIndicator = errorIndicator == null ? null : errorIndicator.trim();
    }

    public Date getRectifyDateTime() {
        return rectifyDateTime;
    }

    public void setRectifyDateTime(Date rectifyDateTime) {
        this.rectifyDateTime = rectifyDateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}