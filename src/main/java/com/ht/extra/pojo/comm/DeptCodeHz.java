package com.ht.extra.pojo.comm;

public class DeptCodeHz {
    private String deptCodehz;

    private String deptNamehz;

    private String deptHzadress;

    private String deptHzbank;

    public String getDeptCodehz() {
        return deptCodehz;
    }

    public void setDeptCodehz(String deptCodehz) {
        this.deptCodehz = deptCodehz == null ? null : deptCodehz.trim();
    }

    public String getDeptNamehz() {
        return deptNamehz;
    }

    public void setDeptNamehz(String deptNamehz) {
        this.deptNamehz = deptNamehz == null ? null : deptNamehz.trim();
    }

    public String getDeptHzadress() {
        return deptHzadress;
    }

    public void setDeptHzadress(String deptHzadress) {
        this.deptHzadress = deptHzadress == null ? null : deptHzadress.trim();
    }

    public String getDeptHzbank() {
        return deptHzbank;
    }

    public void setDeptHzbank(String deptHzbank) {
        this.deptHzbank = deptHzbank == null ? null : deptHzbank.trim();
    }
}