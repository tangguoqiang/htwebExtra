package com.ht.extra.pojo.comm;

public class TechnicTitleVsDutyKey {
    private String gradeOfTechnic;

    private String gradeOfTitle;

    public String getGradeOfTechnic() {
        return gradeOfTechnic;
    }

    public void setGradeOfTechnic(String gradeOfTechnic) {
        this.gradeOfTechnic = gradeOfTechnic == null ? null : gradeOfTechnic.trim();
    }

    public String getGradeOfTitle() {
        return gradeOfTitle;
    }

    public void setGradeOfTitle(String gradeOfTitle) {
        this.gradeOfTitle = gradeOfTitle == null ? null : gradeOfTitle.trim();
    }
}