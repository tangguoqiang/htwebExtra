package com.ht.extra.pojo.medrec;

import java.math.BigDecimal;
import java.util.Date;

public class MdcCaseRecord {
    private BigDecimal serialNo;

    private String patientId;

    private BigDecimal visitId;

    private String cclassCode;

    private String cclassName;

    private String userName;

    private String userId;

    private String deptCode;

    private String patientDeptCode;

    private Date createData;

    private BigDecimal cclassState;

    private String ccaseConten;

    public BigDecimal getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(BigDecimal serialNo) {
        this.serialNo = serialNo;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public BigDecimal getVisitId() {
        return visitId;
    }

    public void setVisitId(BigDecimal visitId) {
        this.visitId = visitId;
    }

    public String getCclassCode() {
        return cclassCode;
    }

    public void setCclassCode(String cclassCode) {
        this.cclassCode = cclassCode == null ? null : cclassCode.trim();
    }

    public String getCclassName() {
        return cclassName;
    }

    public void setCclassName(String cclassName) {
        this.cclassName = cclassName == null ? null : cclassName.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getPatientDeptCode() {
        return patientDeptCode;
    }

    public void setPatientDeptCode(String patientDeptCode) {
        this.patientDeptCode = patientDeptCode == null ? null : patientDeptCode.trim();
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    public BigDecimal getCclassState() {
        return cclassState;
    }

    public void setCclassState(BigDecimal cclassState) {
        this.cclassState = cclassState;
    }

    public String getCcaseConten() {
        return ccaseConten;
    }

    public void setCcaseConten(String ccaseConten) {
        this.ccaseConten = ccaseConten == null ? null : ccaseConten.trim();
    }
}