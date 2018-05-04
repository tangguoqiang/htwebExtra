package com.ht.extra.endTreatment;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by Dell on 2016/12/13.
 */
@WebService(targetNamespace = "http://impl.endTreatment.extra.ht.com/")
public interface EndTreatment {
    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/inDepService")
    @WebResult String inDepService(@WebParam(name = "inDepService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/inDoctorService")
    @WebResult String inDoctorService(@WebParam(name = "inDoctorService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/inHaPatientService")
    @WebResult String inHaPatientService(@WebParam(name = "inHaPatientService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/inHaHospDetailService")
    @WebResult String inHaHospDetailService(@WebParam(name = "inHaHospDetailService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/inHaOperationService")
    @WebResult String inHaOperationService(@WebParam(name = "inHaOperationService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/inHaDiseaseService")
    @WebResult String inHaDiseaseService(@WebParam(name = "inHaDiseaseService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/InHaDiagnosisService")
    @WebResult String InHaDiagnosisService(@WebParam(name = "InHaDiagnosisService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/outHaDiseaseService")
    @WebResult String outHaDiseaseService(@WebParam(name = "outHaDiseaseService") String xmlStr);

    @WebMethod(action = "http://impl.endTreatment.extra.ht.com/inHaMedicineService")
    @WebResult String inHaMedicineService(@WebParam(name = "inHaMedicineService") String xmlStr);


}
