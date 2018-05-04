package com.ht.extra.njyb;

/**
 * 
	 * 类描述  医保入参报文头
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月14日 下午1:35:59
 */
public class SiInParamBase {

	/**
	 * 入参格式: inputData
			业务编号^医疗机构编号^操作员编号^业务周期号^医院交易流水号^接入方式^读卡类型^入参^ 
	 */
	private String ywbh;//业务编号
	private String yljgbh;//医疗机构编号
	private String czybh;//操作员编号
	private String ywzqh;//业务周期号
	private String yyjylsh;//医院交易流水号
	private String jrfs;//接入方式
	private String dklx;//读卡类型
	public String getYwbh() {
		return ywbh;
	}
	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}
	public String getYljgbh() {
		return yljgbh;
	}
	public void setYljgbh(String yljgbh) {
		this.yljgbh = yljgbh;
	}
	public String getCzybh() {
		return czybh;
	}
	public void setCzybh(String czybh) {
		this.czybh = czybh;
	}
	public String getYwzqh() {
		return ywzqh;
	}
	public void setYwzqh(String ywzqh) {
		this.ywzqh = ywzqh;
	}
	public String getYyjylsh() {
		return yyjylsh;
	}
	public void setYyjylsh(String yyjylsh) {
		this.yyjylsh = yyjylsh;
	}
	public String getJrfs() {
		return jrfs;
	}
	public void setJrfs(String jrfs) {
		this.jrfs = jrfs;
	}
	public String getDklx() {
		return dklx;
	}
	public void setDklx(String dklx) {
		this.dklx = dklx;
	}
	
	
}
