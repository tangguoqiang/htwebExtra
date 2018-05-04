package com.ht.extra.pojo.inpadm;

import java.util.Date;

public class PatsInTransferring {
    private String patientId;

    private String deptTransferedFrom;

    private String deptTransferedTo;

    private Date transferDateTime;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getDeptTransferedFrom() {
        return deptTransferedFrom;
    }

    public void setDeptTransferedFrom(String deptTransferedFrom) {
        this.deptTransferedFrom = deptTransferedFrom == null ? null : deptTransferedFrom.trim();
    }

    public String getDeptTransferedTo() {
        return deptTransferedTo;
    }

    public void setDeptTransferedTo(String deptTransferedTo) {
        this.deptTransferedTo = deptTransferedTo == null ? null : deptTransferedTo.trim();
    }

    public Date getTransferDateTime() {
        return transferDateTime;
    }

    public void setTransferDateTime(Date transferDateTime) {
        this.transferDateTime = transferDateTime;
    }
}