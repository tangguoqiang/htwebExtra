package com.ht.extra.pojo.exam;

public class ExamWorkingPlan extends ExamWorkingPlanKey {
    private String mornBegin;

    private String mornEnd;

    private String noonBegin;

    private String noonEnd;

    public String getMornBegin() {
        return mornBegin;
    }

    public void setMornBegin(String mornBegin) {
        this.mornBegin = mornBegin == null ? null : mornBegin.trim();
    }

    public String getMornEnd() {
        return mornEnd;
    }

    public void setMornEnd(String mornEnd) {
        this.mornEnd = mornEnd == null ? null : mornEnd.trim();
    }

    public String getNoonBegin() {
        return noonBegin;
    }

    public void setNoonBegin(String noonBegin) {
        this.noonBegin = noonBegin == null ? null : noonBegin.trim();
    }

    public String getNoonEnd() {
        return noonEnd;
    }

    public void setNoonEnd(String noonEnd) {
        this.noonEnd = noonEnd == null ? null : noonEnd.trim();
    }
}