package com.ht.extra.pojo.comm;

import java.util.Date;

public class DiagnosisDictBack2015 {
    private String diagnosisCode;

    private String diagnosisName;

    private Short stdIndicator;

    private Short approvedIndicator;

    private Date createDate;

    private String inputCode;

    private String codeVersion;

    private String healthLevel;

    private String infectIndicator;

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode == null ? null : diagnosisCode.trim();
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName == null ? null : diagnosisName.trim();
    }

    public Short getStdIndicator() {
        return stdIndicator;
    }

    public void setStdIndicator(Short stdIndicator) {
        this.stdIndicator = stdIndicator;
    }

    public Short getApprovedIndicator() {
        return approvedIndicator;
    }

    public void setApprovedIndicator(Short approvedIndicator) {
        this.approvedIndicator = approvedIndicator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getCodeVersion() {
        return codeVersion;
    }

    public void setCodeVersion(String codeVersion) {
        this.codeVersion = codeVersion == null ? null : codeVersion.trim();
    }

    public String getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(String healthLevel) {
        this.healthLevel = healthLevel == null ? null : healthLevel.trim();
    }

    public String getInfectIndicator() {
        return infectIndicator;
    }

    public void setInfectIndicator(String infectIndicator) {
        this.infectIndicator = infectIndicator == null ? null : infectIndicator.trim();
    }
}