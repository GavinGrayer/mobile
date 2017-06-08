package com.domain;

import java.sql.Date;

public class RechargeInfor {
	
	private String tel_numb;   //�ֻ����
	private String recharge_time;//��ֵʱ��
	private String recharge_type_id;//��ֵ��ʽ���
	private String card_id;//��ֵ�����
	private String bank_card_numb;//���п�����
	private String preferential_id;//�Żݱ��
	private String discount_amout;//�Żݽ��
	private String recharge_money;//��ֵ���
	private int money_count;//�ܵĳ�ֵ���
	private int bc_count;//���п���ֵ����
	private int card_count;//��ֵ������
	private int discount_count;//�Ż��ܽ��
	
	public RechargeInfor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getMoney_count() {
		return money_count;
	}



	public void setMoney_count(int money_count) {
		this.money_count = money_count;
	}



	public int getBc_count() {
		return bc_count;
	}



	public void setBc_count(int bc_count) {
		this.bc_count = bc_count;
	}



	public int getCard_count() {
		return card_count;
	}



	public void setCard_count(int card_count) {
		this.card_count = card_count;
	}



	public int getDiscount_count() {
		return discount_count;
	}



	public void setDiscount_count(int discount_count) {
		this.discount_count = discount_count;
	}



	public RechargeInfor(String tel_numb, String recharge_time,
			String recharge_type_id, String card_id, String bank_card_numb,
			String discount_amout, String recharge_money, int money_count,
			int bc_count, int card_count, int discount_count) {
		super();
		this.tel_numb = tel_numb;
		this.recharge_time = recharge_time;
		this.recharge_type_id = recharge_type_id;
		this.card_id = card_id;
		this.bank_card_numb = bank_card_numb;
		this.discount_amout = discount_amout;
		this.recharge_money = recharge_money;
		this.money_count = money_count;
		this.bc_count = bc_count;
		this.card_count = card_count;
		this.discount_count = discount_count;
	}



	public RechargeInfor(String tel_numb, String recharge_time,
			String recharge_type_id, String card_id, String bank_card_numb,
			String discount_amout, String recharge_money) {
		super();
		this.tel_numb = tel_numb;
		this.recharge_time = recharge_time;
		this.recharge_type_id = recharge_type_id;
		this.card_id = card_id;
		this.bank_card_numb = bank_card_numb;
		this.discount_amout = discount_amout;
		this.recharge_money = recharge_money;
	}



	public RechargeInfor(String tel_numb, String recharge_time,
			String recharge_type_id, String bank_card_numb,
			String discount_amout, String recharge_money) {
		super();
		this.tel_numb = tel_numb;
		this.recharge_time = recharge_time;
		this.recharge_type_id = recharge_type_id;
		this.bank_card_numb = bank_card_numb;
		this.discount_amout = discount_amout;
		this.recharge_money = recharge_money;
	}



	public RechargeInfor(String tel_numb, String recharge_time,
			String recharge_type_id, String card_id, String bank_card_numb,
			String preferential_id, String discount_amout, String recharge_money) {
		super();
		this.tel_numb = tel_numb;
		this.recharge_time = recharge_time;
		this.recharge_type_id = recharge_type_id;
		this.card_id = card_id;
		this.bank_card_numb = bank_card_numb;
		this.preferential_id = preferential_id;
		this.discount_amout = discount_amout;
		this.recharge_money = recharge_money;
	}
	public String getTel_numb() {
		return tel_numb;
	}
	public void setTel_numb(String tel_numb) {
		this.tel_numb = tel_numb;
	}
	public String getRecharge_time() {
		return recharge_time;
	}
	public void setRecharge_time(String recharge_time) {
		this.recharge_time = recharge_time;
	}
	public String getRecharge_type_id() {
		return recharge_type_id;
	}
	public void setRecharge_type_id(String recharge_type_id) {
		this.recharge_type_id = recharge_type_id;
	}
	public String getCard_id() {
		return card_id;
	}
	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}
	public String getBank_card_numb() {
		return bank_card_numb;
	}
	public void setBank_card_numb(String bank_card_numb) {
		this.bank_card_numb = bank_card_numb;
	}
	public String getPreferential_id() {
		return preferential_id;
	}
	public void setPreferential_id(String preferential_id) {
		this.preferential_id = preferential_id;
	}
	public String getDiscount_amout() {
		return discount_amout;
	}
	public void setDiscount_amout(String discount_amout) {
		this.discount_amout = discount_amout;
	}
	public String getRecharge_money() {
		return recharge_money;
	}
	public void setRecharge_money(String recharge_money) {
		this.recharge_money = recharge_money;
	}
	
	
	
}
