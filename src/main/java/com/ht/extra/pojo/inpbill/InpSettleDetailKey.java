package com.ht.extra.pojo.inpbill;

public class InpSettleDetailKey {
    private String rcptNo;

    private String feeClassName;

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getFeeClassName() {
        return feeClassName;
    }

    public void setFeeClassName(String feeClassName) {
        this.feeClassName = feeClassName == null ? null : feeClassName.trim();
    }
}