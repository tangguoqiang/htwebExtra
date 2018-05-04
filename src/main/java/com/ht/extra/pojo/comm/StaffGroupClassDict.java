package com.ht.extra.pojo.comm;

public class StaffGroupClassDict {
    private String groupClass;

    private Short serialNo;

    public String getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(String groupClass) {
        this.groupClass = groupClass == null ? null : groupClass.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }
}