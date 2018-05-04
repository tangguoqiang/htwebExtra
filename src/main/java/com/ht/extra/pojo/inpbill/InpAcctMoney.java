package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;

public class InpAcctMoney extends InpAcctMoneyKey {
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