package com.ht.extra.pojo.comm;

public class HelpMsg extends HelpMsgKey {
    private String messages;

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages == null ? null : messages.trim();
    }
}