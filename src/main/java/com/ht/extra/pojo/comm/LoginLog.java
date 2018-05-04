package com.ht.extra.pojo.comm;

import java.math.BigDecimal;
import java.util.Date;

public class LoginLog extends LoginLogKey {
    private Date loginOffTime;

    private String userInDb;

    private String machine;

    private String ipAddress;

    private String runProgram;

    private BigDecimal sid;

    private BigDecimal serial;

    public Date getLoginOffTime() {
        return loginOffTime;
    }

    public void setLoginOffTime(Date loginOffTime) {
        this.loginOffTime = loginOffTime;
    }

    public String getUserInDb() {
        return userInDb;
    }

    public void setUserInDb(String userInDb) {
        this.userInDb = userInDb == null ? null : userInDb.trim();
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getRunProgram() {
        return runProgram;
    }

    public void setRunProgram(String runProgram) {
        this.runProgram = runProgram == null ? null : runProgram.trim();
    }

    public BigDecimal getSid() {
        return sid;
    }

    public void setSid(BigDecimal sid) {
        this.sid = sid;
    }

    public BigDecimal getSerial() {
        return serial;
    }

    public void setSerial(BigDecimal serial) {
        this.serial = serial;
    }
}