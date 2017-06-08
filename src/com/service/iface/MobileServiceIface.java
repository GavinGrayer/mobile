package com.service.iface;

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

public interface MobileServiceIface {
	
	/**
	 * ע������ѯ�˻��Ƿ����
	 * @param username
	 * @return
	 */
	public String RegUserfindPwd(String username);
	
	
	
	/**
	 * ע������ѯ�ֻ����Ƿ����
	 * @param mobile
	 * @return
	 */
	public String RegMobilefind(String mobile);
	
	
	/**
	 * ��ע����汣������ݿ�
	 * @param tc
	 * @return
	 */
	public boolean RegSaveInfor(T_customer tc);
	
	/**
	 * ��½����ͨ���˻���ѯ����
	 * @param username
	 * @return
	 */
	public String LoginUserfindPwd(String username);
	
	/**
	 * ��¼�ֻ�������
	 * @param tm
	 * @return
	 */
	public int T_mobileCount(T_mobile tm);
	
	/**
	 * ������ѡҳ�����ֻ���
	 * //����ѡ�Ĵ���selcity��seltelfee��selnumb_form��selnumb_type,inputstyle-------
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<T_mobile> mobileList(int currentPage,int pageSize,T_mobile tm);
	
	
	/**
	 * ��ѯ�����ײ�
	 * @return
	 */
	public List<MobileSetMeal> setmeaList();
	
	
	/**
	 * �޸�mobile��issaleΪ1
	 * 1�������ۡ� 0����δ�ۡ�
	 * @param mobile
	 * @return
	 */
	public boolean updateIsSale(String mobile);
	
	
	/**
	 * ͨ��username����ѯ�ͻ���Ϣ
	 * @param username
	 * @return
	 */
	public T_customer uerFindInfor(String username);
	
	/**
	 * ͨ��tel_charge����ȡ��ֵ�Ż�discount_amount
	 * @param tel_charge
	 * @return
	 */
	public TPreferentialInfor findTel_chargeAndDiscount_amount(String tel_charge);
	
	
	/**
	 * �����ֵ��¼
	 * @param rcInfor
	 * @return
	 */
	public boolean saveRechargeInfor(RechargeInfor rcInfor);
	
	/**
	 * ͨ��cardNum����ѯ��ֵ���Ƿ����
	 * @param cardNum
	 * @return
	 */
	public String cardNumFind(String cardNum);
	
	/**
	 * ͨ��cardNum����ѯ��ֵ����������Ϣ
	 * @param cardNum
	 * @return
	 */
	public TRechargeCard cardNumFindInfor(String cardNum);
	
	/**
	 * ����ֵ���ĳ�ֵ��¼�����t_recharge_infor����
	 * @param t
	 * @return
	 */
	public boolean saveRechargeInforCard(RechargeInfor rcInfor);
	
	
	/**
	 * ���ѳ���ĳ�ֵ����is_available��1-->>0
	 * @param card_id
	 * @return
	 */
	public boolean rechargeCardIsAvailable(String card_id);
	
	/**
	 * ͨ���ֻ�������ѯ���г�ֵ��¼
	 * @param mobile
	 * @return
	 */
	public List<RechargeInfor> rechargeInforList(int currentPage,int pageSize,String mobile);
	
	/**
	 * ��ѯָ���ֻ��ŵļ�¼����
	 * @param mobile
	 * @return
	 */
	public int countRecords(String mobile);
	
	/**
	 *����ָ�����ֻ��Ų�ѯ��ѡ��ҵ����ײ�
	 * @param mobile
	 * @return
	 */
	public List<ReplaceBusiness> findBussiness(String mobile);
	
	/**
	 * ��ѯ����t_mobile_package��t_business_fee���������
	 * @return
	 */
	public List<TBusinessFee> findTBussinessFeeList();
	
	
	/**
	 * �������ҵ����ײ�
	 * @param tmp
	 * @return
	 */
	public boolean savetmobilepackage(TMobilePackage tmp);
	
	
	/**
	 * ����ָ���� �ֻ��� �� businessId ����ѯ��ѡ��ҵ����ײ�
	 * @param mobile
	 * @param business_id
	 * @return
	 */
	
	public ReplaceBusiness findEffectiveAndEndTime(String mobile,String business_id);
	
	
	/**
	 * ����business_id,mobile,status����дȷ��д����ʱ���λ��
	 * @param mobile
	 * @return
	 */
	public String findEndTime(String mobile,String business_id,String status);
	
	/**
	 * ����tel_package_id������ر�ʱ��
	 * @param tel_package_id
	 * @return
	 */
	public boolean saveEndTime(String tel_package_id,String end_time);
	
	/**
	 * Ԥ�����Ѵ�Ǯ
	 * @param selfee
	 * @return
	 */
	public boolean saveAccount(int selfee);
	
	/**
	 * ��ѯ�ƶ���ֵ���ĳ�ֵ���
	 * @param cardId
	 * @return
	 */
	public int findCardCharge(String cardId);
	
	/**
	 * �����ֻ�������ѯ�����
	 * @param mobile
	 * @return
	 */
	public int findAccount(String mobile);
	

}
