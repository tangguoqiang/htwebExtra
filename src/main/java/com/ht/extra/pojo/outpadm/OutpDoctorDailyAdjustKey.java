package com.ht.extra.pojo.outpadm;

import java.util.Date;

public class OutpDoctorDailyAdjustKey {
    private Date clinicDate;

    private String clinicDept;

    private String doctor;

    private String queueName;

    private Short adjustType;

    public Date getClinicDate() {
        return clinicDate;
    }

    public void setClinicDate(Date clinicDate) {
        this.clinicDate = clinicDate;
    }

    public String getClinicDept() {
        return clinicDept;
    }

    public void setClinicDept(String clinicDept) {
        this.clinicDept = clinicDept == null ? null : clinicDept.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName == null ? null : queueName.trim();
    }

    public Short getAdjustType() {
        return adjustType;
    }

    public void setAdjustType(Short adjustType) {
        this.adjustType = adjustType;
    }
}