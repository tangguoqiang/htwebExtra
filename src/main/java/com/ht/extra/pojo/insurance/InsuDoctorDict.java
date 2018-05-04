package com.ht.extra.pojo.insurance;

public class InsuDoctorDict {
    private String doctCode;

    private String doctName;

    private String doctDeptCode;

    private String doctSex;

    private String doctInsuNo;

    private String doctEducation;

    private String doctCertificateNo;

    private String inputCode;

    public String getDoctCode() {
        return doctCode;
    }

    public void setDoctCode(String doctCode) {
        this.doctCode = doctCode == null ? null : doctCode.trim();
    }

    public String getDoctName() {
        return doctName;
    }

    public void setDoctName(String doctName) {
        this.doctName = doctName == null ? null : doctName.trim();
    }

    public String getDoctDeptCode() {
        return doctDeptCode;
    }

    public void setDoctDeptCode(String doctDeptCode) {
        this.doctDeptCode = doctDeptCode == null ? null : doctDeptCode.trim();
    }

    public String getDoctSex() {
        return doctSex;
    }

    public void setDoctSex(String doctSex) {
        this.doctSex = doctSex == null ? null : doctSex.trim();
    }

    public String getDoctInsuNo() {
        return doctInsuNo;
    }

    public void setDoctInsuNo(String doctInsuNo) {
        this.doctInsuNo = doctInsuNo == null ? null : doctInsuNo.trim();
    }

    public String getDoctEducation() {
        return doctEducation;
    }

    public void setDoctEducation(String doctEducation) {
        this.doctEducation = doctEducation == null ? null : doctEducation.trim();
    }

    public String getDoctCertificateNo() {
        return doctCertificateNo;
    }

    public void setDoctCertificateNo(String doctCertificateNo) {
        this.doctCertificateNo = doctCertificateNo == null ? null : doctCertificateNo.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}