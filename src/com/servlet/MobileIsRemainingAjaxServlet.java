package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class MobileIsRemainingAjaxServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public MobileIsRemainingAjaxServlet() {
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

		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();

		System.out.println("Ajax验证----手机号已开启----------------------->>>>>>>>>>>>>>>>>>>");
		
		String mobile=request.getParameter("mobile")==null ? "" : request.getParameter("mobile");
		System.out.println("+++++mobile::-->"+mobile);
	
		//写方法
		String customer_name = mobileService.RegMobilefind(mobile);
		
		
		System.out.println("根据username手机号取出的姓名--若为空，则可以注册>"+customer_name);
		
		
		String result = "false";
		
		if(customer_name==null){
			
			result = "true";
			System.out.println("------>>>>>>");
		}
		
		System.out.println("result-->"+result);
		System.out.println("Ajax验证----手机号----------结束------------>>>>>>>>>>>>>>>>>>>");
		
		//out.print(result);
		out.print("<root><result>"+result+"</result></root>");
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
