package com.domain;

public class TBusinessFee {
	
	private String business_id;//业务编号
	private String business_name;//业务名称
	private String short_name;//业务名称缩写
	private String business_charge;//业务收费
	private String is_optional;//业务状态   1代表‘用户可选’ 0代表‘用户不可选’
	private String is_largess; //业务状态   1代表‘赠送业务’ 0代表‘基础业务’
	private String effective_time;//起始时间
	private String end_time;//结束时间
	
	
	public TBusinessFee(String business_id) {
		super();
		this.business_id = business_id;
	}

	public TBusinessFee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TBusinessFee(String business_name, String short_name,
			String business_charge, String is_optional, String is_largess) {
		super();
		this.business_name = business_name;
		this.short_name = short_name;
		this.business_charge = business_charge;
		this.is_optional = is_optional;
		this.is_largess = is_largess;
	}

	
	
	public String getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}

	public TBusinessFee(String business_id, String business_name,
			String short_name, String business_charge, String is_optional,
			String is_largess, String effective_time, String end_time) {
		super();
		this.business_id = business_id;
		this.business_name = business_name;
		this.short_name = short_name;
		this.business_charge = business_charge;
		this.is_optional = is_optional;
		this.is_largess = is_largess;
		this.effective_time = effective_time;
		this.end_time = end_time;
	}

	public TBusinessFee(String business_name, String short_name,
			String business_charge, String is_optional, String is_largess,
			String effective_time, String end_time) {
		super();
		this.business_name = business_name;
		this.short_name = short_name;
		this.business_charge = business_charge;
		this.is_optional = is_optional;
		this.is_largess = is_largess;
		this.effective_time = effective_time;
		this.end_time = end_time;
	}

	public String getEffective_time() {
		return effective_time;
	}

	public void setEffective_time(String effective_time) {
		this.effective_time = effective_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getBusiness_name() {
		return business_name;
	}

	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getBusiness_charge() {
		return business_charge;
	}

	public void setBusiness_charge(String business_charge) {
		this.business_charge = business_charge;
	}

	public String getIs_optional() {
		return is_optional;
	}

	public void setIs_optional(String is_optional) {
		this.is_optional = is_optional;
	}

	public String getIs_largess() {
		return is_largess;
	}

	public void setIs_largess(String is_largess) {
		this.is_largess = is_largess;
	}
	
	
	
	
	
}
