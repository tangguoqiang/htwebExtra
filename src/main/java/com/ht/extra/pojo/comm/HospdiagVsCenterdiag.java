package com.ht.extra.pojo.comm;

public class HospdiagVsCenterdiag extends HospdiagVsCenterdiagKey {
    private String xnhDiagcode;

    private String xnhDiagname;

    private String hospInputCode;

    public String getXnhDiagcode() {
        return xnhDiagcode;
    }

    public void setXnhDiagcode(String xnhDiagcode) {
        this.xnhDiagcode = xnhDiagcode == null ? null : xnhDiagcode.trim();
    }

    public String getXnhDiagname() {
        return xnhDiagname;
    }

    public void setXnhDiagname(String xnhDiagname) {
        this.xnhDiagname = xnhDiagname == null ? null : xnhDiagname.trim();
    }

    public String getHospInputCode() {
        return hospInputCode;
    }

    public void setHospInputCode(String hospInputCode) {
        this.hospInputCode = hospInputCode == null ? null : hospInputCode.trim();
    }
}