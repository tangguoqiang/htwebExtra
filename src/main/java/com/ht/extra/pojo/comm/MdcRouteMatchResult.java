package com.ht.extra.pojo.comm;

public class MdcRouteMatchResult {
    private String suserId;

    private String ssysName;

    private String smatchUser;

    private String smatchTime;

    public String getSuserId() {
        return suserId;
    }

    public void setSuserId(String suserId) {
        this.suserId = suserId == null ? null : suserId.trim();
    }

    public String getSsysName() {
        return ssysName;
    }

    public void setSsysName(String ssysName) {
        this.ssysName = ssysName == null ? null : ssysName.trim();
    }

    public String getSmatchUser() {
        return smatchUser;
    }

    public void setSmatchUser(String smatchUser) {
        this.smatchUser = smatchUser == null ? null : smatchUser.trim();
    }

    public String getSmatchTime() {
        return smatchTime;
    }

    public void setSmatchTime(String smatchTime) {
        this.smatchTime = smatchTime == null ? null : smatchTime.trim();
    }
}