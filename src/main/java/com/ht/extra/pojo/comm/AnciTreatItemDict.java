package com.ht.extra.pojo.comm;

public class AnciTreatItemDict {
    private String diagTreatCode;

    private String diagTreatName;

    private String countUnit;

    private String inputCode;

    public String getDiagTreatCode() {
        return diagTreatCode;
    }

    public void setDiagTreatCode(String diagTreatCode) {
        this.diagTreatCode = diagTreatCode == null ? null : diagTreatCode.trim();
    }

    public String getDiagTreatName() {
        return diagTreatName;
    }

    public void setDiagTreatName(String diagTreatName) {
        this.diagTreatName = diagTreatName == null ? null : diagTreatName.trim();
    }

    public String getCountUnit() {
        return countUnit;
    }

    public void setCountUnit(String countUnit) {
        this.countUnit = countUnit == null ? null : countUnit.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}