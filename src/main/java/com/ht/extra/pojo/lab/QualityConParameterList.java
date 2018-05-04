package com.ht.extra.pojo.lab;

import java.math.BigDecimal;

public class QualityConParameterList extends QualityConParameterListKey {
    private String inst;

    private String method;

    private String wavelength;

    private BigDecimal xb1;

    private BigDecimal xb2;

    private BigDecimal xb3;

    private BigDecimal sd1;

    private BigDecimal sd2;

    private BigDecimal sd3;

    private BigDecimal cv1;

    private BigDecimal cv2;

    private BigDecimal cv3;

    private String batchNo1;

    private String batchNo2;

    private String batchNo3;

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst == null ? null : inst.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getWavelength() {
        return wavelength;
    }

    public void setWavelength(String wavelength) {
        this.wavelength = wavelength == null ? null : wavelength.trim();
    }

    public BigDecimal getXb1() {
        return xb1;
    }

    public void setXb1(BigDecimal xb1) {
        this.xb1 = xb1;
    }

    public BigDecimal getXb2() {
        return xb2;
    }

    public void setXb2(BigDecimal xb2) {
        this.xb2 = xb2;
    }

    public BigDecimal getXb3() {
        return xb3;
    }

    public void setXb3(BigDecimal xb3) {
        this.xb3 = xb3;
    }

    public BigDecimal getSd1() {
        return sd1;
    }

    public void setSd1(BigDecimal sd1) {
        this.sd1 = sd1;
    }

    public BigDecimal getSd2() {
        return sd2;
    }

    public void setSd2(BigDecimal sd2) {
        this.sd2 = sd2;
    }

    public BigDecimal getSd3() {
        return sd3;
    }

    public void setSd3(BigDecimal sd3) {
        this.sd3 = sd3;
    }

    public BigDecimal getCv1() {
        return cv1;
    }

    public void setCv1(BigDecimal cv1) {
        this.cv1 = cv1;
    }

    public BigDecimal getCv2() {
        return cv2;
    }

    public void setCv2(BigDecimal cv2) {
        this.cv2 = cv2;
    }

    public BigDecimal getCv3() {
        return cv3;
    }

    public void setCv3(BigDecimal cv3) {
        this.cv3 = cv3;
    }

    public String getBatchNo1() {
        return batchNo1;
    }

    public void setBatchNo1(String batchNo1) {
        this.batchNo1 = batchNo1 == null ? null : batchNo1.trim();
    }

    public String getBatchNo2() {
        return batchNo2;
    }

    public void setBatchNo2(String batchNo2) {
        this.batchNo2 = batchNo2 == null ? null : batchNo2.trim();
    }

    public String getBatchNo3() {
        return batchNo3;
    }

    public void setBatchNo3(String batchNo3) {
        this.batchNo3 = batchNo3 == null ? null : batchNo3.trim();
    }
}