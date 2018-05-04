package com.ht.extra.njyb;

/**
 * 
	 * 类描述    医保读卡反参（用于与his交互）
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月14日 上午11:09:10
 */
public class SiReadCardInfo extends SiOutParamBase {

	private String tbr;//社会保障卡号
	private String dwbh;//单位编号 
	private String dwmc;//单位名称
	private String idNo;//身份证号
	private String name;//姓名
	private String sex;//性别
	private String yllb;//医疗人员类别    二级代码
	private String ydrybz;// 异地人员标志  二级代码
	private String tcqh;//统筹区号  二级代码
	private String accountBalance;//  当前帐户余额  2 位小数
	private String inHosStatus;//在院状态   二级代码
	private String bnzycs;// 本年住院次数 
	private String dyxsbz;//遇享受标志  二级代码
	private String dybxsyy;//待遇不享受原因 
	private String allBzm;//病种登记情况   定点在本医院的病种编码,当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
	private String ybmmzg;// 医保门慢资格    二级代码  1-享受，0-不享受
	private String ybMmbz;//医保门慢病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
	private String ybMjzg;//医保门精资格  二级代码	1-享受，0-不享受
	private String ybmjbz;// 医保门精病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
	private String ybmazg;//医保门艾资格  二级代码 1-享受，0-不享受
	private String ybmabz;//医保门艾病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
	private String ybbgglsz;//医保丙肝干扰素资格1-享受，0-不享受
	private String ybbgglsbz;// 医保丙肝干扰素病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
	private String ybmzxybzg;//医保门诊血友病资格  二级代码1-享受，0-不享受
	private String ybmzxybbz;//医保门诊血友病病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
	private String ybmezg;//医保门特资格二级代码 1-享受，0-不享受
	private String ybmebz;//医保门特病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
	private String ybtyzg;//医保特药资格  二级代码  1-享受，0-不享受
	private String ybtybz;//医保特药病种  当存在多个病种编码时,每个病种编码间以英文逗号
	private String ybtymcbm;// 医保特药名称编码当存在多个编码时,每个编码间以英文逗号分隔，不以
	private String jmmdzg;//居民门大资格   二级代码 1-享受，0-不享受
	private String jmmdbz;//居民门大病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
	private String jmmzyhbzg;// 居民门诊血友病资格 二级代码 1-享受，0-不享受
	private String jmmzyhbbz;//居民门诊血友病病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
	private String jmtyzg;//居民特药资格 二级代码1-享受，0-不享受
	private String jmtybz;// 居民特药病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
	private String jmtymcbm;//居民特药名称编码  当存在多个编码时,每个编码间以英文逗号分隔，不以英文逗号开始，不以英文逗
	private String nmgmdzg;// 农民工门大资格  二级代码1-享受，0-不享受
	private String nmgmdbz;//农民工门大病种   当存在多个病种编码时,每  个病种编码间以英文逗号
	private String nmgtyzg;//农民工特药资格    二级代码  1-享受，0-不享受
	private String nmgtybz;//农民工特药病种   当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
	private String nmgtybzbm;//农民工特药名称编码  当存在多个编码时,每个编码间以英文逗号分隔，不以
	private String xszgmt;//能否享受职工门诊统筹 只判断职工人群，二级代码 1-享受，0-不享受
	private String sysplx;//生育审批类型 二级代码
	private String fsyy;//封锁原因 VARCHAR2(3) 二级代码
	private String mmsykbje;//门慢剩余可报金额 VARHCAR2(16) 2 位小数
	private String mtfzzlsyje;//门特辅助治疗剩余可报金额 2 位小数
	private String gsdyzg;//工伤待遇资格
	private String gsdybz;//工伤待遇病种
	private String gszdjl;//工伤诊断结论
	private String dksykbje;//大卡剩余可报金额
	private String mtsykbje;//门统剩余可报金额
	private String ybjczg;//医保家床资格
	/** 二级代码
	 * 序号 类别名称 代码值 代码名称
			1 性别 1 男
			2 性别 2 女
			3 医疗人员类别 11 在职
			4 医疗人员类别 21 退休
			5 医疗人员类别 22 退职
			6 医疗人员类别 23 70 岁以上退休
			7 医疗人员类别 24 退休待审核
			8 医疗人员类别 31 离休
			9 医疗人员类别 41 建国前老工人
			10 医疗人员类别 42 二乙伤残军人
			南京金保二期医保接口手册
			P
			-22
			/44
			11 医疗人员类别 51 普通居民 12 医疗人员类别 52 儿童学生
			13 医疗人员类别 53 大学生
			14 医疗人员类别 62 建筑业农民
			工
			15 在院状态
			0 不在院
			16 在院状态
			1 在院
			17 待遇享受标志
			1 正常享受
			18 待遇享受标志
			2
			不享受待遇
			19 统筹区号 320101 市本级 20 统筹区号 320102 玄武区 21 统筹区号 320104 秦淮区 22 统筹区号 320105 建邺区 23 统筹区号 320106 鼓楼区 24 统筹区号 320108 化学工业园区
			25 统筹区号 320111 浦口区
			26 统筹区号 320113 栖霞区
			27 统筹区号 320114 雨花台区
			28 统筹区号 320115 江宁区
			29 统筹区号 320116 六合区
			30 统筹区号 320124 溧水区
			31 统筹区号 320125 高淳区
			32 统筹区号 320131 经济管委会
			33 统筹区号 320132 高新区管委会
			34 统筹区号 320133 化工园区管委会 35 异地人员标志 0 否 36 异地人员标志 1 是
			37 待遇不享受原因 02 欠费
			38 待遇不享受原因 03 退休待批
			39 待遇不享受原因 04 等待期
			40 待遇不享受原因 05 退保
			41 待遇不享受原因 99 其他特殊情况
			42 生育审批类型 25 居民生育 43 生育审批类型 28 计生手术 44 生育审批类型 29 妊娠前期 45 生育审批类型 30 妊娠后期 46 生育审批类型 31 分娩
			47 封锁原因 11 单位全封锁
			48 封锁原因 12 单位封统筹
			49 封锁原因 13 个人全封锁
			50 封锁原因 14 个人封统筹
	 */
	
