package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class DrugDictReturn81 extends DrugDictReturn81Key {
    private String drugName;

    private BigDecimal ratio;

    private String memo;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public BigDecimal getRatio() {
        return ratio;
    }

    public void setRatio(BigDecimal ratio) {
        this.ratio = ratio;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}