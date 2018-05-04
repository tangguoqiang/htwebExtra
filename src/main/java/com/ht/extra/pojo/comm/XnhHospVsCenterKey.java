package com.ht.extra.pojo.comm;

public class XnhHospVsCenterKey {
    private String hospItemClass;

    private String hospItemCode;

    private String hospItemSpec;

    private String hospItemUnit;

    public String getHospItemClass() {
        return hospItemClass;
    }

    public void setHospItemClass(String hospItemClass) {
        this.hospItemClass = hospItemClass == null ? null : hospItemClass.trim();
    }

    public String getHospItemCode() {
        return hospItemCode;
    }

    public void setHospItemCode(String hospItemCode) {
        this.hospItemCode = hospItemCode == null ? null : hospItemCode.trim();
    }

    public String getHospItemSpec() {
        return hospItemSpec;
    }

    public void setHospItemSpec(String hospItemSpec) {
        this.hospItemSpec = hospItemSpec == null ? null : hospItemSpec.trim();
    }

    public String getHospItemUnit() {
        return hospItemUnit;
    }

    public void setHospItemUnit(String hospItemUnit) {
        this.hospItemUnit = hospItemUnit == null ? null : hospItemUnit.trim();
    }
}