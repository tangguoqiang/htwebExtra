package com.ht.extra.pojo.comm;

import java.math.BigDecimal;

public class QcMsgDict {
    private String qcMsgCode;

    private Short serialNo;

    private String qaEventType;

    private String message;

    private BigDecimal score;

    private String inputCode;

    private String scoreType;

    public String getQcMsgCode() {
        return qcMsgCode;
    }

    public void setQcMsgCode(String qcMsgCode) {
        this.qcMsgCode = qcMsgCode == null ? null : qcMsgCode.trim();
    }

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getQaEventType() {
        return qaEventType;
    }

    public void setQaEventType(String qaEventType) {
        this.qaEventType = qaEventType == null ? null : qaEventType.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType == null ? null : scoreType.trim();
    }
}