package com.ht.extra.preTreatment;

import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.io.UnsupportedEncodingException;

/**
 * Created by Dell on 2016/12/13.
 */
@WebService(targetNamespace = "http://impl.PreTreatment.extra.ht.com/")
public interface PreTreatment {
    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/queryHosBase")
    @WebResult String queryHosBase(@WebParam(name = "queryHosBase") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/queryDept")
    @WebResult String queryDept(@WebParam(name = "queryDept") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/queryDoctor")
    @WebResult String queryDoctor(@WebParam(name = "queryDoctor") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/querySchedule")
    @WebResult String querySchedule(@WebParam(name = "querySchedule") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/querySource")
    @WebResult String querySource(@WebParam(name = "querySource") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/addOrder")
    @WebResult String addOrder(@WebParam(name = "addOrder") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/cancelOrder")
    @WebResult String cancelOrder(@WebParam(name = "cancelOrder") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/queryOrder")
    @WebResult String queryOrder(@WebParam(name = "queryOrder") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/payOrder")
    @WebResult String payOrder(@WebParam(name = "payOrder") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/refundReg")
    @WebResult String refundReg(@WebParam(name = "refundReg") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/queryChargeType")
    @WebResult String queryChargeType(@WebParam(name = "queryChargeType") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/register")
    @WebResult String register(@WebParam(name = "register") String XmlParam);

    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/queryStopSch")
    @WebResult String queryStopSch(@WebParam(name = "queryStopSch") String XmlParam);

//    @WebMethod(action = "http://impl.PreTreatment.extra.ht.com/queryScheduleN")
//    @WebResult String queryScheduleN(@WebParam(name="queryScheduleN") String XmlParam);

}
