package com.ht.extra.endTreatment.impl;

import com.ht.extra.dao.*;
import com.ht.extra.endTreatment.EndTreatment;

import com.ht.extra.pojo.comm.DeptDict;
import com.ht.extra.pojo.comm.RelationshipDict;
import com.ht.extra.pojo.comm.StaffDict;
import com.ht.extra.pojo.medrec.*;
import com.ht.extra.pojo.ordadm.Orders;
import com.ht.extra.pojo.ordadm.OrdersKey;
import com.ht.extra.pojo.outpadm.ClinicIndex;
import com.ht.extra.pojo.outpadm.ClinicMaster;
import com.ht.extra.pojo.outpdoct.OutpMr;
import com.ht.extra.pojo.outpdoct.OutpMrKey;
import com.ht.extra.util.DateToWeek;
import com.ht.extra.util.StringUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class EndTreatmentImpl implements EndTreatment {
    private static Logger logger = Logger.getLogger(EndTreatmentImpl.class);
    @Resource
    private DeptDictMapper deptDictMapper;
    @Resource
    private ClinicIndexMapper clinicIndexMapper;
    @Resource
    private StaffDictMapper staffDictMapper;
    @Resource
    private PatMasterIndexMapper patMasterIndexMapper;
    @Resource
    private OperationMapper operationMapper;
    @Resource
    private DiagnosisMapper diagnosisMapper;
    @Resource
    private ClinicMasterMapper clinicMasterMapper;
    @Resource
    private OutpMrMapper outpMrMapper;
    @Resource
    private PatVisitMapper patVisitMapper;
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private RelationshipDictMapper relationshipDictMapper;
    @Override
    public String inDepService(String xmlStr) {
        logger.info("[诊后查询科室(inDepService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String deptNo = root.element("dep_no").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if (deptNo != null && deptNo.length() > 0) {
                Element data = listData.addElement("data");
                DeptDict deptDict = deptDictMapper.selectByPrimaryKey(deptNo);
                if (deptDict != null) {
                    data.addElement("dep_id").setText(StringUtil.Iso_GBK(deptDict.getDeptCode()));
                    data.addElement("dep_no").setText(StringUtil.Iso_GBK(deptDict.getDeptCode()));
                    data.addElement("dep_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                    data.addElement("short_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                    data.addElement("hospital_pos").setText(StringUtil.Iso_GBK(deptDict.getDeptLocation()));
                    data.addElement("phone").setText("");
                    data.addElement("cat_no").setText("");
                    data.addElement("unit_character").setText("");
                    List<ClinicIndex> clinicIndexList = clinicIndexMapper.selectByDept(deptNo);
                    if(clinicIndexList !=null && clinicIndexList.size()>0){
                        data.addElement("yuyue_status").setText("1");
                    }else{
                        data.addElement("yuyue_status").setText("0");
                    }
                    data.addElement("fanghao_rate").setText("");
                    data.addElement("dep_status").setText("1");
                    ///科室类别（1.住院;2.门诊;3.急诊;4.观察室;5:医技科室）
                    data.addElement("dep_type").setText("");

                    data.addElement("fax").setText("");
                    data.addElement("email").setText("");
                    data.addElement("url").setText("");
                    data.addElement("treat_limit").setText("");
                    data.addElement("unit_id").setText("");
                    data.addElement("dep_intro").setText("");
                }
            } else {
                //没有科室代码查询全部的科室
                List<DeptDict> deptDicts = deptDictMapper.selectByAll();
                if(deptDicts !=null && deptDicts.size()>0){
                    for(DeptDict deptDict : deptDicts){
                        Element data = listData.addElement("data");
                        data.addElement("dep_id").setText(StringUtil.Iso_GBK(deptDict.getDeptCode()));
                        data.addElement("dep_no").setText(StringUtil.Iso_GBK(deptDict.getDeptCode()));
                        data.addElement("dep_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                        data.addElement("short_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                        data.addElement("hospital_pos").setText(StringUtil.Iso_GBK(deptDict.getDeptLocation()));
                        data.addElement("phone").setText("");
                        data.addElement("cat_no").setText("");
                        data.addElement("unit_character").setText("");
                        List<ClinicIndex> clinicIndexList = clinicIndexMapper.selectByDept(deptNo);
                        if(clinicIndexList !=null && clinicIndexList.size()>0){
                            data.addElement("yuyue_status").setText("1");
                        }else{
                            data.addElement("yuyue_status").setText("0");
                        }
                        data.addElement("fanghao_rate").setText("");
                        data.addElement("dep_status").setText("1");
                        ///科室类别（1.住院;2.门诊;3.急诊;4.观察室;5:医技科室）
                        data.addElement("dep_type").setText("");

                        data.addElement("fax").setText("");
                        data.addElement("email").setText("");
                        data.addElement("url").setText("");
                        data.addElement("treat_limit").setText("");
                        data.addElement("unit_id").setText("");
                        data.addElement("dep_intro").setText("");
                    }
                }

            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String inDoctorService(String xmlStr) {
        logger.info("[诊后查询医生(inDepService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String docNo = root.element("doc_no").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if (docNo != null && docNo.length() > 0) {
                Element data = listData.addElement("data");
                StaffDict staffDict = staffDictMapper.selectByPrimaryKey(docNo);
                if (staffDict != null) {
                    data.addElement("doctor_id").setText(StringUtil.Iso_GBK(staffDict.getEmpNo()));
                    data.addElement("doc_no").setText(StringUtil.Iso_GBK(staffDict.getEmpNo()));
                    data.addElement("doctor_name").setText(StringUtil.Iso_GBK(staffDict.getName()));
                    if(staffDict.getDeptCode() !=null){
                        data.addElement("dep_no").setText(StringUtil.Iso_GBK(staffDict.getDeptCode()));
                        DeptDict deptDict = deptDictMapper.selectByPrimaryKey(staffDict.getDeptCode());
                        if(deptDict!=null && deptDict.getDeptName()!=null){
                            data.addElement("dep_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                        }else{
                            data.addElement("dep_name").setText("");
                        }
                    }else{
                        data.addElement("dep_no").setText("");
                        data.addElement("dep_name").setText("");
                    }
                    data.addElement("sex").setText("3");
                    data.addElement("edu_level").setText("");
                    data.addElement("zcid").setText(StringUtil.Iso_GBK(staffDict.getTitle()));
                    //是否是专家
                    data.addElement("is_expert").setText("");
                    data.addElement("doc_spec").setText("");

                    data.addElement("headship").setText("");

                    data.addElement("mobile").setText("");
                    data.addElement("email").setText("");
                    data.addElement("url").setText("");
                    data.addElement("expert").setText("");
                    data.addElement("detail").setText("");
                    data.addElement("phote").setText("");
                    data.addElement("unit_id").setText("");
                }else{
                    return getErrorlMsg("未查询到医生信息！");
                }
            } else {
                //查询全部的医生信息
                List<StaffDict> staffDicts = staffDictMapper.selectAll(StringUtil.Utf_Iso("医生"));
                if(staffDicts !=null && staffDicts.size()>0){
                    for(StaffDict staffDict : staffDicts){
                        Element data = listData.addElement("data");
                        data.addElement("doctor_id").setText(StringUtil.Iso_GBK(staffDict.getEmpNo()));
                        data.addElement("doc_no").setText(StringUtil.Iso_GBK(staffDict.getEmpNo()));
                        data.addElement("doctor_name").setText(StringUtil.Iso_GBK(staffDict.getName()));
                        if(staffDict.getDeptCode() !=null){
                            data.addElement("dep_no").setText(StringUtil.Iso_GBK(staffDict.getDeptCode()));
                        }else{
                            data.addElement("dep_no").setText("");
                        }
                        if(staffDict.getJob()!=null){
                            data.addElement("dep_name").setText(StringUtil.Iso_GBK(staffDict.getJob()));
                        }else{
                            data.addElement("dep_name").setText("");
                        }
                        data.addElement("sex").setText("3");
                        data.addElement("edu_level").setText("");
                        data.addElement("zcid").setText(StringUtil.Iso_GBK(staffDict.getTitle()));
                        //是否是专家
                        data.addElement("is_expert").setText("");
                        data.addElement("doc_spec").setText("");

                        data.addElement("headship").setText("");

                        data.addElement("mobile").setText("");
                        data.addElement("email").setText("");
                        data.addElement("url").setText("");
                        data.addElement("expert").setText("");
                        data.addElement("detail").setText("");
                        data.addElement("phote").setText("");
                        data.addElement("unit_id").setText("");
                    }
                }
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String inHaPatientService(String xmlStr) {
        logger.info("[诊后查询患者基本信息(inHaPatientService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String patientId = root.element("his_patient_id").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            Element data = listData.addElement("data");
            if(patientId !=null){
                //可查军队医改
                //PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientId);
                //不可可查军队医改
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientId);
                if(patMasterIndex!=null){
                    data.addElement("unit_id").setText("");
                    data.addElement("his_patient_id").setText(patientId);
                    data.addElement("patient_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                    //是否是专家
                    data.addElement("card_type").setText("01");
                    if(patMasterIndex.getCardNo() !=null){
                        data.addElement("card_no").setText(patMasterIndex.getCardNo());
                    }else{
                        data.addElement("card_no").setText("");
                    }
                    if(patMasterIndex.getPhoneNumberHome()!=null){
                        data.addElement("phone").setText(patMasterIndex.getPhoneNumberHome());
                    }else{
                        data.addElement("phone").setText("");
                    }

                    data.addElement("email").setText("");
                    data.addElement("social_card").setText("");
                    data.addElement("health_card").setText("");

                    if(patMasterIndex.getSex()!=null && "男".equals(patMasterIndex.getSex())){
                        data.addElement("sex").setText("1");
                    }else{
                        data.addElement("sex").setText("2");
                    }
                    if(patMasterIndex.getDateOfBirth()!=null){
                        data.addElement("birth").setText(DateToWeek.formatDateString(patMasterIndex.getDateOfBirth(),"yyyy-MM-dd"));
                    }else{
                        data.addElement("birth").setText("");
                    }
                    data.addElement("marital").setText("");
                    if(patMasterIndex.getMailingAddress()!=null){
                        data.addElement("address").setText(StringUtil.Iso_GBK(patMasterIndex.getMailingAddress()));
                    }else{
                        data.addElement("address").setText("");
                    }
                    data.addElement("job").setText("");
                    data.addElement("country").setText("");
                    if(patMasterIndex.getNation()!=null){
                        data.addElement("nation").setText(StringUtil.Iso_GBK(patMasterIndex.getNation()));
                    }else{
                        data.addElement("nation").setText("");
                    }
                    data.addElement("register").setText("");
                    data.addElement("company_name").setText("");
                    data.addElement("company_addr").setText("");
                    data.addElement("company_tel").setText("");
                    if(patMasterIndex.getNextOfKin()!=null){
                        data.addElement("contact_name").setText(StringUtil.Iso_GBK(patMasterIndex.getNextOfKin()));
                    }else{
                        data.addElement("contact_name").setText("");
                    }
                    if(patMasterIndex.getNextOfKinPhone()!=null){
                        data.addElement("contact_phone").setText(StringUtil.Iso_GBK(patMasterIndex.getNextOfKinPhone()));
                    }else{
                        data.addElement("contact_phone").setText("");
                    }
                    if(patMasterIndex.getRelationship()!=null){
                        RelationshipDict relationshipDict = relationshipDictMapper.selectByPrimaryKey(patMasterIndex.getRelationship());
                        data.addElement("relation").setText(StringUtil.Iso_GBK(relationshipDict.getRelationshipName()));
                    }else{
                        data.addElement("relation").setText("");
                    }
                    if(patMasterIndex.getNextOfKinAddr()!=null){
                        data.addElement("contact_addr").setText(StringUtil.Iso_GBK(patMasterIndex.getNextOfKinAddr()));
                    }else{
                        data.addElement("contact_addr").setText("");
                    }



                }else{
                    return getSuccessMsg("未查询到对应的病人信息！");
                }
            }else{
                return getErrorlMsg("病人id不能为空！");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }
//inHaHospDetailService
    @Override
    public String inHaHospDetailService(String xmlStr) {
        logger.info("[诊后查询患者基本信息(inHaPatientService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            //String patientId = root.element("his_patient_id").getTextTrim();
            String startDate = root.element("StartDate").getTextTrim();
            String endDate = root.element("EndDate").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if(startDate!=null && endDate!=null){
                List<PatVisit> patVisits = patVisitMapper.selectByOutDate(startDate,endDate);
                if(patVisits!=null){
                    for(PatVisit patVisit : patVisits){
                        String patientId = patVisit.getPatientId();
                        Element data = listData.addElement("data");
                        data.addElement("unit_id").setText("");
                        data.addElement("hosp_code").setText(patVisit.getPatientId()+"^"+patVisit.getVisitId());
                        data.addElement("hosp_no").setText(patVisit.getPatientId()+"^"+patVisit.getVisitId());
                        data.addElement("hosp_times").setText(patVisit.getVisitId().toString());
                        data.addElement("his_patient_id").setText(patVisit.getPatientId());
                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientId);
                        if(patMasterIndex!=null && patMasterIndex.getInpNo()!=null){
                            data.addElement("hosp_no1").setText(patMasterIndex.getInpNo());
                        }else{
                            data.addElement("hosp_no1").setText("");
                        }
                        if(patMasterIndex!=null && patMasterIndex.getPhoneNumberHome()!=null){
                            data.addElement("phone").setText(patMasterIndex.getPhoneNumberHome());
                        }else{
                            data.addElement("phone").setText("");
                        }
                        if(patMasterIndex!=null && patMasterIndex.getName()!=null){
                            data.addElement("patient_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                        }else{
                            data.addElement("patient_name").setText("");
                        }
                        if(patMasterIndex!=null && patMasterIndex.getIdNo()!=null){
                            data.addElement("card_no").setText(StringUtil.Iso_GBK(patMasterIndex.getIdNo()));
                        }else{
                            data.addElement("card_no").setText("");
                        }
                        if(patMasterIndex!=null && patMasterIndex.getChargeType()!=null){
                            data.addElement("charge_type").setText(StringUtil.Iso_GBK(patMasterIndex.getChargeType()));
                        }else{
                            data.addElement("charge_type").setText("");
                        }
                        if(patVisit.getAdmissionDateTime()!=null){
                            data.addElement("hosp_in_date").setText(DateToWeek.formatDateString(patVisit.getAdmissionDateTime(),"yyyy-MM-dd"));
                        }else{
                            data.addElement("hosp_in_date").setText("");
                        }
                        if(patVisit.getDischargeDateTime()!=null){
                            data.addElement("hosp_out_date").setText(DateToWeek.formatDateString(patVisit.getDischargeDateTime(),"yyyy-MM-dd"));
                        }else{
                            data.addElement("hosp_out_date").setText("");
                        }
                        if(patVisit.getAdmissionDateTime()!=null && patVisit.getDischargeDateTime()!=null){
                            double date = Math.floor((patVisit.getDischargeDateTime().getTime()-patVisit.getAdmissionDateTime().getTime()) / (1000 * 60 * 60 * 24));
                            data.addElement("days").setText(date+"");
                        }else{
                            data.addElement("days").setText("");
                        }
                        if(patVisit.getDeptAdmissionTo()!=null){
                            data.addElement("in_dep_no").setText(patVisit.getDeptAdmissionTo());
                            DeptDict deptDict = deptDictMapper.selectByPrimaryKey(patVisit.getDeptAdmissionTo());
                            if(deptDict!=null && deptDict.getDeptName()!=null){
                                data.addElement("in_dep_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                            }else{
                                data.addElement("in_dep_name").setText("");
                            }
                        }
                        if(patVisit.getDeptDischargeFrom()!=null){
                            data.addElement("out_dep_no").setText(patVisit.getDeptDischargeFrom());
                            DeptDict deptDict = deptDictMapper.selectByPrimaryKey(patVisit.getDeptDischargeFrom());
                            if(deptDict!=null && deptDict.getDeptName()!=null){
                                data.addElement("out_dep_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                            }else{
                                data.addElement("out_dep_name").setText("");
                            }
                        }
                        OperationKey operationKey = new OperationKey();
                        operationKey.setPatientId(patientId);
                        operationKey.setVisitId(patVisit.getVisitId());
                        List<Operation> operations = operationMapper.selectByPatient(operationKey);
                        if(operations!=null && operations.size()>0){
                            data.addElement("is_operate").setText("1");
                        }else{
                            data.addElement("is_operate").setText("0");
                        }
                        data.addElement("is_rediagnose").setText("");
                        data.addElement("rediagnose_days").setText("");
                        data.addElement("hosp_in_info").setText("");
                        DiagnosisKey diagnosisKey = new DiagnosisKey();
                        diagnosisKey.setPatientId(patientId);
                        diagnosisKey.setVisitId(patVisit.getVisitId());
                        diagnosisKey.setDiagnosisType("3");
                        diagnosisKey.setDiagnosisNo(Short.parseShort("1"));
                        Diagnosis diagnosis = diagnosisMapper.selectByPrimaryKey(diagnosisKey);
                        data.addElement("in_diag_code").setText("");
                        data.addElement("out_diag_code").setText("");
                        if(diagnosis !=null && diagnosis.getDiagnosisDesc()!=null){
                            data.addElement("in_diag_name").setText(StringUtil.Iso_GBK(diagnosis.getDiagnosisDesc()));
                            data.addElement("disease_name").setText(StringUtil.Iso_GBK(diagnosis.getDiagnosisDesc()));
                            data.addElement("out_diag_name").setText(StringUtil.Iso_GBK(diagnosis.getDiagnosisDesc()));

                        }else{
                            data.addElement("in_diag_name").setText("");
                            data.addElement("disease_name").setText("");
                            data.addElement("out_diag_name").setText("");
                        }
                        if(diagnosis !=null && diagnosis.getTreatResult()!=null){
                            data.addElement("result").setText(StringUtil.Iso_GBK(diagnosis.getTreatResult()));
                        }else{
                            data.addElement("result").setText("");
                        }
                        data.addElement("out_advice").setText("");
                        data.addElement("pathology_diag").setText("");
                        if(patVisit.getDirector()!=null){
                            data.addElement("dept_doc_no").setText(StringUtil.Iso_GBK(patVisit.getDirector()));
                            data.addElement("dept_doc_name").setText(StringUtil.Iso_GBK(patVisit.getDirector()));
                        }else{
                            data.addElement("dept_doc_no").setText("");
                            data.addElement("dept_doc_name").setText("");
                        }

                        if(patVisit.getAttendingDoctor()!=null){
                            data.addElement("attend_doc_no").setText(StringUtil.Iso_GBK(patVisit.getAttendingDoctor()));
                            data.addElement("attend_doc_name").setText(StringUtil.Iso_GBK(patVisit.getAttendingDoctor()));
                        }else{
                            data.addElement("attend_doc_no").setText("");
                            data.addElement("attend_doc_name").setText("");
                        }

                        if(patVisit.getDoctorInCharge()!=null){
                            data.addElement("hosp_doc_no").setText(StringUtil.Iso_GBK(patVisit.getDoctorInCharge()));
                            data.addElement("hosp_doc_name").setText(StringUtil.Iso_GBK(patVisit.getDoctorInCharge()));
                        }else{
                            data.addElement("hosp_doc_no").setText("");
                            data.addElement("hosp_doc_name").setText("");
                        }
                        if(patVisit.getDischargeDisposition()!=null){
                            if("1".equals(patVisit.getDischargeDisposition())){
                                data.addElement("out_type").setText("正常");
                            }
                            if("2".equals(patVisit.getDischargeDisposition())){
                                data.addElement("out_type").setText("转院");
                            }
                            if("3".equals(patVisit.getDischargeDisposition())){
                                data.addElement("out_type").setText("死亡");
                            }
                        }else{
                            data.addElement("out_type").setText("");
                        }
                        data.addElement("out_type_info").setText("");
                        if(patVisit.getChargeType()!=null){
                            data.addElement("cost_type").setText(StringUtil.Iso_GBK(patVisit.getChargeType()));
                        }else{
                            data.addElement("cost_type").setText("");
                        }
                        data.addElement("bed_no").setText("");
                        data.addElement("out_sum").setText("");
                    }
                }else{
                    return getSuccessMsg("未在时间内查询到住院信息");
                }
            }else{
                return getErrorlMsg("开始时间和结束时间不能为空");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    //手术记录查询
    @Override
    public String inHaOperationService(String xmlStr) {
        logger.info("[诊后查询住院患者手术记录(inHaOperationService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String hospCode = root.element("hosp_code").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if(hospCode !=null && hospCode.contains("^")){
                String patientId = hospCode.split("\\^")[0];
                String visitNo = hospCode.split("\\^")[1];
                OperationKey operationKey = new OperationKey();
                operationKey.setPatientId(patientId);
                operationKey.setVisitId(Short.parseShort(visitNo));
                List<Operation> operations = operationMapper.selectByPatient(operationKey);
                if(operations!=null){
                    for(Operation operation :operations){
                        Element data = listData.addElement("data");
                        data.addElement("his_patient_id").setText(patientId);
                        data.addElement("clinic_hosp_no").setText(hospCode);
                        data.addElement("hosp_times").setText(visitNo);
                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientId);
                        if(patMasterIndex !=null && patMasterIndex.getName()!=null){
                            data.addElement("patient_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                        }else{
                            data.addElement("patient_name").setText("");
                        }
                        if(operation.getOperationNo()!=null){
                            data.addElement("op_times").setText(operation.getOperationNo().toString());
                        }else{
                            data.addElement("op_times").setText("");
                        }
                        if(operation.getOperationCode()!=null){
                            data.addElement("op_code").setText(operation.getOperationCode());
                        }else{
                            data.addElement("op_code").setText("");
                        }
                        if(operation.getOperationDesc()!=null){
                            data.addElement("op_name").setText(StringUtil.Iso_GBK(operation.getOperationDesc()));
                        }else{
                            data.addElement("op_name").setText("");
                        }
                        if(operation.getOperatingDate()!=null){
                            data.addElement("op_date").setText(DateToWeek.formatDateString(operation.getOperatingDate(),"yyyy-MM-dd"));
                        }else{
                            data.addElement("op_date").setText("");
                        }
                        data.addElement("incision_no").setText("");
                        if(operation.getWoundGrade()!=null){
                            data.addElement("incision_name").setText(StringUtil.Iso_GBK(operation.getWoundGrade()));
                        }else{
                            data.addElement("incision_name").setText("");
                        }
                        data.addElement("union_no").setText("");
                        if(operation.getHeal()!=null){
                            data.addElement("union_name").setText(StringUtil.Iso_GBK(operation.getHeal()));
                        }else{
                            data.addElement("union_name").setText("");
                        }
                        data.addElement("anes_no").setText("");
                        if(operation.getAnaesthesiaMethod()!=null){
                            data.addElement("anes_name").setText(StringUtil.Iso_GBK(operation.getAnaesthesiaMethod()));
                        }else{
                            data.addElement("anes_name").setText("");
                        }
                        data.addElement("doc_no").setText("");
                        if(operation.getOperator()!=null){
                            data.addElement("doc_name").setText(StringUtil.Iso_GBK(operation.getOperator()));
                        }else{
                            data.addElement("doc_name").setText("");
                        }
                        data.addElement("unit_id").setText("");

                    }
                }else{
                    return getSuccessMsg("未查询到住院手术信息！");
                }
            }else{
                return getErrorlMsg("病人id不能为空!");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String inHaDiseaseService(String xmlStr) {
        logger.info("[诊后查询住院患者诊断(inHaDiseaseService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String hospCode = root.element("hosp_code").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if(hospCode !=null && hospCode.contains("^")){
                String patientId = hospCode.split("\\^")[0];
                String visitNo = hospCode.split("\\^")[1];
                DiagnosisKey diagnosisKey = new DiagnosisKey();
                diagnosisKey.setPatientId(patientId);
                diagnosisKey.setVisitId(Short.parseShort(visitNo));
                List<Diagnosis> diagnosises = diagnosisMapper.selectByPatientId(diagnosisKey);
                if(diagnosises!=null){
                    for(Diagnosis diagnosis : diagnosises){
                        Element data = listData.addElement("data");
                        data.addElement("his_patient_id").setText(patientId);
                        data.addElement("hosp_code").setText(hospCode);
                        data.addElement("hosp_no").setText(hospCode);
                        data.addElement("hosp_times").setText(visitNo);
                        data.addElement("diag_type").setText("住院诊断");
                        data.addElement("diag_times").setText(String.valueOf(diagnosises.size()));
                        data.addElement("icd_code").setText("");

                        if(diagnosis.getDiagnosisDesc()!=null){
                            data.addElement("disease_name").setText(StringUtil.Iso_GBK(diagnosis.getDiagnosisDesc()));
                        }else{
                            data.addElement("disease_name").setText("");
                        }
                        if(diagnosis.getTreatResult()!=null){
                            data.addElement("result").setText(StringUtil.Iso_GBK(diagnosis.getTreatResult()));
                        }else{
                            data.addElement("result").setText("");
                        }
                        data.addElement("doc_no").setText("");
                        data.addElement("hosp_in_info").setText("");
                        data.addElement("unit_id").setText("");

                    }
                }else{
                    return getSuccessMsg("未查询到住院诊断信息！");
                }
            }else{
                return getErrorlMsg("病人id不能为空!");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String InHaDiagnosisService(String xmlStr) {
        logger.info("[诊后查询门诊信息(InHaDiagnosisService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String startDate = root.element("StartDate").getTextTrim();
            String endDate = root.element("EndDate").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if(startDate!=null && endDate !=null){
                List<ClinicMaster> clinicMasters = clinicMasterMapper.selectByVisitDateAll(startDate,endDate);
                if(clinicMasters!=null && clinicMasters.size()>0){
                    for(ClinicMaster clinicMaster : clinicMasters){
                        Element data = listData.addElement("data");
                        if(clinicMaster.getVisitDept()!=null){
                            data.addElement("CLINIC_DEP_NO").setText(clinicMaster.getVisitDept());
                        }else{
                            data.addElement("CLINIC_DEP_NO").setText(clinicMaster.getVisitDept());
                        }
                        data.addElement("HIS_PATIENT_ID").setText(clinicMaster.getPatientId());
                        OutpMrKey outpMrKey = new OutpMrKey();
                        outpMrKey.setVisitDate(clinicMaster.getVisitDate());
                        outpMrKey.setVisitNo(clinicMaster.getVisitNo());
                        outpMrKey.setOrdinal(Short.parseShort("1"));
                        OutpMr outpMr = outpMrMapper.selectByPrimaryKey(outpMrKey);
                        String visitDate = DateToWeek.formatDateString(clinicMaster.getVisitDate(),"yyyy-MM-dd");
                        //patientId^visitDate^visitNo
                        data.addElement("CLINIC_NO").setText(clinicMaster.getPatientId()+"^"+visitDate+clinicMaster.getVisitNo());
                        data.addElement("CLINIC_DATE").setText(visitDate);
                        //主诊断编码
                        if(outpMr!=null && outpMr.getDiagCode()!=null){
                            data.addElement("CLINIC_DIAG_CODE").setText(StringUtil.Iso_GBK(outpMr.getDiagCode()));
                        }else{
                            data.addElement("CLINIC_DIAG_CODE").setText("");
                        }
                        //data.addElement("CLINIC_DIAG_CODE").setText("");
                        //主诊断名称
                        if(outpMr!=null && outpMr.getDiagDesc()!=null){
                            data.addElement("CLINIC_DIAG_NAME").setText(StringUtil.Iso_GBK(outpMr.getDiagDesc()));
                        }else{
                            data.addElement("CLINIC_DIAG_NAME").setText("");
                        }
                        //费用代码
                        data.addElement("COST_TYPE").setText("");

                        data.addElement("DOC_NO").setText("");
                        if(clinicMaster.getDoctor()!=null){
                            data.addElement("DOCTOR_NAME").setText(StringUtil.Iso_GBK(clinicMaster.getDoctor()));
                        }else{
                            data.addElement("DOCTOR_NAME").setText("");
                        }
                        if(clinicMaster.getChargeType()!=null){
                            data.addElement("COST_TYPE_NAME").setText(StringUtil.Iso_GBK(clinicMaster.getChargeType()));
                        }else{
                            data.addElement("COST_TYPE_NAME").setText("");
                        }
                        data.addElement("DISEASE_CODE").setText("");
                        data.addElement("OTHER_DGS").setText("");
                        data.addElement("YUYUE_ID").setText("");
                        data.addElement("UNIT_ID").setText("");
                    }
                }else{
                    return  getSuccessMsg("时间段内未查询到门诊信息！");
                }
            }else{
                return getErrorlMsg("开始时间和结束时间不能为空");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String outHaDiseaseService(String xmlStr) {
        logger.info("[诊后查询门诊诊断信息(outHaDiseaseService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String clinicHospNo = root.element("clinic_hosp_no").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if(clinicHospNo!=null && clinicHospNo.contains("^")){
                String patient = clinicHospNo.split("\\^")[0];
                String visitDate = clinicHospNo.split("\\^")[1];
                String visitNo = clinicHospNo.split("\\^")[2];
                OutpMrKey outpMrKey = new OutpMrKey();
                outpMrKey.setOrdinal(Short.parseShort("1"));
                outpMrKey.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                outpMrKey.setVisitNo(Short.parseShort(visitNo));
                OutpMr outpMr = outpMrMapper.selectByPrimaryKey(outpMrKey);
                Element data = listData.addElement("data");
                data.addElement("his_patient_id").setText(patient);
                data.addElement("clinic_hosp_no").setText(clinicHospNo);
                data.addElement("diag_type").setText("");
                data.addElement("diag_times").setText("1");
                if(outpMr!=null && outpMr.getDiagCode()!=null){
                    data.addElement("icd_code").setText(StringUtil.Iso_GBK(outpMr.getDiagCode()));
                }else{
                    data.addElement("icd_code").setText("");
                }
                if(outpMr!=null && outpMr.getDiagDesc()!=null){
                    data.addElement("disease_name").setText(StringUtil.Iso_GBK(outpMr.getDiagDesc()));
                }else{
                    data.addElement("disease_name").setText("");
                }
                data.addElement("result").setText("");
                if(outpMr!=null && outpMr.getDoctor()!=null){
                    data.addElement("doc_no").setText(StringUtil.Iso_GBK(outpMr.getDoctor()));
                }else{
                    data.addElement("doc_no").setText("");
                }
                data.addElement("hosp_in_info").setText("");
                data.addElement("unit_id").setText("");

            }else{
                return getErrorlMsg("病人id错误或不能为空!");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String inHaMedicineService(String xmlStr) {
        logger.info("[诊后查询住院患者用药情况(inHaMedicineService)  入参 :]" + xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String hospCode = root.element("hosp_code").getTextTrim();
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element listData = root1.addElement("listData");
            if(hospCode !=null && hospCode.contains("^")){
                String patientId = hospCode.split("\\^")[0];
                String visitNo = hospCode.split("\\^")[1];
                OrdersKey ordersKey = new OrdersKey();
                ordersKey.setVisitId(Short.parseShort(visitNo));
                ordersKey.setPatientId(patientId);
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientId);
                List<Orders> ordersList = ordersMapper.selectByPatient(ordersKey);
                if(ordersList!=null && ordersList.size()>0){
                    for(Orders orders : ordersList){
                        Element data = listData.addElement("data");
                        data.addElement("his_medicine_id").setText(orders.getOrderNo().toString());
                        data.addElement("hosp_no").setText(hospCode);
                        data.addElement("hosp_times").setText(visitNo);
                        data.addElement("his_patient_id").setText(patientId);
                        data.addElement("patient_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                        if(orders.getDoctor()!=null){
                            data.addElement("doc_no").setText(StringUtil.Iso_GBK(orders.getDoctor()));
                            data.addElement("doc_name").setText(StringUtil.Iso_GBK(orders.getDoctor()));
                        }else{
                            data.addElement("doc_no").setText("");
                            data.addElement("doc_name").setText("");
                        }
                        if(orders.getStartDateTime()!=null){
                            data.addElement("start_date").setText(DateToWeek.formatDateString(orders.getStartDateTime(),"yyyy-MM-dd HH:mm:ss"));
                        }else{
                            data.addElement("start_date").setText("");
                        }
                        if(orders.getStopDateTime()!=null){
                            data.addElement("end_date").setText(DateToWeek.formatDateString(orders.getStopDateTime(),"yyyy-MM-dd HH:mm:ss"));
                        }else{
                            data.addElement("end_date").setText("");
                        }

                        if(orders.getStartDateTime()!=null && orders.getStopDateTime()!=null){
                            double date = Math.ceil((orders.getStopDateTime().getTime()-orders.getStartDateTime().getTime()) / (1000 * 60 * 60 * 24));
                            data.addElement("days").setText(date+"");
                        }else{
                            data.addElement("days").setText("");
                        }
                        data.addElement("medicine_name").setText(StringUtil.Iso_GBK(orders.getOrderText()));
                        data.addElement("medicine_code").setText(StringUtil.Iso_GBK(orders.getOrderCode()));
                        if(orders.getDosage()!=null){
                            data.addElement("dosage").setText(orders.getDosage().toString());
                        }else{
                            data.addElement("dosage").setText("");
                        }
                        if(orders.getDosageUnits()!=null){
                            data.addElement("unit").setText(StringUtil.Iso_GBK(orders.getDosageUnits()));
                        }else{
                            data.addElement("unit").setText("");
                        }
                        if(orders.getFrequency()!=null){
                            data.addElement("frequency").setText(StringUtil.Iso_GBK(orders.getFrequency()));
                        }else{
                            data.addElement("frequency").setText("");
                        }

                        if(orders.getAdministration()!=null){
                            data.addElement("channel").setText(StringUtil.Iso_GBK(orders.getAdministration()));
                        }else{
                            data.addElement("channel").setText("");
                        }
                        data.addElement("instruction").setText("");
                        data.addElement("unit_id").setText("");
                    }
                }
            }else{
                return getErrorlMsg("病人id不能为空!");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }


    private String getSuccessMsg(String desc){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element head = root.addElement("head");
        head.addElement("result").setText("1");
        head.addElement("desc").setText(desc);
        return doc.asXML();
    }

    private String getErrorlMsg(String desc){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element head = root.addElement("head");
        head.addElement("result").setText("0");
        head.addElement("desc").setText(desc);
        return doc.asXML();
    }
}
