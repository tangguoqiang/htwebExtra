package com.ht.extra.regTreatment.impl;

import com.haitaiinc.Util;
import com.ht.extra.dao.*;
import com.ht.extra.njyb.*;
import com.ht.extra.pojo.RecordNo;
import com.ht.extra.pojo.comm.*;
import com.ht.extra.pojo.inpbill.InternetPayinfo;
import com.ht.extra.pojo.inpbill.ItemRelation;
import com.ht.extra.pojo.inpbill.PayOrderRecord;
import com.ht.extra.pojo.insurance.*;
import com.ht.extra.pojo.medrec.PatMasterIndex;
import com.ht.extra.pojo.outpadm.*;
import com.ht.extra.pojo.outpbill.OutpBillItems;
import com.ht.extra.pojo.outpbill.OutpOrderDesc;
import com.ht.extra.pojo.outpbill.OutpPaymentsMoney;
import com.ht.extra.pojo.outpbill.OutpRcptMaster;
import com.ht.extra.pojo.outpdoct.*;
import com.ht.extra.regTreatment.RegTreatment;
import com.ht.extra.util.DateToWeek;
import com.ht.extra.util.PinyinTool;
import com.ht.extra.util.SiClassUtil;
import com.ht.extra.util.StringUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by jpzhang on 2017/9/13.
 */

public class RegTreatmentImpl implements RegTreatment {
    private static Logger logger = Logger.getLogger(RegTreatmentImpl.class);

    @Resource
    private ClinicForRegistMapper clinicForRegistMapper;
    @Resource
    private ClinicScheduleMapper clinicScheduleMapper;
    @Resource
    private DeptDictMapper deptDictMapper;
    @Resource
    private UsersMapper usersMapper;
    @Resource
    private PriceListMapper priceListMapper;
    @Resource
    private PatIccardRecNewMapper patIccardRecNewMapper;
    @Resource
    public PatMasterIndexMapper patMasterIndexMapper;
    @Resource
    public ChargeTypeDictMapper chargeTypeDictMapper;
    @Resource
    private RecpNoMapper recpNoMapper;
    @Resource
    private PayOrderRecordMapper payOrderRecordMapper;
    @Resource
    public InternetPayinfoMapper internetPayinfoMapper;
    @Resource
    public OutpOrdersTMapper outpOrdersTMapper;
    @Resource
    public OutpOrdersCostsMapper outpOrdersCostsMapper;
    @Resource
    public OutpRcptMasterMapper outpRcptMasterMapper;
    @Resource
    public OutpPaymentsMoneyMapper outpPaymentsMoneyMapper;
    @Resource
    public ClinicMasterMapper clinicMasterMapper;
    @Resource
    public OutpOrderDescMapper outpOrderDescMapper;
    @Resource
    public OutpBillItemsMapper outpBillItemsMapper;

    @Resource
    public InsuVsHospitalDeptMapper insuVsHospitalDeptMapper;
    @Resource
    public InsuOutpClinicMasterMapper insuOutpClinicMasterMapper;
    @Resource
    public InsuOutpBillDetailMapper insuOutpBillDetailMapper;
    @Resource
    public InsuOutpSettleRecordMapper insuOutpSettleRecordMapper;
    @Resource
    public InsuVsPriceMapper insuVsPriceMapper;
    @Resource
    private RecordNoMapper recordNoMapper;
    @Resource
    private ClinicVsChargeMapper clinicVsChargeMapper;
    @Resource
    private ItemRelationMapper itemRelationMapper;
    @Resource
    public InsuDoctorDictMapper insuDoctorDictMapper;
    @Resource
    private ClinicAppointsMapper clinicAppointsMapper;
    @Resource
    private ClinicIndexMapper clinicIndexMapper;
    @Resource
    private CurrentPriceListMapper currentPriceListMapper;
    @Resource
    private ScanPayMapper scanPayMapper;
    @Resource
    private InsuranceAccountsNjjbMapper insuranceAccountsNjjbMapper;
    @Resource
    private Njjb2100Mapper njjb2100Mapper;
    @Resource
    private BankTradeLogMapper bankTradeLogMapper;
    @Resource
    private OutpMrMapper outpMrMapper;
    @Resource
    private OutpPrescMapper outpPrescMapper;
    @Resource
    private NjjbOutp2210Mapper njjbOutp2210Mapper;
    @Resource
    private NjjbOutp2420Mapper njjbOutp2420Mapper;
    @Resource
    private NjjbOutp2410Mapper njjbOutp2410Mapper;
    @Resource
    private NjjbOutp2310Mapper njjbOutp2310Mapper;
    @Resource
    private AppConfigerParameterMapper appConfigerParameterMapper;
    @Resource
    private InsuranceVsDiagnosisMapper insuranceVsDiagnosisMapper;

    /**
     * 获取用户信息接口 用户信息查询和用户信息验证
     *
     * @param xmlParam
     * @return
     */
    @Override
    public String getPatientInfo(String xmlParam) {
        logger.info("[获取用户信息  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element root = document.getRootElement();
            String cCardNo = root.element("body").element("cCardNo").getText();  //市民卡
            String cardNo = root.element("body").element("cardNo").getText(); //医保卡号
            String cardNoType = root.element("body").element("cardNoType").getText(); //诊疗卡类型
            String idenNo = root.element("body").element("idenNo").getText(); //身份证号
            String patientId = root.element("body").element("patientId").getText();
            String result = "";
            if ((cardNo != null && cardNo.length() > 0) || (idenNo != null && idenNo.length() > 0) || (cCardNo != null && cCardNo.length() > 0)) {
                PatIccardRecNew patIccardRecNew = new PatIccardRecNew();
                if (cardNo != null && cardNo.length() > 0) {
                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
                } else if (idenNo != null && idenNo.length() > 0) {
                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
                } else if (cCardNo != null && cCardNo.length() > 0) {
                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
                }
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element rootElement = doc.addElement("response");
                Element header = rootElement.addElement("head");
                if (patIccardRecNew != null) {
                    PatMasterIndex patMasterIndex =
                            patMasterIndexMapper.selectByPatientId(patIccardRecNew.getPatientId()); //没有增加军队医改的限制

                    // 1.如果用户以身份证登陆,且身份证号和库中不一致
                    // 2.如果用户以医保卡登陆,且医保卡号和库中不一致
                    // 3.如果用户以市民卡登陆,且市民卡号和库中不一致
                    if ((!StringUtils.isEmpty(idenNo) && !idenNo.equals(patMasterIndex.getIdNo()))
                            || (!StringUtils.isEmpty(cardNo) && !cardNo.equals(patMasterIndex.getInsurancesNo()))
                            || (!StringUtils.isEmpty(cCardNo) && !cCardNo.equals(patIccardRecNew.getIccardNo()))) {
                        header.addElement("code").setText("2");
                        header.addElement("desc").setText("此患者信息有误,请到柜台挂号!!");
                    } else {
                        header.addElement("code").setText("0");
                        header.addElement("desc").setText("此患者已注册");
                        Element data = rootElement.addElement("body");
                        data.addElement("patientId").setText(patMasterIndex.getPatientId());
                        data.addElement("cardNo").setText(cardNo);
                        data.addElement("cardNoType").setText(StringUtil.Iso_GBK(cardNoType));
                        data.addElement("name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                        String sex = StringUtil.Iso_GBK(patMasterIndex.getSex());
                        if (sex != null && sex.length() > 0) {
                            if ("男".equals(sex)) {
                                data.addElement("sexCode").setText("M");
                                data.addElement("sexName").setText(sex);
                            } else if ("女".equals(sex)) {
                                data.addElement("sexCode").setText("F");
                                data.addElement("sexName").setText(sex);
                            } else {
                                data.addElement("sexCode").setText("O");
                                data.addElement("sexName").setText("其他");
                            }

                        } else {
                            data.addElement("sexCode").setText("O");
                            data.addElement("sexName").setText("其他");
                        }

                        data.addElement("birthday").setText(DateToWeek.formatDateString(patMasterIndex.getDateOfBirth(), "yyyy-MM-dd"));
                        if (patMasterIndex.getIdNo() != null) {
                            if (patMasterIndex.getIdNo().length() != 15 && patMasterIndex.getIdNo().length() != 18) {
                                data.addElement("idenNo").setText("");
                            } else {
                                data.addElement("idenNo").setText(patMasterIndex.getIdNo());
                            }
                        } else {
                            data.addElement("idenNo").setText("");
                        }
                        if (patMasterIndex.getMailingAddress() != null) {
                            data.addElement("home").setText(StringUtil.Iso_GBK(patMasterIndex.getMailingAddress()));
                        } else {
                            data.addElement("home").setText("");
                        }
                        if (patMasterIndex.getPhoneNumberHome() != null) {
                            data.addElement("homeTel").setText(patMasterIndex.getPhoneNumberHome());
                        } else {
                            data.addElement("homeTel").setText("");
                        }
                        ChargeTypeDict chargeTypeDict =
                                chargeTypeDictMapper.selectByPrimaryKey(patMasterIndex.getChargeType());
                        if (chargeTypeDict != null) {
                            data.addElement("personalType").setText(chargeTypeDict.getChargeTypeCode());
                        } else {
                            data.addElement("personalType").setText("");
                        }
                        data.addElement("personalTypeName").setText(StringUtil.Iso_GBK(patMasterIndex.getChargeType()));
                        data.addElement("specialKindDesc").setText("01");
                        data.addElement("siCardNo").setText(cardNo);
                        data.addElement("siType").setText("");
                        data.addElement("yztRealNameFlag").setText("");
                        data.addElement("yztPatientIndex").setText("");
                    }
                } else {
                    header.addElement("code").setText("1");
                    header.addElement("desc").setText("此患者未注册");
                }
                logger.info(doc.asXML());
                result = doc.asXML();
            } else if (patientId != null && patientId.length() > 0) {
                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientId); //没有增加军队医改的限制
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element rootElement = doc.addElement("response");
                Element header = root.addElement("head");
                if (patMasterIndex != null) {
                    header.addElement("code").setText("0");
                    header.addElement("desc").setText("此患者已注册");
                    Element data = rootElement.addElement("body");

                    data.addElement("patientId").setText(patMasterIndex.getPatientId());
                    data.addElement("cardNo").setText(cardNo);
                    data.addElement("cardNoType").setText(StringUtil.Iso_GBK(cardNoType));
                    data.addElement("name").setText(StringUtil.Iso_GBK(patMasterIndex.getName()));
                    String sex = StringUtil.Iso_GBK(patMasterIndex.getSex());
                    if (sex != null && sex.length() > 0) {
                        if ("男".equals(sex)) {
                            data.addElement("sexCode").setText("M");
                            data.addElement("sexName").setText(sex);
                        } else if ("女".equals(sex)) {
                            data.addElement("sexCode").setText("F");
                            data.addElement("sexName").setText(sex);
                        } else {
                            data.addElement("sexCode").setText("O");
                            data.addElement("sexName").setText("其他");
                        }

                    } else {
                        data.addElement("sexCode").setText("O");
                        data.addElement("sexName").setText("其他");
                    }

                    data.addElement("birthday").setText(DateToWeek.formatDateString(patMasterIndex.getDateOfBirth(),
                            "yyyy-MM-dd"));
                    if (patMasterIndex.getIdNo() != null) {
                        if (patMasterIndex.getIdNo().length() != 15 && patMasterIndex.getIdNo().length() != 18) {
                            data.addElement("idenNo").setText("");
                        } else {
                            data.addElement("idenNo").setText(patMasterIndex.getIdNo());
                        }
                    } else {
                        data.addElement("idenNo").setText("");
                    }
                    if (patMasterIndex.getMailingAddress() != null) {
                        data.addElement("home").setText(StringUtil.Iso_GBK(patMasterIndex.getMailingAddress()));
                    } else {
                        data.addElement("home").setText("");
                    }
                    if (patMasterIndex.getPhoneNumberHome() != null) {
                        data.addElement("homeTel").setText(patMasterIndex.getPhoneNumberHome());
                    } else {
                        data.addElement("homeTel").setText("");
                    }
                    ChargeTypeDict chargeTypeDict =
                            chargeTypeDictMapper.selectByPrimaryKey(patMasterIndex.getChargeType());
                    if (chargeTypeDict != null) {
                        data.addElement("personalType").setText(chargeTypeDict.getChargeTypeCode());
                    } else {
                        data.addElement("personalType").setText("");
                    }
                    data.addElement("personalTypeName").setText(StringUtil.Iso_GBK(patMasterIndex.getChargeType()));
                    data.addElement("specialKindDesc").setText("01");
                    data.addElement("siCardNo").setText(cardNo);
                    data.addElement("siType").setText("");
                    data.addElement("yztRealNameFlag").setText("");
                    data.addElement("yztPatientIndex").setText("");

                    logger.info(doc.asXML());
                    result = doc.asXML();
                } else {
                    header.addElement("code").setText("1");
                    header.addElement("desc").setText("此患者未注册");
                    logger.info(doc.asXML());
                    result = doc.asXML();
                }
            } else {
                return getErrorlMsg("输入参数有误！！！");
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 用户HIS信息注册 用户初诊信息注册(如果用户所持的医疗卡未在当前HIS系统中注册过，需要调用该接口将用户的信息在HIS系统中进行注册。)
     *
     * @param xmlParam
     * @return
     */
    @Override
    @Transactional
    public String registerCtznCard(String xmlParam) {
        logger.info("[用户HIS信息注册  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element root = document.getRootElement();
            String cCardNo = root.element("body").element("cCardNo").getText();  //市民卡
            String cardNo = root.element("body").element("cardNo").getText(); //诊疗卡卡号(医保卡)
            String cardNoType = root.element("body").element("cardNoType").getText(); //诊疗卡类型  1 医保卡
            String idenNo = root.element("body").element("idenNo").getText(); //身份证号
            String homeTel = root.element("body").element("homeTel").getText(); //联系电话
            String name = root.element("body").element("name").getText();
            String sexCode = root.element("body").element("sexCode").getText();
            String birthday = root.element("body").element("birthday").getText();//yyyy-MM-dd
            String identity = root.element("body").element("identity").getText(); //患者身份
            String personalTypeName = root.element("body").element("personalTypeName").getText();
            String nation = root.element("body").element("nation").getText();//民族
            String address = root.element("body").element("address").getText();//地址
            String namePhonetic = PinyinTool.toPinYin(name, " ", PinyinTool.Type.UPPERCASE);
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element rootElement = doc.addElement("response");
            Element header = rootElement.addElement("head");
            String chargeType = "";
            if ("在职".equals(personalTypeName)) {
                chargeType = "职工医保";
            } else if ("退休".equals(personalTypeName)) {
                chargeType = "职工医保";
            } else if ("退职".equals(personalTypeName)) {
                chargeType = "职工医保";
            } else if ("70岁以上退休".equals(personalTypeName)) {
                chargeType = "职工医保";
            } else if ("退休待审核".equals(personalTypeName)) {
                chargeType = "职工医保";
            } else if ("离休".equals(personalTypeName)) {
                chargeType = "市统筹";
            } else if ("地市级离休".equals(personalTypeName)) {
                chargeType = "市统筹";
            } else if ("建国前老工人".equals(personalTypeName)) {
                chargeType = "市统筹";
            } else if ("二乙伤残军人".equals(personalTypeName)) {
                chargeType = "市统筹";
            } else if ("普通居民".equals(personalTypeName)) {
                chargeType = "居民医保";
            } else if ("儿童学生".equals(personalTypeName)) {
                chargeType = "儿童医保";
            } else if ("大学生".equals(personalTypeName)) {
                chargeType = "大学生";
            } else if ("建筑业农民工".equals(personalTypeName)) {
                chargeType = "农工医保";
            } else {
                chargeType = personalTypeName;
            }
            if (idenNo != null && idenNo.length() > 0) {
                if (cCardNo != null && cCardNo.length() > 0) { //市民卡不为空
                    PatIccardRecNew patCardNo = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
                    if (patCardNo != null) { //市民卡卡存在
                        PatIccardRecNew patIdNo = patIccardRecNewMapper.selectByPrimaryKey(idenNo);//身份证号
                        if (patIdNo != null) {//市民卡存在,身份证存在（不做处理直接返回）
                            if (patCardNo.getPatientId().equals(patIdNo.getPatientId())) { //只有一个patientId
                                PatMasterIndex pmi = new PatMasterIndex();
                                pmi.setPatientId(patIdNo.getPatientId());
//                            pmi.setInpNo("");
                                if (name.length() > 4) {
                                    pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                } else {
                                    pmi.setName(StringUtil.Utf_Iso(name));
                                }
                                logger.info("zjp----->" + namePhonetic);
                                if (namePhonetic.length() > 16) {
                                    pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                } else {
                                    pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                }
                                String sexDecs = "";
                                if (sexCode.equals("M")) {
                                    sexDecs = "男";
                                } else if (sexCode.equals("F")) {
                                    sexDecs = "女";
                                } else {
                                    sexDecs = "未知";
                                }
                                pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                                pmi.setBirthPlace(idenNo.substring(0, 6));
                                pmi.setCitizenship("CN");
                                if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                    pmi.setNation(null);
                                    pmi.setMailingAddress(null);
                                } else {
                                    pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                    pmi.setMailingAddress(truncateStr(address, 40));
                                }
                                pmi.setIdNo(idenNo);
                                pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                pmi.setUnitInContract("");
                                pmi.setZipCode("");
                                pmi.setPhoneNumberHome(homeTel);
                                pmi.setPhoneNumberBusiness("");
                                pmi.setNextOfKin("");
                                pmi.setRelationship("");
                                pmi.setNextOfKinAddr("");
                                pmi.setNextOfKinZipCode("");
                                pmi.setNextOfKinPhone("");
                                pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                pmi.setLastVisitDate(new Date());
                                pmi.setOperator("ZZJ");
                                pmi.setInsurancesNo(cardNo);
                                pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                //校验
                                PatMasterIndex patMasterIndex =
                                        patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId()); //没有增加军队医改的限制
                                if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                    patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                }
                                patMasterIndex = patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId());
                                //没有增加军队医改的限制
                                if (patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0) {
                                    header.addElement("code").setText("0");
                                    header.addElement("desc").setText("成功");
                                    header.addElement("patientId").setText(patIdNo.getPatientId());
                                } else {
                                    header.addElement("code").setText("1");
                                    header.addElement("desc").setText("身份证更新失败！！！");
                                    header.addElement("patientId").setText(patIdNo.getPatientId());
                                }

                            } else { //两个patientId
                                PatMasterIndex pacCardNo =
                                        patMasterIndexMapper.selectByPatientId(patCardNo.getPatientId());
                                PatMasterIndex pacIdenNo =
                                        patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId());
                                if (pacCardNo.getInpNo() != null && pacCardNo.getInpNo().length() > 0 && pacIdenNo.getInpNo() != null && pacIdenNo.getInpNo().length() > 0) { //两个住院号都不为空
                                    if (new BigDecimal(pacCardNo.getInpNo()).compareTo(new BigDecimal(pacIdenNo.getInpNo())) < 0) { //
                                        PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                        pirnIdNo.setPatientId(pacCardNo.getPatientId());
                                        pirnIdNo.setIccardNo(patIdNo.getIccardNo());
                                        pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                        PatMasterIndex pmi = new PatMasterIndex();
                                        pmi.setPatientId(pacCardNo.getPatientId());
//                            pmi.setInpNo("");
                                        if (name.length() > 4) {
                                            pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                        } else {
                                            pmi.setName(StringUtil.Utf_Iso(name));
                                        }
                                        logger.info("zjp----->" + namePhonetic);
                                        if (namePhonetic.length() > 16) {
                                            pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                        } else {
                                            pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                        }
                                        String sexDecs = "";
                                        if (sexCode.equals("M")) {
                                            sexDecs = "男";
                                        } else if (sexCode.equals("F")) {
                                            sexDecs = "女";
                                        } else {
                                            sexDecs = "未知";
                                        }
                                        pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                        pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,
                                                "yyyy-MM-dd").getTime())); //出生日期
                                        pmi.setBirthPlace(idenNo.substring(0, 6));
                                        pmi.setCitizenship("CN");
                                        if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                            pmi.setNation(null);
                                            pmi.setMailingAddress(null);
                                        } else {
                                            pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                            pmi.setMailingAddress(truncateStr(address, 40));
                                        }
                                        pmi.setIdNo(idenNo);
                                        pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                        pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                        pmi.setUnitInContract("");
                                        pmi.setZipCode("");
                                        pmi.setPhoneNumberHome(homeTel);
                                        pmi.setPhoneNumberBusiness("");
                                        pmi.setNextOfKin("");
                                        pmi.setRelationship("");
                                        pmi.setNextOfKinAddr("");
                                        pmi.setNextOfKinZipCode("");
                                        pmi.setNextOfKinPhone("");
                                        pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                        pmi.setLastVisitDate(new Date());
                                        pmi.setOperator("ZZJ");
                                        pmi.setInsurancesNo(cardNo);
                                        pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                        patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                        patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        //校验
                                        PatMasterIndex patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId()); //没有增加军队医改的限制
                                        if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        }
                                        patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId()); //没有增加军队医改的限制
                                        if (patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0) {
                                            header.addElement("code").setText("0");
                                            header.addElement("desc").setText("成功");
                                            header.addElement("patientId").setText(pacCardNo.getPatientId());
                                        } else {
                                            header.addElement("code").setText("1");
                                            header.addElement("desc").setText("身份证更新失败！！！");
                                            header.addElement("patientId").setText(pacCardNo.getPatientId());
                                        }
                                    } else {
                                        PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                        pirnIdNo.setPatientId(pacIdenNo.getPatientId());
                                        pirnIdNo.setIccardNo(patCardNo.getIccardNo());
                                        pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                        PatMasterIndex pmi = new PatMasterIndex();
                                        pmi.setPatientId(pacIdenNo.getPatientId());
//                            pmi.setInpNo("");
                                        if (name.length() > 4) {
                                            pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                        } else {
                                            pmi.setName(StringUtil.Utf_Iso(name));
                                        }
                                        logger.info("zjp----->" + namePhonetic);
                                        if (namePhonetic.length() > 16) {
                                            pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                        } else {
                                            pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                        }
                                        String sexDecs = "";
                                        if (sexCode.equals("M")) {
                                            sexDecs = "男";
                                        } else if (sexCode.equals("F")) {
                                            sexDecs = "女";
                                        } else {
                                            sexDecs = "未知";
                                        }
                                        pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                        pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,
                                                "yyyy-MM-dd").getTime())); //出生日期
                                        pmi.setBirthPlace(idenNo.substring(0, 6));
                                        pmi.setCitizenship("CN");
                                        if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                            pmi.setNation(null);
                                            pmi.setMailingAddress(null);
                                        } else {
                                            pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                            pmi.setMailingAddress(truncateStr(address, 40));
                                        }
                                        pmi.setIdNo(idenNo);
                                        pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                        pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                        pmi.setUnitInContract("");
                                        pmi.setZipCode("");
                                        pmi.setPhoneNumberHome(homeTel);
                                        pmi.setPhoneNumberBusiness("");
                                        pmi.setNextOfKin("");
                                        pmi.setRelationship("");
                                        pmi.setNextOfKinAddr("");
                                        pmi.setNextOfKinZipCode("");
                                        pmi.setNextOfKinPhone("");
                                        pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                        pmi.setLastVisitDate(new Date());
                                        pmi.setOperator("ZZJ");
                                        pmi.setInsurancesNo(cardNo);
                                        pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                        patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                        patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        //校验
                                        PatMasterIndex patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId()); //没有增加军队医改的限制
                                        if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        }
                                        patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId()); //没有增加军队医改的限制
                                        if (patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0) {
                                            header.addElement("code").setText("0");
                                            header.addElement("desc").setText("成功");
                                            header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                        } else {
                                            header.addElement("code").setText("1");
                                            header.addElement("desc").setText("身份证更新失败！！！");
                                            header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                        }
                                    }
                                } else {
                                    if (pacCardNo.getInpNo() != null && pacCardNo.getInpNo().length() > 0) { //
                                        PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                        pirnIdNo.setPatientId(pacCardNo.getPatientId());
                                        pirnIdNo.setIccardNo(patIdNo.getIccardNo());
                                        pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                        PatMasterIndex pmi = new PatMasterIndex();
                                        pmi.setPatientId(pacCardNo.getPatientId());
//                            pmi.setInpNo("");
                                        if (name.length() > 4) {
                                            pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                        } else {
                                            pmi.setName(StringUtil.Utf_Iso(name));
                                        }
                                        logger.info("zjp----->" + namePhonetic);
                                        if (namePhonetic.length() > 16) {
                                            pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                        } else {
                                            pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                        }
                                        String sexDecs = "";
                                        if (sexCode.equals("M")) {
                                            sexDecs = "男";
                                        } else if (sexCode.equals("F")) {
                                            sexDecs = "女";
                                        } else {
                                            sexDecs = "未知";
                                        }
                                        pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                        pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,
                                                "yyyy-MM-dd").getTime())); //出生日期
                                        pmi.setBirthPlace(idenNo.substring(0, 6));
                                        pmi.setCitizenship("CN");
                                        if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                            pmi.setNation(null);
                                            pmi.setMailingAddress(null);
                                        } else {
                                            pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                            pmi.setMailingAddress(truncateStr(address, 40));
                                        }
                                        pmi.setIdNo(idenNo);
                                        pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                        pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                        pmi.setUnitInContract("");
                                        pmi.setZipCode("");
                                        pmi.setPhoneNumberHome(homeTel);
                                        pmi.setPhoneNumberBusiness("");
                                        pmi.setNextOfKin("");
                                        pmi.setRelationship("");
                                        pmi.setNextOfKinAddr("");
                                        pmi.setNextOfKinZipCode("");
                                        pmi.setNextOfKinPhone("");
                                        pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                        pmi.setLastVisitDate(new Date());
                                        pmi.setOperator("ZZJ");
                                        pmi.setInsurancesNo(cardNo);
                                        pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                        patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                        patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        //校验
                                        PatMasterIndex patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId()); //没有增加军队医改的限制
                                        if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        }
                                        patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId()); //没有增加军队医改的限制
                                        if (patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0) {
                                            header.addElement("code").setText("0");
                                            header.addElement("desc").setText("成功");
                                            header.addElement("patientId").setText(pacCardNo.getPatientId());
                                        } else {
                                            header.addElement("code").setText("1");
                                            header.addElement("desc").setText("身份证更新失败！！！");
                                            header.addElement("patientId").setText(pacCardNo.getPatientId());
                                        }
                                    } else if (pacIdenNo.getInpNo() != null && pacIdenNo.getInpNo().length() > 0) {
                                        PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                        pirnIdNo.setPatientId(pacIdenNo.getPatientId());
                                        pirnIdNo.setIccardNo(patCardNo.getIccardNo());
                                        pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                        PatMasterIndex pmi = new PatMasterIndex();
                                        pmi.setPatientId(pacIdenNo.getPatientId());
//                            pmi.setInpNo("");
                                        if (name.length() > 4) {
                                            pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                        } else {
                                            pmi.setName(StringUtil.Utf_Iso(name));
                                        }
                                        logger.info("zjp----->" + namePhonetic);
                                        if (namePhonetic.length() > 16) {
                                            pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                        } else {
                                            pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                        }
                                        String sexDecs = "";
                                        if (sexCode.equals("M")) {
                                            sexDecs = "男";
                                        } else if (sexCode.equals("F")) {
                                            sexDecs = "女";
                                        } else {
                                            sexDecs = "未知";
                                        }
                                        pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                        pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,
                                                "yyyy-MM-dd").getTime())); //出生日期
                                        pmi.setBirthPlace(idenNo.substring(0, 6));
                                        pmi.setCitizenship("CN");
                                        if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                            pmi.setNation(null);
                                            pmi.setMailingAddress(null);
                                        } else {
                                            pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                            pmi.setMailingAddress(truncateStr(address, 40));
                                        }
                                        pmi.setIdNo(idenNo);
                                        pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                        pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                        pmi.setUnitInContract("");
                                        pmi.setZipCode("");
                                        pmi.setPhoneNumberHome(homeTel);
                                        pmi.setPhoneNumberBusiness("");
                                        pmi.setNextOfKin("");
                                        pmi.setRelationship("");
                                        pmi.setNextOfKinAddr("");
                                        pmi.setNextOfKinZipCode("");
                                        pmi.setNextOfKinPhone("");
                                        pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                        pmi.setLastVisitDate(new Date());
                                        pmi.setOperator("ZZJ");
                                        pmi.setInsurancesNo(cardNo);
                                        pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                        patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                        patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        //校验
                                        PatMasterIndex patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId()); //没有增加军队医改的限制
                                        if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                        }
                                        patMasterIndex =
                                                patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId()); //没有增加军队医改的限制
                                        if (patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0) {
                                            header.addElement("code").setText("0");
                                            header.addElement("desc").setText("成功");
                                            header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                        } else {
                                            header.addElement("code").setText("1");
                                            header.addElement("desc").setText("身份证更新失败！！！");
                                            header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                        }
                                    } else { //都为空
                                        if (pacCardNo.getIdNo() != null && pacCardNo.getIdNo().length() > 0) {
                                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                            pirnIdNo.setPatientId(pacCardNo.getPatientId());
                                            pirnIdNo.setIccardNo(patIdNo.getIccardNo());
                                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                            PatMasterIndex pmi = new PatMasterIndex();
                                            pmi.setPatientId(pacCardNo.getPatientId());
//                            pmi.setInpNo("");
                                            if (name.length() > 4) {
                                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                            } else {
                                                pmi.setName(StringUtil.Utf_Iso(name));
                                            }
                                            logger.info("zjp----->" + namePhonetic);
                                            if (namePhonetic.length() > 16) {
                                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                            } else {
                                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                            }
                                            String sexDecs = "";
                                            if (sexCode.equals("M")) {
                                                sexDecs = "男";
                                            } else if (sexCode.equals("F")) {
                                                sexDecs = "女";
                                            } else {
                                                sexDecs = "未知";
                                            }
                                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM" +
                                                    "-dd").getTime())); //出生日期
                                            pmi.setBirthPlace(idenNo.substring(0, 6));
                                            pmi.setCitizenship("CN");
                                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                pmi.setNation(null);
                                                pmi.setMailingAddress(null);
                                            } else {
                                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                pmi.setMailingAddress(truncateStr(address, 40));
                                            }
                                            pmi.setIdNo(idenNo);
                                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                            pmi.setUnitInContract("");
                                            pmi.setZipCode("");
                                            pmi.setPhoneNumberHome(homeTel);
                                            pmi.setPhoneNumberBusiness("");
                                            pmi.setNextOfKin("");
                                            pmi.setRelationship("");
                                            pmi.setNextOfKinAddr("");
                                            pmi.setNextOfKinZipCode("");
                                            pmi.setNextOfKinPhone("");
                                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                            pmi.setLastVisitDate(new Date());
                                            pmi.setOperator("ZZJ");
                                            pmi.setInsurancesNo(cardNo);
                                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                            patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            //校验
                                            PatMasterIndex patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            }
                                            patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0) {
                                                header.addElement("code").setText("0");
                                                header.addElement("desc").setText("成功");
                                                header.addElement("patientId").setText(pacCardNo.getPatientId());
                                            } else {
                                                header.addElement("code").setText("1");
                                                header.addElement("desc").setText("身份证更新失败！！！");
                                                header.addElement("patientId").setText(pacCardNo.getPatientId());
                                            }
                                        } else {
                                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                            pirnIdNo.setPatientId(pacIdenNo.getPatientId());
                                            pirnIdNo.setIccardNo(patCardNo.getIccardNo());
                                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                            PatMasterIndex pmi = new PatMasterIndex();
                                            pmi.setPatientId(pacIdenNo.getPatientId());
//                            pmi.setInpNo("");
                                            if (name.length() > 4) {
                                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                            } else {
                                                pmi.setName(StringUtil.Utf_Iso(name));
                                            }
                                            logger.info("zjp----->" + namePhonetic);
                                            if (namePhonetic.length() > 16) {
                                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                            } else {
                                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                            }
                                            String sexDecs = "";
                                            if (sexCode.equals("M")) {
                                                sexDecs = "男";
                                            } else if (sexCode.equals("F")) {
                                                sexDecs = "女";
                                            } else {
                                                sexDecs = "未知";
                                            }
                                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM" +
                                                    "-dd").getTime())); //出生日期
                                            pmi.setBirthPlace(idenNo.substring(0, 6));
                                            pmi.setCitizenship("CN");
                                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                pmi.setNation(null);
                                                pmi.setMailingAddress(null);
                                            } else {
                                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                pmi.setMailingAddress(truncateStr(address, 40));
                                            }
                                            pmi.setIdNo(idenNo);
                                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                            pmi.setUnitInContract("");
                                            pmi.setZipCode("");
                                            pmi.setPhoneNumberHome(homeTel);
                                            pmi.setPhoneNumberBusiness("");
                                            pmi.setNextOfKin("");
                                            pmi.setRelationship("");
                                            pmi.setNextOfKinAddr("");
                                            pmi.setNextOfKinZipCode("");
                                            pmi.setNextOfKinPhone("");
                                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                            pmi.setLastVisitDate(new Date());
                                            pmi.setOperator("ZZJ");
                                            pmi.setInsurancesNo(cardNo);
                                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                            patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            //校验
                                            PatMasterIndex patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            }
                                            patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0) {
                                                header.addElement("code").setText("0");
                                                header.addElement("desc").setText("成功");
                                                header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                            } else {
                                                header.addElement("code").setText("1");
                                                header.addElement("desc").setText("身份证更新失败！！！");
                                                header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                            }
                                        }
                                    }
                                }
                            }


                        } else {//市民卡存在，身份证不存在
                            //1.insert  RecNew（身份证）
                            //1.1 插入身份证
                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                            pirnIdNo.setPatientId(patCardNo.getPatientId());
                            pirnIdNo.setIccardNo(idenNo);
                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM" +
                                    "-dd"), "yyyy-MM-dd").getTime()));
                            //2.insert  patMasterIndex
                            PatMasterIndex pmi = new PatMasterIndex();
                            pmi.setPatientId(patCardNo.getPatientId());
