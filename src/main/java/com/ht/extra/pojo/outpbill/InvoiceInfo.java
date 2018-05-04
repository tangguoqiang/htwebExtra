package com.ht.extra.pojo.outpbill;

import java.math.BigDecimal;
import java.util.Date;

public class InvoiceInfo extends InvoiceInfoKey {
    private String diskNo;

    private String appType;

    private Date rcptDate;

    private String rcptNo;

    private String invoiceContent;

    private BigDecimal invoiceCosts;

    private String verifyCode;

    private Date reportDate;

    private String invoiceStatus;

    public String getDiskNo() {
        return diskNo;
    }

    public void setDiskNo(String diskNo) {
        this.diskNo = diskNo == null ? null : diskNo.trim();
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    public Date getRcptDate() {
        return rcptDate;
    }

    public void setRcptDate(Date rcptDate) {
        this.rcptDate = rcptDate;
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getInvoiceContent() {
        return invoiceContent;
    }

    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent == null ? null : invoiceContent.trim();
    }

    public BigDecimal getInvoiceCosts() {
        return invoiceCosts;
    }

    public void setInvoiceCosts(BigDecimal invoiceCosts) {
        this.invoiceCosts = invoiceCosts;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode == null ? null : verifyCode.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus == null ? null : invoiceStatus.trim();
    }
}