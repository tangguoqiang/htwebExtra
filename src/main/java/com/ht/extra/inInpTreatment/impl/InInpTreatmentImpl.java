package com.ht.extra.inInpTreatment.impl;

import com.haitaiinc.Util;
import com.ht.extra.dao.*;
import com.ht.extra.inInpTreatment.InInpTreatment;
import com.ht.extra.pojo.comm.DeptDict;
import com.ht.extra.pojo.comm.PriceList;
import com.ht.extra.pojo.exam.ExamMaster;
import com.ht.extra.pojo.inpadm.PatsInHospital;
import com.ht.extra.pojo.inpbill.DailyLedger;
import com.ht.extra.pojo.inpbill.InpBillDetail;
import com.ht.extra.pojo.inpbill.InternetPayinfo;
import com.ht.extra.pojo.inpbill.PrepaymentRcpt;
import com.ht.extra.pojo.insurance.BankTradeLog;
import com.ht.extra.pojo.lab.LabResult;
import com.ht.extra.pojo.lab.LabTestItems;
import com.ht.extra.pojo.lab.LabTestItemsKey;
import com.ht.extra.pojo.lab.LabTestMaster;
import com.ht.extra.pojo.medrec.*;
import com.ht.extra.util.DateToWeek;
import com.ht.extra.util.StringUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/13.
 */
public class InInpTreatmentImpl implements InInpTreatment{
    private static Logger logger = Logger.getLogger(InInpTreatmentImpl.class);
    @Resource
    private PatsInHospitalMapper patsInHospitalMapper;
    @Resource
    private PatMasterIndexMapper patMasterIndexMapper;
    @Resource
    private MedicalCostsMapper medicalCostsMapper;
    @Resource
    private DailyLedgerMapper dailyLedgerMapper;
    @Resource
    private InpBillDetailMapper inpBillDetailMapper;
    @Resource
    private ExamMasterMapper examMasterMapper;
    @Resource
    private DeptDictMapper deptDictMapper;
    @Resource
    private LabTestMasterMapper labTestMasterMapper;
    @Resource
    private LabResultMapper labResultMapper;
    @Resource
    private LabTestItemsMapper labTestItemsMapper;
    @Resource
    private PatVisitMapper patVisitMapper;
    @Resource
    private DiagnosisMapper diagnosisMapper;
    @Resource
    private RecpNoMapper recpNoMapper;
    @Resource
    private InternetPayinfoMapper internetPayinfoMapper;
    @Resource
    private PrepaymentRcptMapper prepaymentRcptMapper;
    @Resource
    private  PriceListMapper priceListMapper;
    @Resource
    private  BankTradeLogMapper bankTradeLogMapper;

