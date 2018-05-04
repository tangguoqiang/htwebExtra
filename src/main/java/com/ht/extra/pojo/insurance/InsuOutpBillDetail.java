package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;

public class InsuOutpBillDetail extends InsuOutpBillDetailKey {
    private String patientId;

    private String itemClass;

    private String insuItemName;

    private BigDecimal price;

    private BigDecimal amount;

    private String operatorNo;

    private String insuPhamProducingArea;

    private String insuPhamProducingAreaSign;

    private String rcptNo;

    private String insuItemCode;

    private String insuCardNo;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass == null ? null : itemClass.trim();
    }

    public String getInsuItemName() {
        return insuItemName;
    }

    public void setInsuItemName(String insuItemName) {
        this.insuItemName = insuItemName == null ? null : insuItemName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getInsuPhamProducingArea() {
        return insuPhamProducingArea;
    }

    public void setInsuPhamProducingArea(String insuPhamProducingArea) {
        this.insuPhamProducingArea = insuPhamProducingArea == null ? null : insuPhamProducingArea.trim();
    }

    public String getInsuPhamProducingAreaSign() {
        return insuPhamProducingAreaSign;
    }

    public void setInsuPhamProducingAreaSign(String insuPhamProducingAreaSign) {
        this.insuPhamProducingAreaSign = insuPhamProducingAreaSign == null ? null : insuPhamProducingAreaSign.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getInsuItemCode() {
        return insuItemCode;
    }

    public void setInsuItemCode(String insuItemCode) {
        this.insuItemCode = insuItemCode == null ? null : insuItemCode.trim();
    }

    public String getInsuCardNo() {
        return insuCardNo;
    }

    public void setInsuCardNo(String insuCardNo) {
        this.insuCardNo = insuCardNo == null ? null : insuCardNo.trim();
    }
}