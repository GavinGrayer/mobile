package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class RechargeCardMobileServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public RechargeCardMobileServlet() {
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
		
		System.out.println("Ajax��֤----�ֻ����ѿ���----------------------->>>>>>>>>>>>>>>>>>>");
		
		String mobile=request.getParameter("mobile");
		System.out.println("+++++mobile::-->"+mobile);
	
		//д�����ж��Ƿ�
		String customer_name = mobileService.RegMobilefind(mobile);
		
		
		System.out.println("����username�ֻ���ȡ��������--��Ϊ�գ������ע��>"+customer_name);
		
		
		String result = "false";
		
		if(customer_name==null){
			
			result = "true";
			System.out.println("------>>>>>>");
		}
		System.out.println("result-->"+result);
		
		//out.print(result);
		out.print("<root><result>"+result+"</result></root>");
	}

}
