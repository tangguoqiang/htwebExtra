package com.ht.extra.njyb;

/**
 * 
	 * 类描述  医保出参报文头
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月14日 下午1:36:18
 */
public class SiOutParamBase {

	/**
	 * 出参格式: outputData char*
		中心交易流水号^输出参数^预留字段 1^预留字段 2 
	 */
	
	private String zxjylsh;//中心交易流水号
	private String ylzd1;//预留字段 1
	private String ylzd2;//预留字段 2 
	public String getZxjylsh() {
		return zxjylsh;
	}
	public void setZxjylsh(String zxjylsh) {
		this.zxjylsh = zxjylsh;
	}
	public String getYlzd1() {
		return ylzd1;
	}
	public void setYlzd1(String ylzd1) {
		this.ylzd1 = ylzd1;
	}
	public String getYlzd2() {
		return ylzd2;
	}
	public void setYlzd2(String ylzd2) {
		this.ylzd2 = ylzd2;
	}
	
	
}
