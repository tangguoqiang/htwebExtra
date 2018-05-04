package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;

public class ClinicSchedule extends ClinicScheduleKey {
    private Short registrationLimits;

    private Short appointmentLimits;

    private ClinicIndex clinicIndex;

    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ClinicIndex getClinicIndex() {
        return clinicIndex;
    }

    public void setClinicIndex(ClinicIndex clinicIndex) {
        this.clinicIndex = clinicIndex;
    }
    public Short getRegistrationLimits() {
        return registrationLimits;
    }

    public void setRegistrationLimits(Short registrationLimits) {
        this.registrationLimits = registrationLimits;
    }

    public Short getAppointmentLimits() {
        return appointmentLimits;
    }

    public void setAppointmentLimits(Short appointmentLimits) {
        this.appointmentLimits = appointmentLimits;
    }
}