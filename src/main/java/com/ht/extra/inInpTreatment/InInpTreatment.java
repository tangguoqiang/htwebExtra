package com.ht.extra.inInpTreatment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Administrator on 2017/1/13.
 */
@WebService(targetNamespace = "http://impl.inInpTreatment.extra.ht.com/")
public interface InInpTreatment {
    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/bindZyCard")
    @WebResult String bindZyCard(@WebParam(name = "bindZyCard") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryCheckinInfoList")
    @WebResult String queryCheckinInfoList(@WebParam(name = "queryCheckinInfoList") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryCheckinInfo")
    @WebResult String queryCheckinInfo(@WebParam(name = "queryCheckinInfo") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryDailyLedgerCount")
    @WebResult String queryDailyLedgerCount(@WebParam(name = "queryDailyLedgerCount") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryDailyLedgerList")
    @WebResult String queryDailyLedgerList(@WebParam(name = "queryDailyLedgerList") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryDailyLedger")
    @WebResult String queryDailyLedger(@WebParam(name = "queryDailyLedger") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/payDepositFee")
    @WebResult String payDepositFee(@WebParam(name = "payDepositFee") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryPayState")
    @WebResult String queryPayState(@WebParam(name = "queryPayState") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryPayment")
    @WebResult String queryPayment(@WebParam(name = "queryPayment") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryExamReportList")
    @WebResult String queryExamReportList(@WebParam(name = "queryExamReportList") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryExamReport")
    @WebResult String queryExamReport(@WebParam(name = "queryExamReport") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryLabReprotList")
    @WebResult String queryLabReprotList(@WebParam(name = "queryLabReprotList") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/queryLabResult")
    @WebResult String queryLabResult(@WebParam(name = "queryLabResult") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/getInPatientInfo")
    @WebResult String getInPatientInfo(@WebParam(name = "getInPatientInfo") String xmlStr);

    @WebMethod(action = "http://impl.inInpTreatment.extra.ht.com/payDepositHospitalFee")
    @WebResult String payDepositHospitalFee(@WebParam(name = "payDepositHospitalFee") String xmlStr);
}
