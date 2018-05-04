package com.ht.extra.pojo.medrec;

import java.util.Date;

public class SybDispatDiagInfo extends SybDispatDiagInfoKey {
    private String diagnosisDesc;

    private Date diagnosisDate;

    private Short treatDays;

    private String treatResult;

    private Short operTreatIndicator;

    private String codeVersion;

    private String diagCode;

    private String treatcode;

    private String opsid;

    private String disregFlag;

    public String getDiagnosisDesc() {
        return diagnosisDesc;
    }

    public void setDiagnosisDesc(String diagnosisDesc) {
        this.diagnosisDesc = diagnosisDesc == null ? null : diagnosisDesc.trim();
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public Short getTreatDays() {
        return treatDays;
    }

    public void setTreatDays(Short treatDays) {
        this.treatDays = treatDays;
    }

    public String getTreatResult() {
        return treatResult;
    }

    public void setTreatResult(String treatResult) {
        this.treatResult = treatResult == null ? null : treatResult.trim();
    }

    public Short getOperTreatIndicator() {
        return operTreatIndicator;
    }

    public void setOperTreatIndicator(Short operTreatIndicator) {
        this.operTreatIndicator = operTreatIndicator;
    }

    public String getCodeVersion() {
        return codeVersion;
    }

    public void setCodeVersion(String codeVersion) {
        this.codeVersion = codeVersion == null ? null : codeVersion.trim();
    }

    public String getDiagCode() {
        return diagCode;
    }

    public void setDiagCode(String diagCode) {
        this.diagCode = diagCode == null ? null : diagCode.trim();
    }

    public String getTreatcode() {
        return treatcode;
    }

    public void setTreatcode(String treatcode) {
        this.treatcode = treatcode == null ? null : treatcode.trim();
    }

    public String getOpsid() {
        return opsid;
    }

    public void setOpsid(String opsid) {
        this.opsid = opsid == null ? null : opsid.trim();
    }

    public String getDisregFlag() {
        return disregFlag;
    }

    public void setDisregFlag(String disregFlag) {
        this.disregFlag = disregFlag == null ? null : disregFlag.trim();
    }
}