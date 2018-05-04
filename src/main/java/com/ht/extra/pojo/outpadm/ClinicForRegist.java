package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;

public class ClinicForRegist extends ClinicForRegistKey {
    private Short registrationLimits;

    private Short appointmentLimits;

    private Short currentNo;

    private Short registrationNum;

    private Short appointmentNum;

    private BigDecimal registPrice;

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

    public Short getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(Short currentNo) {
        this.currentNo = currentNo;
    }

    public Short getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(Short registrationNum) {
        this.registrationNum = registrationNum;
    }

    public Short getAppointmentNum() {
        return appointmentNum;
    }

    public void setAppointmentNum(Short appointmentNum) {
        this.appointmentNum = appointmentNum;
    }

    public BigDecimal getRegistPrice() {
        return registPrice;
    }

    public void setRegistPrice(BigDecimal registPrice) {
        this.registPrice = registPrice;
    }
}