package com.ht.extra.pojo.medrec;

public class PmiMergedLog extends PmiMergedLogKey {
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}