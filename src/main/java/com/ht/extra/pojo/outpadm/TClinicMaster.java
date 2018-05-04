package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;
import java.util.Date;

public class TClinicMaster {
    private Date visitDate;

    private String visitTime;

    private Short visitNo;

    private Short clinicId;

    private Short serialNo;

    private String patientId;

    private String name;

    private String namePhonetic;

    private String sex;

    private Short age;

    private String identity;

    private String chargeType;

    private String unitInContract;

    private String clinicType;

    private Short firstVisitIndicator;

    private String visitDept;

    private String visitSpecialClinic;

    private String doctor;

    private String doctorTitle;

    private Short mrProvideIndicator;

    private Short registryStatus;

    private Date registryDate;

    private BigDecimal clinicPrice;

    private String operator;

    private Date returnedDate;

    private String returnedOperator;

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime == null ? null : visitTime.trim();
    }

    public Short getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Short visitNo) {
        this.visitNo = visitNo;
    }

    public Short getClinicId() {
        return clinicId;
    }

    public void setClinicId(Short clinicId) {
        this.clinicId = clinicId;
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNamePhonetic() {
        return namePhonetic;
    }

    public void setNamePhonetic(String namePhonetic) {
        this.namePhonetic = namePhonetic == null ? null : namePhonetic.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getUnitInContract() {
        return unitInContract;
    }

    public void setUnitInContract(String unitInContract) {
        this.unitInContract = unitInContract == null ? null : unitInContract.trim();
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType == null ? null : clinicType.trim();
    }

    public Short getFirstVisitIndicator() {
        return firstVisitIndicator;
    }

    public void setFirstVisitIndicator(Short firstVisitIndicator) {
        this.firstVisitIndicator = firstVisitIndicator;
    }

    public String getVisitDept() {
        return visitDept;
    }

    public void setVisitDept(String visitDept) {
        this.visitDept = visitDept == null ? null : visitDept.trim();
    }

    public String getVisitSpecialClinic() {
        return visitSpecialClinic;
    }

    public void setVisitSpecialClinic(String visitSpecialClinic) {
        this.visitSpecialClinic = visitSpecialClinic == null ? null : visitSpecialClinic.trim();
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor == null ? null : doctor.trim();
    }

    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle == null ? null : doctorTitle.trim();
    }

    public Short getMrProvideIndicator() {
        return mrProvideIndicator;
    }

    public void setMrProvideIndicator(Short mrProvideIndicator) {
        this.mrProvideIndicator = mrProvideIndicator;
    }

    public Short getRegistryStatus() {
        return registryStatus;
    }

    public void setRegistryStatus(Short registryStatus) {
        this.registryStatus = registryStatus;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

    public BigDecimal getClinicPrice() {
        return clinicPrice;
    }

    public void setClinicPrice(BigDecimal clinicPrice) {
        this.clinicPrice = clinicPrice;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public String getReturnedOperator() {
        return returnedOperator;
    }

    public void setReturnedOperator(String returnedOperator) {
        this.returnedOperator = returnedOperator == null ? null : returnedOperator.trim();
    }
}