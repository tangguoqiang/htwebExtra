package com.ht.extra.pojo.outpdoct;

import java.math.BigDecimal;
import java.util.Date;

public class OutpOrdersCostsBak extends OutpOrdersCostsBakKey {
    private String patientId;

    private Date visitDate;

    private Short visitNo;

    private Short orderSubNo;

    private String itemClass;

    private String itemName;

    private String itemCode;

    private String itemSpec;

    private String units;

    private Short repetition;

    private BigDecimal amount;

    private String orderedByDept;

    private String orderedByDoctor;

    private String performedBy;

    private String classOnRcpt;

    private BigDecimal costs;

    private BigDecimal charges;

    private String rcptNo;

    private Integer billDescNo;

    private Short billItemNo;

    private Short chargeIndicator;

    private String appointNo;

    private String recipetype;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Short getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(Short visitNo) {
        this.visitNo = visitNo;
    }

    public Short getOrderSubNo() {
        return orderSubNo;
    }

    public void setOrderSubNo(Short orderSubNo) {
        this.orderSubNo = orderSubNo;
    }

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

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public Short getRepetition() {
        return repetition;
    }

    public void setRepetition(Short repetition) {
        this.repetition = repetition;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderedByDept() {
        return orderedByDept;
    }

    public void setOrderedByDept(String orderedByDept) {
        this.orderedByDept = orderedByDept == null ? null : orderedByDept.trim();
    }

    public String getOrderedByDoctor() {
        return orderedByDoctor;
    }

    public void setOrderedByDoctor(String orderedByDoctor) {
        this.orderedByDoctor = orderedByDoctor == null ? null : orderedByDoctor.trim();
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy == null ? null : performedBy.trim();
    }

    public String getClassOnRcpt() {
        return classOnRcpt;
    }

    public void setClassOnRcpt(String classOnRcpt) {
        this.classOnRcpt = classOnRcpt == null ? null : classOnRcpt.trim();
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

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public Integer getBillDescNo() {
        return billDescNo;
    }

    public void setBillDescNo(Integer billDescNo) {
        this.billDescNo = billDescNo;
    }

    public Short getBillItemNo() {
        return billItemNo;
    }

    public void setBillItemNo(Short billItemNo) {
        this.billItemNo = billItemNo;
    }

    public Short getChargeIndicator() {
        return chargeIndicator;
    }

    public void setChargeIndicator(Short chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
    }

    public String getAppointNo() {
        return appointNo;
    }

    public void setAppointNo(String appointNo) {
        this.appointNo = appointNo == null ? null : appointNo.trim();
    }

    public String getRecipetype() {
        return recipetype;
    }

    public void setRecipetype(String recipetype) {
        this.recipetype = recipetype == null ? null : recipetype.trim();
    }
}