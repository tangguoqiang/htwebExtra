package com.ht.extra.util;

import com.ht.extra.njyb.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 
	 * 类描述  解析医保相关参数类
 	 * @version  1.0
	 * @author  jianggen
	 * 医保的前端入参格式为：读卡反参☆结算入参☆结算出参☆明细上传（挂号暂不需要，如需要则让前端传入即可）☆登记入参
	 * @version  2017年7月14日 下午1:09:27
 */

public class SiClassUtil {
	
	public static final String PARAM1="☆";//用于多个操作的分割
	public static final String PARAM2="\\^";//医保报文的分割符号
	public static final String PARAM3="\\|";//参数分割符号
	public static final String PARAM4="\\$";//明细上传分割符号
	
	
	public static void main(String[] args) {
//		System.out.println(getSiInfoContent("0042-20170718150159-108^1881177780|10093789|江苏健康无忧网络科技有限公司|320111198609044034|陈华|1|11|0|320132|105.09|0|0|1||6101|1|6101|0||0||0||0||0||0|||0||0||0|||0||0|||0|||2000|0|^^☆2410^H0042^Y0149^0042-000Y0149-20170712800164^20170718025127-000H0042-1007^1^0^GH770|ZZ40060118|11|20170718145118|20170718145118||6101|||ZZ||||1881177780||6005||1|||^☆0042-20170718150208-092^15.0|12.0|0.0|0.0|0.0|3.0|0.0|0.0|3.0|0.0|0.0|12.0|102.09|6101||0.0|15.0|0.00|16||^^☆☆2210^H0042^Y0149^0042-000Y0149-20170712800164^20170718025121-000H0042-5744^1^0^GH770|11|20170718145118|6101||6005|||ZZ||1881177780|||||||^"));
		SiReadCardInfo siReadCardInfo = getSiReadCardInfo("0007-20180509094309-664^0000209419|00015200|南京市新亚商场|320103193003070542|曾建英|2|22|0|320101|139.0|0|1|1|||0||0||0||0||0||0||0|||0||0||0|||0||0|||1|||0|0|0|||0|3000.0|0|^^");
		System.out.println(siReadCardInfo.getYllb());
	}

	public static SiInfoContent getSiInfoContent(String siInfoContent){
		SiInfoContent siInfoContentModel=new SiInfoContent();
		String[] paramStr=siInfoContent.split(PARAM1,-1);
		siInfoContentModel.setSiReadCardInfo(getSiReadCardInfo(paramStr[0]));
		siInfoContentModel.setSiSettlementInParamInfo(getSiSettlementInParamInfo(paramStr[1]));
		siInfoContentModel.setSiSettlementOutParamInfo(getSiSettlementOutParamInfo(paramStr[2]));
		//上传明细暂时只有缴费需要
		siInfoContentModel.setSiPrenoOutList(getSiPrenoOutList(paramStr[3]));
		siInfoContentModel.setSiInDJParamInfo(getSiInDjList(paramStr[4]));
		return siInfoContentModel;
		
	}

	
	/**
	 * 
	  * 方法描述：获取医保结算反参
	  * @param  
	  * @return  出参格式: outputData char* 中心交易流水号^输出参数^预留字段 1^预留字段 2 
	  * @version 1.0
	  * @author jianggen
	  * 2017年7月14日 下午1:23:51
	 */
	public static SiSettlementOutParamInfo getSiSettlementOutParamInfo(
			String str) {
		SiSettlementOutParamInfo model =new SiSettlementOutParamInfo();
		String[] strArray=str.split(PARAM2,-1);
		model.setZxjylsh(strArray[0]);
		model.setYlzd1(strArray[2]);
		model.setYlzd2(strArray[3]);
		String[] strOutParamArray=strArray[1].split(PARAM3, -1);
		model.setYlfze(strOutParamArray[0]);//本次医疗费总额  2 位小数
		model.setTczfje(strOutParamArray[1]);//本次统筹支付金额  2 位小数
		model.setDbjzzf(strOutParamArray[2]);//本次大病救助支付  2 位小数
		model.setDbbxzf(strOutParamArray[3]);//本次大病保险支付  2 位小数
		model.setMzbzzf(strOutParamArray[4]);//本次民政补助支付  2 位小数
		model.setZhzfze(strOutParamArray[5]);//本次帐户支付总额  2 位小数
		model.setXjzfze(strOutParamArray[6]);//本次现金支付总额  2 位小数
		model.setZhzfzf(strOutParamArray[7]);//本次帐户支付自付  2 位小数
		model.setZhzfzl(strOutParamArray[8]);//本次帐户支付自理  2 位小数
		model.setXjzfzf(strOutParamArray[9]);//本次现金支付自付  2 位小数
		model.setXjzfzl(strOutParamArray[10]);//本次现金支付自理  2 位小数
		model.setYbfwnfy(strOutParamArray[11]);//医保范围内费用  2 位小数
		model.setZhxfhye(strOutParamArray[12]);//帐户消费后余额  2 位小数
		model.setDbzbm(strOutParamArray[13]);//单病种病种编码  二级代码
		model.setSmxx(strOutParamArray[14]);//说明信息
		model.setYfhj(strOutParamArray[15]);//药费合计  2 位小数
		model.setZlxmfhj(strOutParamArray[16]);//诊疗项目费合计  2 位小数
		model.setBbzf(strOutParamArray[17]);//补保支付  2 位小数
		model.setYylb(strOutParamArray[18]);//医疗类别  二级代码
		model.setIsNo(strOutParamArray[19]);//备用 6  当前为空，后续扩展用
		//System.out.println("获取医保结算反参："+JSON.toJSON(strOutParamArray));
		return model;
	}

