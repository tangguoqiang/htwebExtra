package com.ht.extra.pojo.medrec;

import java.util.Date;

public class MrRec extends MrRecKey {
    private String mrAttr;

    private String patientId;

    private Date mrCreateDate;

    private String currentLocation;

    private String storeLocation;

    private String mrStatus;

    private Date lastBorrowedDate;

    private Date lastReturnedDate;

    public String getMrAttr() {
        return mrAttr;
    }

    public void setMrAttr(String mrAttr) {
        this.mrAttr = mrAttr == null ? null : mrAttr.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public Date getMrCreateDate() {
        return mrCreateDate;
    }

    public void setMrCreateDate(Date mrCreateDate) {
        this.mrCreateDate = mrCreateDate;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation == null ? null : currentLocation.trim();
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation == null ? null : storeLocation.trim();
    }

    public String getMrStatus() {
        return mrStatus;
    }

    public void setMrStatus(String mrStatus) {
        this.mrStatus = mrStatus == null ? null : mrStatus.trim();
    }

    public Date getLastBorrowedDate() {
        return lastBorrowedDate;
    }

    public void setLastBorrowedDate(Date lastBorrowedDate) {
        this.lastBorrowedDate = lastBorrowedDate;
    }

    public Date getLastReturnedDate() {
        return lastReturnedDate;
    }

    public void setLastReturnedDate(Date lastReturnedDate) {
        this.lastReturnedDate = lastReturnedDate;
    }
}