package com.ht.extra.pojo.inpbill;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/15.
 */
public class DailyLedger {
    private String patientId;

    private short visitId;

    private Date ledgerDate;

    private BigDecimal costs;

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public Date getLedgerDate() {
        return ledgerDate;
    }

    public void setLedgerDate(Date ledgerDate) {
        this.ledgerDate = ledgerDate;
    }

    public short getVisitId() {
        return visitId;
    }

    public void setVisitId(short visitId) {
        this.visitId = visitId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
