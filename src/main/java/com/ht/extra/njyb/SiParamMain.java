package com.ht.extra.njyb;

import java.util.List;

/**
 * @description 医保参数主项数据
 * @author xdz
 * @date 2017年6月5日 下午9:46:51
 */
public class SiParamMain {
	/**患   者  信  息**/
	private String patientIndex;//个人编号（医保中心患者唯一索引）
	private String cardNo;//医保卡号
	private String patientPhone;//患者联系方式
	
	private String jzsj;//就诊时间（门诊/住院 入院时间）
	private String jsrq;//结算日期
	private String diagnosisCode;//诊断疾病编码
	
	/**患者住院信息**/
	private String zyh;//住院号
	private String bqmc;//病区名称
	private String bedNo;//床位号
	private String cyrq;//出院日期
	private String cyyy;//出院原因
	private String fmrq;//分娩日期
	private String cc;//产次
	private String outDiagnosisCode;//出院诊断编码
	private String babyNo;//胎儿数
	private String zyyybh;//转院医院编码
	private String sscgbz;//手术是否成功标识
	
	/**患者门诊信息**/
	private String mzlsh;//门诊流水号
	
	/**医保相关数据**/
	private String djh;//单据号
	private String jbr;//经办人
	private String ksbm;//科室编码
	private String ysbm;//医生编码
	private String medicalType;//医疗类别 
	private String monthlyType;//月结算类别
	private String ztjsbz;//中途结算标识

	/**患者医保数据子项集合**/
	private List<SiParamSub> siParamSubList;//医保参数明细
	
	private String reservedMainOne;//预留字段一
	private String reservedMainTwo;//预留字段二
	private String reservedMainThree;//预留字段三

	public String getPatientIndex() {
		return patientIndex;
	}

	public void setPatientIndex(String patientIndex) {
		this.patientIndex = patientIndex;
	}

	
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getJzsj() {
		return jzsj;
	}

	public void setJzsj(String jzsj) {
		this.jzsj = jzsj;
	}

	public String getJsrq() {
		return jsrq;
	}

	public void setJsrq(String jsrq) {
		this.jsrq = jsrq;
	}

	public String getDiagnosisCode() {
		return diagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		this.diagnosisCode = diagnosisCode;
	}

	public String getZyh() {
		return zyh;
	}

	public void setZyh(String zyh) {
		this.zyh = zyh;
	}

	public String getBqmc() {
		return bqmc;
	}

	public void setBqmc(String bqmc) {
		this.bqmc = bqmc;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getCyrq() {
		return cyrq;
	}

	public void setCyrq(String cyrq) {
		this.cyrq = cyrq;
	}

	public String getCyyy() {
		return cyyy;
	}

	public void setCyyy(String cyyy) {
		this.cyyy = cyyy;
	}

	public String getFmrq() {
		return fmrq;
	}

	public void setFmrq(String fmrq) {
		this.fmrq = fmrq;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getOutDiagnosisCode() {
		return outDiagnosisCode;
	}

	public void setOutDiagnosisCode(String outDiagnosisCode) {
		this.outDiagnosisCode = outDiagnosisCode;
	}

	public String getBabyNo() {
		return babyNo;
	}

	public void setBabyNo(String babyNo) {
		this.babyNo = babyNo;
	}

	public String getZyyybh() {
		return zyyybh;
	}

	public void setZyyybh(String zyyybh) {
		this.zyyybh = zyyybh;
	}

	public String getSscgbz() {
		return sscgbz;
	}

	public void setSscgbz(String sscgbz) {
		this.sscgbz = sscgbz;
	}

	public String getMzlsh() {
		return mzlsh;
	}

	public void setMzlsh(String mzlsh) {
		this.mzlsh = mzlsh;
	}

	public String getDjh() {
		return djh;
	}

	public void setDjh(String djh) {
		this.djh = djh;
	}

	public String getJbr() {
		return jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	public String getKsbm() {
		return ksbm;
	}

	public void setKsbm(String ksbm) {
		this.ksbm = ksbm;
	}

	public String getYsbm() {
		return ysbm;
	}

	public void setYsbm(String ysbm) {
		this.ysbm = ysbm;
	}

	public String getMedicalType() {
		return medicalType;
	}

	public void setMedicalType(String medicalType) {
		this.medicalType = medicalType;
	}

	public String getMonthlyType() {
		return monthlyType;
	}

	public void setMonthlyType(String monthlyType) {
		this.monthlyType = monthlyType;
	}

	public String getZtjsbz() {
		return ztjsbz;
	}

	public void setZtjsbz(String ztjsbz) {
		this.ztjsbz = ztjsbz;
	}

	public List<SiParamSub> getSiParamSubList() {
		return siParamSubList;
	}

	public void setSiParamSubList(List<SiParamSub> siParamSubList) {
		this.siParamSubList = siParamSubList;
	}

	public String getReservedMainOne() {
		return reservedMainOne;
	}

	public void setReservedMainOne(String reservedMainOne) {
		this.reservedMainOne = reservedMainOne;
	}

	public String getReservedMainTwo() {
		return reservedMainTwo;
	}

	public void setReservedMainTwo(String reservedMainTwo) {
		this.reservedMainTwo = reservedMainTwo;
	}

	public String getReservedMainThree() {
		return reservedMainThree;
	}

	public void setReservedMainThree(String reservedMainThree) {
		this.reservedMainThree = reservedMainThree;
	}
}

