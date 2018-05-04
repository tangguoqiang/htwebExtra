package com.ht.extra.pojo.comm;

public class MdcRouteMatchInfoView {
    private String suserId;

    private String suserName;

    private String suserSpell;

    private String suserSpell2;

    private String suserCode;

    private String ssysName;

    private String smatchUser;

    private String smatchTime;

    public String getSuserId() {
        return suserId;
    }

    public void setSuserId(String suserId) {
        this.suserId = suserId == null ? null : suserId.trim();
    }

    public String getSuserName() {
        return suserName;
    }

    public void setSuserName(String suserName) {
        this.suserName = suserName == null ? null : suserName.trim();
    }

    public String getSuserSpell() {
        return suserSpell;
    }

    public void setSuserSpell(String suserSpell) {
        this.suserSpell = suserSpell == null ? null : suserSpell.trim();
    }

    public String getSuserSpell2() {
        return suserSpell2;
    }

    public void setSuserSpell2(String suserSpell2) {
        this.suserSpell2 = suserSpell2 == null ? null : suserSpell2.trim();
    }

    public String getSuserCode() {
        return suserCode;
    }

    public void setSuserCode(String suserCode) {
        this.suserCode = suserCode == null ? null : suserCode.trim();
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