package com.ht.extra.pojo.medrec;

public class MrRecKey {
    private String mrClass;

    private String mrNo;

    public String getMrClass() {
        return mrClass;
    }

    public void setMrClass(String mrClass) {
        this.mrClass = mrClass == null ? null : mrClass.trim();
    }

    public String getMrNo() {
        return mrNo;
    }

    public void setMrNo(String mrNo) {
        this.mrNo = mrNo == null ? null : mrNo.trim();
    }
}