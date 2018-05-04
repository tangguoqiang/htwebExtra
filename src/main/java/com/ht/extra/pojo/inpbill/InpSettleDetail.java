package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;

public class InpSettleDetail extends InpSettleDetailKey {
    private BigDecimal payments;

    private BigDecimal costs;

    public BigDecimal getPayments() {
        return payments;
    }

    public void setPayments(BigDecimal payments) {
        this.payments = payments;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }
}