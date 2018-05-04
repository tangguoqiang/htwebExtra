package com.ht.extra.pojo.outpadm;

public class OutpCounselQueueKey {
    private String counselNo;

    private String queueName;

    private String clinicLabel;

    public String getCounselNo() {
        return counselNo;
    }

    public void setCounselNo(String counselNo) {
        this.counselNo = counselNo == null ? null : counselNo.trim();
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName == null ? null : queueName.trim();
    }

    public String getClinicLabel() {
        return clinicLabel;
    }

    public void setClinicLabel(String clinicLabel) {
        this.clinicLabel = clinicLabel == null ? null : clinicLabel.trim();
    }
}