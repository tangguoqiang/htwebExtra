package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.util.Date;

public class InpBillMaterial extends InpBillMaterialKey {
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

    private Date billingDateTime;

    private String operatorNo;

    private String rcptNo;

    private BigDecimal specialCharges;

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

    public Date getBillingDateTime() {
        return billingDateTime;
    }

    public void setBillingDateTime(Date billingDateTime) {
        this.billingDateTime = billingDateTime;
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
}