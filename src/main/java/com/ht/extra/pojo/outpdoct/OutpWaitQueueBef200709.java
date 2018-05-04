package com.ht.extra.pojo.outpdoct;

import java.util.Date;

public class OutpWaitQueueBef200709 {
    private Date visitDate;

    private Short visitNo;

    private Short queueSequence;

    private String counselNo;

    private String queueName;

    private String registerDept;

    private Date registerDate;

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

    public Short getQueueSequence() {
        return queueSequence;
    }

    public void setQueueSequence(Short queueSequence) {
        this.queueSequence = queueSequence;
    }

    public String getCounselNo() {
        return counselNo;
    }

    public void setCounselNo(String counselNo) {
        this.counselNo = counselNo == null ? null : counselNo.trim();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName == null ? null : queueName.trim();
    }

    public String getRegisterDept() {
        return registerDept;
    }

    public void setRegisterDept(String registerDept) {
        this.registerDept = registerDept == null ? null : registerDept.trim();
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
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