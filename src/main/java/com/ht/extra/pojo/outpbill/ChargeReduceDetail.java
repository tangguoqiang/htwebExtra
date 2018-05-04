package com.ht.extra.pojo.outpbill;

import java.math.BigDecimal;

public class ChargeReduceDetail extends ChargeReduceDetailKey {
    private String rcptNo;

    private BigDecimal reduceAmount;

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }
}