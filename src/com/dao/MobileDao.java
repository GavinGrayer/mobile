package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import sun.net.www.content.audio.aiff;

import com.dao.iface.MobileDaoIface;
import com.db.DbConnectionMgr;
import com.domain.MobileSetMeal;
import com.domain.RechargeInfor;
import com.domain.ReplaceBusiness;
import com.domain.TBusinessFee;
import com.domain.TMobilePackage;
import com.domain.TPreferentialInfor;
import com.domain.TRechargeCard;
import com.domain.T_customer;
import com.domain.T_mobile;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class MobileDao implements MobileDaoIface {
	
	/**
	 * 注册界面查询账户是否存在
	 */
	@Override
	public String RegUserfindPwd(String username, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs = null;
		String customer_name =null;
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				customer_name = rs.getString("customer_name");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		
		return customer_name;
	}

	
	/**
	 *  注册界面查询手机号是否存在
	 */
	@Override
	public String RegMobilefind(String mobile, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs = null;
		String customer_name =null;
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, mobile);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				customer_name = rs.getString("customer_name");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		
		
		return customer_name;
	}


	
	/**
	 * 从注册界面保存给数据库
	 */
	@Override
	public boolean RegSaveInfor(T_customer tc, String sql) {
		// TODO Auto-generated method stub
		boolean result=false;
		int a;
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		

		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, tc.getCustoner_username());
			ps.setString(2, tc.getCustomer_name());
			ps.setString(3, tc.getId_card_numb());
			ps.setString(4, tc.getTel_numb());
			ps.setDate(5, tc.getCustomer_birthday());
			ps.setString(6, tc.getCustomer_pwd());
			
			a = ps.executeUpdate();
			
			if(a>0){
				
				result=true;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		
		return result;
	}


	
	
	@Override
	public String LoginUserfindPwd(String username, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs = null;
		String customer_pwd =null;
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				customer_pwd = rs.getString("customer_pwd");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		
		return customer_pwd;
	}


	/**
	 * 记录手机号总数
	 */
	@Override
	public int T_mobileCount(String sql,T_mobile tm) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		
		String selcity=tm.getTel_add();

		
		String seltelfee=tm.getAcc_init_amount();
		
		
		
		String selnumb_form=tm.getTel_numb();
		String selnumb_type=tm.getTel_type();
		String inputstyle=tm.getInput_tel();
		
		try {
			ps=conn.prepareStatement(sql);
		
			
			ps.setString(1, "%"+selcity+"%");
			ps.setString(2, "%"+seltelfee+"%");
			ps.setString(3, "%"+selnumb_form+"%");
			ps.setString(4, "%"+selnumb_type+"%");
			ps.setString(5, "%"+inputstyle+"%");
			
			rs=ps.executeQuery();
			if(rs.next()){
				
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		
		return count;
	}

	
	/**
	 * 
	 * 返回所选页数的手机号
	 * //将所选的传入selcity，seltelfee，selnumb_form，selnumb_type,inputstyle-------
	 */
	@Override
	public List<T_mobile> mobileList(int begin, int end, String sql,T_mobile tm) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<T_mobile> mobiList=new ArrayList<T_mobile>();
		
		String selcity=tm.getTel_add();

		
		String seltelfee=tm.getAcc_init_amount();
		
		
		
		String selnumb_form=tm.getTel_numb();
		String selnumb_type=tm.getTel_type();
		String inputstyle=tm.getInput_tel();
		
		System.out.println(selcity);
		System.out.println(seltelfee);
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, "%"+selcity+"%");
			ps.setString(2, "%"+seltelfee);
			ps.setString(3, selnumb_form+"%");
			ps.setString(4, "%"+selnumb_type+"%");
			ps.setString(5, "%"+inputstyle+"%");
			ps.setInt(6, begin);
			ps.setInt(7, end);
			System.out.println("========");
			System.out.println("Dao里的selnumb_form:::--->>>"+selnumb_form);
			System.out.println("inputstyle:::--->>>"+inputstyle);
			rs=ps.executeQuery();
			
			System.out.println("Dao查询");
			while(rs.next()){
				
				String tel_numb=rs.getString("tel_numb");
				String tel_add=rs.getString("tel_add");
				String acc_init_amount=rs.getString("acc_init_amount");
				System.out.println(tel_numb+"------");
				
				T_mobile tm1=new T_mobile(tel_numb,tel_add,acc_init_amount);
				System.out.println(tel_numb+"-----++++++++++------");
				
				mobiList.add(tm1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		
		
		return mobiList;
	}


	/**
	 * 查询所有套餐
	 * @param sql
	 * @return
	 */
	@Override
	public List<MobileSetMeal> setmeaList(String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<MobileSetMeal> setmeaList=new ArrayList<MobileSetMeal>();
		String flag=null;
		//String flag2=null;
		
		int count=1;
		
		try {
			ps = conn.prepareStatement(sql);

			rs=ps.executeQuery();
			
			while(rs.next()){
				String pp_id=rs.getString("pp_id");
				String business_id=rs.getString("business_id");
				String pp_name=rs.getString("pp_name");
				String pp_fee=rs.getString("pp_fee");
				String business_name=rs.getString("business_name");
				
				System.out.println(pp_name+"---------");
				System.out.println("count::::--->>>"+count);
				if(count%2!=0){
					flag=business_name;//基数存流量
					System.out.println("单次存的"+flag);
					count++;
				}else{
					System.out.println("双次存的"+business_name);
					MobileSetMeal msm=new MobileSetMeal(pp_id,business_id,pp_name,pp_fee,business_name,flag);
					setmeaList.add(msm);
					count++;
					//flag=business_name;//偶数存话费
				}

				//MobileSetMeal msm=new MobileSetMeal(pp_name,pp_fee,business_name);
					
					
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
	
		
		
		return setmeaList;
	}


	@Override
	public boolean updateIsSale(String mobile, String sql) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
		
			ps.setString(1, mobile);
			
			int i=ps.executeUpdate();
			
			if(i>0){
				result=true;
			}else{
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		return result;
	}

	
	/**
	 * 通过username来查询客户信息
	 */
	@Override
	public T_customer uerFindInfor(String username, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		T_customer tc=null;
	
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs=ps.executeQuery();
		
			
			while(rs.next()){
				
				String customer_name=rs.getString("customer_name");
				String tel_numb=rs.getString("tel_numb");
				String id_card_numb=rs.getString("id_card_numb");
				Date customer_birthday=rs.getDate("customer_birthday");
				String customer_pwd=rs.getString("customer_pwd");
				
				tc=new T_customer(customer_name,id_card_numb,tel_numb,customer_birthday,customer_pwd); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return tc;
	}

	/**
	 * 通过tel_charge来获取充值优惠discount_amount
	 * @param tel_charge
	 * @param sql
	 * @return
	 */
	@Override
	public TPreferentialInfor findTel_chargeAndDiscount_amount(String tel_charge, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		String discount_amount=null;
		String preferential_name=null;
		ResultSet rs=null;
		TPreferentialInfor t=null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, tel_charge);
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				
				discount_amount=rs.getString("discount_amount");
				preferential_name=rs.getString("preferential_name");
				
				t=new TPreferentialInfor(discount_amount,preferential_name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		
		return t;
	}



	/**
	 * 保存充值记录
	 */
	@Override
	public boolean saveRechargeInfor(RechargeInfor rcInfor, String sql) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		
		
		
		try {
			ps=conn.prepareStatement(sql);
		//recharge_infor_id,tel_numb,recharge_time,Recharge_type_id,bank_card_numb,discount_amount,recharge_money
			String Tel_numb = rcInfor.getTel_numb();
			String Recharge_time=rcInfor.getRecharge_time();


			

			
			String Recharge_type_id=rcInfor.getRecharge_type_id();
			String Bank_card_numb=rcInfor.getBank_card_numb();
			String Discount_amout=rcInfor.getDiscount_amout();
			String Recharge_money=rcInfor.getRecharge_money();
			
			System.out.println(Tel_numb+":::"+Recharge_time+":::"+Recharge_type_id+":::"+Bank_card_numb+":::"+Discount_amout);
			
			ps.setString(1, Tel_numb);
			ps.setString(2, Recharge_time);
			ps.setString(3, Recharge_type_id);
			ps.setString(4, Bank_card_numb);
			ps.setString(5, Discount_amout);
			ps.setString(6, Recharge_money);
			
			int i=ps.executeUpdate();
			
			if(i>0){
				result=true;
			}else{
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		return result;
	}


	
	/**
	 * 通过cardNum来查询充值卡是否存在
	 * @param cardNum
	 * @return
	 */
	@Override
	public String cardNumFind(String cardNum, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs = null;
		String card_pwd =null;
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, cardNum);
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				
				card_pwd = rs.getString("card_pwd");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		
		return card_pwd;
	}

	/**
	 * 
	 * 通过cardNum来查询充值卡的所有消息
	 */
	@Override
	public TRechargeCard cardNumFindInfor(String cardNum, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		TRechargeCard t=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, cardNum);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				String card_id=rs.getString("card_id");
				String card_pwd=rs.getString("card_pwd");
				String card_charge=rs.getString("card_charge");
				String is_available=rs.getString("is_available");
				
				t=new TRechargeCard(card_id,card_pwd,card_charge,is_available);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return t;
	}
	



	/**
	 * 将充值卡的充值记录存放在t_recharge_infor表里
	 */
	@Override
	public boolean saveRechargeInforCard(RechargeInfor rcInfor, String sql) {
		// TODO Auto-generated method stub
boolean result=false;
		
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		
		
		
		try {
			ps=conn.prepareStatement(sql);
		//recharge_infor_id,tel_numb,recharge_time,Recharge_type_id,card_id,discount_amount,recharge_money
			String Tel_numb = rcInfor.getTel_numb();
			String Recharge_time=rcInfor.getRecharge_time();

			String Recharge_type_id=rcInfor.getRecharge_type_id();
			String card_id=rcInfor.getCard_id();
			String Discount_amout=rcInfor.getDiscount_amout();
			String Recharge_money=rcInfor.getRecharge_money();
			
			System.out.println(Tel_numb+":::"+Recharge_time+":::"+Recharge_type_id+":::"+card_id+":::"+Discount_amout);
			
			ps.setString(1, Tel_numb);
			ps.setString(2, Recharge_time);
			ps.setString(3, Recharge_type_id);
			ps.setString(4, card_id);
			ps.setString(5, Discount_amout);
			ps.setString(6, Recharge_money);
			
			int i=ps.executeUpdate();
			
			if(i>0){
				result=true;
			}else{
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		return result;
	}

	/**
	 * 通过手机号来查询所有充值记录
	 */
	@Override
	public List<RechargeInfor> rechargeInforList(int begin,int end,String mobile, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<RechargeInfor> rechargeInforList=new ArrayList<RechargeInfor>();
		
		int money_count=0;//总的充值金额
		int bc_count=0;//银行卡充值次数
		int card_count=0;//充值卡次数
		int discount_count=0;//优惠总金额
		
		
		RechargeInfor rcInfor=null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, mobile);
			ps.setInt(2, begin);
			ps.setInt(3, end);
			rs=ps.executeQuery();
			
			while(rs.next()){
				String tel_numb=rs.getString("TEL_NUMB");
				
				Date recharge_time=rs.getDate("recharge_time");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date=new java.util.Date();
				String recharge_time1=sdf.format(recharge_time);
				
				
				System.out.println(recharge_time1+"---------");
				
				String recharge_type_id=rs.getString("recharge_type_id");
				System.out.println("-----------");
				String card_id=rs.getString("card_id");
				String bank_card_numb=rs.getString("bank_card_numb");
				String discount_amout=rs.getString("discount_amount");
				String recharge_money=rs.getString("recharge_money");
				
				
				
				money_count=money_count+Integer.parseInt(recharge_money);
				
				System.out.println("//总的充值金额"+money_count);
				
				
				discount_count=discount_count+Integer.parseInt(discount_amout);
				System.out.println("//优惠总金额"+discount_count);
				
				
				if(bank_card_numb!=null){
					bc_count++;
				}
				System.out.println("//银行卡充值次数"+bc_count);
				if(card_id!=null){
					card_count++;
				}
				System.out.println("//充值卡次数"+card_count);
				
				if(bank_card_numb==null){
					bank_card_numb="--";
				}
				if(card_id==null){
					card_id="--";
				}

					rcInfor=new RechargeInfor(tel_numb,recharge_time1,recharge_type_id,card_id,bank_card_numb,discount_amout,recharge_money,money_count,bc_count,card_count,discount_count);

				rechargeInforList.add(rcInfor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rechargeInforList;
	}

//	public static void main(String[] args) {
//		MobileDao md=new MobileDao();
//		String sql="select * from ( select a.*,rownum r from "
//			+" ( select tel_numb,recharge_time,recharge_type_id, "
//			+" card_id,bank_card_numb,discount_amount,recharge_money,rownum "
//			+" from t_recharge_infor where tel_numb = ? "
//			+" order by tel_numb desc ) a ) "+" where r between ? and ? ";
//		
//		List<RechargeInfor> aList=md.rechargeInforList(1, 4, "13456375432", sql);
//		for(RechargeInfor r: aList){
//			System.out.println(r.getRecharge_time());
//		}
//	}

	
	/**
	 * 将已冲过的充值卡的is_available由1-->>0
	 */
	@Override
	public boolean rechargeCardIsAvailable(String card_id, String sql) {
		// TODO Auto-generated method stub
boolean result=false;
		
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
		
			ps.setString(1, card_id);
			
			int i=ps.executeUpdate();
			
			if(i>0){
				result=true;
			}else{
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		return result;
	}

	
	/**
	 * 查询指定手机号的记录总数
	 */
	@Override
	public int countRecords(String mobile, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, mobile);
			rs=ps.executeQuery();
			
			if(rs.next()){
				count=rs.getInt(1);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		return count;
	}
	
	
//	public static void main(String[] args) {
//		MobileDao md=new MobileDao();
//		String sql="select * from ( select a.*,rownum r from "
//			+" ( select tel_numb,recharge_time,recharge_type_id, "
//			+" card_id,bank_card_numb,discount_amount,recharge_money,rownum "
//			+" from t_recharge_infor where tel_numb = ? "
//			+" order by tel_numb desc ) a ) "+" where r between ? and ? ";
//		
//		
//			
//		 List<RechargeInfor> a=md.rechargeInforList(1, 4, "13213213211", sql);
//		
//		 for(RechargeInfor aInfor : a){
//		 System.out.println(aInfor.getCard_id());
//		 }
//	}

	/**
	 * 根据指定的手机号查询已选的业务和套餐
	 */
	@Override
	public List<ReplaceBusiness> findBussiness(String mobile, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ReplaceBusiness> replaceBusinessList=new ArrayList<ReplaceBusiness>();
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, mobile);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				String tel_numb=rs.getString("tel_numb");
				Date start_time1=rs.getDate("start_time");
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date=new java.util.Date();
				//String start_time=sdf.format(start_time1);
				
				String start_time=null;
				if(start_time1!=null){
					
					start_time=sdf.format(start_time1);
				}else{
					start_time="--";
				}
				
				
				Date end_time1=rs.getDate("end_time");
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1=new java.util.Date();
				//String end_time=sdf.format(end_time1);
				
				String end_time=null;
				if(end_time1!=null){
					
					end_time=sdf.format(end_time1);
				}else{
					end_time="--";
				}
				
				System.out.println("DAO中修改后的end_time"+end_time+"::::end_time1"+end_time1);
				
				String business_id=rs.getString("business_id");
				String business_name=rs.getString("business_name");
				String short_name=rs.getString("short_name");
				//String pp_name=rs.getString("pp_name");
				//String pp_fee=rs.getString("pp_fee");
				
				
				
				
				ReplaceBusiness rb=new ReplaceBusiness(business_id,tel_numb,start_time,end_time,business_name,short_name,null,null);
			
				replaceBusinessList.add(rb);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return replaceBusinessList;
	}

	
//	public static void main(String[] args) {
//		MobileDao md=new MobileDao();
//		
//		String sql=" SELECT tel_numb,start_time,t3.business_id,t3.pp_id,t2.end_time,business_name,short_name,pp_name,pp_fee "
//			+" FROM t_phone_package t1,t_business_fee t2,t_mobile_package t3 "
//			+" WHERE t1.pp_id=t3.pp_id AND t3.business_id=t2.business_id AND tel_numb = ? ";
//		
//
//		List<ReplaceBusiness> a=md.findBussiness("13456375432", sql);
//		for(ReplaceBusiness r:a){
//			System.out.println("aaaaaa"+r.getStart_time());
//		}
//	}
	
	
	/**
	 * 查询所有t_business_fee表里的内容
	 * @param sql
	 * @return
	 */
	@Override
	public List<TBusinessFee> findTBussinessFeeList(String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps;
		ResultSet rs=null;
		List<TBusinessFee> findBusinessFeeList=new ArrayList<TBusinessFee>();
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				String business_id=rs.getString("business_id");
				String business_name=rs.getString("business_name");
				String short_name=rs.getString("short_name");
				String business_charge=rs.getString("business_charge");
				String is_optional=rs.getString("is_optional");
				String is_largess=rs.getString("is_largess");
				
				//System.out.println("--------===========-----------");
				Date effective_time1=rs.getDate("effective_time");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				//java.util.Date date1=new java.util.Date();
				String effective_time=null;
				if(effective_time1!=null){
					
					effective_time=sdf.format(effective_time1);
				}else{
					effective_time="--";
				}
				
				
				Date end_time1=rs.getDate("end_time");
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				//java.util.Date date=new java.util.Date();
				String end_time=null;
				if(end_time1!=null){
					
					end_time=sdf.format(end_time1);
				}else{
					end_time="--";
				}
				if(is_largess==null){
					business_charge=business_charge.concat("元");
				}else if(is_largess.equals("1")){
					business_charge="套餐内业务";
					
				}else if(is_largess.equals("0")){
					business_charge="基础业务";
				}
				
				
				
					TBusinessFee tbf=new TBusinessFee(business_id,business_name,short_name,business_charge,is_optional,is_largess,effective_time,end_time);
				
				findBusinessFeeList.add(tbf);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return findBusinessFeeList;
	}


	
	/**
	 * 保存办理业务和套餐
	 * @param tmp
	 * @param sql
	 * @return
	 */
	@Override
	public boolean savetmobilepackage(TMobilePackage tmp, String sql) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		
		
		
		try {
			ps=conn.prepareStatement(sql);
			String Tel_numb=tmp.getTel_numb();
			String Business_id=tmp.getBusiness_id();
			String pp_id=tmp.getPp_id();
			String Start_time =tmp.getStart_time();
			String End_time=tmp.getEnd_time();
			String status=tmp.getStatus();
			
			ps.setString(1, Tel_numb);
			System.out.println("------------");
			ps.setString(2, Business_id);
			ps.setString(3, pp_id);
			ps.setString(4, Start_time);
			ps.setString(5, End_time);
			ps.setString(6, status);
			
			int i=ps.executeUpdate();
			
			if(i>0){
				result=true;
			}else{
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		return result;
	}


	
	/**
	 * 根据指定的 手机号 和 businessId 来查询已选的业务和套餐
	 * @param mobile
	 * @param business_id
	 * @param sql
	 * @return
	 */
	@Override
	public ReplaceBusiness findEffectiveAndEndTime(String mobile,
			String business_id, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		ReplaceBusiness rb=new ReplaceBusiness();
	
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, mobile);
			ps.setString(2, business_id);
			
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				String tel_numb=rs.getString("tel_numb");
				Date start_time1=rs.getDate("start_time");
				
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date=new java.util.Date();
				//String start_time=sdf.format(start_time1);
				
				String start_time=null;
				if(start_time1!=null){
					
					start_time=sdf.format(start_time1);
				}else{
					start_time="--";
				}
				
				
				Date end_time1=rs.getDate("end_time");
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1=new java.util.Date();
				//String end_time=sdf.format(end_time1);
				
				String end_time=null;
				if(end_time!=null){
					
					end_time=sdf.format(end_time1);
				}else{
					end_time="--";
				}
				
				String business_id1=rs.getString("business_id");

				String pp_id=rs.getString("pp_id");

				
				
				
				
				rb=new ReplaceBusiness(business_id1,tel_numb,start_time,end_time,null,null,null,null,pp_id);
			
				
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rb;
	}

	
	
	/**
	 * 根据business_id,mobile,status来填写确定写结束时间的位置
	 * @param mobile
	 * @param business_id
	 * @param status
	 * @param sql
	 * @return
	 */
	@Override
	public String findEndTime(String mobile, String business_id,String status, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String tel_package_id="";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, business_id);
			ps.setString(2, mobile);
			ps.setString(3, status);
			rs=ps.executeQuery();
			System.out.println("---------Dao-----------");
			if(rs.next()){
				tel_package_id=rs.getString("tel_package_id");

				System.out.println("dao里的tel_package_id>>>>>>"+tel_package_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		return tel_package_id;
	}


	
	/**
	 * 根据tel_package_id来保存关闭时间
	 * @param tel_package_id
	 * @param end_time
	 * @param sql
	 * @return
	 */
	@Override
	public boolean saveEndTime(String tel_package_id, String end_time,
			String sql) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		try {

			ps=conn.prepareStatement(sql);
			ps.setString(1, end_time);
			
			ps.setString(2, tel_package_id);
			
			

			int i=ps.executeUpdate();
			
			conn.commit();
			
			System.out.println("i>>>>"+i);
			
			if(i>0){
				result=true;
			}else{
				result=false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		MobileDao md=new MobileDao();
		String sql=" update t_mobile_package set end_time = to_date(?,'DD-MM-YYYY') where tel_package_id = ? ";
		
		
		
		md.saveEndTime("1116", "22-11-2016", sql);
	}

	
	/**
	 * 预付话费存钱
	 * @param selfee
	 * @param sql
	 * @return
	 */

	@Override
	public boolean saveAccount(int selfee, String sql) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
		
			ps.setInt(1, selfee);
			
			int i=ps.executeUpdate();
			
			if(i>0){
				result=true;
			}else{
				result=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, null);
		}
		
		
		return result;
	}


	
	/**
	 * 查询制定充值卡的充值金额
	 * @param cardId
	 * @param sql
	 * @return
	 */
	@Override
	public int findCardCharge(String cardId, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int card_charge=0;
		try {
			ps=conn.prepareStatement(sql);
		
			ps.setString(1, cardId);
			rs=ps.executeQuery();
			
			if(rs.next()){
				card_charge=rs.getInt("card_charge");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbConnectionMgr.close(conn, ps, rs);
		}
		
		
		return card_charge;
	}


	
	/**
	 * 根据手机号来查询总余额
	 * @param mobile
	 * @param sql
	 * @return
	 */
	@Override
	public int findAccount(String mobile, String sql) {
		// TODO Auto-generated method stub
		Connection conn=DbConnectionMgr.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int account=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mobile);
			rs=ps.executeQuery();
			
			if(rs.next()){
				account=rs.getInt("account_balance");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return account;
	}

}
