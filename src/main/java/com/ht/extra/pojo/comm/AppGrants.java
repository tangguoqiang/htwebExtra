package com.ht.extra.pojo.comm;

public class AppGrants extends AppGrantsKey {
    private String capabilityDetail;

    private String memo1;

    private String memo2;

    public String getCapabilityDetail() {
        return capabilityDetail;
    }

    public void setCapabilityDetail(String capabilityDetail) {
        this.capabilityDetail = capabilityDetail == null ? null : capabilityDetail.trim();
    }

    public String getMemo1() {
        return memo1;
    }

    public void setMemo1(String memo1) {
        this.memo1 = memo1 == null ? null : memo1.trim();
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2 == null ? null : memo2.trim();
    }
}