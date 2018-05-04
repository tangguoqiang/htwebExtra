package com.ht.extra.pojo.exam;

import java.math.BigDecimal;
import java.util.Date;

public class VExamReq {
    private String examNo;

    private String patientId;

    private Short visitId;

    private String name;

    private String sex;

    private Date dateOfBirth;

    private String examClass;

    private String examSubClass;

    private String clinSymp;

    private String physSign;

    private String chargeType;

    private String relevantLabTest;

    private String relevantDiag;

    private String clinDiag;

    private String performedBy;

    private String performedDeptname;

    private String patientSource;

    private Date reqDateTime;

    private String reqDept;

    private String reqDeptname;

    private String reqPhysician;

    private Short examItemNo;

    private String examItemCode;

    private String examItem;

    private BigDecimal bedNo;

    private String inpNo;

    private String mailingAddress;

    private String zipCode;

    private String phoneNumber;

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo == null ? null : examNo.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass == null ? null : examClass.trim();
    }

    public String getExamSubClass() {
        return examSubClass;
    }

    public void setExamSubClass(String examSubClass) {
        this.examSubClass = examSubClass == null ? null : examSubClass.trim();
    }

    public String getClinSymp() {
        return clinSymp;
    }

    public void setClinSymp(String clinSymp) {
        this.clinSymp = clinSymp == null ? null : clinSymp.trim();
    }

    public String getPhysSign() {
        return physSign;
    }

    public void setPhysSign(String physSign) {
        this.physSign = physSign == null ? null : physSign.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getRelevantLabTest() {
        return relevantLabTest;
    }

    public void setRelevantLabTest(String relevantLabTest) {
        this.relevantLabTest = relevantLabTest == null ? null : relevantLabTest.trim();
    }

    public String getRelevantDiag() {
        return relevantDiag;
    }

    public void setRelevantDiag(String relevantDiag) {
        this.relevantDiag = relevantDiag == null ? null : relevantDiag.trim();
    }

    public String getClinDiag() {
        return clinDiag;
    }

    public void setClinDiag(String clinDiag) {
        this.clinDiag = clinDiag == null ? null : clinDiag.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public String getPerformedDeptname() {
        return performedDeptname;
    }

    public void setPerformedDeptname(String performedDeptname) {
        this.performedDeptname = performedDeptname == null ? null : performedDeptname.trim();
    }

    public String getPatientSource() {
        return patientSource;
    }

    public void setPatientSource(String patientSource) {
        this.patientSource = patientSource == null ? null : patientSource.trim();
    }

    public Date getReqDateTime() {
        return reqDateTime;
    }

    public void setReqDateTime(Date reqDateTime) {
        this.reqDateTime = reqDateTime;
    }

    public String getReqDept() {
        return reqDept;
    }

    public void setReqDept(String reqDept) {
        this.reqDept = reqDept == null ? null : reqDept.trim();
    }

    public String getReqDeptname() {
        return reqDeptname;
    }

    public void setReqDeptname(String reqDeptname) {
        this.reqDeptname = reqDeptname == null ? null : reqDeptname.trim();
    }

    public String getReqPhysician() {
        return reqPhysician;
    }

    public void setReqPhysician(String reqPhysician) {
        this.reqPhysician = reqPhysician == null ? null : reqPhysician.trim();
    }

    public Short getExamItemNo() {
        return examItemNo;
    }

    public void setExamItemNo(Short examItemNo) {
        this.examItemNo = examItemNo;
    }

    public String getExamItemCode() {
        return examItemCode;
    }

    public void setExamItemCode(String examItemCode) {
        this.examItemCode = examItemCode == null ? null : examItemCode.trim();
    }

    public String getExamItem() {
        return examItem;
    }

    public void setExamItem(String examItem) {
        this.examItem = examItem == null ? null : examItem.trim();
    }

    public BigDecimal getBedNo() {
        return bedNo;
    }

    public void setBedNo(BigDecimal bedNo) {
        this.bedNo = bedNo;
    }

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }
}