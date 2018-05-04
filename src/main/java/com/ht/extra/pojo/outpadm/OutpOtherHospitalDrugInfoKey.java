package com.ht.extra.pojo.outpadm;

import java.math.BigDecimal;
import java.util.Date;

public class OutpOtherHospitalDrugInfoKey {
    private String hospitalName;

    private Date visitDate;

    private String rcptNo;

    private BigDecimal itemNo;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getRcptNo() {
        return rcptNo;
    }

    public void setRcptNo(String rcptNo) {
        this.rcptNo = rcptNo == null ? null : rcptNo.trim();
    }

    public BigDecimal getItemNo() {
        return itemNo;
    }

    public void setItemNo(BigDecimal itemNo) {
        this.itemNo = itemNo;
    }
}