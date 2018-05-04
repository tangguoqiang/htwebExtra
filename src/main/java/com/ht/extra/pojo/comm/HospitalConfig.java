package com.ht.extra.pojo.comm;

public class HospitalConfig {
    private String hospital;

    private String authorizedKey;

    private String unitCode;

    private String location;

    private String mailingAddress;

    private String zipCode;

    private Short approvedBedNum;

    private Short hospitalType;

    private String hospitalClass;

    private String hospitalNo;

    private String verifyKey;

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital == null ? null : hospital.trim();
    }

    public String getAuthorizedKey() {
        return authorizedKey;
    }

    public void setAuthorizedKey(String authorizedKey) {
        this.authorizedKey = authorizedKey == null ? null : authorizedKey.trim();
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode == null ? null : unitCode.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public Short getApprovedBedNum() {
        return approvedBedNum;
    }

    public void setApprovedBedNum(Short approvedBedNum) {
        this.approvedBedNum = approvedBedNum;
    }

    public Short getHospitalType() {
        return hospitalType;
    }

    public void setHospitalType(Short hospitalType) {
        this.hospitalType = hospitalType;
    }

    public String getHospitalClass() {
        return hospitalClass;
    }

    public void setHospitalClass(String hospitalClass) {
        this.hospitalClass = hospitalClass == null ? null : hospitalClass.trim();
    }

    public String getHospitalNo() {
        return hospitalNo;
    }

    public void setHospitalNo(String hospitalNo) {
        this.hospitalNo = hospitalNo == null ? null : hospitalNo.trim();
    }

    public String getVerifyKey() {
        return verifyKey;
    }

    public void setVerifyKey(String verifyKey) {
        this.verifyKey = verifyKey == null ? null : verifyKey.trim();
    }
}