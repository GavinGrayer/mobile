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
	 * 注册界面查询账户是否存在
	 * @param username
	 * @param sql
	 * @return
	 */
	public String RegUserfindPwd(String username,String sql);
	
	/**
	 * 注册界面查询手机号是否存在
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public String RegMobilefind(String mobile,String sql);
	
	
	/**
	 * 从注册界面保存给数据库
	 * @param tc
	 * @param sql
	 * @return
	 */
	public boolean RegSaveInfor(T_customer tc,String sql);
	
	/**
	 * 登陆界面通过账户查询密码
	 * @param username
	 * @param sql
	 * @return
	 */
	public String LoginUserfindPwd(String username,String sql);
	
	
	/**
	 * 记录手机号总数
	 * 
	 * @param sql
	 * @return
	 */
	public int T_mobileCount(String sql,T_mobile tm);
	
	/**
	 * 
	 * 返回所选页数的手机号
	 * //将所选的传入selcity，seltelfee，selnumb_form，selnumb_type,inputstyle-------
	 * @param currentPage
	 * @param pageSize
	 * @return
	 *
	 */
	public List<T_mobile> mobileList(int currentPage,int pageSize,String sql,T_mobile tm);
	
	
	
	/**
	 * 查询所有套餐
	 * @param sql
	 * @return
	 */
	public List<MobileSetMeal> setmeaList(String sql);
	
	
	/**
	 * 修改mobile的issale为1
	 * 1代表“已售” 0代表“未售”
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public boolean updateIsSale(String mobile,String sql);
	
	/**
	 * 通过username来查询客户信息
	 * @param username
	 * @param sql
	 * @return
	 */
	public T_customer uerFindInfor(String username,String sql);
	
	/**
	 * 通过tel_charge来获取充值优惠discount_amount
	 * @param tel_charge
	 * @param sql
	 * @return
	 */
	public TPreferentialInfor findTel_chargeAndDiscount_amount(String tel_charge,String sql);
	
	
	/**
	 * 保存充值记录
	 * @param rcInfor
	 * @param sql
	 * @return
	 */
	public boolean saveRechargeInfor(RechargeInfor rcInfor,String sql);
	
	
	/**
	 * 通过cardNum来查询充值卡是否存在
	 * @param cardNum
	 * @return
	 */
	public String cardNumFind(String cardNum,String sql);
	
	/**
	 * 通过cardNum来查询充值卡的所有消息
	 * @param cardNum
	 * @param sql
	 * @return
	 */
	public TRechargeCard cardNumFindInfor(String cardNum,String sql);
	
	/**
	 * 将充值卡的充值记录存放在t_recharge_infor表里
	 * @param t
	 * @param sql
	 * @return
	 */
	public boolean saveRechargeInforCard(RechargeInfor rcInfor,String sql);
	
	/**
	 * 通过手机号来查询所有充值记录
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public List<RechargeInfor> rechargeInforList(int begin,int end,String mobile,String sql); 

	/**
	 * 将已冲过的充值卡的is_available由1-->>0
	 * @param card_id
	 * @param sql
	 * @return
	 */
	public boolean rechargeCardIsAvailable(String card_id,String sql);
	
	/**
	 * 查询指定手机号的记录总数
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public int countRecords(String mobile,String sql);
	
	/**
	 * 根据指定的手机号查询已选的业务和套餐
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public List<ReplaceBusiness> findBussiness(String mobile,String sql);
	
	
	/**
	 * 查询所有t_business_fee表里的内容
	 * @param sql
	 * @return
	 */
	public List<TBusinessFee> findTBussinessFeeList(String sql);
	
	/**
	 * 保存办理业务和套餐
	 * @param tmp
	 * @param sql
	 * @return
	 */
	public boolean savetmobilepackage(TMobilePackage tmp,String sql);
	
	
	/**
	 * 根据指定的 手机号 和 businessId 来查询已选的业务和套餐
	 * @param mobile
	 * @param business_id
	 * @param sql
	 * @return
	 */
	public ReplaceBusiness findEffectiveAndEndTime(String mobile,String business_id,String sql);
	
	
	/**
	 * 根据business_id,mobile,status来填写确定写结束时间的位置
	 * @param mobile
	 * @param business_id
	 * @param status
	 * @param sql
	 * @return
	 */
	public String findEndTime(String mobile, String business_id,String status,String sql);
	
	
	/**
	 * 根据tel_package_id来保存关闭时间
	 * @param tel_package_id
	 * @param end_time
	 * @param sql
	 * @return
	 */
	public boolean saveEndTime(String tel_package_id,String end_time,String sql); 
	
	
	/**
	 * 预付话费存钱
	 * @param selfee
	 * @param sql
	 * @return
	 */
	public boolean saveAccount(int selfee,String sql); 
	
	
	/**
	 * 查询制定充值卡的充值金额
	 * @param cardId
	 * @param sql
	 * @return
	 */
	public int findCardCharge(String cardId,String sql); 
	
	
	/**
	 * 根据手机号来查询总余额
	 * @param mobile
	 * @param sql
	 * @return
	 */
	public int findAccount(String mobile,String sql);
}
