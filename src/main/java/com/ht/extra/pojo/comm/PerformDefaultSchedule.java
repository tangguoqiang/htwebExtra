package com.ht.extra.pojo.comm;

public class PerformDefaultSchedule {
    private Short serialNo;

    private String freqDesc;

    private String administration;

    private String defaultSchedule;

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getFreqDesc() {
        return freqDesc;
    }

    public void setFreqDesc(String freqDesc) {
        this.freqDesc = freqDesc == null ? null : freqDesc.trim();
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration == null ? null : administration.trim();
    }

    public String getDefaultSchedule() {
        return defaultSchedule;
    }

    public void setDefaultSchedule(String defaultSchedule) {
        this.defaultSchedule = defaultSchedule == null ? null : defaultSchedule.trim();
    }
}