package com.ht.extra.inTreatment.impl;

import com.haitaiinc.Util;
import com.ht.extra.dao.*;
import com.ht.extra.inTreatment.InTreatment;
import com.ht.extra.pojo.RecordNo;
import com.ht.extra.pojo.RecpNo;
import com.ht.extra.pojo.comm.ClinicItemDict;
import com.ht.extra.pojo.comm.ClinicVsCharge;
import com.ht.extra.pojo.comm.CurrentPriceList;
import com.ht.extra.pojo.comm.PriceList;
import com.ht.extra.pojo.inpbill.InternetPayinfo;
import com.ht.extra.pojo.inpbill.ItemRelation;
import com.ht.extra.pojo.insurance.PatIccardRecNew;
import com.ht.extra.pojo.medrec.PatMasterIndex;
import com.ht.extra.pojo.outpadm.ClinicMaster;
import com.ht.extra.pojo.outpbill.OutpBillItems;
import com.ht.extra.pojo.outpbill.OutpOrderDesc;
import com.ht.extra.pojo.outpbill.OutpPaymentsMoney;
import com.ht.extra.pojo.outpbill.OutpRcptMaster;
import com.ht.extra.pojo.outpdoct.OutpOrdersCosts;
import com.ht.extra.pojo.outpdoct.OutpOrdersT;
import com.ht.extra.pojo.pharmacy.DrugPrescDetailTemp;
import com.ht.extra.util.DateToWeek;
import com.ht.extra.util.PinyinTool;
import com.ht.extra.util.StringUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 2016/12/14 0014.
 */
public class InTreatmentImpl implements InTreatment {
    private static Logger logger = Logger.getLogger(InTreatment.class);
    @Resource
    public PatMasterIndexMapper patMasterIndexMapper;
    @Resource
    public ClinicMasterMapper clinicMasterMapper;
    @Resource
    public ClinicForRegistMapper clinicForRegistMapper;
    @Resource
    public OutpOrdersTMapper outpOrdersTMapper;
    @Resource
    public OutpOrdersCostsMapper outpOrdersCostsMapper;
    @Resource
    public OutpRcptMasterMapper outpRcptMasterMapper;
    @Resource
    public OutpPaymentsMoneyMapper outpPaymentsMoneyMapper;
    @Resource
    public OutpOrderDescMapper outpOrderDescMapper;
    @Resource
    public OutpBillItemsMapper outpBillItemsMapper;
    @Resource
    public InternetPayinfoMapper internetPayinfoMapper;
    @Resource
    private DeptDictMapper deptDictMapper;
    @Resource
    private  RecpNoMapper recpNoMapper;
    @Resource
    private  RecordNoMapper recordNoMapper;
    @Resource
    private PriceListMapper priceListMapper;
    @Resource
    private PatIccardRecNewMapper patIccardRecNewMapper;
    @Resource
    private ClinicItemDictMapper clinicItemDictMapper ;
    @Resource
    private CurrentPriceListMapper currentPriceListMapper  ;
    @Resource
    private ClinicVsChargeMapper clinicVsChargeMapper;
    @Resource
    private ItemRelationMapper itemRelationMapper;
    @Resource
    private DrugPrescDetailTempMapper drugPrescDetailTempMapper;
    @Resource
    private WebServiceContext wsContext;


