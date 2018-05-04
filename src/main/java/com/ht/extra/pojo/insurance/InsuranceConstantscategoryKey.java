package com.ht.extra.pojo.insurance;

public class InsuranceConstantscategoryKey {
    private String interfacecode;

    private String guidecode;

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
}