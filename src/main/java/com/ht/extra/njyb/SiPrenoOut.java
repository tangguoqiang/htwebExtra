package com.ht.extra.njyb;

/**
 * 
	 * 类描述  处方上传明细医保反参（与his交互）
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月14日 下午3:31:47
 */
public class SiPrenoOut extends SiOutParamBase{
	private String cfh;//处方号  非空
	private String cflsh;//处方流水号  非空 与入参处方流水号相同
	private String cfrq;//处方日期  非空 YYYYMMDDHH24MISS
	private String yysfxmzbm;//医院收费项目自编码 非空
	private String je;//金额  最多 4 位小数
	private String zfje;//自付金额  最多 4 位小数
	private String zlje;//自理金额  最多 4 位小数
	private String zfbl;//自付比例 最多 4 位小数
	private String zfsx;//支付上限  最多 4 位小数
	private String sfxmdj;//收费项目等级  二级代码
	private String smxx;//说明信息
	private String by2;//备用 2  当前为空，后续扩展用
	private String by3;//备用 3  当前为空，后续扩展用
	private String by4;//备用 4  当前为空，后续扩展用
	private String by5;//备用 5 当前为空，后续扩展用
	private String by6;//备用 6  当前为空，后续扩展用
	/**
	 * 本交易对应二级代码
	序号 类别名称 代码值 代码名称
	1 收费项目种类 1 药品
	2 收费项目种类 2 诊疗项目
	3 收费项目种类 3 医用材料
	南京金保二期医保接口手册 P-28/44
	4 收费项目等级 1 甲类
	5 收费项目等级 2 乙类
	6 收费项目等级 3 丙类
	7 按最小计价单位收费 0 否
	8 按最小计价单位收费 1 是
	 */
	public String getCfh() {
		return cfh;
	}
	public void setCfh(String cfh) {
		this.cfh = cfh;
	}
	public String getCflsh() {
		return cflsh;
	}
	public void setCflsh(String cflsh) {
		this.cflsh = cflsh;
	}
	public String getCfrq() {
		return cfrq;
	}
	public void setCfrq(String cfrq) {
		this.cfrq = cfrq;
	}
	public String getYysfxmzbm() {
		return yysfxmzbm;
	}
	public void setYysfxmzbm(String yysfxmzbm) {
		this.yysfxmzbm = yysfxmzbm;
	}
	public String getJe() {
		return je;
	}
	public void setJe(String je) {
		this.je = je;
	}
	public String getZfje() {
		return zfje;
	}
	public void setZfje(String zfje) {
		this.zfje = zfje;
	}
	public String getZlje() {
		return zlje;
	}
	public void setZlje(String zlje) {
		this.zlje = zlje;
	}
	public String getZfbl() {
		return zfbl;
	}
	public void setZfbl(String zfbl) {
		this.zfbl = zfbl;
	}
	public String getZfsx() {
		return zfsx;
	}
	public void setZfsx(String zfsx) {
		this.zfsx = zfsx;
	}
	public String getSfxmdj() {
		return sfxmdj;
	}
	public void setSfxmdj(String sfxmdj) {
		this.sfxmdj = sfxmdj;
	}
	public String getSmxx() {
		return smxx;
	}
	public void setSmxx(String smxx) {
		this.smxx = smxx;
	}
	public String getBy2() {
		return by2;
	}
	public void setBy2(String by2) {
		this.by2 = by2;
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
	
	
}
