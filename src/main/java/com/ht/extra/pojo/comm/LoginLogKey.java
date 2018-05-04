package com.ht.extra.pojo.comm;

import java.math.BigDecimal;
import java.util.Date;

public class LoginLogKey {
    private BigDecimal sessionId;

    private Date loginOnTime;

    public BigDecimal getSessionId() {
        return sessionId;
    }

    public void setSessionId(BigDecimal sessionId) {
        this.sessionId = sessionId;
    }

    public Date getLoginOnTime() {
        return loginOnTime;
    }

    public void setLoginOnTime(Date loginOnTime) {
        this.loginOnTime = loginOnTime;
    }
}