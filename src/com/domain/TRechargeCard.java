package com.domain;

public class TRechargeCard {
	
	private String card_id;//��ֵ������
	private String card_pwd;//��ֵ����
	private String card_charge;//��ֵ���
	private String is_available;//��ֵ��״̬  1�������á���0���������á�
	public TRechargeCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TRechargeCard(String card_id, String card_pwd, String card_charge,
			String is_available) {
		super();
		this.card_id = card_id;
		this.card_pwd = card_pwd;
		this.card_charge = card_charge;
		this.is_available = is_available;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getCard_pwd() {
		return card_pwd;
	}
	public void setCard_pwd(String card_pwd) {
		this.card_pwd = card_pwd;
	}
	public String getCard_charge() {
		return card_charge;
	}
	public void setCard_charge(String card_charge) {
		this.card_charge = card_charge;
	}
	public String getIs_available() {
		return is_available;
	}
	public void setIs_available(String is_available) {
		this.is_available = is_available;
	}
	
	
}