	/**
	 * 
	  * 方法描述：获取医保结算入参
	  * @param 
	  * @return 入参格式: inputData
			业务编号^医疗机构编号^操作员编号^业务周期号^医院交易流水号^接入方式^读卡类型^入参^ 
	  * @version 1.0
	  * @author jianggen
	  * 2017年7月14日 下午1:24:32
	 */
	public static SiSettlementInParamInfo getSiSettlementInParamInfo(
			String str) {
		SiSettlementInParamInfo model =new SiSettlementInParamInfo();
		String[] strArray=str.split(PARAM2,-1);
		model.setYwbh(strArray[0]);
		model.setYljgbh(strArray[1]);
		model.setCzybh(strArray[2]);
		model.setYwzqh(strArray[3]);
		model.setYyjylsh(strArray[4]);
		model.setJrfs(strArray[5]);
		model.setDklx(strArray[6]);
		String[] strOutParamArray=strArray[7].split(PARAM3, -1);
		model.setMzlsh(strOutParamArray[0]);// 门诊/住院流水号 非空 同登记时的门诊/住院流 水号
		model.setDjh(strOutParamArray[1]);// 单据号  预结算传空，结算时必传 且不能为 0
		model.setYllb(strOutParamArray[2]);// 医疗类别非空 二级代码
		model.setJsrq(strOutParamArray[3]);//结算日期 非空 YYYYMMDDHH24MISS
		model.setCyrq(strOutParamArray[4]);//出院日期 非空  YYYYMMDDHH24MISS
		model.setCyyy(strOutParamArray[5]);//出院原因 二级代码（住院必传
		model.setCyzdjbbm(strOutParamArray[6]);//出院诊断疾病编码 VARCHAR2(50) 必须为中心病种编码，具 体规则见交易说明
		model.setYjslb(strOutParamArray[7]);//月结算类别 二级代码
		model.setZtjsbz(strOutParamArray[8]);//中途结算标志 二级代码
		model.setJbr(strOutParamArray[9]);//经办人 非空 医药机构操作员姓名
		model.setFmrq(strOutParamArray[10]);//分娩日期YYYYMMDDHH24MISS，医疗 类别是生育住院，出院诊 断疾病编码是分娩类，必 填
		model.setCc(strOutParamArray[11]);//产次 填写数字，1 表示一胎，2 表示二胎，以此类推；医疗类别是生育 住院，出院诊断疾病编码 是分娩类，必填
		model.setTes(strOutParamArray[12]);//胎儿数  填写数字，1 表示一个胎 儿，2 表示二个胎儿，以此类推；医疗类别是生育住院，出院诊断疾病编码 是分娩类，必填
		model.setTbr(strOutParamArray[13]);//社会保障卡号  非空
		model.setZyyybh(strOutParamArray[14]);//转院医院编号  出院原因是 03 转院时，此 字段必填
		model.setKsbm(strOutParamArray[15]);//科室编码  非空
		model.setYsbm(strOutParamArray[16]);// 医生编码 见交易说明
		model.setGhfjs(strOutParamArray[17]);//是否为挂号费结算 二级代码，传空值时代表0
		model.setZsrtbr(strOutParamArray[18]);//准生儿社会保障卡号 详见首页的修改记录
		model.setShcs(strOutParamArray[19]);//手术是否成功标志 详见首页的修改记录
		//System.out.println("获取医保结算入参："+JSON.toJSON(model));
		return model;
	}

