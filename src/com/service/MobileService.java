package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.MobileDao;
import com.dao.iface.MobileDaoIface;
import com.domain.MobileSetMeal;
import com.domain.RechargeInfor;
import com.domain.ReplaceBusiness;
import com.domain.TBusinessFee;
import com.domain.TMobilePackage;
import com.domain.TPreferentialInfor;
import com.domain.TRechargeCard;
import com.domain.T_customer;
import com.domain.T_mobile;
import com.service.iface.MobileServiceIface;

public class MobileService implements MobileServiceIface {
	
	private MobileDaoIface mobileDao;
	
	public MobileService() {
		super();
		// TODO Auto-generated constructor stub
		mobileDao=new MobileDao();
	}

	/**
	 * ע������ѯ�˻��Ƿ����
	 */
	@Override
	public String RegUserfindPwd(String username) {
		// TODO Auto-generated method stub
		String sql="select customer_name from t_customer where customer_username=?";
		
		return mobileDao.RegUserfindPwd(username, sql);
	}
	/**
	 *  ע������ѯ�ֻ����Ƿ����
	 */
	@Override
	public String RegMobilefind(String mobile) {
		// TODO Auto-generated method stub
		String sql="select customer_name from t_customer where tel_numb=?";
		
		return mobileDao.RegMobilefind(mobile, sql);
	}
	
//	public static void main(String[] args) {
//		MobileService m=new MobileService();
//		System.out.println(m.RegUserfindPwd("1213042021"));
//	}

	@Override
	public boolean RegSaveInfor(T_customer tc) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		String sql="insert into t_customer(customer_id,customer_username,customer_name,id_card_numb,tel_numb,customer_birthday,customer_pwd) "
					+"values(c.nextval,?,?,?,?,?,?)";
		
		return mobileDao.RegSaveInfor(tc, sql);
	}

	
	@Override
	public String LoginUserfindPwd(String username) {
		// TODO Auto-generated method stub
		String sql="select customer_pwd from t_customer where customer_username=?";
		
		return mobileDao.LoginUserfindPwd(username, sql);
	}
	
	
	/**
	 * ��¼����
	 */
	
	@Override
	public int T_mobileCount(T_mobile tm) {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_mobile where tel_add like ? and acc_init_amount like ? and tel_numb like ? and tel_type like ? and tel_numb like ?";
		
		System.out.println("Service���selnumb_form��ֵ:::--->>>"+tm.getTel_numb());
		
		return mobileDao.T_mobileCount(sql,tm);
	}

	
	/**
	 * ������ѡҳ�����ֻ���
	 * //����ѡ�Ĵ���selcity��seltelfee��selnumb_form��selnumb_type,inputstyle-------
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	@Override
	public List<T_mobile> mobileList(int currentPage, int pageSize,T_mobile tm) {
		// TODO Auto-generated method stub
		//������ʼ��¼��
		int begin = (currentPage - 1)*pageSize + 1;
		
		int end = (currentPage - 1)*pageSize + 6;
		
		String sql="select * from ( select a.*,rownum r from"
			+" ( select tel_numb,tel_add,acc_init_amount,rownum "
			+"from t_mobile where is_sale = 0 and tel_add like ? and acc_init_amount like ? and tel_numb like ? and tel_type like ? and tel_numb like ?"
			+" order by tel_numb desc ) a ) "+"where r between ? and ?";
		
		/**
		 * ���������ֻ�����ʾ
		 */
