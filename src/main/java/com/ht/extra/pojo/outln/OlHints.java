package com.ht.extra.pojo.outln;

import java.math.BigDecimal;

public class OlHints {
    private String olName;

    private BigDecimal hint;

    private String category;

    private BigDecimal hintType;

    private String hintText;

    private BigDecimal stage;

    private BigDecimal node;

    private String tableName;

    private BigDecimal tableTin;

    private BigDecimal tablePos;

    private BigDecimal refId;

    private String userTableName;

    private Double cost;

    private Double cardinality;

    private Double bytes;

    private BigDecimal hintTextoff;

    private BigDecimal hintTextlen;

    private String joinPred;

    private BigDecimal spare1;

    private BigDecimal spare2;

    private String hintString;

    public String getOlName() {
        return olName;
    }

    public void setOlName(String olName) {
        this.olName = olName == null ? null : olName.trim();
    }

    public BigDecimal getHint() {
        return hint;
    }

    public void setHint(BigDecimal hint) {
        this.hint = hint;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getHintType() {
        return hintType;
    }

    public void setHintType(BigDecimal hintType) {
        this.hintType = hintType;
    }

    public String getHintText() {
        return hintText;
    }

    public void setHintText(String hintText) {
        this.hintText = hintText == null ? null : hintText.trim();
    }

    public BigDecimal getStage() {
        return stage;
    }

    public void setStage(BigDecimal stage) {
        this.stage = stage;
    }

    public BigDecimal getNode() {
        return node;
    }

    public void setNode(BigDecimal node) {
        this.node = node;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public BigDecimal getTableTin() {
        return tableTin;
    }

    public void setTableTin(BigDecimal tableTin) {
        this.tableTin = tableTin;
    }

    public BigDecimal getTablePos() {
        return tablePos;
    }

    public void setTablePos(BigDecimal tablePos) {
        this.tablePos = tablePos;
    }

    public BigDecimal getRefId() {
        return refId;
    }

    public void setRefId(BigDecimal refId) {
        this.refId = refId;
    }

    public String getUserTableName() {
        return userTableName;
    }

    public void setUserTableName(String userTableName) {
        this.userTableName = userTableName == null ? null : userTableName.trim();
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getCardinality() {
        return cardinality;
    }

    public void setCardinality(Double cardinality) {
        this.cardinality = cardinality;
    }

    public Double getBytes() {
        return bytes;
    }

    public void setBytes(Double bytes) {
        this.bytes = bytes;
    }

    public BigDecimal getHintTextoff() {
        return hintTextoff;
    }

    public void setHintTextoff(BigDecimal hintTextoff) {
        this.hintTextoff = hintTextoff;
    }

    public BigDecimal getHintTextlen() {
        return hintTextlen;
    }

    public void setHintTextlen(BigDecimal hintTextlen) {
        this.hintTextlen = hintTextlen;
    }

    public String getJoinPred() {
        return joinPred;
    }

    public void setJoinPred(String joinPred) {
        this.joinPred = joinPred == null ? null : joinPred.trim();
    }

    public BigDecimal getSpare1() {
        return spare1;
    }

    public void setSpare1(BigDecimal spare1) {
        this.spare1 = spare1;
    }

    public BigDecimal getSpare2() {
        return spare2;
    }

    public void setSpare2(BigDecimal spare2) {
        this.spare2 = spare2;
    }

    public String getHintString() {
        return hintString;
    }

    public void setHintString(String hintString) {
        this.hintString = hintString == null ? null : hintString.trim();
    }
}