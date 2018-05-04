package com.ht.extra.pojo.comm;

public class QqMessage extends QqMessageKey {
    private String message;

    private Short status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}