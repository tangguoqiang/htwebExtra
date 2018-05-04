package com.ht.extra.pojo.outpdoct;

import java.util.Date;

public class OutpWaitQueue extends OutpWaitQueueKey {
    private Date visitDate;

    private Short visitNo;

    private Short workedIndicator;

    private String doctor;

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

    public Short getWorkedIndicator() {
        return workedIndicator;
    }

    public void setWorkedIndicator(Short workedIndicator) {
        this.workedIndicator = workedIndicator;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }
}