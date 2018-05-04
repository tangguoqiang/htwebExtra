package com.ht.extra.pojo.outpbill;

import java.math.BigDecimal;

public class OutpAcctMoney extends OutpAcctMoneyKey {
    private BigDecimal incomeAmount;

    private BigDecimal refundedAmount;

    public BigDecimal getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(BigDecimal incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public BigDecimal getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(BigDecimal refundedAmount) {
        this.refundedAmount = refundedAmount;
    }
}