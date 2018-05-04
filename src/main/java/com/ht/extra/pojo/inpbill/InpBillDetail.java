package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class InpBillDetail extends InpBillDetailKey {
    private String itemClass;

    private String itemName;

    private String itemCode;

    private String itemSpec;

    private BigDecimal amount;

    private String units;

    private String orderedBy;

    private String performedBy;

    private BigDecimal costs;

    private BigDecimal charges;

    private Timestamp billingDateTime;

    private String operatorNo;

    private String rcptNo;

    private BigDecimal specialCharges;

    private BigDecimal freeLimit;

    private BigDecimal price;

    private BigDecimal purchasePrice;

    private String doctorDept;

    private String checker;

    private Date checkTime;

    private String machineCode;

    private Short settleFlag;

    private Short deductIndicator;

    private String classOnInpRcpt;

    private String subjCode;

    private String classOnMr;

    private String classOnReckoning;

    private String flag;

    private BigDecimal ownCosts;

    private BigDecimal insurCosts;

    private String itemSerialNo;

    private String updateFlag;

    private String gsFlag;

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec == null ? null : itemSpec.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy == null ? null : orderedBy.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
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


    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public BigDecimal getSpecialCharges() {
        return specialCharges;
    }

    public void setSpecialCharges(BigDecimal specialCharges) {
        this.specialCharges = specialCharges;
    }

    public BigDecimal getFreeLimit() {
        return freeLimit;
    }

    public void setFreeLimit(BigDecimal freeLimit) {
        this.freeLimit = freeLimit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getDoctorDept() {
        return doctorDept;
    }

    public void setDoctorDept(String doctorDept) {
        this.doctorDept = doctorDept == null ? null : doctorDept.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode == null ? null : machineCode.trim();
    }

    public Short getSettleFlag() {
        return settleFlag;
    }

    public void setSettleFlag(Short settleFlag) {
        this.settleFlag = settleFlag;
    }

    public Short getDeductIndicator() {
        return deductIndicator;
    }

    public void setDeductIndicator(Short deductIndicator) {
        this.deductIndicator = deductIndicator;
    }

    public String getClassOnInpRcpt() {
        return classOnInpRcpt;
    }

    public void setClassOnInpRcpt(String classOnInpRcpt) {
        this.classOnInpRcpt = classOnInpRcpt == null ? null : classOnInpRcpt.trim();
    }

    public String getSubjCode() {
        return subjCode;
    }

    public void setSubjCode(String subjCode) {
        this.subjCode = subjCode == null ? null : subjCode.trim();
    }

    public String getClassOnMr() {
        return classOnMr;
    }

    public void setClassOnMr(String classOnMr) {
        this.classOnMr = classOnMr == null ? null : classOnMr.trim();
    }

    public String getClassOnReckoning() {
        return classOnReckoning;
    }

    public void setClassOnReckoning(String classOnReckoning) {
        this.classOnReckoning = classOnReckoning == null ? null : classOnReckoning.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public BigDecimal getOwnCosts() {
        return ownCosts;
    }

    public void setOwnCosts(BigDecimal ownCosts) {
        this.ownCosts = ownCosts;
    }

    public BigDecimal getInsurCosts() {
        return insurCosts;
    }

    public void setInsurCosts(BigDecimal insurCosts) {
        this.insurCosts = insurCosts;
    }

    public String getItemSerialNo() {
        return itemSerialNo;
    }

    public void setItemSerialNo(String itemSerialNo) {
        this.itemSerialNo = itemSerialNo == null ? null : itemSerialNo.trim();
    }

    public String getUpdateFlag() {
        return updateFlag;
    }

    public void setUpdateFlag(String updateFlag) {
        this.updateFlag = updateFlag == null ? null : updateFlag.trim();
    }

    public String getGsFlag() {
        return gsFlag;
    }

    public void setGsFlag(String gsFlag) {
        this.gsFlag = gsFlag == null ? null : gsFlag.trim();
    }

    public Timestamp getBillingDateTime() {
        return billingDateTime;
    }

    public void setBillingDateTime(Timestamp billingDateTime) {
        this.billingDateTime = billingDateTime;
    }
}