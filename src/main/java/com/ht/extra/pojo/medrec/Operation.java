package com.ht.extra.pojo.medrec;

import java.util.Date;

public class Operation extends OperationKey {
    private String operationDesc;

    private String operationCode;

    private String heal;

    private String woundGrade;

    private Date operatingDate;

    private String anaesthesiaMethod;

    private String operator;

    private String firstAssistant;

    private String secondAssistant;

    private String anesthesiaDoctor;

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc == null ? null : operationDesc.trim();
    }

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    public String getHeal() {
        return heal;
    }

    public void setHeal(String heal) {
        this.heal = heal == null ? null : heal.trim();
    }

    public String getWoundGrade() {
        return woundGrade;
    }

    public void setWoundGrade(String woundGrade) {
        this.woundGrade = woundGrade == null ? null : woundGrade.trim();
    }

    public Date getOperatingDate() {
        return operatingDate;
    }

    public void setOperatingDate(Date operatingDate) {
        this.operatingDate = operatingDate;
    }

    public String getAnaesthesiaMethod() {
        return anaesthesiaMethod;
    }

    public void setAnaesthesiaMethod(String anaesthesiaMethod) {
        this.anaesthesiaMethod = anaesthesiaMethod == null ? null : anaesthesiaMethod.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getFirstAssistant() {
        return firstAssistant;
    }

    public void setFirstAssistant(String firstAssistant) {
        this.firstAssistant = firstAssistant == null ? null : firstAssistant.trim();
    }

    public String getSecondAssistant() {
        return secondAssistant;
    }

    public void setSecondAssistant(String secondAssistant) {
        this.secondAssistant = secondAssistant == null ? null : secondAssistant.trim();
    }

    public String getAnesthesiaDoctor() {
        return anesthesiaDoctor;
    }

    public void setAnesthesiaDoctor(String anesthesiaDoctor) {
        this.anesthesiaDoctor = anesthesiaDoctor == null ? null : anesthesiaDoctor.trim();
    }
}