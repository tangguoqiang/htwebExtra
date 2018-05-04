package com.ht.extra.pojo.exam;

import java.math.BigDecimal;

public class ExamItems extends ExamItemsKey {
    private String examItem;

    private String examItemCode;

    private BigDecimal costs;

    private String examSubClass;

    public String getExamItem() {
        return examItem;
    }

    public void setExamItem(String examItem) {
        this.examItem = examItem == null ? null : examItem.trim();
    }

    public String getExamItemCode() {
        return examItemCode;
    }

    public void setExamItemCode(String examItemCode) {
        this.examItemCode = examItemCode == null ? null : examItemCode.trim();
    }

    public BigDecimal getCosts() {
        return costs;
    }

    public void setCosts(BigDecimal costs) {
        this.costs = costs;
    }

    public String getExamSubClass() {
        return examSubClass;
    }

    public void setExamSubClass(String examSubClass) {
        this.examSubClass = examSubClass == null ? null : examSubClass.trim();
    }
}