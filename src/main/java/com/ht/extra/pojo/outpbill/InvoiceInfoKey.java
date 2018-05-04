package com.ht.extra.pojo.outpbill;

public class InvoiceInfoKey {
    private String invoiceNo;

    private String rcptType;

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo == null ? null : invoiceNo.trim();
    }

    public String getRcptType() {
        return rcptType;
    }

    public void setRcptType(String rcptType) {
        this.rcptType = rcptType == null ? null : rcptType.trim();
    }
}