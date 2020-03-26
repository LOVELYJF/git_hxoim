package com.hxoim.common.rmbKit.models;

/**
 *  任免表家庭成员数据对象
 */
public class Family {
	public String chengWei;
	public String xingMing;
	public String chuShengRiQi;
	public String nianLing;
	public String zhengZhiMianMao;
	public String gongZuoDanWeiJiZhiWu;
	public String getChengWei() {
		return chengWei;
	}
	public void setChengWei(String chengWei) {
		this.chengWei = chengWei;
	}

	public String getXingMing() {
		return xingMing;
	}
	public void setXingMing(String xingMing) {
		this.xingMing = xingMing;
	}
	public String getChuShengRiQi() {
		return chuShengRiQi;
	}
	public void setChuShengRiQi(String chuShengRiQi) {
		this.chuShengRiQi = chuShengRiQi;
	}
	public String getNianLing() {
		return nianLing;
	}
	public void setNianLing(String nianLing) {
		this.nianLing = nianLing;
	}
	public String getZhengZhiMianMao() {
		//(char)11 政治面貌2个字换行
		if (zhengZhiMianMao != null && zhengZhiMianMao.length()==4){
			StringBuilder sb=new StringBuilder(zhengZhiMianMao);
			sb.insert(2, "<br/>");
			return sb.toString();
		}else {
			return zhengZhiMianMao;
		}
	}
	public void setZhengZhiMianMao(String zhengZhiMianMao) {
		this.zhengZhiMianMao = zhengZhiMianMao;
	}
	public String getGongZuoDanWeiJiZhiWu() {
		return gongZuoDanWeiJiZhiWu;
	}
	public void setGongZuoDanWeiJiZhiWu(String gongZuoDanWeiJiZhiWu) {
		this.gongZuoDanWeiJiZhiWu = gongZuoDanWeiJiZhiWu;
	}
	
}
