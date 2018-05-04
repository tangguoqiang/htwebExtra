package com.ht.extra.pojo.comm;

public class TechnicTitleVsDuty extends TechnicTitleVsDutyKey {
    private String gradeOfDuty;

    public String getGradeOfDuty() {
        return gradeOfDuty;
    }

    public void setGradeOfDuty(String gradeOfDuty) {
        this.gradeOfDuty = gradeOfDuty == null ? null : gradeOfDuty.trim();
    }
}