	/**
	 * 
	  * 方法描述：获取医保卡读卡反参 
	  * @param 
	  * @return  出参格式: outputData char* 中心交易流水号^输出参数^预留字段 1^预留字段 2 
	  * @version 1.0
	  * @author jianggen
	  * 2017年7月14日 下午1:25:09
	 */
	public static SiReadCardInfo getSiReadCardInfo(String str) {
		SiReadCardInfo model=new SiReadCardInfo();
		String[] strArray=str.split(PARAM2,-1);
		model.setZxjylsh(strArray[0]);
		model.setYlzd1(strArray[2]);
		model.setYlzd2(strArray[3]);
		String[] strOutParamArray=strArray[1].split(PARAM3, -1);
		model.setTbr(strOutParamArray[0]);//社会保障卡号
		model.setDwbh(strOutParamArray[1]);//单位编号 
		model.setDwmc(strOutParamArray[2]);//单位名称
		model.setIdNo(strOutParamArray[3]);//身份证号
		model.setName(strOutParamArray[4]);//姓名
		model.setSex(strOutParamArray[5]);//性别
		model.setYllb(strOutParamArray[6]);//医疗人员类别    二级代码
		model.setYdrybz(strOutParamArray[7]);// 异地人员标志  二级代码
		model.setTcqh(strOutParamArray[8]);//统筹区号  二级代码
		model.setAccountBalance(strOutParamArray[9]);//  当前帐户余额  2 位小数
		model.setInHosStatus(strOutParamArray[10]);//在院状态   二级代码
		model.setBnzycs(strOutParamArray[11]);// 本年住院次数 
		model.setDyxsbz(strOutParamArray[12]);//遇享受标志  二级代码
		model.setDybxsyy(strOutParamArray[13]);//待遇不享受原因 
		model.setAllBzm(strOutParamArray[14]);//病种登记情况   定点在本医院的病种编码,当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
		model.setYbmmzg(strOutParamArray[15]);// 医保门慢资格    二级代码  1-享受，0-不享受
		model.setYbMmbz(strOutParamArray[16]);//医保门慢病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
		model.setYbMjzg(strOutParamArray[17]);//医保门精资格  二级代码	1-享受，0-不享受
		model.setYbmjbz(strOutParamArray[18]);// 医保门精病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
		model.setYbmazg(strOutParamArray[19]);//医保门艾资格  二级代码 1-享受，0-不享受
		model.setYbmabz(strOutParamArray[20]);//医保门艾病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
		model.setYbbgglsz(strOutParamArray[21]);//医保丙肝干扰素资格1-享受，0-不享受
		model.setYbbgglsbz(strOutParamArray[22]);// 医保丙肝干扰素病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
		model.setYbmzxybzg(strOutParamArray[23]);//医保门诊血友病资格  二级代码1-享受，0-不享受
		model.setYbmzxybbz(strOutParamArray[24]);//医保门诊血友病病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
		model.setYbmezg(strOutParamArray[25]);//医保门特资格二级代码 1-享受，0-不享受
		model.setYbmebz(strOutParamArray[26]);//医保门特病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
		model.setYbtyzg(strOutParamArray[27]);//医保特药资格  二级代码  1-享受，0-不享受
		model.setYbtybz(strOutParamArray[28]);//医保特药病种  当存在多个病种编码时,每个病种编码间以英文逗号
		model.setYbtymcbm(strOutParamArray[29]);// 医保特药名称编码当存在多个编码时,每个编码间以英文逗号分隔，不以
		model.setJmmdzg(strOutParamArray[30]);//居民门大资格   二级代码 1-享受，0-不享受
		model.setJmmdbz(strOutParamArray[31]);//居民门大病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
		model.setJmmzyhbzg(strOutParamArray[32]);// 居民门诊血友病资格 二级代码 1-享受，0-不享受
		model.setJmmzyhbbz(strOutParamArray[33]);//居民门诊血友病病种 当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
		model.setJmtyzg(strOutParamArray[34]);//居民特药资格 二级代码1-享受，0-不享受
		model.setJmtybz(strOutParamArray[35]);// 居民特药病种  当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，不以英文逗号结尾
		model.setJmtymcbm(strOutParamArray[36]);//居民特药名称编码  当存在多个编码时,每个编码间以英文逗号分隔，不以英文逗号开始，不以英文逗
		model.setNmgmdzg(strOutParamArray[37]);// 农民工门大资格  二级代码1-享受，0-不享受
		model.setNmgmdbz(strOutParamArray[38]);//农民工门大病种   当存在多个病种编码时,每  个病种编码间以英文逗号
		model.setNmgtyzg(strOutParamArray[39]);//农民工特药资格    二级代码  1-享受，0-不享受
		model.setNmgtybz(strOutParamArray[40]);//农民工特药病种   当存在多个病种编码时,每个病种编码间以英文逗号分隔，不以英文逗号开始，
		model.setNmgtybzbm(strOutParamArray[41]);//农民工特药名称编码  当存在多个编码时,每个编码间以英文逗号分隔，不以
		model.setXszgmt(strOutParamArray[42]);//能否享受职工门诊统筹 只判断职工人群，二级代码 1-享受，0-不享受
		model.setSysplx(strOutParamArray[43]);//生育审批类型 二级代码
		model.setFsyy(strOutParamArray[44]);//封锁原因 VARCHAR2(3) 二级代码
		model.setMmsykbje(strOutParamArray[45]);//门慢剩余可报金额 VARHCAR2(16) 2 位小数
		model.setMtfzzlsyje(strOutParamArray[46]);//门特辅助治疗剩余可报金额 2 位小数
		model.setGsdyzg(strOutParamArray[47]);//工伤待遇资格
		model.setGsdybz(strOutParamArray[48]);//工伤待遇病种
		model.setGszdjl(strOutParamArray[49]);//工伤诊断结论
		model.setDksykbje(strOutParamArray[50]);//大卡剩余可报金额
		model.setMtsykbje(strOutParamArray[51]);//门统剩余可报金额
		model.setYbjczg(strOutParamArray[52]);//医保家床资格
		//System.out.println("获取医保卡读卡反参 ："+JSON.toJSON(model));
		return model;
	}
	