    @Override
    @Transactional
    public String requestWS(String xmlStr) {
        logger.info("[诊中 入参XML：]"+xmlStr);
        String result="";
        logger.info(" ----&gt; 获取客户端信息开始 &lt;---- ");
        String clientIP = getClientInfo();
        logger.info(" ----&gt; 获取客户端信息结束 &lt;---- ");
        logger.info("客户端IP地址："+clientIP);
        try {
            Document document = DocumentHelper.parseText(xmlStr);
            Element  root     = document.getRootElement();
            String   key      = root.element("head").element("key").getText();
            if ("queue_common_bindCard".equals(key)){
                String cardNo = root.element("body").element("cardNo").getText();
                String cardId = root.element("body").element("card_id").getText();
                String name = root.element("body").element("name").getText();
                String phone = root.element("body").element("phone").getText();
                logger.info("客户端IP地址："+cardNo);
                PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardId);
                if(!(patIccardRecNew == null)){ //不为空
                    if(cardNo.equals(patIccardRecNew.getPatientId())){
//                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(patIccardRecNew.getPatientId()); // 绑定病人时，如果charge_type是'军队医改'的病人，不能绑卡
                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patIccardRecNew.getPatientId());
                        if(patMasterIndex !=null && StringUtil.Iso_GBK(patMasterIndex.getName()).equals(name)){
                            patMasterIndex.setIdNo(cardId);
                            patMasterIndex.setPhoneNumberHome(phone);
                            patMasterIndexMapper.updateByPrimaryKey(patMasterIndex);
                            Document doc = DocumentHelper.createDocument();
                            doc.setXMLEncoding("GBK");
                            Element rootElement = doc.addElement("response");
                            Element headElement = rootElement.addElement("head");
                            headElement.addElement("result").setText("0");
                            headElement.addElement("desc").setText("卡号确认成功");
                            Element bodyElement = rootElement.addElement("body");
                            bodyElement.addElement("cardNo").setText(cardNo);
                            bodyElement.addElement("name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                            bodyElement.addElement("phone").setText(phone);
                            bodyElement.addElement("patientId").setText(Util.escapeInnerText(patMasterIndex.getPatientId()));
                            bodyElement.addElement("idCard").setText(Util.escapeInnerText(patMasterIndex.getIdNo()));
                            logger.info(doc.asXML());
                            result = doc.asXML();
                        }else{
                            result = getErrorMsg("[查无此卡号/其他]");
                        }
                    }else{
                        result = getErrorMsg("[患者主索引不一致/其他]");
                    }
                }else{//new 为空
//                    PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(cardNo); // 绑定病人时，如果charge_type是'军队医改'的病人，不能绑卡
                    PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(cardNo);
                    if(patMasterIndex !=null && StringUtil.Iso_GBK(patMasterIndex.getName()).equals(name)){
                        PatIccardRecNew pirn = new PatIccardRecNew();
                        pirn.setIccardNo(cardId);
                        pirn.setPatientId(cardNo);
                        pirn.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"),"yyyy-MM-dd").getTime()));
                        patIccardRecNewMapper.insert(pirn);
                        logger.info("pirn："+pirn);
                        patMasterIndex.setIdNo(cardId);
                        patMasterIndex.setPhoneNumberHome(phone);
                        patMasterIndexMapper.updateByPrimaryKey(patMasterIndex);
                        logger.info("patMasterIndex："+patMasterIndex);
                        Document doc = DocumentHelper.createDocument();
                        doc.setXMLEncoding("GBK");
                        Element rootElement = doc.addElement("response");
                        Element headElement = rootElement.addElement("head");
                        headElement.addElement("result").setText("0");
                        headElement.addElement("desc").setText("卡号确认成功");
                        Element bodyElement = rootElement.addElement("body");
                        bodyElement.addElement("cardNo").setText(cardNo);
                        bodyElement.addElement("name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                        bodyElement.addElement("phone").setText(phone);
                        bodyElement.addElement("patientId").setText(Util.escapeInnerText(patMasterIndex.getPatientId()));
                        bodyElement.addElement("idCard").setText(Util.escapeInnerText(patMasterIndex.getIdNo()));
                        logger.info(doc.asXML());
                        result = doc.asXML();
                    }else{
                        result = getErrorMsg("[查无此卡号/其他]");
                    }
                }





//                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(cardNo); // 绑定病人时，如果charge_type是'军队医改'的病人，不能绑卡
//                if(patMasterIndex !=null && StringUtil.Iso_GBK(patMasterIndex.getName()).equals(name)){
//                    if(!Util.isEmpty(cardId)){
//                        patMasterIndex.setIdNo(cardId);
//                        patMasterIndex.setPhoneNumberHome(phone);
//
//                        PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardId);
//                        if(!(patIccardRecNew == null)){
//                            //组织身份证与patientid
//                            patIccardRecNew.setIccardNo(cardId);
//                            patIccardRecNew.setPatientId(cardNo);
//                            patIccardRecNew.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"),"yyyy-MM-dd").getTime()));
//                            patIccardRecNewMapper.updateByPrimaryKey(patIccardRecNew);
//                        }else{
//                            PatIccardRecNew pirn = new PatIccardRecNew();
//                            pirn.setIccardNo(cardId);
//                            pirn.setPatientId(cardNo);
//                            pirn.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"),"yyyy-MM-dd").getTime()));
//                            patIccardRecNewMapper.insert(pirn);
//                        }
//
//                        patMasterIndexMapper.updateByPrimaryKey(patMasterIndex);
//                    }
//
//                    Document doc = DocumentHelper.createDocument();
//                    doc.setXMLEncoding("GBK");
//                    Element rootElement = doc.addElement("response");
//                    Element headElement = rootElement.addElement("head");
//                    headElement.addElement("result").setText("0");
//                    headElement.addElement("desc").setText("卡号确认成功");
//                    Element bodyElement = rootElement.addElement("body");
//                    bodyElement.addElement("cardNo").setText(cardNo);
//                    bodyElement.addElement("name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
//                    bodyElement.addElement("phone").setText(Util.escapeInnerText(patMasterIndex.getPhoneNumberHome()));
//                    bodyElement.addElement("patientId").setText(Util.escapeInnerText(patMasterIndex.getPatientId()));
//                    bodyElement.addElement("idCard").setText(Util.escapeInnerText(patMasterIndex.getIdNo()));
//                    logger.info(doc.asXML());
//                    result = doc.asXML();
//
//                }else{
//                    result = getErrorMsg("[查无此卡号/其他]");
//                }
            }else  if("pay_common_buildFile".equals(key)){
                String cardId = root.element("body").element("card_id").getText();
                System.out.println("身份证："+cardId);
                if(!Util.isEmpty(cardId)&& cardId.length()==18){
                    String name = root.element("body").element("name").getText();
                    String sex = root.element("body").element("sex").getText();
                    //  String cardNo = root.element("body").element("card_no").getText();
                    String phone = root.element("body").element("phone").getText();
                    String birthday = root.element("body").element("birthday").getText();
                    logger.info("zjp----->"+name);
                    String namePhonetic = PinyinTool.toPinYin(name," ",PinyinTool.Type.UPPERCASE) ;
                    PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardId);
                    PatIccardRecNew pirn = new PatIccardRecNew();
                    if(!(patIccardRecNew != null)){ //为空
                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByIdNo(cardId);
                        if(!(patMasterIndex != null)){ //为空
                            PatMasterIndex pmi = new PatMasterIndex();
                            String patientID = recpNoMapper.selectPatientID().getRecpNo();
                            int lengthDo = patientID.length();
                            if (lengthDo < 8) {
                                for (int i = 0; i < 8 - lengthDo; i++) {
                                    patientID = "0" + patientID;
                                }
                            }
                            patientID="61"+patientID;
                            //组织身份证与patientid
                            pirn.setIccardNo(cardId);
                            pirn.setPatientId(patientID);
                            pirn.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"),"yyyy-MM-dd").getTime()));

                            //组织病人的基本信息
                            pmi.setPatientId(patientID);
                            pmi.setInpNo("");
                            if(name.length()>4){
                                pmi.setName(StringUtil.Utf_Iso(name.substring(0,4)));
                            }else{
                                pmi.setName(StringUtil.Utf_Iso(name));
                            }
                            logger.info("zjp----->"+namePhonetic);
                            if (namePhonetic.length()>16){
                                pmi.setNamePhonetic(namePhonetic.substring(0,16)); //姓名拼音
                            }else{
                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                            }
                            String sexDecs="";
                            if(sex.equals("1")){
                                sexDecs ="男";
                            }else if (sex.equals("2")) {
                                sexDecs ="女";
                            }else{
                                sexDecs="未知";
                            }
                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,"yyyy-MM-dd").getTime())); //出生日期
                            if(cardId !=null){
                                pmi.setBirthPlace(cardId.substring(0,6));
                            }else{
                                pmi.setBirthPlace("");
                            }
                            pmi.setCitizenship("CN");
                            pmi.setNation(StringUtil.Utf_Iso("汉族"));
                            pmi.setIdNo(cardId);
                            pmi.setIdentity(StringUtil.Utf_Iso("地方人员"));
                            pmi.setChargeType(StringUtil.Utf_Iso("自费"));
                            pmi.setUnitInContract("");
                            pmi.setMailingAddress("");
                            pmi.setZipCode("");
                            pmi.setPhoneNumberHome(phone);
                            pmi.setPhoneNumberBusiness("");
                            pmi.setNextOfKin("");
                            pmi.setRelationship("");
                            pmi.setNextOfKinAddr("");
                            pmi.setNextOfKinZipCode("");
                            pmi.setNextOfKinPhone("");
                            pmi.setVipIndicator((short) 0);
                            pmi.setCreateDate(new Date());
                            pmi.setOperator("s160");
                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                            logger.info("zjp----->"+pmi);
                            patIccardRecNewMapper.insert(pirn);
                            patMasterIndexMapper.insertSelective(pmi);
                            Document doc = DocumentHelper.createDocument();
                            Element rootElement = doc.addElement("response");
                            Element headElement = rootElement.addElement("head");
                            headElement.addElement("result").setText("0");
                            headElement.addElement("desc").setText("建卡成功");
                            Element bodyElement = rootElement.addElement("body");
//                            bodyElement.addElement("card_no").setText("");
//                            bodyElement.addElement("name").setText("");
//                            bodyElement.addElement("sex").setText("");
//                            bodyElement.addElement("phone").setText("");
                            bodyElement.addElement("card_id").setText(patientID);
                            logger.info(doc.asXML());
                            result = doc.asXML();
                        }else{
                            //组织身份证与patientid
                            pirn.setIccardNo(cardId);
                            pirn.setPatientId(patMasterIndex.getPatientId());
                            pirn.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"),"yyyy-MM-dd").getTime()));

                            patIccardRecNewMapper.insert(pirn);

                            Document doc = DocumentHelper.createDocument();
                            Element rootElement = doc.addElement("response");
                            Element headElement = rootElement.addElement("head");
                            headElement.addElement("result").setText("0");
                            headElement.addElement("desc").setText("建卡成功");
                            Element bodyElement = rootElement.addElement("body");
//                            bodyElement.addElement("card_no").setText("");
//                            bodyElement.addElement("name").setText("");
//                            bodyElement.addElement("sex").setText("");
//                            bodyElement.addElement("phone").setText("");
                            bodyElement.addElement("card_id").setText(patMasterIndex.getPatientId());
                            logger.info(doc.asXML());
                            result = doc.asXML();
                        }
                    }else{
                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByIdNo(cardId);
                        if(!(patMasterIndex == null)){ //不为空
                            patMasterIndex.setPatientId(patIccardRecNew.getPatientId());
                            patMasterIndex.setIdNo(patIccardRecNew.getIccardNo());
                            patMasterIndex.setPhoneNumberHome(phone);
                            patMasterIndexMapper.updateByPrimaryKey(patMasterIndex);
                            Document doc = DocumentHelper.createDocument();
                            Element rootElement = doc.addElement("response");
                            Element headElement = rootElement.addElement("head");
                            headElement.addElement("result").setText("0");
                            headElement.addElement("desc").setText("建卡成功");
                            Element bodyElement = rootElement.addElement("body");
//                            bodyElement.addElement("card_no").setText("");
//                            bodyElement.addElement("name").setText("");
//                            bodyElement.addElement("sex").setText("");
//                            bodyElement.addElement("phone").setText("");
                            bodyElement.addElement("card_id").setText(patMasterIndex.getPatientId());
                            logger.info(doc.asXML());
                            result = doc.asXML();
                        }else{
                            PatMasterIndex pmi = new PatMasterIndex();
                            String patientID = recpNoMapper.selectPatientID().getRecpNo();
                            int lengthDo = patientID.length();
                            if (lengthDo < 8) {
                                for (int i = 0; i < 8 - lengthDo; i++) {
                                    patientID = "0" + patientID;
                                }
                            }
                            patientID="61"+patientID;
                            //组织病人的基本信息
                            pmi.setPatientId(patientID);
                            pmi.setInpNo("");
                            if(name.length()>4){
                                pmi.setName(StringUtil.Utf_Iso(name.substring(0,4)));
                            }else{
                                pmi.setName(StringUtil.Utf_Iso(name));
                            }
                            if (namePhonetic.length()>16){
                                pmi.setNamePhonetic(namePhonetic.substring(0,16)); //姓名拼音
                            }else{
                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                            }
                            String sexDecs="";
                            if(sex.equals("1")){
                                sexDecs ="男";
                            }else if (sex.equals("2")) {
                                sexDecs ="女";
                            }else{
                                sexDecs="未知";
                            }
                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,"yyyy-MM-dd").getTime())); //出生日期
                            if(cardId !=null){
                                pmi.setBirthPlace(cardId.substring(0,6));
                            }else{
                                pmi.setBirthPlace("");
                            }
                            pmi.setCitizenship("CN");
                            pmi.setNation(StringUtil.Utf_Iso("汉族"));
                            pmi.setIdNo(cardId);
                            pmi.setIdentity(StringUtil.Utf_Iso("地方人员"));
                            pmi.setChargeType(StringUtil.Utf_Iso("自费"));
                            pmi.setUnitInContract("");
                            pmi.setMailingAddress("");
                            pmi.setZipCode("");
                            pmi.setPhoneNumberHome(phone);
                            pmi.setPhoneNumberBusiness("");
                            pmi.setNextOfKin("");
                            pmi.setRelationship("");
                            pmi.setNextOfKinAddr("");
                            pmi.setNextOfKinZipCode("");
                            pmi.setNextOfKinPhone("");
                            pmi.setVipIndicator((short) 0);
                            pmi.setCreateDate(new Date());
                            pmi.setOperator("s160");
                            pmi.setNameAlias(StringUtil.Utf_Iso(name));
                            logger.info("zjp----->"+pmi);
                            patMasterIndexMapper.insertSelective(pmi);
                            Document doc = DocumentHelper.createDocument();
                            Element rootElement = doc.addElement("response");
                            Element headElement = rootElement.addElement("head");
                            headElement.addElement("result").setText("0");
                            headElement.addElement("desc").setText("建卡成功");
                            Element bodyElement = rootElement.addElement("body");
