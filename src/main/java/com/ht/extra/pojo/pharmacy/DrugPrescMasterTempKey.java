package com.ht.extra.pojo.pharmacy;

import java.util.Date;

public class DrugPrescMasterTempKey {
    private Date prescDate;

    private Short prescNo;

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
}