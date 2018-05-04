package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.util.Date;

public class UnsettleRec extends UnsettleRecKey {
    private String name;

    private String deptName;

    private String chargeTypeName;

    private String mailingAddress;

    private String unitOfWork;

    private String phoneNumberHome;

    private String phoneNumberBusiness;

    private BigDecimal totalCost;

    private BigDecimal prepayments;

    private String guarantor;

    private String unitOfGuarantor;

    private String operator;

    private Date enterDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getChargeTypeName() {
        return chargeTypeName;
    }

    public void setChargeTypeName(String chargeTypeName) {
        this.chargeTypeName = chargeTypeName == null ? null : chargeTypeName.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getUnitOfWork() {
        return unitOfWork;
    }

    public void setUnitOfWork(String unitOfWork) {
        this.unitOfWork = unitOfWork == null ? null : unitOfWork.trim();
    }

    public String getPhoneNumberHome() {
        return phoneNumberHome;
    }

    public void setPhoneNumberHome(String phoneNumberHome) {
        this.phoneNumberHome = phoneNumberHome == null ? null : phoneNumberHome.trim();
    }

    public String getPhoneNumberBusiness() {
        return phoneNumberBusiness;
    }

    public void setPhoneNumberBusiness(String phoneNumberBusiness) {
        this.phoneNumberBusiness = phoneNumberBusiness == null ? null : phoneNumberBusiness.trim();
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getPrepayments() {
        return prepayments;
    }

    public void setPrepayments(BigDecimal prepayments) {
        this.prepayments = prepayments;
    }

    public String getGuarantor() {
        return guarantor;
    }

    public void setGuarantor(String guarantor) {
        this.guarantor = guarantor == null ? null : guarantor.trim();
    }

    public String getUnitOfGuarantor() {
        return unitOfGuarantor;
    }

    public void setUnitOfGuarantor(String unitOfGuarantor) {
        this.unitOfGuarantor = unitOfGuarantor == null ? null : unitOfGuarantor.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }
}