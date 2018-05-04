package com.ht.extra.pojo.inpadm;

public class MedicalQcLog extends MedicalQcLogKey {
    private String deptStayed;

    private String checkedBy;

    public String getDeptStayed() {
        return deptStayed;
    }

    public void setDeptStayed(String deptStayed) {
        this.deptStayed = deptStayed == null ? null : deptStayed.trim();
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy == null ? null : checkedBy.trim();
    }
}