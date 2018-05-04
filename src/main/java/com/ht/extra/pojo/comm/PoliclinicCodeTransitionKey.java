package com.ht.extra.pojo.comm;

public class PoliclinicCodeTransitionKey {
    private String designatedHospital;

    private String oldPoliclinicCode;

    public String getDesignatedHospital() {
        return designatedHospital;
    }

    public void setDesignatedHospital(String designatedHospital) {
        this.designatedHospital = designatedHospital == null ? null : designatedHospital.trim();
    }

    public String getOldPoliclinicCode() {
        return oldPoliclinicCode;
    }

    public void setOldPoliclinicCode(String oldPoliclinicCode) {
        this.oldPoliclinicCode = oldPoliclinicCode == null ? null : oldPoliclinicCode.trim();
    }
}