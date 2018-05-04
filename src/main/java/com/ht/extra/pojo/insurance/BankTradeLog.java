package com.ht.extra.pojo.insurance;

import java.math.BigDecimal;

public class BankTradeLog extends BankTradeLogKey {
    private String tempRcptNo;

    private String patientId;

    private String bankCard;

    private String traNo;

    private String traReferNo;

    private BigDecimal traTotal;

    private String traType;

    private String traStatus;

    private String traFinalNo;

    private String traPcNo;

    private String traTime;

    private String merchantNo;

    private String note;

    private Short times;

    private String userId;

    private String acctNo;

    private Short returnTimes;

    private BigDecimal returnMoneyLimit;

    private String returnType;

    private String oprAppNameHis;

    private BigDecimal acctFlagHis;

    private String operTypeHis;

    private BigDecimal rcptFlagHis;

    private String bankNo;

    private String traAuthNo;

    private String settleDate;

    private String lrcReturn;

    private String returnRcptNo;

    public String getTempRcptNo() {
        return tempRcptNo;
    }

    public void setTempRcptNo(String tempRcptNo) {
        this.tempRcptNo = tempRcptNo == null ? null : tempRcptNo.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard == null ? null : bankCard.trim();
    }

    public String getTraNo() {
        return traNo;
    }

    public void setTraNo(String traNo) {
        this.traNo = traNo == null ? null : traNo.trim();
    }

    public String getTraReferNo() {
        return traReferNo;
    }

    public void setTraReferNo(String traReferNo) {
        this.traReferNo = traReferNo == null ? null : traReferNo.trim();
    }

    public BigDecimal getTraTotal() {
        return traTotal;
    }

    public void setTraTotal(BigDecimal traTotal) {
        this.traTotal = traTotal;
    }

    public String getTraType() {
        return traType;
    }

    public void setTraType(String traType) {
        this.traType = traType == null ? null : traType.trim();
    }

    public String getTraStatus() {
        return traStatus;
    }

    public void setTraStatus(String traStatus) {
        this.traStatus = traStatus == null ? null : traStatus.trim();
    }

    public String getTraFinalNo() {
        return traFinalNo;
    }

    public void setTraFinalNo(String traFinalNo) {
        this.traFinalNo = traFinalNo == null ? null : traFinalNo.trim();
    }

    public String getTraPcNo() {
        return traPcNo;
    }

    public void setTraPcNo(String traPcNo) {
        this.traPcNo = traPcNo == null ? null : traPcNo.trim();
    }

    public String getTraTime() {
        return traTime;
    }

    public void setTraTime(String traTime) {
        this.traTime = traTime == null ? null : traTime.trim();
    }

    public String getMerchantNo() {
        return merchantNo;
    }

    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Short getTimes() {
        return times;
    }

    public void setTimes(Short times) {
        this.times = times;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public Short getReturnTimes() {
        return returnTimes;
    }

    public void setReturnTimes(Short returnTimes) {
        this.returnTimes = returnTimes;
    }

    public BigDecimal getReturnMoneyLimit() {
        return returnMoneyLimit;
    }

    public void setReturnMoneyLimit(BigDecimal returnMoneyLimit) {
        this.returnMoneyLimit = returnMoneyLimit;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType == null ? null : returnType.trim();
    }

    public String getOprAppNameHis() {
        return oprAppNameHis;
    }

    public void setOprAppNameHis(String oprAppNameHis) {
        this.oprAppNameHis = oprAppNameHis == null ? null : oprAppNameHis.trim();
    }

    public BigDecimal getAcctFlagHis() {
        return acctFlagHis;
    }

    public void setAcctFlagHis(BigDecimal acctFlagHis) {
        this.acctFlagHis = acctFlagHis;
    }

    public String getOperTypeHis() {
        return operTypeHis;
    }

    public void setOperTypeHis(String operTypeHis) {
        this.operTypeHis = operTypeHis == null ? null : operTypeHis.trim();
    }

    public BigDecimal getRcptFlagHis() {
        return rcptFlagHis;
    }

    public void setRcptFlagHis(BigDecimal rcptFlagHis) {
        this.rcptFlagHis = rcptFlagHis;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo == null ? null : bankNo.trim();
    }

    public String getTraAuthNo() {
        return traAuthNo;
    }

    public void setTraAuthNo(String traAuthNo) {
        this.traAuthNo = traAuthNo == null ? null : traAuthNo.trim();
    }

    public String getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(String settleDate) {
        this.settleDate = settleDate == null ? null : settleDate.trim();
    }

    public String getLrcReturn() {
        return lrcReturn;
    }

    public void setLrcReturn(String lrcReturn) {
        this.lrcReturn = lrcReturn == null ? null : lrcReturn.trim();
    }

    public String getReturnRcptNo() {
        return returnRcptNo;
    }

    public void setReturnRcptNo(String returnRcptNo) {
        this.returnRcptNo = returnRcptNo == null ? null : returnRcptNo.trim();
    }
}