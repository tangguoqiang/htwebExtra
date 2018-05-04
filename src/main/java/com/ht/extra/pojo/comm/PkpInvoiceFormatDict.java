package com.ht.extra.pojo.comm;

public class PkpInvoiceFormatDict extends PkpInvoiceFormatDictKey {
    private String storeFormat;

    private String limitationOfLength;

    private String length;

    private String prefixLength;

    private String convertWay;

    private String taxCodeOperation;

    private String memo;

    public String getStoreFormat() {
        return storeFormat;
    }

    public void setStoreFormat(String storeFormat) {
        this.storeFormat = storeFormat == null ? null : storeFormat.trim();
    }

    public String getLimitationOfLength() {
        return limitationOfLength;
    }

    public void setLimitationOfLength(String limitationOfLength) {
        this.limitationOfLength = limitationOfLength == null ? null : limitationOfLength.trim();
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length == null ? null : length.trim();
    }

    public String getPrefixLength() {
        return prefixLength;
    }

    public void setPrefixLength(String prefixLength) {
        this.prefixLength = prefixLength == null ? null : prefixLength.trim();
    }

    public String getConvertWay() {
        return convertWay;
    }

    public void setConvertWay(String convertWay) {
        this.convertWay = convertWay == null ? null : convertWay.trim();
    }

    public String getTaxCodeOperation() {
        return taxCodeOperation;
    }

    public void setTaxCodeOperation(String taxCodeOperation) {
        this.taxCodeOperation = taxCodeOperation == null ? null : taxCodeOperation.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}