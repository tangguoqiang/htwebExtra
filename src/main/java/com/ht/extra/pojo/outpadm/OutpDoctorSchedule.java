package com.ht.extra.pojo.outpadm;

public class OutpDoctorSchedule extends OutpDoctorScheduleKey {
    private String clinicDuration;

    private String queueName;

    public String getClinicDuration() {
        return clinicDuration;
    }

    public void setClinicDuration(String clinicDuration) {
        this.clinicDuration = clinicDuration == null ? null : clinicDuration.trim();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName == null ? null : queueName.trim();
    }
}