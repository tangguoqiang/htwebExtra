package com.ht.extra.pojo.medrec;

import java.util.Date;

public class MrCirculation extends MrCirculationKey {
    private String inpNo;

    private Date mrSubmitDate;

    private String mrSubmitUser;

    private Date mrConfirmDate;

    private String mrCofirmer;

    private Date mrExaminationDate;

    private String mrExaminer;

    private String mrBinder;

    private Date mrArchiveDate;

    private String mrArchiver;

    private String mrStatus;

    private Short score;

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
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

    public String getMrBinder() {
        return mrBinder;
    }

    public void setMrBinder(String mrBinder) {
        this.mrBinder = mrBinder == null ? null : mrBinder.trim();
    }

    public Date getMrArchiveDate() {
        return mrArchiveDate;
    }

    public void setMrArchiveDate(Date mrArchiveDate) {
        this.mrArchiveDate = mrArchiveDate;
    }

    public String getMrArchiver() {
        return mrArchiver;
    }

    public void setMrArchiver(String mrArchiver) {
        this.mrArchiver = mrArchiver == null ? null : mrArchiver.trim();
    }

    public String getMrStatus() {
        return mrStatus;
    }

    public void setMrStatus(String mrStatus) {
        this.mrStatus = mrStatus == null ? null : mrStatus.trim();
    }

    public Short getScore() {
        return score;
    }

    public void setScore(Short score) {
        this.score = score;
    }
}