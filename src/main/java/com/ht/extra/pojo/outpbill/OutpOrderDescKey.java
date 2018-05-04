package com.ht.extra.pojo.outpbill;

import java.sql.Timestamp;
import java.util.Date;

public class OutpOrderDescKey {
    private Timestamp visitDate;

    private Short visitNo;

    public Date getVisitDate() {
        return visitDate;
    }


    public Short getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Short visitNo) {
        this.visitNo = visitNo;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }
}