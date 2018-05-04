package com.ht.extra.pojo.medrec;

public class MrTraceLog extends MrTraceLogKey {
    private String releasedDept;

    private String acceptedDept;

    private String releasedBy;

    private String acceptedBy;

    private String memo;

    public String getReleasedDept() {
        return releasedDept;
    }

    public void setReleasedDept(String releasedDept) {
        this.releasedDept = releasedDept == null ? null : releasedDept.trim();
    }

    public String getAcceptedDept() {
        return acceptedDept;
    }

    public void setAcceptedDept(String acceptedDept) {
        this.acceptedDept = acceptedDept == null ? null : acceptedDept.trim();
    }

    public String getReleasedBy() {
        return releasedBy;
    }

    public void setReleasedBy(String releasedBy) {
        this.releasedBy = releasedBy == null ? null : releasedBy.trim();
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy == null ? null : acceptedBy.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}