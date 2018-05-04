package com.ht.extra.pojo.comm;

public class HospdiagVsCenterdiagKey {
    private String hospDiagcode;

    private String hospDiagname;

    private String stdIndicator;

    public String getHospDiagcode() {
        return hospDiagcode;
    }

    public void setHospDiagcode(String hospDiagcode) {
        this.hospDiagcode = hospDiagcode == null ? null : hospDiagcode.trim();
    }

    public String getHospDiagname() {
        return hospDiagname;
    }

    public void setHospDiagname(String hospDiagname) {
        this.hospDiagname = hospDiagname == null ? null : hospDiagname.trim();
    }

    public String getStdIndicator() {
        return stdIndicator;
    }

    public void setStdIndicator(String stdIndicator) {
        this.stdIndicator = stdIndicator == null ? null : stdIndicator.trim();
    }
}