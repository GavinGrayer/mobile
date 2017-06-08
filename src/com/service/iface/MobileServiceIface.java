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
	 * 注册界面查询账户是否存在
	 * @param username
	 * @return
	 */
	public String RegUserfindPwd(String username);
	
	
	
	/**
	 * 注册界面查询手机号是否存在
	 * @param mobile
	 * @return
	 */
	public String RegMobilefind(String mobile);
	
	
	/**
	 * 从注册界面保存给数据库
	 * @param tc
	 * @return
	 */
	public boolean RegSaveInfor(T_customer tc);
	
	/**
	 * 登陆界面通过账户查询密码
	 * @param username
	 * @return
	 */
	public String LoginUserfindPwd(String username);
	
	/**
	 * 记录手机号总数
	 * @param tm
	 * @return
	 */
	public int T_mobileCount(T_mobile tm);
	
	/**
	 * 返回所选页数的手机号
	 * //将所选的传入selcity，seltelfee，selnumb_form，selnumb_type,inputstyle-------
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public List<T_mobile> mobileList(int currentPage,int pageSize,T_mobile tm);
	
	
	/**
	 * 查询所有套餐
	 * @return
	 */
	public List<MobileSetMeal> setmeaList();
	
	
	/**
	 * 修改mobile的issale为1
	 * 1代表“已售” 0代表“未售”
	 * @param mobile
	 * @return
	 */
	public boolean updateIsSale(String mobile);
	
	
	/**
	 * 通过username来查询客户信息
	 * @param username
	 * @return
	 */
	public T_customer uerFindInfor(String username);
	
	/**
	 * 通过tel_charge来获取充值优惠discount_amount
	 * @param tel_charge
	 * @return
	 */
	public TPreferentialInfor findTel_chargeAndDiscount_amount(String tel_charge);
	
	
	/**
	 * 保存充值记录
	 * @param rcInfor
	 * @return
	 */
	public boolean saveRechargeInfor(RechargeInfor rcInfor);
	
	/**
	 * 通过cardNum来查询充值卡是否存在
	 * @param cardNum
	 * @return
	 */
	public String cardNumFind(String cardNum);
	
	/**
	 * 通过cardNum来查询充值卡的所有消息
	 * @param cardNum
	 * @return
	 */
	public TRechargeCard cardNumFindInfor(String cardNum);
	
	/**
	 * 将充值卡的充值记录存放在t_recharge_infor表里
	 * @param t
	 * @return
	 */
	public boolean saveRechargeInforCard(RechargeInfor rcInfor);
	
	
	/**
	 * 将已冲过的充值卡的is_available由1-->>0
	 * @param card_id
	 * @return
	 */
	public boolean rechargeCardIsAvailable(String card_id);
	
	/**
	 * 通过手机号来查询所有充值记录
	 * @param mobile
	 * @return
	 */
	public List<RechargeInfor> rechargeInforList(int currentPage,int pageSize,String mobile);
	
	/**
	 * 查询指定手机号的记录总数
	 * @param mobile
	 * @return
	 */
	public int countRecords(String mobile);
	
	/**
	 *根据指定的手机号查询已选的业务和套餐
	 * @param mobile
	 * @return
	 */
	public List<ReplaceBusiness> findBussiness(String mobile);
	
	/**
	 * 查询所有t_mobile_package和t_business_fee表里的内容
	 * @return
	 */
	public List<TBusinessFee> findTBussinessFeeList();
	
	
	/**
	 * 保存办理业务和套餐
	 * @param tmp
	 * @return
	 */
	public boolean savetmobilepackage(TMobilePackage tmp);
	
	
	/**
	 * 根据指定的 手机号 和 businessId 来查询已选的业务和套餐
	 * @param mobile
	 * @param business_id
	 * @return
	 */
	
	public ReplaceBusiness findEffectiveAndEndTime(String mobile,String business_id);
	
	
	/**
	 * 根据business_id,mobile,status来填写确定写结束时间的位置
	 * @param mobile
	 * @return
	 */
	public String findEndTime(String mobile,String business_id,String status);
	
	/**
	 * 根据tel_package_id来保存关闭时间
	 * @param tel_package_id
	 * @return
	 */
	public boolean saveEndTime(String tel_package_id,String end_time);
	
	/**
	 * 预付话费存钱
	 * @param selfee
	 * @return
	 */
	public boolean saveAccount(int selfee);
	
	/**
	 * 查询制定充值卡的充值金额
	 * @param cardId
	 * @return
	 */
	public int findCardCharge(String cardId);
	
	/**
	 * 根据手机号来查询总余额
	 * @param mobile
	 * @return
	 */
	public int findAccount(String mobile);
	

}
