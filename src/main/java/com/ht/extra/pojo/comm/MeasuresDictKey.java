package com.ht.extra.pojo.comm;

public class MeasuresDictKey {
    private String measuresClass;

    private String measuresName;

    public String getMeasuresClass() {
        return measuresClass;
    }

    public void setMeasuresClass(String measuresClass) {
        this.measuresClass = measuresClass == null ? null : measuresClass.trim();
    }

    public String getMeasuresName() {
        return measuresName;
    }

    public void setMeasuresName(String measuresName) {
        this.measuresName = measuresName == null ? null : measuresName.trim();
    }
}