//                            bodyElement.addElement("card_no").setText("");
//                            bodyElement.addElement("name").setText("");
//                            bodyElement.addElement("sex").setText("");
//                            bodyElement.addElement("phone").setText("");
                            bodyElement.addElement("card_id").setText(patientID);
                            logger.info(doc.asXML());
                            result = doc.asXML();
                        }
                    }
                }else{
                    result = getErrorMsg("[身份证号为空/长度不为18位]");
                }

//            }else if ("queryQueue".equals(key)){
//                String appId  = root.element("body").element("appId").getText();
//                String depId  = root.element("body").element("depId").getText();
//                String doctorId =  root.element("body").element("doctorId").getText();
//                String endTime = root.element("body").element("endTime").getText();
//                int  queueNum = 0;
//                int  hasNo = 1;
//                if (!Util.isEmpty(appId) || (Util.isEmpty(depId) && Util.isEmpty(doctorId))){
//                    String beginTime = Util.getCurrentDate("yyyy-MM-dd");
//                    if(!Util.isEmpty(appId)){
////                        queueNum = clinicMasterMapper.selectPatientNumByAppId(appId,beginTime,endTime); //时间日期 有待转换
////                        ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByCliniclabel(appId);
////                        if(clinicForRegist!=null){
////                            if (clinicForRegist.getRegistrationLimits().equals("0")){
////                                hasNo =1;
////                            }else if (clinicForRegist.getRegistrationNum()>=clinicForRegist.getCurrentNo()){
////                                hasNo =0;
////                            }
////                        }
//                    }else{
//                 //       queueNum = clinicMasterMapper.selectPatientNumByOther(depId,doctorId,beginTime,endTime);
////                        ClinicForRegist clinicForRegist = clinicForRegistMapper.selectRegistByOther(depId,doctorId);
////                        if(clinicForRegist!=null){
////                            if (clinicForRegist.getRegistrationLimits().equals("0")){
////                                hasNo =1;
////                            }else if (clinicForRegist.getRegistrationNum()>=clinicForRegist.getCurrentNo()){
////                                hasNo =0;
////                            }
////                        }
//                    }
//                    Document doc = DocumentHelper.createDocument();
//                    Element rootElement = doc.addElement("response");
//                    Element headElement = rootElement.addElement("head");
//                    headElement.addElement("result").setText("0");
//                    headElement.addElement("desc").setText("查询成功");
//                    Element bodyElement = rootElement.addElement("body");
//                    bodyElement.addElement("queueNum").setText(queueNum+"");
//                    bodyElement.addElement("hasNo").setText(hasNo+"");
//                    bodyElement.addElement("averageTime").setText("");
//                    logger.info(doc.asXML());
//                    result = doc.asXML();
//                }else{
//                    result = getErrorMsg("[建卡失败]");
//                }

            }else if ("queue_comm_takeNo".equals(key)){

            }else if ("pay_common_queryPayInfo".equals(key)){
                String cardNo = root.element("body").element("cardNo").getText();
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(cardNo);
                String changeType = "自费";
                List<OutpOrdersT> outpOrdersTList = outpOrdersTMapper.selectByPrimaryKeyForZF(cardNo,StringUtil.Utf_Iso(changeType));
                if (!Util.isEmpty(outpOrdersTList)){
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element rootElement = doc.addElement("response");
                    Element headElement = rootElement.addElement("head");
                    headElement.addElement("result").setText("0");
                    headElement.addElement("desc").setText("查询成功");
                    Element bodyElement = rootElement.addElement("body");

                    //查询试管
                    // 1.是否存在，存在先删除(包含检验的辅材 和药品用法的辅材)，然后重新组织
                    List<OutpOrdersCosts> ordersCostsListForSGAndFC = new ArrayList<OutpOrdersCosts>();
                    for(int i=0;i<outpOrdersTList.size();i++) {
                        ordersCostsListForSGAndFC = outpOrdersCostsMapper.selectOrdersCostsDeleteForSG(outpOrdersTList.get(i).getVisitNo(), outpOrdersTList.get(i).getVisitDate(),"s160","ZZJ"); //查询是否已经插入采血费和药品的辅材费，已存在先删除
                        if (!Util.isEmpty(ordersCostsListForSGAndFC)) {

                            for (int k = 0; k < ordersCostsListForSGAndFC.size(); k++) {
//                                outpOrdersCostsMapper.deleteOrdersCostsDeleteForSG(ordersCostsListForSGAndFC.get(k).getVisitNo(),ordersCostsListForSGAndFC.get(k).getVisitDate());
                                outpOrdersCostsMapper.deleteByPrimaryKey(ordersCostsListForSGAndFC.get(k));
                            }
//                            break;
                        }
                    }

                    //雾化吸入 只收一组
                    boolean flag =false;
                    //组织支付项目
                    for(int i=0;i<outpOrdersTList.size();i++){
                        OutpOrdersT outpOrdersT =outpOrdersTList.get(i);
                        if(!Util.isEmpty(outpOrdersT.getSerialNo())){
                            List<OutpOrdersCosts> outpOrdersCostsList =outpOrdersCostsMapper.selectOrdersCostsListBySerialNo(outpOrdersT.getSerialNo(),outpOrdersT.getVisitDate(),outpOrdersT.getVisitNo());
                            if(!(outpOrdersCostsList !=null && outpOrdersCostsList.size()>0)){
                                continue;
                            }
//                        List<OutpOrdersCosts> outpOrdersCostsList =outpOrdersCostsMapper.selectOrdersCostsList(cardNo,StringUtil.Utf_Iso(changeType));
                            //List<OutpOrdersCosts> outpOrdersCostsList =outpOrdersCostsMapper.selectOrdersCostsListBySerialNo(outpOrdersT.getSerialNo());

                            // 只要有一次性末梢采血器，不收取任何辅助检查
                            List<OutpOrdersCosts> ordersCostsListForCXQ  =outpOrdersCostsMapper.selectOrdersCostsListForCXQ(outpOrdersT.getVisitNo(),outpOrdersT.getVisitDate(),outpOrdersT.getPatientId());
                            if(!(ordersCostsListForCXQ!=null&& ordersCostsListForCXQ.size()>0) ){
                                //查询试管
                                //2.如果是同一执行科室，只收一个管子,如果不是同一执行科室，每个科室收一个管子,同一批只收一个针头，一个静脉采血
                                List<OutpOrdersCosts> ordersCostsListForSG =outpOrdersCostsMapper.selectOrdersCostsDeptForSG(outpOrdersT.getVisitNo(),outpOrdersT.getVisitDate(),"ZZJ","s160"); //查询是否已经插入采血费，已存在不需要插入
                                if(Util.isEmpty(ordersCostsListForSG)){
                                    String serialNo="";
                                    for(int j=0;j<outpOrdersCostsList.size();j++){
                                        OutpOrdersCosts ordersCosts = outpOrdersCostsList.get(j);
                                        if(ordersCosts.getOrderClass().equals("C")){
                                            serialNo = ordersCosts.getSerialNo();
                                            break;
                                        }
                                    }

                                    if(!Util.isEmpty(serialNo)){
                                        //  List<OutpOrdersCosts> outpOrdersDeptList =outpOrdersCostsMapper.selectOrdersCostsDeptForJY(outpOrdersT.getVisitNo(),outpOrdersT.getVisitDate());//查询执行科室 绑定试管数量
                                        List<RecordNo> recorNoList = recordNoMapper.selectPerformedByListForSG(outpOrdersT.getVisitNo(),outpOrdersT.getVisitDate(),StringUtil.Utf_Iso("血%"));//查询执行科室 绑定试管数量
                                        if(!Util.isEmpty(recorNoList)){
                                            List<PriceList>   priceLists =  priceListMapper.selectPriceListForSG(StringUtil.Utf_Iso("7#南京德玥科"),StringUtil.Utf_Iso("进口南京浩谷"));
                                            //将试管组织插入到医嘱表中
                                            for(int k=0;k<priceLists.size();k++){
                                                PriceList priceList = priceLists.get(k);
                                                OutpOrdersCosts outpOrdersCostsSG =new OutpOrdersCosts();
                                                outpOrdersCostsSG.setSerialNo(serialNo);
                                                outpOrdersCostsSG.setOrderClass("C");
                                                outpOrdersCostsSG.setOrderNo((short) 0); //接口写入的采血类型
                                                int no = k+1;
                                                outpOrdersCostsSG.setItemNo((short) no);
                                                outpOrdersCostsSG.setPatientId(outpOrdersT.getPatientId());
                                                outpOrdersCostsSG.setVisitDate(outpOrdersT.getVisitDate());
                                                outpOrdersCostsSG.setVisitNo(outpOrdersT.getVisitNo());
                                                outpOrdersCostsSG.setItemClass(priceList.getItemClass());
                                                outpOrdersCostsSG.setItemName(priceList.getItemName());
                                                outpOrdersCostsSG.setOrderSubNo((short) 1);
                                                outpOrdersCostsSG.setRepetition((short)1);
                                                outpOrdersCostsSG.setItemCode(priceList.getItemCode());
                                                outpOrdersCostsSG.setItemSpec(priceList.getItemSpec());
                                                outpOrdersCostsSG.setUnits(priceList.getUnits());
                                                if(priceList.getItemCode().equals("71AAE00001")){ //试管
                                                    int size =recorNoList.size();
                                                    outpOrdersCostsSG.setAmount(new BigDecimal(size));
                                                    BigDecimal amount = new BigDecimal(size);
                                                    BigDecimal costs = amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                    outpOrdersCostsSG.setCosts(costs);
                                                    outpOrdersCostsSG.setCharges(costs);
                                                }else{
                                                    outpOrdersCostsSG.setAmount(new BigDecimal(1));
                                                    outpOrdersCostsSG.setCosts(priceList.getPrice());
                                                    outpOrdersCostsSG.setCharges(priceList.getPrice());
                                                }
                                                outpOrdersCostsSG.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                outpOrdersCostsSG.setOrderByName("s160");
                                                outpOrdersCostsSG.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                outpOrdersCostsSG.setChargeIndicator((short) 0);
                                                if (outpOrdersT.getOrderedBy().startsWith("28")){
                                                    outpOrdersCostsSG.setPerformedBy("2802");
                                                }else if(outpOrdersT.getOrderedBy().startsWith("11")){
                                                    outpOrdersCostsSG.setPerformedBy("110301");
                                                }else{
                                                    outpOrdersCostsSG.setPerformedBy("2607");
                                                }
                                                outpOrdersCostsMapper.insert(outpOrdersCostsSG);
                                            }
                                        }
                                    }
                                }
                            }

                            boolean flagJC =false;//执行科室为 4701 单独收一个一次性大单
                            boolean flag1 =false ;//执行科室为 1107 单独收一个一次性大单
                            boolean flagDeptCode =false; //开单科室11开头的 并且 执行科室为 4701  单独收0.5 耦合剂
                            if(!Util.isEmpty(outpOrdersCostsList)){
                                for(int k=0;k<outpOrdersCostsList.size();k++){
                                    OutpOrdersCosts ordersCosts = outpOrdersCostsList.get(k);
                                    if(ordersCosts.getOrderClass().equals("D")){
                                        if(!flagJC) {
                                            if (ordersCosts.getPerformedBy().equals("4701")) {
                                                short num = outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                                CurrentPriceList currentPriceList = currentPriceListMapper.selectByPrimaryKey("I","71AAC00006",StringUtil.Utf_Iso("60Cmx110Cm南京新中标"),StringUtil.Utf_Iso("条"));
                                                if (currentPriceList != null) {
                                                    OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                    outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                    outpOrdersCostsJM.setOrderClass(currentPriceList.getItemClass());
                                                    outpOrdersCostsJM.setOrderNo((short) 1);
                                                    int no = num + k + 1;
                                                    outpOrdersCostsJM.setItemNo((short) no);
                                                    outpOrdersCostsJM.setPatientId(outpOrdersT.getPatientId());
                                                    outpOrdersCostsJM.setVisitDate(outpOrdersT.getVisitDate());
                                                    outpOrdersCostsJM.setVisitNo(outpOrdersT.getVisitNo());
                                                    outpOrdersCostsJM.setItemClass(currentPriceList.getItemClass());
                                                    outpOrdersCostsJM.setItemName(currentPriceList.getItemName());
                                                    outpOrdersCostsJM.setOrderSubNo((short) 1);
                                                    outpOrdersCostsJM.setRepetition((short) 1);
                                                    outpOrdersCostsJM.setItemCode(currentPriceList.getItemCode());
                                                    outpOrdersCostsJM.setItemSpec(currentPriceList.getItemSpec());
                                                    outpOrdersCostsJM.setUnits(currentPriceList.getUnits());
                                                    outpOrdersCostsJM.setAmount(BigDecimal.valueOf(1));
                                                    outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                    outpOrdersCostsJM.setCosts(new BigDecimal(String.valueOf(currentPriceList.getPrice())));
                                                    outpOrdersCostsJM.setCharges(new BigDecimal(String.valueOf(currentPriceList.getPrice())));
                                                    outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                    outpOrdersCostsJM.setOrderByName("s160");
                                                    outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                    outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                    outpOrdersCostsJM.setPerformedBy("4701");
                                                    outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                                }
                                                flagJC = true;
                                                continue;
                                            }
                                        }
                                        if(!flag1) {
                                            if (ordersCosts.getPerformedBy().equals("1107")) {
                                                short num = outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                                CurrentPriceList currentPriceList = currentPriceListMapper.selectByPrimaryKey("I","71AAC00006",StringUtil.Utf_Iso("60Cmx110Cm南京新中标"),StringUtil.Utf_Iso("条"));
                                                if (currentPriceList != null) {
                                                    OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                    outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                    outpOrdersCostsJM.setOrderClass(currentPriceList.getItemClass());
                                                    outpOrdersCostsJM.setOrderNo((short) 1);
                                                    int no = num + k + 1;
                                                    outpOrdersCostsJM.setItemNo((short) no);
                                                    outpOrdersCostsJM.setPatientId(outpOrdersT.getPatientId());
                                                    outpOrdersCostsJM.setVisitDate(outpOrdersT.getVisitDate());
                                                    outpOrdersCostsJM.setVisitNo(outpOrdersT.getVisitNo());
                                                    outpOrdersCostsJM.setItemClass(currentPriceList.getItemClass());
                                                    outpOrdersCostsJM.setItemName(currentPriceList.getItemName());
                                                    outpOrdersCostsJM.setOrderSubNo((short) 1);
                                                    outpOrdersCostsJM.setRepetition((short) 1);
                                                    outpOrdersCostsJM.setItemCode(currentPriceList.getItemCode());
                                                    outpOrdersCostsJM.setItemSpec(currentPriceList.getItemSpec());
                                                    outpOrdersCostsJM.setUnits(currentPriceList.getUnits());
                                                    outpOrdersCostsJM.setAmount(BigDecimal.valueOf(1));
                                                    outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                    outpOrdersCostsJM.setCosts(new BigDecimal(String.valueOf(currentPriceList.getPrice())));
                                                    outpOrdersCostsJM.setCharges(new BigDecimal(String.valueOf(currentPriceList.getPrice())));
                                                    outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                    outpOrdersCostsJM.setOrderByName("s160");
                                                    outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                    outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                    outpOrdersCostsJM.setPerformedBy("1107");
                                                    outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                                }
                                                flag1 = true;
                                                continue;
                                            }
                                        }
                                        if(!flagDeptCode){
                                            if(outpOrdersT.getOrderedBy().equals("1103") && ordersCosts.getPerformedBy().equals("4701") ){
                                                short num = outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                                CurrentPriceList currentPriceList = currentPriceListMapper.selectByPrimaryKey("I", "71AAF00713", "0.5", StringUtil.Utf_Iso("支"));
                                                if (currentPriceList != null) {
                                                    OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                    outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                    outpOrdersCostsJM.setOrderClass(currentPriceList.getItemClass());
                                                    outpOrdersCostsJM.setOrderNo((short) 1);
                                                    int no = num + k + 1;
                                                    outpOrdersCostsJM.setItemNo((short) no);
                                                    outpOrdersCostsJM.setPatientId(outpOrdersT.getPatientId());
                                                    outpOrdersCostsJM.setVisitDate(outpOrdersT.getVisitDate());
                                                    outpOrdersCostsJM.setVisitNo(outpOrdersT.getVisitNo());
                                                    outpOrdersCostsJM.setItemClass(currentPriceList.getItemClass());
                                                    outpOrdersCostsJM.setItemName(currentPriceList.getItemName());
                                                    outpOrdersCostsJM.setOrderSubNo((short) 1);
                                                    outpOrdersCostsJM.setRepetition((short) 1);
                                                    outpOrdersCostsJM.setItemCode(currentPriceList.getItemCode());
                                                    outpOrdersCostsJM.setItemSpec(currentPriceList.getItemSpec());
                                                    outpOrdersCostsJM.setUnits(currentPriceList.getUnits());
                                                    outpOrdersCostsJM.setAmount(BigDecimal.valueOf(1));
                                                    outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                    outpOrdersCostsJM.setCosts(new BigDecimal(String.valueOf(currentPriceList.getPrice())));
                                                    outpOrdersCostsJM.setCharges(new BigDecimal(String.valueOf(currentPriceList.getPrice())));
                                                    outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                    outpOrdersCostsJM.setOrderByName("s160");
                                                    outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                    outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                    outpOrdersCostsJM.setPerformedBy("4701");
                                                    outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                                }
                                                flagDeptCode = true;
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }

                            // 静脉输液附加费用计算（静脉输液，静脉续滴）
                            if(!Util.isEmpty(outpOrdersCostsList)){
                                for(int j=0;j<outpOrdersCostsList.size();j++){
                                    OutpOrdersCosts ordersCosts = outpOrdersCostsList.get(j);
                                    if(ordersCosts.getOrderClass().equals("A") && ( StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("静脉滴注")|| StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("静脉续滴")|| StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("小儿静滴") )){
                                        logger.info("----------->zjp"+StringUtil.Iso_GBK(ordersCosts.getAdministration()));
                                        List<ItemRelation>  itemRelationList =itemRelationMapper.selectItemList();
                                        for(int k=0;k<itemRelationList.size();k++){
                                            ItemRelation itemRelation =itemRelationList.get(k);
                                            if(ordersCosts.getItemClass().equals(itemRelation.getItemClass())&&ordersCosts.getItemCode().equals(itemRelation.getItemCode())&& ordersCosts.getItemSpec().equals(itemRelation.getItemSpec())&&ordersCosts.getUnits().equals(itemRelation.getUnits())){
                                                List<ClinicVsCharge> clinicVsChargeList =  clinicVsChargeMapper.selectByAdministration(ordersCosts.getAdministration());
                                                if(!Util.isEmpty(clinicVsChargeList)) {
                                                    short num =  outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(),ordersCosts.getVisitNo(),ordersCosts.getSerialNo()).getItemNo();
                                                    for (int g = 0; g < clinicVsChargeList.size(); g++) {
                                                        ClinicVsCharge clinicVsCharge = clinicVsChargeList.get(g);
                                                        PriceList priceList = priceListMapper.selectPriceListForAdministration(clinicVsCharge.getChargeItemClass(),clinicVsCharge.getChargeItemCode(),clinicVsCharge.getChargeItemSpec(),clinicVsCharge.getUnits());
                                                        if(!(priceList == null)){
                                                            OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                            outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                            outpOrdersCostsJM.setOrderClass(priceList.getItemClass());
                                                            outpOrdersCostsJM.setOrderNo((short) 1);
                                                            int no= num+g+1;
                                                            outpOrdersCostsJM.setItemNo((short) no);
                                                            outpOrdersCostsJM.setPatientId(outpOrdersT.getPatientId());
                                                            outpOrdersCostsJM.setVisitDate(outpOrdersT.getVisitDate());
                                                            outpOrdersCostsJM.setVisitNo(outpOrdersT.getVisitNo());
                                                            outpOrdersCostsJM.setItemClass(priceList.getItemClass());
                                                            outpOrdersCostsJM.setItemName(priceList.getItemName());
                                                            outpOrdersCostsJM.setOrderSubNo((short) 1);
                                                            outpOrdersCostsJM.setRepetition((short) 1);
                                                            outpOrdersCostsJM.setItemCode(priceList.getItemCode());
                                                            outpOrdersCostsJM.setItemSpec(priceList.getItemSpec());
                                                            outpOrdersCostsJM.setUnits(priceList.getUnits());

                                                            BigDecimal amount;
                                                            if(ordersCosts.getDays() == null || ordersCosts.getDays() < 1){
                                                                amount = new BigDecimal(clinicVsCharge.getAmount());
                                                            }else{
                                                                amount = new BigDecimal(clinicVsCharge.getAmount()).multiply(new BigDecimal(ordersCosts.getDays()));
                                                            }

                                                            outpOrdersCostsJM.setAmount(amount);
                                                            outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                            //BigDecimal amount = new BigDecimal(clinicVsCharge.getAmount());
                                                            BigDecimal cost = amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                            outpOrdersCostsJM.setCosts(cost);
                                                            outpOrdersCostsJM.setCharges(cost);
                                                            outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                            outpOrdersCostsJM.setOrderByName("s160");
                                                            outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                            outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                            if(StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("小儿静滴")){
                                                                outpOrdersCostsJM.setPerformedBy("260201");
                                                            }else{
                                                                if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                    outpOrdersCostsJM.setPerformedBy("260201");
                                                                }else if(outpOrdersT.getOrderedBy().equals("1103")){
                                                                    outpOrdersCostsJM.setPerformedBy("110301");
                                                                }else {
                                                                    outpOrdersCostsJM.setPerformedBy("2802");
                                                                }
                                                            }

                                                            outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                                        }
                                                    }
                                                }
                                                if(ordersCosts.getOrderClass().equals("A") && (StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("静脉滴注"))){
                                                    PriceList priceList = priceListMapper.selectPriceListForSY(StringUtil.Utf_Iso("20ml江苏苏云医"));
                                                    short num =  outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(),ordersCosts.getVisitNo(),ordersCosts.getSerialNo()).getItemNo();
                                                    if(!(priceList == null)){
                                                        OutpOrdersCosts outpOrdersCostsZS = new OutpOrdersCosts();
                                                        outpOrdersCostsZS.setSerialNo(ordersCosts.getSerialNo());
                                                        outpOrdersCostsZS.setOrderClass(priceList.getItemClass());
                                                        outpOrdersCostsZS.setOrderNo((short) 1);
                                                        num++;
                                                        outpOrdersCostsZS.setItemNo(num);
                                                        outpOrdersCostsZS.setPatientId(outpOrdersT.getPatientId());
                                                        outpOrdersCostsZS.setVisitDate(outpOrdersT.getVisitDate());
                                                        outpOrdersCostsZS.setVisitNo(outpOrdersT.getVisitNo());
                                                        outpOrdersCostsZS.setItemClass(priceList.getItemClass());
                                                        outpOrdersCostsZS.setItemName(priceList.getItemName());
                                                        outpOrdersCostsZS.setOrderSubNo((short) 1);
                                                        outpOrdersCostsZS.setRepetition((short) 1);
                                                        outpOrdersCostsZS.setItemCode(priceList.getItemCode());
                                                        outpOrdersCostsZS.setItemSpec(priceList.getItemSpec());
                                                        outpOrdersCostsZS.setUnits(priceList.getUnits());

                                                        BigDecimal cost;
                                                        if(ordersCosts.getDays() == 0 || ordersCosts.getDays() < 1){
                                                            outpOrdersCostsZS.setAmount(new BigDecimal(1));
                                                            cost = new BigDecimal(String.valueOf(priceList.getPrice()));
                                                        }else{
                                                            outpOrdersCostsZS.setAmount(new BigDecimal(ordersCosts.getDays()));
                                                            cost = new BigDecimal(ordersCosts.getDays()).multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                        }
                                                        outpOrdersCostsZS.setDays(ordersCosts.getDays());
                                                        outpOrdersCostsZS.setCosts(cost);
                                                        outpOrdersCostsZS.setCharges(cost);
                                                        outpOrdersCostsZS.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                        outpOrdersCostsZS.setOrderByName("s160");
                                                        outpOrdersCostsZS.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                        outpOrdersCostsZS.setChargeIndicator((short) 0);
                                                        if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                            outpOrdersCostsZS.setPerformedBy("260201");
                                                        } else if(outpOrdersT.getOrderedBy().equals("1103")){
                                                            outpOrdersCostsZS.setPerformedBy("110301");
                                                        }else {
                                                            outpOrdersCostsZS.setPerformedBy("2802");
                                                        }
                                                        outpOrdersCostsMapper.insert(outpOrdersCostsZS);
                                                    }
                                                }
                                            }
                                        }

                                    }else{
                                        if(!Util.isEmpty(ordersCosts.getAdministration())){
                                            BigDecimal days = new BigDecimal(String.valueOf(ordersCosts.getDays()));
                                            if(StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("雾化吸入")){
                                                if(flag){
                                                    continue;
                                                }
                                                flag =true;
                                                days =  new BigDecimal(String.valueOf(outpOrdersCostsMapper.selectISOrdersCostsForMaxAmount(ordersCosts.getVisitDate(),ordersCosts.getVisitNo(), StringUtil.Utf_Iso("雾化吸入"),outpOrdersT.getPatientId()).getAmount()));
                                            }
                                            //配置中的代码不收辅材费
                                            File file = new File("C:\\configuration\\drugCode.txt");
                                            String drugCode = txt2String(file);
                                            if(drugCode!=null && drugCode.length()>0) {
                                                if (!drugCode.contains(ordersCosts.getItemCode())) {
                                                    List<ClinicVsCharge> clinicVsChargeList =  clinicVsChargeMapper.selectByAdministration(ordersCosts.getAdministration());
                                                    if(!Util.isEmpty(clinicVsChargeList)) {
                                                        short num =  outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(),ordersCosts.getVisitNo(),ordersCosts.getSerialNo()).getItemNo();
                                                        for (int k = 0; k < clinicVsChargeList.size(); k++) {
                                                            ClinicVsCharge clinicVsCharge = clinicVsChargeList.get(k);
                                                            PriceList priceList = priceListMapper.selectPriceListForAdministration(clinicVsCharge.getChargeItemClass(),clinicVsCharge.getChargeItemCode(),clinicVsCharge.getChargeItemSpec(),clinicVsCharge.getUnits());
                                                            if(!(priceList == null)){
                                                                OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                                outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                                outpOrdersCostsJM.setOrderClass(priceList.getItemClass());
                                                                outpOrdersCostsJM.setOrderNo((short) 1);
                                                                int no= num+k+1;
                                                                outpOrdersCostsJM.setItemNo((short) no);
                                                                outpOrdersCostsJM.setPatientId(outpOrdersT.getPatientId());
                                                                outpOrdersCostsJM.setVisitDate(outpOrdersT.getVisitDate());
                                                                outpOrdersCostsJM.setVisitNo(outpOrdersT.getVisitNo());
                                                                outpOrdersCostsJM.setItemClass(priceList.getItemClass());
                                                                outpOrdersCostsJM.setItemName(priceList.getItemName());
                                                                outpOrdersCostsJM.setOrderSubNo((short) 1);
                                                                outpOrdersCostsJM.setRepetition((short) 1);
                                                                outpOrdersCostsJM.setItemCode(priceList.getItemCode());
                                                                outpOrdersCostsJM.setItemSpec(priceList.getItemSpec());
                                                                outpOrdersCostsJM.setUnits(priceList.getUnits());

                                                                BigDecimal amount;
                                                                if(days.compareTo(new BigDecimal(1)) < 0){
                                                                    amount = new BigDecimal(clinicVsCharge.getAmount());
                                                                }else{
                                                                    amount = new BigDecimal(clinicVsCharge.getAmount()).multiply(days);
                                                                }
                                                                outpOrdersCostsJM.setAmount(amount);
                                                                outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                                //BigDecimal amount = new BigDecimal(clinicVsCharge.getAmount());
                                                                BigDecimal cost = amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                                outpOrdersCostsJM.setCosts(cost);
                                                                outpOrdersCostsJM.setCharges(cost);
                                                                outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                                outpOrdersCostsJM.setOrderByName("s160");
                                                                outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                                outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                                if(StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("肌肉注射")){
                                                                    if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                        outpOrdersCostsJM.setPerformedBy("260201");
                                                                    } else if(outpOrdersT.getOrderedBy().equals("1103")){
                                                                        outpOrdersCostsJM.setPerformedBy("110301");
                                                                    } else if(outpOrdersT.getOrderedBy().startsWith("28")){
                                                                        outpOrdersCostsJM.setPerformedBy("2802");
                                                                    } else {
                                                                        outpOrdersCostsJM.setPerformedBy("2607");
                                                                    }
                                                                }else{
                                                                    if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                        outpOrdersCostsJM.setPerformedBy("260201");
                                                                    } else if(outpOrdersT.getOrderedBy().equals("1103")){
                                                                        outpOrdersCostsJM.setPerformedBy("110301");
                                                                    } else if(outpOrdersT.getOrderedBy().equals("1901")&& StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("雾化吸入")){
                                                                        outpOrdersCostsJM.setPerformedBy("1901");
                                                                    } else {
                                                                        outpOrdersCostsJM.setPerformedBy("2802");
                                                                    }
                                                                }

                                                                outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                                            }
                                                        }
                                                    }
                                                }
                                            }else{
                                                List<ClinicVsCharge> clinicVsChargeList =  clinicVsChargeMapper.selectByAdministration(ordersCosts.getAdministration());
                                                if(!Util.isEmpty(clinicVsChargeList)) {
                                                    short num =  outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(),ordersCosts.getVisitNo(),ordersCosts.getSerialNo()).getItemNo();
                                                    for (int k = 0; k < clinicVsChargeList.size(); k++) {
                                                        ClinicVsCharge clinicVsCharge = clinicVsChargeList.get(k);
                                                        PriceList priceList = priceListMapper.selectPriceListForAdministration(clinicVsCharge.getChargeItemClass(),clinicVsCharge.getChargeItemCode(),clinicVsCharge.getChargeItemSpec(),clinicVsCharge.getUnits());
                                                        if(!(priceList == null)){
                                                            OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                            outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                            outpOrdersCostsJM.setOrderClass(priceList.getItemClass());
                                                            outpOrdersCostsJM.setOrderNo((short) 1);
                                                            int no= num+k+1;
                                                            outpOrdersCostsJM.setItemNo((short) no);
                                                            outpOrdersCostsJM.setPatientId(outpOrdersT.getPatientId());
                                                            outpOrdersCostsJM.setVisitDate(outpOrdersT.getVisitDate());
                                                            outpOrdersCostsJM.setVisitNo(outpOrdersT.getVisitNo());
                                                            outpOrdersCostsJM.setItemClass(priceList.getItemClass());
                                                            outpOrdersCostsJM.setItemName(priceList.getItemName());
                                                            outpOrdersCostsJM.setOrderSubNo((short) 1);
                                                            outpOrdersCostsJM.setRepetition((short) 1);
                                                            outpOrdersCostsJM.setItemCode(priceList.getItemCode());
                                                            outpOrdersCostsJM.setItemSpec(priceList.getItemSpec());
                                                            outpOrdersCostsJM.setUnits(priceList.getUnits());

                                                            BigDecimal amount;
                                                            if(days.compareTo(new BigDecimal(1)) < 0){
                                                                amount = new BigDecimal(clinicVsCharge.getAmount());
                                                            }else{
                                                                amount = new BigDecimal(clinicVsCharge.getAmount()).multiply(days);
                                                            }
                                                            outpOrdersCostsJM.setAmount(amount);
                                                            outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                            //BigDecimal amount = new BigDecimal(clinicVsCharge.getAmount());
                                                            BigDecimal cost = amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                            outpOrdersCostsJM.setCosts(cost);
                                                            outpOrdersCostsJM.setCharges(cost);
                                                            outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                            outpOrdersCostsJM.setOrderByName("s160");
                                                            outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                            outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                            if(StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("肌肉注射")){
                                                                if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                    outpOrdersCostsJM.setPerformedBy("260201");
                                                                } else if(outpOrdersT.getOrderedBy().equals("1103")){
                                                                    outpOrdersCostsJM.setPerformedBy("110301");
                                                                } else if(outpOrdersT.getOrderedBy().startsWith("28")){
                                                                    outpOrdersCostsJM.setPerformedBy("2802");
                                                                } else {
                                                                    outpOrdersCostsJM.setPerformedBy("2607");
                                                                }
                                                            }else{
                                                                if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                    outpOrdersCostsJM.setPerformedBy("260201");
                                                                } else if(outpOrdersT.getOrderedBy().equals("1103")){
                                                                    outpOrdersCostsJM.setPerformedBy("110301");
                                                                } else if(outpOrdersT.getOrderedBy().equals("1901")&& StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("雾化吸入")){
                                                                    outpOrdersCostsJM.setPerformedBy("1901");
                                                                } else {
                                                                    outpOrdersCostsJM.setPerformedBy("2802");
                                                                }
                                                            }

                                                            outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                                        }
                                                    }
                                                }
                                            }

                                        }

                                    }
                                }
                            }

                            //重新查 看是否含有采血项目和静脉输液附加费
                            outpOrdersCostsList =outpOrdersCostsMapper.selectOrdersCostsListBySerialNo(outpOrdersT.getSerialNo(), outpOrdersT.getVisitDate(), outpOrdersT.getVisitNo());
                            logger.info("[诊中  入参 :]" + outpOrdersCostsList);
                            String hisPayAmt = outpOrdersCostsMapper.selectCountBySerialNo(outpOrdersT.getSerialNo(),outpOrdersT.getVisitDate(), outpOrdersT.getVisitNo()).getCosts().toString();
                            String deptName = deptDictMapper.selectByPrimaryKey(outpOrdersT.getOrderedBy()).getDeptName();
                            for(int j=0;j<outpOrdersCostsList.size();j++){
                                Element payInfoElement =   bodyElement.addElement("pay_info");
                                OutpOrdersCosts outpOrdersCosts = outpOrdersCostsList.get(j);
                                payInfoElement.addElement("hisPayNo").setText(outpOrdersCosts.getSerialNo());//流水号
                                payInfoElement.addElement("presNo").setText(StringUtil.Iso_GBK(outpOrdersCosts.getOrderNo()+""));//医嘱序号
                                payInfoElement.addElement("hisPayNoSn").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemNo()+""));//计价项目序号
                                payInfoElement.addElement("item_code_his").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemCode()));//计价项目代码
                                payInfoElement.addElement("itemCodeYB").setText("");//
                                payInfoElement.addElement("detail_item_name").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemName()));//计价项目名称
                                payInfoElement.addElement("std").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemSpec()));//计价项目规格
                                if(outpOrdersCosts.getRepetition() > 1){
                                    payInfoElement.addElement("amt").setText(outpOrdersCosts.getAmount()
                                            .multiply(new BigDecimal(outpOrdersCosts.getRepetition()))+"");//数量
                                }else{
                                    payInfoElement.addElement("amt").setText(outpOrdersCosts.getAmount()+"");//数量
                                }

                                payInfoElement.addElement("unit").setText(StringUtil.Iso_GBK(outpOrdersCosts.getUnits()));//计价单位
                                payInfoElement.addElement("price").setText(outpOrdersCosts.getCosts().divide(outpOrdersCosts.getAmount(), 2, RoundingMode.HALF_UP)+""); //单价
                                payInfoElement.addElement("detailPayAmt").setText(StringUtil.Iso_GBK(outpOrdersCosts.getCosts()+""));//计价费用

                                payInfoElement.addElement("phone").setText(Util.escapeInnerText(patMasterIndex.getNextOfKinPhone()));
                                payInfoElement.addElement("cardId").setText(Util.escapeInnerText(patMasterIndex.getIdNo()));
                                payInfoElement.addElement("healthyno").setText(DateToWeek.formatDateString(outpOrdersT.getVisitDate(),"yyyy-MM-dd")+"^"+outpOrdersT.getVisitNo()); //
                                payInfoElement.addElement("his_pay_no").setText(outpOrdersT.getSerialNo());
                                payInfoElement.addElement("payamt").setText(hisPayAmt);
                                payInfoElement.addElement("selfPayAmt").setText(hisPayAmt);
                                payInfoElement.addElement("socialPayAmt").setText("0");
                                payInfoElement.addElement("payType").setText("weixin");
                                payInfoElement.addElement("creatTime").setText(Util.format(outpOrdersT.getOrderDate(),"yyyy-MM-dd HH:mm:ss"));
                                payInfoElement.addElement("regType").setText("0");
                                payInfoElement.addElement("depId").setText(outpOrdersCosts.getPerformedBy());
                                payInfoElement.addElement("dep_name").setText(StringUtil.Iso_GBK(deptName));
                                payInfoElement.addElement("docId").setText(StringUtil.Iso_GBK(outpOrdersT.getDoctor()));
                                if("A".equals(outpOrdersCosts.getOrderClass())){
                                    payInfoElement.addElement("itemClass").setText("0");
                                }else {
                                    payInfoElement.addElement("itemClass").setText("1");
                                }


                            }
                        }
                    }
                    logger.info(doc.asXML());
                    result = doc.asXML();
                }else{
                    result = getErrorMsg("[无收费项目]");
                }
