package com.ht.extra.pojo.outpbill;

import java.util.Date;

public class RcptVsSeqItems {
    private String rcptNo;

    private Date seqDate;

    private String seqNo;

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public Date getSeqDate() {
        return seqDate;
    }

    public void setSeqDate(Date seqDate) {
        this.seqDate = seqDate;
    }

    public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo == null ? null : seqNo.trim();
    }
}