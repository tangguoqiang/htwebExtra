package com.ht.extra.pojo.outpadm;

public class OutpDoctorScheduleKey {
    private String clinicDept;

    private Short dayOfWeek;

    private String doctor;

    public String getClinicDept() {
        return clinicDept;
    }

    public void setClinicDept(String clinicDept) {
        this.clinicDept = clinicDept == null ? null : clinicDept.trim();
    }

    public Short getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Short dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }
}