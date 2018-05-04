package com.ht.extra.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Dell on 2016/12/13.
 */
@WebService(targetNamespace = "http://impl.test.extra.ht.com/")
public interface HelloWorld {

    @WebMethod(action = "http://impl.test.extra.ht.com/toSend")
    @WebResult String toSend(@WebParam(name="toSend") String xmlStr);
}
