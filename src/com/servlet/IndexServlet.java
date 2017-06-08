package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.T_customer;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class IndexServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public IndexServlet() {
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
		
		System.out.println("登录---主页间的indexServlet已开启---------------------->>>>>>>>>>>>>>>>>>>>>>");
		String username=request.getParameter("username")==null? "游客123" : request.getParameter("username").trim();
		
		System.out.println("需要通过username查询姓名和手机号来给menu.jsp和head.jsp使用:::"+username);
		
		//根据username查找信息
		T_customer tc=mobileService.uerFindInfor(username);
		
		//姓名
		String name=tc.getCustomer_name();
		String mobile=tc.getTel_numb();
		System.out.println("姓名"+name+"mobile"+mobile);
		
		//获取金额
		int account=mobileService.findAccount(mobile);
		
		
		System.out.println("登录---主页间的indexServlet已结束---------------------->>>>>>>>>>>>>>>>>>>>>>");
		
		HttpSession session=request.getSession();
		
		session.setAttribute("account", account);
		session.setAttribute("name", name);
		session.setAttribute("mobile", mobile);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
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
