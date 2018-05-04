package com.ht.extra.pojo.medrec;

import java.math.BigDecimal;

public class MedicalCosts extends MedicalCostsKey {
    private BigDecimal costs;

    private BigDecimal totcosts;

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public BigDecimal getTotcosts() {
        return totcosts;
    }

    public void setTotcosts(BigDecimal totcosts) {
        this.totcosts = totcosts;
    }
}