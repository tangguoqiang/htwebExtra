package com.ht.extra.pojo.lab;

import java.util.Date;

public class InstrumentDict {
    private String instId;

    private String instName;

    private String instNo;

    private Integer duplexFlag;

    private String diluteFlag;

    private String autoinFlag;

    private String commPort;

    private Long baudRate;

    private Integer byteSize;

    private Integer parity;

    private Integer stopBits;

    private Integer fOutx;

    private Integer fInx;

    private Integer fHardware;

    private Long txQueuesize;

    private Long rxQueuesize;

    private Long xonLim;

    private Long xoffLim;

    private String xonChar;

    private String xoffChar;

    private String errorChar;

    private String eventChar;

    private String driverProg;

    private Integer priority;

    private String serveStatus;

    private String itemType;

    private String factory;

    private String description;

    private Date connectDate;

    private String computerName;

    private Integer autoLoad;

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName == null ? null : instName.trim();
    }

    public String getInstNo() {
        return instNo;
    }

    public void setInstNo(String instNo) {
        this.instNo = instNo == null ? null : instNo.trim();
    }

    public Integer getDuplexFlag() {
        return duplexFlag;
    }

    public void setDuplexFlag(Integer duplexFlag) {
        this.duplexFlag = duplexFlag;
    }

    public String getDiluteFlag() {
        return diluteFlag;
    }

    public void setDiluteFlag(String diluteFlag) {
        this.diluteFlag = diluteFlag == null ? null : diluteFlag.trim();
    }

    public String getAutoinFlag() {
        return autoinFlag;
    }

    public void setAutoinFlag(String autoinFlag) {
        this.autoinFlag = autoinFlag == null ? null : autoinFlag.trim();
    }

    public String getCommPort() {
        return commPort;
    }

    public void setCommPort(String commPort) {
        this.commPort = commPort == null ? null : commPort.trim();
    }

    public Long getBaudRate() {
        return baudRate;
    }

    public void setBaudRate(Long baudRate) {
        this.baudRate = baudRate;
    }

    public Integer getByteSize() {
        return byteSize;
    }

    public void setByteSize(Integer byteSize) {
        this.byteSize = byteSize;
    }

    public Integer getParity() {
        return parity;
    }

    public void setParity(Integer parity) {
        this.parity = parity;
    }

    public Integer getStopBits() {
        return stopBits;
    }

    public void setStopBits(Integer stopBits) {
        this.stopBits = stopBits;
    }

    public Integer getfOutx() {
        return fOutx;
    }

    public void setfOutx(Integer fOutx) {
        this.fOutx = fOutx;
    }

    public Integer getfInx() {
        return fInx;
    }

    public void setfInx(Integer fInx) {
        this.fInx = fInx;
    }

    public Integer getfHardware() {
        return fHardware;
    }

    public void setfHardware(Integer fHardware) {
        this.fHardware = fHardware;
    }

    public Long getTxQueuesize() {
        return txQueuesize;
    }

    public void setTxQueuesize(Long txQueuesize) {
        this.txQueuesize = txQueuesize;
    }

    public Long getRxQueuesize() {
        return rxQueuesize;
    }

    public void setRxQueuesize(Long rxQueuesize) {
        this.rxQueuesize = rxQueuesize;
    }

    public Long getXonLim() {
        return xonLim;
    }

    public void setXonLim(Long xonLim) {
        this.xonLim = xonLim;
    }

    public Long getXoffLim() {
        return xoffLim;
    }

    public void setXoffLim(Long xoffLim) {
        this.xoffLim = xoffLim;
    }

    public String getXonChar() {
        return xonChar;
    }

    public void setXonChar(String xonChar) {
        this.xonChar = xonChar == null ? null : xonChar.trim();
    }

    public String getXoffChar() {
        return xoffChar;
    }

    public void setXoffChar(String xoffChar) {
        this.xoffChar = xoffChar == null ? null : xoffChar.trim();
    }

    public String getErrorChar() {
        return errorChar;
    }

    public void setErrorChar(String errorChar) {
        this.errorChar = errorChar == null ? null : errorChar.trim();
    }

    public String getEventChar() {
        return eventChar;
    }

    public void setEventChar(String eventChar) {
        this.eventChar = eventChar == null ? null : eventChar.trim();
    }

    public String getDriverProg() {
        return driverProg;
    }

    public void setDriverProg(String driverProg) {
        this.driverProg = driverProg == null ? null : driverProg.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getServeStatus() {
        return serveStatus;
    }

    public void setServeStatus(String serveStatus) {
        this.serveStatus = serveStatus == null ? null : serveStatus.trim();
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory == null ? null : factory.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getConnectDate() {
        return connectDate;
    }

    public void setConnectDate(Date connectDate) {
        this.connectDate = connectDate;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName == null ? null : computerName.trim();
    }

    public Integer getAutoLoad() {
        return autoLoad;
    }

    public void setAutoLoad(Integer autoLoad) {
        this.autoLoad = autoLoad;
    }
}