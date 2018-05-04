package com.ht.extra.njyb;


/**
 * 
	 * 类描述   医保相关类
 	 * @version  1.0
	 * @author  jianggen
	 * @version  2017年7月14日 下午1:16:45
 */
public class SiInfoContent {
	private SiReadCardInfo siReadCardInfo;//医保读卡反参
	private SiSettlementInParamInfo siSettlementInParamInfo;//医保结算入参
	private SiSettlementOutParamInfo siSettlementOutParamInfo;//医保结算反三处
	private SiPrenoOutList siPrenoOutList;//处方明细反参
	private SiInDJParamInfo siInDJParamInfo;//登记信息入参
	
	
	public SiInDJParamInfo getSiInDJParamInfo() {
		return siInDJParamInfo;
	}
	public void setSiInDJParamInfo(SiInDJParamInfo siInDJParamInfo) {
		this.siInDJParamInfo = siInDJParamInfo;
	}
	public SiPrenoOutList getSiPrenoOutList() {
		return siPrenoOutList;
	}
	public void setSiPrenoOutList(SiPrenoOutList siPrenoOutList) {
		this.siPrenoOutList = siPrenoOutList;
	}
	public SiReadCardInfo getSiReadCardInfo() {
		return siReadCardInfo;
	}
	public void setSiReadCardInfo(SiReadCardInfo siReadCardInfo) {
		this.siReadCardInfo = siReadCardInfo;
	}
	public SiSettlementInParamInfo getSiSettlementInParamInfo() {
		return siSettlementInParamInfo;
	}
	public void setSiSettlementInParamInfo(
			SiSettlementInParamInfo siSettlementInParamInfo) {
		this.siSettlementInParamInfo = siSettlementInParamInfo;
	}
	public SiSettlementOutParamInfo getSiSettlementOutParamInfo() {
		return siSettlementOutParamInfo;
	}
	public void setSiSettlementOutParamInfo(
			SiSettlementOutParamInfo siSettlementOutParamInfo) {
		this.siSettlementOutParamInfo = siSettlementOutParamInfo;
	}
	
}
