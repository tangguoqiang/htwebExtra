package com.ht.extra.njyb;

/**
 * 
	 * 类描述   医保登记入参
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月18日 下午2:54:42
 */
public class SiInDJParamInfo extends SiInParamBase {
	private String mzlsh;// 门诊/住院流水号
	private String yllb;//医疗类别 
	private String mzrysj;//门诊/住院入院时间 VARCHAR2(14) 非空 YYYYMMDDHH24MISS
	private String zdjbbm;//诊断疾病编码 除普通门诊、急诊外必传
	private String bqmc;//病区名称
	private String ksbm;//科室编码
	private String cwh;//床位号
	private String ysbh;//医生编码  除普通门诊、急诊外必传
	private String jbr;//经办人  非空 医药机构操作员姓名
	private String brlxdh;//病人联系电话 
	private String tbr;//社会保障卡号 VARHCAR2(20) 非空
	private String zyh;//住院号 VARHCAR2(50)
	private String babyTbr;//准生儿社会保障卡号 VARHCAR2(100) 当准新生儿入院时需要传入，“准生儿社会保障卡号”是办理准新	生儿新参保时提供给办理人的，院端需要前台手工录入
	private String by3;// 备用 3 VARHCAR2(100) 当前为空，后续扩展用
	private String by4;//备用 4 VARHCAR2(200) 当前为空，后续扩展用
	private String by5;//备用 5 VARHCAR2(200) 当前为空，后续扩展用
	private String by6;//备用 6 VARHCAR2(200) 当前为空，后续扩展用
	public String getMzlsh() {
		return mzlsh;
	}
	public void setMzlsh(String mzlsh) {
		this.mzlsh = mzlsh;
	}
	public String getYllb() {
		return yllb;
	}
	public void setYllb(String yllb) {
		this.yllb = yllb;
	}
	public String getMzrysj() {
		return mzrysj;
	}
	public void setMzrysj(String mzrysj) {
		this.mzrysj = mzrysj;
	}
	public String getZdjbbm() {
		return zdjbbm;
	}
	public void setZdjbbm(String zdjbbm) {
		this.zdjbbm = zdjbbm;
	}
	public String getBqmc() {
		return bqmc;
	}
	public void setBqmc(String bqmc) {
		this.bqmc = bqmc;
	}
	public String getKsbm() {
		return ksbm;
	}
	public void setKsbm(String ksbm) {
		this.ksbm = ksbm;
	}
	public String getCwh() {
		return cwh;
	}
	public void setCwh(String cwh) {
		this.cwh = cwh;
	}
	public String getYsbh() {
		return ysbh;
	}
	public void setYsbh(String ysbh) {
		this.ysbh = ysbh;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
	}
	public String getBrlxdh() {
		return brlxdh;
	}
	public void setBrlxdh(String brlxdh) {
		this.brlxdh = brlxdh;
	}
	public String getTbr() {
		return tbr;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getZyh() {
		return zyh;
	}
	public void setZyh(String zyh) {
		this.zyh = zyh;
	}
	public String getBabyTbr() {
		return babyTbr;
	}
	public void setBabyTbr(String babyTbr) {
		this.babyTbr = babyTbr;
	}
	public String getBy3() {
		return by3;
	}
	public void setBy3(String by3) {
		this.by3 = by3;
	}
	public String getBy4() {
		return by4;
	}
	public void setBy4(String by4) {
		this.by4 = by4;
	}
	public String getBy5() {
		return by5;
	}
	public void setBy5(String by5) {
		this.by5 = by5;
	}
	public String getBy6() {
		return by6;
	}
	public void setBy6(String by6) {
		this.by6 = by6;
	}
	
	
	/**
	 * 1 医疗类别 11 普通门诊 门诊可开展
		2
		医疗类别 13 门诊统筹 院端不需要上传，中心自动
		判断，在结算出参内返回
		3 医疗类别 14 门诊精神病 门诊可开展
		4 医疗类别 15 门诊艾滋病 门诊可开展
		5 医疗类别 16 门诊慢性病 门诊可开展,药店可开展
		6 医疗类别 171 门特 门诊可开展,药店可开展
		7 医疗类别 172 门诊血友病 门诊可开展
		11 医疗类别 18 门诊大病 门诊可开展
		12 医疗类别 191 家庭病床 门诊可开展
		13 医疗类别 21 普通住院 住院可开展
		14 医疗类别 41 药店购药 药店可开展
		15 医疗类别 42 特药 药店可开展
		16 医疗类别 51 职工计划生育 门诊可开展
		17 医疗类别 52 生育住院 住院可开展
		18
		医疗类别 53 产前检查 门诊可开展（居民医保生育
		产前检查使用）
		19 医疗类别 61 工伤门诊职业病 门诊可开展
		20 医疗类别 62 工伤门诊康复治疗 门诊可开展
		21 医疗类别 63 工伤门诊肢体伤残 门诊可开展
		22 医疗类别 64 工伤住院职业病 住院可开展
		23 医疗类别 65 工伤住院康复治疗 住院可开展
		24 医疗类别 66 工伤住院肢体伤残 住院可开展
		25 医疗类别 81 退休体检 暂不开展
		26 医疗类别 82 离休体检 暂不开展
		27 医疗类别 83 妇女体检 暂不开展
		28 医疗类别 84 农民工体检 暂不开展
		29 医疗类别 85 工伤体检 暂不开展
		30 医疗类别 86 急诊 门诊可开展
	 */
	
}
