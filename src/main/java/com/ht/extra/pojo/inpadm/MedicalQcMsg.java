package com.ht.extra.pojo.inpadm;

import java.util.Date;

public class MedicalQcMsg extends MedicalQcMsgKey {
    private String deptStayed;

    private String doctorInCharge;

    private String qaEventType;

    private String message;

    private String issuedBy;

    private Short msgStatus;

    private Date askDateTime;

    private String qcModule;

    private String topicId;

    private String topic;

    private String doctorComment;

    public String getDeptStayed() {
        return deptStayed;
    }

    public void setDeptStayed(String deptStayed) {
        this.deptStayed = deptStayed == null ? null : deptStayed.trim();
    }

    public String getDoctorInCharge() {
        return doctorInCharge;
    }

    public void setDoctorInCharge(String doctorInCharge) {
        this.doctorInCharge = doctorInCharge == null ? null : doctorInCharge.trim();
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

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy == null ? null : issuedBy.trim();
    }

    public Short getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Short msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Date getAskDateTime() {
        return askDateTime;
    }

    public void setAskDateTime(Date askDateTime) {
        this.askDateTime = askDateTime;
    }

    public String getQcModule() {
        return qcModule;
    }

    public void setQcModule(String qcModule) {
        this.qcModule = qcModule == null ? null : qcModule.trim();
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    public String getDoctorComment() {
        return doctorComment;
    }

    public void setDoctorComment(String doctorComment) {
        this.doctorComment = doctorComment == null ? null : doctorComment.trim();
    }
}