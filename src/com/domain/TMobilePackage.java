package com.domain;

public class TMobilePackage {
	
	private String Tel_Package_Id;//手机套餐配置编号  自增长
	private String Tel_numb;//手机号码
	private String Business_id;//业务编号
	private String pp_id;//套餐编号
	private String Start_time;//
	private String End_time;
	private String status;//套餐后者业务状态
	public TMobilePackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TMobilePackage(String tel_numb, String business_id,
			String start_time, String end_time, String status) {
		super();
		Tel_numb = tel_numb;
		Business_id = business_id;
		Start_time = start_time;
		End_time = end_time;
		this.status = status;
	}

	public TMobilePackage(String tel_numb, String business_id, String pp_id,
			String start_time, String end_time, String status) {
		super();
		Tel_numb = tel_numb;
		Business_id = business_id;
		this.pp_id = pp_id;
		Start_time = start_time;
		End_time = end_time;
		this.status = status;
	}
	public String getTel_numb() {
		return Tel_numb;
	}
	public void setTel_numb(String tel_numb) {
		Tel_numb = tel_numb;
	}
	public String getBusiness_id() {
		return Business_id;
	}
	public void setBusiness_id(String business_id) {
		Business_id = business_id;
	}
	public String getPp_id() {
		return pp_id;
	}
	public void setPp_id(String pp_id) {
		this.pp_id = pp_id;
	}
	public String getStart_time() {
		return Start_time;
	}
	public void setStart_time(String start_time) {
		Start_time = start_time;
	}
	public String getEnd_time() {
		return End_time;
	}
	public void setEnd_time(String end_time) {
		End_time = end_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
