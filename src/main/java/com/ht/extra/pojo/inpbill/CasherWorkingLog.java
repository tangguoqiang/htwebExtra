package com.ht.extra.pojo.inpbill;

public class CasherWorkingLog extends CasherWorkingLogKey {
    private String operName;

    private String contents;

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}