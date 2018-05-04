package com.ht.extra.inTreatment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Dell on 2016/12/13.
 */
@WebService(targetNamespace = "http://impl.inTreatment.extra.ht.com/")
public interface InTreatment {

    @WebMethod(action = "http://impl.inTreatment.extra.ht.com/requestWS")
    @WebResult String requestWS(@WebParam(name = "requestWS") String xmlStr);
}
