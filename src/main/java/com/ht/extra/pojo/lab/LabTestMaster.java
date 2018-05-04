package com.ht.extra.pojo.lab;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class LabTestMaster {
    private String testNo;

    private Short priorityIndicator;

    private String patientId;

    private Short visitId;

    private String workingId;

    private Timestamp executeDate;

    private String name;

    private String namePhonetic;

    private String chargeType;

    private String sex;

    private Short age;

    private String testCause;

    private String relevantClinicDiag;

    private String specimen;

    private String notesForSpcm;

    private Timestamp spcmReceivedDateTime;

    private Timestamp spcmSampleDateTime;

    private Timestamp requestedDateTime;

    private String orderingDept;

    private String orderingProvider;

    private String performedBy;

    private String resultStatus;

    private Timestamp resultsRptDateTime;

    private String transcriptionist;

    private String verifiedBy;

    private BigDecimal costs;

    private BigDecimal charges;

    private Short billingIndicator;

    private Short printIndicator;

    private String subject;

    private Timestamp dateOfBirth;

    private String patientSource;

    private Timestamp visitDate;

    private Short visitNo;

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo == null ? null : testNo.trim();
    }

    public Short getPriorityIndicator() {
        return priorityIndicator;
    }

    public void setPriorityIndicator(Short priorityIndicator) {
        this.priorityIndicator = priorityIndicator;
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

    public String getWorkingId() {
        return workingId;
    }

    public void setWorkingId(String workingId) {
        this.workingId = workingId == null ? null : workingId.trim();
    }

    public Date getExecuteDate() {
        return executeDate;
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

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
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

    public String getTestCause() {
        return testCause;
    }

    public void setTestCause(String testCause) {
        this.testCause = testCause == null ? null : testCause.trim();
    }

    public String getRelevantClinicDiag() {
        return relevantClinicDiag;
    }

    public void setRelevantClinicDiag(String relevantClinicDiag) {
        this.relevantClinicDiag = relevantClinicDiag == null ? null : relevantClinicDiag.trim();
    }

    public String getSpecimen() {
        return specimen;
    }

    public void setSpecimen(String specimen) {
        this.specimen = specimen == null ? null : specimen.trim();
    }

    public String getNotesForSpcm() {
        return notesForSpcm;
    }

    public void setNotesForSpcm(String notesForSpcm) {
        this.notesForSpcm = notesForSpcm == null ? null : notesForSpcm.trim();
    }

    public Date getSpcmReceivedDateTime() {
        return spcmReceivedDateTime;
    }


    public Date getSpcmSampleDateTime() {
        return spcmSampleDateTime;
    }


    public Date getRequestedDateTime() {
        return requestedDateTime;
    }


    public String getOrderingDept() {
        return orderingDept;
    }

    public void setOrderingDept(String orderingDept) {
        this.orderingDept = orderingDept == null ? null : orderingDept.trim();
    }

    public String getOrderingProvider() {
        return orderingProvider;
    }

    public void setOrderingProvider(String orderingProvider) {
        this.orderingProvider = orderingProvider == null ? null : orderingProvider.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
    }

    public Date getResultsRptDateTime() {
        return resultsRptDateTime;
    }


    public String getTranscriptionist() {
        return transcriptionist;
    }

    public void setTranscriptionist(String transcriptionist) {
        this.transcriptionist = transcriptionist == null ? null : transcriptionist.trim();
    }

    public String getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy == null ? null : verifiedBy.trim();
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public BigDecimal getCharges() {
        return charges;
    }

    public void setCharges(BigDecimal charges) {
        this.charges = charges;
    }

    public Short getBillingIndicator() {
        return billingIndicator;
    }

    public void setBillingIndicator(Short billingIndicator) {
        this.billingIndicator = billingIndicator;
    }

    public Short getPrintIndicator() {
        return printIndicator;
    }

    public void setPrintIndicator(Short printIndicator) {
        this.printIndicator = printIndicator;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public String getPatientSource() {
        return patientSource;
    }

    public void setPatientSource(String patientSource) {
        this.patientSource = patientSource == null ? null : patientSource.trim();
    }

    public Date getVisitDate() {
        return visitDate;
    }


    public Short getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Short visitNo) {
        this.visitNo = visitNo;
    }

    public void setSpcmReceivedDateTime(Timestamp spcmReceivedDateTime) {
        this.spcmReceivedDateTime = spcmReceivedDateTime;
    }

    public void setSpcmSampleDateTime(Timestamp spcmSampleDateTime) {
        this.spcmSampleDateTime = spcmSampleDateTime;
    }

    public void setRequestedDateTime(Timestamp requestedDateTime) {
        this.requestedDateTime = requestedDateTime;
    }

    public void setResultsRptDateTime(Timestamp resultsRptDateTime) {
        this.resultsRptDateTime = resultsRptDateTime;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    public void setExecuteDate(Timestamp executeDate) {
        this.executeDate = executeDate;
    }
}