//		String sql="select * from ( select a.*,rownum r from"
//			+" ( select tel_numb,tel_add,acc_init_amount,rownum "
//			+"from t_mobile "
//			+" order by tel_numb desc ) a ) "+"where r between ? and ?";
		
		return mobileDao.mobileList(begin, end, sql,tm);
	}

	
	
	/**
	 * ��ѯ�����ײ�
	 * @return
	 */
	@Override
	public List<MobileSetMeal> setmeaList() {
		// TODO Auto-generated method stub
		String sql="SELECT b.pp_id,b.business_id,c.business_name,c.short_name,a.pp_name,a.pp_fee " +
						 "FROM t_phone_package a,t_package_business b,t_business_fee c " +
						 "WHERE a.pp_id = b.pp_id AND b.business_id = c.business_id ";
		
		
		return mobileDao.setmeaList(sql);
	}

	
	/**
	 * �޸�mobile��issaleΪ1
	 * 1�������ۡ� 0����δ�ۡ�
	 * @param mobile
	 * @return
	 */
	@Override
	public boolean updateIsSale(String mobile) {
		// TODO Auto-generated method stub
		String sql="update t_mobile set is_sale = 1 where tel_numb = ?";
		
		return mobileDao.updateIsSale(mobile, sql);
	}

	
	/**
	 * ͨ��username����ѯ�ͻ���Ϣ
	 * @param username
	 * @return
	 */
	@Override
	public T_customer uerFindInfor(String username) {
		// TODO Auto-generated method stub
		String sql="select * from t_customer where customer_username = ?";
		
		return mobileDao.uerFindInfor(username, sql);
	}

	
	/**
	 * ͨ��tel_charge����ȡ��ֵ�Ż�discount_amount
	 * @param tel_charge
	 * @return
	 */
	@Override
	public TPreferentialInfor findTel_chargeAndDiscount_amount(String tel_charge) {
		// TODO Auto-generated method stub
		String sql="select discount_amount,preferential_name from t_preferential_infor where tel_charge = ?";
		
		return mobileDao.findTel_chargeAndDiscount_amount(tel_charge, sql);
	}
	
	
	/**
	 * �����ֵ��¼
	 * @param rcInfor
	 * @return
	 */
	@Override
	public boolean saveRechargeInfor(RechargeInfor rcInfor) {
		// TODO Auto-generated method stub
		
		String sql = "insert into t_recharge_infor(Recharge_infor_id,Tel_numb,Recharge_time,Recharge_type_id,Bank_card_numb,discount_amount,recharge_money)" +
		"values(t1.nextval,?,to_date(?,'DD-MM-YYYY'),?,?,?,?)";
		
		return mobileDao.saveRechargeInfor(rcInfor, sql);
	}
	
	
	/**
	 * ͨ��cardNum����ѯ��ֵ���Ƿ����
	 * @param cardNum
	 * @return
	 */
	@Override
	public String cardNumFind(String cardNum) {
		// TODO Auto-generated method stub
		String sql="select card_pwd from t_recharge_card where card_id = ?";
		
		return mobileDao.cardNumFind(cardNum, sql);
	}
	
	
	/**
	 * ͨ��cardNum����ѯ��ֵ����������Ϣ
	 * @param cardNum
	 * @return
	 */
	@Override
	public TRechargeCard cardNumFindInfor(String cardNum) {
		// TODO Auto-generated method stub
		String sql="select * from t_recharge_card where card_id = ?";
		
		return mobileDao.cardNumFindInfor(cardNum, sql);
	}

	
	/**
	 * ����ֵ���ĳ�ֵ��¼�����t_recharge_infor����
	 * @param t
	 * @return
	 */
	@Override
	public boolean saveRechargeInforCard(RechargeInfor rcInfor) {
		// TODO Auto-generated method stub
		String sql = "insert into t_recharge_infor(Recharge_infor_id,Tel_numb,Recharge_time,Recharge_type_id,card_id,discount_amount,recharge_money)" +
		"values(t1.nextval,?,to_date(?,'DD-MM-YYYY'),?,?,?,?)";
		
		return mobileDao.saveRechargeInforCard(rcInfor, sql);
	}

	
	
	
	/**
	 * ͨ���ֻ�������ѯ���г�ֵ��¼
	 * @param mobile
	 * @return
	 */
	@Override
	public List<RechargeInfor> rechargeInforList(int currentPage,int pageSize,String mobile) {
		// TODO Auto-generated method stub
		
		//������ʼ��¼��
		int begin = (currentPage - 1)*pageSize + 1;
		
		int end = (currentPage - 1)*pageSize + 4;
		
		//String sql="select * from t_recharge_infor where tel_numb = ?";
		String sql="select * from ( select a.*,rownum r from "
			+" ( select tel_numb,recharge_time,recharge_type_id, "
			+" card_id,bank_card_numb,discount_amount,recharge_money,rownum "
			+" from t_recharge_infor where tel_numb = ? "
			+" order by tel_numb desc ) a ) "+" where r between ? and ? ";
		
		
		return mobileDao.rechargeInforList(begin,end,mobile, sql);
	}

	
	/**
	 * ���ѳ���ĳ�ֵ����is_available��1-->>0
	 * @param card_id
	 * @return
	 */
	@Override
	public boolean rechargeCardIsAvailable(String card_id) {
		// TODO Auto-generated method stub
		String sql="update t_recharge_card set is_available = 0 where card_id = ?";
		
		return mobileDao.rechargeCardIsAvailable(card_id, sql);
	}

	
	/**
	 * ��ѯָ���ֻ��ŵļ�¼����
	 * @param mobile
	 * @return
	 */
	@Override
	public int countRecords(String mobile) {
		// TODO Auto-generated method stub
		String sql="select count(*) from t_recharge_infor where tel_numb = ?";
		
		return mobileDao.countRecords(mobile, sql);
	}

	
	/**
	 *����ָ�����ֻ��Ų�ѯ��ѡ��ҵ����ײ�
	 * @param mobile
	 * @return
	 */
	@Override
	public List<ReplaceBusiness> findBussiness(String mobile) {
		// TODO Auto-generated method stub
		String sql=" SELECT tel_numb,start_time,t3.business_id,t3.end_time,business_name,short_name "
			+" FROM t_business_fee t2,t_mobile_package t3 "
			+" WHERE t3.business_id=t2.business_id AND tel_numb = ? ";
				
		
		
		return mobileDao.findBussiness(mobile, sql);
	}

	
	/**
	 * ��ѯ����t_business_fee���������
	 * @return
	 */
	@Override
	public List<TBusinessFee> findTBussinessFeeList() {
		// TODO Auto-generated method stub
		String sql="select * from t_business_fee";
		
		return mobileDao.findTBussinessFeeList(sql);
	}

	
	
	/**
	 * �������ҵ����ײ�
	 * @param tmp
	 * @return
	 */
	@Override
	public boolean savetmobilepackage(TMobilePackage tmp) {
		// TODO Auto-generated method stub
		String sql = "insert into t_mobile_package(Tel_Package_Id,Tel_numb,Business_id,pp_id,Start_time,End_time,status)" +
		"values(t2.nextval,?,?,?,to_date(?,'DD-MM-YYYY'),to_date(?,'DD-MM-YYYY'),?)";
		
		return mobileDao.savetmobilepackage(tmp, sql);
	}

	
	
	
	/**
	 * ����ָ���� �ֻ��� �� businessId ����ѯ��ѡ��ҵ����ײ�
	 * @param mobile
	 * @param business_id
	 * @return
	 */
	@Override
	public ReplaceBusiness findEffectiveAndEndTime(String mobile,
			String business_id) {
		// TODO Auto-generated method stub
		String sql=" SELECT tel_numb,start_time,business_id,end_time,pp_id "
				+" FROM t_mobile_package "
				+" WHERE tel_numb = ? and business_id= ? ";
		
		
		return mobileDao.findEffectiveAndEndTime(mobile, business_id, sql);
	}

	
	
	/**
	 * ����business_id,mobile,status����дȷ��д����ʱ���λ��
	 * @param mobile
	 * @return
	 */
	@Override
	public String findEndTime(String mobile, String business_id,String status) {
		// TODO Auto-generated method stub
		String sql=" select * from t_mobile_package where business_id = ? and tel_numb = ? and status = ? ";
		
		return mobileDao.findEndTime(mobile, business_id, status, sql);
	}

	
	/**
	 * ����tel_package_id������ر�ʱ��
	 * @param tel_package_id
	 * @return
	 */
	@Override
	public boolean saveEndTime(String tel_package_id,String end_time) {
		// TODO Auto-generated method stub
		String sql=" update t_mobile_package set end_time = to_date(?,'DD-MM-YYYY'),status = 0 where tel_package_id = ? ";
		
		return mobileDao.saveEndTime(tel_package_id, end_time, sql);
	}

	
	/**
	 * Ԥ�����Ѵ�Ǯ
	 * @param selfee
	 * @return
	 */
	@Override
	public boolean saveAccount(int selfee) {
		// TODO Auto-generated method stub
		String sql="update t_account set account_balance = account_balance + ?";
		return mobileDao.saveAccount(selfee, sql);
	}

	
	/**
	 * ��ѯ�ƶ���ֵ���ĳ�ֵ���
	 * @param cardId
	 * @return
	 */
	@Override
	public int findCardCharge(String cardId) {
		// TODO Auto-generated method stub
		String sql="select * from t_recharge_card where card_id = ?";
		return mobileDao.findCardCharge(cardId, sql);
	}

	
	/**
	 * �����ֻ�������ѯ�����
	 * @param mobile
	 * @return
	 */
	@Override
	public int findAccount(String mobile) {
		// TODO Auto-generated method stub
		String sql="select * from t_account where tel_number = ?";
		
		return mobileDao.findAccount(mobile, sql);
	}

	


	
	



	


}
