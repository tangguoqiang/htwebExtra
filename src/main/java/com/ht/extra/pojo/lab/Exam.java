package com.ht.extra.pojo.lab;

public class Exam {
    private Short serialNo;

    private String itemCode1;

    private String itemCode2;

    private String itemCode3;

    private String itemCode4;

    private String itemCode5;

    private Short x;

    private Short y;

    private String condition;

    private String descExam;

    private String examClass;

    public Short getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Short serialNo) {
        this.serialNo = serialNo;
    }

    public String getItemCode1() {
        return itemCode1;
    }

    public void setItemCode1(String itemCode1) {
        this.itemCode1 = itemCode1 == null ? null : itemCode1.trim();
    }

    public String getItemCode2() {
        return itemCode2;
    }

    public void setItemCode2(String itemCode2) {
        this.itemCode2 = itemCode2 == null ? null : itemCode2.trim();
    }

    public String getItemCode3() {
        return itemCode3;
    }

    public void setItemCode3(String itemCode3) {
        this.itemCode3 = itemCode3 == null ? null : itemCode3.trim();
    }

    public String getItemCode4() {
        return itemCode4;
    }

    public void setItemCode4(String itemCode4) {
        this.itemCode4 = itemCode4 == null ? null : itemCode4.trim();
    }

    public String getItemCode5() {
        return itemCode5;
    }

    public void setItemCode5(String itemCode5) {
        this.itemCode5 = itemCode5 == null ? null : itemCode5.trim();
    }

    public Short getX() {
        return x;
    }

    public void setX(Short x) {
        this.x = x;
    }

    public Short getY() {
        return y;
    }

    public void setY(Short y) {
        this.y = y;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition == null ? null : condition.trim();
    }

    public String getDescExam() {
        return descExam;
    }

    public void setDescExam(String descExam) {
        this.descExam = descExam == null ? null : descExam.trim();
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass == null ? null : examClass.trim();
    }
}