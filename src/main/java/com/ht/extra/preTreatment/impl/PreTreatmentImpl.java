package com.ht.extra.preTreatment.impl;

import com.haitaiinc.Util;
import com.ht.extra.dao.*;
import com.ht.extra.njyb.SiInDJParamInfo;
import com.ht.extra.njyb.SiReadCardInfo;
import com.ht.extra.njyb.SiSettlementInParamInfo;
import com.ht.extra.njyb.SiSettlementOutParamInfo;
import com.ht.extra.pojo.comm.AppConfigerParameter;
import com.ht.extra.pojo.comm.AppConfigerParameterKey;
import com.ht.extra.pojo.comm.DeptDict;
import com.ht.extra.pojo.inpbill.PayOrderRecord;
import com.ht.extra.pojo.insurance.*;
import com.ht.extra.pojo.medrec.PatMasterIndex;
import com.ht.extra.pojo.outpadm.*;
import com.ht.extra.preTreatment.PreTreatment;
import com.ht.extra.util.DateToWeek;
import com.ht.extra.util.StringUtil;
import com.ht.extra.util.SiClassUtil;
import org.apache.log4j.Logger;
import org.dom4j.*;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Dell on 2016/12/13.
 */
public class PreTreatmentImpl implements PreTreatment{
    private static Logger logger = Logger.getLogger(PreTreatmentImpl.class);

    @Resource
    private InpatientMapper inpatientMapper;
    @Resource
    private DeptDictMapper deptDictMapper;
    @Resource
    private ClinicIndexMapper clinicIndexMapper;
    @Resource
    private ClinicScheduleMapper clinicScheduleMapper;
    @Resource
    private ClinicForRegistMapper clinicForRegistMapper;
    @Resource
    private PatMasterIndexMapper patMasterIndexMapper;
    @Resource
    private ClinicMasterMapper clinicMasterMapper;
    @Resource
    private ClinicAppointsMapper clinicAppointsMapper;
    @Resource
    private PayOrderRecordMapper payOrderRecordMapper;
    @Resource
    private  ScanPayMapper scanPayMapper;
    @Resource
    private RecpNoMapper recpNoMapper;
    @Resource
    private ClinicForRegistStopMapper clinicForRegistStopMapper;
    @Resource
    private InsuranceAccountsNjjbMapper insuranceAccountsNjjbMapper;
    @Resource
    private  Njjb2100Mapper njjb2100Mapper;
    @Resource
    private  NjjbReg2210Mapper njjbReg2210Mapper;
    @Resource
    private  NjjbReg2310Mapper njjbReg2310Mapper;
    @Resource
    private  NjjbReg2420Mapper njjbReg2420Mapper;
    @Resource
    private  NjjbReg2410Mapper njjbReg2410Mapper;
    @Resource
    private  AppConfigerParameterMapper appConfigerParameterMapper;
    @Resource
    private  BankTradeLogMapper bankTradeLogMapper;


    @Resource
    private WebServiceContext wsContext;

