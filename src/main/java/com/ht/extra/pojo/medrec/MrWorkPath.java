package com.ht.extra.pojo.medrec;

public class MrWorkPath {
    private String mrPath;

    private String templetPath;

    private String fileUser;

    private String filePwd;

    private String ipAddr;

    public String getMrPath() {
        return mrPath;
    }

    public void setMrPath(String mrPath) {
        this.mrPath = mrPath == null ? null : mrPath.trim();
    }

    public String getTempletPath() {
        return templetPath;
    }

    public void setTempletPath(String templetPath) {
        this.templetPath = templetPath == null ? null : templetPath.trim();
    }

    public String getFileUser() {
        return fileUser;
    }

    public void setFileUser(String fileUser) {
        this.fileUser = fileUser == null ? null : fileUser.trim();
    }

    public String getFilePwd() {
        return filePwd;
    }

    public void setFilePwd(String filePwd) {
        this.filePwd = filePwd == null ? null : filePwd.trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }
}