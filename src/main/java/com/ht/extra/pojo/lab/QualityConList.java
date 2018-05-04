package com.ht.extra.pojo.lab;

import java.math.BigDecimal;

public class QualityConList extends QualityConListKey {
    private String operator;

    private BigDecimal controlResult;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public BigDecimal getControlResult() {
        return controlResult;
    }

    public void setControlResult(BigDecimal controlResult) {
        this.controlResult = controlResult;
    }
}