package com.ht.extra.pojo.medrec;

import java.math.BigDecimal;

public class BloodTransfusion extends BloodTransfusionKey {
    private Integer wholeBlood;

    private Integer redCell;

    private Integer pureRedCell;

    private Integer platelet;

    private Integer cryoagglutinin;

    private Integer plasma;

    private Integer autotransfusion;

    private BigDecimal others;

    private BigDecimal wholeBlood2;

    private BigDecimal redCell2;

    private BigDecimal pureRedCell2;

    private BigDecimal platelet21;

    private BigDecimal platelet22;

    private BigDecimal plasma2;

    private BigDecimal autotransfusion2;

    private String otherBloodName;

    public Integer getWholeBlood() {
        return wholeBlood;
    }

    public void setWholeBlood(Integer wholeBlood) {
        this.wholeBlood = wholeBlood;
    }

    public Integer getRedCell() {
        return redCell;
    }

    public void setRedCell(Integer redCell) {
        this.redCell = redCell;
    }

    public Integer getPureRedCell() {
        return pureRedCell;
    }

    public void setPureRedCell(Integer pureRedCell) {
        this.pureRedCell = pureRedCell;
    }

    public Integer getPlatelet() {
        return platelet;
    }

    public void setPlatelet(Integer platelet) {
        this.platelet = platelet;
    }

    public Integer getCryoagglutinin() {
        return cryoagglutinin;
    }

    public void setCryoagglutinin(Integer cryoagglutinin) {
        this.cryoagglutinin = cryoagglutinin;
    }

    public Integer getPlasma() {
        return plasma;
    }

    public void setPlasma(Integer plasma) {
        this.plasma = plasma;
    }

    public Integer getAutotransfusion() {
        return autotransfusion;
    }

    public void setAutotransfusion(Integer autotransfusion) {
        this.autotransfusion = autotransfusion;
    }

    public BigDecimal getOthers() {
        return others;
    }

    public void setOthers(BigDecimal others) {
        this.others = others;
    }

    public BigDecimal getWholeBlood2() {
        return wholeBlood2;
    }

    public void setWholeBlood2(BigDecimal wholeBlood2) {
        this.wholeBlood2 = wholeBlood2;
    }

    public BigDecimal getRedCell2() {
        return redCell2;
    }

    public void setRedCell2(BigDecimal redCell2) {
        this.redCell2 = redCell2;
    }

    public BigDecimal getPureRedCell2() {
        return pureRedCell2;
    }

    public void setPureRedCell2(BigDecimal pureRedCell2) {
        this.pureRedCell2 = pureRedCell2;
    }

    public BigDecimal getPlatelet21() {
        return platelet21;
    }

    public void setPlatelet21(BigDecimal platelet21) {
        this.platelet21 = platelet21;
    }

    public BigDecimal getPlatelet22() {
        return platelet22;
    }

    public void setPlatelet22(BigDecimal platelet22) {
        this.platelet22 = platelet22;
    }

    public BigDecimal getPlasma2() {
        return plasma2;
    }

    public void setPlasma2(BigDecimal plasma2) {
        this.plasma2 = plasma2;
    }

    public BigDecimal getAutotransfusion2() {
        return autotransfusion2;
    }

    public void setAutotransfusion2(BigDecimal autotransfusion2) {
        this.autotransfusion2 = autotransfusion2;
    }

    public String getOtherBloodName() {
        return otherBloodName;
    }

    public void setOtherBloodName(String otherBloodName) {
        this.otherBloodName = otherBloodName == null ? null : otherBloodName.trim();
    }
}