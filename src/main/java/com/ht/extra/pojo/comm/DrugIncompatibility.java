package com.ht.extra.pojo.comm;

public class DrugIncompatibility extends DrugIncompatibilityKey {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}