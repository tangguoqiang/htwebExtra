package com.ht.extra.pojo.exam;

public class ExamPatMiKey {
    private String localIdClass;

    private String patientLocalId;

    public String getLocalIdClass() {
        return localIdClass;
    }

    public void setLocalIdClass(String localIdClass) {
        this.localIdClass = localIdClass == null ? null : localIdClass.trim();
    }

    public String getPatientLocalId() {
        return patientLocalId;
    }

    public void setPatientLocalId(String patientLocalId) {
        this.patientLocalId = patientLocalId == null ? null : patientLocalId.trim();
    }
}