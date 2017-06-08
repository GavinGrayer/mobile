package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.TMobilePackage;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class AccountServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public AccountServlet() {
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

		this.doPost(request, response);
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
		
		String mobile=request.getParameter("mobile");
		String business_id=request.getParameter("business_id");
		String pp_id=request.getParameter("pp_id");
		
		//把钱存起来--------11.22
		String selfee=request.getParameter("selfee");
		
		boolean result2=mobileService.saveAccount(Integer.parseInt(selfee));
		
		if(result2){
			System.out.println("预支话费已存入成功");
		}else{
			System.out.println("预支话费存入失败");
		}
		
		System.out.println("传来的手机号用来改issale"+mobile);
		
		
		//将已购买的手机号的issale改成1
		boolean result=mobileService.updateIsSale(mobile);
		
		if(result){
			
			System.out.println("已售:::-->>is_sale:1");
			
		}else{
			
			System.out.println("未售:::-->>is_sale:0");
		}
		
		
		//系统时间
		Date d=new Date();
		int year1=d.getYear()+1900;
		String year=String.valueOf(year1);
		
		int month1=d.getMonth()+1;
		String month=String.valueOf(month1);
		
		int date1=d.getDate();
		String date=String.valueOf(date1);
		
		System.out.println("time2:"+d+":::");
		
		//开通时间-----------3
		String time=date.concat("-".concat(month.concat("-".concat(year))));

		System.out.println("当前系统时间是::-->>"+time);
		
		
		
		
		//将mobile和指定的套餐放入t_mobile_package表中
		//手机号，开始时间，pp_id,business_id封装在TMobilePackage
		TMobilePackage tmp=new TMobilePackage(mobile,business_id,pp_id,time,null,null);
		
		boolean result1=mobileService.savetmobilepackage(tmp);
		
		System.out.println("result1::-->>保存套餐成功为true::-->>"+result1);
		request.getRequestDispatcher("/numericalSelection/select_number.jsp").forward(request, response);
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
