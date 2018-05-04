package com.ht.extra.pojo.insurance;

public class BankTradeLogKey {
    private String type;

    private String rcptNo;

    private String traDate;

    private String tradeId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public String getTraDate() {
        return traDate;
    }

    public void setTraDate(String traDate) {
        this.traDate = traDate == null ? null : traDate.trim();
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId == null ? null : tradeId.trim();
    }
}