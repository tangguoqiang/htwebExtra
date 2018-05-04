package com.ht.extra.pojo.outpbill;

import java.sql.Timestamp;
import java.util.Date;

public class OutpBillItemsKey {
    private Timestamp visitDate;

    private Short visitNo;

    private Short itemNo;

    public Date getVisitDate() {
        return visitDate;
    }


    public Short getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Short visitNo) {
        this.visitNo = visitNo;
    }

    public Short getItemNo() {
        return itemNo;
    }

    public void setItemNo(Short itemNo) {
        this.itemNo = itemNo;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }
}