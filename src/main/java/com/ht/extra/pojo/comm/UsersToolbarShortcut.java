package com.ht.extra.pojo.comm;

public class UsersToolbarShortcut {
    private Long shortcutId;

    private String empNo;

    private String shortcutName;

    private String menuId;

    private String localcomputerExePath;

    private Short orderBy;

    private Short usertoolbarType;

    private Short userRole;

    public Long getShortcutId() {
        return shortcutId;
    }

    public void setShortcutId(Long shortcutId) {
        this.shortcutId = shortcutId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getShortcutName() {
        return shortcutName;
    }

    public void setShortcutName(String shortcutName) {
        this.shortcutName = shortcutName == null ? null : shortcutName.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getLocalcomputerExePath() {
        return localcomputerExePath;
    }

    public void setLocalcomputerExePath(String localcomputerExePath) {
        this.localcomputerExePath = localcomputerExePath == null ? null : localcomputerExePath.trim();
    }

    public Short getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Short orderBy) {
        this.orderBy = orderBy;
    }

    public Short getUsertoolbarType() {
        return usertoolbarType;
    }

    public void setUsertoolbarType(Short usertoolbarType) {
        this.usertoolbarType = usertoolbarType;
    }

    public Short getUserRole() {
        return userRole;
    }

    public void setUserRole(Short userRole) {
        this.userRole = userRole;
    }
}