	/**
	 * 
	  * 方法描述：上传明细反参
	  * @param 
	  * @return 出参格式: outputData char* 中心交易流水号^输出参数^预留字段 1^预留字段 2 
	  * @version 1.0
	  * @author jianggen
	  * 2017年7月14日 下午4:37:47
	 */
	public static SiPrenoOutList getSiPrenoOutList(String str) {
		SiPrenoOutList modelList=new SiPrenoOutList();
		List<SiPrenoOut> siPrenoOutList=new ArrayList<SiPrenoOut>();
		if("".equals(str)){
			return null;
		}else{
			String[] strArrayList=str.split(PARAM2,-1);
			String zxjylsh=strArrayList[0];
			String ylzd1=strArrayList[2];
			String ylzd2=strArrayList[3];
			String[] strArray=strArrayList[1].split(PARAM4,-1);
			for(String s:strArray){
				SiPrenoOut model=new SiPrenoOut();
				model.setZxjylsh(zxjylsh);
				model.setYlzd1(ylzd1);
				model.setYlzd2(ylzd2);
				String[] strOutParamArray=s.split(PARAM3, -1);
				model.setCfh(strOutParamArray[0]);//处方号  非空
				model.setCflsh(strOutParamArray[1]);//处方流水号  非空 与入参处方流水号相同
				model.setCfrq(strOutParamArray[2]);//处方日期  非空 YYYYMMDDHH24MISS
				model.setYysfxmzbm(strOutParamArray[3]);//医院收费项目自编码 非空
				model.setJe(strOutParamArray[4]);//金额  最多 4 位小数
				model.setZfje(strOutParamArray[5]);//自付金额  最多 4 位小数
				model.setZlje(strOutParamArray[6]);//自理金额  最多 4 位小数
				model.setZfbl(strOutParamArray[7]);//自付比例 最多 4 位小数
				model.setZfsx(strOutParamArray[8]);//支付上限  最多 4 位小数
				model.setSfxmdj(strOutParamArray[9]);//收费项目等级  二级代码
				model.setSmxx(strOutParamArray[10]);//说明信息
				model.setBy2(strOutParamArray[11]);//备用 2  当前为空，后续扩展用
				model.setBy3(strOutParamArray[12]);//备用 3  当前为空，后续扩展用
				model.setBy4(strOutParamArray[13]);//备用 4  当前为空，后续扩展用
				model.setBy5(strOutParamArray[14]);//备用 5 当前为空，后续扩展用
				model.setBy6(strOutParamArray[15]);//备用 6  当前为空，后续扩展用
				siPrenoOutList.add(model);
			}
			//System.out.println("处方明细上传："+JSON.toJSONString(siPrenoOutList));
			modelList.setSiPrenoOutList(siPrenoOutList);
		}
		return modelList;
	}
	/**
	 * 
	  * 方法描述：获取登记信息入参
	  * @param 
	  * @return 入参格式: inputData
			业务编号^医疗机构编号^操作员编号^业务周期号^医院交易流水号^接入方式^读卡类型^入参^ 
	  * @version 1.0
	  * @author jianggen
	  * 2017年7月14日 下午1:24:32
	 */
	public static SiInDJParamInfo getSiInDjList(String str) {
		SiInDJParamInfo model =new SiInDJParamInfo();
		String[] strArray=str.split(PARAM2,-1);
		model.setYwbh(strArray[0]);
		model.setYljgbh(strArray[1]);
		model.setCzybh(strArray[2]);
		model.setYwzqh(strArray[3]);
		model.setYyjylsh(strArray[4]);
		model.setJrfs(strArray[5]);
		model.setDklx(strArray[6]);
		String[] strOutParamArray=strArray[7].split(PARAM3, -1);
		model.setMzlsh(strOutParamArray[0]);// 门诊/住院流水号
		model.setYllb(strOutParamArray[1]);//医疗类别 
		model.setMzrysj(strOutParamArray[2]);//门诊/住院入院时间 VARCHAR2(14) 非空 YYYYMMDDHH24MISS
		model.setZdjbbm(strOutParamArray[3]);//诊断疾病编码 除普通门诊、急诊外必传
		model.setBqmc(strOutParamArray[4]);//病区名称
		model.setKsbm(strOutParamArray[5]);//科室编码
		model.setCwh(strOutParamArray[6]);//床位号
		model.setYsbh(strOutParamArray[7]);//医生编码  除普通门诊、急诊外必传
		model.setJbr(strOutParamArray[8]);//经办人  非空 医药机构操作员姓名
		model.setBrlxdh(strOutParamArray[9]);//病人联系电话 
		model.setTbr(strOutParamArray[10]);//社会保障卡号 VARHCAR2(20) 非空
		model.setZyh(strOutParamArray[11]);//住院号 VARHCAR2(50)
		model.setBabyTbr(strOutParamArray[12]);//准生儿社会保障卡号 VARHCAR2(100) 当准新生儿入院时需要传入，“准生儿社会保障卡号”是办理准新	生儿新参保时提供给办理人的，院端需要前台手工录入
		model.setBy3(strOutParamArray[13]);// 备用 3 VARHCAR2(100) 当前为空，后续扩展用
		model.setBy4(strOutParamArray[14]);//备用 4 VARHCAR2(200) 当前为空，后续扩展用
		model.setBy5(strOutParamArray[15]);//备用 5 VARHCAR2(200) 当前为空，后续扩展用
		model.setBy6(strOutParamArray[16]);//备用 6 VARHCAR2(200) 当前为空，后续扩展用
		//System.out.println("获取医保登记入参："+JSON.toJSON(model));
		return model;
	}
}
