package com.ht.extra.pojo.comm;

public class FileServersKey {
    private String application;

    private String fileClass;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application == null ? null : application.trim();
    }

    public String getFileClass() {
        return fileClass;
    }

    public void setFileClass(String fileClass) {
        this.fileClass = fileClass == null ? null : fileClass.trim();
    }
}