package com.ht.extra.pojo.exam;

import java.math.BigDecimal;
import java.util.Date;

public class ExamMasterItems {
    private Long serialNo;

    private String examNo;

    private String examSubClass;

    private String examItem;

    private String examItemCode;

    private String localIdClass;

    private String dicomModality;

    private String patientLocalId;

    private String device;

    private Date scheduledDateTime;

    private String notice;

    private Date examDateTime;

    private Date reportDateTime;

    private String technician;

    private String reporter;

    private String verifier;

    private Long reportNo;

    private String resultStatus;

    private BigDecimal costs;

    private String itemId;

    public Long getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo == null ? null : examNo.trim();
    }

    public String getExamSubClass() {
        return examSubClass;
    }

    public void setExamSubClass(String examSubClass) {
        this.examSubClass = examSubClass == null ? null : examSubClass.trim();
    }

    public String getExamItem() {
        return examItem;
    }

    public void setExamItem(String examItem) {
        this.examItem = examItem == null ? null : examItem.trim();
    }

    public String getExamItemCode() {
        return examItemCode;
    }

    public void setExamItemCode(String examItemCode) {
        this.examItemCode = examItemCode == null ? null : examItemCode.trim();
    }

    public String getLocalIdClass() {
        return localIdClass;
    }

    public void setLocalIdClass(String localIdClass) {
        this.localIdClass = localIdClass == null ? null : localIdClass.trim();
    }

    public String getDicomModality() {
        return dicomModality;
    }

    public void setDicomModality(String dicomModality) {
        this.dicomModality = dicomModality == null ? null : dicomModality.trim();
    }

    public String getPatientLocalId() {
        return patientLocalId;
    }

    public void setPatientLocalId(String patientLocalId) {
        this.patientLocalId = patientLocalId == null ? null : patientLocalId.trim();
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public Date getScheduledDateTime() {
        return scheduledDateTime;
    }

    public void setScheduledDateTime(Date scheduledDateTime) {
        this.scheduledDateTime = scheduledDateTime;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public Date getExamDateTime() {
        return examDateTime;
    }

    public void setExamDateTime(Date examDateTime) {
        this.examDateTime = examDateTime;
    }

    public Date getReportDateTime() {
        return reportDateTime;
    }

    public void setReportDateTime(Date reportDateTime) {
        this.reportDateTime = reportDateTime;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician == null ? null : technician.trim();
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter == null ? null : reporter.trim();
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier == null ? null : verifier.trim();
    }

    public Long getReportNo() {
        return reportNo;
    }

    public void setReportNo(Long reportNo) {
        this.reportNo = reportNo;
    }

    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }
}