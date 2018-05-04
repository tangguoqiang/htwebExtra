package com.ht.extra.pojo.comm;

public class FileServers extends FileServersKey {
    private String ipAddr;

    private Integer port;

    private String protocol;

    private String fileUser;

    private String filePwd;

    private String filePath;

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }
}