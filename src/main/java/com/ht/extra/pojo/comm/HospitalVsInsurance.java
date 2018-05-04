package com.ht.extra.pojo.comm;

import java.math.BigDecimal;
import java.util.Date;

public class HospitalVsInsurance extends HospitalVsInsuranceKey {
    private String hospitalItemName;

    private String insuranceItemName;

    private String hospitalInputCode;

    private Date enterDate;

    private String operatorNo;

    private String xnhybInsurItemCode;

    private String xnhybInsurFlag;

    private String xnhybCountryBasedir;

    private String drugConf;

    private String xnhUpflag;

    private String memo;

    private BigDecimal hospitalPrice;

    private String specialDiagCode;

    private String xnhybInsurItemName;

    public String getHospitalItemName() {
        return hospitalItemName;
    }

    public void setHospitalItemName(String hospitalItemName) {
        this.hospitalItemName = hospitalItemName == null ? null : hospitalItemName.trim();
    }

    public String getInsuranceItemName() {
        return insuranceItemName;
    }

    public void setInsuranceItemName(String insuranceItemName) {
        this.insuranceItemName = insuranceItemName == null ? null : insuranceItemName.trim();
    }

    public String getHospitalInputCode() {
        return hospitalInputCode;
    }

    public void setHospitalInputCode(String hospitalInputCode) {
        this.hospitalInputCode = hospitalInputCode == null ? null : hospitalInputCode.trim();
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo == null ? null : operatorNo.trim();
    }

    public String getXnhybInsurItemCode() {
        return xnhybInsurItemCode;
    }

    public void setXnhybInsurItemCode(String xnhybInsurItemCode) {
        this.xnhybInsurItemCode = xnhybInsurItemCode == null ? null : xnhybInsurItemCode.trim();
    }

    public String getXnhybInsurFlag() {
        return xnhybInsurFlag;
    }

    public void setXnhybInsurFlag(String xnhybInsurFlag) {
        this.xnhybInsurFlag = xnhybInsurFlag == null ? null : xnhybInsurFlag.trim();
    }

    public String getXnhybCountryBasedir() {
        return xnhybCountryBasedir;
    }

    public void setXnhybCountryBasedir(String xnhybCountryBasedir) {
        this.xnhybCountryBasedir = xnhybCountryBasedir == null ? null : xnhybCountryBasedir.trim();
    }

    public String getDrugConf() {
        return drugConf;
    }

    public void setDrugConf(String drugConf) {
        this.drugConf = drugConf == null ? null : drugConf.trim();
    }

    public String getXnhUpflag() {
        return xnhUpflag;
    }

    public void setXnhUpflag(String xnhUpflag) {
        this.xnhUpflag = xnhUpflag == null ? null : xnhUpflag.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public BigDecimal getHospitalPrice() {
        return hospitalPrice;
    }

    public void setHospitalPrice(BigDecimal hospitalPrice) {
        this.hospitalPrice = hospitalPrice;
    }

    public String getSpecialDiagCode() {
        return specialDiagCode;
    }

    public void setSpecialDiagCode(String specialDiagCode) {
        this.specialDiagCode = specialDiagCode == null ? null : specialDiagCode.trim();
    }

    public String getXnhybInsurItemName() {
        return xnhybInsurItemName;
    }

    public void setXnhybInsurItemName(String xnhybInsurItemName) {
        this.xnhybInsurItemName = xnhybInsurItemName == null ? null : xnhybInsurItemName.trim();
    }
}