package com.ht.extra.pojo.medrec;

import java.util.Date;

public class PmiMergedLogKey {
    private String pidMerged;

    private String pidRetained;

    private Date mergedDate;

    public String getPidMerged() {
        return pidMerged;
    }

    public void setPidMerged(String pidMerged) {
        this.pidMerged = pidMerged == null ? null : pidMerged.trim();
    }

    public String getPidRetained() {
        return pidRetained;
    }

    public void setPidRetained(String pidRetained) {
        this.pidRetained = pidRetained == null ? null : pidRetained.trim();
    }

    public Date getMergedDate() {
        return mergedDate;
    }

    public void setMergedDate(Date mergedDate) {
        this.mergedDate = mergedDate;
    }
}