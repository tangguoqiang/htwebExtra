package com.ht.extra.pojo.comm;

public class MdcDrugMatchResult {
    private String suserId;

    private String suserUnit;

    private String ssysName;

    private String ssysType;

    private String sstrength;

    private String ssysUnit;

    private String sunitrate;

    private String smatchUser;

    private String smatchTime;

    private String shasHisInfo;

    public String getSuserId() {
        return suserId;
    }

    public void setSuserId(String suserId) {
        this.suserId = suserId == null ? null : suserId.trim();
    }

    public String getSuserUnit() {
        return suserUnit;
    }

    public void setSuserUnit(String suserUnit) {
        this.suserUnit = suserUnit == null ? null : suserUnit.trim();
    }

    public String getSsysName() {
        return ssysName;
    }

    public void setSsysName(String ssysName) {
        this.ssysName = ssysName == null ? null : ssysName.trim();
    }

    public String getSsysType() {
        return ssysType;
    }

    public void setSsysType(String ssysType) {
        this.ssysType = ssysType == null ? null : ssysType.trim();
    }

    public String getSstrength() {
        return sstrength;
    }

    public void setSstrength(String sstrength) {
        this.sstrength = sstrength == null ? null : sstrength.trim();
    }

    public String getSsysUnit() {
        return ssysUnit;
    }

    public void setSsysUnit(String ssysUnit) {
        this.ssysUnit = ssysUnit == null ? null : ssysUnit.trim();
    }

    public String getSunitrate() {
        return sunitrate;
    }

    public void setSunitrate(String sunitrate) {
        this.sunitrate = sunitrate == null ? null : sunitrate.trim();
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

    public String getShasHisInfo() {
        return shasHisInfo;
    }

    public void setShasHisInfo(String shasHisInfo) {
        this.shasHisInfo = shasHisInfo == null ? null : shasHisInfo.trim();
    }
}