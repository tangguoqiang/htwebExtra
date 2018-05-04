package com.ht.extra.pojo.comm;

import java.math.BigDecimal;
import java.util.Date;

public class UsersBackup {
    private BigDecimal serialNo;

    private String dbUser;

    private String userId;

    private String userName;

    private String userDept;

    private Date createDate;

    public BigDecimal getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(BigDecimal serialNo) {
        this.serialNo = serialNo;
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser == null ? null : dbUser.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserDept() {
        return userDept;
    }

    public void setUserDept(String userDept) {
        this.userDept = userDept == null ? null : userDept.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}