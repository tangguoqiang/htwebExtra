package com.ht.extra.pojo.comm;

public class OutpPrescClass {
    private String prescClass;

    private String prescName;

    private String memo;

    private String prescAlias;

    public String getPrescClass() {
        return prescClass;
    }

    public void setPrescClass(String prescClass) {
        this.prescClass = prescClass == null ? null : prescClass.trim();
    }

    public String getPrescName() {
        return prescName;
    }

    public void setPrescName(String prescName) {
        this.prescName = prescName == null ? null : prescName.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getPrescAlias() {
        return prescAlias;
    }

    public void setPrescAlias(String prescAlias) {
        this.prescAlias = prescAlias == null ? null : prescAlias.trim();
    }
}