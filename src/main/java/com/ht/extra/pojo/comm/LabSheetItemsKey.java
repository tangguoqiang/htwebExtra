package com.ht.extra.pojo.comm;

public class LabSheetItemsKey {
    private String labSheetId;

    private String labItemCode;

    public String getLabSheetId() {
        return labSheetId;
    }

    public void setLabSheetId(String labSheetId) {
        this.labSheetId = labSheetId == null ? null : labSheetId.trim();
    }

    public String getLabItemCode() {
        return labItemCode;
    }

    public void setLabItemCode(String labItemCode) {
        this.labItemCode = labItemCode == null ? null : labItemCode.trim();
    }
}