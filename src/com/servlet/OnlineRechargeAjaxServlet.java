package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.TPreferentialInfor;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class OnlineRechargeAjaxServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public OnlineRechargeAjaxServlet() {
		super();
		mobileService=new MobileService();
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

		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String tel_charge=request.getParameter("tel_charge");
		
		System.out.println("通过充值金额来获取充值优惠tel_charge:::--->>>"+tel_charge);
		
		//通过tel_charge来获取充值优惠discount_amount
		TPreferentialInfor t=mobileService.findTel_chargeAndDiscount_amount(tel_charge);
		
		String result1=t.getDiscount_amount();
		
		//String preferential_name=t.getPreferential_name();
		
		System.out.println("从数据库得来的tel_charge::-->>"+result1);
		String result=null;
		
		
		
		
		
		//根据充值金额返回相应的result优惠金额
		
		if(result1.equals("2")){
			
			result=tel_charge.concat(",".concat(result1));
			
		}else if(result1.equals("8")){
			
			result=tel_charge.concat(",".concat(result1));
			
		}else if(result1.equals("15")){
			
			result=tel_charge.concat(",".concat(result1));
			
		}else if(result1.equals("30")){
			
			result=tel_charge.concat(",".concat(result1));			
			
		}else if(result1.equals("200")){
			
			result=tel_charge.concat(",".concat(result1));
		}else if(result1.equals("50")){
			
			result=tel_charge.concat(",".concat(result1));
			
		}else if(result1.equals("80")){
			
			result=result1;
		}else{
			result="请选择";
		}
		
		
		
		
		out.print("<root><result>"+result+"</result></root>");
	}

}
