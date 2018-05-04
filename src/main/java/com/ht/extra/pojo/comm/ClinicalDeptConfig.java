package com.ht.extra.pojo.comm;

public class ClinicalDeptConfig {
    private String deptCode;

    private Short bedNumber;

    private Short chiefPhysicianNum;

    private Short attendingDoctorNum;

    private Short residentNum;

    private Short nurseNum;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
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

    public Short getResidentNum() {
        return residentNum;
    }

    public void setResidentNum(Short residentNum) {
        this.residentNum = residentNum;
    }

    public Short getNurseNum() {
        return nurseNum;
    }

    public void setNurseNum(Short nurseNum) {
        this.nurseNum = nurseNum;
    }
}