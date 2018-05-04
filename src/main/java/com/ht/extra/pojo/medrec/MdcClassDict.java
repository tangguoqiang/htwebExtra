package com.ht.extra.pojo.medrec;

import java.math.BigDecimal;

public class MdcClassDict {
    private BigDecimal serialNo;

    private String cclassCode;

    private String cclassName;

    private String userId;

    private String userDept;

    private String inputCode;

    public BigDecimal getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(BigDecimal serialNo) {
        this.serialNo = serialNo;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserDept() {
        return userDept;
    }

    public void setUserDept(String userDept) {
        this.userDept = userDept == null ? null : userDept.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}