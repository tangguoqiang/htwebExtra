package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;
import java.util.Date;

public class InsuOutpSettleRecord {
    private String insuRcptNo;

    private String insuCardNo;

    private Date insuVisitDate;

    private BigDecimal outpFee;

    private BigDecimal drugTotal;

    private BigDecimal medicalTotal;

    private BigDecimal paymentSelf;

    private BigDecimal insuRangeTotal;

    private BigDecimal payFromAccount;

    private BigDecimal payFromFund;

    private BigDecimal largerDiagnosisPayment;

    private BigDecimal payFromInsured;

    private BigDecimal accountInitialAmount;

    private BigDecimal accountEndAmount;

    private String insuOperatorNo;

    private String rcptNo;

    private String refundedRcptNo;

    private String patName;

    private String identityClass;

    private BigDecimal payFromCash;

    private String chargeClass;

    private String insuranceClass;

    private BigDecimal payFromAllowance;

    private BigDecimal payFromCivil;

    public String getInsuRcptNo() {
        return insuRcptNo;
    }

    public void setInsuRcptNo(String insuRcptNo) {
        this.insuRcptNo = insuRcptNo == null ? null : insuRcptNo.trim();
    }

    public String getInsuCardNo() {
        return insuCardNo;
    }

    public void setInsuCardNo(String insuCardNo) {
        this.insuCardNo = insuCardNo == null ? null : insuCardNo.trim();
    }

    public Date getInsuVisitDate() {
        return insuVisitDate;
    }

    public void setInsuVisitDate(Date insuVisitDate) {
        this.insuVisitDate = insuVisitDate;
    }

    public BigDecimal getOutpFee() {
        return outpFee;
    }

    public void setOutpFee(BigDecimal outpFee) {
        this.outpFee = outpFee;
    }

    public BigDecimal getDrugTotal() {
        return drugTotal;
    }

    public void setDrugTotal(BigDecimal drugTotal) {
        this.drugTotal = drugTotal;
    }

    public BigDecimal getMedicalTotal() {
        return medicalTotal;
    }

    public void setMedicalTotal(BigDecimal medicalTotal) {
        this.medicalTotal = medicalTotal;
    }

    public BigDecimal getPaymentSelf() {
        return paymentSelf;
    }

    public void setPaymentSelf(BigDecimal paymentSelf) {
        this.paymentSelf = paymentSelf;
    }

    public BigDecimal getInsuRangeTotal() {
        return insuRangeTotal;
    }

    public void setInsuRangeTotal(BigDecimal insuRangeTotal) {
        this.insuRangeTotal = insuRangeTotal;
    }

    public BigDecimal getPayFromAccount() {
        return payFromAccount;
    }

    public void setPayFromAccount(BigDecimal payFromAccount) {
        this.payFromAccount = payFromAccount;
    }

    public BigDecimal getPayFromFund() {
        return payFromFund;
    }

    public void setPayFromFund(BigDecimal payFromFund) {
        this.payFromFund = payFromFund;
    }

    public BigDecimal getLargerDiagnosisPayment() {
        return largerDiagnosisPayment;
    }

    public void setLargerDiagnosisPayment(BigDecimal largerDiagnosisPayment) {
        this.largerDiagnosisPayment = largerDiagnosisPayment;
    }

    public BigDecimal getPayFromInsured() {
        return payFromInsured;
    }

    public void setPayFromInsured(BigDecimal payFromInsured) {
        this.payFromInsured = payFromInsured;
    }

    public BigDecimal getAccountInitialAmount() {
        return accountInitialAmount;
    }

    public void setAccountInitialAmount(BigDecimal accountInitialAmount) {
        this.accountInitialAmount = accountInitialAmount;
    }

    public BigDecimal getAccountEndAmount() {
        return accountEndAmount;
    }

    public void setAccountEndAmount(BigDecimal accountEndAmount) {
        this.accountEndAmount = accountEndAmount;
    }

    public String getInsuOperatorNo() {
        return insuOperatorNo;
    }

    public void setInsuOperatorNo(String insuOperatorNo) {
        this.insuOperatorNo = insuOperatorNo == null ? null : insuOperatorNo.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getRefundedRcptNo() {
        return refundedRcptNo;
    }

    public void setRefundedRcptNo(String refundedRcptNo) {
        this.refundedRcptNo = refundedRcptNo == null ? null : refundedRcptNo.trim();
    }

    public String getPatName() {
        return patName;
    }

    public void setPatName(String patName) {
        this.patName = patName == null ? null : patName.trim();
    }

    public String getIdentityClass() {
        return identityClass;
    }

    public void setIdentityClass(String identityClass) {
        this.identityClass = identityClass == null ? null : identityClass.trim();
    }

    public BigDecimal getPayFromCash() {
        return payFromCash;
    }

    public void setPayFromCash(BigDecimal payFromCash) {
        this.payFromCash = payFromCash;
    }

    public String getChargeClass() {
        return chargeClass;
    }

    public void setChargeClass(String chargeClass) {
        this.chargeClass = chargeClass == null ? null : chargeClass.trim();
    }

    public String getInsuranceClass() {
        return insuranceClass;
    }

    public void setInsuranceClass(String insuranceClass) {
        this.insuranceClass = insuranceClass == null ? null : insuranceClass.trim();
    }

    public BigDecimal getPayFromAllowance() {
        return payFromAllowance;
    }

    public void setPayFromAllowance(BigDecimal payFromAllowance) {
        this.payFromAllowance = payFromAllowance;
    }

    public BigDecimal getPayFromCivil() {
        return payFromCivil;
    }

    public void setPayFromCivil(BigDecimal payFromCivil) {
        this.payFromCivil = payFromCivil;
    }
}