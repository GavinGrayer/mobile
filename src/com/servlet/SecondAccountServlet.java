package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.RechargeInfor;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class SecondAccountServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public SecondAccountServlet() {
		super();
		mobileService=new MobileService();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//手机号
		String mobile=request.getParameter("mobile");
		
		//姓名
		String name=request.getParameter("name");
		
		//充值金额
		String tel_charge=request.getParameter("tel_charge");
		
		//实际到帐
		String T4=request.getParameter("T4");
		
		//优惠的金额
		String discount=String.valueOf(Integer.parseInt(T4)-Integer.parseInt(tel_charge));
		
		//银行卡号
		String T2=request.getParameter("T2");
		
		//系统时间
		Date d=new Date();
		int year1=d.getYear()+1900;
		String year=String.valueOf(year1);
		
		int month1=d.getMonth()+1;
		String month=String.valueOf(month1);
		
		int date1=d.getDate();
		String date=String.valueOf(date1);
		
		System.out.println("time2:"+d+":::");
		
		//充值时间
		String time=date.concat("-".concat(month.concat("-".concat(year))));
		
		
		//存钱：剩余话费
		boolean a=mobileService.saveAccount(Integer.parseInt(T4));
		
		if(a){
			System.out.println("在线充值成功");
		}else{
			System.out.println("在线充值失败");
		}
		
		
		System.out.println("当前系统时间是::-->>"+time);
		
		//充值方式编号
		String recharge_type_id="1001";
		
		
		System.out.println("欢迎来到SecondAccountServlet----------------");
		System.out.println("mobile:->"+mobile);
		
		//将所有充值消息封装在rechargeinfor的javabean里
		RechargeInfor rcInfor=new RechargeInfor(mobile,time,recharge_type_id,T2,discount,tel_charge);
		
		//将rcinfor存入T_recharge_infor表中
		boolean result=mobileService.saveRechargeInfor(rcInfor);
		
		System.out.println("result"+result);
		
		//if(result==true){
		request.getRequestDispatcher("/numericalSelection/select_number.jsp").forward(request, response);
		//}else{
			
		//}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
