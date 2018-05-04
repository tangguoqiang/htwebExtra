package com.ht.extra.pojo.medrec;

import java.util.Date;

public class MrTraceLogKey {
    private String mrClass;

    private String transferAttr;

    private String mrNo;

    private Date releasedDateTime;

    public String getMrClass() {
        return mrClass;
    }

    public void setMrClass(String mrClass) {
        this.mrClass = mrClass == null ? null : mrClass.trim();
    }

    public String getTransferAttr() {
        return transferAttr;
    }

    public void setTransferAttr(String transferAttr) {
        this.transferAttr = transferAttr == null ? null : transferAttr.trim();
    }

    public String getMrNo() {
        return mrNo;
    }

    public void setMrNo(String mrNo) {
        this.mrNo = mrNo == null ? null : mrNo.trim();
    }

    public Date getReleasedDateTime() {
        return releasedDateTime;
    }

    public void setReleasedDateTime(Date releasedDateTime) {
        this.releasedDateTime = releasedDateTime;
    }
}