//                            pmi.setInpNo("");
                            if (name.length() > 4) {
                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                            } else {
                                pmi.setName(StringUtil.Utf_Iso(name));
                            }
                            logger.info("zjp----->" + namePhonetic);
                            if (namePhonetic.length() > 16) {
                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                            } else {
                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                            }
                            String sexDecs = "";
                            if (sexCode.equals("M")) {
                                sexDecs = "男";
                            } else if (sexCode.equals("F")) {
                                sexDecs = "女";
                            } else {
                                sexDecs = "未知";
                            }
                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                            pmi.setBirthPlace(idenNo.substring(0, 6));
                            pmi.setCitizenship("CN");
                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                pmi.setNation(null);
                                pmi.setMailingAddress(null);
                            } else {
                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                pmi.setMailingAddress(truncateStr(address, 40));
                            }
                            pmi.setIdNo(idenNo);
                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                            pmi.setUnitInContract("");
                            pmi.setZipCode("");
                            pmi.setPhoneNumberHome(homeTel);
                            pmi.setPhoneNumberBusiness("");
                            pmi.setNextOfKin("");
                            pmi.setRelationship("");
                            pmi.setNextOfKinAddr("");
                            pmi.setNextOfKinZipCode("");
                            pmi.setNextOfKinPhone("");
                            pmi.setVipIndicator((short) 0);
                            pmi.setCreateDate(new Date());
                            pmi.setOperator("ZZJ");
                            pmi.setInsurancesNo(cardNo);
                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                            patIccardRecNewMapper.insert(pirnIdNo);
                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                            //重新校验是否插入 只需校验身份证号
                            PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                            if (cardNo != null && cardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                            } else if (idenNo != null && idenNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                            } else if (cCardNo != null && cCardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                            }
                            if (patIccardRecNew == null) {
                                patIccardRecNewMapper.insert(pirnIdNo);
                            }
                            patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);


//                            if (cardNo != null && cardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                            } else if (idenNo != null && idenNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                            } else if (cCardNo != null && cCardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                            }

                            PatMasterIndex patMasterIndex =
                                    patMasterIndexMapper.selectByPatientId(patCardNo.getPatientId()); //没有增加军队医改的限制
                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                            }
                            patMasterIndex = patMasterIndexMapper.selectByPatientId(patCardNo.getPatientId());
                            //没有增加军队医改的限制

                            if (patIccardRecNew == null) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("注册失败,注册表未插入信息");
                            } else if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("身份证更新失败！！！");
                                header.addElement("patientId").setText(patCardNo.getPatientId());
                            } else {
                                header.addElement("code").setText("0");
                                header.addElement("desc").setText("成功");
                                header.addElement("patientId").setText(patCardNo.getPatientId());
                            }

                        }
                    } else {
                        PatIccardRecNew patIdNo = patIccardRecNewMapper.selectByPrimaryKey(idenNo);//身份证号
                        if (patIdNo != null) { //市民卡不存在,身份证号存在
                            //1.insert  RecNew（市民卡号）
                            PatIccardRecNew pirn = new PatIccardRecNew();
                            pirn.setPatientId(patIdNo.getPatientId());
                            pirn.setIccardNo(cCardNo);
                            pirn.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd")
                                    , "yyyy-MM-dd").getTime()));
                            //2.update patMasterIndex
                            PatMasterIndex pmi = new PatMasterIndex();
                            pmi.setPatientId(patIdNo.getPatientId());
//                            pmi.setInpNo("");
                            if (name.length() > 4) {
                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                            } else {
                                pmi.setName(StringUtil.Utf_Iso(name));
                            }
                            logger.info("zjp----->" + namePhonetic);
                            if (namePhonetic.length() > 16) {
                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                            } else {
                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                            }
                            String sexDecs = "";
                            if (sexCode.equals("M")) {
                                sexDecs = "男";
                            } else if (sexCode.equals("F")) {
                                sexDecs = "女";
                            } else {
                                sexDecs = "未知";
                            }
                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                            pmi.setBirthPlace(idenNo.substring(0, 6));
                            pmi.setCitizenship("CN");
                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                pmi.setNation(null);
                                pmi.setMailingAddress(null);
                            } else {
                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                pmi.setMailingAddress(truncateStr(address, 40));
                            }
                            pmi.setIdNo(idenNo);
                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                            pmi.setUnitInContract("");
                            pmi.setZipCode("");
                            pmi.setPhoneNumberHome(homeTel);
                            pmi.setPhoneNumberBusiness("");
                            pmi.setNextOfKin("");
                            pmi.setRelationship("");
                            pmi.setNextOfKinAddr("");
                            pmi.setNextOfKinZipCode("");
                            pmi.setNextOfKinPhone("");
                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                            pmi.setLastVisitDate(new Date());
                            pmi.setOperator("ZZJ");
                            pmi.setInsurancesNo(cardNo);
                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                            patIccardRecNewMapper.insert(pirn);
                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                            //重新校验是否插入 只需要检查市民卡号
                            PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                            if (cardNo != null && cardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                            } else if (idenNo != null && idenNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                            } else if (cCardNo != null && cCardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                            }
                            if (patIccardRecNew == null) {
                                patIccardRecNewMapper.insert(pirn);
                            }

                            patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                            if (cardNo != null && cardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                            } else if (idenNo != null && idenNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                            } else if (cCardNo != null && cCardNo.length() > 0) {
//                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                            }

                            PatMasterIndex patMasterIndex =
                                    patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId()); //没有增加军队医改的限制
                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                            }
                            patMasterIndex = patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId());
                            //没有增加军队医改的限制

                            if (patIccardRecNew == null) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("注册失败,注册表未插入信息");
                            } else if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("身份证更新失败！！！");
                                header.addElement("patientId").setText(patIdNo.getPatientId());
                            } else {
                                header.addElement("code").setText("0");
                                header.addElement("desc").setText("成功");
                                header.addElement("patientId").setText(patIdNo.getPatientId());
                            }
//                            if(patIccardRecNew==null){
//                                header.addElement("code").setText("1");
//                                header.addElement("desc").setText("注册失败,注册表未插入信息");
//                            }else{
//                                header.addElement("code").setText("0");
//                                header.addElement("desc").setText("成功");
//                                header.addElement("patientId").setText(patIdNo.getPatientId());
//                            }

                        } else {//市民卡不存在,身份证号不存在
                            //1.insert  RecNew（诊疗卡号和身份证）
                            String patientID = recpNoMapper.selectPatientID().getRecpNo();
                            int lengthDo = patientID.length();
                            if (lengthDo < 8) {
                                for (int i = 0; i < 8 - lengthDo; i++) {
                                    patientID = "0" + patientID;
                                }
                            }
                            patientID = "61" + patientID;
                            //1.1   插入诊疗卡
                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                            pirnIdNo.setPatientId(patientID);
                            pirnIdNo.setIccardNo(idenNo);
                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM" +
                                    "-dd"), "yyyy-MM-dd").getTime()));
                            //1.2 插入身份证

                            //2.insert  patMasterIndex
                            PatMasterIndex pmi = new PatMasterIndex();
                            pmi.setPatientId(patientID);