    @Override
    public String queryHosBase(String XmlParam) {
        try {
            logger.info("[查询医院信息  入参 :]"+XmlParam);
            Document document = DocumentHelper.parseText(XmlParam);
            Element root = document.getRootElement();
            String unitld = root.element("data").element("unitId").getTextTrim();
            System.out.println(unitld);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.getHospitalMsg();
    }

    @Override
    public String queryDept(String XmlParam){
        logger.info("[查询科室信息  入参 :]"+XmlParam);
        //DeptDict dds = deptDictMapper.selectByPrimaryKey("123");
        List<DeptDict> deptDicts = deptDictMapper.selectByAllByMZ();
        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("GBK");
        Element root = doc.addElement("response");
        Element header = root.addElement("header");
        Element data = root.addElement("data");
        header.addElement("code").setText("0");
        header.addElement("desc").setText("成功");
        if(deptDicts !=null && deptDicts.size()>0){
            for(DeptDict dd : deptDicts){
                Element list =data.addElement("list");
                list.addElement("depId").setText(dd.getDeptCode());
                list.addElement("depName").setText(StringUtil.Iso_GBK(dd.getDeptName()));
                list.addElement("depIntro").setText("");
            }
        }
        logger.info(doc.asXML());
        return doc.asXML();
    }

    /**
     * 查询门诊号别定义表中的对应科室的医生，去掉医生是空的情况（普通号）
     * @param XmlParam
     * @return
     */
    @Override
    public String queryDoctor(String XmlParam) {
        logger.info("[查询医生信息  入参 :]"+XmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            String depId = reroot.element("data").element("depId").getTextTrim();
            List<ClinicIndex> clinicIndices = clinicIndexMapper.selectByDept(depId);
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root = doc.addElement("response");
            Element header = root.addElement("header");
            Element data = root.addElement("data");
            header.addElement("code").setText("0");
            header.addElement("desc").setText("成功");
            if(clinicIndices !=null && clinicIndices.size()>0){
                for(ClinicIndex ci : clinicIndices){
                    if(ci.getDoctor() !=null && ci.getDoctor().length()>0){
                        Element list = data.addElement("list");
                        list.addElement("docId").setText(StringUtil.Iso_GBK(ci.getDoctor()));
                        list.addElement("docName").setText(StringUtil.Iso_GBK(ci.getDoctor()));
                        list.addElement("docTitle").setText(StringUtil.Iso_GBK(ci.getDoctorTitleDict().getTitleName()));
                        list.addElement("docSex").setText("0");
                    }
                }
            }
            logger.info(doc.asXML());
            return doc.asXML();
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 通过科室号，或者医生查询排班，时间段内的所有排班（数据源是星期，直接转换成星期查询）主键 用号别^星期^午别
     * 现在挂号中没有挂号金额，amt；挂号中没有已预约数目。
     * timeType 多出白天：day；昼夜：all
     * @param XmlParam
     * @return
     */
//    @Override
//    public String querySchedule(String XmlParam) {
//        logger.info("[查询排班信息  入参 :]"+XmlParam);
//        Document document = null;
//        try {
//            document = DocumentHelper.parseText(XmlParam);
//            Element reroot = document.getRootElement();
//            String depId = reroot.element("data").element("depId").getTextTrim();
//            String docId = reroot.element("data").element("docId").getTextTrim();
//            String startDate = reroot.element("data").element("startDate").getTextTrim();
//            String endDate = reroot.element("data").element("endDate").getTextTrim();
//            List<ClinicSchedule> clinicSchedules = null;
//            DeptDict deptDict = deptDictMapper.selectByPrimaryKey(depId);
//            if(docId !=null && ! "".equals(docId)){
//                clinicSchedules = clinicScheduleMapper.selectByDeptAndDocIdForSchedule(depId,StringUtil.Utf_Iso(docId));
//            }else{
//                clinicSchedules = clinicScheduleMapper.selectByDeptForSchedule(depId);
//            }
//            LinkedHashMap<String,String> linkedHashMap = DateToWeek.forDateToWeek(startDate,endDate);
//            Document doc = DocumentHelper.createDocument();
//            doc.setXMLEncoding("GBK");
//            Element root = doc.addElement("response");
//            Element header = root.addElement("header");
//            Element data = root.addElement("data");
//            header.addElement("code").setText("0");
//            header.addElement("desc").setText("成功");
//            Iterator iterator = linkedHashMap.entrySet().iterator();
//            while(iterator.hasNext()){
//                Map.Entry<String,String> entry = (Map.Entry<String,String>)iterator.next();
//                String date = entry.getKey();
//                String week = entry.getValue();
//                if(clinicSchedules !=null && clinicSchedules.size()>0){
//                    for(ClinicSchedule clinicSchedule : clinicSchedules){
//                        if(week.equals(clinicSchedule.getDayOfWeek().toString())){
//                            ClinicIndex clinicIndex = clinicSchedule.getClinicIndex();
//                            //开放急诊的排班接口
////                            if(clinicIndex.getClinicType()!=null && "急诊".equals(StringUtil.Iso_GBK(clinicIndex.getClinicType()))){
////                                continue;
////                            }
//                            String timeDesc = getTimeDescEng(StringUtil.Iso_GBK(clinicSchedule.getTimeDesc()));
//                            Element list = data.addElement("list");
//                            list.addElement("schId").setText(StringUtil.Iso_GBK(clinicSchedule.getClinicLabel())+"^"+clinicSchedule.getDayOfWeek().toString()+"^"+timeDesc+"^"+date);
//                            list.addElement("clinicLabel").setText(StringUtil.Iso_GBK(clinicSchedule.getClinicLabel())); //号别
//                            list.addElement("visitDate").setText(date);
//                            list.addElement("timeDesc").setText(StringUtil.Iso_GBK(clinicSchedule.getTimeDesc()));////上午 下午 白天 昼夜
//                            list.addElement("depId").setText(depId);
//                            list.addElement("depName").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
//                            list.addElement("docId").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor()));
//                            list.addElement("docName").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor()));
//                            list.addElement("schDate").setText(date);
//                            ClinicForRegistStopKey clinicForRegistStopKey = new ClinicForRegistStopKey();
//                            clinicForRegistStopKey.setClinicDate(DateToWeek.formatDate(date,"yyyy-MM-dd"));
//                            clinicForRegistStopKey.setClinicLabel(clinicSchedule.getClinicLabel());
//                            clinicForRegistStopKey.setTimeDesc(clinicSchedule.getTimeDesc());
//                            ClinicForRegistStop clinicForRegistStop = clinicForRegistStopMapper.selectByPrimaryKey(clinicForRegistStopKey);
//                            if(clinicForRegistStop !=null && clinicForRegistStopKey.getClinicLabel()!=null && clinicForRegistStopKey.getClinicLabel().length()>0){
//                                list.addElement("flag").setText("-1");
//                            }else{
//                                list.addElement("flag").setText("1");
//                            }
//                            list.addElement("timeType").setText(timeDesc);
//                            list.addElement("levelName").setText(StringUtil.Iso_GBK(clinicIndex.getClinicType()));
//                            if(clinicSchedule.getPrice()!=null){
//                                list.addElement("amt").setText(clinicSchedule.getPrice().toString());
//                            }else{
//                                list.addElement("amt").setText("0");
//                            }
//
//                            List<ClinicForRegist> clinicForRegistList = clinicForRegistMapper.selectByClinicLabel(clinicIndex.getClinicLabel(),date);
//                            if(clinicForRegistList!=null && clinicForRegistList.size()>0){
//                                if(clinicSchedule.getAppointmentLimits()!=null){
//                                    list.addElement("srcMax").setText(clinicSchedule.getAppointmentLimits().toString());
//                                }else{
//                                    list.addElement("srcMax").setText("100");
//                                }
//                            }else{
//                                list.addElement("srcMax").setText("0");
//                            }
//
//                            list.addElement("srcNum").setText("");
//                        }
//                    }
//                }
//            }
//            return doc.asXML();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return this.getErrorlMsg("数据出错");
//        }
//    }

    /**
     *  通过ClinicForRegist生成排班，可以解决临时增加的排班
     *  通过科室号，或者医生查询排班，时间段内的所有排班（数据源是星期，直接转换成星期查询）主键 用号别^星期^午别
     *  现在挂号中没有挂号金额，amt；挂号中没有已预约数目。
     *  timeType 多出白天：day；昼夜：all
     * @param XmlParam
     * @return
     */
    @Override
    public String querySchedule(String XmlParam) {
        logger.info("[查询排班信息（按照号源查询）  入参 :]"+XmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            String depId = reroot.element("data").element("depId").getTextTrim();
            String docId = reroot.element("data").element("docId").getTextTrim();
            String startDate = reroot.element("data").element("startDate").getTextTrim();
            String endDate = reroot.element("data").element("endDate").getTextTrim();
            List<ClinicForRegist> clinicForRegists = null;
            DeptDict deptDict = deptDictMapper.selectByPrimaryKey(depId);
            if(docId !=null && ! "".equals(docId)){
                clinicForRegists = clinicForRegistMapper.selectByDeptAndDocIdForRegist(depId,StringUtil.Utf_Iso(docId),startDate,endDate);
            }else{
                clinicForRegists = clinicForRegistMapper.selectByDeptForRegist(depId,startDate,endDate);
            }
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root = doc.addElement("response");
            Element header = root.addElement("header");
            Element data = root.addElement("data");
            header.addElement("code").setText("0");
            header.addElement("desc").setText("成功");
            if(clinicForRegists!=null && clinicForRegists.size()>0) {
                for (ClinicForRegist clinicForRegist : clinicForRegists) {
                    Element list = data.addElement("list");
                    String date = DateToWeek.formatDateString(clinicForRegist.getClinicDate(),"yyyy-MM-dd");
                    String clinicWeek = DateToWeek.getWeek(clinicForRegist.getClinicDate());
                    String timeDesc = getTimeDescEng(StringUtil.Iso_GBK(clinicForRegist.getTimeDesc()));
                    ClinicIndex clinicIndex = clinicIndexMapper.selectByPrimaryKey(clinicForRegist.getClinicLabel());
                    list.addElement("schId").setText(StringUtil.Iso_GBK(clinicForRegist.getClinicLabel()) + "^" + clinicWeek + "^" + timeDesc + "^" + date);
                    list.addElement("clinicLabel").setText(StringUtil.Iso_GBK(clinicForRegist.getClinicLabel())); //号别
                    list.addElement("visitDate").setText(date);
                    list.addElement("timeDesc").setText(StringUtil.Iso_GBK(clinicForRegist.getTimeDesc()));////上午 下午 白天 昼夜
                    list.addElement("depId").setText(depId);
                    list.addElement("depName").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                    list.addElement("docId").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor()));
                    list.addElement("docName").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor()));
                    list.addElement("schDate").setText(date);
                    ClinicForRegistStopKey clinicForRegistStopKey = new ClinicForRegistStopKey();
                    clinicForRegistStopKey.setClinicDate(DateToWeek.formatDate(date, "yyyy-MM-dd"));
                    clinicForRegistStopKey.setClinicLabel(clinicForRegist.getClinicLabel());
                    clinicForRegistStopKey.setTimeDesc(clinicForRegist.getTimeDesc());
                    ClinicForRegistStop clinicForRegistStop = clinicForRegistStopMapper.selectByPrimaryKey(clinicForRegistStopKey);
                    if (clinicForRegistStop != null && clinicForRegistStopKey.getClinicLabel() != null && clinicForRegistStopKey.getClinicLabel().length() > 0) {
                        list.addElement("flag").setText("-1");
                    } else {
                        list.addElement("flag").setText("1");
                    }
                    list.addElement("timeType").setText(timeDesc);
                    list.addElement("levelName").setText(StringUtil.Iso_GBK(clinicIndex.getClinicType()));
                    if (clinicIndex.getPrice() != null) {
                        list.addElement("amt").setText(clinicIndex.getPrice().toString());
                    } else {
                        list.addElement("amt").setText("0");
                    }

                    List<ClinicForRegist> clinicForRegistList = clinicForRegistMapper.selectByClinicLabel(clinicIndex.getClinicLabel(), date);
                    if (clinicForRegistList != null && clinicForRegistList.size() > 0) {
                        if (clinicForRegist.getAppointmentLimits() != null) {
                            list.addElement("srcMax").setText(clinicForRegist.getAppointmentLimits().toString());
                        } else {
                            list.addElement("srcMax").setText("100");
                        }
                    } else {
                        list.addElement("srcMax").setText("0");
                    }

                    list.addElement("srcNum").setText("");
                }
            }
            return doc.asXML();
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 查询停诊列表
     * @param XmlParam
     * @return
     */
    @Override
    public String queryStopSch(String XmlParam ){
        logger.info("[查询停诊列表  入参 :]"+XmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            String schDate = reroot.element("data").element("schDate").getTextTrim();
            if(schDate!=null && schDate.length()>0){
                List<ClinicForRegistStop> clinicForRegistStops = clinicForRegistStopMapper.selectByClinicDate(schDate);
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root = doc.addElement("response");
                Element header = root.addElement("header");
                Element data = root.addElement("data");
                header.addElement("code").setText("0");
                header.addElement("desc").setText("成功");
                if(clinicForRegistStops!=null && clinicForRegistStops.size()>0){
                    for (ClinicForRegistStop clinicForRegistStop : clinicForRegistStops) {
                        Element list = data.addElement("list");
                        String date = DateToWeek.formatDateString(clinicForRegistStop.getClinicDate(),"yyyy-MM-dd");
                        String clinicWeek = DateToWeek.getWeek(clinicForRegistStop.getClinicDate());
                        String timeDesc = getTimeDescEng(StringUtil.Iso_GBK(clinicForRegistStop.getTimeDesc()));
                        list.addElement("schId").setText(StringUtil.Iso_GBK(clinicForRegistStop.getClinicLabel()) + "^" + clinicWeek + "^" + timeDesc + "^" + date);
                        list.addElement("schDate").setText(date);
                        list.addElement("timeType").setText(timeDesc);
                    }
                }
                return doc.asXML();
            }else{
                return this.getErrorlMsg("入参为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }
    /**
     * 通过排班数据查询号源信息。只能通过号类和星期查出对应的号源信息
     * @param XmlParam
     * @return
     */
    @Override
    public String querySource(String XmlParam) {
        logger.info("[查询号源信息  入参 :]"+XmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            String schId = reroot.element("data").element("schId").getTextTrim();
            String clinicLabel = schId.split("\\^")[0];
            String week = schId.split("\\^")[1];
            String timeDesc = schId.split("\\^")[2];
            String time = schId.split("\\^")[3];
            if("am".equals(timeDesc)){
                timeDesc = "上午";
            }else if("pm".equals(timeDesc)){
                timeDesc = "下午";
            }else if("day".equals(timeDesc)){
                timeDesc = "白天";
            }else{
                timeDesc = "昼夜";
            }
            List<ClinicForRegist> clinicForRegistList = clinicForRegistMapper.selectByClinicLabel(StringUtil.Utf_Iso(clinicLabel),time);
            if(Util.isEmpty(clinicForRegistList)){
                return getErrorlMsg("未查询到号源信息");
            }
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root = doc.addElement("response");
            Element header = root.addElement("header");
            Element data = root.addElement("data");
            header.addElement("code").setText("0");
            header.addElement("desc").setText("成功");
            if(clinicForRegistList != null && clinicForRegistList.size()>0){
                for(ClinicForRegist clinicForRegist : clinicForRegistList){
                    //排班中，午别与号源中的午别不一致 是否需要修改
//                    if(timeDesc.equals(StringUtil.Iso_GBK(clinicForRegist.getTimeDesc()))){
//                        continue;
//                    }
                    String clinicWeek = DateToWeek.getWeek(clinicForRegist.getClinicDate());
                    if(clinicWeek.equals(week)){
                        String clinicDate = DateToWeek.formatDateString(clinicForRegist.getClinicDate(),"yyyy-MM-dd");
                        Element list = data.addElement("list");
                        list.addElement("schId").setText(schId);
                        list.addElement("srcId").setText(clinicDate);
                        if("上午".equals(StringUtil.Iso_GBK(clinicForRegist.getTimeDesc()))){
                            list.addElement("beginTime").setText("07:30");
                            list.addElement("endTime").setText("11:30");
                        }else  if("下午".equals(StringUtil.Iso_GBK(clinicForRegist.getTimeDesc()))){
                            list.addElement("beginTime").setText("13:30");
                            list.addElement("endTime").setText("16:30");
                        }else  if("白天".equals(StringUtil.Iso_GBK(clinicForRegist.getTimeDesc()))){
                            list.addElement("beginTime").setText("07:30");
                            list.addElement("endTime").setText("16:30");
                        }else{
                            list.addElement("beginTime").setText("00:00");
                            list.addElement("endTime").setText("24:00");
                        }
                        if(clinicForRegist.getAppointmentLimits()!=null){
                            list.addElement("srcMax").setText(clinicForRegist.getAppointmentLimits().toString());
                        }else{
                            list.addElement("srcMax").setText("100");
                        }
                        if(clinicForRegist.getAppointmentNum()!=null){
                            list.addElement("srcNum").setText(clinicForRegist.getAppointmentNum().toString());
                        }else{
                            list.addElement("srcNum").setText("0");
                        }
                    }
                }
            }
            return doc.asXML();
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    @Override
    @Transactional
    public String addOrder(String XmlParam) {
        logger.info("[预约信息  入参 :]"+XmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            //号别+星期+午别
            String schId = reroot.element("data").element("schId").getTextTrim();
            //日期
            String srcId = reroot.element("data").element("srcId").getTextTrim();
            //patient_id
            String clinicNo = reroot.element("data").element("clinicNo").getTextTrim();
            String trueName = reroot.element("data").element("trueName").getTextTrim();
            String clinicLabel = schId.split("\\^")[0];
            String timeDesc = schId.split("\\^")[2];
            if("am".equals(timeDesc)){
                timeDesc = "上午";
            }else if("pm".equals(timeDesc)){
                timeDesc = "下午";
            }else if("day".equals(timeDesc)){
                timeDesc = "白天";
            }else{
                timeDesc = "昼夜";
            }
            if(clinicNo == null || "".equals(clinicNo)){
                return this.getErrorlMsg("clinicNO不能为空");
            }
            PatMasterIndex pmi = patMasterIndexMapper.selectByPrimaryKey(clinicNo);
            if(!trueName.equals(StringUtil.Iso_GBK(pmi.getName()))){
                return this.getErrorlMsg("病人信息不一致");
            }
            Date nowdate = new Date();
            //String dataString = DateToWeek.formatDateString(nowdate,"yyyyMMddHHmmss");
            ClinicForRegistKey cfrk = new ClinicForRegistKey();
            cfrk.setClinicDate(DateToWeek.formatDate(srcId,"yyyy-MM-dd"));
            cfrk.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
            cfrk.setTimeDesc(StringUtil.Utf_Iso(timeDesc));
            ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfrk);
            if(clinicForRegist==null){
                return getErrorlMsg("未查询到号源信息");
            }
            if(clinicForRegist.getAppointmentNum()!=null){
                clinicForRegist.setAppointmentNum((short)(1+clinicForRegist.getAppointmentNum()));
            }else{
                clinicForRegist.setAppointmentNum((short)1);
            }
            ClinicAppoints clinicAppoints = new ClinicAppoints();
            clinicAppoints.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
            clinicAppoints.setPatientId(pmi.getPatientId());
            clinicAppoints.setVisitDateAppted(DateToWeek.formatDate(srcId,"yyyy-MM-dd"));
            clinicAppoints.setVisitTimeAppted(StringUtil.Utf_Iso(timeDesc));
            clinicAppoints.setApptMadeDate(nowdate);
            clinicAppoints.setClinicSource("sz160");
            clinicAppoints.setClinicAttr("0");
            //预约后当前号加一，当前号默认被预约
            if(clinicForRegist.getCurrentNo()!=null){
                clinicAppoints.setSerialNo(clinicForRegist.getCurrentNo());
                clinicForRegist.setCurrentNo((short)(1+clinicForRegist.getCurrentNo()));
            }else{
                clinicForRegist.setCurrentNo((short)1);
                clinicAppoints.setSerialNo((short)1);
            }
            if(clinicForRegist.getAppointmentLimits()!=null && clinicForRegist.getAppointmentLimits()>0){
                List<ClinicAppoints>  clinicAppointsList = clinicAppointsMapper.selectApponints(clinicAppoints.getVisitDateAppted(),clinicAppoints.getClinicLabel());
                logger.info("[预约信息  入参 :]"+clinicForRegist.getAppointmentLimits());
                if(clinicAppointsList!=null && clinicAppointsList.size()>0){
                    if(clinicAppointsList.size()>= clinicForRegist.getAppointmentLimits()){
                        return getErrorlMsg("当前号源已被预约完！！！");
                    }
                }
            }
            ClinicAppointsKey clinicAppointsKey = new ClinicAppointsKey();
            clinicAppointsKey.setVisitTimeAppted(clinicAppoints.getVisitTimeAppted());
            clinicAppointsKey.setVisitDateAppted(clinicAppoints.getVisitDateAppted());
            clinicAppointsKey.setClinicLabel(clinicAppoints.getClinicLabel());
            clinicAppointsKey.setPatientId(clinicAppoints.getPatientId());
            ClinicAppoints clinicAppoints1 = clinicAppointsMapper.selectByPrimaryKey(clinicAppointsKey);
            if(clinicAppoints1 != null){
                return getErrorlMsg("已有预约信息，无法再次预约");
            }
            clinicForRegistMapper.updateByPrimaryKey(clinicForRegist);
            clinicAppointsMapper.insertSelective(clinicAppoints);
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root = doc.addElement("response");
            Element header = root.addElement("header");
            Element data = root.addElement("data");
            header.addElement("code").setText("0");
            header.addElement("desc").setText("成功");
            //预约订单号=主键：就诊日期、号别、病人标识号、午别。
            data.addElement("orderId").setText(srcId+"^"+clinicLabel+"^"+clinicNo+"^"+timeDesc);

            // add by tang 2018-06-21,返回记录新增serialNo
            data.addElement("orderNo").setText(clinicAppoints.getSerialNo()+"");
            data.addElement("hisTakeNo").setText("");
            return doc.asXML();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    @Override
    @Transactional
    public String cancelOrder(String XmlParam) {
        logger.info("[取消预约信息  入参 :]"+XmlParam);
        Document document = null;
        String result="";
        logger.info(" ----&gt; 获取客户端信息开始 &lt;---- ");
        String clientIP = getClientInfo();
        logger.info(" ----&gt; 获取客户端信息结束 &lt;---- ");
        logger.info("客户端IP地址："+clientIP);
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            //预约订单号=主键：就诊日期、号别、病人标识号、午别。
            String orderId = reroot.element("data").element("orderId").getTextTrim();
            logger.info("orderId--->"+orderId);
            if(orderId !=null && orderId.contains("^")){
                logger.info("orderId进入");
                ClinicAppointsKey clinicAppointsKey = new ClinicAppoints();
                clinicAppointsKey.setClinicLabel(StringUtil.Utf_Iso(orderId.split("\\^")[1]));
                clinicAppointsKey.setPatientId(orderId.split("\\^")[2]);
                clinicAppointsKey.setVisitDateAppted(DateToWeek.formatDate(orderId.split("\\^")[0],"yyyy-MM-dd"));
                clinicAppointsKey.setVisitTimeAppted(StringUtil.Utf_Iso(orderId.split("\\^")[3]));
                ClinicAppoints clinicAppoints = clinicAppointsMapper.selectByPrimaryKey(clinicAppointsKey);
                //2为取消。
                clinicAppoints.setClinicAttr("2");
                ClinicForRegistKey cfrk = new ClinicForRegistKey();
                cfrk.setClinicDate(DateToWeek.formatDate(orderId.split("\\^")[0],"yyyy-MM-dd"));
                cfrk.setClinicLabel(StringUtil.Utf_Iso(orderId.split("\\^")[1]));
                cfrk.setTimeDesc(StringUtil.Utf_Iso(orderId.split("\\^")[3]));
                ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfrk);
                if(clinicForRegist==null){
                    //return getErrorlMsg("未查询到号源信息");停诊的时候会导致无法查询。但是可退预约
                    clinicAppointsMapper.updateByPrimaryKey(clinicAppoints);
                    return getSuccessMsg("成功");
                }else{
                    if(clinicForRegist.getAppointmentNum()!=null){
                        clinicForRegist.setAppointmentNum((short)(clinicForRegist.getAppointmentNum()-1));
                    }else{
                        clinicForRegist.setAppointmentNum((short)1);
                    }
                    clinicForRegistMapper.updateByPrimaryKey(clinicForRegist);
                    clinicAppointsMapper.updateByPrimaryKey(clinicAppoints);
                    return getSuccessMsg("成功");
                }
            }else{
                return getErrorlMsg("orderID格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    public String queryOrder(String XmlParam) {
        logger.info("[查询预约  入参 :]"+XmlParam);
        Document document = null;
        String result="";
        logger.info(" ----&gt; 获取客户端信息开始 &lt;---- ");
        String clientIP = getClientInfo();
        logger.info(" ----&gt; 获取客户端信息结束 &lt;---- ");
        logger.info("客户端IP地址："+clientIP);
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            //预约订单号=主键：就诊日期、号别、病人标识号、午别。
            String orderId = reroot.element("data").element("orderId").getTextTrim();
            if(orderId !=null && orderId.contains("^")){
                ClinicAppointsKey clinicAppointsKey = new ClinicAppoints();
                clinicAppointsKey.setClinicLabel(StringUtil.Utf_Iso(orderId.split("\\^")[1]));
                clinicAppointsKey.setPatientId(orderId.split("\\^")[2]);
                clinicAppointsKey.setVisitDateAppted(DateToWeek.formatDate(orderId.split("\\^")[0],"yyyy-MM-dd"));
                clinicAppointsKey.setVisitTimeAppted(StringUtil.Utf_Iso(orderId.split("\\^")[3]));
                ClinicAppoints clinicAppoints = clinicAppointsMapper.selectByPrimaryKey(clinicAppointsKey);
                PatMasterIndex pmi = patMasterIndexMapper.selectByPrimaryKey(orderId.split("\\^")[2]);
                String clinicAttr = clinicAppoints.getClinicAttr();
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root = doc.addElement("response");
                Element header = root.addElement("header");
                Element data = root.addElement("data");
                header.addElement("code").setText("0");
                header.addElement("desc").setText("成功");
                data.addElement("orderId").setText(orderId);
                data.addElement("hisTakeNo").setText("");
                data.addElement("schId").setText(orderId.split("\\^")[1]+"^"+DateToWeek.getWeek(clinicAppointsKey.getVisitDateAppted())+"^"+getTimeDescEng(orderId.split("\\^")[3]));
                data.addElement("srcId").setText(orderId.split("\\^")[0]);
                data.addElement("trueName").setText(StringUtil.Iso_GBK(pmi.getName()));
                data.addElement("cardNo").setText(StringUtil.Iso_GBK(pmi.getIdNo()));
                if(pmi.getPhoneNumberHome()!=null){
                    data.addElement("phone").setText(pmi.getPhoneNumberHome());
                }else{
                    data.addElement("phone").setText("");
                }
                if("0".equals(clinicAttr)){
                    data.addElement("status").setText("2");
                }else{
                    data.addElement("status").setText("1");
                }
                return doc.asXML();
            }else{
                return getErrorlMsg("orderID格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return getErrorlMsg("数据处理出错");
        }
    }

    @Override
    @Transactional
    public String payOrder(String XmlParam) {
        logger.info("[支付预约信息  入参 :]"+XmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            //预约订单号=主键：就诊日期、号别、病人标识号、午别。
            String orderId = reroot.element("data").element("orderId").getTextTrim();
            String tradeNo = reroot.element("data").element("third_recharge_id").getTextTrim();
            if(orderId !=null && orderId.contains("^")){
                String clinicLabel = orderId.split("\\^")[1];
                String patientID = orderId.split("\\^")[2];
                String visitDate = orderId.split("\\^")[0];
                String timeDesc = orderId.split("\\^")[3];
                PayOrderRecord payOrderRecord = new PayOrderRecord();
                ClinicAppointsKey clinicAppointsKey = new ClinicAppoints();
                clinicAppointsKey.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                clinicAppointsKey.setPatientId(patientID);
                clinicAppointsKey.setVisitDateAppted(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                clinicAppointsKey.setVisitTimeAppted(StringUtil.Utf_Iso(timeDesc));
                ClinicForRegistKey cfrk = new ClinicForRegistKey();
                cfrk.setClinicDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                cfrk.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                cfrk.setTimeDesc(StringUtil.Utf_Iso(timeDesc));
                ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfrk);
                ClinicAppoints clinicAppoints = clinicAppointsMapper.selectByPrimaryKey(clinicAppointsKey);
                PatMasterIndex pmi = patMasterIndexMapper.selectByPrimaryKey(patientID);
                if(pmi !=null && pmi.getChargeType()!=null && !"自费".equals(StringUtil.Iso_GBK(pmi.getChargeType()))){
                    return getErrorlMsg("非自费病人请至医院支付取号！");
                }
                ClinicIndex clinicIndex  = clinicIndexMapper.selectByPrimaryKey(StringUtil.Utf_Iso(clinicLabel));
                ClinicMaster clinicMaster = new ClinicMaster();
                clinicMaster.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                clinicMaster.setClinicLabel(clinicAppoints.getClinicLabel());
                clinicMaster.setVisitTimeDesc(clinicAppoints.getVisitTimeAppted());
                clinicMaster.setSerialNo(clinicAppoints.getSerialNo());
                clinicMaster.setPatientId(pmi.getPatientId());
                clinicMaster.setName(pmi.getName());
                clinicMaster.setNamePhonetic(pmi.getNamePhonetic());
                clinicMaster.setSex(pmi.getSex());
                if(pmi.getDateOfBirth()!=null){
                    int age =(new Date().getYear() - pmi.getDateOfBirth().getYear());
                    clinicMaster.setAge((short)age);
                }
                clinicMaster.setIdentity(pmi.getIdentity());
                clinicMaster.setChargeType(pmi.getChargeType());
                clinicMaster.setClinicType(clinicIndex.getClinicTypeName());
                if(clinicIndex!=null && clinicIndex.getDoctor()!=null){
                    clinicMaster.setDoctor(clinicIndex.getDoctor());
                }else{
                    clinicMaster.setDoctor("");
                }

                //初复诊判断
                clinicMaster.setFirstVisitIndicator((short)0);
                clinicMaster.setVisitDept(clinicIndex.getClinicDept());
                clinicMaster.setMrProvideIndicator((short)0);
                clinicMaster.setRegistrationStatus((short)1);
                clinicMaster.setRegisteringDate(new Timestamp(new Date().getTime()));
                clinicMaster.setClinicFee(clinicIndex.getPrice());
                clinicMaster.setRegistFee(new BigDecimal(0));
                clinicMaster.setOtherFee(new BigDecimal(0));
                clinicMaster.setClinicCharge(clinicIndex.getPrice());
                clinicMaster.setOperator("sz160");
                clinicMaster.setPayWay(3+"");
                clinicMaster.setAgeUnit(StringUtil.Utf_Iso("岁"));
                //clinicForRegist.setCurrentNo((short)(clinicForRegist.getCurrentNo()+1));
                if(clinicForRegist.getRegistrationNum()!=null){
                    clinicForRegist.setRegistrationNum((short)(clinicForRegist.getRegistrationNum()+1));
                }else{
                    clinicForRegist.setRegistrationNum((short)1);
                }
                //1为取号，当作支付成功。
                clinicAppoints.setClinicAttr("1");
                //更新最新可用号和当日已挂号
                clinicForRegistMapper.updateByPrimaryKeySelective(clinicForRegist);
                //更新预约中预约状态
                clinicAppointsMapper.updateByPrimaryKey(clinicAppoints);
                //   ClinicMaster clinicMasters = clinicMasterMapper.selectByVisitDate(clinicMaster.getVisitDate());
                String visitNo = generateVisitNo(clinicMaster.getVisitDate());
                clinicMaster.setVisitNo(Short.parseShort(visitNo));

                clinicMasterMapper.insert(clinicMaster);
                //支付记录
                payOrderRecord.setOrderId(StringUtil.Utf_Iso(orderId));
                payOrderRecord.setPatientId(patientID);
                payOrderRecord.setVisitDate(clinicMaster.getVisitDate());
                payOrderRecord.setVisitNo(clinicMaster.getVisitNo());
                payOrderRecord.setRecordTime(new Timestamp(new Date().getTime()));
                payOrderRecord.setTradeNo(tradeNo);
                payOrderRecordMapper.insertSelective(payOrderRecord);
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root = doc.addElement("response");
                Element header = root.addElement("header");
                Element data = root.addElement("data");
                header.addElement("code").setText("0");
                header.addElement("desc").setText("成功");
                data.addElement("visitId").setText(visitDate+"^"+clinicMaster.getVisitNo());
                return doc.asXML();
            }else{
                return getErrorlMsg("orderID格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    @Override
    @Transactional
    public String refundReg(String XmlParam) {
        logger.info("[取消预约订单信息  入参 :]"+XmlParam);
        Document document = null;
        String result="";
        logger.info(" ----&gt; 获取客户端信息开始 &lt;---- ");
        String clientIP = getClientInfo();
        logger.info(" ----&gt; 获取客户端信息结束 &lt;---- ");
        logger.info("客户端IP地址："+clientIP);
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            //支付订单visit_date id;
            String orderId = reroot.element("data").element("visitId").getTextTrim();
            String clinicNo = reroot.element("data").element("clinicNo").getTextTrim();
            logger.info("orderId---->"+orderId);
            if(orderId !=null && orderId.contains("^")){
                logger.info("orderId 进入");
                String visitDate = orderId.split("\\^")[0];
                String visidNo = orderId.split("\\^")[1];
                ClinicMasterKey clinicMasterKey = new ClinicMasterKey();
                clinicMasterKey.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                clinicMasterKey.setVisitNo(Short.parseShort(visidNo));
                ClinicMaster clinicMaster = clinicMasterMapper.selectByPrimaryKey(clinicMasterKey);
                ClinicForRegistKey cfrk = new ClinicForRegistKey();
                cfrk.setClinicDate(clinicMaster.getVisitDate());
                cfrk.setClinicLabel(clinicMaster.getClinicLabel());
                cfrk.setTimeDesc(clinicMaster.getVisitTimeDesc());
                ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfrk);
                PayOrderRecord payOrderRecord =payOrderRecordMapper.selectByVisitDateNo(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"),visidNo);
                if(clinicMaster!=null && payOrderRecord !=null ){
                    if(clinicNo.equals(clinicMaster.getPatientId())){
                        logger.info("orderId 进入");
                        if(clinicMaster.getRegistrationStatus()==(short)2){
                            return getErrorlMsg("已就诊无法取消！");
                        }else{

                                //clinicMaster.setRegistrationStatus((short)2);
                                clinicMaster.setReturnedDate(new Timestamp(new Date().getTime()));
                                clinicMaster.setReturnedOperator("sz160");
                                payOrderRecord.setIsReturn("Y");
                                if(clinicForRegist !=null) {
                                    //取消预约订单已挂号数量-1
                                    if (clinicForRegist.getRegistrationNum() != null) {
                                        clinicForRegist.setRegistrationNum((short) (clinicForRegist.getRegistrationNum() - 1));
                                    }
                                    clinicForRegistMapper.updateByPrimaryKey(clinicForRegist);
                                }
                                ClinicAppointsKey clinicAppointsKey = new ClinicAppoints();
                                clinicAppointsKey.setClinicLabel(clinicMaster.getClinicLabel());
                                clinicAppointsKey.setPatientId(clinicNo);
                                clinicAppointsKey.setVisitDateAppted(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                                clinicAppointsKey.setVisitTimeAppted(clinicMaster.getVisitTimeDesc());
                                ClinicAppoints clinicAppoints = clinicAppointsMapper.selectByPrimaryKey(clinicAppointsKey);
                                //1为取号，当作支付成功。
                                clinicAppoints.setClinicAttr("2");
                                //更新预约中预约状态
                                clinicAppointsMapper.updateByPrimaryKey(clinicAppoints);

                                payOrderRecordMapper.updateByPrimaryKey(payOrderRecord);
                                clinicMasterMapper.updateByPrimaryKey(clinicMaster);
                                return getSuccessMsg("取消成功");

                        }
                    }else{
                        return getErrorlMsg("订单号与对应人员不一致！");
                    }
                }else {
                    return getErrorlMsg("未查询到订单信息");
                }
            }else{
                return getErrorlMsg("orderID格式不正确");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    @Override
    public String queryChargeType(String XmlParam) {
        logger.info("[查询病人收费状态  入参 :]"+XmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(XmlParam);
            Element reroot = document.getRootElement();
            String patientID = reroot.element("body").element("patientID").getTextTrim();
            if(patientID !=null){

                PatMasterIndex pmi = patMasterIndexMapper.selectByPrimaryKey(patientID);

                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root = doc.addElement("response");
                Element header = root.addElement("header");
                Element data = root.addElement("data");
                header.addElement("code").setText("0");
                header.addElement("desc").setText("成功");
                if(pmi !=null && pmi.getChargeType()!=null){
                    data.addElement("chargeType").setText(StringUtil.Iso_GBK(pmi.getChargeType()));
                }else{
                    data.addElement("chargeType").setText("");
                }
                return doc.asXML();
            }else{
                return getErrorlMsg("请填写正确的病人id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    /**
     * 直接挂号 160 只能自费病人挂号  自助机无限制
     * @param xmlParam
     * @return
     */
    @Override
    @Transactional
    public String register(String xmlParam){
        logger.info("[直接挂号  入参 :]"+xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            //来源 S160 和 自助机
            String  sourceType = reroot.element("data").element("sourceType").getTextTrim();
            if (sourceType !=null && sourceType.length()>0 && "S160".equals(sourceType) ){
                //订单号=主键：就诊日期、号别、病人标识号、午别。
                String tradeNo = reroot.element("data").element("third_recharge_id").getTextTrim();
                String clinicLabel =  reroot.element("data").element("clinicLabel").getTextTrim();
                String patientID =  reroot.element("data").element("patientID").getTextTrim();
                String visitDate =  reroot.element("data").element("visitDate").getTextTrim();//yyyy-mm-dd
                String timeDesc =  reroot.element("data").element("timeDesc").getTextTrim(); //上午 下午 白天 昼夜
                String orderId =visitDate+"^"+clinicLabel+"^"+patientID+"^"+timeDesc;
                if(clinicLabel !=null && clinicLabel.length()>0){
                    PayOrderRecord payOrderRecord = new PayOrderRecord();
                    ClinicForRegistKey cfrk = new ClinicForRegistKey();
                    cfrk.setClinicDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                    cfrk.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                    cfrk.setTimeDesc(StringUtil.Utf_Iso(timeDesc));
                    ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfrk);
//                ClinicAppoints clinicAppoints = clinicAppointsMapper.selectByPrimaryKey(clinicAppointsKey);
                    if(clinicForRegist.getRegistrationLimits()!=null && clinicForRegist.getRegistrationLimits()>0){
                        List<ClinicAppoints>  clinicAppointsList = clinicAppointsMapper.selectRegesters(cfrk.getClinicDate(),cfrk.getClinicLabel());// 状态为0
                        List<ClinicMaster> clinicMasterList = clinicMasterMapper.selectRegesters(cfrk.getClinicDate(),cfrk.getClinicLabel());
                        int num =clinicAppointsList.size()+clinicMasterList.size();
                        if(num>0){
                            if(num >= (int)clinicForRegist.getRegistrationLimits()){
                                return getErrorlMsg("当日号已挂完！！！");
                            }
                        }
                    }
                    PatMasterIndex pmi = patMasterIndexMapper.selectByPrimaryKey(patientID);
                    if(pmi !=null && pmi.getChargeType()!=null && !"自费".equals(StringUtil.Iso_GBK(pmi.getChargeType()))){
                        return getErrorlMsg("非自费病人不可网上挂号！！！");
                    }
                    ClinicIndex clinicIndex  = clinicIndexMapper.selectByPrimaryKey(StringUtil.Utf_Iso(clinicLabel));
                    ClinicMaster clinicMaster = new ClinicMaster();
                    clinicMaster.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                    clinicMaster.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                    clinicMaster.setVisitTimeDesc(StringUtil.Utf_Iso(timeDesc));
                    clinicMaster.setSerialNo(clinicForRegist.getCurrentNo()); //
                    clinicMaster.setPatientId(pmi.getPatientId());
                    clinicMaster.setName(pmi.getName());
                    clinicMaster.setNamePhonetic(pmi.getNamePhonetic());
                    clinicMaster.setSex(pmi.getSex());
                    if(pmi.getDateOfBirth()!=null){
                        int age =(new Date().getYear() - pmi.getDateOfBirth().getYear());
                        clinicMaster.setAge((short)age);
                    }
                    clinicMaster.setIdentity(pmi.getIdentity());
                    clinicMaster.setChargeType(pmi.getChargeType());
                    clinicMaster.setClinicType(clinicIndex.getClinicTypeName());
                    if(clinicIndex!=null && clinicIndex.getDoctor()!=null){
                        clinicMaster.setDoctor(clinicIndex.getDoctor());
                    }else{
                        clinicMaster.setDoctor("");
                    }

                    //初复诊判断
                    clinicMaster.setFirstVisitIndicator((short)0);
                    clinicMaster.setVisitDept(clinicIndex.getClinicDept());
                    clinicMaster.setMrProvideIndicator((short)0);
                    clinicMaster.setRegistrationStatus((short)1);
                    clinicMaster.setRegisteringDate(new Timestamp(new Date().getTime()));
                    clinicMaster.setClinicFee(clinicIndex.getPrice());
                    clinicMaster.setRegistFee(new BigDecimal(0));
                    clinicMaster.setOtherFee(new BigDecimal(0));
                    clinicMaster.setClinicCharge(clinicIndex.getPrice());
                    clinicMaster.setOperator("sz160");
                    clinicMaster.setPayWay(3+"");
                    clinicMaster.setAgeUnit(StringUtil.Utf_Iso("岁"));
                    //clinicForRegist.setCurrentNo((short)(clinicForRegist.getCurrentNo()+1));
                    if(clinicForRegist.getRegistrationNum()!=null){
                        clinicForRegist.setRegistrationNum((short)(clinicForRegist.getRegistrationNum()+1));
                    }else{
                        clinicForRegist.setRegistrationNum((short)1);
                    }
                    // clinicForRegist.setCurrentNo( (short) (clinicForRegist.getCurrentNo()+1));
                    //   ClinicMaster clinicMasters = clinicMasterMapper.selectByVisitDate(clinicMaster.getVisitDate());

                    String visitNo;
                    while (true){
                        visitNo = recpNoMapper.selectVisitNo().getRecpNo();
                        ClinicMasterKey masterKey = new ClinicMasterKey();
                        masterKey.setVisitDate(clinicMaster.getVisitDate());
                        masterKey.setVisitNo(Short.parseShort(visitNo));
                        if(clinicMasterMapper.selectByPrimaryKey(masterKey) == null)
                            break;
                    }
                    clinicMaster.setVisitNo(Short.parseShort(generateVisitNo(clinicMaster.getVisitDate())));

                    checkSerialNo(clinicMaster);
                    clinicForRegist.setCurrentNo((short)(clinicMaster.getSerialNo() + 1));
                    //更新最新可用号和当日已挂号
                    clinicForRegistMapper.updateByPrimaryKeySelective(clinicForRegist);

                    clinicMasterMapper.insert(clinicMaster);
                    //支付记录
                    payOrderRecord.setOrderId(StringUtil.Utf_Iso(orderId));
                    payOrderRecord.setPatientId(patientID);
                    payOrderRecord.setVisitDate(clinicMaster.getVisitDate());
                    payOrderRecord.setVisitNo(clinicMaster.getVisitNo());
                    payOrderRecord.setRecordTime(new Timestamp(new Date().getTime()));
                    payOrderRecord.setTradeNo(tradeNo);
                    payOrderRecordMapper.insertSelective(payOrderRecord);

                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element root = doc.addElement("response");
                    Element header = root.addElement("header");
                    Element data = root.addElement("data");
                    header.addElement("code").setText("0");
                    header.addElement("desc").setText("成功");
                    data.addElement("visitId").setText(visitDate+"^"+clinicMaster.getVisitNo());
                    data.addElement("orderId").setText(orderId);
                    // add by tang 2018-06-21,返回记录新增serialNo
                    data.addElement("orderNo").setText(clinicMaster.getSerialNo()+"");
                    return doc.asXML();
                }else{
                    return getErrorlMsg("clinicLabel不能为空！");
                }
            }else { //自助机
                String schedueType = reroot.element("data").element("schedueType").getTextTrim();//1挂号  2 预约挂号
                //订单号=主键：就诊日期、号别、病人标识号、午别。
                String tradeNo = reroot.element("data").element("third_recharge_id").getTextTrim();
                String clinicLabel =  reroot.element("data").element("clinicLabel").getTextTrim();
                String patientID =  reroot.element("data").element("patientID").getTextTrim();
                String visitDate =  reroot.element("data").element("visitDate").getTextTrim();//yyyy-mm-dd
                String timeDesc =  reroot.element("data").element("timeDesc").getTextTrim(); //上午 下午 白天 昼夜
                String identity =reroot.element("data").element("identity").getTextTrim();//身份
                String chargeType =reroot.element("data").element("chargeType").getTextTrim(); //费别
                String insuranceType = reroot.element("data").element("insuranceType").getTextTrim(); //医保单据
                String insuranceNo = reroot.element("data").element("insuranceNo").getTextTrim(); //社会保障卡   为空是自费  不为空是医保
                String clinicFee = reroot.element("data").element("clinicFee").getTextTrim(); //总费用
                String clinicCharge = reroot.element("data").element("clinicCharge").getTextTrim(); //个人缴费
                String payMethod = reroot.element("data").element("payMethod").getTextTrim(); //支付方式 5  自助机微信 6 自助机支付宝 9 自助银联
               //新医保入参
                String  siDkOutParam = reroot.element("data").element("siDkOutParam").getTextTrim();// 读卡出参
                String  siDjParam = reroot.element("data").element("siDjParam").getTextTrim(); //登记入参
                String  siInParam = reroot.element("data").element("siInParam").getTextTrim(); //结算入参
                String  siOutParam = reroot.element("data").element("siOutParam").getTextTrim(); //结算反参

                //银联支付
                String yhkh = reroot.element("data").element("yhkh").getTextTrim(); // 银行卡号
                String pzh = reroot.element("data").element("pzh").getTextTrim();// 凭证号
                String ckh = reroot.element("data").element("ckh").getTextTrim();//  参考号
                String je = reroot.element("data").element("je").getTextTrim();  //  金额 （元）
                String zdh = reroot.element("data").element("zdh").getTextTrim();//  终端号
                String pch = reroot.element("data").element("pch").getTextTrim();//  批次号
                String jysj = reroot.element("data").element("jysj").getTextTrim();//  日期
                String shh = reroot.element("data").element("shh").getTextTrim();// 商务编号
                String czy = reroot.element("data").element("czy").getTextTrim();// 操作员


                SiReadCardInfo siReadCardInfo = new SiReadCardInfo();
                SiInDJParamInfo siInDJParamInfo  = new SiInDJParamInfo();
                SiSettlementInParamInfo siSettlementInParamInfo = new SiSettlementInParamInfo();
                SiSettlementOutParamInfo siSettlementOutParamInfo = new SiSettlementOutParamInfo();

                if(insuranceNo!=null && insuranceNo.length()>0) {  //  为空是自费  不为空是医保
                    siReadCardInfo  =   SiClassUtil.getSiReadCardInfo(siDkOutParam);

                    siInDJParamInfo = SiClassUtil.getSiInDjList(siDjParam);
                    //  siInParam  siOutParam
                    siSettlementInParamInfo = SiClassUtil.getSiSettlementInParamInfo(siInParam);

                    siSettlementOutParamInfo = SiClassUtil.getSiSettlementOutParamInfo(siOutParam);

                }

                String orderId =visitDate+"^"+clinicLabel+"^"+patientID+"^"+timeDesc;
                if(clinicLabel !=null && clinicLabel.length()>0 && patientID!=null&& patientID.length()>0 && visitDate!=null&& visitDate.length()>0 && timeDesc!=null&& timeDesc.length()>0){
                    PayOrderRecord payOrderRecord = new PayOrderRecord();
                    ClinicForRegistKey cfrk = new ClinicForRegistKey();
                    cfrk.setClinicDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                    cfrk.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                    cfrk.setTimeDesc(StringUtil.Utf_Iso(timeDesc));
                    ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfrk);

                    // 自助机取号不能更新currentNo, add by tang 2018-05-15
                    short serialNo = clinicForRegist.getCurrentNo();
                    // 2 预约挂号
                    if("2".equals(schedueType)){
                        ClinicAppointsKey clinicAppointsKey = new ClinicAppoints();
                        clinicAppointsKey.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                        clinicAppointsKey.setPatientId(patientID);
                        clinicAppointsKey.setVisitDateAppted(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                        clinicAppointsKey.setVisitTimeAppted(StringUtil.Utf_Iso(timeDesc));
                        ClinicAppoints clinicAppoints = clinicAppointsMapper.selectByPrimaryKey(clinicAppointsKey);
                        //1为取号，当作支付成功。
                        clinicAppoints.setClinicAttr("1");
                        //更新预约中预约状态
                        clinicAppointsMapper.updateByPrimaryKey(clinicAppoints);
                        //预约序号
//                        clinicForRegist.setCurrentNo(clinicAppoints.getSerialNo());
                        serialNo = clinicAppoints.getSerialNo();
                    }

                    PatMasterIndex pmi = patMasterIndexMapper.selectByPatientId(patientID);
//                    if(pmi !=null && pmi.getChargeType()!=null && !("自费".equals(StringUtil.Iso_GBK(pmi.getChargeType())) || "职工医保".equals(StringUtil.Iso_GBK(pmi.getChargeType()))) ){
//                        return getErrorlMsg("非自费(非职工医保)病人请至医院支付取号！");
//                    }
                    ClinicIndex clinicIndex  = clinicIndexMapper.selectByPrimaryKey(StringUtil.Utf_Iso(clinicLabel));
                    ClinicMaster clinicMaster = new ClinicMaster();
                    clinicMaster.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                    clinicMaster.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                    clinicMaster.setVisitTimeDesc(StringUtil.Utf_Iso(timeDesc));
                    clinicMaster.setSerialNo(serialNo); //
                    clinicMaster.setPatientId(pmi.getPatientId());
                    clinicMaster.setName(pmi.getName());
                    clinicMaster.setNamePhonetic(pmi.getNamePhonetic());
                    clinicMaster.setSex(pmi.getSex());
                    if(pmi.getDateOfBirth()!=null){
                        int age =(new Date().getYear() - pmi.getDateOfBirth().getYear());
                        clinicMaster.setAge((short)age);
                    }
                    //费别和人员性质   yllb  siReadCardInfo.getYllb()
                    if(!Util.isEmpty(siReadCardInfo.getYllb())){
                        if ("11".equals(siReadCardInfo.getYllb())){
//                            identity="在职";
                            chargeType="职工医保";
                        }else if("21".equals(siReadCardInfo.getYllb())){
//                            identity="退休";
                            chargeType="职工医保";
                        }else if("22".equals(siReadCardInfo.getYllb())){
//                            identity="退职";
                            chargeType="职工医保";
                        }else if("23".equals(siReadCardInfo.getYllb())){
//                            identity="70岁以上退职";
                            chargeType="职工医保";
                        }else if("24".equals(siReadCardInfo.getYllb())){
//                            identity="退职待审核";
                            chargeType="职工医保";
                        }else if("31".equals(siReadCardInfo.getYllb())){
//                            identity="离休";
                            chargeType="市统筹";
                        }else if("32".equals(siReadCardInfo.getYllb())){
//                            identity="地市级离休";
                            chargeType="市统筹";
                        }else if("41".equals(siReadCardInfo.getYllb())){
//                            identity="建国前老工人";
                            chargeType="市统筹";
                        }else if("42".equals(siReadCardInfo.getYllb())){
//                            identity="二乙伤残军人";
                            chargeType="市统筹";
                        }else if("51".equals(siReadCardInfo.getYllb())){
//                            identity="居民";
                            chargeType="居民医保";
                        }else if("52".equals(siReadCardInfo.getYllb())){
//                            identity="儿童学生";
                            chargeType="儿童医保";
                        }else if("53".equals(siReadCardInfo.getYllb())){
//                            identity="大学生";
                            chargeType="大学生";
                        }else if("62".equals(siReadCardInfo.getYllb())){
//                            identity="建筑业农民工";
                            chargeType="农工医保";
                        }else{
//                            identity="未知";
                            chargeType="未知";
                        }

                        clinicMaster.setIdentity(StringUtil.Utf_Iso(identity));//
                        clinicMaster.setChargeType(StringUtil.Utf_Iso(chargeType)); //
                    }else{
                        clinicMaster.setIdentity(StringUtil.Utf_Iso(identity));//
                        clinicMaster.setChargeType(StringUtil.Utf_Iso(chargeType)); //
                    }

                    if(insuranceNo!=null && insuranceNo.length()>0){  //  为空是自费  不为空是医保
                        clinicMaster.setInsuranceType(StringUtil.Utf_Iso(insuranceType));
                        clinicMaster.setInsuranceNo(insuranceNo);
                    }


                    clinicMaster.setClinicType(clinicIndex.getClinicTypeName());
                    if(clinicIndex!=null && clinicIndex.getDoctor()!=null){
                        clinicMaster.setDoctor(clinicIndex.getDoctor());
                    }else{
                        clinicMaster.setDoctor("");
                    }

                    //初复诊判断
                    clinicMaster.setFirstVisitIndicator((short)0);
                    clinicMaster.setVisitDept(clinicIndex.getClinicDept());
                    clinicMaster.setMrProvideIndicator((short)0);
                    clinicMaster.setRegistrationStatus((short)1);
                    clinicMaster.setRegisteringDate(new Timestamp(new Date().getTime()));
                    BigDecimal tot = new BigDecimal(clinicFee);
                    if(tot.compareTo(clinicIndex.getPrice())!=0){
                        return getErrorlMsg("挂号费有误！");
                    }
                    clinicMaster.setClinicFee(clinicIndex.getPrice());
                    clinicMaster.setRegistFee(new BigDecimal(0));
                    clinicMaster.setOtherFee(new BigDecimal(0));
                    if(clinicCharge!=null&& clinicCharge.length()>0){
                        clinicMaster.setClinicCharge(new BigDecimal(clinicCharge));
                    }

                    clinicMaster.setOperator(sourceType);
                    clinicMaster.setPayWay(payMethod);
                    clinicMaster.setAgeUnit(StringUtil.Utf_Iso("岁"));
                    if("9".equals(payMethod)){
                        clinicMaster.setTradeNo("");
                    }else{
                        clinicMaster.setTradeNo(tradeNo);
                    }
                    //clinicForRegist.setCurrentNo((short)(clinicForRegist.getCurrentNo()+1));
                    if(clinicForRegist.getRegistrationNum()!=null){
                        clinicForRegist.setRegistrationNum((short)(clinicForRegist.getRegistrationNum()+1));
                    }else{
                        clinicForRegist.setRegistrationNum((short)1);
                    }

                    //   ClinicMaster clinicMasters = clinicMasterMapper.selectByVisitDate(clinicMaster.getVisitDate());
                    String visitNo = generateVisitNo(clinicMaster.getVisitDate());
                    clinicMaster.setVisitNo(Short.parseShort(visitNo));

                    checkSerialNo(clinicMaster);

                    if("1".equals(schedueType)){
                        clinicForRegist.setCurrentNo((short)(clinicMaster.getSerialNo() + 1));
                    }

                    //更新最新可用号和当日已挂号
                    clinicForRegistMapper.updateByPrimaryKeySelective(clinicForRegist);

                    clinicMasterMapper.insert(clinicMaster);
//                    //支付记录 走刘彤的退费接口
//                    payOrderRecord.setOrderId(StringUtil.Utf_Iso(orderId));
//                    payOrderRecord.setPatientId(patientID);
//                    payOrderRecord.setVisitDate(clinicMaster.getVisitDate());
//                    payOrderRecord.setVisitNo(clinicMaster.getVisitNo());
//                    payOrderRecord.setRecordTime(new Timestamp(new Date().getTime()));
//                    payOrderRecord.setTradeNo(tradeNo);
//                    payOrderRecordMapper.insertSelective(payOrderRecord);
                    //支付记录 走刘冬的退费
                   if(payMethod.length()>0 && (payMethod.equals("5") || payMethod.equals("6"))){
                       ScanPay scanPay = new ScanPay();
                       String id = recpNoMapper.selectScanPay().getRecpNo();
                       scanPay.setId(new BigDecimal(id));
                       scanPay.setPatientName(pmi.getName());
                       scanPay.setOperaterId("ZZJ");
                       scanPay.setPatientId(pmi.getPatientId());
                       scanPay.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                       scanPay.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                       scanPay.setAmPm(StringUtil.Utf_Iso(timeDesc));
                       BigDecimal b1 = new BigDecimal(100);
                       // update by tang 2018-5-22 只需要存入现金缴费,不要存入全部费用
                       scanPay.setTotalCosts(new BigDecimal(clinicCharge).multiply(b1).intValue()+"");
                       scanPay.setChargeType(StringUtil.Utf_Iso("挂号费"));
                       scanPay.setPayWay(payMethod);
                       scanPay.setHospitalMark(StringUtil.Utf_Iso("中国人民解放军81医院"));
                       scanPay.setTrandeNo(tradeNo);
                       scanPay.setRcptNo(visitNo);
                       scanPay.setResultComment("N");
                       scanPay.setOperDate(Util.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
                       scanPayMapper.insert(scanPay);
                   }

                    DeptDict deptDict = deptDictMapper.selectByPrimaryKey(clinicIndex.getClinicDept());

                    //自助银联  9
                    if("9".equals(payMethod)){
                            BankTradeLog bankTradeLog = new BankTradeLog();
                            bankTradeLog.setType(StringUtil.Utf_Iso("门诊收费"));
                            bankTradeLog.setRcptNo(Util.format(clinicMaster.getVisitDate(),"yyyy-MM-dd")+clinicMaster.getVisitNo());
                            bankTradeLog.setTraDate(Util.getCurrentDate("yyyyMMdd"));
                            bankTradeLog.setTradeId(Util.format(clinicMaster.getVisitDate(),"yyyy-MM-dd")+clinicMaster.getVisitNo());
                            bankTradeLog.setTempRcptNo(Util.format(clinicMaster.getVisitDate(),"yyyy-MM-dd")+clinicMaster.getVisitNo());
                            bankTradeLog.setPatientId(clinicMaster.getPatientId());
                            bankTradeLog.setBankCard(yhkh);
                            bankTradeLog.setTraNo(pzh);
                            bankTradeLog.setTraFinalNo(zdh);
                            bankTradeLog.setTraTotal(new BigDecimal(je));
                            bankTradeLog.setTraStatus(1+"");
                            bankTradeLog.setTraPcNo(pch);
                            bankTradeLog.setTraTime(Util.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
                            bankTradeLog.setMerchantNo(shh);
//                          bankTradeLog.setNote();
//                          bankTradeLog.setTimes();
                            bankTradeLog.setUserId(czy);
                            bankTradeLog.setAcctNo(1+"");
//                          bankTradeLog.setReturnTimes();
//                          bankTradeLog.setReturnMoneyLimit();
//                          bankTradeLog.setReturnType();
                            bankTradeLog.setOprAppNameHis(1+"");
                            bankTradeLog.setAcctFlagHis(new BigDecimal(1));
                            bankTradeLog.setOperTypeHis(StringUtil.Utf_Iso("银行卡"));
                            bankTradeLog.setRcptFlagHis(new BigDecimal(1));
//                          bankTradeLog.setBankNo();
//                          bankTradeLog.setTraAuthNo();
//                          bankTradeLog.setSettleDate();
//                          bankTradeLog.setLrcReturn();
//                          bankTradeLog.setReturnRcptNo();
                            bankTradeLog.setTraReferNo(ckh);

                            bankTradeLogMapper.insertSelective(bankTradeLog);
                    }
                    logger.info("[直接挂号  入参 :]"+1);
                    //新医保数据 开关配置
                    AppConfigerParameter appConfigerParameter = appConfigerParameterMapper.selectByParameterName("NJJB_CONTROL");
                    if(appConfigerParameter!=null && appConfigerParameter.getParameterValue().equals("Y")){
                         if(insuranceNo!=null && insuranceNo.length()>0){  //  为空是自费  不为空是医保
                            //统筹区属 转换
                             String  tcqh="";
                             if(siReadCardInfo.getTcqh().equals("320101")){
                                 tcqh="本市级";
                             }else if(siReadCardInfo.getTcqh().equals("320102")){
                                 tcqh="玄武区";
                             }else if(siReadCardInfo.getTcqh().equals("320104")){
                                 tcqh="秦淮区";
                             }else if(siReadCardInfo.getTcqh().equals("320105")){
                                 tcqh="建邺区";
                             }else if(siReadCardInfo.getTcqh().equals("320106")){
                                 tcqh="鼓楼区";
                             }else if(siReadCardInfo.getTcqh().equals("320107")){
                                 tcqh="雨花台区";
                             }else if(siReadCardInfo.getTcqh().equals("320108")){
                                 tcqh="化学工业园区";
                             }else if(siReadCardInfo.getTcqh().equals("320111")){
                                 tcqh="浦口区";
                             }else if(siReadCardInfo.getTcqh().equals("320113")){
                                 tcqh="栖霞区";
                             }else if(siReadCardInfo.getTcqh().equals("320114")){
                                 tcqh="雨花台区";
                             }else if(siReadCardInfo.getTcqh().equals("320115")){
                                 tcqh="江宁区";
                             }else if(siReadCardInfo.getTcqh().equals("320116")){
                                 tcqh="六合区";
                             }else if(siReadCardInfo.getTcqh().equals("320124")){
                                 tcqh="溧水区";
                             }else if(siReadCardInfo.getTcqh().equals("320125")){
                                 tcqh="高淳区";
                             }else if(siReadCardInfo.getTcqh().equals("320131")){
                                 tcqh="经济管委会";
                             }else if(siReadCardInfo.getTcqh().equals("320132")){
                                 tcqh="高新区管委会";
                             }else if(siReadCardInfo.getTcqh().equals("320133")){
                                 tcqh="化工园区管委会";
                             }else {
                                 tcqh="未知";
                             }

                             InsuranceAccountsNjjbKey insuranceAccountsNjjbKey = new InsuranceAccountsNjjbKey();
                             insuranceAccountsNjjbKey.setInsuranceNo(siReadCardInfo.getTbr());
                             insuranceAccountsNjjbKey.setPatientId(patientID);
                             insuranceAccountsNjjbKey.setAccountStatus((short) 0);
                             InsuranceAccountsNjjb  insuranceAccountsNjjb  =  insuranceAccountsNjjbMapper.selectByPrimaryKey(insuranceAccountsNjjbKey);

                             InsuranceAccountsNjjb  insuranceAccountsNjjb1 = new InsuranceAccountsNjjb();
                             insuranceAccountsNjjb1.setInsuranceNo(siReadCardInfo.getTbr());
                             insuranceAccountsNjjb1.setPatientId(patientID);
                             insuranceAccountsNjjb1.setName(pmi.getName());
                             insuranceAccountsNjjb1.setNamePhonetic(pmi.getNamePhonetic());
                             insuranceAccountsNjjb1.setSex(pmi.getSex());
                             insuranceAccountsNjjb1.setDateOfBirth(pmi.getDateOfBirth());
                            // insuranceAccountsNjjb1.setStartDateOfWork();
                            // insuranceAccountsNjjb1.setWorkingYears();
                             insuranceAccountsNjjb1.setUnit(StringUtil.Utf_Iso(siReadCardInfo.getDwmc()));
                             insuranceAccountsNjjb1.setIdentityClass(StringUtil.Utf_Iso("市医保"));
                             insuranceAccountsNjjb1.setAccountBalance( new BigDecimal(siReadCardInfo.getAccountBalance()));
                             insuranceAccountsNjjb1.setInsuranceLocation(StringUtil.Utf_Iso(tcqh));
                             insuranceAccountsNjjb1.setInsuranceLocationCode(siReadCardInfo.getTcqh());
                             insuranceAccountsNjjb1.setOperator("ZZJ");
                             insuranceAccountsNjjb1.setAccountStatus((short) 0);
                             if(insuranceAccountsNjjb!=null){
                                 insuranceAccountsNjjb1.setUpdateDateTime(new Timestamp(new Date().getTime()));
                                 insuranceAccountsNjjbMapper.updateByPrimaryKeySelective(insuranceAccountsNjjb1);
                             }else{
                                 insuranceAccountsNjjb1.setCreateDate(new Timestamp(new Date().getTime()));
                                 insuranceAccountsNjjbMapper.insertSelective(insuranceAccountsNjjb1);
                             }

                             Njjb2100 njjb2100  =   njjb2100Mapper.selectByPrimaryKey(siReadCardInfo.getTbr());

                             Njjb2100  njjb21001 = new Njjb2100();
                             njjb21001.setInsuranceNo(siReadCardInfo.getTbr());
                             njjb21001.setReadName1(siReadCardInfo.getTbr());
                             njjb21001.setReadName2(siReadCardInfo.getDwbh());
                             njjb21001.setReadName3(StringUtil.Utf_Iso(siReadCardInfo.getDwmc()));
                             njjb21001.setReadName4(siReadCardInfo.getIdNo());
                             njjb21001.setReadName5(StringUtil.Utf_Iso(siReadCardInfo.getName()));
                             njjb21001.setReadName6(siReadCardInfo.getSex());
                             njjb21001.setReadName7(siReadCardInfo.getYllb());
                             njjb21001.setReadName8(siReadCardInfo.getYdrybz());
                             njjb21001.setReadName9(StringUtil.Utf_Iso(tcqh));
                             njjb21001.setReadName10(siReadCardInfo.getAccountBalance());
                             njjb21001.setReadName11(siReadCardInfo.getInHosStatus());
                             njjb21001.setReadName12(siReadCardInfo.getBnzycs());
                             njjb21001.setReadName13(siReadCardInfo.getDyxsbz());
                             njjb21001.setReadName14(StringUtil.Utf_Iso(siReadCardInfo.getDybxsyy()));
                             njjb21001.setReadName15(StringUtil.Utf_Iso(siReadCardInfo.getAllBzm()));
                             njjb21001.setReadName16(siReadCardInfo.getYbmmzg());
                             njjb21001.setReadName17(StringUtil.Utf_Iso(siReadCardInfo.getYbMmbz()));
                             njjb21001.setReadName18(siReadCardInfo.getYbMjzg());
                             njjb21001.setReadName19(StringUtil.Utf_Iso(siReadCardInfo.getYbmjbz()));
                             njjb21001.setReadName20(siReadCardInfo.getYbmazg());
                             njjb21001.setReadName21(StringUtil.Utf_Iso(siReadCardInfo.getYbmabz()));
                             njjb21001.setReadName22(siReadCardInfo.getYbbgglsz());
                             njjb21001.setReadName23(StringUtil.Utf_Iso(siReadCardInfo.getYbbgglsbz()));
                             njjb21001.setReadName24(siReadCardInfo.getYbmzxybzg());
                             njjb21001.setReadName25(StringUtil.Utf_Iso(siReadCardInfo.getYbmzxybbz()));
                             njjb21001.setReadName26(siReadCardInfo.getYbmezg());
                             njjb21001.setReadName27(StringUtil.Utf_Iso(siReadCardInfo.getYbmebz()));
                             njjb21001.setReadName28(siReadCardInfo.getYbtyzg());
                             njjb21001.setReadName29(StringUtil.Utf_Iso(siReadCardInfo.getYbtybz()));
                             njjb21001.setReadName30(siReadCardInfo.getYbtymcbm());
                             njjb21001.setReadName31(siReadCardInfo.getJmmdzg());
                             njjb21001.setReadName32(siReadCardInfo.getJmmdbz());
                             njjb21001.setReadName33(siReadCardInfo.getJmmzyhbzg());
                             njjb21001.setReadName34(siReadCardInfo.getJmmzyhbbz());
                             njjb21001.setReadName35(siReadCardInfo.getJmtyzg());
                             njjb21001.setReadName36(siReadCardInfo.getJmtybz());
                             njjb21001.setReadName37(siReadCardInfo.getJmtymcbm());
                             njjb21001.setReadName38(siReadCardInfo.getNmgmdzg());
                             njjb21001.setReadName39(siReadCardInfo.getNmgmdbz());
                             njjb21001.setReadName40(siReadCardInfo.getNmgtyzg());
                             njjb21001.setReadName41(siReadCardInfo.getNmgtybz());
                             njjb21001.setReadName42(siReadCardInfo.getNmgtybzbm());
                             njjb21001.setReadName43(siReadCardInfo.getXszgmt());
                             njjb21001.setReadName44(siReadCardInfo.getSysplx());
                             njjb21001.setReadName45(siReadCardInfo.getFsyy());
                             njjb21001.setReadName46(siReadCardInfo.getMmsykbje());
                             njjb21001.setReadName47(siReadCardInfo.getMtfzzlsyje());
                             njjb21001.setReadName48(siReadCardInfo.getGsdyzg());
                             njjb21001.setReadName49(siReadCardInfo.getGsdybz());
                             njjb21001.setReadName50(siReadCardInfo.getGszdjl());
                             njjb21001.setReadName51(siReadCardInfo.getDksykbje());
                             njjb21001.setReadName52(siReadCardInfo.getMtsykbje());
                             njjb21001.setReadName53(siReadCardInfo.getYbjczg());
                             if(njjb2100!=null){
                                 njjb2100Mapper.updateByPrimaryKeySelective(njjb21001);
                             }else{
                                 njjb2100Mapper.insertSelective(njjb21001);
                             }

                             //siDjParam  医保登记

                             NjjbReg2210 njjbReg2210= new NjjbReg2210();
                             njjbReg2210.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                             njjbReg2210.setVisitNo(Integer.valueOf(visitNo));
                             njjbReg2210.setSign((short)1);
                             njjbReg2210.setCreated(DateToWeek.formatDate(Util.getCurrentDate("yyyyMMddHHmmss"),"yyyyMMddHHmmss"));
                             njjbReg2210.setInHeader1(siInDJParamInfo.getYwbh()); //业务编号（4位）
                             njjbReg2210.setInHeader2(siInDJParamInfo.getYljgbh());//医疗机构编号(8位)
                             njjbReg2210.setInHeader3(siInDJParamInfo.getCzybh());//操作员编号(8位)
                             njjbReg2210.setInHeader4(siInDJParamInfo.getYwzqh());//业务周期号(最大34位)
                             njjbReg2210.setInHeader5(siInDJParamInfo.getYyjylsh());//医院交易流水号(发送方交易流水号)(最大30位)
                             njjbReg2210.setInHeader6(siInDJParamInfo.getJrfs());//接入方式
                             njjbReg2210.setInHeader7(siInDJParamInfo.getDklx());//读卡类型

                             njjbReg2210.setInName1(siInDJParamInfo.getMzlsh());  //门诊/住院流水号
                             njjbReg2210.setInName2(StringUtil.Utf_Iso(siInDJParamInfo.getYllb())); //医疗类别
                             njjbReg2210.setInName3(siInDJParamInfo.getMzrysj());
                             njjbReg2210.setInName4(siInDJParamInfo.getZdjbbm());
                             njjbReg2210.setInName5(StringUtil.Utf_Iso(siInDJParamInfo.getBqmc()));
                             njjbReg2210.setInName6(siInDJParamInfo.getKsbm());
                             njjbReg2210.setInName7(siInDJParamInfo.getCwh());
                             njjbReg2210.setInName8(StringUtil.Utf_Iso(siInDJParamInfo.getYsbh()));
                             njjbReg2210.setInName9(siInDJParamInfo.getJbr());
                             njjbReg2210.setInName10(siInDJParamInfo.getBrlxdh());
                             njjbReg2210.setInName11(siInDJParamInfo.getTbr());
                             njjbReg2210.setInName12(siInDJParamInfo.getZyh());
                             njjbReg2210.setInName13(siInDJParamInfo.getBabyTbr());
                             njjbReg2210.setInName14(siInDJParamInfo.getBy3());
                             njjbReg2210.setInName15(siInDJParamInfo.getBy4());
                             njjbReg2210.setInName16(siInDJParamInfo.getBy5());
                             njjbReg2210.setInName17(siInDJParamInfo.getBy6());

                             njjbReg2210.setOutFooter1(siReadCardInfo.getZxjylsh()); //中心交易流水号
                             njjbReg2210.setOutFooter2(siReadCardInfo.getYlzd1());
                             njjbReg2210.setOutFooter3(siReadCardInfo.getYlzd2());

                             njjbReg2210.setInsuranceNo(siReadCardInfo.getTbr());
                             njjbReg2210.setReadName1(siReadCardInfo.getTbr());
                             njjbReg2210.setReadName2(siReadCardInfo.getDwbh());
                             njjbReg2210.setReadName3(StringUtil.Utf_Iso(siReadCardInfo.getDwmc()));
                             njjbReg2210.setReadName4(siReadCardInfo.getIdNo());
                             njjbReg2210.setReadName5(StringUtil.Utf_Iso(siReadCardInfo.getName()));
                             njjbReg2210.setReadName6(siReadCardInfo.getSex());
                             njjbReg2210.setReadName7(siReadCardInfo.getYllb());
                             njjbReg2210.setReadName8(siReadCardInfo.getYdrybz());
                             njjbReg2210.setReadName9(StringUtil.Utf_Iso(tcqh));
                             njjbReg2210.setReadName10(siReadCardInfo.getAccountBalance());
                             njjbReg2210.setReadName11(siReadCardInfo.getInHosStatus());
                             njjbReg2210.setReadName12(siReadCardInfo.getBnzycs());
                             njjbReg2210.setReadName13(siReadCardInfo.getDyxsbz());
                             njjbReg2210.setReadName14(StringUtil.Utf_Iso(siReadCardInfo.getDybxsyy()));
                             njjbReg2210.setReadName15(StringUtil.Utf_Iso(siReadCardInfo.getAllBzm()));
                             njjbReg2210.setReadName16(siReadCardInfo.getYbmmzg());
                             njjbReg2210.setReadName17(StringUtil.Utf_Iso(siReadCardInfo.getYbMmbz()));
                             njjbReg2210.setReadName18(siReadCardInfo.getYbMjzg());
                             njjbReg2210.setReadName19(StringUtil.Utf_Iso(siReadCardInfo.getYbmjbz()));
                             njjbReg2210.setReadName20(siReadCardInfo.getYbmazg());
                             njjbReg2210.setReadName21(StringUtil.Utf_Iso(siReadCardInfo.getYbmabz()));
                             njjbReg2210.setReadName22(siReadCardInfo.getYbbgglsz());
                             njjbReg2210.setReadName23(StringUtil.Utf_Iso(siReadCardInfo.getYbbgglsbz()));
                             njjbReg2210.setReadName24(siReadCardInfo.getYbmzxybzg());
                             njjbReg2210.setReadName25(StringUtil.Utf_Iso(siReadCardInfo.getYbmzxybbz()));
                             njjbReg2210.setReadName26(siReadCardInfo.getYbmezg());
                             njjbReg2210.setReadName27(StringUtil.Utf_Iso(siReadCardInfo.getYbmebz()));
                             njjbReg2210.setReadName28(siReadCardInfo.getYbtyzg());
                             njjbReg2210.setReadName29(StringUtil.Utf_Iso(siReadCardInfo.getYbtybz()));
                             njjbReg2210.setReadName30(siReadCardInfo.getYbtymcbm());
                             njjbReg2210.setReadName31(siReadCardInfo.getJmmdzg());
                             njjbReg2210.setReadName32(siReadCardInfo.getJmmdbz());
                             njjbReg2210.setReadName33(siReadCardInfo.getJmmzyhbzg());
                             njjbReg2210.setReadName34(siReadCardInfo.getJmmzyhbbz());
                             njjbReg2210.setReadName35(siReadCardInfo.getJmtyzg());
                             njjbReg2210.setReadName36(siReadCardInfo.getJmtybz());
                             njjbReg2210.setReadName37(siReadCardInfo.getJmtymcbm());
                             njjbReg2210.setReadName38(siReadCardInfo.getNmgmdzg());
                             njjbReg2210.setReadName39(siReadCardInfo.getNmgmdbz());
                             njjbReg2210.setReadName40(siReadCardInfo.getNmgtyzg());
                             njjbReg2210.setReadName41(siReadCardInfo.getNmgtybz());
                             njjbReg2210.setReadName42(siReadCardInfo.getNmgtybzbm());
                             njjbReg2210.setReadName43(siReadCardInfo.getXszgmt());
                             njjbReg2210.setReadName44(siReadCardInfo.getSysplx());
                             njjbReg2210.setReadName45(siReadCardInfo.getFsyy());
                             njjbReg2210.setReadName46(siReadCardInfo.getMmsykbje());
                             njjbReg2210.setReadName47(siReadCardInfo.getMtfzzlsyje());
                             njjbReg2210.setReadName48(siReadCardInfo.getGsdyzg());
                             njjbReg2210.setReadName49(siReadCardInfo.getGsdybz());
                             njjbReg2210.setReadName50(siReadCardInfo.getGszdjl());
                             njjbReg2210.setReadName51(siReadCardInfo.getDksykbje());
                             njjbReg2210.setReadName52(siReadCardInfo.getMtsykbje());
                             njjbReg2210.setReadName53(siReadCardInfo.getYbjczg());

                             njjbReg2210Mapper.insertSelective(njjbReg2210);



                             //1.挂号费用明细表(NJJB_REG_2310)
                             String inName5  = Util.getCurrentDate("yyyyMMddHHmmss");
                             NjjbReg2310 njjbreg2310 = new NjjbReg2310();
                             njjbreg2310.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                             njjbreg2310.setVisitNo(Integer.valueOf(visitNo));
                             njjbreg2310.setItemNo(1);
                             njjbreg2310.setSign((short) 1);
                             njjbreg2310.setCreated(DateToWeek.formatDate(Util.getCurrentDate("yyyyMMddHHmmss"),"yyyyMMddHHmmss"));
                             njjbreg2310.setInHeader1("2310");
                             njjbreg2310.setInHeader2(siSettlementInParamInfo.getYljgbh());//医疗机构编号(8位)
                             njjbreg2310.setInHeader3(siSettlementInParamInfo.getCzybh());//操作员编号(8位)
                             njjbreg2310.setInHeader4(siSettlementInParamInfo.getYwzqh());//业务周期号(最大34位)
                             njjbreg2310.setInHeader5(siSettlementInParamInfo.getYyjylsh());//医院交易流水号(发送方交易流水号)(最大30位)
                             njjbreg2310.setInHeader6(siSettlementInParamInfo.getJrfs());//接入方式
                             njjbreg2310.setInHeader7(siSettlementInParamInfo.getDklx());//读卡类型

                             njjbreg2310.setInName1(siSettlementInParamInfo.getMzlsh()); //门诊/住院流水号
                             njjbreg2310.setInName2(2+""); //收费项目种类
                             njjbreg2310.setInName3(clinicMaster.getSerialNo()+""); //处方号
                             njjbreg2310.setInName4(clinicMaster.getSerialNo()+""); //处方流水号
                             njjbreg2310.setInName5(inName5); //处方日期
//                             njjbreg2310.setInName6(); //医院收费项目自编码
                             njjbreg2310.setInName7(siSettlementOutParamInfo.getYlfze()); //单价
                             njjbreg2310.setInName8(1+"");  //数量
                             njjbreg2310.setInName9(siSettlementOutParamInfo.getYlfze());  //金额
//                             njjbreg2310.setInName10();  //中药饮片副数
                             njjbreg2310.setInName11(siSettlementInParamInfo.getYsbm()); //医生编码
                             njjbreg2310.setInName12(siSettlementInParamInfo.getKsbm());  //科室编码
                             njjbreg2310.setInName13(siSettlementInParamInfo.getJbr());  //经办人
//                             njjbreg2310.setInName14(); //按最小计价单位收费标志
//                             njjbreg2310.setInName15();  //备用2
//                             njjbreg2310.setInName16();
//                             njjbreg2310.setInName17();
//                             njjbreg2310.setInName18();
//                             njjbreg2310.setInName19();

                             njjbreg2310.setOutFooter1(siSettlementOutParamInfo.getZxjylsh()); //中心交易流水号
                             njjbreg2310.setOutFooter2(siSettlementOutParamInfo.getYlzd1());
                             njjbreg2310.setOutFooter3(siSettlementOutParamInfo.getYlzd2());

                             njjbreg2310.setOutName1(clinicMaster.getSerialNo()+"");//处方号
                             njjbreg2310.setOutName2(clinicMaster.getSerialNo()+"");//处方流水号
                             njjbreg2310.setOutName3(inName5);//处方日期
//                             njjbreg2310.setOutName4();//医院收费项目自编码BigDecimal b1 = new BigDecimal(Double.toString(v1));
                             BigDecimal b1 = new BigDecimal(siSettlementOutParamInfo.getZhzfzf());
                             BigDecimal b2 = new BigDecimal(siSettlementOutParamInfo.getXjzfzf());
                             njjbreg2310.setOutName5(siSettlementOutParamInfo.getYlfze());//金额
                             njjbreg2310.setOutName6(b1.add(b2)+"");//自付金额
                             BigDecimal b3 = new BigDecimal(siSettlementOutParamInfo.getZhzfzl());
                             BigDecimal b4 = new BigDecimal(siSettlementOutParamInfo.getXjzfzl());
                             njjbreg2310.setOutName7(b3.add(b4)+"");//自理金额
                             njjbreg2310.setOutName8(0+"");//自付比例
//                             njjbreg2310.setOutName9();//支付上限
                             njjbreg2310.setOutName10(1+"");//收费项目等级
                             njjbreg2310.setOutName11(siSettlementOutParamInfo.getSmxx());//说明信息
//                             njjbreg2310.setOutName12();//备用2
//                             njjbreg2310.setOutName13();
//                             njjbreg2310.setOutName14();
//                             njjbreg2310.setOutName15();
//                             njjbreg2310.setOutName16();

                             njjbReg2310Mapper.insertSelective(njjbreg2310);

                             //2.挂号试算(NJJB_REG_2420)
                             NjjbReg2420 njjbReg2420 = new NjjbReg2420();
                             njjbReg2420.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                             njjbReg2420.setVisitNo(Integer.valueOf(visitNo));
                             njjbReg2420.setRcptNo(siInDJParamInfo.getMzlsh());

                             njjbReg2420.setInHeader1("2420");
                             njjbReg2420.setInHeader2(siSettlementInParamInfo.getYljgbh());//医疗机构编号(8位)
                             njjbReg2420.setInHeader3(siSettlementInParamInfo.getCzybh());//操作员编号(8位)
                             njjbReg2420.setInHeader4(siSettlementInParamInfo.getYwzqh());//业务周期号(最大34位)
                             njjbReg2420.setInHeader5(siSettlementInParamInfo.getYyjylsh());//医院交易流水号(发送方交易流水号)(最大30位)
                             njjbReg2420.setInHeader6(siSettlementInParamInfo.getJrfs());//接入方式
                             njjbReg2420.setInHeader7(siSettlementInParamInfo.getDklx());//读卡类型

                             njjbReg2420.setInName1(siSettlementInParamInfo.getMzlsh()); //门诊/住院流水号
                             njjbReg2420.setInName2(siSettlementInParamInfo.getDjh()); //单据号
                             njjbReg2420.setInName3(siSettlementInParamInfo.getYllb()); //医疗类别
                             njjbReg2420.setInName4(siSettlementInParamInfo.getJsrq()); //结算日期
                             njjbReg2420.setInName5(siSettlementInParamInfo.getCyrq()); //出院日期
                             njjbReg2420.setInName6(siSettlementInParamInfo.getCyyy()); //出院原因
                             njjbReg2420.setInName7(siSettlementInParamInfo.getCyzdjbbm()); //出院诊断疾病编码
                             njjbReg2420.setInName8(siSettlementInParamInfo.getYjslb());  //月结算类别
                             njjbReg2420.setInName9(siSettlementInParamInfo.getZtjsbz());  //中途结算标志
                             njjbReg2420.setInName10(siSettlementInParamInfo.getJbr());  //经办人
                             njjbReg2420.setInName11(siSettlementInParamInfo.getFmrq()); //分娩日期
                             njjbReg2420.setInName12(siSettlementInParamInfo.getCc());  //产次
                             njjbReg2420.setInName13(siSettlementInParamInfo.getTes());  //胎儿数
                             njjbReg2420.setInName14(siSettlementInParamInfo.getTbr()); //社会保障卡号
                             njjbReg2420.setInName15(siSettlementInParamInfo.getZyyybh());  //转院医院编号
                             njjbReg2420.setInName16(siSettlementInParamInfo.getKsbm()); //科室编码
                             njjbReg2420.setInName17(siSettlementInParamInfo.getYsbm());//医生编码
                             njjbReg2420.setInName18(siSettlementInParamInfo.getGhfjs()); //备用4
                             njjbReg2420.setInName19(siSettlementInParamInfo.getZsrtbr());
                             njjbReg2420.setInName20(siSettlementInParamInfo.getShcs());

                             njjbReg2420.setOutFooter1(siSettlementOutParamInfo.getZxjylsh()); //中心交易流水号
                             njjbReg2420.setOutFooter2(siSettlementOutParamInfo.getYlzd1());
                             njjbReg2420.setOutFooter3(siSettlementOutParamInfo.getYlzd2());

                             njjbReg2420.setOutName1(siSettlementOutParamInfo.getYlfze());//本次医疗费总额
                             njjbReg2420.setOutName2(siSettlementOutParamInfo.getTczfje());//本次统筹支付金额
                             njjbReg2420.setOutName3(siSettlementOutParamInfo.getDbjzzf());//本次大病救助支付
                             njjbReg2420.setOutName4(siSettlementOutParamInfo.getDbbxzf());//本次大病保险支付
                             njjbReg2420.setOutName5(siSettlementOutParamInfo.getMzbzzf());//本次民政补助支付
                             njjbReg2420.setOutName6(siSettlementOutParamInfo.getZhzfze());//本次帐户支付总额
                             njjbReg2420.setOutName7(siSettlementOutParamInfo.getXjzfze());//本次现金支付总额
                             njjbReg2420.setOutName8(siSettlementOutParamInfo.getZhzfzf());//本次帐户支付自付
                             njjbReg2420.setOutName9(siSettlementOutParamInfo.getZhzfzl());//本次帐户支付自理
                             njjbReg2420.setOutName10(siSettlementOutParamInfo.getXjzfzf());//本次现金支付自付
                             njjbReg2420.setOutName11(siSettlementOutParamInfo.getXjzfzl());//本次现金支付自理
                             njjbReg2420.setOutName12(siSettlementOutParamInfo.getYbfwnfy());//医保范围内费用
                             njjbReg2420.setOutName13(siSettlementOutParamInfo.getZhxfhye());//帐户消费后余额
                             njjbReg2420.setOutName14(siSettlementOutParamInfo.getDbzbm());//单病种病种编码
                             njjbReg2420.setOutName15(siSettlementOutParamInfo.getSmxx());//说明信息
                             njjbReg2420.setOutName16(siSettlementOutParamInfo.getYfhj());//备用2
                             njjbReg2420.setOutName17(siSettlementOutParamInfo.getZlxmfhj());
                             njjbReg2420.setOutName18(siSettlementOutParamInfo.getBbzf());
                             njjbReg2420.setOutName19(siSettlementOutParamInfo.getYylb());
                             njjbReg2420.setOutName20(siSettlementOutParamInfo.getIsNo());

                             njjbReg2420Mapper.insertSelective(njjbReg2420);

                             //3.挂号结算(NJJB_REG_2410)
                             NjjbReg2410 njjbReg2410 = new NjjbReg2410();
                             njjbReg2410.setVisitDate(DateToWeek.formatDate(visitDate,"yyyy-MM-dd"));
                             njjbReg2410.setVisitNo(Integer.valueOf(visitNo));
                             njjbReg2410.setSign((short)1);
                             njjbReg2410.setCreated(DateToWeek.formatDate(Util.getCurrentDate("yyyyMMddHHmmss"),"yyyyMMddHHmmss"));

                             njjbReg2410.setInHeader1(siSettlementInParamInfo.getYwbh());
                             njjbReg2410.setInHeader2(siSettlementInParamInfo.getYljgbh());//医疗机构编号(8位)
                             njjbReg2410.setInHeader3(siSettlementInParamInfo.getCzybh());//操作员编号(8位)
                             njjbReg2410.setInHeader4(siSettlementInParamInfo.getYwzqh());//业务周期号(最大34位)
                             njjbReg2410.setInHeader5(siSettlementInParamInfo.getYyjylsh());//医院交易流水号(发送方交易流水号)(最大30位)
                             njjbReg2410.setInHeader6(siSettlementInParamInfo.getJrfs());//接入方式
                             njjbReg2410.setInHeader7(siSettlementInParamInfo.getDklx());//读卡类型

                             njjbReg2410.setInName1(siSettlementInParamInfo.getMzlsh()); //门诊/住院流水号
                             njjbReg2410.setInName2(siSettlementInParamInfo.getDjh()); //单据号
                             njjbReg2410.setInName3(siSettlementInParamInfo.getYllb()); //医疗类别
                             njjbReg2410.setInName4(siSettlementInParamInfo.getJsrq()); //结算日期
                             njjbReg2410.setInName5(siSettlementInParamInfo.getCyrq()); //出院日期
                             njjbReg2410.setInName6(siSettlementInParamInfo.getCyyy()); //出院原因
                             njjbReg2410.setInName7(siSettlementInParamInfo.getCyzdjbbm()); //出院诊断疾病编码
                             njjbReg2410.setInName8(siSettlementInParamInfo.getYjslb());  //月结算类别
                             njjbReg2410.setInName9(siSettlementInParamInfo.getZtjsbz());  //中途结算标志
                             njjbReg2410.setInName10(siSettlementInParamInfo.getJbr());  //经办人
                             njjbReg2410.setInName11(siSettlementInParamInfo.getFmrq()); //分娩日期
                             njjbReg2410.setInName12(siSettlementInParamInfo.getCc());  //产次
                             njjbReg2410.setInName13(siSettlementInParamInfo.getTes());  //胎儿数
                             njjbReg2410.setInName14(siSettlementInParamInfo.getTbr()); //社会保障卡号
                             njjbReg2410.setInName15(siSettlementInParamInfo.getZyyybh());  //转院医院编号
                             njjbReg2410.setInName16(siSettlementInParamInfo.getKsbm()); //科室编码
                             njjbReg2410.setInName17(siSettlementInParamInfo.getYsbm());//医生编码
                             njjbReg2410.setInName18(siSettlementInParamInfo.getGhfjs()); //备用4
                             njjbReg2410.setInName19(siSettlementInParamInfo.getZsrtbr());
                             njjbReg2410.setInName20(siSettlementInParamInfo.getShcs());


                             njjbReg2410.setOutFooter1(siSettlementOutParamInfo.getZxjylsh()); //中心交易流水号
                             njjbReg2410.setOutFooter2(siSettlementOutParamInfo.getYlzd1());
                             njjbReg2410.setOutFooter3(siSettlementOutParamInfo.getYlzd2());

                             njjbReg2410.setOutName1(siSettlementOutParamInfo.getYlfze());//本次医疗费总额
                             njjbReg2410.setOutName2(siSettlementOutParamInfo.getTczfje());//本次统筹支付金额
                             njjbReg2410.setOutName3(siSettlementOutParamInfo.getDbjzzf());//本次大病救助支付
                             njjbReg2410.setOutName4(siSettlementOutParamInfo.getDbbxzf());//本次大病保险支付
                             njjbReg2410.setOutName5(siSettlementOutParamInfo.getMzbzzf());//本次民政补助支付
                             njjbReg2410.setOutName6(siSettlementOutParamInfo.getZhzfze());//本次帐户支付总额
                             njjbReg2410.setOutName7(siSettlementOutParamInfo.getXjzfze());//本次现金支付总额
                             njjbReg2410.setOutName8(siSettlementOutParamInfo.getZhzfzf());//本次帐户支付自付
                             njjbReg2410.setOutName9(siSettlementOutParamInfo.getZhzfzl());//本次帐户支付自理
                             njjbReg2410.setOutName10(siSettlementOutParamInfo.getXjzfzf());//本次现金支付自付
                             njjbReg2410.setOutName11(siSettlementOutParamInfo.getXjzfzl());//本次现金支付自理
                             njjbReg2410.setOutName12(siSettlementOutParamInfo.getYbfwnfy());//医保范围内费用
                             njjbReg2410.setOutName13(siSettlementOutParamInfo.getZhxfhye());//帐户消费后余额
                             njjbReg2410.setOutName14(siSettlementOutParamInfo.getDbzbm());//单病种病种编码
                             njjbReg2410.setOutName15(siSettlementOutParamInfo.getSmxx());//说明信息
                             njjbReg2410.setOutName16(siSettlementOutParamInfo.getYfhj());//备用2
                             njjbReg2410.setOutName17(siSettlementOutParamInfo.getZlxmfhj());
                             njjbReg2410.setOutName18(siSettlementOutParamInfo.getBbzf());
                             njjbReg2410.setOutName19(siSettlementOutParamInfo.getYylb());
                             njjbReg2410.setOutName20(siSettlementOutParamInfo.getIsNo());

                             njjbReg2410Mapper.insertSelective(njjbReg2410);

                        }
                    }
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element root = doc.addElement("response");
                    Element header = root.addElement("head");
                    Element data = root.addElement("data");
                    header.addElement("code").setText("0");
                    header.addElement("desc").setText("成功");
                    data.addElement("visitId").setText(visitDate+"^"+clinicMaster.getVisitNo());
                    data.addElement("outRegisterTime").setText(visitDate);
                    data.addElement("outAddress").setText(StringUtil.Iso_GBK(deptDict.getDeptLocation()));
                    data.addElement("outPatientId").setText(pmi.getPatientId());
                    data.addElement("orderNo").setText(clinicMaster.getSerialNo()+"");
                    data.addElement("orderId").setText(orderId);
                    return doc.asXML();
                }else{
                    return getErrorlMsg("入参不能为空！");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }
    private String getTimeDescEng(String timeDesc){
        if(timeDesc.equals("上午")){
            return "am";
        }else if(timeDesc.equals("下午")){
            return "pm";
        }else if(timeDesc.equals("白天")){
            return "day";
        }else{
            return "all";
        }
    }

    private String getHospitalMsg(){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element header = root.addElement("header");
        Element data = root.addElement("data");
        header.addElement("code").setText("0");
        header.addElement("desc").setText("成功");
        data.addElement("unitName").setText("南京八一医院");
        data.addElement("unitIntro").setText("");
        data.addElement("unitAddress").setText("");
        data.addElement("unitLevel").setText("");
        data.addElement("unitPhone").setText("");
        return doc.asXML();
    }

    private String getSuccessMsg(String desc){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element header = root.addElement("header");
        Element data = root.addElement("data");
        header.addElement("code").setText("0");
        header.addElement("desc").setText(desc);
        return doc.asXML();
    }

    private String getErrorlMsg(String desc){
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element header = root.addElement("header");
        Element data = root.addElement("data");
        header.addElement("code").setText("1");
        header.addElement("desc").setText(desc);
        return doc.asXML();
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
    @Test
    public void test(){
        Document document = null;
        try {
            document = DocumentHelper.parseText("<?xml version=\"1.0\" encoding=\"utf-8\"?><request><head><token>8E67BCD9797042FF84474048E6D22BF6</token><time>20140303121212</time></head><data><unitId>1000001</unitId></data></request>\n");
            Element root = document.getRootElement();
//            String unitld = root.element("data").element("unitld").getTextTrim();
            Element data = root.element("data");
            String unitld = data.element("unitId").getText();
            logger.info(unitld);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private String generateVisitNo(Date visitDate){
        String visitNo;
        while (true){
            visitNo = recpNoMapper.selectVisitNo().getRecpNo();
            ClinicMasterKey masterKey = new ClinicMasterKey();
            masterKey.setVisitDate(visitDate);
            masterKey.setVisitNo(Short.parseShort(visitNo));
            if(clinicMasterMapper.selectByPrimaryKey(masterKey) == null)
                return visitNo;
        }
    }

    /**
     * add by Tang, 并发保护
     * @param clinicMaster ClinicMaster
     */
    private void checkSerialNo(ClinicMaster clinicMaster){
        int maxSerialNo = clinicMasterMapper.getMaxSerialNo(clinicMaster.getVisitDate(),
                clinicMaster.getClinicLabel(),clinicMaster.getVisitTimeDesc());
        if(maxSerialNo >= clinicMaster.getSerialNo()){
            clinicMaster.setSerialNo((short)(maxSerialNo + 1));
        }
    }

    public static  void main(String[] args){
        String ss ="0007-20180403174320-221^1882822455|10093789|江苏健康无忧网络科技有限公司|321281199203113554|姜根|1|11|0|320140|1455.49|0|0|1|||0||0||0||0||0||0||0|||0||0||0|||0||0|||0|||0|0|0|||0|0|0|^^";
       //  SiClassUtil.getSiReadCardInfo(ss);
        System.out.println( "2345678="+SiClassUtil.getSiReadCardInfo(ss));
    }
}
