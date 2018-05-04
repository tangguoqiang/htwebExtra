package com.ht.extra.pojo.comm;

public class ChargeTypeVsIdentity extends ChargeTypeVsIdentityKey {
    private String identity;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }
}