	public String getTbr() {
		return tbr;
	}
	public String getGsdyzg() {
		return gsdyzg;
	}
	public void setGsdyzg(String gsdyzg) {
		this.gsdyzg = gsdyzg;
	}
	public String getGsdybz() {
		return gsdybz;
	}
	public void setGsdybz(String gsdybz) {
		this.gsdybz = gsdybz;
	}
	public String getGszdjl() {
		return gszdjl;
	}
	public void setGszdjl(String gszdjl) {
		this.gszdjl = gszdjl;
	}
	public String getDksykbje() {
		return dksykbje;
	}
	public void setDksykbje(String dksykbje) {
		this.dksykbje = dksykbje;
	}
	public String getMtsykbje() {
		return mtsykbje;
	}
	public void setMtsykbje(String mtsykbje) {
		this.mtsykbje = mtsykbje;
	}
	public String getYbjczg() {
		return ybjczg;
	}
	public void setYbjczg(String ybjczg) {
		this.ybjczg = ybjczg;
	}
	public void setTbr(String tbr) {
		this.tbr = tbr;
	}
	public String getDwbh() {
		return dwbh;
	}
	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getYllb() {
		return yllb;
	}
	public void setYllb(String yllb) {
		this.yllb = yllb;
	}
	public String getYdrybz() {
		return ydrybz;
	}
	public void setYdrybz(String ydrybz) {
		this.ydrybz = ydrybz;
	}
	public String getTcqh() {
		return tcqh;
	}
	public void setTcqh(String tcqh) {
		this.tcqh = tcqh;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getInHosStatus() {
		return inHosStatus;
	}
	public void setInHosStatus(String inHosStatus) {
		this.inHosStatus = inHosStatus;
	}
	public String getBnzycs() {
		return bnzycs;
	}
	public void setBnzycs(String bnzycs) {
		this.bnzycs = bnzycs;
	}
	public String getDyxsbz() {
		return dyxsbz;
	}
	public void setDyxsbz(String dyxsbz) {
		this.dyxsbz = dyxsbz;
	}
	public String getDybxsyy() {
		return dybxsyy;
	}
	public void setDybxsyy(String dybxsyy) {
		this.dybxsyy = dybxsyy;
	}
	public String getAllBzm() {
		return allBzm;
	}
	public void setAllBzm(String allBzm) {
		this.allBzm = allBzm;
	}
	public String getYbmmzg() {
		return ybmmzg;
	}
	public void setYbmmzg(String ybmmzg) {
		this.ybmmzg = ybmmzg;
	}
	public String getYbMmbz() {
		return ybMmbz;
	}
	public void setYbMmbz(String ybMmbz) {
		this.ybMmbz = ybMmbz;
	}
	public String getYbMjzg() {
		return ybMjzg;
	}
	public void setYbMjzg(String ybMjzg) {
		this.ybMjzg = ybMjzg;
	}
	public String getYbmjbz() {
		return ybmjbz;
	}
	public void setYbmjbz(String ybmjbz) {
		this.ybmjbz = ybmjbz;
	}
	public String getYbmazg() {
		return ybmazg;
	}
	public void setYbmazg(String ybmazg) {
		this.ybmazg = ybmazg;
	}
	public String getYbmabz() {
		return ybmabz;
	}
	public void setYbmabz(String ybmabz) {
		this.ybmabz = ybmabz;
	}
	public String getYbbgglsz() {
		return ybbgglsz;
	}
	public void setYbbgglsz(String ybbgglsz) {
		this.ybbgglsz = ybbgglsz;
	}
	public String getYbbgglsbz() {
		return ybbgglsbz;
	}
	public void setYbbgglsbz(String ybbgglsbz) {
		this.ybbgglsbz = ybbgglsbz;
	}
	public String getYbmzxybzg() {
		return ybmzxybzg;
	}
	public void setYbmzxybzg(String ybmzxybzg) {
		this.ybmzxybzg = ybmzxybzg;
	}
	public String getYbmzxybbz() {
		return ybmzxybbz;
	}
	public void setYbmzxybbz(String ybmzxybbz) {
		this.ybmzxybbz = ybmzxybbz;
	}
	public String getYbmezg() {
		return ybmezg;
	}
	public void setYbmezg(String ybmezg) {
		this.ybmezg = ybmezg;
	}
	public String getYbmebz() {
		return ybmebz;
	}
	public void setYbmebz(String ybmebz) {
		this.ybmebz = ybmebz;
	}
	public String getYbtyzg() {
		return ybtyzg;
	}
	public void setYbtyzg(String ybtyzg) {
		this.ybtyzg = ybtyzg;
	}
	public String getYbtybz() {
		return ybtybz;
	}
	public void setYbtybz(String ybtybz) {
		this.ybtybz = ybtybz;
	}
	public String getYbtymcbm() {
		return ybtymcbm;
	}
	public void setYbtymcbm(String ybtymcbm) {
		this.ybtymcbm = ybtymcbm;
	}
	public String getJmmdzg() {
		return jmmdzg;
	}
	public void setJmmdzg(String jmmdzg) {
		this.jmmdzg = jmmdzg;
	}
	public String getJmmdbz() {
		return jmmdbz;
	}
	public void setJmmdbz(String jmmdbz) {
		this.jmmdbz = jmmdbz;
	}
	public String getJmmzyhbzg() {
		return jmmzyhbzg;
	}
	public void setJmmzyhbzg(String jmmzyhbzg) {
		this.jmmzyhbzg = jmmzyhbzg;
	}
	public String getJmmzyhbbz() {
		return jmmzyhbbz;
	}
	public void setJmmzyhbbz(String jmmzyhbbz) {
		this.jmmzyhbbz = jmmzyhbbz;
	}
	public String getJmtyzg() {
		return jmtyzg;
	}
	public void setJmtyzg(String jmtyzg) {
		this.jmtyzg = jmtyzg;
	}
	public String getJmtybz() {
		return jmtybz;
	}
	public void setJmtybz(String jmtybz) {
		this.jmtybz = jmtybz;
	}
	public String getJmtymcbm() {
		return jmtymcbm;
	}
	public void setJmtymcbm(String jmtymcbm) {
		this.jmtymcbm = jmtymcbm;
	}
	public String getNmgmdzg() {
		return nmgmdzg;
	}
	public void setNmgmdzg(String nmgmdzg) {
		this.nmgmdzg = nmgmdzg;
	}
	public String getNmgmdbz() {
		return nmgmdbz;
	}
	public void setNmgmdbz(String nmgmdbz) {
		this.nmgmdbz = nmgmdbz;
	}
	public String getNmgtyzg() {
		return nmgtyzg;
	}
	public void setNmgtyzg(String nmgtyzg) {
		this.nmgtyzg = nmgtyzg;
	}
	public String getNmgtybz() {
		return nmgtybz;
	}
	public void setNmgtybz(String nmgtybz) {
		this.nmgtybz = nmgtybz;
	}
	public String getNmgtybzbm() {
		return nmgtybzbm;
	}
	public void setNmgtybzbm(String nmgtybzbm) {
		this.nmgtybzbm = nmgtybzbm;
	}
	public String getXszgmt() {
		return xszgmt;
	}
	public void setXszgmt(String xszgmt) {
		this.xszgmt = xszgmt;
	}
	public String getSysplx() {
		return sysplx;
	}
	public void setSysplx(String sysplx) {
		this.sysplx = sysplx;
	}
	public String getFsyy() {
		return fsyy;
	}
	public void setFsyy(String fsyy) {
		this.fsyy = fsyy;
	}
	public String getMmsykbje() {
		return mmsykbje;
	}
	public void setMmsykbje(String mmsykbje) {
		this.mmsykbje = mmsykbje;
	}
	public String getMtfzzlsyje() {
		return mtfzzlsyje;
	}
	public void setMtfzzlsyje(String mtfzzlsyje) {
		this.mtfzzlsyje = mtfzzlsyje;
	}
	
}
