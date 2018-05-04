package com.ht.extra.pojo.comm;

public class BillingGroupDict {
    private String groupName;

    private Short serialNo;

    private String groupCode;

    private String startWindowNo;

    private String stopWindowNo;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }

    public String getStartWindowNo() {
        return startWindowNo;
    }

    public void setStartWindowNo(String startWindowNo) {
        this.startWindowNo = startWindowNo == null ? null : startWindowNo.trim();
    }

    public String getStopWindowNo() {
        return stopWindowNo;
    }

    public void setStopWindowNo(String stopWindowNo) {
        this.stopWindowNo = stopWindowNo == null ? null : stopWindowNo.trim();
    }
}