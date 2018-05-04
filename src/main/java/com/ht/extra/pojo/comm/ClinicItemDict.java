package com.ht.extra.pojo.comm;

public class ClinicItemDict extends ClinicItemDictKey {
    private String itemName;

    private String inputCode;

    private String autoprintFlag;

    private String itemDatawin;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getAutoprintFlag() {
        return autoprintFlag;
    }

    public void setAutoprintFlag(String autoprintFlag) {
        this.autoprintFlag = autoprintFlag == null ? null : autoprintFlag.trim();
    }

    public String getItemDatawin() {
        return itemDatawin;
    }

    public void setItemDatawin(String itemDatawin) {
        this.itemDatawin = itemDatawin == null ? null : itemDatawin.trim();
    }
}