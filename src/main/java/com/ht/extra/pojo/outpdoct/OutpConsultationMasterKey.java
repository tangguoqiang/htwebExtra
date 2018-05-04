package com.ht.extra.pojo.outpdoct;

import java.util.Date;

public class OutpConsultationMasterKey {
    private Date visitDate;

    private Short visitNo;

    private Short consultationId;

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Short getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Short visitNo) {
        this.visitNo = visitNo;
    }

    public Short getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Short consultationId) {
        this.consultationId = consultationId;
    }
}