package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class SpecialRegistPrice extends SpecialRegistPriceKey {
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}