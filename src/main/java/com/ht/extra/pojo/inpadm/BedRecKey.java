package com.ht.extra.pojo.inpadm;

public class BedRecKey {
    private String wardCode;

    private Short bedNo;

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode == null ? null : wardCode.trim();
    }

    public Short getBedNo() {
        return bedNo;
    }

    public void setBedNo(Short bedNo) {
        this.bedNo = bedNo;
    }
}