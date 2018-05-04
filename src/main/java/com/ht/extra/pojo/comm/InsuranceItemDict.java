package com.ht.extra.pojo.comm;

public class InsuranceItemDict extends InsuranceItemDictKey {
    private String itemSpec;

    private String units;

    private String insuranceClass;

    private String inputCode;

    private String memo;

    private String payBl;

    private String exceptMemo;

    private String limitPrice;

    private String otherMemo;

    private String drugConf;

    private String countryMedica;

    private String cityBl;

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec == null ? null : itemSpec.trim();
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units == null ? null : units.trim();
    }

    public String getInsuranceClass() {
        return insuranceClass;
    }

    public void setInsuranceClass(String insuranceClass) {
        this.insuranceClass = insuranceClass == null ? null : insuranceClass.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getPayBl() {
        return payBl;
    }

    public void setPayBl(String payBl) {
        this.payBl = payBl == null ? null : payBl.trim();
    }

    public String getExceptMemo() {
        return exceptMemo;
    }

    public void setExceptMemo(String exceptMemo) {
        this.exceptMemo = exceptMemo == null ? null : exceptMemo.trim();
    }

    public String getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice == null ? null : limitPrice.trim();
    }

    public String getOtherMemo() {
        return otherMemo;
    }

    public void setOtherMemo(String otherMemo) {
        this.otherMemo = otherMemo == null ? null : otherMemo.trim();
    }

    public String getDrugConf() {
        return drugConf;
    }

    public void setDrugConf(String drugConf) {
        this.drugConf = drugConf == null ? null : drugConf.trim();
    }

    public String getCountryMedica() {
        return countryMedica;
    }

    public void setCountryMedica(String countryMedica) {
        this.countryMedica = countryMedica == null ? null : countryMedica.trim();
    }

    public String getCityBl() {
        return cityBl;
    }

    public void setCityBl(String cityBl) {
        this.cityBl = cityBl == null ? null : cityBl.trim();
    }
}