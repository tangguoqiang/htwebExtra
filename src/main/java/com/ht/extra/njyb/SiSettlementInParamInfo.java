package com.ht.extra.njyb;

/**
 * 
	 * 类描述   医保结算入参（用于与his交互）
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月14日 上午11:09:10
 */
public class SiSettlementInParamInfo extends SiInParamBase {
	private String mzlsh;// 门诊/住院流水号 非空 同登记时的门诊/住院流 水号
	private String djh;// 单据号  预结算传空，结算时必传 且不能为 0
	private String yllb;// 医疗类别非空 二级代码
	private String jsrq;//结算日期 非空 YYYYMMDDHH24MISS
	private String cyrq;//出院日期 非空  YYYYMMDDHH24MISS
	private String cyyy;//出院原因 二级代码（住院必传
	private String cyzdjbbm;//出院诊断疾病编码 VARCHAR2(50) 必须为中心病种编码，具 体规则见交易说明
	private String yjslb;//月结算类别 二级代码
	private String ztjsbz;//中途结算标志 二级代码
	private String jbr;//经办人 非空 医药机构操作员姓名
	private String fmrq;//分娩日期YYYYMMDDHH24MISS，医疗 类别是生育住院，出院诊 断疾病编码是分娩类，必 填
	private String cc;//产次 填写数字，1 表示一胎，2 表示二胎，以此类推；医疗类别是生育 住院，出院诊断疾病编码 是分娩类，必填
	private String tes;//胎儿数  填写数字，1 表示一个胎 儿，2 表示二个胎儿，以此类推；医疗类别是生育住院，出院诊断疾病编码 是分娩类，必填
	private String tbr;//社会保障卡号  非空
	private String zyyybh;//转院医院编号  出院原因是 03 转院时，此 字段必填
	private String ksbm;//科室编码  非空
	private String ysbm;// 医生编码 见交易说明
	private String ghfjs;//是否为挂号费结算 二级代码，传空值时代表0
	private String zsrtbr;//准生儿社会保障卡号 详见首页的修改记录
	private String shcs;//手术是否成功标志 详见首页的修改记录
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
	public String getYllb() {
		return yllb;
	}
	public void setYllb(String yllb) {
		this.yllb = yllb;
	}
	public String getJsrq() {
		return jsrq;
	}
	public void setJsrq(String jsrq) {
		this.jsrq = jsrq;
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
	public String getCyzdjbbm() {
		return cyzdjbbm;
	}
	public void setCyzdjbbm(String cyzdjbbm) {
		this.cyzdjbbm = cyzdjbbm;
	}
	public String getYjslb() {
		return yjslb;
	}
	public void setYjslb(String yjslb) {
		this.yjslb = yjslb;
	}
	public String getZtjsbz() {
		return ztjsbz;
	}
	public void setZtjsbz(String ztjsbz) {
		this.ztjsbz = ztjsbz;
	}
	public String getJbr() {
		return jbr;
	}
	public void setJbr(String jbr) {
		this.jbr = jbr;
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
	public String getTes() {
		return tes;
	}
	public void setTes(String tes) {
		this.tes = tes;
	}
	public String getTbr() {
		return tbr;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getZyyybh() {
		return zyyybh;
	}
	public void setZyyybh(String zyyybh) {
		this.zyyybh = zyyybh;
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
	public String getGhfjs() {
		return ghfjs;
	}
	public void setGhfjs(String ghfjs) {
		this.ghfjs = ghfjs;
	}
	public String getZsrtbr() {
		return zsrtbr;
	}
	public void setZsrtbr(String zsrtbr) {
		this.zsrtbr = zsrtbr;
	}
	public String getShcs() {
		return shcs;
	}
	public void setShcs(String shcs) {
		this.shcs = shcs;
	}
	
	
	/**
	 * 
	 * 本交易对应二级代码
		序号 类别名称 代码值 代码名称
		南京金保二期医保接口手册 P-31/44
		1 中途结算标志 0 否
		2 中途结算标志 1 是
		3 单病种病种编码 D001a-1 腹股沟疝修补术（开放式单侧）
		4 单病种病种编码 D001a-2 腹股沟疝修补术（开放式双侧）
		5 单病种病种编码 D001b-1 腹股沟疝修补术（腹腔镜单侧）
		6 单病种病种编码 D001b-2 腹股沟疝修补术（腹腔镜双侧）
		7 单病种病种编码 D002a 阑尾炎切除术（开放式）
		8 单病种病种编码 D002b 阑尾炎切除术（腹腔镜）
		9 单病种病种编码 D003a 甲状腺良性肿瘤切除术（开放式）
		10 单病种病种编码 D003b 甲状腺良性肿瘤切除术（腹腔镜）
		11 单病种病种编码 D004b 经腹腔镜胆囊切除术（腹腔镜）
		12 单病种病种编码 D005-1 白内障摘除术（单侧）
		13 单病种病种编码 D005-2 白内障摘除术（双侧）
		14 单病种病种编码 D006-1 冠状动脉支架置入术（一个支架）
		15 单病种病种编码 D006-2 冠状动脉支架置入术（二个支架）
		16 单病种病种编码 D006-3 冠状动脉支架置入术（三个支架）
		17 单病种病种编码 D007 冠状动脉造影术
		18 单病种病种编码 D008 慢径、旁道消融术
		19 单病种病种编码 D009 髋关节置换(单髋)
		20 单病种病种编码 D010 膝关节置换术
		21 单病种病种编码 D011 良性前列腺增生切除术
		22 单病种病种编码 D012a 子宫良性肿瘤切除术（非腔镜）
		23 单病种病种编码 D012b 子宫良性肿瘤切除术（腔镜）
		24 单病种病种编码 D012a 子宫良性肿瘤切除术（非腔镜）
		25 单病种病种编码 D012b 子宫良性肿瘤切除术（腔镜）
		26 单病种病种编码 D013b-1 卵巢良性肿瘤（腔镜单侧）
		27 单病种病种编码 D013b-2 卵巢良性肿瘤（腔镜双侧）
		28 出院原因 01 治愈
		29 出院原因 02 死亡
		30 出院原因 03 转院
		31 出院原因 04 其它
		32 出院原因 05 好转
		33 月结算类别 03 床日护理
		34 月结算类别 04 床日非护理
		35 是否为挂号费结算 0 否
		36 是否为挂号费结算 1 是
	 */
	
	
}
