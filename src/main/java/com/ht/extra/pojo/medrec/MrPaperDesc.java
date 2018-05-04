package com.ht.extra.pojo.medrec;

import java.math.BigDecimal;

public class MrPaperDesc extends MrPaperDescKey {
    private BigDecimal height;

    private BigDecimal width;

    private BigDecimal leftMargin;

    private BigDecimal topMargin;

    private Short orderLines;

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(BigDecimal leftMargin) {
        this.leftMargin = leftMargin;
    }

    public BigDecimal getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(BigDecimal topMargin) {
        this.topMargin = topMargin;
    }

    public Short getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(Short orderLines) {
        this.orderLines = orderLines;
    }
}