//            }else if ("pay_queryPayInfoDetail".equals(key)){
//                String cardType = root.element("body").element("cardType").getText();
//                String cardNo = root.element("body").element("cardNo").getText();
////                String hisPayNo = root.element("body").element("hisPayNo").getText();
////                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(cardNo);
//                String changeType = "自费";
//                List<OutpOrdersCosts> outpOrdersCostsList =outpOrdersCostsMapper.selectOrdersCostsList(cardNo,StringUtil.Utf_Iso(changeType));
//                if (!Util.isEmpty(outpOrdersCostsList)){
//                    Document doc = DocumentHelper.createDocument();
//                    doc.setXMLEncoding("GBK");
//                    Element rootElement = doc.addElement("response");
//                    Element headElement = rootElement.addElement("head");
//                    headElement.addElement("key").setText("pay_queryPayInfoDetail");
//                    headElement.addElement("hospcode").setText("");
//                    headElement.addElement("token").setText("");
//                    headElement.addElement("time").setText(Util.getCurrentDate("yyyyMMddHHmmss"));
//                    Element bodyElement = rootElement.addElement("body");
////                    for(int i=0;i<outpOrdersCostsList.size();i++){
////                        OutpOrdersCosts outpOrdersCosts = outpOrdersCostsList.get(i);
////                        Element detailElement =   bodyElement.addElement("detail");
////                        detailElement.addElement("hisPayNo").setText(outpOrdersCosts.getSerialNo());
////                        detailElement.addElement("presNo").setText(StringUtil.Iso_GBK(outpOrdersCosts.getOrderNo()+""));
////                        detailElement.addElement("hisPayNoSn").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemNo()+""));
////                        detailElement.addElement("itemCodeHIS").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemCode()));
////                        detailElement.addElement("itemCodeYB").setText("");
////                        detailElement.addElement("itemName").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemName()));
////                        detailElement.addElement("std").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemSpec()));
////                        detailElement.addElement("amt").setText(StringUtil.Iso_GBK(outpOrdersCosts.getAmount()+""));
////                        detailElement.addElement("unit").setText(StringUtil.Iso_GBK(outpOrdersCosts.getUnits()));
////                        detailElement.addElement("price").setText("");
////                        detailElement.addElement("hisPayAmt").setText(StringUtil.Iso_GBK(outpOrdersCosts.getCosts()+""));
////                        detailElement.addElement("selfPayAmt").setText("");
////                        detailElement.addElement("socialPayAmt").setText("");
////                    }
//                    logger.info(doc.asXML());
//                    result = doc.asXML();
//                }else{
//                    result = getErrorMsg("[无收费项目]");
//                }
            }else if ("confirmPayInfo".equals(key)){
                String cardNo = root.element("body").element("cardNo").getTextTrim();
//                String appId = root.element("body").element("appId").getTextTrim();
                String hisPayNo = root.element("body").element("hisPayNo").getTextTrim();
                String webPayNo = root.element("body").element("webPayNo").getTextTrim();
                System.out.println("业务标识："+key);
                String payAmt = root.element("body").element("payAmt").getTextTrim();
//                String socialPayAmt = root.element("body").element("socialPayAmt").getTextTrim();
//                String selfPayAmt = root.element("body").element("selfPayAmt").getTextTrim();
                String payMethod = root.element("body").element("payMethod").getTextTrim();
                String payTime = root.element("body").element("payTime").getTextTrim();
                String payType = root.element("body").element("payType").getTextTrim();
//                String SSBillNumber = root.element("body").element("SSBillNumber").getTextTrim();
//                String SSItems = root.element("body").element("SSItems").getTextTrim();
                String mchid = root.element("body").element("mchId").getTextTrim();
                System.out.println("业务标识："+key);
                InternetPayinfo IPI = internetPayinfoMapper.selectByPrimaryKey(webPayNo);
                if(IPI==null){
                    //该单据所有费用
                    String hisPayAmt = outpOrdersCostsMapper.selectCountBySerialNo1(hisPayNo).getCosts().toString();
                    String rcptNo="";
                    if(!Util.isEmpty(hisPayNo) && payAmt.equals(hisPayAmt)){
                        List<OutpOrdersCosts>  outpOrdersCostsList = outpOrdersCostsMapper.selectOrdersCostsListBySerialNo1(hisPayNo);
                        OutpOrdersT outpOrdersT = outpOrdersTMapper.selectByPrimaryKey(hisPayNo);
                        if(!Util.isEmpty(outpOrdersCostsList)){
//                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(cardNo);

                            ClinicMaster clinicMaster = new ClinicMaster();
                            clinicMaster.setVisitDate(outpOrdersT.getVisitDate());
                            clinicMaster.setVisitNo(outpOrdersT.getVisitNo());
                            clinicMaster = clinicMasterMapper.selectByPrimaryKey(clinicMaster);

                            rcptNo = "O"+recpNoMapper.selectRecpNo().getRecpNo();

                            //1.门诊医疗收据记录 OUTP_RCPT_MASTER
                            OutpRcptMaster outpRcptMaster = new OutpRcptMaster();
                            outpRcptMaster.setRcptNo(rcptNo);
                            outpRcptMaster.setPatientId(clinicMaster.getPatientId());
                            outpRcptMaster.setName(clinicMaster.getName());
                            outpRcptMaster.setNamePhonetic(clinicMaster.getNamePhonetic());
                            outpRcptMaster.setIdentity(clinicMaster.getIdentity());
                            outpRcptMaster.setChargeType(clinicMaster.getChargeType());
                            outpRcptMaster.setUnitInContract(clinicMaster.getUnitInContract());
                            outpRcptMaster.setVisitDate(new Timestamp(DateToWeek.formatDate(payTime,"yyyy-MM-dd HH:mm:ss").getTime()));
                            outpRcptMaster.setTotalCosts(new BigDecimal(payAmt));
                            outpRcptMaster.setTotalCharges(new BigDecimal(payAmt));
                            outpRcptMaster.setOperatorNo("s160");
                            outpRcptMaster.setChargeIndicator((short) 0);
                            outpRcptMaster.getRefundedRcptNo();
                            outpRcptMaster.setAcctNo("");
                            outpRcptMaster.setPrintOperatorNo("");
                            outpRcptMaster.setPrintDateTime(null);

                            //2.门诊病人支付方式记录 OUTP_PAYMENTS_MONEY
                            OutpPaymentsMoney opm = new OutpPaymentsMoney();
                            opm.setRcptNo(rcptNo);
                            opm.setPaymentNo((short) 1);
                            opm.setMoneyType(StringUtil.Utf_Iso("线上支付"));
                            opm.setPaymentAmount(new BigDecimal(payAmt));
                            opm.setRefundedAmount(BigDecimal.valueOf(0));
                            opm.setPrepayNo("");


                            //3.开单记录 OUTP_ORDER_DESC
                            OutpOrderDesc outpOrderDesc = new OutpOrderDesc();
                            outpOrderDesc.setVisitDate(new Timestamp(DateToWeek.formatDate(payTime,"yyyy-MM-dd HH:mm:ss").getTime()));
                            outpOrderDesc.setVisitNo(outpOrdersT.getVisitNo());
                            outpOrderDesc.setPatientId(clinicMaster.getPatientId());
                            //判断是否含药品处方
                            List<OutpOrdersCosts> outpOrdersCostsForPresc = outpOrdersCostsMapper.selectOrdersCostsListForPresc(hisPayNo);
                            if(Util.isEmpty(outpOrdersCostsForPresc)){
                                outpOrderDesc.setPrescIndicator((short) 0);
                            }else{
                                outpOrderDesc.setPrescIndicator((short) 1);
                            }

                            outpOrderDesc.setOrderedByDept(outpOrdersT.getOrderedBy());
                            outpOrderDesc.setOrderedByDoctor(outpOrdersT.getDoctor());
                            outpOrderDesc.setRcptNo(rcptNo);
                            outpOrderDesc.setVisitId(null);

                            outpOrderDescMapper.insert(outpOrderDesc);
                            outpRcptMasterMapper.insert(outpRcptMaster);
                            outpPaymentsMoneyMapper.insert(opm);


                            //4.门诊病人诊疗费用项目 OUTP_BILL_ITEMS
                            for (int i=0;i<outpOrdersCostsList.size();i++){
                                OutpOrdersCosts outpOrdersCosts =  outpOrdersCostsList.get(i);
                                OutpBillItems outpBillItems = new OutpBillItems();
                                outpBillItems.setVisitDate(new Timestamp(DateToWeek.formatDate(payTime,"yyyy-MM-dd HH:mm:ss").getTime()));
                                outpBillItems.setVisitNo(clinicMaster.getVisitNo());
                                outpBillItems.setRcptNo(rcptNo);
                                int k=i+1;
                                outpBillItems.setItemNo((short)k);
                                outpBillItems.setItemClass(outpOrdersCosts.getItemClass());
                                outpBillItems.setClassOnRcpt(outpOrdersCosts.getOrderClass());
                                outpBillItems.setItemCode(outpOrdersCosts.getItemCode());
                                outpBillItems.setItemName(outpOrdersCosts.getItemName());
                                outpBillItems.setItemSpec(outpOrdersCosts.getItemSpec());
                                outpBillItems.setAmount(outpOrdersCosts.getAmount());
                                outpBillItems.setUnits(outpOrdersCosts.getUnits());
                                //配置中的代码 走特定的执行地点
                                File file = new File("C:\\configuration\\itemCode.txt");
                                String itemCode = txt2String(file);
                                if(itemCode!=null && itemCode.length()>0) {
                                    if (itemCode.contains(outpOrdersCosts.getItemCode())) {
                                        outpBillItems.setPerformedBy("31");
                                    }else{
                                        outpBillItems.setPerformedBy(outpOrdersCosts.getPerformedBy());
                                    }
                                }else{
                                    outpBillItems.setPerformedBy(outpOrdersCosts.getPerformedBy());
                                }
                                outpBillItems.setCosts(outpOrdersCosts.getCosts());
                                outpBillItems.setCharges(outpOrdersCosts.getCharges());

                                outpBillItemsMapper.insert(outpBillItems);
                            }
                            //5.门诊微信交易记录
                            InternetPayinfo internetPayinfo  = new InternetPayinfo();
                            internetPayinfo.setTradeNo(webPayNo);
                            internetPayinfo.setRecptNo(rcptNo);
                            internetPayinfo.setPatientId(clinicMaster.getPatientId());
                            internetPayinfo.setChangeDateTime(new Timestamp(DateToWeek.formatDate(payTime,"yyyy-MM-dd HH:mm:ss").getTime()));
                            internetPayinfo.setInoutFlag("o");
                            internetPayinfo.setPayMethod(StringUtil.Utf_Iso(payMethod));
                            internetPayinfo.setMchId(mchid);

                            internetPayinfoMapper.insert(internetPayinfo);

                            outpOrdersCostsMapper.updateIndicatorBySerialNo(hisPayNo,rcptNo);

                        }
                        String deptLocation = deptDictMapper.selectDeptLocation(rcptNo).getDeptLocation();
                        Document doc = DocumentHelper.createDocument();
                        doc.setXMLEncoding("GBK");
                        Element rootR  = doc.addElement("response");
                        Element head = rootR.addElement("head");
                        head.addElement("result").setText("0");
                        head.addElement("desc").setText("[支付确认成功]");
                        Element body  = rootR.addElement("body");
                        body.addElement("fph").setText(rcptNo);
                        if(deptLocation!=null){
                            body.addElement("guideInfo").setText(StringUtil.Iso_GBK(deptLocation));
                        }else{
                            body.addElement("guideInfo").setText("");
                        }
                        logger.info(doc.asXML());
                        result = doc.asXML();

                    }else{
                        result = getErrorMsg("[该单据金额不对或流水号为空！！！]");
                    }
                }else{
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element rootR  = doc.addElement("response");
                    Element head = rootR.addElement("head");
                    head.addElement("result").setText("0");
                    head.addElement("desc").setText("[该单据已经支付完毕]");
                    logger.info(doc.asXML());
                    result = doc.asXML();
                }

            }else if ("queue_comm_HisPayStatus".equals(key)){
                String hisPayNo = root.element("body").element("hisPayNo").getText();
                String payTradeNo = root.element("body").element("payTradeNo").getText();
                String payMethod = root.element("body").element("payMethod").getText();
                if(!Util.isEmpty(hisPayNo)){
                    InternetPayinfo internetPayinfo = internetPayinfoMapper.selectByPrimaryKey(payTradeNo);
                    if(internetPayinfo!=null){
                        Document doc = DocumentHelper.createDocument();
                        doc.setXMLEncoding("GBK");
                        Element rootR  = doc.addElement("response");
                        Element head = rootR.addElement("head");
                        head.addElement("result").setText("0");
                        head.addElement("desc").setText("[支付确认成功]");
                        Element body  = rootR.addElement("body");
                        body.addElement("fph").setText(internetPayinfo.getRecptNo());
                        String deptLocation = deptDictMapper.selectDeptLocation(internetPayinfo.getRecptNo()).getDeptLocation();
                        if(deptLocation!=null){
                            body.addElement("guideInfo").setText(StringUtil.Iso_GBK(deptLocation));
                        }else{
                            body.addElement("guideInfo").setText("");
                        }
                        logger.info(doc.asXML());
                        result = doc.asXML();
                    }else{
                        return  getErrorMsg("无支付记录！！！");
                    }
                }else{
                    return  getErrorMsg("支付流水号为空！！！");
                }
            }else if("queue_comm_queryMedicineInfo".equals(key)){ //查询取药状态
                String payTradeNo = root.element("body").element("payTradeNo").getText();//微信交易流水号
                if(payTradeNo!=null && payTradeNo.length()>0){
                    InternetPayinfo internetPayinfo = internetPayinfoMapper.selectByPrimaryKey(payTradeNo);
                    if(internetPayinfo!=null){
                        if(internetPayinfo.getRecptNo()!=null && internetPayinfo.getRecptNo().length()>0){
                            List<OutpOrdersCosts> outpOrdersCostList = outpOrdersCostsMapper.selectOrdersCostsListByRecptNo(internetPayinfo.getRecptNo());
                            if(outpOrdersCostList!=null && outpOrdersCostList.size()>0){
                                Document doc = DocumentHelper.createDocument();
                                doc.setXMLEncoding("GBK");
                                Element rootR  = doc.addElement("response");
                                Element head = rootR.addElement("head");
                                head.addElement("result").setText("0");
                                head.addElement("desc").setText("[查询成功]");
                                Element body  = rootR.addElement("body");
                                body.addElement("trade_no").setText(internetPayinfo.getTradeNo());
                                for(int i=0;i<outpOrdersCostList.size();i++){
                                    Element details =  body.addElement("details");
                                    OutpOrdersCosts outpOrdersCosts = outpOrdersCostList.get(i);
                                    DrugPrescDetailTemp drugPrescDetailTemp = new DrugPrescDetailTemp();
                                    drugPrescDetailTemp.setPrescDate(outpOrdersCosts.getVisitDate());
                                    drugPrescDetailTemp.setPrescNo(outpOrdersCosts.getVisitNo());
                                    drugPrescDetailTemp.setItemNo(outpOrdersCosts.getItemNo());
                                    DrugPrescDetailTemp dpdt = drugPrescDetailTempMapper.selectByPrimaryKey(drugPrescDetailTemp);
                                    String excuteStatue ="0";//未执行
                                    if(dpdt==null){
                                        excuteStatue="1"; //已执行
                                    }
                                    details.addElement("item_name").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemName()));
                                    details.addElement("excute_statue").setText(excuteStatue);
                                    details.addElement("std").setText(StringUtil.Iso_GBK(outpOrdersCosts.getAmount()+""));
                                }
                                logger.info(doc.asXML());
                                result = doc.asXML();
                            }else{
                                return  getErrorMsg("无支付记录！！！");
                            }
                        }
                    }else{
                        return  getErrorMsg("无支付记录！！！");
                    }
                }else{
                    return  getErrorMsg("支付流水号为空！！！");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
        return result;
    }

    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    private String getClientInfo() {
        String clientIP = null;
        try {
            MessageContext mc = wsContext.getMessageContext();
            HttpServletRequest request = (HttpServletRequest) (mc.get(MessageContext.SERVLET_REQUEST));
            clientIP = request.getRemoteAddr();
            System.out.println("client IP : " + clientIP);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientIP;
    }
    private String getErrorMsg(String desc){
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("GBK");
        Element root  = document.addElement("response");
        Element head = root.addElement("head");
        head.addElement("result").setText("1");
        head.addElement("desc").setText(desc);
        logger.info(document.asXML());
        return document.asXML();
    }
}
