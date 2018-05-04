package com.ht.extra.pojo.outpbill;

import java.math.BigDecimal;

public class OutpPaymentsMoney extends OutpPaymentsMoneyKey {
    private Short paymentNo;

    private BigDecimal paymentAmount;

    private BigDecimal refundedAmount;

    private String prepayNo;

    public Short getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(Short paymentNo) {
        this.paymentNo = paymentNo;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public BigDecimal getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(BigDecimal refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public String getPrepayNo() {
        return prepayNo;
    }

    public void setPrepayNo(String prepayNo) {
        this.prepayNo = prepayNo == null ? null : prepayNo.trim();
    }
}