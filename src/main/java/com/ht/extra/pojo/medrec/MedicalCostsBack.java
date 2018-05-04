package com.ht.extra.pojo.medrec;

import java.math.BigDecimal;

public class MedicalCostsBack extends MedicalCostsBackKey {
    private BigDecimal costs;

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }
}