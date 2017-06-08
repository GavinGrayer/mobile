package com.dao.iface;

import java.util.List;

import com.domain.MobileSetMeal;
import com.domain.RechargeInfor;
import com.domain.ReplaceBusiness;
import com.domain.TBusinessFee;
import com.domain.TMobilePackage;
import com.domain.TPreferentialInfor;
import com.domain.TRechargeCard;
import com.domain.T_customer;
import com.domain.T_mobile;

public interface MobileDaoIface {
	
	/**
	 * ע������ѯ�˻��Ƿ����
	 * @param username
	 * @param sql
	 * @return
	 */
	public String RegUserfindPwd(String username,String sql);
	
	/**
	 * ע������ѯ�ֻ����Ƿ����
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public String RegMobilefind(String mobile,String sql);
	
	
	/**
	 * ��ע����汣������ݿ�
	 * @param tc
	 * @param sql
	 * @return
	 */
	public boolean RegSaveInfor(T_customer tc,String sql);
	
	/**
	 * ��½����ͨ���˻���ѯ����
	 * @param username
	 * @param sql
	 * @return
	 */
	public String LoginUserfindPwd(String username,String sql);
	
	
	/**
	 * ��¼�ֻ�������
	 * 
	 * @param sql
	 * @return
	 */
	public int T_mobileCount(String sql,T_mobile tm);
	
	/**
	 * 
	 * ������ѡҳ�����ֻ���
	 * //����ѡ�Ĵ���selcity��seltelfee��selnumb_form��selnumb_type,inputstyle-------
	 * @param currentPage
	 * @param pageSize
	 * @return
	 *
	 */
	public List<T_mobile> mobileList(int currentPage,int pageSize,String sql,T_mobile tm);
	
	
	
	/**
	 * ��ѯ�����ײ�
	 * @param sql
	 * @return
	 */
	public List<MobileSetMeal> setmeaList(String sql);
	
	
	/**
	 * �޸�mobile��issaleΪ1
	 * 1�������ۡ� 0����δ�ۡ�
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public boolean updateIsSale(String mobile,String sql);
	
	/**
	 * ͨ��username����ѯ�ͻ���Ϣ
	 * @param username
	 * @param sql
	 * @return
	 */
	public T_customer uerFindInfor(String username,String sql);
	
	/**
	 * ͨ��tel_charge����ȡ��ֵ�Ż�discount_amount
	 * @param tel_charge
	 * @param sql
	 * @return
	 */
	public TPreferentialInfor findTel_chargeAndDiscount_amount(String tel_charge,String sql);
	
	
	/**
	 * �����ֵ��¼
	 * @param rcInfor
	 * @param sql
	 * @return
	 */
	public boolean saveRechargeInfor(RechargeInfor rcInfor,String sql);
	
	
	/**
	 * ͨ��cardNum����ѯ��ֵ���Ƿ����
	 * @param cardNum
	 * @return
	 */
	public String cardNumFind(String cardNum,String sql);
	
	/**
	 * ͨ��cardNum����ѯ��ֵ����������Ϣ
	 * @param cardNum
	 * @param sql
	 * @return
	 */
	public TRechargeCard cardNumFindInfor(String cardNum,String sql);
	
	/**
	 * ����ֵ���ĳ�ֵ��¼�����t_recharge_infor����
	 * @param t
	 * @param sql
	 * @return
	 */
	public boolean saveRechargeInforCard(RechargeInfor rcInfor,String sql);
	
	/**
	 * ͨ���ֻ�������ѯ���г�ֵ��¼
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public List<RechargeInfor> rechargeInforList(int begin,int end,String mobile,String sql); 

	/**
	 * ���ѳ���ĳ�ֵ����is_available��1-->>0
	 * @param card_id
	 * @param sql
	 * @return
	 */
	public boolean rechargeCardIsAvailable(String card_id,String sql);
	
	/**
	 * ��ѯָ���ֻ��ŵļ�¼����
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public int countRecords(String mobile,String sql);
	
	/**
	 * ����ָ�����ֻ��Ų�ѯ��ѡ��ҵ����ײ�
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public List<ReplaceBusiness> findBussiness(String mobile,String sql);
	
	
	/**
	 * ��ѯ����t_business_fee���������
	 * @param sql
	 * @return
	 */
	public List<TBusinessFee> findTBussinessFeeList(String sql);
	
	/**
	 * �������ҵ����ײ�
	 * @param tmp
	 * @param sql
	 * @return
	 */
	public boolean savetmobilepackage(TMobilePackage tmp,String sql);
	
	
	/**
	 * ����ָ���� �ֻ��� �� businessId ����ѯ��ѡ��ҵ����ײ�
	 * @param mobile
	 * @param business_id
	 * @param sql
	 * @return
	 */
	public ReplaceBusiness findEffectiveAndEndTime(String mobile,String business_id,String sql);
	
	
	/**
	 * ����business_id,mobile,status����дȷ��д����ʱ���λ��
	 * @param mobile
	 * @param business_id
	 * @param status
	 * @param sql
	 * @return
	 */
	public String findEndTime(String mobile, String business_id,String status,String sql);
	
	
	/**
	 * ����tel_package_id������ر�ʱ��
	 * @param tel_package_id
	 * @param end_time
	 * @param sql
	 * @return
	 */
	public boolean saveEndTime(String tel_package_id,String end_time,String sql); 
	
	
	/**
	 * Ԥ�����Ѵ�Ǯ
	 * @param selfee
	 * @param sql
	 * @return
	 */
	public boolean saveAccount(int selfee,String sql); 
	
	
	/**
	 * ��ѯ�ƶ���ֵ���ĳ�ֵ���
	 * @param cardId
	 * @param sql
	 * @return
	 */
	public int findCardCharge(String cardId,String sql); 
	
	
	/**
	 * �����ֻ�������ѯ�����
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public int findAccount(String mobile,String sql);
}
