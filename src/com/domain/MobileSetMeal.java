package com.domain;

public class MobileSetMeal {
	
	private String pp_id;
	private String business_id;
	private String pp_name;
	private String pp_fee;
	private String business_name;	
	private String flag;
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public MobileSetMeal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MobileSetMeal(String pp_name, String pp_fee, String business_name) {
		super();
		this.pp_name = pp_name;
		this.pp_fee = pp_fee;
		this.business_name = business_name;
	}

	public String getPp_id() {
		return pp_id;
	}
	public void setPp_id(String pp_id) {
		this.pp_id = pp_id;
	}
	public String getBusiness_id() {
		return business_id;
	}
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	public MobileSetMeal(String pp_id, String business_id, String pp_name,
			String pp_fee, String business_name, String flag) {
		super();
		this.pp_id = pp_id;
		this.business_id = business_id;
		this.pp_name = pp_name;
		this.pp_fee = pp_fee;
		this.business_name = business_name;
		this.flag = flag;
	}
	public MobileSetMeal(String pp_name, String pp_fee, String business_name,
			String flag) {
		super();
		this.pp_name = pp_name;
		this.pp_fee = pp_fee;
		this.business_name = business_name;
		this.flag = flag;
	}
	public String getPp_name() {
		return pp_name;
	}
	public void setPp_name(String pp_name) {
		this.pp_name = pp_name;
	}
	public String getPp_fee() {
		return pp_fee;
	}
	public void setPp_fee(String pp_fee) {
		this.pp_fee = pp_fee;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	
	
	
}
