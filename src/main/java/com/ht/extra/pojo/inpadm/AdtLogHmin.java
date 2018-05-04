package com.ht.extra.pojo.inpadm;

import java.util.Date;

public class AdtLogHmin extends AdtLogHminKey {
    private String deptCode;

    private String dbUser;

    private Date logDateTimeAgain;

    private String insertUser;

    private Date insertDateTime;

    private String diffDaySign;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser == null ? null : dbUser.trim();
    }

    public Date getLogDateTimeAgain() {
        return logDateTimeAgain;
    }

    public void setLogDateTimeAgain(Date logDateTimeAgain) {
        this.logDateTimeAgain = logDateTimeAgain;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser == null ? null : insertUser.trim();
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public String getDiffDaySign() {
        return diffDaySign;
    }

    public void setDiffDaySign(String diffDaySign) {
        this.diffDaySign = diffDaySign == null ? null : diffDaySign.trim();
    }
}