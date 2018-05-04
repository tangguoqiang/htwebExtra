package com.ht.extra.pojo.comm;

public class PoliclinicDict {
    private String policlinicCode;

    private Integer serialNo;

    private String policlinicName;

    private String policlinicType;

    private String contactMan;

    private String contactPhone;

    private String mailingAddress;

    private String zipCode;

    private String inputCode;

    public String getPoliclinicCode() {
        return policlinicCode;
    }

    public void setPoliclinicCode(String policlinicCode) {
        this.policlinicCode = policlinicCode == null ? null : policlinicCode.trim();
    }

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getPoliclinicName() {
        return policlinicName;
    }

    public void setPoliclinicName(String policlinicName) {
        this.policlinicName = policlinicName == null ? null : policlinicName.trim();
    }

    public String getPoliclinicType() {
        return policlinicType;
    }

    public void setPoliclinicType(String policlinicType) {
        this.policlinicType = policlinicType == null ? null : policlinicType.trim();
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan == null ? null : contactMan.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress == null ? null : mailingAddress.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public String getInputCode() {
        return inputCode;
    }

    public void setInputCode(String inputCode) {
        this.inputCode = inputCode == null ? null : inputCode.trim();
    }
}