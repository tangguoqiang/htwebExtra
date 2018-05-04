package com.ht.extra.pojo.comm;

public class OuterCodingConfigBackupKey {
    private String topic;

    private String codingSchm;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getCodingSchm() {
        return codingSchm;
    }

    public void setCodingSchm(String codingSchm) {
        this.codingSchm = codingSchm == null ? null : codingSchm.trim();
    }
}