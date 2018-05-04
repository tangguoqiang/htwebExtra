package com.ht.extra.pojo.comm;

public class StaffArt81 {
    private String artCode;

    private String artName;

    public String getArtCode() {
        return artCode;
    }

    public void setArtCode(String artCode) {
        this.artCode = artCode == null ? null : artCode.trim();
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName == null ? null : artName.trim();
    }
}