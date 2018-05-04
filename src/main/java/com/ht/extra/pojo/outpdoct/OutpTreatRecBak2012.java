package com.ht.extra.pojo.outpdoct;

import java.math.BigDecimal;
import java.util.Date;

public class OutpTreatRecBak2012 {
    private Date visitDate;

    private Short visitNo;

    private String serialNo;

    private Short itemNo;

    private String itemClass;

    private String itemCode;

    private String itemName;

    private String itemSpec;

    private String units;

    private Short amount;

    private String frequency;

    private String performedBy;

    private BigDecimal costs;

    private BigDecimal charges;

    private Short chargeIndicator;

    private String appointNo;

    private Short appointItemNo;

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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo == null ? null : serialNo.trim();
    }

    public Short getItemNo() {
        return itemNo;
    }

    public void setItemNo(Short itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
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

    public Short getAmount() {
        return amount;
    }

    public void setAmount(Short amount) {
        this.amount = amount;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency == null ? null : frequency.trim();
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

    public Short getAppointItemNo() {
        return appointItemNo;
    }

    public void setAppointItemNo(Short appointItemNo) {
        this.appointItemNo = appointItemNo;
    }
}