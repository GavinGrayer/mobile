package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class LoginServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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

		String username=request.getParameter("username") == null? "" : request.getParameter("username");
		String pwd=request.getParameter("pwd")== null? "" : request.getParameter("pwd");
		String userMsg=request.getParameter("userMsg")== null? "" : request.getParameter("userMsg");
		String pwdMsg=request.getParameter("pwdMsg")== null? "" : request.getParameter("pwdMsg");
		
		Map<String, String>errMap=new HashMap<String, String>();
		
		//��̨�˻���֤
		if(username == ""){
			errMap.put("userMsg","�˻�����Ϊ��");

		}else if(username.length() > 20){
			errMap.put("userMsg","�˻����ȱ�����1-20֮��");

		}else{
			errMap.put("userMsg", "");

		}
		
		//��̨������֤
		if(pwd == ""){
			errMap.put("pwdMsg","�˻�����Ϊ��");

		}else if(username.length() > 20){
			errMap.put("pwdMsg","�˻����ȱ�����1-20֮��");

		}else{
			errMap.put("userMsg", "");

		}
		
		request.setAttribute("errMap",errMap);

		request.getRequestDispatcher("/login.jsp").forward(request, response);

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