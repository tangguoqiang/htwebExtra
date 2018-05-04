package com.ht.extra.pojo.medrec;

public class DiagComparing extends DiagComparingKey {
    private String diagCorrespondence;

    public String getDiagCorrespondence() {
        return diagCorrespondence;
    }

    public void setDiagCorrespondence(String diagCorrespondence) {
        this.diagCorrespondence = diagCorrespondence == null ? null : diagCorrespondence.trim();
    }
}