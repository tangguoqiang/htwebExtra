package com.ht.extra.regTreatment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by jpzhang on 2017/9/13.
 */
@WebService(targetNamespace = "http://impl.regTreatment.extra.ht.com/")

public interface RegTreatment {
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/getPatientInfo")
    @WebResult String getPatientInfo(@WebParam(name = "getPatientInfo") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/registerCtznCard")
    @WebResult String registerCtznCard(@WebParam(name = "registerCtznCard") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/getSchedueInfo")
    @WebResult String getSchedueInfo(@WebParam(name = "getSchedueInfo") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/canRegisterType")
    @WebResult String canRegisterType(@WebParam(name = "canRegisterType") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/getCurrentRegisterType")
    @WebResult String getCurrentRegisterType(@WebParam(name = "getCurrentRegisterType") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/saveBillItems")
    @WebResult String saveBillItems(@WebParam(name = "saveBillItems") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/getPatientItemsInfo")
    @WebResult String getPatientItemsInfo(@WebParam(name = "getPatientItemsInfo") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/getReserveInfo")
    @WebResult String getReserveInfo(@WebParam(name = "getReserveInfo") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/getPriceListInfo")
    @WebResult String getPriceListInfo(@WebParam(name = "getPriceListInfo") String xmlStr);
    @WebMethod(action = "http://impl.regTreatment.extra.ht.com/reservateConfirm")
    @WebResult String reservateConfirm(@WebParam(name = "reservateConfirm") String xmlStr);
}
