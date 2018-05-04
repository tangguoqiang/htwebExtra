package com.ht.extra.pojo.comm;

public class OperationCodeCompare extends OperationCodeCompareKey {
    private String newCode;

    private String newName;

    private String oldCodeVersion;

    private String newCodeVersion;

    public String getNewCode() {
        return newCode;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode == null ? null : newCode.trim();
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName == null ? null : newName.trim();
    }

    public String getOldCodeVersion() {
        return oldCodeVersion;
    }

    public void setOldCodeVersion(String oldCodeVersion) {
        this.oldCodeVersion = oldCodeVersion == null ? null : oldCodeVersion.trim();
    }

    public String getNewCodeVersion() {
        return newCodeVersion;
    }

    public void setNewCodeVersion(String newCodeVersion) {
        this.newCodeVersion = newCodeVersion == null ? null : newCodeVersion.trim();
    }
}