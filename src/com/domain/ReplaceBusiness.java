package com.domain;

public class ReplaceBusiness {
	
	private String business_id;//ҵ����
	private String tel_numb;//�ֻ���
	private String start_time;//��ʼʱ��
	private String end_time;//����ʱ��
	private String business_name;//ҵ������
	private String short_name;//ҵ��������д
	private String pp_name;//�ײ�����
	private String pp_fee;//�ײͼ��
	private String pp_id;//�ײͱ��
	
	public ReplaceBusiness(String business_id, String tel_numb,
			String start_time, String end_time, String business_name,
			String short_name, String pp_name, String pp_fee, String pp_id) {
		super();
		this.business_id = business_id;
		this.tel_numb = tel_numb;
		this.start_time = start_time;
		this.end_time = end_time;
		this.business_name = business_name;
		this.short_name = short_name;
		this.pp_name = pp_name;
		this.pp_fee = pp_fee;
		this.pp_id = pp_id;
	}

	public ReplaceBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}

	public ReplaceBusiness(String business_id, String tel_numb,
			String start_time, String end_time, String business_name,
			String short_name, String pp_name, String pp_fee) {
		super();
		this.business_id = business_id;
		this.tel_numb = tel_numb;
		this.start_time = start_time;
		this.end_time = end_time;
		this.business_name = business_name;
		this.short_name = short_name;
		this.pp_name = pp_name;
		this.pp_fee = pp_fee;
	}

	public ReplaceBusiness(String tel_numb, String start_time, String end_time,
			String business_name, String short_name, String pp_name,
			String pp_fee) {
		super();
		this.tel_numb = tel_numb;
		this.start_time = start_time;
		this.end_time = end_time;
		this.business_name = business_name;
		this.short_name = short_name;
		this.pp_name = pp_name;
		this.pp_fee = pp_fee;
	}
	public String getTel_numb() {
		return tel_numb;
	}
	public void setTel_numb(String tel_numb) {
		this.tel_numb = tel_numb;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
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
	
	
	
}
