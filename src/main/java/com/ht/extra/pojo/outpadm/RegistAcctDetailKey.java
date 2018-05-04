package com.ht.extra.pojo.outpadm;

public class RegistAcctDetailKey {
    private String acctNo;

    private String tallyFeeClass;

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getTallyFeeClass() {
        return tallyFeeClass;
    }

    public void setTallyFeeClass(String tallyFeeClass) {
        this.tallyFeeClass = tallyFeeClass == null ? null : tallyFeeClass.trim();
    }
}