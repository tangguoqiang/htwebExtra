package com.ht.extra.pojo.medrec;

import java.util.Date;

public class Transfer extends TransferKey {
    private String deptStayed;

    private Date dischargeDateTime;

    private String deptTransferedTo;

    private String doctorInCharge;

    private String doctorDept;

    public String getDeptStayed() {
        return deptStayed;
    }

    public void setDeptStayed(String deptStayed) {
        this.deptStayed = deptStayed == null ? null : deptStayed.trim();
    }

    public Date getDischargeDateTime() {
        return dischargeDateTime;
    }

    public void setDischargeDateTime(Date dischargeDateTime) {
        this.dischargeDateTime = dischargeDateTime;
    }

    public String getDeptTransferedTo() {
        return deptTransferedTo;
    }

    public void setDeptTransferedTo(String deptTransferedTo) {
        this.deptTransferedTo = deptTransferedTo == null ? null : deptTransferedTo.trim();
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public void setDoctorInCharge(String doctorInCharge) {
        this.doctorInCharge = doctorInCharge == null ? null : doctorInCharge.trim();
    }

    public String getDoctorDept() {
        return doctorDept;
    }

    public void setDoctorDept(String doctorDept) {
        this.doctorDept = doctorDept == null ? null : doctorDept.trim();
    }
}