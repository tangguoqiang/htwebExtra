package com.ht.extra.pojo.pharmacy;

import java.math.BigDecimal;

public class DrugPrescMasterTemp extends DrugPrescMasterTempKey {
    private String dispensary;

    private String queueId;

    private Short status;

    private String patientId;

    private String name;

    private String namePhonetic;

    private String identity;

    private String chargeType;

    private String unitInContract;

    private Short prescType;

    private String prescAttr;

    private Short prescSource;

    private Short repetition;

    private BigDecimal costs;

    private BigDecimal payments;

    private String orderedBy;

    private String prescribedBy;

    private String enteredBy;

    private Short visitId;

    public String getDispensary() {
        return dispensary;
    }

    public void setDispensary(String dispensary) {
        this.dispensary = dispensary == null ? null : dispensary.trim();
    }

    public String getQueueId() {
        return queueId;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId == null ? null : queueId.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getChargeType() {
        return chargeType;
    }

    public void setChargeType(String chargeType) {
        this.chargeType = chargeType == null ? null : chargeType.trim();
    }

    public String getUnitInContract() {
        return unitInContract;
    }

    public void setUnitInContract(String unitInContract) {
        this.unitInContract = unitInContract == null ? null : unitInContract.trim();
    }

    public Short getPrescType() {
        return prescType;
    }

    public void setPrescType(Short prescType) {
        this.prescType = prescType;
    }

    public String getPrescAttr() {
        return prescAttr;
    }

    public void setPrescAttr(String prescAttr) {
        this.prescAttr = prescAttr == null ? null : prescAttr.trim();
    }

    public Short getPrescSource() {
        return prescSource;
    }

    public void setPrescSource(Short prescSource) {
        this.prescSource = prescSource;
    }

    public Short getRepetition() {
        return repetition;
    }

    public void setRepetition(Short repetition) {
        this.repetition = repetition;
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public BigDecimal getPayments() {
        return payments;
    }

    public void setPayments(BigDecimal payments) {
        this.payments = payments;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy == null ? null : orderedBy.trim();
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy == null ? null : prescribedBy.trim();
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy == null ? null : enteredBy.trim();
    }

    public Short getVisitId() {
        return visitId;
    }

    public void setVisitId(Short visitId) {
        this.visitId = visitId;
    }
}