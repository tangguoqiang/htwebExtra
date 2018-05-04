package com.ht.extra.pojo.comm;

public class AllowLogin {
    private String userInDb;

    private String machine;

    private String ipAddress;

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
}