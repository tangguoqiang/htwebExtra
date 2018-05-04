package com.ht.extra.pojo.comm;

public class ApplicationGrantLog extends ApplicationGrantLogKey {
    private String oldCapability;

    private String newCapability;

    private String dbUser;

    private String machine;

    public String getOldCapability() {
        return oldCapability;
    }

    public void setOldCapability(String oldCapability) {
        this.oldCapability = oldCapability == null ? null : oldCapability.trim();
    }

    public String getNewCapability() {
        return newCapability;
    }

    public void setNewCapability(String newCapability) {
        this.newCapability = newCapability == null ? null : newCapability.trim();
    }

    public String getDbUser() {
        return dbUser;
    }

    public void setDbUser(String dbUser) {
        this.dbUser = dbUser == null ? null : dbUser.trim();
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine == null ? null : machine.trim();
    }
}