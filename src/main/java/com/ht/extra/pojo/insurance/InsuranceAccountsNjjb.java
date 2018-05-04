package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InsuranceAccountsNjjb extends InsuranceAccountsNjjbKey {
    private String name;

    private String namePhonetic;

    private String sex;

    private Date dateOfBirth;

    private Date startDateOfWork;

    private Short workingYears;

    private BigDecimal salary;

    private String unit;

    private String identityClass;

    private String insuranceType;

    private BigDecimal accountRatedAmount;

    private BigDecimal paymentBeginningLine;

    private BigDecimal accountInitialAmount;

    private BigDecimal accountBalance;

    private BigDecimal accountReservedAmount;

    private Timestamp createDate;

    private Date expirationDate;

    private Date lastDepositDate;

    private Date cancelDate;

    private String cancelCause;

    private Timestamp updateDateTime;

    private String operator;

    private String insuranceLocation;

    private String insuranceLocationCode;

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

    public Date getStartDateOfWork() {
        return startDateOfWork;
    }

    public void setStartDateOfWork(Date startDateOfWork) {
        this.startDateOfWork = startDateOfWork;
    }

    public Short getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Short workingYears) {
        this.workingYears = workingYears;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getIdentityClass() {
        return identityClass;
    }

    public void setIdentityClass(String identityClass) {
        this.identityClass = identityClass == null ? null : identityClass.trim();
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType == null ? null : insuranceType.trim();
    }

    public BigDecimal getAccountRatedAmount() {
        return accountRatedAmount;
    }

    public void setAccountRatedAmount(BigDecimal accountRatedAmount) {
        this.accountRatedAmount = accountRatedAmount;
    }

    public BigDecimal getPaymentBeginningLine() {
        return paymentBeginningLine;
    }

    public void setPaymentBeginningLine(BigDecimal paymentBeginningLine) {
        this.paymentBeginningLine = paymentBeginningLine;
    }

    public BigDecimal getAccountInitialAmount() {
        return accountInitialAmount;
    }

    public void setAccountInitialAmount(BigDecimal accountInitialAmount) {
        this.accountInitialAmount = accountInitialAmount;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BigDecimal getAccountReservedAmount() {
        return accountReservedAmount;
    }

    public void setAccountReservedAmount(BigDecimal accountReservedAmount) {
        this.accountReservedAmount = accountReservedAmount;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getLastDepositDate() {
        return lastDepositDate;
    }

    public void setLastDepositDate(Date lastDepositDate) {
        this.lastDepositDate = lastDepositDate;
    }

    public Date getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(Date cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getCancelCause() {
        return cancelCause;
    }

    public void setCancelCause(String cancelCause) {
        this.cancelCause = cancelCause == null ? null : cancelCause.trim();
    }

    public Timestamp getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getInsuranceLocation() {
        return insuranceLocation;
    }

    public void setInsuranceLocation(String insuranceLocation) {
        this.insuranceLocation = insuranceLocation == null ? null : insuranceLocation.trim();
    }

    public String getInsuranceLocationCode() {
        return insuranceLocationCode;
    }

    public void setInsuranceLocationCode(String insuranceLocationCode) {
        this.insuranceLocationCode = insuranceLocationCode == null ? null : insuranceLocationCode.trim();
    }
}