//                            pmi.setInpNo("");
                            if (name.length() > 4) {
                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                            } else {
                                pmi.setName(StringUtil.Utf_Iso(name));
                            }
                            logger.info("zjp----->" + namePhonetic);
                            if (namePhonetic.length() > 16) {
                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                            } else {
                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                            }

                            String sexDecs = "";
                            if (sexCode.equals("M")) {
                                sexDecs = "男";
                            } else if (sexCode.equals("F")) {
                                sexDecs = "女";
                            } else {
                                sexDecs = "未知";
                            }
                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                            pmi.setBirthPlace(idenNo.substring(0, 6));
                            pmi.setCitizenship("CN");
                            pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                            pmi.setIdNo(idenNo);
                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                            pmi.setUnitInContract("");

                            pmi.setMailingAddress(truncateStr(address, 40));
                            pmi.setZipCode("");
                            pmi.setPhoneNumberHome(homeTel);
                            pmi.setPhoneNumberBusiness("");
                            pmi.setNextOfKin("");
                            pmi.setRelationship("");
                            pmi.setNextOfKinAddr("");
                            pmi.setNextOfKinZipCode("");
                            pmi.setNextOfKinPhone("");
                            pmi.setVipIndicator((short) 0);
                            pmi.setCreateDate(new Date());
                            pmi.setOperator("ZZJ");
                            pmi.setInsurancesNo(cardNo);
                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                            patIccardRecNewMapper.insert(pirnIdNo);
                            patMasterIndexMapper.insertSelective(pmi);

                            //重新校验是否插入
                            PatIccardRecNew patIccardRecNew = new PatIccardRecNew();
                            if (cardNo != null && cardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
                            } else if (idenNo != null && idenNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
                            } else if (cCardNo != null && cCardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
                            }
                            if (patIccardRecNew == null) {
                                patIccardRecNewMapper.insert(pirnIdNo);
                            }
                            PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientID);
                            //没有增加军队医改的限制
                            if (patMasterIndex == null) {
                                patMasterIndexMapper.insertSelective(pmi);
                            }

                            if (cardNo != null && cardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
                            } else if (idenNo != null && idenNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
                            } else if (cCardNo != null && cCardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
                            }
                            patMasterIndex = patMasterIndexMapper.selectByPatientId(patientID); //没有增加军队医改的限制

                            if (patIccardRecNew == null) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("注册失败,注册表未插入信息");
                                header.addElement("patientId").setText(patientID);
                            } else if (patMasterIndex == null) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("注册失败,主表未插入信息");
                                header.addElement("patientId").setText(patientID);
                            } else {
                                header.addElement("code").setText("0");
                                header.addElement("desc").setText("成功");
                                header.addElement("patientId").setText(patientID);
                            }

                        }
                    }
                } else {
                    if (cardNo != null && cardNo.length() > 0) { //诊疗卡卡号不为空
                        PatIccardRecNew patCardNo = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
                        if (patCardNo != null) { //诊疗卡存在
                            PatIccardRecNew patIdNo = patIccardRecNewMapper.selectByPrimaryKey(idenNo);//身份证号
                            if (patIdNo != null) {//诊疗卡存在,身份证存在（不做处理直接返回）
                                if (patCardNo.getPatientId().equals(patIdNo.getPatientId())) { //只有一个patientId
                                    PatMasterIndex pmi = new PatMasterIndex();
                                    pmi.setPatientId(patIdNo.getPatientId());
//                            pmi.setInpNo("");
                                    if (name.length() > 4) {
                                        pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                    } else {
                                        pmi.setName(StringUtil.Utf_Iso(name));
                                    }
                                    logger.info("zjp----->" + namePhonetic);
                                    if (namePhonetic.length() > 16) {
                                        pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                    } else {
                                        pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                    }
                                    String sexDecs = "";
                                    if (sexCode.equals("M")) {
                                        sexDecs = "男";
                                    } else if (sexCode.equals("F")) {
                                        sexDecs = "女";
                                    } else {
                                        sexDecs = "未知";
                                    }
                                    pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                    pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                                    pmi.setBirthPlace(idenNo.substring(0, 6));
                                    pmi.setCitizenship("CN");
                                    if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                        pmi.setNation(null);
                                        pmi.setMailingAddress(null);
                                    } else {
                                        pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                        pmi.setMailingAddress(truncateStr(address, 40));
                                    }
                                    pmi.setIdNo(idenNo);
                                    pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                    pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                    pmi.setUnitInContract("");
                                    pmi.setZipCode("");
                                    pmi.setPhoneNumberHome(homeTel);
                                    pmi.setPhoneNumberBusiness("");
                                    pmi.setNextOfKin("");
                                    pmi.setRelationship("");
                                    pmi.setNextOfKinAddr("");
                                    pmi.setNextOfKinZipCode("");
                                    pmi.setNextOfKinPhone("");
                                    pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                    pmi.setLastVisitDate(new Date());
                                    pmi.setOperator("ZZJ");
                                    pmi.setInsurancesNo(cardNo);
                                    pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                    patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                    PatMasterIndex patMasterIndex =
                                            patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId()); //没有增加军队医改的限制
                                    if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                        patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                    }
                                    patMasterIndex = patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId());
                                    //没有增加军队医改的限制

                                    if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                        header.addElement("code").setText("1");
                                        header.addElement("desc").setText("身份证更新失败！！！");
                                        header.addElement("patientId").setText(patIdNo.getPatientId());
                                    } else {
                                        header.addElement("code").setText("0");
                                        header.addElement("desc").setText("成功");
                                        header.addElement("patientId").setText(patIdNo.getPatientId());
                                    }
                                } else { //两个patientId
                                    PatMasterIndex pacCardNo =
                                            patMasterIndexMapper.selectByPatientId(patCardNo.getPatientId());
                                    PatMasterIndex pacIdenNo =
                                            patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId());
                                    if (pacCardNo.getInpNo() != null && pacCardNo.getInpNo().length() > 0 && pacIdenNo.getInpNo() != null && pacIdenNo.getInpNo().length() > 0) { //两个住院号都不为空
                                        if (new BigDecimal(pacCardNo.getInpNo()).compareTo(new BigDecimal(pacIdenNo.getInpNo())) < 0) { //
                                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                            pirnIdNo.setPatientId(pacCardNo.getPatientId());
                                            pirnIdNo.setIccardNo(patIdNo.getIccardNo());
                                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                            PatMasterIndex pmi = new PatMasterIndex();
                                            pmi.setPatientId(pacCardNo.getPatientId());
//                            pmi.setInpNo("");
                                            if (name.length() > 4) {
                                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                            } else {
                                                pmi.setName(StringUtil.Utf_Iso(name));
                                            }
                                            logger.info("zjp----->" + namePhonetic);
                                            if (namePhonetic.length() > 16) {
                                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                            } else {
                                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                            }
                                            String sexDecs = "";
                                            if (sexCode.equals("M")) {
                                                sexDecs = "男";
                                            } else if (sexCode.equals("F")) {
                                                sexDecs = "女";
                                            } else {
                                                sexDecs = "未知";
                                            }
                                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM" +
                                                    "-dd").getTime())); //出生日期
                                            pmi.setBirthPlace(idenNo.substring(0, 6));
                                            pmi.setCitizenship("CN");
                                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                pmi.setNation(null);
                                                pmi.setMailingAddress(null);
                                            } else {
                                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                pmi.setMailingAddress(truncateStr(address, 40));
                                            }
                                            pmi.setIdNo(idenNo);
                                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                            pmi.setUnitInContract("");
                                            pmi.setZipCode("");
                                            pmi.setPhoneNumberHome(homeTel);
                                            pmi.setPhoneNumberBusiness("");
                                            pmi.setNextOfKin("");
                                            pmi.setRelationship("");
                                            pmi.setNextOfKinAddr("");
                                            pmi.setNextOfKinZipCode("");
                                            pmi.setNextOfKinPhone("");
                                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                            pmi.setLastVisitDate(new Date());
                                            pmi.setOperator("ZZJ");
                                            pmi.setInsurancesNo(cardNo);
                                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                            patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            PatMasterIndex patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            }
                                            patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                            //没有增加军队医改的限制

                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                header.addElement("code").setText("1");
                                                header.addElement("desc").setText("身份证更新失败！！！");
                                                header.addElement("patientId").setText(pacCardNo.getPatientId());
                                            } else {
                                                header.addElement("code").setText("0");
                                                header.addElement("desc").setText("成功");
                                                header.addElement("patientId").setText(pacCardNo.getPatientId());
                                            }
                                        } else {
                                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                            pirnIdNo.setPatientId(pacIdenNo.getPatientId());
                                            pirnIdNo.setIccardNo(patCardNo.getIccardNo());
                                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                            PatMasterIndex pmi = new PatMasterIndex();
                                            pmi.setPatientId(pacIdenNo.getPatientId());
//                            pmi.setInpNo("");
                                            if (name.length() > 4) {
                                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                            } else {
                                                pmi.setName(StringUtil.Utf_Iso(name));
                                            }
                                            logger.info("zjp----->" + namePhonetic);
                                            if (namePhonetic.length() > 16) {
                                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                            } else {
                                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                            }
                                            String sexDecs = "";
                                            if (sexCode.equals("M")) {
                                                sexDecs = "男";
                                            } else if (sexCode.equals("F")) {
                                                sexDecs = "女";
                                            } else {
                                                sexDecs = "未知";
                                            }
                                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM" +
                                                    "-dd").getTime())); //出生日期
                                            pmi.setBirthPlace(idenNo.substring(0, 6));
                                            pmi.setCitizenship("CN");
                                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                pmi.setNation(null);
                                                pmi.setMailingAddress(null);
                                            } else {
                                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                pmi.setMailingAddress(truncateStr(address, 40));
                                            }
                                            pmi.setIdNo(idenNo);
                                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                            pmi.setUnitInContract("");
                                            pmi.setZipCode("");
                                            pmi.setPhoneNumberHome(homeTel);
                                            pmi.setPhoneNumberBusiness("");
                                            pmi.setNextOfKin("");
                                            pmi.setRelationship("");
                                            pmi.setNextOfKinAddr("");
                                            pmi.setNextOfKinZipCode("");
                                            pmi.setNextOfKinPhone("");
                                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                            pmi.setLastVisitDate(new Date());
                                            pmi.setOperator("ZZJ");
                                            pmi.setInsurancesNo(cardNo);
                                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                            patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                            PatMasterIndex patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            }
                                            patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                            //没有增加军队医改的限制

                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                header.addElement("code").setText("1");
                                                header.addElement("desc").setText("身份证更新失败！！！");
                                                header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                            } else {
                                                header.addElement("code").setText("0");
                                                header.addElement("desc").setText("成功");
                                                header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                            }
                                        }
                                    } else {
                                        if (pacCardNo.getInpNo() != null && pacCardNo.getInpNo().length() > 0) { //
                                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                            pirnIdNo.setPatientId(pacCardNo.getPatientId());
                                            pirnIdNo.setIccardNo(patIdNo.getIccardNo());
                                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                            PatMasterIndex pmi = new PatMasterIndex();
                                            pmi.setPatientId(pacCardNo.getPatientId());
//                            pmi.setInpNo("");
                                            if (name.length() > 4) {
                                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                            } else {
                                                pmi.setName(StringUtil.Utf_Iso(name));
                                            }
                                            logger.info("zjp----->" + namePhonetic);
                                            if (namePhonetic.length() > 16) {
                                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                            } else {
                                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                            }
                                            String sexDecs = "";
                                            if (sexCode.equals("M")) {
                                                sexDecs = "男";
                                            } else if (sexCode.equals("F")) {
                                                sexDecs = "女";
                                            } else {
                                                sexDecs = "未知";
                                            }
                                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM" +
                                                    "-dd").getTime())); //出生日期
                                            pmi.setBirthPlace(idenNo.substring(0, 6));
                                            pmi.setCitizenship("CN");
                                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                pmi.setNation(null);
                                                pmi.setMailingAddress(null);
                                            } else {
                                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                pmi.setMailingAddress(truncateStr(address, 40));
                                            }
                                            pmi.setIdNo(idenNo);
                                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                            pmi.setUnitInContract("");
                                            pmi.setZipCode("");
                                            pmi.setPhoneNumberHome(homeTel);
                                            pmi.setPhoneNumberBusiness("");
                                            pmi.setNextOfKin("");
                                            pmi.setRelationship("");
                                            pmi.setNextOfKinAddr("");
                                            pmi.setNextOfKinZipCode("");
                                            pmi.setNextOfKinPhone("");
                                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                            pmi.setLastVisitDate(new Date());
                                            pmi.setOperator("ZZJ");
                                            pmi.setInsurancesNo(cardNo);
                                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                            patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                            PatMasterIndex patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            }
                                            patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                            //没有增加军队医改的限制

                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                header.addElement("code").setText("1");
                                                header.addElement("desc").setText("身份证更新失败！！！");
                                                header.addElement("patientId").setText(pacCardNo.getPatientId());
                                            } else {
                                                header.addElement("code").setText("0");
                                                header.addElement("desc").setText("成功");
                                                header.addElement("patientId").setText(pacCardNo.getPatientId());
                                            }
                                        } else if (pacIdenNo.getInpNo() != null && pacIdenNo.getInpNo().length() > 0) {
                                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                            pirnIdNo.setPatientId(pacIdenNo.getPatientId());
                                            pirnIdNo.setIccardNo(patCardNo.getIccardNo());
                                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                            PatMasterIndex pmi = new PatMasterIndex();
                                            pmi.setPatientId(pacIdenNo.getPatientId());
//                            pmi.setInpNo("");
                                            if (name.length() > 4) {
                                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                            } else {
                                                pmi.setName(StringUtil.Utf_Iso(name));
                                            }
                                            logger.info("zjp----->" + namePhonetic);
                                            if (namePhonetic.length() > 16) {
                                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                            } else {
                                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                            }
                                            String sexDecs = "";
                                            if (sexCode.equals("M")) {
                                                sexDecs = "男";
                                            } else if (sexCode.equals("F")) {
                                                sexDecs = "女";
                                            } else {
                                                sexDecs = "未知";
                                            }
                                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM" +
                                                    "-dd").getTime())); //出生日期
                                            pmi.setBirthPlace(idenNo.substring(0, 6));
                                            pmi.setCitizenship("CN");
                                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                pmi.setNation(null);
                                                pmi.setMailingAddress(null);
                                            } else {
                                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                pmi.setMailingAddress(truncateStr(address, 40));
                                            }
                                            pmi.setIdNo(idenNo);
                                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                            pmi.setUnitInContract("");
                                            pmi.setZipCode("");
                                            pmi.setPhoneNumberHome(homeTel);
                                            pmi.setPhoneNumberBusiness("");
                                            pmi.setNextOfKin("");
                                            pmi.setRelationship("");
                                            pmi.setNextOfKinAddr("");
                                            pmi.setNextOfKinZipCode("");
                                            pmi.setNextOfKinPhone("");
                                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                            pmi.setLastVisitDate(new Date());
                                            pmi.setOperator("ZZJ");
                                            pmi.setInsurancesNo(cardNo);
                                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                            patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                            PatMasterIndex patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                            //没有增加军队医改的限制
                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                            }
                                            patMasterIndex =
                                                    patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                            //没有增加军队医改的限制

                                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                header.addElement("code").setText("1");
                                                header.addElement("desc").setText("身份证更新失败！！！");
                                                header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                            } else {
                                                header.addElement("code").setText("0");
                                                header.addElement("desc").setText("成功");
                                                header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                            }
                                        } else { //都为空
                                            if (pacCardNo.getIdNo() != null && pacCardNo.getIdNo().length() > 0) {
                                                PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                                pirnIdNo.setPatientId(pacCardNo.getPatientId());
                                                pirnIdNo.setIccardNo(patIdNo.getIccardNo());
                                                pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                                PatMasterIndex pmi = new PatMasterIndex();
                                                pmi.setPatientId(pacCardNo.getPatientId());
//                            pmi.setInpNo("");
                                                if (name.length() > 4) {
                                                    pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                                } else {
                                                    pmi.setName(StringUtil.Utf_Iso(name));
                                                }
                                                logger.info("zjp----->" + namePhonetic);
                                                if (namePhonetic.length() > 16) {
                                                    pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                                } else {
                                                    pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                                }
                                                String sexDecs = "";
                                                if (sexCode.equals("M")) {
                                                    sexDecs = "男";
                                                } else if (sexCode.equals("F")) {
                                                    sexDecs = "女";
                                                } else {
                                                    sexDecs = "未知";
                                                }
                                                pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                                pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,
                                                        "yyyy-MM-dd").getTime())); //出生日期
                                                pmi.setBirthPlace(idenNo.substring(0, 6));
                                                pmi.setCitizenship("CN");
                                                if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                    pmi.setNation(null);
                                                    pmi.setMailingAddress(null);
                                                } else {
                                                    pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                    pmi.setMailingAddress(truncateStr(address, 40));
                                                }
                                                pmi.setIdNo(idenNo);
                                                pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                                pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                                pmi.setUnitInContract("");
                                                pmi.setZipCode("");
                                                pmi.setPhoneNumberHome(homeTel);
                                                pmi.setPhoneNumberBusiness("");
                                                pmi.setNextOfKin("");
                                                pmi.setRelationship("");
                                                pmi.setNextOfKinAddr("");
                                                pmi.setNextOfKinZipCode("");
                                                pmi.setNextOfKinPhone("");
                                                pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                                pmi.setLastVisitDate(new Date());
                                                pmi.setOperator("ZZJ");
                                                pmi.setInsurancesNo(cardNo);
                                                pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                                patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                                PatMasterIndex patMasterIndex =
                                                        patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                                //没有增加军队医改的限制
                                                if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                    patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                                }
                                                patMasterIndex =
                                                        patMasterIndexMapper.selectByPatientId(pacCardNo.getPatientId());
                                                //没有增加军队医改的限制

                                                if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                    header.addElement("code").setText("1");
                                                    header.addElement("desc").setText("身份证更新失败！！！");
                                                    header.addElement("patientId").setText(pacCardNo.getPatientId());
                                                } else {
                                                    header.addElement("code").setText("0");
                                                    header.addElement("desc").setText("成功");
                                                    header.addElement("patientId").setText(pacCardNo.getPatientId());
                                                }
                                            } else {
                                                PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                                pirnIdNo.setPatientId(pacIdenNo.getPatientId());
                                                pirnIdNo.setIccardNo(patCardNo.getIccardNo());
                                                pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd"), "yyyy-MM-dd").getTime()));

                                                PatMasterIndex pmi = new PatMasterIndex();
                                                pmi.setPatientId(pacIdenNo.getPatientId());
//                            pmi.setInpNo("");
                                                if (name.length() > 4) {
                                                    pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                                } else {
                                                    pmi.setName(StringUtil.Utf_Iso(name));
                                                }
                                                logger.info("zjp----->" + namePhonetic);
                                                if (namePhonetic.length() > 16) {
                                                    pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                                } else {
                                                    pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                                }
                                                String sexDecs = "";
                                                if (sexCode.equals("M")) {
                                                    sexDecs = "男";
                                                } else if (sexCode.equals("F")) {
                                                    sexDecs = "女";
                                                } else {
                                                    sexDecs = "未知";
                                                }
                                                pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                                pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday,
                                                        "yyyy-MM-dd").getTime())); //出生日期
                                                pmi.setBirthPlace(idenNo.substring(0, 6));
                                                pmi.setCitizenship("CN");
                                                if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                                    pmi.setNation(null);
                                                    pmi.setMailingAddress(null);
                                                } else {
                                                    pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                                    pmi.setMailingAddress(truncateStr(address, 40));
                                                }
                                                pmi.setIdNo(idenNo);
                                                pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                                pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                                pmi.setUnitInContract("");
                                                pmi.setZipCode("");
                                                pmi.setPhoneNumberHome(homeTel);
                                                pmi.setPhoneNumberBusiness("");
                                                pmi.setNextOfKin("");
                                                pmi.setRelationship("");
                                                pmi.setNextOfKinAddr("");
                                                pmi.setNextOfKinZipCode("");
                                                pmi.setNextOfKinPhone("");
                                                pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                                                pmi.setLastVisitDate(new Date());
                                                pmi.setOperator("ZZJ");
                                                pmi.setInsurancesNo(cardNo);
                                                pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                                patIccardRecNewMapper.updateByPrimaryKeySelective(pirnIdNo);
                                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                                PatMasterIndex patMasterIndex =
                                                        patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                                //没有增加军队医改的限制
                                                if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                    patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                                }
                                                patMasterIndex =
                                                        patMasterIndexMapper.selectByPatientId(pacIdenNo.getPatientId());
                                                //没有增加军队医改的限制

                                                if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                                    header.addElement("code").setText("1");
                                                    header.addElement("desc").setText("身份证更新失败！！！");
                                                    header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                                } else {
                                                    header.addElement("code").setText("0");
                                                    header.addElement("desc").setText("成功");
                                                    header.addElement("patientId").setText(pacIdenNo.getPatientId());
                                                }
                                            }
                                        }
                                    }
                                }

                            } else {//诊疗卡存在，身份证不存在

                                //1.1 插入身份证
                                PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                pirnIdNo.setPatientId(patCardNo.getPatientId());
                                pirnIdNo.setIccardNo(idenNo);
                                pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy" +
                                        "-MM-dd"), "yyyy-MM-dd").getTime()));
                                //2.update  patMasterIndex

                                PatMasterIndex pmi = new PatMasterIndex();
                                pmi.setPatientId(patCardNo.getPatientId());
//                                pmi.setInpNo("");
                                if (name.length() > 4) {
                                    pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                } else {
                                    pmi.setName(StringUtil.Utf_Iso(name));
                                }
                                logger.info("zjp----->" + namePhonetic);
                                if (namePhonetic.length() > 16) {
                                    pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                } else {
                                    pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                }
                                String sexDecs = "";
                                if (sexCode.equals("M")) {
                                    sexDecs = "男";
                                } else if (sexCode.equals("F")) {
                                    sexDecs = "女";
                                } else {
                                    sexDecs = "未知";
                                }
                                pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                                pmi.setBirthPlace(idenNo.substring(0, 6));
                                pmi.setCitizenship("CN");
                                if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                    pmi.setNation(null);
                                    pmi.setMailingAddress(null);
                                } else {
                                    pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                    pmi.setMailingAddress(truncateStr(address, 40));
                                }
                                pmi.setIdNo(idenNo);
                                pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                pmi.setUnitInContract("");
                                pmi.setZipCode("");
                                pmi.setPhoneNumberHome(homeTel);
                                pmi.setPhoneNumberBusiness("");
                                pmi.setNextOfKin("");
                                pmi.setRelationship("");
                                pmi.setNextOfKinAddr("");
                                pmi.setNextOfKinZipCode("");
                                pmi.setNextOfKinPhone("");
                                pmi.setVipIndicator((short) 0);
//                                pmi.setCreateDate(new Date());
                                pmi.setLastVisitDate(new Date());
                                pmi.setOperator("ZZJ");
                                pmi.setInsurancesNo(cardNo);
                                pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                patIccardRecNewMapper.insert(pirnIdNo);
                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                //重新校验是否插入 只需要检验身份证
                                PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                                if (cardNo != null && cardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                                } else if (idenNo != null && idenNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                                } else if (cCardNo != null && cCardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                                }
                                if (patIccardRecNew == null) {
                                    patIccardRecNewMapper.insert(pirnIdNo);
                                }

//                                if (cardNo != null && cardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                                } else if (idenNo != null && idenNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                                } else if (cCardNo != null && cCardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                                }
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);

                                PatMasterIndex patMasterIndex =
                                        patMasterIndexMapper.selectByPatientId(patCardNo.getPatientId()); //没有增加军队医改的限制
                                if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                    patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                }
                                patMasterIndex = patMasterIndexMapper.selectByPatientId(patCardNo.getPatientId());
                                //没有增加军队医改的限制

                                if (patIccardRecNew == null) {
                                    header.addElement("code").setText("1");
                                    header.addElement("desc").setText("注册失败,注册表未插入信息");
                                } else if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                    header.addElement("code").setText("1");
                                    header.addElement("desc").setText("身份证更新失败！！！");
                                } else {
                                    header.addElement("code").setText("0");
                                    header.addElement("desc").setText("成功");
                                    header.addElement("patientId").setText(patCardNo.getPatientId());
                                }
                            }
                        } else {
                            PatIccardRecNew patIdNo = patIccardRecNewMapper.selectByPrimaryKey(idenNo);//身份证号
                            if (patIdNo != null) {//诊疗卡不存在,身份证号存在
                                //1.insert  RecNew（诊疗卡号）
                                PatIccardRecNew pirn = new PatIccardRecNew();
                                pirn.setPatientId(patIdNo.getPatientId());
                                pirn.setIccardNo(cardNo);
                                pirn.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM" +
                                        "-dd"), "yyyy-MM-dd").getTime()));
                                //2.update patMasterIndex
                                PatMasterIndex pmi = new PatMasterIndex();
                                pmi.setPatientId(patIdNo.getPatientId());
//                                pmi.setInpNo("");
                                if (name.length() > 4) {
                                    pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                } else {
                                    pmi.setName(StringUtil.Utf_Iso(name));
                                }
                                logger.info("zjp----->" + namePhonetic);
                                if (namePhonetic.length() > 16) {
                                    pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                } else {
                                    pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                }
                                String sexDecs = "";
                                if (sexCode.equals("M")) {
                                    sexDecs = "男";
                                } else if (sexCode.equals("F")) {
                                    sexDecs = "女";
                                } else {
                                    sexDecs = "未知";
                                }
                                pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                                pmi.setBirthPlace(idenNo.substring(0, 6));
                                pmi.setCitizenship("CN");
                                if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                    pmi.setNation(null);
                                    pmi.setMailingAddress(null);
                                } else {
                                    pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                    pmi.setMailingAddress(truncateStr(address, 40));
                                }
                                pmi.setIdNo(idenNo);
                                pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                pmi.setUnitInContract("");
                                pmi.setZipCode("");
                                pmi.setPhoneNumberHome(homeTel);
                                pmi.setPhoneNumberBusiness("");
                                pmi.setNextOfKin("");
                                pmi.setRelationship("");
                                pmi.setNextOfKinAddr("");
                                pmi.setNextOfKinZipCode("");
                                pmi.setNextOfKinPhone("");
                                pmi.setVipIndicator((short) 0);
//                                pmi.setCreateDate(new Date());
                                pmi.setLastVisitDate(new Date());
                                pmi.setOperator("ZZJ");
                                pmi.setInsurancesNo(cardNo);
                                pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                patIccardRecNewMapper.insert(pirn);
                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);

                                //重新校验是否插入,只需要检查cardNo
                                PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
                                if (patIccardRecNew == null)
                                    patIccardRecNewMapper.insert(pirn);
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);

                                PatMasterIndex patMasterIndex =
                                        patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId()); //没有增加军队医改的限制
                                if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                    patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                                }
                                patMasterIndex = patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId());
                                //没有增加军队医改的限制

                                if (patIccardRecNew == null) {
                                    header.addElement("code").setText("1");
                                    header.addElement("desc").setText("注册失败,注册表未插入信息");
                                } else if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                    header.addElement("code").setText("1");
                                    header.addElement("desc").setText("身份证更新失败！！！");
                                } else {
                                    header.addElement("code").setText("0");
                                    header.addElement("desc").setText("成功");
                                    header.addElement("patientId").setText(patIdNo.getPatientId());
                                }

                            } else {//诊疗卡不存在,身份证号不存在
                                //1.insert  RecNew（诊疗卡号和身份证）
                                String patientID = recpNoMapper.selectPatientID().getRecpNo();
                                int lengthDo = patientID.length();
                                if (lengthDo < 8) {
                                    for (int i = 0; i < 8 - lengthDo; i++) {
                                        patientID = "0" + patientID;
                                    }
                                }
                                patientID = "61" + patientID;
                                //1.1  插入诊疗卡
                                PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                                pirnIdNo.setPatientId(patientID);
                                pirnIdNo.setIccardNo(idenNo);
                                pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy" +
                                        "-MM-dd"), "yyyy-MM-dd").getTime()));
                                //1.2 插入身份证

                                //2.insert  patMasterIndex
                                PatMasterIndex pmi = new PatMasterIndex();
                                pmi.setPatientId(patientID);
//                                pmi.setInpNo("");
                                if (name.length() > 4) {
                                    pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                                } else {
                                    pmi.setName(StringUtil.Utf_Iso(name));
                                }
                                logger.info("zjp----->" + namePhonetic);
                                if (namePhonetic.length() > 16) {
                                    pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                                } else {
                                    pmi.setNamePhonetic(namePhonetic); //姓名拼音
                                }
                                String sexDecs = "";
                                if (sexCode.equals("M")) {
                                    sexDecs = "男";
                                } else if (sexCode.equals("F")) {
                                    sexDecs = "女";
                                } else {
                                    sexDecs = "未知";
                                }
                                pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                                pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                                pmi.setBirthPlace(idenNo.substring(0, 6));
                                pmi.setCitizenship("CN");
                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                pmi.setIdNo(idenNo);
                                pmi.setIdentity(StringUtil.Utf_Iso(identity));
                                pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                                pmi.setUnitInContract("");
                                pmi.setMailingAddress(truncateStr(address, 40));
                                pmi.setZipCode("");
                                pmi.setPhoneNumberHome(homeTel);
                                pmi.setPhoneNumberBusiness("");
                                pmi.setNextOfKin("");
                                pmi.setRelationship("");
                                pmi.setNextOfKinAddr("");
                                pmi.setNextOfKinZipCode("");
                                pmi.setNextOfKinPhone("");
                                pmi.setVipIndicator((short) 0);
                                pmi.setCreateDate(new Date());
                                pmi.setOperator("ZZJ");
                                pmi.setInsurancesNo(cardNo);
                                pmi.setNameAlias(StringUtil.Utf_Iso(name));

                                patIccardRecNewMapper.insert(pirnIdNo);
                                patMasterIndexMapper.insertSelective(pmi);

                                //插入cardNo 2018-05-09修改
                                pirnIdNo.setIccardNo(cardNo);
                                patIccardRecNewMapper.insert(pirnIdNo);

                                //重新校验是否插入,只需要检查身份证号
                                PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                                PatIccardRecNew patIccardRecNew = new PatIccardRecNew();
//                                if (cardNo != null && cardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                                } else if (idenNo != null && idenNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                                } else if (cCardNo != null && cCardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                                }
                                if (patIccardRecNew == null)
                                    patIccardRecNewMapper.insert(pirnIdNo);
                                PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientID);
                                //没有增加军队医改的限制
                                if (patMasterIndex == null)
                                    patMasterIndexMapper.insertSelective(pmi);

//                                if (cardNo != null && cardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
//                                } else if (idenNo != null && idenNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
//                                } else if (cCardNo != null && cCardNo.length() > 0) {
//                                    patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
//                                }
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
                                patMasterIndex = patMasterIndexMapper.selectByPatientId(patientID); //没有增加军队医改的限制

                                if (patIccardRecNew == null) {
                                    header.addElement("code").setText("1");
                                    header.addElement("desc").setText("注册失败,注册表未插入信息");
                                    header.addElement("patientId").setText(patientID);
                                } else if (patMasterIndex == null) {
                                    header.addElement("code").setText("1");
                                    header.addElement("desc").setText("注册失败,主表未插入信息");
                                    header.addElement("patientId").setText(patientID);
                                } else {
                                    header.addElement("code").setText("0");
                                    header.addElement("desc").setText("成功");
                                    header.addElement("patientId").setText(patientID);
                                }
                            }
                        }
                    } else { //诊疗卡卡号为空
                        PatIccardRecNew patIdNo = patIccardRecNewMapper.selectByPrimaryKey(idenNo);//身份证号
                        if (patIdNo != null) { //诊疗卡号为空 ,身份证号不为空 不做处理
                            PatMasterIndex pmi = new PatMasterIndex();
                            pmi.setPatientId(patIdNo.getPatientId());
//                            pmi.setInpNo("");
                            if (name.length() > 4) {
                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                            } else {
                                pmi.setName(StringUtil.Utf_Iso(name));
                            }
                            logger.info("zjp----->" + namePhonetic);
                            if (namePhonetic.length() > 16) {
                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                            } else {
                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                            }
                            String sexDecs = "";
                            if (sexCode.equals("M")) {
                                sexDecs = "男";
                            } else if (sexCode.equals("F")) {
                                sexDecs = "女";
                            } else {
                                sexDecs = "未知";
                            }
                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                            pmi.setBirthPlace(idenNo.substring(0, 6));
                            pmi.setCitizenship("CN");
                            if (cardNoType != null && cardNoType.length() > 0 && "1".equals(cardNoType)) {
                                pmi.setNation(null);
                                pmi.setMailingAddress(null);
                            } else {
                                pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                                pmi.setMailingAddress(truncateStr(address, 40));
                            }
                            pmi.setIdNo(idenNo);
                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                            pmi.setUnitInContract("");
                            pmi.setZipCode("");
                            pmi.setPhoneNumberHome(homeTel);
                            pmi.setPhoneNumberBusiness("");
                            pmi.setNextOfKin("");
                            pmi.setRelationship("");
                            pmi.setNextOfKinAddr("");
                            pmi.setNextOfKinZipCode("");
                            pmi.setNextOfKinPhone("");
                            pmi.setVipIndicator((short) 0);
//                            pmi.setCreateDate(new Date());
                            pmi.setLastVisitDate(new Date());
                            pmi.setOperator("ZZJ");
                            pmi.setInsurancesNo(cardNo);
                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                            patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                            PatMasterIndex patMasterIndex =
                                    patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId()); //没有增加军队医改的限制
                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                patMasterIndexMapper.updateByPrimaryKeySelective(pmi);
                            }
                            patMasterIndex = patMasterIndexMapper.selectByPatientId(patIdNo.getPatientId());
                            //没有增加军队医改的限制

                            if (!(patMasterIndex.getIdNo() != null && patMasterIndex.getIdNo().length() > 0)) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("身份证更新失败！！！");
                            } else {
                                header.addElement("code").setText("0");
                                header.addElement("desc").setText("成功");
                                header.addElement("patientId").setText(patIdNo.getPatientId());
                            }
                        } else { //诊疗卡号为空 ,身份证号为空
                            //1. insert RecNew(身份证)
                            //1.1 插入身份证
                            String patientID = recpNoMapper.selectPatientID().getRecpNo();
                            int lengthDo = patientID.length();
                            if (lengthDo < 8) {
                                for (int i = 0; i < 8 - lengthDo; i++) {
                                    patientID = "0" + patientID;
                                }
                            }
                            patientID = "61" + patientID;
                            PatIccardRecNew pirnIdNo = new PatIccardRecNew();
                            pirnIdNo.setPatientId(patientID);
                            pirnIdNo.setIccardNo(idenNo);
                            pirnIdNo.setRegDatetime(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM" +
                                    "-dd"), "yyyy-MM-dd").getTime()));

                            //2.insert  patMasterIndex
                            PatMasterIndex pmi = new PatMasterIndex();
                            pmi.setPatientId(patientID);
