package com.domain;

public class T_mobile {
	
	private String tel_numb;  //�ֻ����� 13x
	private String tel_type;  //���� ��3G
	private String tel_add;  //������
	private String acc_init_amount; //Ԥ�滰��
	private String input_tel; //ָ���ֻ��Ŷ�
	private int is_sale;	//�Ƿ��۳�
	
	
	public T_mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public T_mobile(String tel_numb, String tel_type, String tel_add,
			String acc_init_amount, String input_tel) {
		super();
		this.tel_numb = tel_numb;
		this.tel_type = tel_type;
		this.tel_add = tel_add;
		this.acc_init_amount = acc_init_amount;
		this.input_tel = input_tel;
	}











	public T_mobile(String tel_numb, String tel_add, String acc_init_amount) {
		super();
		this.tel_numb = tel_numb;
		this.tel_add = tel_add;
		this.acc_init_amount = acc_init_amount;
	}




	
	public T_mobile(String tel_numb, String tel_type, String tel_add,
			String acc_init_amount, String input_tel, int is_sale) {
		super();
		this.tel_numb = tel_numb;
		this.tel_type = tel_type;
		this.tel_add = tel_add;
		this.acc_init_amount = acc_init_amount;
		this.input_tel = input_tel;
		this.is_sale = is_sale;
	}




	public String getInput_tel() {
		return input_tel;
	}



	public void setInput_tel(String input_tel) {
		this.input_tel = input_tel;
	}



	public String getTel_numb() {
		return tel_numb;
	}
	public void setTel_numb(String tel_numb) {
		this.tel_numb = tel_numb;
	}
	public String getTel_type() {
		return tel_type;
	}
	public void setTel_type(String tel_type) {
		this.tel_type = tel_type;
	}
	public String getTel_add() {
		return tel_add;
	}
	public void setTel_add(String tel_add) {
		this.tel_add = tel_add;
	}

	public String getAcc_init_amount() {
		return acc_init_amount;
	}



	public void setAcc_init_amount(String acc_init_amount) {
		this.acc_init_amount = acc_init_amount;
	}



	public int getIs_sale() {
		return is_sale;
	}
	public void setIs_sale(int is_sale) {
		this.is_sale = is_sale;
	}
	
	
}
