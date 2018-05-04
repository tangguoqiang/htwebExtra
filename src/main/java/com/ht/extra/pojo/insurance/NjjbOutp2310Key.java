package com.ht.extra.pojo.insurance;

import java.util.Date;

public class NjjbOutp2310Key {
    private Date visitDate;

    private Integer visitNo;

    private Integer itemNo;

    private String rcptNo;

    private Short sign;

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Integer getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Integer visitNo) {
        this.visitNo = visitNo;
    }

    public Integer getItemNo() {
        return itemNo;
    }

    public void setItemNo(Integer itemNo) {
        this.itemNo = itemNo;
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public Short getSign() {
        return sign;
    }

    public void setSign(Short sign) {
        this.sign = sign;
    }
}