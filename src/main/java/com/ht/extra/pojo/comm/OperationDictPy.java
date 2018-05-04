package com.ht.extra.pojo.comm;

import java.util.Date;

public class OperationDictPy {
    private String operationCode;

    private String operationName;

    private String inputCode;

    private String codeVersion;

    private Short operationLevel;

    private String operationScale;

    private Short stdIndicator;

    private Short approvedIndicator;

    private Date createDate;

    public String getOperationCode() {
        return operationCode;
    }

    public void setOperationCode(String operationCode) {
        this.operationCode = operationCode == null ? null : operationCode.trim();
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
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

    public Short getOperationLevel() {
        return operationLevel;
    }

    public void setOperationLevel(Short operationLevel) {
        this.operationLevel = operationLevel;
    }

    public String getOperationScale() {
        return operationScale;
    }

    public void setOperationScale(String operationScale) {
        this.operationScale = operationScale == null ? null : operationScale.trim();
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
}