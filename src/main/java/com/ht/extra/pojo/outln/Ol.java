package com.ht.extra.pojo.outln;

import java.math.BigDecimal;
import java.util.Date;

public class Ol {
    private String olName;

    private BigDecimal textlen;

    private BigDecimal hashValue;

    private BigDecimal hashValue2;

    private String category;

    private String version;

    private String creator;

    private Date timestamp;

    private BigDecimal flags;

    private BigDecimal hintcount;

    private BigDecimal spare1;

    private String spare2;

    public String getOlName() {
        return olName;
    }

    public void setOlName(String olName) {
        this.olName = olName == null ? null : olName.trim();
    }

    public BigDecimal getTextlen() {
        return textlen;
    }

    public void setTextlen(BigDecimal textlen) {
        this.textlen = textlen;
    }

    public BigDecimal getHashValue() {
        return hashValue;
    }

    public void setHashValue(BigDecimal hashValue) {
        this.hashValue = hashValue;
    }

    public BigDecimal getHashValue2() {
        return hashValue2;
    }

    public void setHashValue2(BigDecimal hashValue2) {
        this.hashValue2 = hashValue2;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getFlags() {
        return flags;
    }

    public void setFlags(BigDecimal flags) {
        this.flags = flags;
    }

    public BigDecimal getHintcount() {
        return hintcount;
    }

    public void setHintcount(BigDecimal hintcount) {
        this.hintcount = hintcount;
    }

    public BigDecimal getSpare1() {
        return spare1;
    }

    public void setSpare1(BigDecimal spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2 == null ? null : spare2.trim();
    }
}