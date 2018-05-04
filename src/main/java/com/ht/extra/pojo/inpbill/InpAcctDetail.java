package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;

public class InpAcctDetail extends InpAcctDetailKey {
    private BigDecimal costs;

    private BigDecimal income;

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }
}