package com.ht.extra.pojo.outln;

import java.math.BigDecimal;

public class OlNodes {
    private String olName;

    private String category;

    private BigDecimal nodeId;

    private BigDecimal parentId;

    private BigDecimal nodeType;

    private BigDecimal nodeTextlen;

    private BigDecimal nodeTextoff;

    private String nodeName;

    public String getOlName() {
        return olName;
    }

    public void setOlName(String olName) {
        this.olName = olName == null ? null : olName.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getNodeId() {
        return nodeId;
    }

    public void setNodeId(BigDecimal nodeId) {
        this.nodeId = nodeId;
    }

    public BigDecimal getParentId() {
        return parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getNodeType() {
        return nodeType;
    }

    public void setNodeType(BigDecimal nodeType) {
        this.nodeType = nodeType;
    }

    public BigDecimal getNodeTextlen() {
        return nodeTextlen;
    }

    public void setNodeTextlen(BigDecimal nodeTextlen) {
        this.nodeTextlen = nodeTextlen;
    }

    public BigDecimal getNodeTextoff() {
        return nodeTextoff;
    }

    public void setNodeTextoff(BigDecimal nodeTextoff) {
        this.nodeTextoff = nodeTextoff;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }
}