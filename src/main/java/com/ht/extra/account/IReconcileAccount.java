package com.ht.extra.account;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 对账接口
 * @author HL
 */
@WebService(targetNamespace = "http://impl.account.extra.ht.com/")
public interface IReconcileAccount {

    /**
     * 对账接口
     * @param xmlStr xml request
     * @return response
     */
    @WebMethod(action = "http://impl.account.extra.ht.com/reconcile")
    @WebResult
    String reconcileAccount(@WebParam(name = "reconcile") String xmlStr);
}
