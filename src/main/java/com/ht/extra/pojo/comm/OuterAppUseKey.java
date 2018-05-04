package com.ht.extra.pojo.comm;

public class OuterAppUseKey {
    private String application;

    private String dictFileName;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getDictFileName() {
        return dictFileName;
    }

    public void setDictFileName(String dictFileName) {
        this.dictFileName = dictFileName == null ? null : dictFileName.trim();
    }
}