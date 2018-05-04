package com.ht.extra.pojo.comm;

public class IdentityDict {
    private String identityName;

    private Short serialNo;

    private String identityCode;

    private String inputCode;

    private Short priorityIndicator;

    private Short militaryIndicator;

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName == null ? null : identityName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode == null ? null : identityCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public Short getPriorityIndicator() {
        return priorityIndicator;
    }

    public void setPriorityIndicator(Short priorityIndicator) {
        this.priorityIndicator = priorityIndicator;
    }

    public Short getMilitaryIndicator() {
        return militaryIndicator;
    }

    public void setMilitaryIndicator(Short militaryIndicator) {
        this.militaryIndicator = militaryIndicator;
    }
}