//                            pmi.setInpNo("");
                            if (name.length() > 4) {
                                pmi.setName(StringUtil.Utf_Iso(name.substring(0, 4)));
                            } else {
                                pmi.setName(StringUtil.Utf_Iso(name));
                            }
                            logger.info("zjp----->" + namePhonetic);
                            if (namePhonetic.length() > 16) {
                                pmi.setNamePhonetic(namePhonetic.substring(0, 16)); //姓名拼音
                            } else {
                                pmi.setNamePhonetic(namePhonetic); //姓名拼音
                            }
                            String sexDecs = "";
                            if (sexCode.equals("M")) {
                                sexDecs = "男";
                            } else if (sexCode.equals("F")) {
                                sexDecs = "女";
                            } else {
                                sexDecs = "未知";
                            }
                            pmi.setSex(StringUtil.Utf_Iso(sexDecs));
                            pmi.setDateOfBirth(new Timestamp(DateToWeek.formatDate(birthday, "yyyy-MM-dd").getTime())); //出生日期
                            pmi.setBirthPlace(idenNo.substring(0, 6));
                            pmi.setCitizenship("CN");
                            pmi.setNation(StringUtil.Utf_Iso(nation + "族"));
                            pmi.setIdNo(idenNo);
                            pmi.setIdentity(StringUtil.Utf_Iso(identity));
                            pmi.setChargeType(StringUtil.Utf_Iso(chargeType));
                            pmi.setUnitInContract("");
                            pmi.setMailingAddress(truncateStr(address, 40));
                            pmi.setZipCode("");
                            pmi.setPhoneNumberHome(homeTel);
                            pmi.setPhoneNumberBusiness("");
                            pmi.setNextOfKin("");
                            pmi.setRelationship("");
                            pmi.setNextOfKinAddr("");
                            pmi.setNextOfKinZipCode("");
                            pmi.setNextOfKinPhone("");
                            pmi.setVipIndicator((short) 0);
                            pmi.setCreateDate(new Date());
                            pmi.setOperator("ZZJ");
                            pmi.setInsurancesNo(cardNo);
                            pmi.setNameAlias(StringUtil.Utf_Iso(name));

                            patIccardRecNewMapper.insert(pirnIdNo);
                            patMasterIndexMapper.insertSelective(pmi);

                            //重新校验是否插入
                            PatIccardRecNew patIccardRecNew = new PatIccardRecNew();
                            if (cardNo != null && cardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
                            } else if (idenNo != null && idenNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
                            } else if (cCardNo != null && cCardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
                            }
                            if (patIccardRecNew == null) {
                                patIccardRecNewMapper.insert(pirnIdNo);
                            }
                            PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(patientID);
                            //没有增加军队医改的限制
                            if (patMasterIndex == null) {
                                patMasterIndexMapper.insertSelective(pmi);
                            }

                            if (cardNo != null && cardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cardNo);
                            } else if (idenNo != null && idenNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idenNo);
                            } else if (cCardNo != null && cCardNo.length() > 0) {
                                patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(cCardNo);
                            }
                            patMasterIndex = patMasterIndexMapper.selectByPatientId(patientID); //没有增加军队医改的限制

                            if (patIccardRecNew == null) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("注册失败,注册表未插入信息");
                                header.addElement("patientId").setText(patientID);
                            } else if (patMasterIndex == null) {
                                header.addElement("code").setText("1");
                                header.addElement("desc").setText("注册失败,主表未插入信息");
                                header.addElement("patientId").setText(patientID);
                            } else {
                                header.addElement("code").setText("0");
                                header.addElement("desc").setText("成功");
                                header.addElement("patientId").setText(patientID);
                            }
                        }
                    }
                }
            } else {
                return getErrorlMsg("身份证不能为空！！！");
            }
            logger.info(doc.asXML());
            return doc.asXML();
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 同步医生排班信息接口（用户查询今日号源和预约号源接口） 当日所有排班（数据源是星期，直接转换成星期查询）主键 用号别^星期^午别 通过排班数据查询号源信息。只能通过号类和星期查出对应的号源信息
     *
     * @param xmlParam
     * @return
     */
    @Override
    public String getSchedueInfo(String xmlParam) {
        logger.info("[排班信息  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String startDate = reroot.element("data").element("startDate").getTextTrim();
            String endDate = reroot.element("data").element("endDate").getTextTrim();
            //  String schedueType = reroot.element("data").element("SchedueType").getTextTrim();//1挂号  2 预约
            if (startDate != null && startDate.length() > 0 && endDate != null && endDate.length() > 0) {
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root = doc.addElement("response");
                Element header = root.addElement("head");
                Element data = root.addElement("body");
                header.addElement("code").setText("0");
                header.addElement("desc").setText("成功");
                List<ClinicForRegist> clinicForRegistList =
                        clinicForRegistMapper.selectByDeptForRegistByTime(startDate, endDate);
                if (clinicForRegistList != null && clinicForRegistList.size() > 0) {
                    for (ClinicForRegist clinicForRegist : clinicForRegistList) {
                        if ("石门坎门诊".equals(StringUtil.Iso_GBK(clinicForRegist.getClinicLabel())))
                            continue;

                        ClinicIndex clinicIndex =
                                clinicIndexMapper.selectByPrimaryKey(clinicForRegist.getClinicLabel());
                        if (clinicIndex != null) {
                            String clinicDate = DateToWeek.formatDateString(clinicForRegist.getClinicDate(), "yyyy-MM" +
                                    "-dd");

                            // 新增急诊儿科的过滤
                            if ("急诊儿科".equals(StringUtil.Iso_GBK(clinicForRegist.getClinicLabel()))) {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar cal = Calendar.getInstance(), now = Calendar.getInstance();
                                cal.setTime(sdf.parse("2018-08-10"));
                                now.setTime(clinicForRegist.getClinicDate());
                                if (now.after(cal)) {
                                    continue;
                                }
                            }

                            Element list = data.addElement("list");
                            list.addElement("clinicDate").setText(clinicDate);
                            list.addElement("departmentId").setText(clinicIndex.getClinicDept());
                            DeptDict deptDict = deptDictMapper.selectByPrimaryKey(clinicIndex.getClinicDept());
                            list.addElement("departmentName").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));
                            list.addElement("expertName").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor()));
                            String docId = "";
                            if (StringUtil.Iso_GBK(clinicIndex.getDoctor()) != null && StringUtil.Iso_GBK(clinicIndex.getDoctor()).length() > 0) {
                                Users users = usersMapper.selectUserName(StringUtil.Iso_GBK(clinicIndex.getDoctor()));
                                if (users != null) {
                                    docId = users.getUserId();
                                }
                            }
                            list.addElement("expertId").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor())); //给工号
                            String classId = "";
                            if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains("普通")) {
                                classId = "pt";
                            } else if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains("专家")) {
                                classId = "zj";
                            } else if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains("急诊")) {
                                classId = "jz";
                            }
                            list.addElement("registerClassId").setText(classId);
                            list.addElement("clinicLabel").setText(StringUtil.Iso_GBK(clinicForRegist.getClinicLabel())); //挂号号别
                            list.addElement("registerTypeId").setText("");
                            list.addElement("registerCount").setText("");
                            list.addElement("remainCount").setText(clinicForRegist.getCurrentNo().toString());
                            list.addElement("waitNo").setText("");
                            list.addElement("seeTime").setText(StringUtil.Iso_GBK(clinicForRegist.getTimeDesc()));
                            // list.addElement("totalFee").setText(clinicForRegist.getRegistPrice().toString());
                            if (clinicIndex.getPrice() != null) {
                                list.addElement("totalFee").setText(clinicIndex.getPrice().toString());
                                list.addElement("diagnoseFee").setText(clinicIndex.getPrice().toString());
                            } else {
                                list.addElement("diagnoseFee").setText("0");
                                list.addElement("totalFee").setText("0");
                            }
                            list.addElement("registerFee").setText("");
                            list.addElement("stopFlag").setText("0");
                        }
                    }

                }
                logger.info("[排班信息  出参 :]" + doc.asXML());
                return doc.asXML();
            } else {
                return getErrorlMsg("输入参数有误！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

//    @Override
//    public String getSchedueInfo(String xmlParam) {
//        logger.info("[排班信息  入参 :]" + xmlParam);
//        Document document = null;
//        try {
//            document = DocumentHelper.parseText(xmlParam);
//            Element reroot = document.getRootElement();
//            String startDate = reroot.element("data").element("startDate").getTextTrim();
//            String endDate = reroot.element("data").element("endDate").getTextTrim();
//            //  String schedueType = reroot.element("data").element("SchedueType").getTextTrim();//1挂号  2 预约
//            if (startDate != null && startDate.length() > 0 && endDate != null && endDate.length() > 0) {
//                Document doc = DocumentHelper.createDocument();
//                doc.setXMLEncoding("GBK");
//                Element root = doc.addElement("response");
//                Element header = root.addElement("head");
//                Element data = root.addElement("body");
//                header.addElement("code").setText("0");
//                header.addElement("desc").setText("成功");
//                List<ClinicSchedule> clinicSchedules = clinicScheduleMapper.selectForSchedule();
//                LinkedHashMap<String, String> linkedHashMap = DateToWeek.forDateToWeek(startDate, endDate);
//                Iterator iterator = linkedHashMap.entrySet().iterator();
//                while (iterator.hasNext()) {
//                    Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
//                    String date = entry.getKey();
//                    String week = entry.getValue();
//                    if (clinicSchedules != null && clinicSchedules.size() > 0) {
//                        for (ClinicSchedule clinicSchedule : clinicSchedules) {
//                            if (week.equals(clinicSchedule.getDayOfWeek().toString())) {
//                                ClinicIndex clinicIndex = clinicSchedule.getClinicIndex();
//                                if (clinicIndex != null) {
//                                    String clinicLabel = StringUtil.Iso_GBK(clinicSchedule.getClinicLabel()); //号别
//                                    week = clinicSchedule.getDayOfWeek().toString();
////                                    String timeDesc = getTimeDescEng(StringUtil.Iso_GBK(clinicSchedule
// .getTimeDesc()));
//                                    String time = date;
////                                    if("am".equals(timeDesc)){
////                                        timeDesc = "1";
////                                    }else if("pm".equals(timeDesc)){
////                                        timeDesc = "3";
////                                    }else if("day".equals(timeDesc)){
////                                        timeDesc = "6";
////                                    }else{
////                                        timeDesc = "4";
////                                    }
//                                    DeptDict deptDict = deptDictMapper.selectByPrimaryKey(clinicIndex.getClinicDept
// ());
//                                    List<ClinicForRegist> clinicForRegistList = clinicForRegistMapper
// .selectByClinicLabel(StringUtil.Utf_Iso(clinicLabel), time);
//                                    if (clinicForRegistList != null && clinicForRegistList.size() > 0) {
//                                        for (ClinicForRegist clinicForRegist : clinicForRegistList) {
//                                            String clinicWeek = DateToWeek.getWeek(clinicForRegist.getClinicDate());
//                                            if (clinicWeek.equals(week)) {
//                                                String clinicDate = DateToWeek.formatDateString(clinicForRegist
// .getClinicDate(), "yyyy-MM-dd");
//                                                Element list = data.addElement("list");
//                                                list.addElement("clinicDate").setText(clinicDate);
//                                                list.addElement("departmentId").setText(clinicIndex.getClinicDept());
//                                                list.addElement("departmentName").setText(StringUtil.Iso_GBK
// (deptDict.getDeptName()));
//                                                list.addElement("expertName").setText(StringUtil.Iso_GBK
// (clinicIndex.getDoctor()));
//                                                String docId = "";
//                                                if (StringUtil.Iso_GBK(clinicIndex.getDoctor()) != null &&
// StringUtil.Iso_GBK(clinicIndex.getDoctor()).length() > 0) {
//                                                    Users users = usersMapper.selectUserName(StringUtil.Iso_GBK
// (clinicIndex.getDoctor()));
//                                                    if (users != null) {
//                                                        docId = users.getUserId();
//                                                    }
//                                                }
//                                                list.addElement("expertId").setText(StringUtil.Iso_GBK(clinicIndex
// .getDoctor())); //给工号
//                                                String classId = "";
//                                                if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains("普通")) {
//                                                    classId = "pt";
//                                                } else if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains
// ("专家")) {
//                                                    classId = "zj";
//                                                } else if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains
// ("急诊")) {
//                                                    classId = "jz";
//                                                }
//                                                list.addElement("registerClassId").setText(classId);
//                                                list.addElement("clinicLabel").setText(StringUtil.Iso_GBK
// (clinicForRegist.getClinicLabel())); //挂号号别
//                                                list.addElement("registerTypeId").setText("");
//                                                list.addElement("registerCount").setText("");
//                                                list.addElement("remainCount").setText(clinicForRegist.getCurrentNo
// ().toString());
//                                                list.addElement("waitNo").setText("");
//                                                list.addElement("seeTime").setText(StringUtil.Iso_GBK
// (clinicSchedule.getTimeDesc()));
//                                                // list.addElement("totalFee").setText(clinicForRegist
// .getRegistPrice().toString());
//                                                if (clinicSchedule.getPrice() != null) {
//                                                    list.addElement("totalFee").setText(clinicSchedule.getPrice()
// .toString());
//                                                    list.addElement("diagnoseFee").setText(clinicSchedule.getPrice
// ().toString());
//                                                } else {
//                                                    list.addElement("diagnoseFee").setText("0");
//                                                    list.addElement("totalFee").setText("0");
//                                                }
//                                                list.addElement("registerFee").setText("");
//                                                list.addElement("stopFlag").setText("0");
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//                return doc.asXML();
//            } else {
//                return getErrorlMsg("输入参数有误！！！");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return this.getErrorlMsg("数据出错");
//        }
//    }

    /**
     * 用户预约
     *
     * @param xmlParam
     * @return
     */
    @Override
    @Transactional
    public String reservateConfirm(String xmlParam) {
        logger.info("[用户预约  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String clinicLabel = reroot.element("data").element("clinicLabel").getTextTrim();
            String patientId = reroot.element("data").element("inpatientId").getTextTrim();
            String timeDesc = reroot.element("data").element("timeDesc").getTextTrim();
            String inClinicDate = reroot.element("data").element("inClinicDate").getTextTrim();

            Date nowdate = new Date();
            ClinicForRegistKey cfrk = new ClinicForRegistKey();
            cfrk.setClinicDate(DateToWeek.formatDate(inClinicDate, "yyyy-MM-dd"));
            cfrk.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
            cfrk.setTimeDesc(StringUtil.Utf_Iso(timeDesc));
            ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfrk);
            if (clinicForRegist == null) {
                return getErrorlMsg("未查询到号源信息");
            }
            if (clinicForRegist.getAppointmentNum() != null) {
                clinicForRegist.setAppointmentNum((short) (1 + clinicForRegist.getAppointmentNum()));
            } else {
                clinicForRegist.setAppointmentNum((short) 1);
            }
            ClinicAppoints clinicAppoints = new ClinicAppoints();
            clinicAppoints.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
            clinicAppoints.setPatientId(patientId);
            clinicAppoints.setVisitDateAppted(DateToWeek.formatDate(inClinicDate, "yyyy-MM-dd"));
            clinicAppoints.setVisitTimeAppted(StringUtil.Utf_Iso(timeDesc));
            clinicAppoints.setApptMadeDate(nowdate);
            clinicAppoints.setClinicSource("ZZJ");
            clinicAppoints.setClinicAttr("0");
            //预约后当前号加一，当前号默认被预约
            if (clinicForRegist.getCurrentNo() != null) {
                clinicAppoints.setSerialNo(clinicForRegist.getCurrentNo());
                clinicForRegist.setCurrentNo((short) (1 + clinicForRegist.getCurrentNo()));
            } else {
                clinicForRegist.setCurrentNo((short) 1);
                clinicAppoints.setSerialNo((short) 1);
            }

            if (clinicForRegist.getAppointmentLimits() != null && clinicForRegist.getAppointmentLimits() > 0) {
                List<ClinicAppoints> clinicAppointsList =
                        clinicAppointsMapper.selectApponints(clinicAppoints.getVisitDateAppted(),
                                clinicAppoints.getClinicLabel());
                logger.info("[预约信息  入参 :]" + clinicForRegist.getAppointmentLimits());
                if (clinicAppointsList != null && clinicAppointsList.size() > 0) {
                    if (clinicAppointsList.size() >= clinicForRegist.getAppointmentLimits()) {
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
            if (clinicAppoints1 != null) {
                return getErrorlMsg("已有预约信息，无法再次预约");
            }
            clinicForRegistMapper.updateByPrimaryKey(clinicForRegist);
            clinicAppointsMapper.insertSelective(clinicAppoints);
            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element root = doc.addElement("response");
            Element header = root.addElement("head");
            Element data = root.addElement("data");
            header.addElement("code").setText("0");
            header.addElement("desc").setText("成功");
            //预约订单号=主键：就诊日期、号别、病人标识号、午别。
            data.addElement("orderId").setText(inClinicDate + "^" + clinicLabel + "^" + patientId + "^" + timeDesc);
            data.addElement("orderNo").setText(clinicAppoints.getSerialNo() + "");
            return doc.asXML();
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 判断当前号别是否可挂号 查询当前号别是否可挂号(由医院HIS系统告知当前号别是否可挂号，或者是否还有剩余号源。)
     *
     * @param xmlParam
     * @return
     */
    @Override
    public String canRegisterType(String xmlParam) {
        logger.info("[判断当前号别  入参 :]" + xmlParam);
        Document document = null;
        String result = "";
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
//            String departmentId = reroot.element("data").element("departmentId").getTextTrim();
//            String expertId = reroot.element("data").element("expertId").getTextTrim();
            String clinicLabel = reroot.element("data").element("clinicLabel").getTextTrim(); //挂号号别
            String seeTime = reroot.element("data").element("seeTime").getTextTrim(); //上午 下午 白天 昼夜
            String time = reroot.element("data").element("time").getTextTrim(); //yyyy-mm-dd
            String patientId = reroot.element("data").element("patientId").getTextTrim();
            String orderId = time + "^" + clinicLabel + "^" + patientId + "^" + seeTime;
            if (clinicLabel != null && clinicLabel.length() > 0 && seeTime != null && seeTime.length() > 0 && time != null && time.length() > 0) {
                //                PayOrderRecord payOrderRecord = payOrderRecordMapper.selectByPrimaryKey(StringUtil
                // .Utf_Iso(orderId));
                List<ClinicMaster> clinicMasters = clinicMasterMapper.selectByClinicLabel(time, patientId,
                        StringUtil.Utf_Iso(clinicLabel), StringUtil.Utf_Iso(seeTime));
                ClinicForRegist cfr = new ClinicForRegist();
                Date date = formatDate(time, "yyyy-MM-dd");
                cfr.setClinicDate(date);
                cfr.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
                cfr.setTimeDesc(StringUtil.Utf_Iso(seeTime));
                ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfr);
                if (clinicForRegist.getRegistrationLimits() != null && clinicForRegist.getRegistrationLimits() > 0) {
                    List<ClinicAppoints> clinicAppointsList =
                            clinicAppointsMapper.selectRegesters(cfr.getClinicDate(), cfr.getClinicLabel());// 状态为0
                    List<ClinicMaster> clinicMasterList = clinicMasterMapper.selectRegesters(cfr.getClinicDate(),
                            cfr.getClinicLabel());
                    int num = clinicAppointsList.size() + clinicMasterList.size();
                    logger.info("[当日号已挂 :]" + num);
                    if (num > 0) {
                        if (num >= (int) clinicForRegist.getRegistrationLimits()) {
                            logger.info("[当日号已挂 :]" + getErrorlMsg("当日号已挂完！！！"));
                            result = getErrorlMsg("当日号已挂完！！！");
                        }
                    }
                } else if (clinicMasters != null && clinicMasters.size() > 0) {
                    result = getErrorlMsg("当前科室已挂号，不可重复挂号！！！");
                } else {
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element root = doc.addElement("response");
                    Element header = root.addElement("head");
                    Element data = root.addElement("body");
                    header.addElement("code").setText("0");
                    header.addElement("desc").setText("成功");
//                    ClinicForRegist cfr = new ClinicForRegist();
//                    Date date = formatDate(time, "yyyy-MM-dd");
//                    cfr.setClinicDate(date);
//                    cfr.setClinicLabel(StringUtil.Utf_Iso(clinicLabel));
//                    cfr.setTimeDesc(StringUtil.Utf_Iso(seeTime));
//                    ClinicForRegist clinicForRegist = clinicForRegistMapper.selectByPrimaryKey(cfr);
//                    if(clinicForRegist.getRegistrationLimits()!=null && clinicForRegist.getRegistrationLimits()>0){
//                        List<ClinicAppoints>  clinicAppointsList = clinicAppointsMapper.selectRegesters(cfr
// .getClinicDate(),cfr.getClinicLabel());// 状态为0
//                        List<ClinicMaster> clinicMasterList = clinicMasterMapper.selectRegesters(cfr.getClinicDate
// (),cfr.getClinicLabel());
//                        int num =clinicAppointsList.size()+clinicMasterList.size();
//                        if(num>0){
//                            if(num>= clinicForRegist.getAppointmentLimits()){
//                                return getErrorlMsg("当日号已挂完！！！");
//                            }
//                        }
//                    }
                    if (clinicForRegist != null) {
                        if (clinicForRegist.getCurrentNo() > 0) {
                            data.addElement("registerFlag").setText("1");
                        } else {
                            data.addElement("registerFlag").setText("0");
                        }
                    } else {
                        data.addElement("registerFlag").setText("0");
                    }
                    result = doc.asXML();
                }
                return result;
            } else {
                return getErrorlMsg("输入参数有误！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 挂号试算 用户挂号试算(查询“指定科室”、“挂号号别”、“指定医生”的挂号需要支付费用信息)
     *
     * @param xmlParam
     * @return
     */
    @Override
    public String getCurrentRegisterType(String xmlParam) {
        logger.info("[挂号试算  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String inDepartmentID = reroot.element("data").element("inDepartmentID").getTextTrim();
            String clinicLabel = reroot.element("data").element("clinicLabel").getTextTrim(); //挂号号别
            String inExpertID = reroot.element("data").element("inExpertID").getTextTrim();  //医生姓名
            String inPersonnelType = reroot.element("data").element("inPersonnelType").getTextTrim(); //人员费用结算类别 0自费1医保
            String inRegisterClassId = reroot.element("data").element("inRegisterClassId").getTextTrim();
            String mzNo = Util.getCurrentDate("yyyyMMddHHmmss");//门诊流水号
            if (clinicLabel != null && clinicLabel.length() > 0) {
                Document doc = DocumentHelper.createDocument();
                doc.setXMLEncoding("GBK");
                Element root = doc.addElement("response");
                Element header = root.addElement("head");
                Element data = root.addElement("body");
                header.addElement("code").setText("0");
                header.addElement("desc").setText("成功");
//                List<PriceList> priceList = new ArrayList<PriceList>();
                //update bt tang 2018-05-22 获取诊疗费编码
                PriceList priceList = null;
                String price = null;
                if (inExpertID != null && inExpertID.length() > 0) {
                    priceList = priceListMapper.selectPriceListByDoctor(StringUtil.Utf_Iso(inExpertID),
                            StringUtil.Utf_Iso(clinicLabel));
                } else {
                    priceList = priceListMapper.selectPriceList(StringUtil.Utf_Iso(clinicLabel));
                }

                if (priceList != null) {
                    price = priceList.getPrice().toString();
                    if (price != null && price.length() > 0) {
                        if ("0".equals(inPersonnelType)) { //自费
                            data.addElement("outFee").setText(price);
                            data.addElement("mzNO").setText("");
                            data.addElement("djh").setText("");
                            data.addElement("cfh").setText("");
                        } else {
                            data.addElement("outghfzbm").setText("110100001");
                            data.addElement("outybghfkzfjr").setText("0.00");
                            if (2 == Integer.valueOf(price)) {
                                data.addElement("outZLFZBM").setText("110200008");
                                data.addElement("outYBZLFZFJE").setText("2");
                            } else if (12 == Integer.valueOf(price) && "jz".equals(inRegisterClassId)) {
                                data.addElement("outZLFZBM").setText("110200003");
                                data.addElement("outYBZLFZFJE").setText("12");
                            } else if (12 == Integer.valueOf(price)) {
                                data.addElement("outZLFZBM").setText("110200006a");
                                data.addElement("outYBZLFZFJE").setText("12");
                            } else if (22 == Integer.valueOf(price)) {
                                data.addElement("outZLFZBM").setText("110200006b");
                                data.addElement("outYBZLFZFJE").setText("22");
                            } else if (35 == Integer.valueOf(price)) {
                                data.addElement("outZLFZBM").setText("110200006c");
                                data.addElement("outYBZLFZFJE").setText("35");
                            } else if (100 == Integer.valueOf(price)) {
                                data.addElement("outZLFZBM").setText("110200002a");
                                data.addElement("outYBZLFZFJE").setText("100");
                            } else if (300 == Integer.valueOf(price)) {
                                data.addElement("outZLFZBM").setText("110200002a");
                                data.addElement("outYBZLFZFJE").setText("300");
                            } else {
                                if (StringUtils.isEmpty(priceList.getItemCode()))
                                    data.addElement("outZLFZBM").setText("");
                                else
                                    data.addElement("outZLFZBM").setText(priceList.getItemCode());
                                data.addElement("outYBZLFZFJE").setText(price);
                            }
                            //update bt tang 2018-05-22 获取诊疗费编码
                            data.addElement("outybghhbbm").setText("");
                            data.addElement("outYBKESIDB").setText(inDepartmentID);
                            data.addElement("outFee").setText(price);
//                       String  rcptNo = "O" + recpNoMapper.selectRecpNo().getRecpNo();
                            String rcptNo = Util.getCurrentDate("yyyyMMddHHmmss");
                            data.addElement("mzNO").setText(rcptNo);
                            data.addElement("djh").setText(rcptNo);
                            data.addElement("cfh").setText(rcptNo);
                        }
                    }
                }

                return doc.asXML();
            } else {
                return getErrorlMsg("输入参数有误！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 获取预约列表
     *
     * @param xmlParam
     * @return
     */
    @Override
    public String getReserveInfo(String xmlParam) {
        logger.info("[获取预约列表  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String idNo = reroot.element("body").element("idNo").getText();//身份证
            if (idNo != null && idNo.length() > 0) {
                PatIccardRecNew patIccardRecNew = patIccardRecNewMapper.selectByPrimaryKey(idNo);
                if (patIccardRecNew != null) {
                    String patientId = patIccardRecNew.getPatientId();
                    PatMasterIndex pmi = patMasterIndexMapper.selectByPatientId(patientId);
                    if (pmi != null) {
                        List<ClinicAppoints> clinicAppoints = clinicAppointsMapper.selectByPatientId(patientId);
                        //当日所有的预约列表
                        if (clinicAppoints != null && clinicAppoints.size() > 0) {
                            Document doc = DocumentHelper.createDocument();
                            doc.setXMLEncoding("GBK");
                            Element rootElement = doc.addElement("response");
                            Element headElement = rootElement.addElement("head");
                            headElement.addElement("code").setText("0");
                            headElement.addElement("desc").setText("查询成功");
                            Element bodyElement = rootElement.addElement("body");

                            for (int i = 0; i < clinicAppoints.size(); i++) {
                                ClinicAppoints ca = clinicAppoints.get(i);
                                ClinicIndex clinicIndex = clinicIndexMapper.selectByPrimaryKey(ca.getClinicLabel());
                                DeptDict deptDict = deptDictMapper.selectByPrimaryKey(clinicIndex.getClinicDept());
                                PriceList priceList =
                                        priceListMapper.selectPriceListByClinicType(clinicIndex.getClinicType());

                                String orderId =
                                        DateToWeek.formatDateString(ca.getVisitDateAppted(), "yyyy-MM-dd") + "^" + ca.getClinicLabel() + "^" + patientId + "^" + ca.getVisitTimeAppted();
                                Element payInfoElement = bodyElement.addElement("list");
                                payInfoElement.addElement("reservateFlow").setText(StringUtil.Iso_GBK(orderId)); //预约流水号
                                payInfoElement.addElement("patientId").setText(patientId);//
                                payInfoElement.addElement("name").setText(StringUtil.Iso_GBK(pmi.getName()));//姓名
                                payInfoElement.addElement("idNo").setText(idNo);//身份证
                                payInfoElement.addElement("clinicDate").setText(DateToWeek.formatDateString(ca.getVisitDateAppted(), "yyyy-MM-dd"));//就诊日期
                                payInfoElement.addElement("departmentId").setText(clinicIndex.getClinicDept());//科室ID
                                payInfoElement.addElement("departmentName").setText(StringUtil.Iso_GBK(deptDict.getDeptName()));//科室名称
                                payInfoElement.addElement("expertId").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor()));//专家ID
                                payInfoElement.addElement("expertName").setText(StringUtil.Iso_GBK(clinicIndex.getDoctor()));//专家名称
                                payInfoElement.addElement("seeTime").setText(StringUtil.Iso_GBK(ca.getVisitTimeAppted()));//午别
                                payInfoElement.addElement("totalFee").setText(priceList.getPrice() + "");//总费用
                                payInfoElement.addElement("clinicLabel").setText(StringUtil.Iso_GBK(ca.getClinicLabel()));//挂号类别
                                String classId = "";
                                if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains("普通")) {
                                    classId = "pt";
                                } else if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains("专家")) {
                                    classId = "zj";
                                } else if (StringUtil.Iso_GBK(clinicIndex.getClinicType()).contains("急诊")) {
                                    classId = "jz";
                                }
                                payInfoElement.addElement("registerClassId").setText(classId);
                            }
                            logger.info(doc.asXML());
                            return doc.asXML();
                        } else {
                            return getErrorlMsg("无预约信息！！！");
                        }
                    } else {
                        return getErrorlMsg("未找到此患者！！！");
                    }
                } else {
                    return getErrorlMsg("此患者未注册！！！");
                }
            } else {
                return getErrorlMsg("输入参数有误！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 划价单缴费试算 用户缴费（划价单）试算 (获取“指定划价单号”的费用明细)
     *
     * @param xmlParam
     * @return
     */
    @Override
    @Transactional
    public String getPatientItemsInfo(String xmlParam) {
        logger.info("[划价单缴费试算  入参 :]" + xmlParam);
        String result = "";
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String cardNo = reroot.element("body").element("cardNo").getText();
            PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPatientId(cardNo);
            List<OutpOrdersT> outpOrdersTList = outpOrdersTMapper.selectByPrimaryKeyForZZJ(cardNo);
            if (!Util.isEmpty(outpOrdersTList)) {
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
                for (int i = 0; i < outpOrdersTList.size(); i++) {
                    ordersCostsListForSGAndFC =
                            outpOrdersCostsMapper.selectOrdersCostsDeleteForSG(outpOrdersTList.get(i).getVisitNo(),
                                    outpOrdersTList.get(i).getVisitDate(), "s160", "ZZJ"); //查询是否已经插入采血费和药品的辅材费，已存在先删除
                    if (!Util.isEmpty(ordersCostsListForSGAndFC)) {
                        for (int k = 0; k < ordersCostsListForSGAndFC.size(); k++) {
                            outpOrdersCostsMapper.deleteByPrimaryKey(ordersCostsListForSGAndFC.get(k));
                        }
                    }
                }
                //雾化吸入 只收一组
                boolean flag = false;
                //组织支付项目
                for (int i = 0; i < outpOrdersTList.size(); i++) {
                    OutpOrdersT outpOrdersT = outpOrdersTList.get(i);
                    ClinicMaster clinicMaster = new ClinicMaster();
                    clinicMaster.setVisitDate(outpOrdersT.getVisitDate());
                    clinicMaster.setVisitNo(outpOrdersT.getVisitNo());
                    clinicMaster = clinicMasterMapper.selectByPrimaryKey(clinicMaster);

                    if (!Util.isEmpty(outpOrdersT.getSerialNo())) {
                        List<OutpOrdersCosts> outpOrdersCostsList =
                                outpOrdersCostsMapper.selectOrdersCostsListBySerialNo(outpOrdersT.getSerialNo(),
                                        outpOrdersT.getVisitDate(), outpOrdersT.getVisitNo());
                        if (!(outpOrdersCostsList != null && outpOrdersCostsList.size() > 0)) {
                            continue;
                        }

                        // 只要有一次性末梢采血器，不收取任何辅助检查
                        List<OutpOrdersCosts> ordersCostsListForCXQ =
                                outpOrdersCostsMapper.selectOrdersCostsListForCXQ(outpOrdersT.getVisitNo(),
                                        outpOrdersT.getVisitDate(), outpOrdersT.getPatientId());
                        if (!(ordersCostsListForCXQ != null && ordersCostsListForCXQ.size() > 0)) {
                            //查询试管
                            //2.如果是同一执行科室，只收一个管子,如果不是同一执行科室，每个科室收一个管子,同一批只收一个针头，一个静脉采血
                            List<OutpOrdersCosts> ordersCostsListForSG =
                                    outpOrdersCostsMapper.selectOrdersCostsDeptForSG(outpOrdersT.getVisitNo(),
                                            outpOrdersT.getVisitDate(), "ZZJ", "s160"); //查询是否已经插入采血费，已存在不需要插入
                            if (Util.isEmpty(ordersCostsListForSG)) {
                                String serialNo = "";
                                for (int j = 0; j < outpOrdersCostsList.size(); j++) {
                                    OutpOrdersCosts ordersCosts = outpOrdersCostsList.get(j);
                                    if (ordersCosts.getOrderClass().equals("C")) {
                                        serialNo = ordersCosts.getSerialNo();
                                        break;
                                    }
                                }
                                if (!Util.isEmpty(serialNo)) {
                                    //  List<OutpOrdersCosts> outpOrdersDeptList =outpOrdersCostsMapper
                                    // .selectOrdersCostsDeptForJY(outpOrdersT.getVisitNo(),outpOrdersT.getVisitDate
                                    // ());//查询执行科室 绑定试管数量
                                    List<RecordNo> recorNoList =
                                            recordNoMapper.selectPerformedByListForSG(outpOrdersT.getVisitNo(),
                                                    outpOrdersT.getVisitDate(), StringUtil.Utf_Iso("血%"));//查询执行科室 绑定试管数量
                                    if (!Util.isEmpty(recorNoList)) {
                                        List<PriceList> priceLists =
                                                priceListMapper.selectPriceListForSG(StringUtil.Utf_Iso("7#南京德玥科"),
                                                        StringUtil.Utf_Iso("进口南京浩谷"));
                                        //将试管组织插入到医嘱表中
                                        for (int k = 0; k < priceLists.size(); k++) {
                                            PriceList priceList = priceLists.get(k);
                                            OutpOrdersCosts outpOrdersCostsSG = new OutpOrdersCosts();
                                            outpOrdersCostsSG.setSerialNo(serialNo);
                                            outpOrdersCostsSG.setOrderClass("C");
                                            outpOrdersCostsSG.setOrderNo((short) 0); //接口写入的采血类型
                                            int no = k + 1;
                                            outpOrdersCostsSG.setItemNo((short) no);
                                            outpOrdersCostsSG.setPatientId(outpOrdersT.getPatientId());
                                            outpOrdersCostsSG.setVisitDate(outpOrdersT.getVisitDate());
                                            outpOrdersCostsSG.setVisitNo(outpOrdersT.getVisitNo());
                                            outpOrdersCostsSG.setItemClass(priceList.getItemClass());
                                            outpOrdersCostsSG.setItemName(priceList.getItemName());
                                            outpOrdersCostsSG.setOrderSubNo((short) 1);
                                            outpOrdersCostsSG.setRepetition((short) 1);
                                            outpOrdersCostsSG.setItemCode(priceList.getItemCode());
                                            outpOrdersCostsSG.setItemSpec(priceList.getItemSpec());
                                            outpOrdersCostsSG.setUnits(priceList.getUnits());
                                            if (priceList.getItemCode().equals("71AAE00001")) { //试管
                                                int size = recorNoList.size();
                                                outpOrdersCostsSG.setAmount(new BigDecimal(size));
                                                BigDecimal amount = new BigDecimal(size);
                                                BigDecimal costs =
                                                        amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                outpOrdersCostsSG.setCosts(costs);
                                                outpOrdersCostsSG.setCharges(costs);
                                            } else {
                                                outpOrdersCostsSG.setAmount(new BigDecimal(1));
                                                outpOrdersCostsSG.setCosts(priceList.getPrice());
                                                outpOrdersCostsSG.setCharges(priceList.getPrice());
                                            }
                                            outpOrdersCostsSG.setOrderedByDept(outpOrdersT.getOrderedBy());
                                            outpOrdersCostsSG.setOrderByName("ZZJ");
                                            outpOrdersCostsSG.setOrderedByDoctor(outpOrdersT.getDoctor());
                                            outpOrdersCostsSG.setChargeIndicator((short) 0);
                                            if (outpOrdersT.getOrderedBy().startsWith("28")) {
                                                outpOrdersCostsSG.setPerformedBy("2802");
                                            } else if (outpOrdersT.getOrderedBy().startsWith("11")) {
                                                outpOrdersCostsSG.setPerformedBy("110301");
                                            } else {
                                                outpOrdersCostsSG.setPerformedBy("2607");
                                            }
                                            outpOrdersCostsMapper.insert(outpOrdersCostsSG);
                                        }
                                    }
                                }
                            }
                        }

                        boolean flagJC = false;//执行科室为 4701 单独收一个一次性大单
                        boolean flag1 = false;//执行科室为 1107 单独收一个一次性大单
                        boolean flagDeptCode = false; //开单科室11开头的 并且 执行科室为 4701  单独收0.5 耦合剂
                        if (!Util.isEmpty(outpOrdersCostsList)) {
                            for (int k = 0; k < outpOrdersCostsList.size(); k++) {
                                OutpOrdersCosts ordersCosts = outpOrdersCostsList.get(k);
                                if (ordersCosts.getOrderClass().equals("D")) {
                                    if (!flagJC) {
                                        if (ordersCosts.getPerformedBy().equals("4701") || ordersCosts.getPerformedBy().equals("1107")) {
                                            short num =
                                                    outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                            CurrentPriceList currentPriceList =
                                                    currentPriceListMapper.selectByPrimaryKey("I", "71AAC00006",
                                                            StringUtil.Utf_Iso("60Cmx110Cm南京新中标"), StringUtil.Utf_Iso("条"));
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
                                                outpOrdersCostsJM.setOrderByName("ZZJ");
                                                outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                outpOrdersCostsJM.setPerformedBy("4701");
                                                outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                            }
                                            flagJC = true;
                                            continue;
                                        }
                                    }
                                    if (!flag1) {
                                        if (ordersCosts.getPerformedBy().equals("1107")) {
                                            short num =
                                                    outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                            CurrentPriceList currentPriceList =
                                                    currentPriceListMapper.selectByPrimaryKey("I", "71AAC00006",
                                                            StringUtil.Utf_Iso("60Cmx110Cm南京新中标"), StringUtil.Utf_Iso("条"));
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
                                                outpOrdersCostsJM.setOrderByName("ZZJ");
                                                outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                outpOrdersCostsJM.setPerformedBy("1107");
                                                outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                            }
                                            flag1 = true;
                                            continue;
                                        }
                                    }
                                    if (!flagDeptCode) {
                                        if (outpOrdersT.getOrderedBy().equals("1103") && ordersCosts.getPerformedBy().equals("4701")) {
                                            short num =
                                                    outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                            CurrentPriceList currentPriceList =
                                                    currentPriceListMapper.selectByPrimaryKey("I", "71AAF00713", "0.5",
                                                            StringUtil.Utf_Iso("支"));
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
                                                outpOrdersCostsJM.setOrderByName("ZZJ");
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
                        if (!Util.isEmpty(outpOrdersCostsList)) {
                            for (int j = 0; j < outpOrdersCostsList.size(); j++) {
                                OutpOrdersCosts ordersCosts = outpOrdersCostsList.get(j);
                                if (ordersCosts.getOrderClass().equals("A") && (StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("静脉滴注") || StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("静脉续滴") || StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("小儿静滴"))) {
                                    logger.info("----------->zjp" + StringUtil.Iso_GBK(ordersCosts.getAdministration()));
                                    List<ItemRelation> itemRelationList = itemRelationMapper.selectItemList();
                                    for (int k = 0; k < itemRelationList.size(); k++) {
                                        ItemRelation itemRelation = itemRelationList.get(k);
                                        if (ordersCosts.getItemClass().equals(itemRelation.getItemClass()) && ordersCosts.getItemCode().equals(itemRelation.getItemCode()) && ordersCosts.getItemSpec().equals(itemRelation.getItemSpec()) && ordersCosts.getUnits().equals(itemRelation.getUnits())) {
                                            List<ClinicVsCharge> clinicVsChargeList =
                                                    clinicVsChargeMapper.selectByAdministration(ordersCosts.getAdministration());
                                            if (!Util.isEmpty(clinicVsChargeList)) {
                                                short num =
                                                        outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                                for (int g = 0; g < clinicVsChargeList.size(); g++) {
                                                    ClinicVsCharge clinicVsCharge = clinicVsChargeList.get(g);
                                                    PriceList priceList =
                                                            priceListMapper.selectPriceListForAdministration(clinicVsCharge.getChargeItemClass(), clinicVsCharge.getChargeItemCode(), clinicVsCharge.getChargeItemSpec(), clinicVsCharge.getUnits());
                                                    if (!(priceList == null)) {
                                                        OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                        outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                        outpOrdersCostsJM.setOrderClass(priceList.getItemClass());
                                                        outpOrdersCostsJM.setOrderNo((short) 1);
                                                        int no = num + g + 1;
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
                                                        if (ordersCosts.getDays() == null || ordersCosts.getDays() < 1) {
                                                            amount = new BigDecimal(clinicVsCharge.getAmount());
                                                        } else {
                                                            amount =
                                                                    new BigDecimal(clinicVsCharge.getAmount()).multiply(new BigDecimal(ordersCosts.getDays()));
                                                        }
                                                        outpOrdersCostsJM.setAmount(amount);
                                                        outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                        //BigDecimal amount = new BigDecimal(clinicVsCharge.getAmount
                                                        // ());
                                                        BigDecimal cost =
                                                                amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                        outpOrdersCostsJM.setCosts(cost);
                                                        outpOrdersCostsJM.setCharges(cost);
                                                        outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                        outpOrdersCostsJM.setOrderByName("ZZJ");
                                                        outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                        outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                        if (StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("小儿静滴")) {
                                                            outpOrdersCostsJM.setPerformedBy("260201");
                                                        } else {
                                                            if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                outpOrdersCostsJM.setPerformedBy("260201");
                                                            } else if (outpOrdersT.getOrderedBy().equals("1103")) {
                                                                outpOrdersCostsJM.setPerformedBy("110301");
                                                            } else {
                                                                outpOrdersCostsJM.setPerformedBy("2802");
                                                            }
                                                        }
                                                        outpOrdersCostsMapper.insert(outpOrdersCostsJM);
                                                    }
                                                }
                                            }
                                            if (ordersCosts.getOrderClass().equals("A") && (StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("静脉滴注"))) {
                                                PriceList priceList =
                                                        priceListMapper.selectPriceListForSY(StringUtil.Utf_Iso("20ml江苏苏云医"));
                                                short num =
                                                        outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                                if (!(priceList == null)) {
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
                                                    if (ordersCosts.getDays() == null || ordersCosts.getDays() < 1) {
                                                        outpOrdersCostsZS.setAmount(BigDecimal.valueOf(1));
                                                        cost = new BigDecimal(String.valueOf(priceList.getPrice()));
                                                    } else {
                                                        outpOrdersCostsZS.setAmount(new BigDecimal(ordersCosts.getDays()));
                                                        cost =
                                                                new BigDecimal(ordersCosts.getDays()).multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                    }

                                                    outpOrdersCostsZS.setDays(ordersCosts.getDays());
                                                    outpOrdersCostsZS.setCosts(cost);
                                                    outpOrdersCostsZS.setCharges(cost);
                                                    outpOrdersCostsZS.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                    outpOrdersCostsZS.setOrderByName("ZZJ");
                                                    outpOrdersCostsZS.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                    outpOrdersCostsZS.setChargeIndicator((short) 0);
                                                    if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                        outpOrdersCostsZS.setPerformedBy("260201");
                                                    } else if (outpOrdersT.getOrderedBy().equals("1103")) {
                                                        outpOrdersCostsZS.setPerformedBy("110301");
                                                    } else {
                                                        outpOrdersCostsZS.setPerformedBy("2802");
                                                    }
                                                    outpOrdersCostsMapper.insert(outpOrdersCostsZS);
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    if (!Util.isEmpty(ordersCosts.getAdministration())) {
                                        BigDecimal days = new BigDecimal(String.valueOf(ordersCosts.getDays()));
                                        if (StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("雾化吸入")) {
                                            if (flag) {
                                                continue;
                                            }
                                            flag = true;
                                            days =
                                                    new BigDecimal(String.valueOf(outpOrdersCostsMapper.selectISOrdersCostsForMaxAmount(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), StringUtil.Utf_Iso("雾化吸入"), outpOrdersT.getPatientId()).getAmount()));
                                        }
                                        //配置中的代码不收辅材费
                                        File file = new File("C:\\configuration\\drugCode.txt");
                                        String drugCode = txt2String(file);
                                        if (drugCode != null && drugCode.length() > 0) {
                                            if (!drugCode.contains(ordersCosts.getItemCode())) {
                                                List<ClinicVsCharge> clinicVsChargeList =
                                                        clinicVsChargeMapper.selectByAdministration(ordersCosts.getAdministration());
                                                if (!Util.isEmpty(clinicVsChargeList)) {
                                                    short num =
                                                            outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                                    for (int k = 0; k < clinicVsChargeList.size(); k++) {
                                                        ClinicVsCharge clinicVsCharge = clinicVsChargeList.get(k);
                                                        PriceList priceList =
                                                                priceListMapper.selectPriceListForAdministration(clinicVsCharge.getChargeItemClass(), clinicVsCharge.getChargeItemCode(), clinicVsCharge.getChargeItemSpec(), clinicVsCharge.getUnits());
                                                        if (!(priceList == null)) {
                                                            OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                            outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                            outpOrdersCostsJM.setOrderClass(priceList.getItemClass());
                                                            outpOrdersCostsJM.setOrderNo((short) 1);
                                                            int no = num + k + 1;
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
                                                            if (days.compareTo(new BigDecimal(1)) < 0) {
                                                                amount = new BigDecimal(clinicVsCharge.getAmount());
                                                            } else {
                                                                amount =
                                                                        new BigDecimal(clinicVsCharge.getAmount()).multiply(days);
                                                            }
                                                            outpOrdersCostsJM.setAmount(amount);
                                                            outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                            //BigDecimal amount = new BigDecimal(clinicVsCharge
                                                            // .getAmount());
                                                            BigDecimal cost =
                                                                    amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                            outpOrdersCostsJM.setCosts(cost);
                                                            outpOrdersCostsJM.setCharges(cost);
                                                            outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                            outpOrdersCostsJM.setOrderByName("ZZJ");
                                                            outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                            outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                            if (StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("肌肉注射")) {
                                                                if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                    outpOrdersCostsJM.setPerformedBy("260201");
                                                                } else if (outpOrdersT.getOrderedBy().equals("1103")) {
                                                                    outpOrdersCostsJM.setPerformedBy("110301");
                                                                } else if (outpOrdersT.getOrderedBy().startsWith("28")) {
                                                                    outpOrdersCostsJM.setPerformedBy("2802");
                                                                } else {
                                                                    outpOrdersCostsJM.setPerformedBy("2607");
                                                                }
                                                            } else {
                                                                if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                    outpOrdersCostsJM.setPerformedBy("260201");
                                                                } else if (outpOrdersT.getOrderedBy().equals("1103")) {
                                                                    outpOrdersCostsJM.setPerformedBy("110301");
                                                                } else if (outpOrdersT.getOrderedBy().equals("1901") && StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("雾化吸入")) {
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
                                        } else {
                                            List<ClinicVsCharge> clinicVsChargeList =
                                                    clinicVsChargeMapper.selectByAdministration(ordersCosts.getAdministration());
                                            if (!Util.isEmpty(clinicVsChargeList)) {
                                                short num =
                                                        outpOrdersCostsMapper.selectISOrdersCostsForMaxItemNo(ordersCosts.getVisitDate(), ordersCosts.getVisitNo(), ordersCosts.getSerialNo()).getItemNo();
                                                for (int k = 0; k < clinicVsChargeList.size(); k++) {
                                                    ClinicVsCharge clinicVsCharge = clinicVsChargeList.get(k);
                                                    PriceList priceList =
                                                            priceListMapper.selectPriceListForAdministration(clinicVsCharge.getChargeItemClass(), clinicVsCharge.getChargeItemCode(), clinicVsCharge.getChargeItemSpec(), clinicVsCharge.getUnits());
                                                    if (!(priceList == null)) {
                                                        OutpOrdersCosts outpOrdersCostsJM = new OutpOrdersCosts();
                                                        outpOrdersCostsJM.setSerialNo(ordersCosts.getSerialNo());
                                                        outpOrdersCostsJM.setOrderClass(priceList.getItemClass());
                                                        outpOrdersCostsJM.setOrderNo((short) 1);
                                                        int no = num + k + 1;
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
                                                        if (days.compareTo(new BigDecimal(1)) < 0) {
                                                            amount = new BigDecimal(clinicVsCharge.getAmount());
                                                        } else {
                                                            amount =
                                                                    new BigDecimal(clinicVsCharge.getAmount()).multiply(days);
                                                        }
                                                        outpOrdersCostsJM.setAmount(amount);
                                                        outpOrdersCostsJM.setDays(ordersCosts.getDays());
                                                        //BigDecimal amount = new BigDecimal(clinicVsCharge.getAmount
                                                        // ());
                                                        BigDecimal cost =
                                                                amount.multiply(new BigDecimal(String.valueOf(priceList.getPrice())));
                                                        outpOrdersCostsJM.setCosts(cost);
                                                        outpOrdersCostsJM.setCharges(cost);
                                                        outpOrdersCostsJM.setOrderedByDept(outpOrdersT.getOrderedBy());
                                                        outpOrdersCostsJM.setOrderByName("ZZJ");
                                                        outpOrdersCostsJM.setOrderedByDoctor(outpOrdersT.getDoctor());
                                                        outpOrdersCostsJM.setChargeIndicator((short) 0);
                                                        if (StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("肌肉注射")) {
                                                            if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                outpOrdersCostsJM.setPerformedBy("260201");
                                                            } else if (outpOrdersT.getOrderedBy().equals("1103")) {
                                                                outpOrdersCostsJM.setPerformedBy("110301");
                                                            } else if (outpOrdersT.getOrderedBy().startsWith("28")) {
                                                                outpOrdersCostsJM.setPerformedBy("2802");
                                                            } else {
                                                                outpOrdersCostsJM.setPerformedBy("2607");
                                                            }
                                                        } else {
                                                            if (outpOrdersT.getOrderedBy().equals("2602")) {
                                                                outpOrdersCostsJM.setPerformedBy("260201");
                                                            } else if (outpOrdersT.getOrderedBy().equals("1103")) {
                                                                outpOrdersCostsJM.setPerformedBy("110301");
                                                            } else if (outpOrdersT.getOrderedBy().equals("1901") && StringUtil.Iso_GBK(ordersCosts.getAdministration()).equals("雾化吸入")) {
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
                        outpOrdersCostsList =
                                outpOrdersCostsMapper.selectOrdersCostsListBySerialNo(outpOrdersT.getSerialNo(),
                                        outpOrdersT.getVisitDate(), outpOrdersT.getVisitNo());
                        String hisPayAmt = outpOrdersCostsMapper.selectCountBySerialNo(outpOrdersT.getSerialNo(),
                                outpOrdersT.getVisitDate(), outpOrdersT.getVisitNo()).getCosts().toString();
                        String deptName = deptDictMapper.selectByPrimaryKey(outpOrdersT.getOrderedBy()).getDeptName();
                        for (int j = 0; j < outpOrdersCostsList.size(); j++) {
                            Element payInfoElement = bodyElement.addElement("pay_info");
                            OutpOrdersCosts outpOrdersCosts = outpOrdersCostsList.get(j);
                            payInfoElement.addElement("hisPayNo").setText(outpOrdersCosts.getSerialNo());//流水号
                            payInfoElement.addElement("cflsh").setText(outpOrdersCosts.getSerialNo() + outpOrdersCosts.getItemNo());//处方流水号
                            payInfoElement.addElement("presNo").setText(StringUtil.Iso_GBK(outpOrdersCosts.getOrderNo() + ""));//医嘱序号
                            payInfoElement.addElement("hisPayNoSn").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemNo() + ""));//计价项目序号
                            payInfoElement.addElement("item_code_his").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemCode()));//计价项目代码

                            InsuVsPrice insuVsPrice = new InsuVsPrice();
                            insuVsPrice.setItemClass(outpOrdersCosts.getItemClass());
                            insuVsPrice.setItemCode(outpOrdersCosts.getItemCode());
                            insuVsPrice.setItemSpec(outpOrdersCosts.getItemSpec());
                            insuVsPrice.setUnits(outpOrdersCosts.getUnits());
                            insuVsPrice = insuVsPriceMapper.selectByPrimaryKey(insuVsPrice);

                            payInfoElement.addElement("itemCodeYB").setText(insuVsPrice.getInsuItemsCode());
                            //计价项目名称
                            payInfoElement.addElement("detail_item_name").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemName()));
                            //计价项目规格
                            payInfoElement.addElement("std").setText(StringUtil.Iso_GBK(outpOrdersCosts.getItemSpec()));
                            //最小计价单位收费标志
                            payInfoElement.addElement("zxjjbs").setText(processZxjjbs(outpOrdersCosts.getItemSpec()));
//                            payInfoElement.addElement("amt").setText(StringUtil.Iso_GBK(outpOrdersCosts.getAmount()
// + ""));//数量
                            payInfoElement.addElement("unit").setText(StringUtil.Iso_GBK(outpOrdersCosts.getUnits()));//计价单位
                            PriceList priceList =
                                    priceListMapper.selectPriceListForAdministration(outpOrdersCosts.getItemClass(),
                                            outpOrdersCosts.getItemCode(), outpOrdersCosts.getItemSpec(), outpOrdersCosts.getUnits());
                            if (priceList != null) {
                                payInfoElement.addElement("price").setText(priceList.getPrice() + ""); //单价
                            } else {
                                payInfoElement.addElement("price").setText(outpOrdersCosts.getCosts().divide(outpOrdersCosts.getAmount(), 3, RoundingMode.HALF_UP) + ""); //单价
                            }
                            payInfoElement.addElement("detailPayAmt").setText(outpOrdersCosts.getCosts() + "");//计价费用
                            payInfoElement.addElement("phone").setText(Util.escapeInnerText(patMasterIndex.getPhoneNumberHome()));
                            payInfoElement.addElement("cardId").setText(Util.escapeInnerText(patMasterIndex.getIdNo()));
                            payInfoElement.addElement("healthyno").setText(DateToWeek.formatDateString(outpOrdersT.getVisitDate(), "yyyy-MM-dd") + "^" + outpOrdersT.getVisitNo()); //
                            payInfoElement.addElement("his_pay_no").setText(outpOrdersT.getSerialNo());
                            payInfoElement.addElement("payamt").setText(hisPayAmt);
                            payInfoElement.addElement("selfPayAmt").setText(hisPayAmt);
                            payInfoElement.addElement("socialPayAmt").setText("0");
                            payInfoElement.addElement("payType").setText("zizhuji");
                            payInfoElement.addElement("creatTime").setText(Util.format(outpOrdersT.getOrderDate(),
                                    "yyyy-MM-dd HH:mm:ss"));
                            payInfoElement.addElement("regType").setText("0");
                            payInfoElement.addElement("depId").setText(outpOrdersT.getOrderedBy());
                            payInfoElement.addElement("dep_name").setText(StringUtil.Iso_GBK(deptName));
                            payInfoElement.addElement("docId").setText(StringUtil.Iso_GBK(outpOrdersT.getDoctor()));
                            List<InsuDoctorDict> idd = insuDoctorDictMapper.selectByDoctorName(outpOrdersT.getDoctor());
                            if (idd != null && idd.size() > 0) {
                                payInfoElement.addElement("ybysbm").setText(idd.get(0).getDoctCode());
                            } else {
                                // update by tang 2018-05-22 医生找不到编码,默认传医生名字
                                payInfoElement.addElement("ybysbm").setText(outpOrdersT.getDoctor());
                            }
                            String itemClass = "1";  // 1 药品  2  诊疗   3 医疗器材
                            if (outpOrdersCosts.getItemClass().equals("A") || outpOrdersCosts.getItemClass().equals(
                                    "B")) {
                                itemClass = "1";
                            } else if (outpOrdersCosts.getItemClass().equals("I")) {
                                itemClass = "3";
                            } else {
                                itemClass = "2";
                            }
                            payInfoElement.addElement("itemClass").setText(itemClass);
                            String feeType = "";
                            if (StringUtil.Iso_GBK(clinicMaster.getChargeType()).equals("自费")) {
                                feeType = "0";
                            } else {
                                feeType = "1";
                            }
                            payInfoElement.addElement("feeType").setText(feeType);
                            InsuVsHospitalDept ivhd =
                                    insuVsHospitalDeptMapper.selectByPrimaryByDeptCode(outpOrdersT.getOrderedBy());
                            if (ivhd != null) {
                                payInfoElement.addElement("ybksdm").setText(ivhd.getInsuDeptCode());
                            } else {
                                payInfoElement.addElement("ybksdm").setText("");
                            }
                            String rcptNo = Util.getCurrentDate("yyyyMMddHHmmss") + outpOrdersT.getVisitNo();//门诊流水号
                            String djh = "O" + recpNoMapper.selectRecpNo().getRecpNo(); //单据号
                            payInfoElement.addElement("mzNO").setText(rcptNo);//门诊流水号
                            payInfoElement.addElement("djh").setText(djh);
                            OutpMrKey outpMrKey = new OutpMrKey();
                            outpMrKey.setVisitDate(outpOrdersT.getVisitDate());
                            outpMrKey.setVisitNo(outpOrdersT.getVisitNo());
                            outpMrKey.setOrdinal((short) 1);
                            OutpMr outpMr = outpMrMapper.selectByPrimaryKey(outpMrKey);
                            if (outpMr != null) {
                                if (!Util.isEmpty(outpMr.getDiagCode())) {
                                    List<InsuranceVsDiagnosis> insuranceVsDiagnosisList =
                                            insuranceVsDiagnosisMapper.selectByIcdCode(outpMr.getDiagCode());
                                    if (insuranceVsDiagnosisList.size() > 0) {
                                        payInfoElement.addElement("bzm").setText(insuranceVsDiagnosisList.get(0).getIcdCode());
                                    } else {
                                        insuranceVsDiagnosisList =
                                                insuranceVsDiagnosisMapper.selectByDiagnosisCode(outpMr.getDiagCode());
                                        if (insuranceVsDiagnosisList.size() > 0) {
                                            payInfoElement.addElement("bzm").setText(insuranceVsDiagnosisList.get(0).getIcdCode());
                                        } else {
                                            payInfoElement.addElement("bzm").setText("20");
                                        }
                                    }
                                } else {
                                    payInfoElement.addElement("bzm").setText("20");
                                }
                            } else {
                                payInfoElement.addElement("bzm").setText("20");
                            }
                            if (outpOrdersCosts.getItemClass().equals("B")) {
                                OutpPrescKey outpPrescKey = new OutpPrescKey();
                                outpPrescKey.setSerialNo(outpOrdersCosts.getSerialNo());
                                outpPrescKey.setItemNo(outpOrdersCosts.getItemNo());
                                OutpPresc outpPresc = outpPrescMapper.selectByPrimaryKey(outpPrescKey);
                                payInfoElement.addElement("cfts").setText(outpPresc.getRepetition() + "");//处方帖数
                                payInfoElement.addElement("amt").setText(outpOrdersCosts.getAmount().multiply(new BigDecimal(outpPresc.getRepetition())).toString());//数量
                            } else {
                                payInfoElement.addElement("cfts").setText("1");
                                payInfoElement.addElement("amt").setText(StringUtil.Iso_GBK(outpOrdersCosts.getAmount() + ""));//数量
                            }


                        }
                    }
                }
                logger.info(doc.asXML());
                return result = doc.asXML();
            } else {
                return result = getErrorlMsg("[无收费项目]");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     * 划价单缴费 用户缴费（将单张、缴费完毕的划价单的缴费情况信息和缴费项目，提交给HIS系统进行相关记录）
     *
     * @param xmlParam
     * @return
     */
    @Override
    @Transactional
    public String saveBillItems(String xmlParam) {
        logger.info("[划价单缴费  入参 :]" + xmlParam);
        Document document = null;
        String result = "";
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String hisPayNo = reroot.element("body").element("hisPayNo").getTextTrim();
            String tradeNo = reroot.element("body").element("tradeNo").getTextTrim();
            String payAmt = reroot.element("body").element("payAmt").getTextTrim(); //支付金额
            String payMethod = reroot.element("body").element("payMethod").getTextTrim(); // 自助阿里5  自助微信6  自助银联9
            String payTime = reroot.element("body").element("payTime").getTextTrim();
            String payType = reroot.element("body").element("payType").getTextTrim();
            String mchid = reroot.element("body").element("mchId").getTextTrim(); //商务号
            String feeType = reroot.element("body").element("feeType").getTextTrim(); //0 自费 1医保
            String inCardNo = reroot.element("body").element("inCardNo").getTextTrim();//医保卡号
            String cardNoType = reroot.element("body").element("cardNoType").getTextTrim();//医保类型
            String insuRcptNo = reroot.element("body").element("insuRcptNo").getTextTrim();//医保收据号
            String inCashPay = reroot.element("body").element("inCashPay").getTextTrim(); //现金支付
            String payFromAccount = reroot.element("body").element("payFromAccount").getTextTrim(); //个人账户支付
            String payFromFund = reroot.element("body").element("payFromFund").getTextTrim();// 统筹支付
            String paymentSelf = reroot.element("body").element("paymentSelf").getTextTrim(); //自理费用
            String insuRangeTotal = reroot.element("body").element("insuRangeTotal").getTextTrim(); //医保范围费用
            String largerDiagnosisPayment = reroot.element("body").element("largerDiagnosisPayment").getTextTrim();
            //大病支付
            String payFromInsured = reroot.element("body").element("payFromInsured").getTextTrim();//个人支付
            String accountInitialAmount = reroot.element("body").element("accountInitialAmount").getTextTrim();//期初个人账户
            String accountEndAmount = reroot.element("body").element("accountEndAmount").getTextTrim();//期末个人账号
            String insuOperatorNo = reroot.element("body").element("insuOperatorNo").getTextTrim();//操作员医保编码
            String drugTotal = reroot.element("body").element("drugTotal").getTextTrim();//药费合计
            String medicalTotal = reroot.element("body").element("medicalTotal").getTextTrim();//治疗项目合计

            //银联支付
            String yhkh = reroot.element("body").element("yhkh").getTextTrim(); // 银行卡号
            String pzh = reroot.element("body").element("pzh").getTextTrim();// 凭证号
            String ckh = reroot.element("body").element("ckh").getTextTrim();//  参考号
            String je = reroot.element("body").element("je").getTextTrim();  //  金额 （元）
            String zdh = reroot.element("body").element("zdh").getTextTrim();//  终端号
            String pch = reroot.element("body").element("pch").getTextTrim();//  批次号
            String jysj = reroot.element("body").element("jysj").getTextTrim();//  日期
            String shh = reroot.element("body").element("shh").getTextTrim();// 商务编号
            String czy = reroot.element("body").element("czy").getTextTrim();// 操作员


            String siDkOutParam = reroot.element("body").element("siDkOutParam").getTextTrim();// 读卡出参
            String siDjParam = reroot.element("body").element("siDjParam").getTextTrim(); //登记入参
            String siInParam = reroot.element("body").element("siInParam").getTextTrim(); //结算入参
            String siOutParam = reroot.element("body").element("siOutParam").getTextTrim(); //结算反参
            String mxsc = reroot.element("body").element("mxsc").getTextTrim(); //上传明细反参

            Document doc = DocumentHelper.createDocument();
            doc.setXMLEncoding("GBK");
            Element rootR = doc.addElement("response");
            Element head = rootR.addElement("head");

            InternetPayinfo IPI = internetPayinfoMapper.selectByPrimaryKey(tradeNo);
            if (IPI == null) {
                if (feeType != null && feeType.length() > 0) {
                    SiReadCardInfo siReadCardInfo = new SiReadCardInfo();
                    SiInDJParamInfo siInDJParamInfo = new SiInDJParamInfo();
                    SiSettlementInParamInfo siSettlementInParamInfo = new SiSettlementInParamInfo();
                    SiSettlementOutParamInfo siSettlementOutParamInfo = new SiSettlementOutParamInfo();
                    List<SiPrenoOut> siPrenoOutList = new ArrayList<SiPrenoOut>();
                    if ("1".equals(feeType)) {

                        siReadCardInfo = SiClassUtil.getSiReadCardInfo(siDkOutParam);

                        siInDJParamInfo = SiClassUtil.getSiInDjList(siDjParam);
                        //  siInParam  siOutParam
                        siSettlementInParamInfo = SiClassUtil.getSiSettlementInParamInfo(siInParam);

                        siSettlementOutParamInfo = SiClassUtil.getSiSettlementOutParamInfo(siOutParam);

                        siPrenoOutList = SiClassUtil.getSiPrenoOutList(mxsc).getSiPrenoOutList();
                    }


                    //该单据所有费用
                    String hisPayAmt = outpOrdersCostsMapper.selectCountBySerialNo1(hisPayNo).getCosts().toString();
                    String rcptNo = "";
                    if (!Util.isEmpty(hisPayNo) && new BigDecimal(payAmt).compareTo(new BigDecimal(hisPayAmt)) == 0) {
                        List<OutpOrdersCosts> outpOrdersCostsList =
                                outpOrdersCostsMapper.selectOrdersCostsListBySerialNo1(hisPayNo);
                        OutpOrdersT outpOrdersT = outpOrdersTMapper.selectByPrimaryKey(hisPayNo);
                        if (!Util.isEmpty(outpOrdersCostsList)) {
//                        PatMasterIndex patMasterIndex = patMasterIndexMapper.selectByPrimaryKey(cardNo);

                            ClinicMaster clinicMaster = new ClinicMaster();
                            clinicMaster.setVisitDate(outpOrdersT.getVisitDate());
                            clinicMaster.setVisitNo(outpOrdersT.getVisitNo());
                            clinicMaster = clinicMasterMapper.selectByPrimaryKey(clinicMaster);

                            if ("1".equals(feeType)) {
                                rcptNo = siSettlementInParamInfo.getDjh();
                            } else {
                                rcptNo = "O" + recpNoMapper.selectRecpNo().getRecpNo();
                            }
                            //1.门诊医疗收据记录 OUTP_RCPT_MASTER
                            OutpRcptMaster outpRcptMaster = new OutpRcptMaster();
                            outpRcptMaster.setRcptNo(rcptNo);
                            outpRcptMaster.setPatientId(clinicMaster.getPatientId());
                            outpRcptMaster.setName(clinicMaster.getName());
                            outpRcptMaster.setNamePhonetic(clinicMaster.getNamePhonetic());
                            if ("1".equals(feeType)) {
                                outpRcptMaster.setIdentity(clinicMaster.getIdentity());
                                outpRcptMaster.setChargeType(clinicMaster.getChargeType());
                            } else {
                                outpRcptMaster.setIdentity(StringUtil.Utf_Iso("地方人员"));
                                outpRcptMaster.setChargeType(StringUtil.Utf_Iso("自费"));
                            }

                            outpRcptMaster.setUnitInContract(clinicMaster.getUnitInContract());
                            outpRcptMaster.setVisitDate(new Timestamp(DateToWeek.formatDate(payTime, "yyyy-MM-dd " +
                                    "HH:mm:ss").getTime()));
                            outpRcptMaster.setTotalCosts(new BigDecimal(payAmt));
                            outpRcptMaster.setTotalCharges(new BigDecimal(payAmt));
                            outpRcptMaster.setOperatorNo("ZZJ");
                            outpRcptMaster.setChargeIndicator((short) 0);
                            outpRcptMaster.getRefundedRcptNo();
                            outpRcptMaster.setAcctNo("");
                            outpRcptMaster.setPrintOperatorNo("");
                            outpRcptMaster.setPrintDateTime(null);

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

                            // add by tang 2018-05-14, 计算payment_no, start
                            short paymentNo = (short) 1;
//                            List<OutpPaymentsMoney> moneyList = outpPaymentsMoneyMapper.selectByRcptNo(rcptNo);
//                            if(moneyList != null && !moneyList.isEmpty())
//                                paymentNo = (short) (moneyList.get(0).getPaymentNo() + 1);
                            // add by tang 2018-05-14, 计算payment_no, end

                            //2.门诊病人支付方式记录 OUTP_PAYMENTS_MONEY
                            if ("1".equals(feeType)) { //现金   统筹 医保账户
                                BigDecimal casePay = new BigDecimal(inCashPay);
                                BigDecimal amount = new BigDecimal(0);
                                BigDecimal fundPay = new BigDecimal(payFromFund);
                                BigDecimal accountPay = new BigDecimal(payFromAccount);
                                if (casePay.compareTo(amount) == 1) {

                                    OutpPaymentsMoney opm = new OutpPaymentsMoney();
                                    opm.setRcptNo(rcptNo);
                                    opm.setPaymentNo(paymentNo++);

                                    opm.setMoneyType(StringUtil.Utf_Iso(moneyType)); // 现金
                                    opm.setPaymentAmount(casePay);
                                    opm.setRefundedAmount(BigDecimal.valueOf(0));
                                    opm.setPrepayNo("");
                                    outpPaymentsMoneyMapper.insert(opm);
                                }
                                if (fundPay.compareTo(amount) == 1) {
                                    OutpPaymentsMoney opm = new OutpPaymentsMoney();
                                    opm.setRcptNo(rcptNo);
                                    opm.setPaymentNo(paymentNo++);
                                    opm.setMoneyType(StringUtil.Utf_Iso("统筹支付")); // 统筹
                                    opm.setPaymentAmount(fundPay);
                                    opm.setRefundedAmount(BigDecimal.valueOf(0));
                                    opm.setPrepayNo("");
                                    outpPaymentsMoneyMapper.insert(opm);
                                }
                                if (accountPay.compareTo(amount) == 1) {
                                    OutpPaymentsMoney opm = new OutpPaymentsMoney();
                                    opm.setRcptNo(rcptNo);
                                    opm.setPaymentNo(paymentNo++);
                                    opm.setMoneyType(StringUtil.Utf_Iso("账户支付")); // 医保账户
                                    opm.setPaymentAmount(accountPay);
                                    opm.setRefundedAmount(BigDecimal.valueOf(0));
                                    opm.setPrepayNo("");
                                    outpPaymentsMoneyMapper.insert(opm);
                                }
                            } else {
                                BigDecimal casePay = new BigDecimal(inCashPay);
                                OutpPaymentsMoney opm = new OutpPaymentsMoney();
                                opm.setRcptNo(rcptNo);
                                opm.setPaymentNo(paymentNo);
                                opm.setMoneyType(StringUtil.Utf_Iso(moneyType)); //   自助阿里5  自助微信6  自助银联9  医保支付0
                                opm.setPaymentAmount(casePay);
                                opm.setRefundedAmount(BigDecimal.valueOf(0));
                                opm.setPrepayNo("");
                                outpPaymentsMoneyMapper.insert(opm);
                            }

                            //3.开单记录 OUTP_ORDER_DESC
                            OutpOrderDesc outpOrderDesc = new OutpOrderDesc();
                            outpOrderDesc.setVisitDate(new Timestamp(DateToWeek.formatDate(payTime, "yyyy-MM-dd " +
                                    "HH:mm:ss").getTime()));
                            outpOrderDesc.setVisitNo(outpOrdersT.getVisitNo());
                            outpOrderDesc.setPatientId(clinicMaster.getPatientId());
                            //判断是否含药品处方
                            List<OutpOrdersCosts> outpOrdersCostsForPresc =
                                    outpOrdersCostsMapper.selectOrdersCostsListForPresc(hisPayNo);
                            if (Util.isEmpty(outpOrdersCostsForPresc)) {
                                outpOrderDesc.setPrescIndicator((short) 0);
                            } else {
                                outpOrderDesc.setPrescIndicator((short) 1);
                            }

                            outpOrderDesc.setOrderedByDept(outpOrdersT.getOrderedBy());
                            outpOrderDesc.setOrderedByDoctor(outpOrdersT.getDoctor());
                            outpOrderDesc.setRcptNo(rcptNo);
                            outpOrderDesc.setVisitId(null);

                            outpOrderDescMapper.insert(outpOrderDesc);
                            outpRcptMasterMapper.insert(outpRcptMaster);

                            //4.门诊病人诊疗费用项目 OUTP_BILL_ITEMS
                            for (int i = 0; i < outpOrdersCostsList.size(); i++) {
                                OutpOrdersCosts outpOrdersCosts = outpOrdersCostsList.get(i);
                                OutpBillItems outpBillItems = new OutpBillItems();
                                outpBillItems.setVisitDate(new Timestamp(DateToWeek.formatDate(payTime, "yyyy-MM-dd " +
                                        "HH:mm:ss").getTime()));
                                outpBillItems.setVisitNo(clinicMaster.getVisitNo());
                                outpBillItems.setRcptNo(rcptNo);
                                int k = i + 1;
                                outpBillItems.setItemNo((short) k);
                                outpBillItems.setItemClass(outpOrdersCosts.getItemClass());
                                outpBillItems.setClassOnRcpt(outpOrdersCosts.getOrderClass());
                                outpBillItems.setItemCode(outpOrdersCosts.getItemCode());
                                outpBillItems.setItemName(outpOrdersCosts.getItemName());
                                outpBillItems.setItemSpec(outpOrdersCosts.getItemSpec());
                                if (outpOrdersCosts.getRepetition() > 1)
                                    outpBillItems.setAmount(outpOrdersCosts.getAmount()
                                            .multiply(new BigDecimal(outpOrdersCosts.getRepetition())));
                                else
                                    outpBillItems.setAmount(outpOrdersCosts.getAmount());
                                outpBillItems.setUnits(outpOrdersCosts.getUnits());
                                //配置中的代码 走特定的执行地点
                                File file = new File("C:\\configuration\\itemCode.txt");
                                String itemCode = txt2String(file);
                                if (itemCode != null && itemCode.length() > 0) {
                                    if (itemCode.contains(outpOrdersCosts.getItemCode())) {
                                        outpBillItems.setPerformedBy("31");
                                    } else {
                                        outpBillItems.setPerformedBy(outpOrdersCosts.getPerformedBy());
                                    }
                                } else {
                                    outpBillItems.setPerformedBy(outpOrdersCosts.getPerformedBy());
                                }
                                outpBillItems.setCosts(outpOrdersCosts.getCosts());
                                outpBillItems.setCharges(outpOrdersCosts.getCharges());

                                outpBillItemsMapper.insert(outpBillItems);
                                if ("1".equals(feeType)) {
                                    //4.1 医保门诊费用明细
                                    InsuOutpBillDetail iobd = new InsuOutpBillDetail();
                                    iobd.setPatientId(clinicMaster.getPatientId());// 病人标识
                                    iobd.setPatName(clinicMaster.getName());//病人姓名
                                    iobd.setItemNo((short) k);//项目序号
                                    String itemClass = "0";
                                    if (outpOrdersCosts.getItemClass().equals("A") || outpOrdersCosts.getItemClass().equals("B")) {
                                        itemClass = "0";
                                    } else {
                                        itemClass = "1";
                                    }
                                    iobd.setItemClass(itemClass); //项目分类
                                    iobd.setVisitDate(Util.format(payTime, "yyyyMMddHHmmss")); //就诊日期
                                    iobd.setItemCode(outpOrdersCosts.getItemCode());//项目代码
                                    InsuVsPrice insuVsPrice = new InsuVsPrice();
                                    insuVsPrice.setItemClass(outpOrdersCosts.getItemClass());
                                    insuVsPrice.setItemCode(outpOrdersCosts.getItemCode());
                                    insuVsPrice.setItemSpec(outpOrdersCosts.getItemSpec());
                                    insuVsPrice.setUnits(outpOrdersCosts.getUnits());
                                    insuVsPrice = insuVsPriceMapper.selectByPrimaryKey(insuVsPrice);

                                    iobd.setInsuItemCode(insuVsPrice.getInsuCode());// 医保项目编码
                                    iobd.setInsuItemName(insuVsPrice.getInsuName()); //医保项目名称
                                    iobd.setUnits(outpOrdersCosts.getUnits());//单位
                                    iobd.setPrice(outpOrdersCosts.getCosts());//价格
//                                    iobd.setAmount(outpOrdersCosts.getAmount());//数量
                                    if (outpOrdersCosts.getRepetition() > 1)
                                        iobd.setAmount(outpOrdersCosts.getAmount()
                                                .multiply(new BigDecimal(outpOrdersCosts.getRepetition())));
                                    else
                                        iobd.setAmount(outpOrdersCosts.getAmount());
                                    iobd.setOperatorNo("ZZJ"); //操作员
                                    iobd.setInsuPhamProducingArea(insuVsPrice.getInsuPhamProducingArea());//医保药品产地
                                    iobd.setInsuPhamProducingAreaSign(insuVsPrice.getInsuPhamProducingAreaSign());
                                    //医保药品产地属性
                                    iobd.setItemSpec(outpOrdersCosts.getItemSpec()); //项目规格
                                    iobd.setRcptNo(rcptNo); //收据号
                                    iobd.setInsuCardNo(inCardNo);//医保卡号

                                    insuOutpBillDetailMapper.insert(iobd);

                                }
                            }
                            //5.门诊自助机交易记录 走刘彤的退费接口
//                            InternetPayinfo internetPayinfo = new InternetPayinfo();
//                            internetPayinfo.setTradeNo(tradeNo);
//                            internetPayinfo.setRecptNo(rcptNo);
//                            internetPayinfo.setPatientId(clinicMaster.getPatientId());
//                            internetPayinfo.setChangeDateTime(new Timestamp(DateToWeek.formatDate(payTime,
// "yyyy-MM-dd HH:mm:ss").getTime()));
//                            internetPayinfo.setInoutFlag("o");
//                            internetPayinfo.setPayMethod(StringUtil.Utf_Iso(moneyType));
//                            internetPayinfo.setMchId(mchid);
//                            internetPayinfoMapper.insert(internetPayinfo);
                            //5.门诊自助机交易记录 走刘冬的退费
                            if (payMethod != null && payMethod.length() > 0 && (payMethod.equals("5") || payMethod.equals("6"))) {
                                ScanPay scanPay = new ScanPay();
                                String id = recpNoMapper.selectScanPay().getRecpNo();
                                scanPay.setId(new BigDecimal(id));
                                scanPay.setPatientName(clinicMaster.getName());
                                scanPay.setOperaterId("ZZJ");
                                scanPay.setPatientId(clinicMaster.getPatientId());
                                scanPay.setClinicLabel(clinicMaster.getClinicLabel());
                                scanPay.setVisitDate(clinicMaster.getVisitDate());
                                scanPay.setAmPm(clinicMaster.getVisitTimeDesc());
                                BigDecimal casePay = new BigDecimal(inCashPay);
                                BigDecimal b1 = new BigDecimal(100);
                                scanPay.setTotalCosts(casePay.multiply(b1).intValue() + "");
                                scanPay.setChargeType(StringUtil.Utf_Iso("门诊收费"));
                                scanPay.setPayWay(payMethod);
                                scanPay.setHospitalMark(StringUtil.Utf_Iso("中国人民解放军81医院"));
                                scanPay.setTrandeNo(tradeNo);
                                scanPay.setRcptNo(rcptNo);
                                scanPay.setResultComment("N");
                                scanPay.setOperDate(Util.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
                                scanPayMapper.insert(scanPay);
                            }

                            outpOrdersCostsMapper.updateIndicatorBySerialNo(hisPayNo, rcptNo);
                            // 6. 医保支付
                            if ("1".equals(feeType)) {
                                //新医保
                                AppConfigerParameter appConfigerParameter =
                                        appConfigerParameterMapper.selectByParameterName("NJJB_CONTROL");

                                if (appConfigerParameter != null && appConfigerParameter.getParameterValue().equals(
                                        "Y")) {
                                    String visitDate =
                                            Util.format(outpOrdersT.getVisitDate(), "yyyy-MM-dd") + " " + Util.getCurrentDate("HH:mm:ss");
                                    PatMasterIndex pmi =
                                            patMasterIndexMapper.selectByPatientId(clinicMaster.getPatientId());

                                    //统筹区属 转换
                                    String tcqh = "";
                                    if (siReadCardInfo.getTcqh().equals("320101")) {
                                        tcqh = "本市级";
                                    } else if (siReadCardInfo.getTcqh().equals("320102")) {
                                        tcqh = "玄武区";
                                    } else if (siReadCardInfo.getTcqh().equals("320104")) {
                                        tcqh = "秦淮区";
                                    } else if (siReadCardInfo.getTcqh().equals("320105")) {
                                        tcqh = "建邺区";
                                    } else if (siReadCardInfo.getTcqh().equals("320106")) {
                                        tcqh = "鼓楼区";
                                    } else if (siReadCardInfo.getTcqh().equals("320107")) {
                                        tcqh = "雨花台区";
                                    } else if (siReadCardInfo.getTcqh().equals("320108")) {
                                        tcqh = "化学工业园区";
                                    } else if (siReadCardInfo.getTcqh().equals("320111")) {
                                        tcqh = "浦口区";
                                    } else if (siReadCardInfo.getTcqh().equals("320113")) {
                                        tcqh = "栖霞区";
                                    } else if (siReadCardInfo.getTcqh().equals("320114")) {
                                        tcqh = "雨花台区";
                                    } else if (siReadCardInfo.getTcqh().equals("320115")) {
                                        tcqh = "江宁区";
                                    } else if (siReadCardInfo.getTcqh().equals("320116")) {
                                        tcqh = "六合区";
                                    } else if (siReadCardInfo.getTcqh().equals("320124")) {
                                        tcqh = "溧水区";
                                    } else if (siReadCardInfo.getTcqh().equals("320125")) {
                                        tcqh = "高淳区";
                                    } else if (siReadCardInfo.getTcqh().equals("320131")) {
                                        tcqh = "经济管委会";
                                    } else if (siReadCardInfo.getTcqh().equals("320132")) {
                                        tcqh = "高新区管委会";
                                    } else if (siReadCardInfo.getTcqh().equals("320133")) {
                                        tcqh = "化工园区管委会";
                                    } else {
                                        tcqh = "未知";
                                    }

                                    InsuranceAccountsNjjbKey insuranceAccountsNjjbKey = new InsuranceAccountsNjjbKey();
                                    insuranceAccountsNjjbKey.setInsuranceNo(siReadCardInfo.getTbr());
                                    insuranceAccountsNjjbKey.setPatientId(clinicMaster.getPatientId());
                                    insuranceAccountsNjjbKey.setAccountStatus((short) 0);
                                    InsuranceAccountsNjjb insuranceAccountsNjjb =
                                            insuranceAccountsNjjbMapper.selectByPrimaryKey(insuranceAccountsNjjbKey);

                                    InsuranceAccountsNjjb insuranceAccountsNjjb1 = new InsuranceAccountsNjjb();
                                    insuranceAccountsNjjb1.setInsuranceNo(siReadCardInfo.getTbr());
                                    insuranceAccountsNjjb1.setPatientId(pmi.getPatientId());
                                    insuranceAccountsNjjb1.setName(pmi.getName());
                                    insuranceAccountsNjjb1.setNamePhonetic(pmi.getNamePhonetic());
                                    insuranceAccountsNjjb1.setSex(pmi.getSex());
                                    insuranceAccountsNjjb1.setDateOfBirth(pmi.getDateOfBirth());
                                    // insuranceAccountsNjjb1.setStartDateOfWork();
                                    // insuranceAccountsNjjb1.setWorkingYears();
                                    insuranceAccountsNjjb1.setUnit(StringUtil.Utf_Iso(siReadCardInfo.getDwmc()));
                                    insuranceAccountsNjjb1.setIdentityClass(StringUtil.Utf_Iso("市医保"));
                                    insuranceAccountsNjjb1.setAccountBalance(new BigDecimal(siReadCardInfo.getAccountBalance()));
                                    insuranceAccountsNjjb1.setInsuranceLocation(StringUtil.Utf_Iso(tcqh));
                                    insuranceAccountsNjjb1.setInsuranceLocationCode(siReadCardInfo.getTcqh());
                                    insuranceAccountsNjjb1.setOperator("ZZJ");
                                    insuranceAccountsNjjb1.setAccountStatus((short) 0);
                                    if (insuranceAccountsNjjb != null) {

                                        insuranceAccountsNjjb1.setUpdateDateTime(new Timestamp(System.currentTimeMillis()));
                                        insuranceAccountsNjjbMapper.updateByPrimaryKeySelective(insuranceAccountsNjjb1);
                                    } else {
                                        insuranceAccountsNjjb1.setCreateDate(new Timestamp(System.currentTimeMillis()));
                                        insuranceAccountsNjjbMapper.insertSelective(insuranceAccountsNjjb1);
                                    }

                                    Njjb2100 njjb2100 = njjb2100Mapper.selectByPrimaryKey(siReadCardInfo.getTbr());

                                    Njjb2100 njjb21001 = new Njjb2100();
                                    njjb21001.setInsuranceNo(siReadCardInfo.getTbr());
                                    njjb21001.setReadName1(siReadCardInfo.getTbr());
                                    njjb21001.setReadName2(siReadCardInfo.getDwbh());
                                    njjb21001.setReadName3(StringUtil.Utf_Iso(siReadCardInfo.getDwmc()));
                                    njjb21001.setReadName4(siReadCardInfo.getIdNo());
                                    njjb21001.setReadName5(StringUtil.Utf_Iso(siReadCardInfo.getName()));
                                    njjb21001.setReadName6(siReadCardInfo.getSex());
                                    njjb21001.setReadName7(siReadCardInfo.getYllb());
                                    njjb21001.setReadName8(siReadCardInfo.getYdrybz());
                                    njjb21001.setReadName9(siReadCardInfo.getTcqh());
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
                                    if (njjb2100 != null) {
                                        njjb2100Mapper.updateByPrimaryKeySelective(njjb21001);
                                    } else {
                                        njjb2100Mapper.insertSelective(njjb21001);
                                    }

                                    //1. NJJB_OUTP_2210(收费登记表)
                                    NjjbOutp2210 njjbOutp2210 = new NjjbOutp2210();
                                    njjbOutp2210.setVisitDate(new Timestamp(DateToWeek.formatDate(visitDate, "yyyy-MM" +
                                            "-dd HH:mm:ss").getTime()));
                                    njjbOutp2210.setVisitNo(Integer.valueOf(outpOrdersT.getVisitNo()));
                                    njjbOutp2210.setRcptNo(rcptNo);
                                    njjbOutp2210.setSign((short) 1);
                                    njjbOutp2210.setCreated(new Timestamp(new Date().getTime()));

                                    njjbOutp2210.setInHeader1(siInDJParamInfo.getYwbh()); //业务编号（4位）
                                    njjbOutp2210.setInHeader2(siInDJParamInfo.getYljgbh());//医疗机构编号(8位)
                                    njjbOutp2210.setInHeader3(siInDJParamInfo.getCzybh());//操作员编号(8位)
                                    njjbOutp2210.setInHeader4(siInDJParamInfo.getYwzqh());//业务周期号(最大34位)
                                    njjbOutp2210.setInHeader5(siInDJParamInfo.getYyjylsh());//医院交易流水号(发送方交易流水号)(最大30位)
                                    njjbOutp2210.setInHeader6(siInDJParamInfo.getJrfs());//接入方式
                                    njjbOutp2210.setInHeader7(siInDJParamInfo.getDklx());//读卡类型

                                    njjbOutp2210.setInName1(siInDJParamInfo.getMzlsh());  //门诊/住院流水号
                                    njjbOutp2210.setInName2(StringUtil.Utf_Iso(siInDJParamInfo.getYllb())); //医疗类别
                                    njjbOutp2210.setInName3(siInDJParamInfo.getMzrysj());
                                    njjbOutp2210.setInName4(siInDJParamInfo.getZdjbbm());
                                    njjbOutp2210.setInName5(StringUtil.Utf_Iso(siInDJParamInfo.getBqmc()));
                                    njjbOutp2210.setInName6(siInDJParamInfo.getKsbm());
                                    njjbOutp2210.setInName7(siInDJParamInfo.getCwh());
                                    njjbOutp2210.setInName8(siInDJParamInfo.getYsbh());
                                    njjbOutp2210.setInName9(siInDJParamInfo.getJbr());
                                    njjbOutp2210.setInName10(siInDJParamInfo.getBrlxdh());
                                    njjbOutp2210.setInName11(siInDJParamInfo.getTbr());
                                    njjbOutp2210.setInName12(siInDJParamInfo.getZyh());
                                    njjbOutp2210.setInName13(siInDJParamInfo.getBabyTbr());
                                    njjbOutp2210.setInName14(siInDJParamInfo.getBy3());
                                    njjbOutp2210.setInName15(siInDJParamInfo.getBy4());
                                    njjbOutp2210.setInName16(siInDJParamInfo.getBy5());
                                    njjbOutp2210.setInName17(siInDJParamInfo.getBy6());

                                    njjbOutp2210.setOutFooter1(siReadCardInfo.getZxjylsh()); //中心交易流水号
                                    njjbOutp2210.setOutFooter2(siReadCardInfo.getYlzd1());
                                    njjbOutp2210.setOutFooter3(siReadCardInfo.getYlzd2());

                                    njjbOutp2210.setInsuranceNo(siReadCardInfo.getTbr());
                                    njjbOutp2210.setReadName1(siReadCardInfo.getTbr());
                                    njjbOutp2210.setReadName2(siReadCardInfo.getDwbh());
                                    njjbOutp2210.setReadName3(StringUtil.Utf_Iso(siReadCardInfo.getDwmc()));
                                    njjbOutp2210.setReadName4(siReadCardInfo.getIdNo());
                                    njjbOutp2210.setReadName5(StringUtil.Utf_Iso(siReadCardInfo.getName()));
                                    njjbOutp2210.setReadName6(siReadCardInfo.getSex());
                                    njjbOutp2210.setReadName7(siReadCardInfo.getYllb());
                                    njjbOutp2210.setReadName8(siReadCardInfo.getYdrybz());
                                    njjbOutp2210.setReadName9(siReadCardInfo.getTcqh());
                                    njjbOutp2210.setReadName10(siReadCardInfo.getAccountBalance());
                                    njjbOutp2210.setReadName11(siReadCardInfo.getInHosStatus());
                                    njjbOutp2210.setReadName12(siReadCardInfo.getBnzycs());
                                    njjbOutp2210.setReadName13(siReadCardInfo.getDyxsbz());
                                    njjbOutp2210.setReadName14(StringUtil.Utf_Iso(siReadCardInfo.getDybxsyy()));
                                    njjbOutp2210.setReadName15(StringUtil.Utf_Iso(siReadCardInfo.getAllBzm()));
                                    njjbOutp2210.setReadName16(siReadCardInfo.getYbmmzg());
                                    njjbOutp2210.setReadName17(StringUtil.Utf_Iso(siReadCardInfo.getYbMmbz()));
                                    njjbOutp2210.setReadName18(siReadCardInfo.getYbMjzg());
                                    njjbOutp2210.setReadName19(StringUtil.Utf_Iso(siReadCardInfo.getYbmjbz()));
                                    njjbOutp2210.setReadName20(siReadCardInfo.getYbmazg());
                                    njjbOutp2210.setReadName21(StringUtil.Utf_Iso(siReadCardInfo.getYbmabz()));
                                    njjbOutp2210.setReadName22(siReadCardInfo.getYbbgglsz());
                                    njjbOutp2210.setReadName23(StringUtil.Utf_Iso(siReadCardInfo.getYbbgglsbz()));
                                    njjbOutp2210.setReadName24(siReadCardInfo.getYbmzxybzg());
                                    njjbOutp2210.setReadName25(StringUtil.Utf_Iso(siReadCardInfo.getYbmzxybbz()));
                                    njjbOutp2210.setReadName26(siReadCardInfo.getYbmezg());
                                    njjbOutp2210.setReadName27(StringUtil.Utf_Iso(siReadCardInfo.getYbmebz()));
                                    njjbOutp2210.setReadName28(siReadCardInfo.getYbtyzg());
                                    njjbOutp2210.setReadName29(StringUtil.Utf_Iso(siReadCardInfo.getYbtybz()));
                                    njjbOutp2210.setReadName30(siReadCardInfo.getYbtymcbm());
                                    njjbOutp2210.setReadName31(siReadCardInfo.getJmmdzg());
                                    njjbOutp2210.setReadName32(siReadCardInfo.getJmmdbz());
                                    njjbOutp2210.setReadName33(siReadCardInfo.getJmmzyhbzg());
                                    njjbOutp2210.setReadName34(siReadCardInfo.getJmmzyhbbz());
                                    njjbOutp2210.setReadName35(siReadCardInfo.getJmtyzg());
                                    njjbOutp2210.setReadName36(siReadCardInfo.getJmtybz());
                                    njjbOutp2210.setReadName37(siReadCardInfo.getJmtymcbm());
                                    njjbOutp2210.setReadName38(siReadCardInfo.getNmgmdzg());
                                    njjbOutp2210.setReadName39(siReadCardInfo.getNmgmdbz());
                                    njjbOutp2210.setReadName40(siReadCardInfo.getNmgtyzg());
                                    njjbOutp2210.setReadName41(siReadCardInfo.getNmgtybz());
                                    njjbOutp2210.setReadName42(siReadCardInfo.getNmgtybzbm());
                                    njjbOutp2210.setReadName43(siReadCardInfo.getXszgmt());
                                    njjbOutp2210.setReadName44(siReadCardInfo.getSysplx());
                                    njjbOutp2210.setReadName45(siReadCardInfo.getFsyy());
                                    njjbOutp2210.setReadName46(siReadCardInfo.getMmsykbje());
                                    njjbOutp2210.setReadName47(siReadCardInfo.getMtfzzlsyje());
                                    njjbOutp2210.setReadName48(siReadCardInfo.getGsdyzg());
                                    njjbOutp2210.setReadName49(siReadCardInfo.getGsdybz());
                                    njjbOutp2210.setReadName50(siReadCardInfo.getGszdjl());
                                    njjbOutp2210.setReadName51(siReadCardInfo.getDksykbje());
                                    njjbOutp2210.setReadName52(siReadCardInfo.getMtsykbje());
                                    njjbOutp2210.setReadName53(siReadCardInfo.getYbjczg());

                                    njjbOutp2210Mapper.insertSelective(njjbOutp2210);

                                    //  NJJB_OUTP_2310(收费明细表)
                                    if (siPrenoOutList != null && siPrenoOutList.size() > 0) {
                                        for (int i = 0; i < siPrenoOutList.size(); i++) {
                                            SiPrenoOut siPrenoOut = siPrenoOutList.get(i);
                                            NjjbOutp2310 njjbOutp2310 = new NjjbOutp2310();
                                            njjbOutp2310.setVisitDate(new Timestamp(new Date().getTime()));
                                            njjbOutp2310.setVisitNo(Integer.valueOf(outpOrdersT.getVisitNo()));
                                            njjbOutp2310.setItemNo(i);
                                            njjbOutp2310.setRcptNo(rcptNo);
                                            njjbOutp2310.setSign((short) 1);
                                            njjbOutp2310.setCreated(DateToWeek.formatDate(Util.getCurrentDate("yyyy" +
                                                    "-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));

                                            njjbOutp2310.setInHeader1("2310");
                                            njjbOutp2310.setInHeader2(siSettlementInParamInfo.getYljgbh());//医疗机构编号(8位)
                                            njjbOutp2310.setInHeader3(siSettlementInParamInfo.getCzybh());//操作员编号(8位)
                                            njjbOutp2310.setInHeader4(siSettlementInParamInfo.getYwzqh());//业务周期号(最大34位)
                                            njjbOutp2310.setInHeader5(siSettlementInParamInfo.getYyjylsh());//医院交易流水号
                                            // (发送方交易流水号)(最大30位)
                                            njjbOutp2310.setInHeader6(siSettlementInParamInfo.getJrfs());//接入方式
                                            njjbOutp2310.setInHeader7(siSettlementInParamInfo.getDklx());//读卡类型

                                            njjbOutp2310.setInName1(siSettlementInParamInfo.getMzlsh()); //门诊/住院流水号
//                                            njjbOutp2310.setInName2(); //收费项目种类
                                            njjbOutp2310.setInName3(siPrenoOut.getCfh()); //处方号
                                            njjbOutp2310.setInName4(siPrenoOut.getCflsh()); //处方流水号
                                            njjbOutp2310.setInName5(siPrenoOut.getCfrq()); //处方日期
                                            njjbOutp2310.setInName6(siPrenoOut.getYysfxmzbm()); //医院收费项目自编码
//                                            njjbOutp2310.setInName7(); //单价
//                                            njjbOutp2310.setInName8();  //数量
//                                            njjbOutp2310.setInName9();  //金额
//                                            njjbOutp2310.setInName10();  //中药饮片副数
                                            njjbOutp2310.setInName11(siSettlementInParamInfo.getYsbm()); //医生编码
                                            njjbOutp2310.setInName12(siSettlementInParamInfo.getKsbm());  //科室编码
                                            njjbOutp2310.setInName13(siSettlementInParamInfo.getJbr());  //经办人

                                            njjbOutp2310.setInName14(processInName14(outpOrdersCostsList,
                                                    siPrenoOut.getYysfxmzbm())); //按最小计价单位收费标志
                                            njjbOutp2310.setInName15(siPrenoOut.getBy2());  //备用2
                                            njjbOutp2310.setInName16(siPrenoOut.getBy3());
                                            njjbOutp2310.setInName17(siPrenoOut.getBy4());
                                            njjbOutp2310.setInName18(siPrenoOut.getBy5());
                                            njjbOutp2310.setInName19(siPrenoOut.getBy6());

                                            njjbOutp2310.setOutFooter1(siPrenoOut.getZxjylsh()); //中心交易流水号
                                            njjbOutp2310.setOutFooter2(siPrenoOut.getYlzd1());
                                            njjbOutp2310.setOutFooter3(siPrenoOut.getYlzd2());

                                            njjbOutp2310.setOutName1(siPrenoOut.getCfh());//处方号
                                            njjbOutp2310.setOutName2(siPrenoOut.getCflsh());//处方流水号
                                            njjbOutp2310.setOutName3(siPrenoOut.getCfrq());//处方日期
                                            njjbOutp2310.setOutName4(siPrenoOut.getYysfxmzbm());//医院收费项目自编码
                                            njjbOutp2310.setOutName5(siPrenoOut.getJe());//金额
                                            njjbOutp2310.setOutName6(siPrenoOut.getZfje());//自付金额
                                            njjbOutp2310.setOutName7(siPrenoOut.getZlje());//自理金额
                                            njjbOutp2310.setOutName8(siPrenoOut.getZfbl());//自付比例
                                            njjbOutp2310.setOutName9(siPrenoOut.getZfsx());//支付上限
                                            njjbOutp2310.setOutName10(siPrenoOut.getSfxmdj());//收费项目等级
                                            njjbOutp2310.setOutName11(siPrenoOut.getSmxx());//说明信息
                                            njjbOutp2310.setOutName12(siPrenoOut.getBy2());//备用2
                                            njjbOutp2310.setOutName13(siPrenoOut.getBy3());
                                            njjbOutp2310.setOutName14(siPrenoOut.getBy4());
                                            njjbOutp2310.setOutName15(siPrenoOut.getBy5());
                                            njjbOutp2310.setOutName16(siPrenoOut.getBy6());

                                            njjbOutp2310Mapper.insertSelective(njjbOutp2310);

                                        }
                                    }
                                    // NJJB_OUTP_2420(收费试算表)
                                    NjjbOutp2420 njjbOutp2420 = new NjjbOutp2420();
                                    njjbOutp2420.setVisitDate(Timestamp.valueOf(visitDate));
                                    njjbOutp2420.setVisitNo(Integer.valueOf(outpOrdersT.getVisitNo()));
                                    njjbOutp2420.setRcptNo(rcptNo);
                                    njjbOutp2420.setInHeader1("2420");
                                    njjbOutp2420.setInHeader2(siSettlementInParamInfo.getYljgbh());//医疗机构编号(8位)
                                    njjbOutp2420.setInHeader3(siSettlementInParamInfo.getCzybh());//操作员编号(8位)
                                    njjbOutp2420.setInHeader4(siSettlementInParamInfo.getYwzqh());//业务周期号(最大34位)
                                    njjbOutp2420.setInHeader5(siSettlementInParamInfo.getYyjylsh());//医院交易流水号
                                    // (发送方交易流水号)(最大30位)
                                    njjbOutp2420.setInHeader6(siSettlementInParamInfo.getJrfs());//接入方式
                                    njjbOutp2420.setInHeader7(siSettlementInParamInfo.getDklx());//读卡类型

                                    njjbOutp2420.setInName1(siSettlementInParamInfo.getMzlsh()); //门诊/住院流水号
                                    njjbOutp2420.setInName2(siSettlementInParamInfo.getDjh()); //单据号
                                    njjbOutp2420.setInName3(siSettlementInParamInfo.getYllb()); //医疗类别
                                    njjbOutp2420.setInName4(siSettlementInParamInfo.getJsrq()); //结算日期
                                    njjbOutp2420.setInName5(siSettlementInParamInfo.getCyrq()); //出院日期
                                    njjbOutp2420.setInName6(siSettlementInParamInfo.getCyyy()); //出院原因
                                    njjbOutp2420.setInName7(siSettlementInParamInfo.getCyzdjbbm()); //出院诊断疾病编码
                                    njjbOutp2420.setInName8(siSettlementInParamInfo.getYjslb());  //月结算类别
                                    njjbOutp2420.setInName9(siSettlementInParamInfo.getZtjsbz());  //中途结算标志
                                    njjbOutp2420.setInName10(siSettlementInParamInfo.getJbr());  //经办人
                                    njjbOutp2420.setInName11(siSettlementInParamInfo.getFmrq()); //分娩日期
                                    njjbOutp2420.setInName12(siSettlementInParamInfo.getCc());  //产次
                                    njjbOutp2420.setInName13(siSettlementInParamInfo.getTes());  //胎儿数
                                    njjbOutp2420.setInName14(siSettlementInParamInfo.getTbr()); //社会保障卡号
                                    njjbOutp2420.setInName15(siSettlementInParamInfo.getZyyybh());  //转院医院编号
                                    njjbOutp2420.setInName16(siSettlementInParamInfo.getKsbm()); //科室编码
                                    njjbOutp2420.setInName17(siSettlementInParamInfo.getYsbm());//医生编码
                                    njjbOutp2420.setInName18(siSettlementInParamInfo.getGhfjs()); //备用4
                                    njjbOutp2420.setInName19(siSettlementInParamInfo.getZsrtbr());
                                    njjbOutp2420.setInName20(siSettlementInParamInfo.getShcs());

                                    njjbOutp2420.setOutFooter1(siSettlementOutParamInfo.getZxjylsh()); //中心交易流水号
                                    njjbOutp2420.setOutFooter2(siSettlementOutParamInfo.getYlzd1());
                                    njjbOutp2420.setOutFooter3(siSettlementOutParamInfo.getYlzd2());

                                    njjbOutp2420.setOutName1(siSettlementOutParamInfo.getYlfze());//本次医疗费总额
                                    njjbOutp2420.setOutName2(siSettlementOutParamInfo.getTczfje());//本次统筹支付金额
                                    njjbOutp2420.setOutName3(siSettlementOutParamInfo.getDbjzzf());//本次大病救助支付
                                    njjbOutp2420.setOutName4(siSettlementOutParamInfo.getDbbxzf());//本次大病保险支付
                                    njjbOutp2420.setOutName5(siSettlementOutParamInfo.getMzbzzf());//本次民政补助支付
                                    njjbOutp2420.setOutName6(siSettlementOutParamInfo.getZhzfze());//本次帐户支付总额
                                    njjbOutp2420.setOutName7(siSettlementOutParamInfo.getXjzfze());//本次现金支付总额
                                    njjbOutp2420.setOutName8(siSettlementOutParamInfo.getZhzfzf());//本次帐户支付自付
                                    njjbOutp2420.setOutName9(siSettlementOutParamInfo.getZhzfzl());//本次帐户支付自理
                                    njjbOutp2420.setOutName10(siSettlementOutParamInfo.getXjzfzf());//本次现金支付自付
                                    njjbOutp2420.setOutName11(siSettlementOutParamInfo.getXjzfzl());//本次现金支付自理
                                    njjbOutp2420.setOutName12(siSettlementOutParamInfo.getYbfwnfy());//医保范围内费用
                                    njjbOutp2420.setOutName13(siSettlementOutParamInfo.getZhxfhye());//帐户消费后余额
                                    njjbOutp2420.setOutName14(siSettlementOutParamInfo.getDbzbm());//单病种病种编码
                                    njjbOutp2420.setOutName15(siSettlementOutParamInfo.getSmxx());//说明信息
                                    njjbOutp2420.setOutName16(siSettlementOutParamInfo.getYfhj());//备用2
                                    njjbOutp2420.setOutName17(siSettlementOutParamInfo.getZlxmfhj());
                                    njjbOutp2420.setOutName18(siSettlementOutParamInfo.getBbzf());
                                    njjbOutp2420.setOutName19(siSettlementOutParamInfo.getYylb());
                                    njjbOutp2420.setOutName20(siSettlementOutParamInfo.getIsNo());

                                    njjbOutp2420Mapper.insertSelective(njjbOutp2420);

                                    //NJJB_OUTP_2410(收费结算表)
                                    NjjbOutp2410 njjbOutp2410 = new NjjbOutp2410();
                                    njjbOutp2410.setVisitDate(Timestamp.valueOf(visitDate));
                                    njjbOutp2410.setVisitNo(Integer.valueOf(outpOrdersT.getVisitNo()));
                                    njjbOutp2410.setRcptNo(rcptNo);
                                    njjbOutp2410.setSign((short) 1);
                                    njjbOutp2410.setCreated(DateToWeek.formatDate(Util.getCurrentDate("yyyy-MM-dd " +
                                            "HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));

                                    njjbOutp2410.setInHeader1(siSettlementInParamInfo.getYwbh());
                                    njjbOutp2410.setInHeader2(siSettlementInParamInfo.getYljgbh());//医疗机构编号(8位)
                                    njjbOutp2410.setInHeader3(siSettlementInParamInfo.getCzybh());//操作员编号(8位)
                                    njjbOutp2410.setInHeader4(siSettlementInParamInfo.getYwzqh());//业务周期号(最大34位)
                                    njjbOutp2410.setInHeader5(siSettlementInParamInfo.getYyjylsh());//医院交易流水号
                                    // (发送方交易流水号)(最大30位)
                                    njjbOutp2410.setInHeader6(siSettlementInParamInfo.getJrfs());//接入方式
                                    njjbOutp2410.setInHeader7(siSettlementInParamInfo.getDklx());//读卡类型

                                    njjbOutp2410.setInName1(siSettlementInParamInfo.getMzlsh()); //门诊/住院流水号
                                    njjbOutp2410.setInName2(siSettlementInParamInfo.getDjh()); //单据号
                                    njjbOutp2410.setInName3(siSettlementInParamInfo.getYllb()); //医疗类别
                                    njjbOutp2410.setInName4(siSettlementInParamInfo.getJsrq()); //结算日期
                                    njjbOutp2410.setInName5(siSettlementInParamInfo.getCyrq()); //出院日期
                                    njjbOutp2410.setInName6(siSettlementInParamInfo.getCyyy()); //出院原因
                                    njjbOutp2410.setInName7(siSettlementInParamInfo.getCyzdjbbm()); //出院诊断疾病编码
                                    njjbOutp2410.setInName8(siSettlementInParamInfo.getYjslb());  //月结算类别
                                    njjbOutp2410.setInName9(siSettlementInParamInfo.getZtjsbz());  //中途结算标志
                                    njjbOutp2410.setInName10(siSettlementInParamInfo.getJbr());  //经办人
                                    njjbOutp2410.setInName11(siSettlementInParamInfo.getFmrq()); //分娩日期
                                    njjbOutp2410.setInName12(siSettlementInParamInfo.getCc());  //产次
                                    njjbOutp2410.setInName13(siSettlementInParamInfo.getTes());  //胎儿数
                                    njjbOutp2410.setInName14(siSettlementInParamInfo.getTbr()); //社会保障卡号
                                    njjbOutp2410.setInName15(siSettlementInParamInfo.getZyyybh());  //转院医院编号
                                    njjbOutp2410.setInName16(siSettlementInParamInfo.getKsbm()); //科室编码
                                    njjbOutp2410.setInName17(siSettlementInParamInfo.getYsbm());//医生编码
                                    njjbOutp2410.setInName18(siSettlementInParamInfo.getGhfjs()); //备用4
                                    njjbOutp2410.setInName19(siSettlementInParamInfo.getZsrtbr());
                                    njjbOutp2410.setInName20(siSettlementInParamInfo.getShcs());

                                    njjbOutp2410.setOutFooter1(siSettlementOutParamInfo.getZxjylsh()); //中心交易流水号
                                    njjbOutp2410.setOutFooter2(siSettlementOutParamInfo.getYlzd1());
                                    njjbOutp2410.setOutFooter3(siSettlementOutParamInfo.getYlzd2());

                                    njjbOutp2410.setOutName1(siSettlementOutParamInfo.getYlfze());//本次医疗费总额
                                    njjbOutp2410.setOutName2(siSettlementOutParamInfo.getTczfje());//本次统筹支付金额
                                    njjbOutp2410.setOutName3(siSettlementOutParamInfo.getDbjzzf());//本次大病救助支付
                                    njjbOutp2410.setOutName4(siSettlementOutParamInfo.getDbbxzf());//本次大病保险支付
                                    njjbOutp2410.setOutName5(siSettlementOutParamInfo.getMzbzzf());//本次民政补助支付
                                    njjbOutp2410.setOutName6(siSettlementOutParamInfo.getZhzfze());//本次帐户支付总额
                                    njjbOutp2410.setOutName7(siSettlementOutParamInfo.getXjzfze());//本次现金支付总额
                                    njjbOutp2410.setOutName8(siSettlementOutParamInfo.getZhzfzf());//本次帐户支付自付
                                    njjbOutp2410.setOutName9(siSettlementOutParamInfo.getZhzfzl());//本次帐户支付自理
                                    njjbOutp2410.setOutName10(siSettlementOutParamInfo.getXjzfzf());//本次现金支付自付
                                    njjbOutp2410.setOutName11(siSettlementOutParamInfo.getXjzfzl());//本次现金支付自理
                                    njjbOutp2410.setOutName12(siSettlementOutParamInfo.getYbfwnfy());//医保范围内费用
                                    njjbOutp2410.setOutName13(siSettlementOutParamInfo.getZhxfhye());//帐户消费后余额
                                    njjbOutp2410.setOutName14(siSettlementOutParamInfo.getDbzbm());//单病种病种编码
                                    njjbOutp2410.setOutName15(siSettlementOutParamInfo.getSmxx());//说明信息
                                    njjbOutp2410.setOutName16(siSettlementOutParamInfo.getYfhj());//备用2
                                    njjbOutp2410.setOutName17(siSettlementOutParamInfo.getZlxmfhj());
                                    njjbOutp2410.setOutName18(siSettlementOutParamInfo.getBbzf());
                                    njjbOutp2410.setOutName19(siSettlementOutParamInfo.getYylb());
                                    njjbOutp2410.setOutName20(siSettlementOutParamInfo.getIsNo());

                                    njjbOutp2410Mapper.insertSelective(njjbOutp2410);

                                } else {//老医保
                                    //6.1 医保门诊就诊情况
                                    InsuOutpClinicMaster iocm = new InsuOutpClinicMaster();
                                    iocm.setInsuCardNo(inCardNo);// 医保卡号
                                    iocm.setVisitDate(Util.getCurrentDate("yyyyMMddHHmmss")); //就诊日期
                                    iocm.setPatientId(clinicMaster.getPatientId());// 病人标识
                                    iocm.setPatName(clinicMaster.getName());//病人姓名
                                    List<InsuDoctorDict> idd =
                                            insuDoctorDictMapper.selectByDoctorName(outpOrdersT.getDoctor());
                                    if (idd != null && idd.size() > 0) {
                                        iocm.setOrderedByDoctorCode(idd.get(0).getDoctCode());//开单医生代码
                                    } else {
                                        iocm.setOrderedByDoctorCode(outpOrdersT.getDoctor());//开单医生代码
                                    }
                                    iocm.setOrderedByDoctor(outpOrdersT.getDoctor()); //开单医生
                                    iocm.setDiagnosisCode("20");//病种编码
                                    iocm.setDiagnosisName(StringUtil.Utf_Iso("其他"));//病种名称
                                    InsuVsHospitalDept ivhd =
                                            insuVsHospitalDeptMapper.selectByPrimaryByDeptCode(outpOrdersT.getOrderedBy());
                                    iocm.setVisitDeptInsuCode(ivhd.getInsuDeptCode());//就诊科室医保代码
                                    iocm.setVisitDeptInsuName(ivhd.getInsuDeptName());//就诊科室医保名称
                                    iocm.setOperatorNo("ZZJ");//操作员编码
                                    iocm.setRcptNo(rcptNo);//收据号
                                    iocm.setInsuType(StringUtil.Utf_Iso(cardNoType));//医保类型
                                    //iocm.setRefundedRcptNo("");//退费收据号
                                    iocm.setDeptCode(outpOrdersT.getOrderedBy());//医院科室码
                                    DeptDict deptDict = deptDictMapper.selectByPrimaryKey(outpOrdersT.getOrderedBy());
                                    iocm.setDeptName(deptDict.getDeptName());//医院科室名
                                    insuOutpClinicMasterMapper.insert(iocm);

                                    //6.2 医保门诊结算记录

                                    InsuOutpSettleRecord iosr = new InsuOutpSettleRecord();
                                    iosr.setInsuCardNo(inCardNo); //医保卡号
                                    iosr.setInsuVisitDate(new Timestamp(DateToWeek.formatDate(Util.getCurrentDate(
                                            "yyyy-MM-dd"), "yyyy-MM-dd").getTime()));//费用发生日期
                                    iosr.setOutpFee(new BigDecimal(payAmt)); //门诊费用
                                    iosr.setDrugTotal(new BigDecimal(drugTotal));//药费合计
                                    iosr.setMedicalTotal(new BigDecimal(medicalTotal)); //治疗项目合计
                                    iosr.setPaymentSelf(new BigDecimal(paymentSelf)); //自理费用
                                    iosr.setInsuRangeTotal(new BigDecimal(insuRangeTotal)); //医保范围费用
                                    iosr.setPayFromAccount(new BigDecimal(payFromAccount)); //个人账户支付
                                    iosr.setPayFromFund(new BigDecimal(payFromFund));// 统筹支付
                                    iosr.setLargerDiagnosisPayment(new BigDecimal(largerDiagnosisPayment)); //大病支付
                                    iosr.setPayFromInsured(new BigDecimal(payFromInsured));//个人支付
                                    iosr.setAccountInitialAmount(new BigDecimal(accountInitialAmount));//期初个人账户
                                    iosr.setAccountEndAmount(new BigDecimal(accountEndAmount));//期末个人账号
                                    iosr.setInsuOperatorNo(insuOperatorNo);//操作员医保编码
                                    iosr.setRcptNo(rcptNo);//收据号
                                    iosr.setInsuRcptNo(insuRcptNo);//医保收据号
//                                iosr.setRefundedRcptNo("");//退费收据号
//                                iosr.setPatName("");//社会保障号
//                                iosr.setIdentityClass("");//人员性质
//                                iosr.setPayFromCash();//现金支付
//                                iosr.setChargeClass(""); //费用类别
//                                iosr.setInsuranceClass("");//险种
//                                iosr.setPayFromAllowance("");//补助支付
                                    insuOutpSettleRecordMapper.insert(iosr);
                                }
                            }
                            // 7. 银联支付
                            if ("9".equals(payMethod)) {
                                BankTradeLog bankTradeLog = new BankTradeLog();
                                bankTradeLog.setType(StringUtil.Utf_Iso("门诊收费"));
                                bankTradeLog.setRcptNo(rcptNo);
                                bankTradeLog.setTraDate(Util.getCurrentDate("yyyyMMdd"));
                                bankTradeLog.setTradeId(rcptNo);
                                bankTradeLog.setTempRcptNo(rcptNo);
                                bankTradeLog.setPatientId(clinicMaster.getPatientId());
                                bankTradeLog.setBankCard(yhkh);
                                bankTradeLog.setTraNo(pzh);
                                bankTradeLog.setTraFinalNo(zdh);
                                bankTradeLog.setTraTotal(new BigDecimal(je));
                                bankTradeLog.setTraStatus(1 + "");
                                bankTradeLog.setTraPcNo(pch);
                                bankTradeLog.setTraTime(Util.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
                                bankTradeLog.setMerchantNo(shh);
//                                bankTradeLog.setNote();
//                                bankTradeLog.setTimes();
                                bankTradeLog.setUserId(czy);
                                bankTradeLog.setAcctNo(1 + "");
//                                bankTradeLog.setReturnTimes();
//                                bankTradeLog.setReturnMoneyLimit();
//                                bankTradeLog.setReturnType();
                                bankTradeLog.setOprAppNameHis(1 + "");
                                bankTradeLog.setAcctFlagHis(new BigDecimal(1));
                                bankTradeLog.setOperTypeHis(StringUtil.Utf_Iso("银行卡"));
                                bankTradeLog.setRcptFlagHis(new BigDecimal(1));
//                                bankTradeLog.setBankNo();
//                                bankTradeLog.setTraAuthNo();
//                                bankTradeLog.setSettleDate();
//                                bankTradeLog.setLrcReturn();
//                                bankTradeLog.setReturnRcptNo();
                                bankTradeLog.setTraReferNo(ckh);
                                bankTradeLogMapper.insertSelective(bankTradeLog);
                            }

                        }
                        String deptLocation = deptDictMapper.selectDeptLocation(rcptNo).getDeptLocation();
                        head.addElement("code").setText("0");
                        head.addElement("desc").setText("[支付确认成功]");
                        Element body = rootR.addElement("body");
                        body.addElement("fph").setText(rcptNo);
                        if (deptLocation != null) {
                            body.addElement("guideInfo").setText(StringUtil.Iso_GBK(deptLocation));
                        } else {
                            body.addElement("guideInfo").setText("");
                        }
                        logger.info(doc.asXML());
                        result = doc.asXML();

                    } else {
                        result = getErrorlMsg("[该单据金额不对或流水号为空！！！]");
                    }
                } else {
                    head.addElement("code").setText("0");
                    head.addElement("desc").setText("[收费类型不能为空]");
                    result = doc.asXML();
                }
            } else {

                head.addElement("code").setText("0");
                head.addElement("desc").setText("[该单据已经支付完毕]");
                logger.info(doc.asXML());
                result = doc.asXML();
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause().getMessage());
        }
    }

    /**
     * 获取价格列表
     *
     * @param xmlParam
     * @return
     */
    @Override
    public String getPriceListInfo(String xmlParam) {
        logger.info("[获取价格列表  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String feePy = reroot.element("body").element("feePy").getText();//检索码
            String feeId = reroot.element("body").element("feeId").getText();// 0 药品 1 非药品
            if (feePy != null && feePy.length() > 0 && feeId != null && feeId.length() > 0) {
                List<CurrentPriceList> cpls = null;
                if ("0".equals(feeId)) {
                    cpls = currentPriceListMapper.selectByInputCodeForDrug("%" + feePy + "%");
                } else {
                    cpls = currentPriceListMapper.selectByInputCode("%" + feePy + "%");
                }
                if (cpls != null && cpls.size() > 0) {
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element rootElement = doc.addElement("response");
                    Element headElement = rootElement.addElement("head");
                    headElement.addElement("code").setText("0");
                    headElement.addElement("desc").setText("查询成功");
                    Element bodyElement = rootElement.addElement("body");
                    for (int i = 0; i < cpls.size(); i++) {
                        CurrentPriceList cpl = cpls.get(i);
                        Element list = bodyElement.addElement("list");
                        list.addElement("mFeeId").setText(cpl.getItemClass());
                        list.addElement("outItemCode").setText(StringUtil.Iso_GBK(cpl.getItemCode()));
                        list.addElement("outItemName").setText(StringUtil.Iso_GBK(cpl.getItemName()));
                        list.addElement("outItemSpec").setText(StringUtil.Iso_GBK(cpl.getItemSpec()));
                        list.addElement("outUnits").setText(StringUtil.Iso_GBK(cpl.getUnits()));
                        list.addElement("outPrice").setText(cpl.getPrice() + "");
                    }
                    return doc.asXML();
                } else {
                    return getErrorlMsg("未查询到信息！！！");
                }
            } else {
                return getErrorlMsg("输入参数有误！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * 挂号对账
     *
     * @param xmlParam
     * @return
     */
    public String registrationRecord(String xmlParam) {
        logger.info("[挂号对账  入参 :]" + xmlParam);
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlParam);
            Element reroot = document.getRootElement();
            String bgDate = reroot.element("body").element("BgDate").getText();//yyyy-MM-dd
            if (bgDate != null && bgDate.length() > 0 && bgDate != null && bgDate.length() > 0) {
                List<PayOrderRecord> payOrderRecordList =
                        payOrderRecordMapper.selectByRecordTime(DateToWeek.formatDate(bgDate, "yyyy-MM-dd"));
                if (payOrderRecordList != null && payOrderRecordList.size() > 0) {
                    Document doc = DocumentHelper.createDocument();
                    doc.setXMLEncoding("GBK");
                    Element rootElement = doc.addElement("response");
                    Element headElement = rootElement.addElement("head");
                    headElement.addElement("code").setText("0");
                    headElement.addElement("desc").setText("查询成功");
                    Element bodyElement = rootElement.addElement("body");
                    for (int i = 0; i < payOrderRecordList.size(); i++) {
                        PayOrderRecord payOrderRecord = payOrderRecordList.get(i);
                        ClinicMasterKey clinicMasterKey = new ClinicMasterKey();
                        clinicMasterKey.setVisitDate(payOrderRecord.getVisitDate());
                        clinicMasterKey.setVisitNo(payOrderRecord.getVisitNo());
                        ClinicMaster clinicMaster = clinicMasterMapper.selectByPrimaryKey(clinicMasterKey);
                        String time = DateToWeek.formatDateString(payOrderRecord.getRecordTime(), "yyyy-MM-dd " +
                                "hh24:mi:ss");
                        if (clinicMaster != null) {
                            if ("0".equals(clinicMaster.getRegistrationStatus())) { //退费的
                                Element list = bodyElement.addElement("item");
                                list.addElement("ID").setText("");
                                list.addElement("RCPT_NO").setText(clinicMaster.getRcptNo());
                                list.addElement("INVOICE_ID").setText("");
                                list.addElement("ORDER_ID").setText(payOrderRecord.getTradeNo());
                                list.addElement("ORDER_DATE").setText(time.substring(1, 10));
                                list.addElement("ORDER_TIME").setText(time.substring(12, 19));
                                list.addElement("PAY_NAME").setText(StringUtil.Iso_GBK("挂号费用"));
                                list.addElement("COST").setText(clinicMaster.getClinicFee() + "");
                                list.addElement("STATUS").setText(StringUtil.Iso_GBK("收费"));
                                list.addElement("PATIENT_ID").setText(clinicMaster.getPatientId());
                                list.addElement("PATIENT_NAME").setText(StringUtil.Iso_GBK(clinicMaster.getName()));
                                list.addElement("PAY_TYPE").setText(StringUtil.Iso_GBK("微信"));
                                list.addElement("SYSTEM_ID").setText(StringUtil.Iso_GBK("微信"));
                                list.addElement("SYSTEM_TYPE").setText(StringUtil.Iso_GBK("挂号"));
                                list.addElement("DISTRICT").setText(StringUtil.Iso_GBK("中国人民解放军81医院"));
                                list.addElement("PAY_ACCOUNT").setText("");
                                list.addElement("OPERATE_ID").setText(clinicMaster.getOperator());
                                list.addElement("DEVICE_ID").setText("");
                                list.addElement("REMARKS").setText("");

                                list = bodyElement.addElement("item");
                                list.addElement("ID").setText("");
                                list.addElement("RCPT_NO").setText(clinicMaster.getRcptNo());
                                list.addElement("INVOICE_ID").setText("");
                                list.addElement("ORDER_ID").setText(payOrderRecord.getTradeNo());
                                list.addElement("ORDER_DATE").setText(time.substring(1, 10));
                                list.addElement("ORDER_TIME").setText(time.substring(12, 19));
                                list.addElement("PAY_NAME").setText(StringUtil.Iso_GBK("挂号费用"));
                                list.addElement("COST").setText(clinicMaster.getClinicFee() + "");
                                list.addElement("STATUS").setText(StringUtil.Iso_GBK("退费"));
                                list.addElement("PATIENT_ID").setText(clinicMaster.getPatientId());
                                list.addElement("PATIENT_NAME").setText(StringUtil.Iso_GBK(clinicMaster.getName()));
                                list.addElement("PAY_TYPE").setText(StringUtil.Iso_GBK("微信"));
                                list.addElement("SYSTEM_ID").setText(StringUtil.Iso_GBK("微信"));
                                list.addElement("SYSTEM_TYPE").setText(StringUtil.Iso_GBK("挂号"));
                                list.addElement("DISTRICT").setText(StringUtil.Iso_GBK("中国人民解放军81医院"));
                                list.addElement("PAY_ACCOUNT").setText("");
                                list.addElement("OPERATE_ID").setText(clinicMaster.getOperator());
                                list.addElement("DEVICE_ID").setText("");
                                list.addElement("REMARKS").setText("");

                            } else {
                                Element list = bodyElement.addElement("item");
                                list.addElement("ID").setText("");
                                list.addElement("RCPT_NO").setText(clinicMaster.getRcptNo());
                                list.addElement("INVOICE_ID").setText("");
                                list.addElement("ORDER_ID").setText(payOrderRecord.getTradeNo());
                                list.addElement("ORDER_DATE").setText(time.substring(1, 10));
                                list.addElement("ORDER_TIME").setText(time.substring(12, 19));
                                list.addElement("PAY_NAME").setText(StringUtil.Iso_GBK("挂号费用"));
                                list.addElement("COST").setText(clinicMaster.getClinicFee() + "");
                                list.addElement("STATUS").setText(StringUtil.Iso_GBK("收费"));
                                list.addElement("PATIENT_ID").setText(clinicMaster.getPatientId());
                                list.addElement("PATIENT_NAME").setText(StringUtil.Iso_GBK(clinicMaster.getName()));
                                list.addElement("PAY_TYPE").setText(StringUtil.Iso_GBK("微信"));
                                list.addElement("SYSTEM_ID").setText(StringUtil.Iso_GBK("微信"));
                                list.addElement("SYSTEM_TYPE").setText(StringUtil.Iso_GBK("挂号"));
                                list.addElement("DISTRICT").setText(StringUtil.Iso_GBK("中国人民解放军81医院"));
                                list.addElement("PAY_ACCOUNT").setText("");
                                list.addElement("OPERATE_ID").setText(clinicMaster.getOperator());
                                list.addElement("DEVICE_ID").setText("");
                                list.addElement("REMARKS").setText("");
                            }
                        }
                    }
                    return doc.asXML();
                } else {
                    return getErrorlMsg("未查询到信息！！！");
                }
            } else {
                return getErrorlMsg("输入参数有误！！！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return this.getErrorlMsg("数据出错");
        }
    }

    /**
     * String转Date
     *
     * @param
     * @param formater
     * @return
     */
    public static Date formatDate(String dateString, String formater) {
        SimpleDateFormat format = new SimpleDateFormat(formater);
        Date date1 = null;
        try {
            date1 = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    private String getTimeDescEng(String timeDesc) {
        if (timeDesc.equals("上午")) {
            return "am";
        } else if (timeDesc.equals("下午")) {
            return "pm";
        } else if (timeDesc.equals("白天")) {
            return "day";
        } else {
            return "all";
        }
    }

    private String getErrorlMsg(String desc) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("response");
        Element header = root.addElement("head");
        Element data = root.addElement("data");
        header.addElement("code").setText("1");
        header.addElement("desc").setText(desc);
        return document.asXML();
    }

    private String truncateStr(String str, int maxLength) {
        String tmpStr = StringUtil.Utf_Iso(str);
        if (tmpStr.toCharArray().length > maxLength)
            return new String(tmpStr.toCharArray(), 0, maxLength);
        return tmpStr;
    }

    private String processInName14(List<OutpOrdersCosts> outpOrdersCostsList, String itemCode) {
        if (outpOrdersCostsList == null || !outpOrdersCostsList.isEmpty() || StringUtils.isEmpty(itemCode))
            return "1";
        for (OutpOrdersCosts cost : outpOrdersCostsList) {
            if (itemCode.equals(cost.getItemCode())) {
                return processZxjjbs(cost.getItemSpec());
            }
        }
        return "1";
    }

    /**
     * 最小计价单位收费标识,0:大包装 1:小包装(默认)
     *
     * @param spec 规格
     * @return 最小计价单位收费标识, 0:大包装 1:小包装
     */
    private String processZxjjbs(String spec) {
        if (!StringUtils.isEmpty(spec)) {
            spec = StringUtil.Iso_GBK(spec);
            if (!StringUtils.isEmpty(spec) && spec.contains("*"))
                return "0";
            return "1";
        }
        return "1";
    }
}
