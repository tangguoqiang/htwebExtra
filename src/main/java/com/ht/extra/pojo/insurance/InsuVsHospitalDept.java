package com.ht.extra.pojo.insurance;

public class InsuVsHospitalDept extends InsuVsHospitalDeptKey {
    private String insuDeptName;

    private String deptName;

    private Short bedNumber;

    private Short chiefPhysicianNum;

    private Short attendingDoctorNum;

    private Short resigentNum;

    public String getInsuDeptName() {
        return insuDeptName;
    }

    public void setInsuDeptName(String insuDeptName) {
        this.insuDeptName = insuDeptName == null ? null : insuDeptName.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Short getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(Short bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Short getChiefPhysicianNum() {
        return chiefPhysicianNum;
    }

    public void setChiefPhysicianNum(Short chiefPhysicianNum) {
        this.chiefPhysicianNum = chiefPhysicianNum;
    }

    public Short getAttendingDoctorNum() {
        return attendingDoctorNum;
    }

    public void setAttendingDoctorNum(Short attendingDoctorNum) {
        this.attendingDoctorNum = attendingDoctorNum;
    }

    public Short getResigentNum() {
        return resigentNum;
    }

    public void setResigentNum(Short resigentNum) {
        this.resigentNum = resigentNum;
    }
}