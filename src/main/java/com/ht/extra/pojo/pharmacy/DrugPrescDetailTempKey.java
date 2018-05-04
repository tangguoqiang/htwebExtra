package com.ht.extra.pojo.pharmacy;

import java.util.Date;

public class DrugPrescDetailTempKey {
    private Date prescDate;

    private Short prescNo;

    private Short itemNo;

    public Date getPrescDate() {
        return prescDate;
    }

    public void setPrescDate(Date prescDate) {
        this.prescDate = prescDate;
    }

    public Short getPrescNo() {
        return prescNo;
    }

    public void setPrescNo(Short prescNo) {
        this.prescNo = prescNo;
    }

    public Short getItemNo() {
        return itemNo;
    }

    public void setItemNo(Short itemNo) {
        this.itemNo = itemNo;
    }
}