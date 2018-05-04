package com.ht.extra.pojo.inpadm;

public class BedRec extends BedRecKey {
    private String bedLabel;

    private String roomNo;

    private String deptCode;

    private String bedApprovedType;

    private String bedSexType;

    private String bedClass;

    private String bedStatus;

    private String monitorLabel;

    private Short icuIndicator;

    public String getBedLabel() {
        return bedLabel;
    }

    public void setBedLabel(String bedLabel) {
        this.bedLabel = bedLabel == null ? null : bedLabel.trim();
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo == null ? null : roomNo.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getBedApprovedType() {
        return bedApprovedType;
    }

    public void setBedApprovedType(String bedApprovedType) {
        this.bedApprovedType = bedApprovedType == null ? null : bedApprovedType.trim();
    }

    public String getBedSexType() {
        return bedSexType;
    }

    public void setBedSexType(String bedSexType) {
        this.bedSexType = bedSexType == null ? null : bedSexType.trim();
    }

    public String getBedClass() {
        return bedClass;
    }

    public void setBedClass(String bedClass) {
        this.bedClass = bedClass == null ? null : bedClass.trim();
    }

    public String getBedStatus() {
        return bedStatus;
    }

    public void setBedStatus(String bedStatus) {
        this.bedStatus = bedStatus == null ? null : bedStatus.trim();
    }

    public String getMonitorLabel() {
        return monitorLabel;
    }

    public void setMonitorLabel(String monitorLabel) {
        this.monitorLabel = monitorLabel == null ? null : monitorLabel.trim();
    }

    public Short getIcuIndicator() {
        return icuIndicator;
    }

    public void setIcuIndicator(Short icuIndicator) {
        this.icuIndicator = icuIndicator;
    }
}