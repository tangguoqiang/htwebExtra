package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class AccountPriceList81 extends AccountPriceList81Key {
    private Long account;

    private BigDecimal charges;

    private BigDecimal costs;

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }
}