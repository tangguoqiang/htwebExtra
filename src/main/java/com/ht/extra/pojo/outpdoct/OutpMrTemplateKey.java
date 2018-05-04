package com.ht.extra.pojo.outpdoct;

public class OutpMrTemplateKey {
    private String type;

    private String contents;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}