package com.ht.extra.pojo.exam;

import java.util.Date;

public class ExamInquiry {
    private String examNo;

    private Date operDate;

    private String operDiagnosis;

    private String operDiagDoctor;

    private String accordWithOper;

    private String pathNo;

    private String pathDiagnosis;

    private String pathDiagDoctor;

    private String accordWithPath;

    private String finalDiagnosis;

    private String accordWithFinal;

    private Date inquDateTime;

    private String inquDoctor;

    private String memo;

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo == null ? null : examNo.trim();
    }

    public Date getOperDate() {
        return operDate;
    }

    public void setOperDate(Date operDate) {
        this.operDate = operDate;
    }

    public String getOperDiagnosis() {
        return operDiagnosis;
    }

    public void setOperDiagnosis(String operDiagnosis) {
        this.operDiagnosis = operDiagnosis == null ? null : operDiagnosis.trim();
    }

    public String getOperDiagDoctor() {
        return operDiagDoctor;
    }

    public void setOperDiagDoctor(String operDiagDoctor) {
        this.operDiagDoctor = operDiagDoctor == null ? null : operDiagDoctor.trim();
    }

    public String getAccordWithOper() {
        return accordWithOper;
    }

    public void setAccordWithOper(String accordWithOper) {
        this.accordWithOper = accordWithOper == null ? null : accordWithOper.trim();
    }

    public String getPathNo() {
        return pathNo;
    }

    public void setPathNo(String pathNo) {
        this.pathNo = pathNo == null ? null : pathNo.trim();
    }

    public String getPathDiagnosis() {
        return pathDiagnosis;
    }

    public void setPathDiagnosis(String pathDiagnosis) {
        this.pathDiagnosis = pathDiagnosis == null ? null : pathDiagnosis.trim();
    }

    public String getPathDiagDoctor() {
        return pathDiagDoctor;
    }

    public void setPathDiagDoctor(String pathDiagDoctor) {
        this.pathDiagDoctor = pathDiagDoctor == null ? null : pathDiagDoctor.trim();
    }

    public String getAccordWithPath() {
        return accordWithPath;
    }

    public void setAccordWithPath(String accordWithPath) {
        this.accordWithPath = accordWithPath == null ? null : accordWithPath.trim();
    }

    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis == null ? null : finalDiagnosis.trim();
    }

    public String getAccordWithFinal() {
        return accordWithFinal;
    }

    public void setAccordWithFinal(String accordWithFinal) {
        this.accordWithFinal = accordWithFinal == null ? null : accordWithFinal.trim();
    }

    public Date getInquDateTime() {
        return inquDateTime;
    }

    public void setInquDateTime(Date inquDateTime) {
        this.inquDateTime = inquDateTime;
    }

    public String getInquDoctor() {
        return inquDoctor;
    }

    public void setInquDoctor(String inquDoctor) {
        this.inquDoctor = inquDoctor == null ? null : inquDoctor.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}