package com.ht.extra.pojo.comm;

public class ExamDiagDict extends ExamDiagDictKey {
    private String diagName;

    private String diagInputCode;

    public String getDiagName() {
        return diagName;
    }

    public void setDiagName(String diagName) {
        this.diagName = diagName == null ? null : diagName.trim();
    }

    public String getDiagInputCode() {
        return diagInputCode;
    }

    public void setDiagInputCode(String diagInputCode) {
        this.diagInputCode = diagInputCode == null ? null : diagInputCode.trim();
    }
}