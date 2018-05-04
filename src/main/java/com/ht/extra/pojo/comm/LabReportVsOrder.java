package com.ht.extra.pojo.comm;

public class LabReportVsOrder extends LabReportVsOrderKey {
    private String itemCode;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }
}