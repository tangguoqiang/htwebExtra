package com.ht.extra.pojo.comm;

public class AnciExamItemDict {
    private String diagExamCode;

    private String diagExamName;

    private String countUnit;

    private String inputCode;

    public String getDiagExamCode() {
        return diagExamCode;
    }

    public void setDiagExamCode(String diagExamCode) {
        this.diagExamCode = diagExamCode == null ? null : diagExamCode.trim();
    }

    public String getDiagExamName() {
        return diagExamName;
    }

    public void setDiagExamName(String diagExamName) {
        this.diagExamName = diagExamName == null ? null : diagExamName.trim();
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