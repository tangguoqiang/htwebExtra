package com.ht.extra.pojo.medrec;

public class PatVisitDel extends PatVisitDelKey {
    private String delUser;

    public String getDelUser() {
        return delUser;
    }

    public void setDelUser(String delUser) {
        this.delUser = delUser == null ? null : delUser.trim();
    }
}