package com.ht.extra.pojo.comm;

public class InputDictDefine extends InputDictDefineKey {
    private Integer serialNo;

    private String application;

    private String dictType;

    private Short itemWidth;

    private Short allowEdit;

    private Short userDefine;

    public Integer getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(Integer serialNo) {
        this.serialNo = serialNo;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    public Short getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(Short itemWidth) {
        this.itemWidth = itemWidth;
    }

    public Short getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Short allowEdit) {
        this.allowEdit = allowEdit;
    }

    public Short getUserDefine() {
        return userDefine;
    }

    public void setUserDefine(Short userDefine) {
        this.userDefine = userDefine;
    }
}