    @Override
    public String bindZyCard(String xmlStr) {
        logger.info("[查询住院信息列表(queryCheckinInfoList)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String patientNo = root.element("data").element("patient_no").getTextTrim();
            String true_name = root.element("data").element("true_name").getTextTrim();
            PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientNo);
            if(patMasterIndex !=null){
                if(true_name.equals(StringUtil.Iso_GBK(patMasterIndex.getName()))){
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element root1 = doc.addElement("response");
                    Element head = root1.addElement("head");
                    head.addElement("result").setText("1");
                    head.addElement("desc").setText("查询信息成功");
                    Element body = root1.addElement("body");
                    body.addElement("patient_id").setText(StringUtil.Iso_GBK(patMasterIndex.getPatientId()));
                    body.addElement("patient_no").setText(StringUtil.Iso_GBK(patMasterIndex.getPatientId()));
                    body.addElement("id_type").setText("1");
                    if(patMasterIndex.getIdNo()!=null){
                        body.addElement("id_card_no").setText(patMasterIndex.getIdNo());
                    }else{
                        body.addElement("id_card_no").setText("");
                    }
                    if("男".equals(StringUtil.Iso_GBK(patMasterIndex.getSex()))){
                        body.addElement("sex").setText("1");
                    }else{
                        body.addElement("sex").setText("2");
                    }
                    if(patMasterIndex.getDateOfBirth()!=null){
                        body.addElement("birth").setText(DateToWeek.formatDateString(patMasterIndex.getDateOfBirth(),"yyyy-MM-dd"));
                    }else{
                        body.addElement("birth").setText("");
                    }
                    if(patMasterIndex.getPhoneNumberHome()!=null){
                        body.addElement("phone").setText(patMasterIndex.getPhoneNumberHome());
                    }else{
                        body.addElement("phone").setText("");
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("卡号信息与姓名不符");
                }
            }else{
                return getErrorlMsg("未查询到卡号信息");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryCheckinInfoList(String xmlStr) {
        logger.info("[查询住院信息列表(queryCheckinInfoList)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String patientNo = root.element("data").element("patient_no").getTextTrim();
            //List<PatsInHospital> patsInHospitals = patsInHospitalMapper.selectByOutTime(patientNo,beginDate,endDate);
            List<PatVisit> patVisits = patVisitMapper.selectBytimes(patientNo);
            PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientNo);
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element head = root1.addElement("head");
            if(patVisits!=null && patVisits.size()>0){
                Element body = root1.addElement("body");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                for(PatVisit patVisit : patVisits){
                    Element checkinInfo = body.addElement("checkin_info");
                    checkinInfo.addElement("checkin_no").setText(patVisit.getPatientId()+"^"+patVisit.getVisitId());
                    checkinInfo.addElement("patient_no").setText(patVisit.getPatientId());
                    checkinInfo.addElement("true_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                    checkinInfo.addElement("dep_id").setText(patVisit.getDeptAdmissionTo());
                    checkinInfo.addElement("dep_name").setText(StringUtil.Iso_GBK(deptDictMapper.selectByPrimaryKey(patVisit.getDeptAdmissionTo()).getDeptName()));
                    checkinInfo.addElement("bed_no").setText("");
                    checkinInfo.addElement("diagnose").setText(StringUtil.Iso_GBK(diagnosisMapper.selectBykeyDiag(patientNo,patVisit.getVisitId()).getDiagnosisDesc()));
                    checkinInfo.addElement("checkin_date").setText(DateToWeek.formatDateString(patVisit.getAdmissionDateTime(),"yyyy-MM-dd"));
                    if(patVisit.getDischargeDateTime()!=null){
                        checkinInfo.addElement("checkout_date").setText(DateToWeek.formatDateString(patVisit.getDischargeDateTime(),"yyyy-MM-dd"));
                        checkinInfo.addElement("state").setText("1");
                    }else{
                        checkinInfo.addElement("checkout_date").setText("");
                        checkinInfo.addElement("state").setText("0");
                    }
                    if(patVisit.getTotalCosts()!=null){
                        checkinInfo.addElement("fee_total").setText(patVisit.getTotalCosts().toString());
                    }else{
                        checkinInfo.addElement("fee_total").setText("0");
                    }
                    checkinInfo.addElement("depositfee_total").setText("0");
                    checkinInfo.addElement("depositfee_balance").setText("0");
                    checkinInfo.addElement("is_low").setText("0");
                }
            }else {
                head.addElement("result").setText("0");
                head.addElement("desc").setText("未查到相关病人信息详情");
            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }
    @Override
    public String queryCheckinInfo(String xmlStr) {
        logger.info("[查询住院信息详情(queryCheckinInfoList)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkinNo = root.element("data").element("checkin_no").getTextTrim();
            if(!checkinNo.contains("^")){
                return getErrorlMsg("checkin_no格式不正确");
            }
            String patientNo = checkinNo.split("\\^")[0];
            String visitId = checkinNo.split("\\^")[1];
            PatsInHospital patsInHospital = patsInHospitalMapper.selectByPrimaryKey(patientNo);
            PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientNo);
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root1 = doc.addElement("response");
            Element head = root1.addElement("head");
            if(patsInHospital!=null && (patsInHospital.getVisitId().toString()).equals(visitId)){
                Element body = root1.addElement("body");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                    Element checkinInfo = body.addElement("checkin_info");
                    checkinInfo.addElement("checkin_no").setText(patsInHospital.getPatientId()+"^"+patsInHospital.getVisitId());
                    checkinInfo.addElement("patient_no").setText(patsInHospital.getPatientId());
                    checkinInfo.addElement("true_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                    if(patsInHospital.getDeptCode() !=null){
                        checkinInfo.addElement("dep_id").setText(patsInHospital.getDeptCode());
                        checkinInfo.addElement("dep_name").setText(StringUtil.Iso_GBK(patsInHospital.getDeptName()));
                    }else{
                        checkinInfo.addElement("dep_id").setText("");
                        checkinInfo.addElement("dep_name").setText("");
                    }
                    if(patsInHospital.getBedNo() !=null){
                        checkinInfo.addElement("bed_no").setText(patsInHospital.getBedNo().toString());
                    }else{
                        checkinInfo.addElement("bed_no").setText("");
                    }
                    if(patsInHospital.getDiagnosis()!=null){
                        checkinInfo.addElement("diagnose").setText(StringUtil.Iso_GBK(patsInHospital.getDiagnosis()));

                    }else{
                        checkinInfo.addElement("diagnose").setText("");
                    }
                    if(patsInHospital.getAdmissionDateTime()!=null){
                        checkinInfo.addElement("checkin_date").setText(DateToWeek.formatDateString(patsInHospital.getAdmissionDateTime(),"yyyy-MM-dd"));
                    }else{
                        checkinInfo.addElement("checkin_date").setText("");
                    }
                    if(patsInHospital.getOutDate()!=null){
                        checkinInfo.addElement("checkout_date").setText(DateToWeek.formatDateString(patsInHospital.getOutDate(),"yyyy-MM-dd"));
                        checkinInfo.addElement("state").setText("1");
                    }else{
                        checkinInfo.addElement("checkout_date").setText("");
                        checkinInfo.addElement("state").setText("0");
                    }
                    if(patsInHospital.getTotalCosts() !=null){
                        checkinInfo.addElement("fee_total").setText(patsInHospital.getTotalCosts().toString());
                    }else{
                        checkinInfo.addElement("fee_total").setText("");
                    }
                    if(patsInHospital.getPrepayments()!=null){
                        checkinInfo.addElement("depositfee_total").setText(patsInHospital.getPrepayments().toString());
                    }else{
                        checkinInfo.addElement("depositfee_total").setText("");
                    }
                    if(patsInHospital.getTotalCosts() !=null && patsInHospital.getPrepayments()!=null){
                        checkinInfo.addElement("depositfee_balance").setText(patsInHospital.getPrepayments().subtract(patsInHospital.getTotalCosts()).toString());
                    }else{
                        checkinInfo.addElement("depositfee_balance").setText("");
                    }
                    checkinInfo.addElement("is_low").setText("0");
            }else {
                PatVisitKey patVisitKey = new PatVisitKey();
                patVisitKey.setPatientId(patientNo);
                patVisitKey.setVisitId(Short.parseShort(visitId));
                PatVisit patVisit = patVisitMapper.selectByPrimaryKey(patVisitKey);
                if(patVisit!=null){
                    Element body = root1.addElement("body");
                    head.addElement("result").setText("1");
                    head.addElement("desc").setText("查询信息成功");
                    Element checkinInfo = body.addElement("checkin_info");
                    checkinInfo.addElement("checkin_no").setText(patVisit.getPatientId()+"^"+patVisit.getVisitId());
                    checkinInfo.addElement("patient_no").setText(patVisit.getPatientId());
                    checkinInfo.addElement("true_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                    checkinInfo.addElement("dep_id").setText(patVisit.getDeptAdmissionTo());
                    checkinInfo.addElement("dep_name").setText(StringUtil.Iso_GBK(deptDictMapper.selectByPrimaryKey(patVisit.getDeptAdmissionTo()).getDeptName()));
                    checkinInfo.addElement("bed_no").setText("");
                    checkinInfo.addElement("diagnose").setText(StringUtil.Iso_GBK(diagnosisMapper.selectBykeyDiag(patientNo,patVisit.getVisitId()).getDiagnosisDesc()));
                    checkinInfo.addElement("checkin_date").setText(DateToWeek.formatDateString(patVisit.getAdmissionDateTime(),"yyyy-MM-dd"));
                    if(patVisit.getDischargeDateTime()!=null){
                        checkinInfo.addElement("checkout_date").setText(DateToWeek.formatDateString(patVisit.getDischargeDateTime(),"yyyy-MM-dd"));
                        checkinInfo.addElement("state").setText("1");
                    }else{
                        checkinInfo.addElement("checkout_date").setText("");
                        checkinInfo.addElement("state").setText("0");
                    }
                    checkinInfo.addElement("fee_total").setText(patVisit.getTotalCosts().toString());
                    checkinInfo.addElement("depositfee_total").setText("0");
                    checkinInfo.addElement("depositfee_balance").setText("0");
                    checkinInfo.addElement("is_low").setText("0");
                }else{
                    head.addElement("result").setText("0");
                    head.addElement("desc").setText("未查到相关病人信息详情");
                }

            }
            return doc.asXML();
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    /**
     * 根据patientId 查询住院患者信息接口
     * @param xmlStr
     * @return
     */
    @Override
    public String getInPatientInfo(String xmlStr){
        logger.info("[查询住院患者信息 入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String patientId = root.element("data").element("patientId").getTextTrim();
            if(patientId!=null && patientId.length()>0){
                PatVisit patVisit =patVisitMapper.selectByPatientId(patientId);
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patientId);
                if(patVisit!=null){
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element root1 = doc.addElement("response");
                    Element head = root1.addElement("head");
                    Element body = root1.addElement("body");
                    head.addElement("result").setText("1");
                    head.addElement("desc").setText("查询信息成功");
                    PatsInHospital patsInHospital = patsInHospitalMapper.selectByPrimaryKey(patVisit.getPatientId());
                    if(patsInHospital!=null && (patsInHospital.getVisitId().toString()).equals(patVisit.getVisitId().toString())){
                        Element checkinInfo = body.addElement("checkin_info");
                        checkinInfo.addElement("checkin_no").setText(patsInHospital.getPatientId()+"^"+patsInHospital.getVisitId());
                        checkinInfo.addElement("patient_no").setText(patsInHospital.getPatientId());
                        if(patMasterIndex.getIdNo()!=null && patMasterIndex.getIdNo().length()>0){
                            checkinInfo.addElement("id_no").setText(patMasterIndex.getIdNo());
                        }else{
                            checkinInfo.addElement("id_no").setText("");
                        }

                        checkinInfo.addElement("true_name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                        DeptDict deptDict = deptDictMapper.selectByPrimaryKey(patsInHospital.getDeptCode());
                        if(patsInHospital.getDeptCode() !=null){
                            checkinInfo.addElement("dep_id").setText(patsInHospital.getDeptCode());
                            checkinInfo.addElement("dep_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                        }else{
                            checkinInfo.addElement("dep_id").setText("");
                            checkinInfo.addElement("dep_name").setText("");
                        }
                        deptDict = deptDictMapper.selectByPrimaryKey(patsInHospital.getWardCode());
                        if(patsInHospital.getWardCode() !=null){
                            checkinInfo.addElement("ward_id").setText(patsInHospital.getWardCode());
                            checkinInfo.addElement("ward_name").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                        }else {
                            checkinInfo.addElement("ward_id").setText("");
                            checkinInfo.addElement("ward_name").setText("");
                        }
                        if(patsInHospital.getBedNo() !=null){
                            checkinInfo.addElement("bed_no").setText(patsInHospital.getBedNo().toString());
                        }else{
                            checkinInfo.addElement("bed_no").setText("");
                        }
                        if(patsInHospital.getDiagnosis()!=null){
                            checkinInfo.addElement("diagnose").setText(StringUtil.Iso_GBK(patsInHospital.getDiagnosis()));

                        }else{
                            checkinInfo.addElement("diagnose").setText("");
                        }
                        if(patsInHospital.getAdmissionDateTime()!=null){
                            checkinInfo.addElement("checkin_date").setText(DateToWeek.formatDateString(patsInHospital.getAdmissionDateTime(),"yyyy-MM-dd"));
                        }else{
                            checkinInfo.addElement("checkin_date").setText("");
                        }
                        if(patsInHospital.getOutDate()!=null){
                            checkinInfo.addElement("checkout_date").setText(DateToWeek.formatDateString(patsInHospital.getOutDate(),"yyyy-MM-dd"));
                            checkinInfo.addElement("state").setText("1");
                        }else{
                            checkinInfo.addElement("checkout_date").setText("");
                            checkinInfo.addElement("state").setText("0");
                        }
                        if(patsInHospital.getTotalCosts() !=null){
                            checkinInfo.addElement("fee_total").setText(patsInHospital.getTotalCosts().toString());
                        }else{
                            checkinInfo.addElement("fee_total").setText("");
                        }
                        if(patsInHospital.getPrepayments()!=null){
                            checkinInfo.addElement("depositfee_total").setText(patsInHospital.getPrepayments().toString());
                        }else{
                            checkinInfo.addElement("depositfee_total").setText("");
                        }
                        if(patsInHospital.getTotalCosts() !=null && patsInHospital.getPrepayments()!=null){
                            checkinInfo.addElement("depositfee_balance").setText(patsInHospital.getPrepayments().subtract(patsInHospital.getTotalCosts()).toString());
                        }else{
                            checkinInfo.addElement("depositfee_balance").setText("");
                        }
                        checkinInfo.addElement("is_low").setText("0");
                        checkinInfo.addElement("chargeType").setText(StringUtil.Iso_GBK(patMasterIndex.getChargeType())); //费别
                        return doc.asXML();
                    }else{
                        return getErrorlMsg("未查到相关病人信息详情！！！");
                    }
                }else {
                    return getErrorlMsg("未查到相关病人信息详情！！！");
                }
            }else {
                return getErrorlMsg("入参有误！！！");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryDailyLedgerCount(String xmlStr) {
        logger.info("[查询住院费用类别统计(queryDailyLedgerCount)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkinNo = root.element("data").element("checkin_no").getTextTrim();
            if(checkinNo!=null && checkinNo.contains("^")){
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                String patientId = checkinNo.split("\\^")[0];
                String visitId = checkinNo.split("\\^")[1];
                MedicalCostsKey medicalCostsKey = new MedicalCostsKey();
                medicalCostsKey.setPatientId(patientId);
                medicalCostsKey.setVisitId(Short.parseShort(visitId));
                List<MedicalCosts> medicalCostses = medicalCostsMapper.selectByMedical(medicalCostsKey);
                if(medicalCostses !=null){
                    Element body = root1.addElement("body");
                    for(MedicalCosts medicalCosts : medicalCostses){
                        Element fee_info = body.addElement("fee_info");
                        fee_info.addElement("checkin_no").setText(medicalCosts.getPatientId()+"^"+medicalCosts.getVisitId());
                        fee_info.addElement("fee_type").setText(StringUtil.Iso_GBK(medicalCosts.getFeeType()));
                        fee_info.addElement("fee_type_total").setText(medicalCosts.getCosts().toString());
                        fee_info.addElement("fee_total").setText(medicalCosts.getTotcosts().toString());
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("未查询到费用信息");
                }
            }else {
                return getErrorlMsg("checkinNo格式不正确");
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryDailyLedgerList(String xmlStr) {
        logger.info("[查询住院费用类别统计(queryCheckinInfoList)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkinNo = root.element("data").element("checkin_no").getTextTrim();
            String beginDate = root.element("data").element("begin_date").getTextTrim();
            String endDate = root.element("data").element("end_date").getTextTrim();
            Date begDate = DateToWeek.formatDate(beginDate,"yyyy-MM-dd");
            Date endDate1 = DateToWeek.formatDate(endDate,"yyyy-MM-dd");
            if(checkinNo!=null && checkinNo.contains("^")){
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                String patientId = checkinNo.split("\\^")[0];
                String visitId = checkinNo.split("\\^")[1];
                List<DailyLedger> dailyLedgers  = dailyLedgerMapper.selectDailyLedger(patientId,Short.parseShort(visitId),begDate,endDate1);
                if(dailyLedgers !=null){
                    Element body = root1.addElement("body");
                    for(DailyLedger dailyLedger : dailyLedgers){
                        Element fee_info = body.addElement("fee_info");
                        fee_info.addElement("checkin_no").setText(dailyLedger.getPatientId()+"^"+dailyLedger.getVisitId());
                        fee_info.addElement("ledger_id").setText(DateToWeek.formatDateString(dailyLedger.getLedgerDate(),"yyyy-MM-dd"));
                        fee_info.addElement("ledger_date").setText(DateToWeek.formatDateString(dailyLedger.getLedgerDate(),"yyyy-MM-dd"));
                        fee_info.addElement("fee_total").setText(dailyLedger.getCosts().toString());
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("未查询到费用信息");
                }
            }else {
                return getErrorlMsg("checkinNo格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryDailyLedger(String xmlStr) {
        logger.info("[查询住院费用明细(queryDailyLedger)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkinNo = root.element("data").element("checkin_no").getTextTrim();
            String ledger_id = root.element("data").element("ledger_id").getTextTrim();
            if(checkinNo!=null && checkinNo.contains("^")){
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                String patientId = checkinNo.split("\\^")[0];
                String visitId = checkinNo.split("\\^")[1];
                List<InpBillDetail> inpBillDetails = inpBillDetailMapper.selectBillingDate(patientId,Short.parseShort(visitId),DateToWeek.formatDate(ledger_id,"yyyy-MM-dd"));
                if(inpBillDetails!=null){
                    Element body = root1.addElement("body");
                    for(InpBillDetail inpBillDetail: inpBillDetails) {
                        Element feedetailInfo = body.addElement("feedetail_info");
                        feedetailInfo.addElement("checkin_no").setText(inpBillDetail.getPatientId() + "^" + inpBillDetail.getVisitId());
                        feedetailInfo.addElement("ledger_id").setText(ledger_id);
                        feedetailInfo.addElement("ledger_date").setText(ledger_id);
                        feedetailInfo.addElement("fee_item").setText(StringUtil.Iso_GBK(inpBillDetail.getItemName()));
                        feedetailInfo.addElement("item_time").setText(DateToWeek.formatDateString(inpBillDetail.getBillingDateTime(), "yyyy-MM-dd HH:mm:ss"));
                        feedetailInfo.addElement("fee_time").setText(DateToWeek.formatDateString(inpBillDetail.getBillingDateTime(), "yyyy-MM-dd HH:mm:ss"));
                        feedetailInfo.addElement("fee_total").setText(inpBillDetail.getCosts().toString());
                        feedetailInfo.addElement("amount").setText(inpBillDetail.getAmount()+"");
                        feedetailInfo.addElement("units").setText(StringUtil.Iso_GBK(inpBillDetail.getUnits()));
                        feedetailInfo.addElement("itemCode").setText(inpBillDetail.getItemCode());
                        feedetailInfo.addElement("itemSpec").setText(StringUtil.Iso_GBK(inpBillDetail.getItemSpec()));
                        PriceList priceList = priceListMapper.selectPriceListForAdministration(inpBillDetail.getItemClass(),inpBillDetail.getItemCode(),inpBillDetail.getItemSpec(),inpBillDetail.getUnits());
                        if(priceList!=null){
                            feedetailInfo.addElement("price").setText(priceList.getPrice()+"");
                        }else {
                            feedetailInfo.addElement("price").setText("");
                        }

                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("未查询到费用明细");
                }
            }else {
                return getErrorlMsg("checkinNo格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    @Transactional
    public String payDepositFee(String xmlStr) {
        logger.info("[缴纳住院押金(queryDailyLedger)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkinNo = root.element("data").element("checkin_no").getTextTrim();
            String patientNo = root.element("data").element("patient_no").getTextTrim();
            //支付方式
            String payMethod = root.element("data").element("pay_method").getTextTrim();
            //支付流水号
            String tradeNo = root.element("data").element("trade_no").getTextTrim();
            //支付金额
            String payAmt = root.element("data").element("pay_amt").getTextTrim();
            //
            String mchId = root.element("data").element("mch_id").getTextTrim();
            if(checkinNo!=null && checkinNo.contains("^")){
                String visitId = checkinNo.split("\\^")[1];
                String recpNo = "I"+recpNoMapper.selectRecpNo().getRecpNo();
                PatsInHospital patsInHospital = patsInHospitalMapper.selectByPrimaryKey(patientNo);
                BigDecimal payNum = new BigDecimal(payAmt);


                PrepaymentRcpt prepaymentRcpt = new PrepaymentRcpt();
                prepaymentRcpt.setPatientId(patientNo);
                prepaymentRcpt.setVisitId(Short.parseShort(visitId));
                prepaymentRcpt.setAmount(payNum);
                prepaymentRcpt.setPayWay(StringUtil.Utf_Iso("线上支付"));
                prepaymentRcpt.setTransactType(StringUtil.Utf_Iso("交款"));
                prepaymentRcpt.setTransactDate(new Timestamp(new Date().getTime()));
                prepaymentRcpt.setOperatorNo("s160");
                prepaymentRcpt.setOutpOrInp("1");
                prepaymentRcpt.setRcptNo(recpNo);

                InternetPayinfo internetPayinfo = new InternetPayinfo();
                internetPayinfo.setPatientId(patientNo);
                internetPayinfo.setChangeDateTime(new Timestamp(new Date().getTime()));
                internetPayinfo.setInoutFlag("I");
                internetPayinfo.setRecptNo(recpNo);
                internetPayinfo.setTradeNo(tradeNo);
                internetPayinfo.setPayMethod(StringUtil.Utf_Iso(payMethod));
                internetPayinfo.setMchId(mchId);
                Document doc = DocumentHelper.createDocument();
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("缴费成功！");
                Element body = root1.addElement("body");
                body.addElement("receipt_no").setText(recpNo);
                internetPayinfoMapper.insert(internetPayinfo);
                prepaymentRcptMapper.insert(prepaymentRcpt);
                if(patsInHospital.getPrepayments()!=null){
                    patsInHospital.setPrepayments(payNum.add(patsInHospital.getPrepayments()));
                }else{
                    patsInHospital.setPrepayments(payNum);
                }
                patsInHospitalMapper.updateByPrimaryKey(patsInHospital);
                return doc.asXML();
            }else {
                return getErrorlMsg("checkinNo格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    @Override
    @Transactional
    public String payDepositHospitalFee(String xmlStr) {
        logger.info("[缴纳住院押金(payDepositHospitalFee)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkinNo = root.element("data").element("checkin_no").getTextTrim();
            String patientNo = root.element("data").element("patient_no").getTextTrim();
            //支付方式
            String payMethod = root.element("data").element("pay_method").getTextTrim();
            //支付流水号
            String tradeNo = root.element("data").element("trade_no").getTextTrim();
            //支付金额
            String payAmt = root.element("data").element("pay_amt").getTextTrim();
            //
            String mchId = root.element("data").element("mch_id").getTextTrim();
            String sourceType = root.element("data").element("sourceType").getTextTrim(); //来源 ZZJ

            //银联支付
            String yhkh = root.element("data").element("yhkh").getTextTrim(); // 银行卡号
            String pzh = root.element("data").element("pzh").getTextTrim();// 凭证号
            String ckh = root.element("data").element("ckh").getTextTrim();//  参考号
            String je = root.element("data").element("je").getTextTrim();  //  金额 （元）
            String zdh = root.element("data").element("zdh").getTextTrim();//  终端号
            String pch = root.element("data").element("pch").getTextTrim();//  批次号
            String jysj = root.element("data").element("jysj").getTextTrim();//  日期
            String shh = root.element("data").element("shh").getTextTrim();// 商务编号
            String czy = root.element("data").element("czy").getTextTrim();// 操作员

            if(checkinNo!=null && checkinNo.contains("^")){
                String visitId = checkinNo.split("\\^")[1];
                String recpNo = "I"+recpNoMapper.selectRecpNo().getRecpNo();
                PatsInHospital patsInHospital = patsInHospitalMapper.selectByPrimaryKey(patientNo);
                BigDecimal payNum = new BigDecimal(payAmt);

                String moneyType = "";
                if (payMethod != null && payMethod.length() > 0) {
                    if ("5".equals(payMethod)) {
                        moneyType = "自助阿里";
                    } else if ("6".equals(payMethod)) {
                        moneyType = "自助微信";
                    } else if ("9".equals(payMethod)) {
                        moneyType = "自助银联";
                    }
                }
                PrepaymentRcpt prepaymentRcpt = new PrepaymentRcpt();
                prepaymentRcpt.setPatientId(patientNo);
                prepaymentRcpt.setVisitId(Short.parseShort(visitId));
                prepaymentRcpt.setAmount(payNum);
                prepaymentRcpt.setPayWay(StringUtil.Utf_Iso(moneyType));
                prepaymentRcpt.setTransactType(StringUtil.Utf_Iso("交款"));
                prepaymentRcpt.setTransactDate(new Timestamp(new Date().getTime()));
                prepaymentRcpt.setOperatorNo(sourceType);
                prepaymentRcpt.setOutpOrInp("1");
                prepaymentRcpt.setRcptNo(recpNo);

                InternetPayinfo internetPayinfo = new InternetPayinfo();
                internetPayinfo.setPatientId(patientNo);
                internetPayinfo.setChangeDateTime(new Timestamp(new Date().getTime()));
                internetPayinfo.setInoutFlag("I");
                internetPayinfo.setRecptNo(recpNo);
                internetPayinfo.setTradeNo(tradeNo);
                internetPayinfo.setPayMethod(StringUtil.Utf_Iso(moneyType));
                internetPayinfo.setMchId(mchId);

                internetPayinfoMapper.insert(internetPayinfo);
                prepaymentRcptMapper.insert(prepaymentRcpt);
                if(patsInHospital.getPrepayments()!=null){
                    patsInHospital.setPrepayments(payNum.add(patsInHospital.getPrepayments()));
                }else{
                    patsInHospital.setPrepayments(payNum);
                }
                patsInHospitalMapper.updateByPrimaryKey(patsInHospital);
                // 7. 银联支付
                if ("9".equals(payMethod)) {
                    BankTradeLog bankTradeLog = new BankTradeLog();
                    bankTradeLog.setType(StringUtil.Utf_Iso("住院收费"));
                    bankTradeLog.setRcptNo(recpNo);
                    bankTradeLog.setTraDate(Util.getCurrentDate("yyyyMMdd"));
                    bankTradeLog.setTradeId(recpNo);
                    bankTradeLog.setTempRcptNo(recpNo);
                    bankTradeLog.setPatientId(patientNo);
                    bankTradeLog.setBankCard(yhkh);
                    bankTradeLog.setTraNo(pzh);
                    bankTradeLog.setTraFinalNo(zdh);
                    bankTradeLog.setTraTotal(new BigDecimal(je));
                    bankTradeLog.setTraStatus(1+"");
                    bankTradeLog.setTraPcNo(pch);
                    bankTradeLog.setTraTime(Util.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
                    bankTradeLog.setMerchantNo(shh);
//                  bankTradeLog.setNote();
//                  bankTradeLog.setTimes();
                    bankTradeLog.setUserId(czy);
                    bankTradeLog.setAcctNo(1+"");
//                  bankTradeLog.setReturnTimes();
//                  bankTradeLog.setReturnMoneyLimit();
//                  bankTradeLog.setReturnType();
                    bankTradeLog.setOprAppNameHis(1+"");
                    bankTradeLog.setAcctFlagHis(new BigDecimal(1));
                    bankTradeLog.setOperTypeHis(StringUtil.Utf_Iso("银行卡"));
                    bankTradeLog.setRcptFlagHis(new BigDecimal(1));
//                  bankTradeLog.setBankNo();
//                  bankTradeLog.setTraAuthNo();
//                  bankTradeLog.setSettleDate();
//                  bankTradeLog.setLrcReturn();
//                  bankTradeLog.setReturnRcptNo();
                    bankTradeLog.setTraReferNo(ckh);

                    bankTradeLogMapper.insertSelective(bankTradeLog);
                }

                Document doc = DocumentHelper.createDocument();
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("缴费成功！");
                Element body = root1.addElement("body");
                body.addElement("receipt_no").setText(recpNo);

                patsInHospital = patsInHospitalMapper.selectByPrimaryKey(patientNo);
                if(patsInHospital.getTotalCosts() !=null && patsInHospital.getPrepayments()!=null){
                    body.addElement("depositfee_balance").setText(patsInHospital.getPrepayments().subtract(patsInHospital.getTotalCosts()).toString());
                }else{
                    body.addElement("depositfee_balance").setText("");
                }
                return doc.asXML();
            }else {
                return getErrorlMsg("checkinNo格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    @Override
    public String queryPayState(String xmlStr) {
        logger.info("[预交金状态查询(queryDailyLedger)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            //支付流水号
            String tradeNo = root.element("data").element("trade_no").getTextTrim();
            if(tradeNo!=null){
                InternetPayinfo internetPayinfo = internetPayinfoMapper.selectByPrimaryKey(tradeNo);
                Document doc = DocumentHelper.createDocument();
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询成功！");
                Element body = root1.addElement("body");
                body.addElement("receipt_no").setText(internetPayinfo.getRecptNo());
                return doc.asXML();
            }else {
                return getErrorlMsg("tradeNo 不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }

    }

    @Override
    public String queryPayment(String xmlStr) {
        logger.info("[预交金查询(queryDailyLedger)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            //支付流水号
            String checkinNo = root.element("data").element("checkin_no").getTextTrim();
            if(checkinNo!=null && checkinNo.contains("^")){
                String patientId = checkinNo.split("\\^")[0];
                String visitId = checkinNo.split("\\^")[1];
                List<PrepaymentRcpt> prepaymentRcptList = prepaymentRcptMapper.selectByPatientVisit(patientId,Short.parseShort(visitId));
                Document doc = DocumentHelper.createDocument();
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询成功！");
                Element body = root1.addElement("body");
                if(prepaymentRcptList!=null && prepaymentRcptList.size()>0){
                    for(PrepaymentRcpt prepaymentRcpt : prepaymentRcptList){
                        if(!(prepaymentRcpt.getAmount().doubleValue()<0)) {
                            Element payInfo = body.addElement("pay_info");
                            payInfo.addElement("pay_time").setText(DateToWeek.formatDateString(prepaymentRcpt.getTransactDate(), "yyyy-MM-dd HH:mm:ss"));
                            payInfo.addElement("channel_id").setText(StringUtil.Iso_GBK(prepaymentRcpt.getPayWay()));
                            payInfo.addElement("pay_method").setText(StringUtil.Iso_GBK(prepaymentRcpt.getPayWay()));
                            payInfo.addElement("pay_amt").setText(prepaymentRcpt.getAmount().toString());
                        }
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("tradeNo 不能为空");
                }
            }else {
                return getErrorlMsg("tradeNo 不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryExamReportList(String xmlStr) {
        logger.info("[查询检查报告列表(queryExamReportList)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String patientId = root.element("data").element("patient_id").getTextTrim();
            if(patientId!=null){
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                List<ExamMaster> examMasters = examMasterMapper.selectExamRepotTwice(patientId);
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientId);
                if(examMasters!=null && examMasters.size()>0){
                    Element body = root1.addElement("body");
                    for(ExamMaster examMaster : examMasters){
                        Element examList = body.addElement("exam_list");
                        examList.addElement("checkNo").setText(patientId+"^"+examMaster.getExamNo());
                        examList.addElement("clinicHospNo").setText(examMaster.getPatientId());
                        examList.addElement("regtype").setText("2");
                        examList.addElement("hospTimes").setText("");
                        examList.addElement("hisPatientId").setText(examMaster.getPatientId());
                        examList.addElement("patientName").setText(StringUtil.Iso_GBK(examMaster.getName()));
                        if ("男".equals(StringUtil.Iso_GBK(examMaster.getSex()))) {
                            examList.addElement("sex").setText("1");
                        } else {
                            examList.addElement("sex").setText("2");
                        }
                        if(patMasterIndex.getDateOfBirth()!=null){
                            int age =(new Date().getYear() - patMasterIndex.getDateOfBirth().getYear());
                            examList.addElement("age").setText(age+"");
                        }else{
                            examList.addElement("age").setText("0");
                        }
                        examList.addElement("checkTypeCode").setText(StringUtil.Iso_GBK(examMaster.getExamClass()));
                        examList.addElement("checkType").setText(StringUtil.Iso_GBK(examMaster.getExamClass()));
                        examList.addElement("lczd").setText(StringUtil.Iso_GBK(examMaster.getClinDiag()));
                        examList.addElement("deptNo").setText(StringUtil.Iso_GBK(examMaster.getPerformedBy()));
                        examList.addElement("deptName").setText(StringUtil.Iso_GBK(deptDictMapper.selectByPrimaryKey(examMaster.getPerformedBy()).getDeptName()));
                        examList.addElement("checkItemCode").setText("");
                        examList.addElement("checkItemName").setText(StringUtil.Iso_GBK(examMaster.getExamSubClass()));
                        examList.addElement("checkArea").setText(StringUtil.Iso_GBK(examMaster.getExamSubClass()));
                        examList.addElement("checkFinding").setText(StringUtil.Iso_GBK(examMaster.getDescription()));
                        examList.addElement("examResult").setText(StringUtil.Iso_GBK(examMaster.getImpression()));
                        examList.addElement("imageCode").setText("");
                        examList.addElement("imageUrl").setText("");
                        examList.addElement("createDate").setText("");
                        examList.addElement("checkDate").setText(Util.escapeInnerText(Util.format(examMaster.getExamDateTime(),"yyyy-MM-dd HH:mm:ss")));
                        examList.addElement("reportDate").setText(Util.escapeInnerText(Util.format(examMaster.getReportDateTime(),"yyyy-MM-dd HH:mm:ss")));
                        examList.addElement("docName").setText(StringUtil.Iso_GBK(examMaster.getReporter()));
                        examList.addElement("checkAdvice").setText("");
                        examList.addElement("isSunNme").setText("");
                        examList.addElement("unitId").setText("");
                        examList.addElement("devModel").setText("");
                        examList.addElement("devModelNo").setText("");
                        if (patMasterIndex.getIdNo() != null) {
                            examList.addElement("card_id").setText(StringUtil.Iso_GBK(patMasterIndex.getIdNo()));
                        } else {
                            examList.addElement("card_id").setText("");
                        }
                        if (patMasterIndex.getIdentity() != null) {
                            examList.addElement("cardType").setText(StringUtil.Iso_GBK(patMasterIndex.getIdentity()));
                        } else {
                            examList.addElement("cardType").setText("");
                        }
                        if (patMasterIndex.getPhoneNumberHome() != null) {
                            examList.addElement("phone").setText(StringUtil.Iso_GBK(patMasterIndex.getPhoneNumberHome()));
                        } else {
                            examList.addElement("phone").setText("");
                        }
                        examList.addElement("attachment").setText("");
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("未查询到检查数据");
                }
            }else {
                return getErrorlMsg("patient_id不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryExamReport(String xmlStr) {
        logger.info("[查询检查明细(queryExamReport)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkNo = root.element("data").element("checkNo").getTextTrim();
            String patientId;
            String examNo;
            if(checkNo.contains("^")){
                patientId = checkNo.split("\\^")[0];
                examNo = checkNo.split("\\^")[1];
            }else{
                return getErrorlMsg("checkNo的格式不正确");
            }
            if(patientId!=null){
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                List<ExamMaster> examMasters = examMasterMapper.selectExamRepotTwice(patientId);
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientId);
                if(examMasters!=null && examMasters.size()>0){
                    Element body = root1.addElement("body");
                    for(ExamMaster examMaster : examMasters) {
                        Element examList = body.addElement("exam_list");
                        if (examNo.equals(examMaster.getExamNo())) {

                            examList.addElement("checkNo").setText(examMaster.getExamNo());
                            examList.addElement("clinicHospNo").setText(examMaster.getPatientId());
                            examList.addElement("regtype").setText("2");
                            examList.addElement("hospTimes").setText("");
                            examList.addElement("hisPatientId").setText(examMaster.getPatientId());
                            examList.addElement("patientName").setText(StringUtil.Iso_GBK(examMaster.getName()));
                            if ("男".equals(StringUtil.Iso_GBK(examMaster.getSex()))) {
                                examList.addElement("sex").setText("1");
                            } else {
                                examList.addElement("sex").setText("2");
                            }
                            if(patMasterIndex.getDateOfBirth()!=null){
                                int age =(new Date().getYear() - patMasterIndex.getDateOfBirth().getYear());
                                examList.addElement("age").setText(age+"");
                            }else{
                                examList.addElement("age").setText("0");
                            }
                            examList.addElement("checkTypeCode").setText(StringUtil.Iso_GBK(examMaster.getExamClass()));
                            examList.addElement("checkType").setText(StringUtil.Iso_GBK(examMaster.getExamClass()));
                            examList.addElement("lczd").setText(StringUtil.Iso_GBK(examMaster.getClinDiag()));
                            examList.addElement("deptNo").setText(StringUtil.Iso_GBK(examMaster.getPerformedBy()));
                            examList.addElement("deptName").setText(StringUtil.Iso_GBK(deptDictMapper.selectByPrimaryKey(examMaster.getPerformedBy()).getDeptName()));
                            examList.addElement("checkItemCode").setText("");
                            examList.addElement("checkItemName").setText(StringUtil.Iso_GBK(examMaster.getExamSubClass()));
                            examList.addElement("checkArea").setText(StringUtil.Iso_GBK(examMaster.getExamSubClass()));
                            examList.addElement("checkFinding").setText(StringUtil.Iso_GBK(examMaster.getDescription()));
                            examList.addElement("examResult").setText(StringUtil.Iso_GBK(examMaster.getImpression()));
                            examList.addElement("imageCode").setText("");
                            examList.addElement("imageUrl").setText("");
                            examList.addElement("createDate").setText("");
                            examList.addElement("checkDate").setText(Util.escapeInnerText(Util.format(examMaster.getExamDateTime(),"yyyy-MM-dd HH:mm:ss")));
                            examList.addElement("reportDate").setText(Util.escapeInnerText(Util.format(examMaster.getReportDateTime(),"yyyy-MM-dd HH:mm:ss")));
                            examList.addElement("docName").setText(StringUtil.Iso_GBK(examMaster.getReporter()));
                            examList.addElement("checkAdvice").setText("");
                            examList.addElement("isSunNme").setText("");
                            examList.addElement("unitId").setText("");
                            examList.addElement("devModel").setText("");
                            examList.addElement("devModelNo").setText("");
                            examList.addElement("report_doctor_name").setText(StringUtil.Iso_GBK(examMaster.getReporter()));
                            examList.addElement("check_doctor_name").setText(StringUtil.Iso_GBK(examMaster.getTechnician()));
                            examList.addElement("apply_doctor_name").setText(StringUtil.Iso_GBK(examMaster.getReqPhysician()));
                            if (patMasterIndex.getIdNo() != null) {
                                examList.addElement("card_id").setText(StringUtil.Iso_GBK(patMasterIndex.getIdNo()));
                            } else {
                                examList.addElement("card_id").setText("");
                            }
                            if (patMasterIndex.getIdentity() != null) {
                                examList.addElement("cardType").setText(StringUtil.Iso_GBK(patMasterIndex.getIdentity()));
                            } else {
                                examList.addElement("cardType").setText("");
                            }
                            if (patMasterIndex.getPhoneNumberHome() != null) {
                                examList.addElement("phone").setText(StringUtil.Iso_GBK(patMasterIndex.getPhoneNumberHome()));
                            } else {
                                examList.addElement("phone").setText("");
                            }
                            examList.addElement("attachment").setText("");
                        }
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("未查询到检查数据");
                }
            }else {
                return getErrorlMsg("patient_id不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryLabReprotList(String xmlStr) {
        logger.info("[查询检查报告列表(queryExamReportList)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String patientId = root.element("data").element("patient_id").getTextTrim();
            if(patientId!=null){
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                List<LabTestMaster> labTestMasters = labTestMasterMapper.selectByPatient(patientId);
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientId);
                if(labTestMasters!=null && labTestMasters.size()>0){
                    Element body = root1.addElement("body");
                    for(LabTestMaster labMaster:labTestMasters){
                        Element lab = body.addElement("lab_list");
                        LabTestItemsKey labTestItemKey = new LabTestItemsKey();
                        labTestItemKey.setTestNo(labMaster.getTestNo());
                        labTestItemKey.setItemNo((short)1);
                        LabTestItems labTestItem = labTestItemsMapper.selectByPrimaryKey(labTestItemKey);
                        lab.addElement("testId").setText(patientId+"^"+labMaster.getTestNo());
                        lab.addElement("clinicHospNo").setText(labMaster.getPatientId());
                        lab.addElement("hospTimes").setText("0");
                        lab.addElement("hisPatientId").setText(labMaster.getPatientId());
                        lab.addElement("patientName").setText(StringUtil.Iso_GBK(labMaster.getName()));
                        if(labTestItem!=null){
                            lab.addElement("testCode").setText(labTestItem.getItemCode());
                            lab.addElement("testName").setText(StringUtil.Iso_GBK(labTestItem.getItemName()));
                        }else{
                            lab.addElement("testCode").setText("");
                            lab.addElement("testName").setText(StringUtil.Iso_GBK(labMaster.getSubject()));
                        }
                        if ("男".equals(StringUtil.Iso_GBK(labMaster.getSex()))) {
                            lab.addElement("sex").setText("1");
                        } else {
                            lab.addElement("sex").setText("2");
                        }
                        if(patMasterIndex.getDateOfBirth()!=null){
                            int age =(new Date().getYear() - patMasterIndex.getDateOfBirth().getYear());
                            lab.addElement("age").setText(age+"");
                        }else{
                            lab.addElement("age").setText("0");
                        }
                        lab.addElement("sendDate").setText(Util.escapeInnerText(Util.format(labMaster.getRequestedDateTime(),"yyyy-MM-dd HH:mm:ss")));
                        if(labMaster.getOrderingDept() !=null){
                            lab.addElement("deptNo").setText(labMaster.getOrderingDept());
                            String deptName = StringUtil.Iso_GBK(deptDictMapper.selectByPrimaryKey(labMaster.getOrderingDept()).getDeptName());
                            if(deptName!=null && deptName.length()>0){
                                if(deptName.contains("军队")){
                                    lab.addElement("deptName").setText(deptName.replaceAll("军队"," "));
                                }else{
                                    lab.addElement("deptName").setText(StringUtil.Iso_GBK(deptDictMapper.selectByPrimaryKey(labMaster.getOrderingDept()).getDeptName()));
                                }
                            }else{
                                lab.addElement("deptName").setText("");
                            }
//                          lab.addElement("deptName").setText(StringUtil.Iso_GBK(deptDictMapper.selectByPrimaryKey(labMaster.getOrderingDept()).getDeptName()));
                        }else{
                            lab.addElement("deptNo").setText("");
                            lab.addElement("deptName").setText("");
                        }
                        lab.addElement("regtype").setText("1");
                        lab.addElement("unitId").setText("");

                        if (patMasterIndex.getIdNo() != null) {
                            lab.addElement("card_id").setText(StringUtil.Iso_GBK(patMasterIndex.getIdNo()));
                        } else {
                            lab.addElement("card_id").setText("");
                        }
                        if (patMasterIndex.getIdentity() != null) {
                            lab.addElement("cardType").setText(StringUtil.Iso_GBK(patMasterIndex.getIdentity()));
                        } else {
                            lab.addElement("cardType").setText("");
                        }
                        if (patMasterIndex.getPhoneNumberHome() != null) {
                            lab.addElement("phone").setText(StringUtil.Iso_GBK(patMasterIndex.getPhoneNumberHome()));
                        } else {
                            lab.addElement("phone").setText("");
                        }
                        lab.addElement("attachment").setText("");
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("未查询到检验数据");
                }
            }else {
                return getErrorlMsg("patient_id不能为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryLabResult(String xmlStr) {
        logger.info("[查询检查明细(queryExamReport)  入参 :]"+xmlStr);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            Element root = document.getRootElement();
            String checkNo = root.element("data").element("checkNo").getTextTrim();
            String patientId;
            String testNo;
            if(checkNo.contains("^")){
                patientId = checkNo.split("\\^")[0];
                testNo = checkNo.split("\\^")[1];
            }else{
                return getErrorlMsg("checkNo的格式不正确");
            }
            if(patientId!=null){
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root1 = doc.addElement("response");
                Element head = root1.addElement("head");
                head.addElement("result").setText("1");
                head.addElement("desc").setText("查询信息成功");
                LabTestMaster labMaster = labTestMasterMapper.selectByPrimaryKey(testNo);
                List<LabResult> labResults = labResultMapper.selectByTestNo(testNo);
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientId);
                if(labResults!=null && labResults.size()>0){
                    Element body = root1.addElement("body");
                    for (LabResult labResult:labResults){
                        Element list= body.addElement("lab_list");
                        list.addElement("resultId").setText(checkNo+labResult.getTestNo()+labResult.getItemNo()+labResult.getPrintOrder());
                        list.addElement("testId").setText(checkNo);
                        list.addElement("diagnose").setText(StringUtil.Iso_GBK(labMaster.getRelevantClinicDiag()));
                        list.addElement("resultDate").setText(Util.escapeInnerText(Util.format(labResult.getResultDateTime(),"yyyy-MM-dd HH:mm:ss")));
                        list.addElement("testCode").setText("");
                        list.addElement("testName ").setText(StringUtil.Iso_GBK(labMaster.getSubject()));
                        list.addElement("itemCode").setText(labResult.getReportItemCode());
                        list.addElement("itemName").setText(StringUtil.Iso_GBK(labResult.getReportItemName()));
                        list.addElement("itemResult").setText(StringUtil.Iso_GBK(labResult.getResult()));
                        if(labResult.getAbnormalIndicator()!=null){
                            list.addElement("alertCode").setText(labResult.getAbnormalIndicator());
                        }else{
                            list.addElement("alertCode").setText("");
                        }
                        list.addElement("report_doctor_name").setText(StringUtil.Iso_GBK(labMaster.getVerifiedBy()));
                        list.addElement("check_doctor_name").setText(StringUtil.Iso_GBK(labMaster.getTranscriptionist()));
                        list.addElement("apply_doctor_name").setText(StringUtil.Iso_GBK(labMaster.getOrderingProvider()));
                        list.addElement("patientName").setText(StringUtil.Iso_GBK(labMaster.getName()));
                        if ("男".equals(StringUtil.Iso_GBK(labMaster.getSex()))) {
                            list.addElement("sex").setText("1");
                        } else {
                            list.addElement("sex").setText("2");
                        }
                        if(labMaster.getAge()!=null){
                            list.addElement("age").setText(labMaster.getAge().toString());
                        }else{
                            list.addElement("age").setText("0");
                        }
                        if("L".equals(labResult.getAbnormalIndicator())){
                            list.addElement("alertName").setText("低");
                        }else if("H".equals(labResult.getAbnormalIndicator())){
                            list.addElement("alertName").setText("高");
                        }else{
                            list.addElement("alertName").setText("正常");
                        }
                        list.addElement("refer").setText(StringUtil.Iso_GBK(labResult.getPrintContext()));
                        list.addElement("units").setText(StringUtil.Iso_GBK(labResult.getUnits()));
                        list.addElement("unitId").setText("");

                        if (patMasterIndex.getIdNo() != null) {
                            list.addElement("card_id").setText(StringUtil.Iso_GBK(patMasterIndex.getIdNo()));
                        } else {
                            list.addElement("card_id").setText("");
                        }
                        if (patMasterIndex.getIdentity() != null) {
                            list.addElement("cardType").setText(StringUtil.Iso_GBK(patMasterIndex.getIdentity()));
                        } else {
                            list.addElement("cardType").setText("");
                        }
                        if (patMasterIndex.getPhoneNumberHome() != null) {
                            list.addElement("phone").setText(StringUtil.Iso_GBK(patMasterIndex.getPhoneNumberHome()));
                        } else {
                            list.addElement("phone").setText("");
                        }
                        if(labMaster.getVisitId()!=null){
                            list.addElement("regType").setText("2");
                        }else{
                            list.addElement("regType").setText("1");
                        }
                        if(labMaster.getPerformedBy()!=null){
                            DeptDict deptDict = deptDictMapper.selectByPrimaryKey(labMaster.getPerformedBy());
                            if(deptDict!=null){
                                list.addElement("deptName").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                            }else{
                                list.addElement("deptName").setText(StringUtil.Iso_GBK(""));
                            }
                        }else{
                            list.addElement("deptName").setText("");
                        }
                    }
                    return doc.asXML();
                }else{
                    return getErrorlMsg("未查询到检验明细数据");
                }
            }else {
                return getErrorlMsg("patient_id不能为空");
            }
        } catch (Exception e) {
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

    @Override
    public String toString() {
        if(this!=null){
            return super.toString();
        }else{
            return "";
        }
    }
}
