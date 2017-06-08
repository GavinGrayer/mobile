package com.domain;

public class TPreferentialInfor {
	
	public String tel_charge;  //充值金额
	public String discount_amount; //充值优惠
	public String preferential_name; //优惠名称
	public TPreferentialInfor(String tel_charge, String discount_amount,
			String preferential_name) {
		super();
		this.tel_charge = tel_charge;
		this.discount_amount = discount_amount;
		this.preferential_name = preferential_name;
	}
	public TPreferentialInfor(String discount_amount, String preferential_name) {
		super();
		this.discount_amount = discount_amount;
		this.preferential_name = preferential_name;
	}
	public String getPreferential_name() {
		return preferential_name;
	}
	public void setPreferential_name(String preferential_name) {
		this.preferential_name = preferential_name;
	}
	public TPreferentialInfor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTel_charge() {
		return tel_charge;
	}
	public void setTel_charge(String tel_charge) {
		this.tel_charge = tel_charge;
	}
	public String getDiscount_amount() {
		return discount_amount;
	}
	public void setDiscount_amount(String discount_amount) {
		this.discount_amount = discount_amount;
	}
	
	
	
}
