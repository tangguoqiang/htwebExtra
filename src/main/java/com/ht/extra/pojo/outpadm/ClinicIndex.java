package com.ht.extra.pojo.outpadm;

import com.ht.extra.pojo.comm.DoctorTitleDict;

import java.math.BigDecimal;
import java.util.List;

public class ClinicIndex {
    private String clinicLabel;

    private String clinicDept;

    private String doctor;

    private String doctorTitle;

    private String clinicType;

    private String inputCode;

    private Short serialNo;

    private DoctorTitleDict doctorTitleDict;

    private BigDecimal price;

    private String clinicTypeName;

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel == null ? null : clinicLabel.trim();
    }

    public String getClinicDept() {
        return clinicDept;
    }

    public void setClinicDept(String clinicDept) {
        this.clinicDept = clinicDept == null ? null : clinicDept.trim();
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

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType == null ? null : clinicType.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public DoctorTitleDict getDoctorTitleDict(){
        return doctorTitleDict;
    }

    public void setDoctorTitleDict(DoctorTitleDict doctorTitleDict){
        this.doctorTitleDict = doctorTitleDict;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getClinicTypeName() {
        return clinicTypeName;
    }

    public void setClinicTypeName(String clinicTypeName) {
        this.clinicTypeName = clinicTypeName;
    }
}