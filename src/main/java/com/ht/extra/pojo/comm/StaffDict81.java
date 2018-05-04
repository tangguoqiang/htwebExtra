package com.ht.extra.pojo.comm;

import java.util.Date;

public class StaffDict81 {
    private String nameId;

    private String empNo;

    private String name;

    private String deptCode;

    private String job;

    private String title;

    private String adminBus;

    private String artOrder;

    private Date jobDate;

    private String inputCode;

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId == null ? null : nameId.trim();
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo == null ? null : empNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAdminBus() {
        return adminBus;
    }

    public void setAdminBus(String adminBus) {
        this.adminBus = adminBus == null ? null : adminBus.trim();
    }

    public String getArtOrder() {
        return artOrder;
    }

    public void setArtOrder(String artOrder) {
        this.artOrder = artOrder == null ? null : artOrder.trim();
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}