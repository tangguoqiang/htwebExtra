package com.ht.extra.pojo.comm;

public class DeptDispenseSerial {
    private String deptCode;

    private Integer serialNo;

    private Short useInfo;

    private String visualCode;

    private String location;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public Short getUseInfo() {
        return useInfo;
    }

    public void setUseInfo(Short useInfo) {
        this.useInfo = useInfo;
    }

    public String getVisualCode() {
        return visualCode;
    }

    public void setVisualCode(String visualCode) {
        this.visualCode = visualCode == null ? null : visualCode.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }
}