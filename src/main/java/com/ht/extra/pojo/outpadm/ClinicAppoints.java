package com.ht.extra.pojo.outpadm;

import java.util.Date;

public class ClinicAppoints extends ClinicAppointsKey {
    private Date apptMadeDate;

    private String clinicAttr;

    private String clinicSource;

    private Short serialNo;

    public Date getApptMadeDate() {
        return apptMadeDate;
    }

    public void setApptMadeDate(Date apptMadeDate) {
        this.apptMadeDate = apptMadeDate;
    }

    public String getClinicAttr() {
        return clinicAttr;
    }

    public void setClinicAttr(String clinicAttr) {
        this.clinicAttr = clinicAttr == null ? null : clinicAttr.trim();
    }

    public String getClinicSource() {
        return clinicSource;
    }

    public void setClinicSource(String clinicSource) {
        this.clinicSource = clinicSource == null ? null : clinicSource.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }
}