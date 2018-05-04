package com.ht.extra.pojo.medrec;

import java.util.Date;

public class QuestionMrRecord extends QuestionMrRecordKey {
    private String inpNo;

    private Date mrExaminationDate;

    private String mrExaminer;

    private Date mrReturnDate;

    private String mrReturner;

    private Date mrNurseConfirmDate;

    private String mrNurseConfirmer;

    private Date mrSubmitDate;

    private String mrSubmitUser;

    private Date mrConfirmDate;

    private String mrCofirmer;

    private String mrStatus;

    private String memo;

    private Short score;

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
    }

    public Date getMrExaminationDate() {
        return mrExaminationDate;
    }

    public void setMrExaminationDate(Date mrExaminationDate) {
        this.mrExaminationDate = mrExaminationDate;
    }

    public String getMrExaminer() {
        return mrExaminer;
    }

    public void setMrExaminer(String mrExaminer) {
        this.mrExaminer = mrExaminer == null ? null : mrExaminer.trim();
    }

    public Date getMrReturnDate() {
        return mrReturnDate;
    }

    public void setMrReturnDate(Date mrReturnDate) {
        this.mrReturnDate = mrReturnDate;
    }

    public String getMrReturner() {
        return mrReturner;
    }

    public void setMrReturner(String mrReturner) {
        this.mrReturner = mrReturner == null ? null : mrReturner.trim();
    }

    public Date getMrNurseConfirmDate() {
        return mrNurseConfirmDate;
    }

    public void setMrNurseConfirmDate(Date mrNurseConfirmDate) {
        this.mrNurseConfirmDate = mrNurseConfirmDate;
    }

    public String getMrNurseConfirmer() {
        return mrNurseConfirmer;
    }

    public void setMrNurseConfirmer(String mrNurseConfirmer) {
        this.mrNurseConfirmer = mrNurseConfirmer == null ? null : mrNurseConfirmer.trim();
    }

    public Date getMrSubmitDate() {
        return mrSubmitDate;
    }

    public void setMrSubmitDate(Date mrSubmitDate) {
        this.mrSubmitDate = mrSubmitDate;
    }

    public String getMrSubmitUser() {
        return mrSubmitUser;
    }

    public void setMrSubmitUser(String mrSubmitUser) {
        this.mrSubmitUser = mrSubmitUser == null ? null : mrSubmitUser.trim();
    }

    public Date getMrConfirmDate() {
        return mrConfirmDate;
    }

    public void setMrConfirmDate(Date mrConfirmDate) {
        this.mrConfirmDate = mrConfirmDate;
    }

    public String getMrCofirmer() {
        return mrCofirmer;
    }

    public void setMrCofirmer(String mrCofirmer) {
        this.mrCofirmer = mrCofirmer == null ? null : mrCofirmer.trim();
    }

    public String getMrStatus() {
        return mrStatus;
    }

    public void setMrStatus(String mrStatus) {
        this.mrStatus = mrStatus == null ? null : mrStatus.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }
}