package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.util.Date;

public class InpDietCosts extends InpDietCostsKey {
    private BigDecimal costs;

    private String dietProvider;

    private Date billingDateTime;

    private String operatorNo;

    private String rcptNo;

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public String getDietProvider() {
        return dietProvider;
    }

    public void setDietProvider(String dietProvider) {
        this.dietProvider = dietProvider == null ? null : dietProvider.trim();
    }

    public Date getBillingDateTime() {
        return billingDateTime;
    }

    public void setBillingDateTime(Date billingDateTime) {
        this.billingDateTime = billingDateTime;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }
}