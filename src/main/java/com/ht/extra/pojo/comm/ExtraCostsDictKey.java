package com.ht.extra.pojo.comm;

public class ExtraCostsDictKey {
    private String orderCont;

    private Short extraItemNo;

    public String getOrderCont() {
        return orderCont;
    }

    public void setOrderCont(String orderCont) {
        this.orderCont = orderCont == null ? null : orderCont.trim();
    }

    public Short getExtraItemNo() {
        return extraItemNo;
    }

    public void setExtraItemNo(Short extraItemNo) {
        this.extraItemNo = extraItemNo;
    }
}