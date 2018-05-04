package com.ht.extra.pojo.outpdoct;

public class TreatProjectItemsKey {
    private String treatProjectId;

    private Short itemNo;

    public String getTreatProjectId() {
        return treatProjectId;
    }

    public void setTreatProjectId(String treatProjectId) {
        this.treatProjectId = treatProjectId == null ? null : treatProjectId.trim();
    }

    public Short getItemNo() {
        return itemNo;
    }

    public void setItemNo(Short itemNo) {
        this.itemNo = itemNo;
    }
}