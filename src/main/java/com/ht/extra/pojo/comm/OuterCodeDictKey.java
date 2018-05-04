package com.ht.extra.pojo.comm;

public class OuterCodeDictKey {
    private String topic;

    private String itemName;

    private String itemCode;

    private String codingSchm;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getCodingSchm() {
        return codingSchm;
    }

    public void setCodingSchm(String codingSchm) {
        this.codingSchm = codingSchm == null ? null : codingSchm.trim();
    }
}