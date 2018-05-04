package com.ht.extra.pojo.comm;

public class DeptreckVsDept {
    private String deptCode;

    private String deptCodehs;

    private String deptAttr;

    private String deptHsname;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptCodehs() {
        return deptCodehs;
    }

    public void setDeptCodehs(String deptCodehs) {
        this.deptCodehs = deptCodehs == null ? null : deptCodehs.trim();
    }

    public String getDeptAttr() {
        return deptAttr;
    }

    public void setDeptAttr(String deptAttr) {
        this.deptAttr = deptAttr == null ? null : deptAttr.trim();
    }

    public String getDeptHsname() {
        return deptHsname;
    }

    public void setDeptHsname(String deptHsname) {
        this.deptHsname = deptHsname == null ? null : deptHsname.trim();
    }
}