package com.ht.extra.pojo.outpdoct;

import java.math.BigDecimal;

public class OutpMrTemplate extends OutpMrTemplateKey {
    private BigDecimal scope;

    private String dept;

    private String owner;

    public BigDecimal getScope() {
        return scope;
    }

    public void setScope(BigDecimal scope) {
        this.scope = scope;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }
}