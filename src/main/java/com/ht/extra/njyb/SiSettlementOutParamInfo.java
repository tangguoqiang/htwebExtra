package com.ht.extra.njyb;

/**
 * 
	 * 类描述    医保结算反参（用于与his交互）
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月14日 上午11:09:10
 */
public class SiSettlementOutParamInfo extends SiOutParamBase {
	private String ylfze;//本次医疗费总额  2 位小数
	private String tczfje;//本次统筹支付金额  2 位小数
	private String dbjzzf;//本次大病救助支付  2 位小数
	private String dbbxzf;//本次大病保险支付  2 位小数
	private String mzbzzf;//本次民政补助支付  2 位小数
	private String zhzfze;//本次帐户支付总额  2 位小数
	private String xjzfze;//本次现金支付总额  2 位小数
	private String zhzfzf;//本次帐户支付自付  2 位小数
	private String zhzfzl;//本次帐户支付自理  2 位小数
	private String xjzfzf;//本次现金支付自付  2 位小数
	private String xjzfzl;//本次现金支付自理  2 位小数
	private String ybfwnfy;//医保范围内费用  2 位小数
	private String zhxfhye;//帐户消费后余额  2 位小数
	private String dbzbm;//单病种病种编码  二级代码
	private String smxx;//说明信息
	private String yfhj;//药费合计  2 位小数
	private String zlxmfhj;//诊疗项目费合计  2 位小数
	private String bbzf;//补保支付  2 位小数
	private String yylb;//医疗类别  二级代码
	private String isNo;//备用 6  当前为空，后续扩展用
	public String getYlfze() {
		return ylfze;
	}
	public void setYlfze(String ylfze) {
		this.ylfze = ylfze;
	}
	public String getTczfje() {
		return tczfje;
	}
	public void setTczfje(String tczfje) {
		this.tczfje = tczfje;
	}
	public String getDbjzzf() {
		return dbjzzf;
	}
	public void setDbjzzf(String dbjzzf) {
		this.dbjzzf = dbjzzf;
	}
	public String getDbbxzf() {
		return dbbxzf;
	}
	public void setDbbxzf(String dbbxzf) {
		this.dbbxzf = dbbxzf;
	}
	public String getMzbzzf() {
		return mzbzzf;
	}
	public void setMzbzzf(String mzbzzf) {
		this.mzbzzf = mzbzzf;
	}
	public String getZhzfze() {
		return zhzfze;
	}
	public void setZhzfze(String zhzfze) {
		this.zhzfze = zhzfze;
	}
	public String getXjzfze() {
		return xjzfze;
	}
	public void setXjzfze(String xjzfze) {
		this.xjzfze = xjzfze;
	}
	public String getZhzfzf() {
		return zhzfzf;
	}
	public void setZhzfzf(String zhzfzf) {
		this.zhzfzf = zhzfzf;
	}
	public String getZhzfzl() {
		return zhzfzl;
	}
	public void setZhzfzl(String zhzfzl) {
		this.zhzfzl = zhzfzl;
	}
	public String getXjzfzf() {
		return xjzfzf;
	}
	public void setXjzfzf(String xjzfzf) {
		this.xjzfzf = xjzfzf;
	}
	public String getXjzfzl() {
		return xjzfzl;
	}
	public void setXjzfzl(String xjzfzl) {
		this.xjzfzl = xjzfzl;
	}
	public String getYbfwnfy() {
		return ybfwnfy;
	}
	public void setYbfwnfy(String ybfwnfy) {
		this.ybfwnfy = ybfwnfy;
	}
	public String getZhxfhye() {
		return zhxfhye;
	}
	public void setZhxfhye(String zhxfhye) {
		this.zhxfhye = zhxfhye;
	}
	public String getDbzbm() {
		return dbzbm;
	}
	public void setDbzbm(String dbzbm) {
		this.dbzbm = dbzbm;
	}
	public String getSmxx() {
		return smxx;
	}
	public void setSmxx(String smxx) {
		this.smxx = smxx;
	}
	public String getYfhj() {
		return yfhj;
	}
	public void setYfhj(String yfhj) {
		this.yfhj = yfhj;
	}
	public String getZlxmfhj() {
		return zlxmfhj;
	}
	public void setZlxmfhj(String zlxmfhj) {
		this.zlxmfhj = zlxmfhj;
	}
	public String getBbzf() {
		return bbzf;
	}
	public void setBbzf(String bbzf) {
		this.bbzf = bbzf;
	}
	public String getYylb() {
		return yylb;
	}
	public void setYylb(String yylb) {
		this.yylb = yylb;
	}
	public String getIsNo() {
		return isNo;
	}
	public void setIsNo(String isNo) {
		this.isNo = isNo;
	}
	
}
