package com.ht.extra.pojo.comm;

public class HospitalVsInsuranceKey {
    private String hospitalItemClass;

    private String hospitalItemCode;

    private String hospitalItemSpec;

    private String hospitalItemUnits;

    public String getHospitalItemClass() {
        return hospitalItemClass;
    }

    public void setHospitalItemClass(String hospitalItemClass) {
        this.hospitalItemClass = hospitalItemClass == null ? null : hospitalItemClass.trim();
    }

    public String getHospitalItemCode() {
        return hospitalItemCode;
    }

    public void setHospitalItemCode(String hospitalItemCode) {
        this.hospitalItemCode = hospitalItemCode == null ? null : hospitalItemCode.trim();
    }

    public String getHospitalItemSpec() {
        return hospitalItemSpec;
    }

    public void setHospitalItemSpec(String hospitalItemSpec) {
        this.hospitalItemSpec = hospitalItemSpec == null ? null : hospitalItemSpec.trim();
    }

    public String getHospitalItemUnits() {
        return hospitalItemUnits;
    }

    public void setHospitalItemUnits(String hospitalItemUnits) {
        this.hospitalItemUnits = hospitalItemUnits == null ? null : hospitalItemUnits.trim();
    }
}