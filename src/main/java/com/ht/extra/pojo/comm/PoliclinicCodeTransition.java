package com.ht.extra.pojo.comm;

public class PoliclinicCodeTransition extends PoliclinicCodeTransitionKey {
    private String oldPoliclinicName;

    private String newPoliclinicCode;

    private String newPoliclinicName;

    public String getOldPoliclinicName() {
        return oldPoliclinicName;
    }

    public void setOldPoliclinicName(String oldPoliclinicName) {
        this.oldPoliclinicName = oldPoliclinicName == null ? null : oldPoliclinicName.trim();
    }

    public String getNewPoliclinicCode() {
        return newPoliclinicCode;
    }

    public void setNewPoliclinicCode(String newPoliclinicCode) {
        this.newPoliclinicCode = newPoliclinicCode == null ? null : newPoliclinicCode.trim();
    }

    public String getNewPoliclinicName() {
        return newPoliclinicName;
    }

    public void setNewPoliclinicName(String newPoliclinicName) {
        this.newPoliclinicName = newPoliclinicName == null ? null : newPoliclinicName.trim();
    }
}