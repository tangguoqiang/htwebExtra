package com.ht.extra.pojo.insurance;

public class InsuranceConstantsKey {
    private String interfacecode;

    private String guidecode;

    private String keyname;

    public String getInterfacecode() {
        return interfacecode;
    }

    public void setInterfacecode(String interfacecode) {
        this.interfacecode = interfacecode == null ? null : interfacecode.trim();
    }

    public String getGuidecode() {
        return guidecode;
    }

    public void setGuidecode(String guidecode) {
        this.guidecode = guidecode == null ? null : guidecode.trim();
    }

    public String getKeyname() {
        return keyname;
    }

    public void setKeyname(String keyname) {
        this.keyname = keyname == null ? null : keyname.trim();
    }
}