package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.TRechargeCard;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class RechargeCardAjaxServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public RechargeCardAjaxServlet() {
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
		
		
		String cardNum=request.getParameter("cardNum");
		
		System.out.println("欢迎来到rechargeCardAjaxServlet::-->>"+cardNum);
		
		
		
		//判断充值卡是否存在
		//string
		String pwd=mobileService.cardNumFind(cardNum);
		
		System.out.println("=++++++++++++++"+pwd);
		
		String result1="0";//是否存在初始化
		String result2="3";//是否能用初始化
		
		if(pwd!=null){
			result1="1";//存在，继续判断是否可用
		
		//根据充值卡号来查询is_available
		//封装
		TRechargeCard t=mobileService.cardNumFindInfor(cardNum);
		System.out.println("-----+++++++++++++");
		String is_available=t.getIs_available();
		
		System.out.println("--------------"+is_available);
	
				////充值卡状态  1：‘可用’；0：‘不可用’
				if(is_available.equals("0")){
					
					result2="0";
				}else{
					result2="1";
				}
		}else{
			result1="0";//不存在
		}
		
		String result=result1.concat(",".concat(result2));
		
		System.out.println("result-->"+result);
		
		out.print("<root><result>"+result+"</result></root>");
	
	}

}
