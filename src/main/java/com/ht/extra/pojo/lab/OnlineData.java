package com.ht.extra.pojo.lab;

import java.util.Date;

public class OnlineData {
    private Integer serialNo;

    private String instId;

    private Integer sampleId;

    private String itemId;

    private String assayResult;

    private Date assayDate;

    private Integer sampleType;

    private Integer resultStatus;

    private String statusComment;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public Integer getSampleId() {
        return sampleId;
    }

    public void setSampleId(Integer sampleId) {
        this.sampleId = sampleId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getAssayResult() {
        return assayResult;
    }

    public void setAssayResult(String assayResult) {
        this.assayResult = assayResult == null ? null : assayResult.trim();
    }

    public Date getAssayDate() {
        return assayDate;
    }

    public void setAssayDate(Date assayDate) {
        this.assayDate = assayDate;
    }

    public Integer getSampleType() {
        return sampleType;
    }

    public void setSampleType(Integer sampleType) {
        this.sampleType = sampleType;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment == null ? null : statusComment.trim();
    }
}