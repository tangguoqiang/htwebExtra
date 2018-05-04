package com.ht.extra.pojo.comm;

public class QueryCondition extends QueryConditionKey {
    private String conditionType;

    private String queryCondition;

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType == null ? null : conditionType.trim();
    }

    public String getQueryCondition() {
        return queryCondition;
    }

    public void setQueryCondition(String queryCondition) {
        this.queryCondition = queryCondition == null ? null : queryCondition.trim();
    }
}