package com.ht.extra.pojo.medrec;

import java.math.BigDecimal;
import java.util.Date;

public class InpPatientCheckLog extends InpPatientCheckLogKey {
    private String deptCode;

    private String bedNo;

    private Date admissionDate;

    private Date applyCheckDate;

    private String applyer;

    private String inpNo;

    private String name;

    private String infoStatus;

    private String checkType;

    private String checkStatus;

    private Date checkDate;

    private String checker;

    private Date settleDate;

    private String settler;

    private Date disabledDate;

    private String changer;

    private BigDecimal checkCosts;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo == null ? null : bedNo.trim();
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getApplyCheckDate() {
        return applyCheckDate;
    }

    public void setApplyCheckDate(Date applyCheckDate) {
        this.applyCheckDate = applyCheckDate;
    }

    public String getApplyer() {
        return applyer;
    }

    public void setApplyer(String applyer) {
        this.applyer = applyer == null ? null : applyer.trim();
    }

    public String getInpNo() {
        return inpNo;
    }

    public void setInpNo(String inpNo) {
        this.inpNo = inpNo == null ? null : inpNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus == null ? null : infoStatus.trim();
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType == null ? null : checkType.trim();
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    public String getSettler() {
        return settler;
    }

    public void setSettler(String settler) {
        this.settler = settler == null ? null : settler.trim();
    }

    public Date getDisabledDate() {
        return disabledDate;
    }

    public void setDisabledDate(Date disabledDate) {
        this.disabledDate = disabledDate;
    }

    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer == null ? null : changer.trim();
    }

    public BigDecimal getCheckCosts() {
        return checkCosts;
    }

    public void setCheckCosts(BigDecimal checkCosts) {
        this.checkCosts = checkCosts;
    }
}