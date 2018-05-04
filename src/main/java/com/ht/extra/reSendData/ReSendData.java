package com.ht.extra.reSendData;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by xps13 on 2017/4/11.
 */
@WebService(targetNamespace = "http://impl.reSendData.extra.ht.com/")
public interface ReSendData {

    @WebMethod(action = "http://impl.reSendData.extra.ht.com/toSend")
    @WebResult String toSend(@WebParam(name = "toSendData",targetNamespace = "http://impl.reSendData.extra.ht.com/") String xmlStr);
}
