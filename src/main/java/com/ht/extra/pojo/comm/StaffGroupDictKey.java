package com.ht.extra.pojo.comm;

public class StaffGroupDictKey {
    private String groupClass;

    private String groupCode;

    public String getGroupClass() {
        return groupClass;
    }

    public void setGroupClass(String groupClass) {
        this.groupClass = groupClass == null ? null : groupClass.trim();
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode == null ? null : groupCode.trim();
    }
}