package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;



import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;

import com.domain.T_customer;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class RegisterServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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
		
		
		System.out.println("后台验证注册已开启---------------------->>>>>>>>>>>>>>>>>>>>>>.");
		/**
		 * 从register.jsp中取出所有值
		 * --------------------------------------------------
		 */
		String username=request.getParameter("username");


		
		
		System.out.println(username+"+++++++++++++++++++");
		
		String tname=request.getParameter("tname");
		
		tname = new String(tname.getBytes("ISO8859-1"),"utf-8");
		
		
		
		
		String mobile=request.getParameter("mobile");
		
		
		String idcard=request.getParameter("idcard");
		
		String birth=request.getParameter("birth");
		
		SimpleDateFormat sdf = new SimpleDateFormat( "MM-dd-yyyy"); 

		Date birth1=null;
		try {
			birth1 = new Date(sdf.parse(birth).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String pwd=request.getParameter("pwd");
		String regpwd=request.getParameter("regpwd");
		
		
		
		
		/**
		 * 从register.jsp取出所有错误span
		 * ---------------------------------------------------
		 */
		String errUser=request.getParameter("errUser");
		String errName=request.getParameter("errName");
		String errMobile=request.getParameter("errMobile");
		String errIdcard=request.getParameter("errIdcard");
		String errbirth=request.getParameter("errbirth");
		String errpwd=request.getParameter("errpwd");
		String errregpwd=request.getParameter("errregpwd");
		
		
		/**
		 * 存放错误消息
		 * --------------------------------------------------
		 */
		Map<String, String> errMap=new HashMap<String, String>();

		String customer_name = mobileService.RegUserfindPwd(username);

		
		//后台验证username
		if(username == null ||username==""){
			errMap.put("errUser", "用户名不能为空!!!");
			
		}
		//else if(customer_name!=null){
		//	errMap.put("errUser", "该账户已存在!!!");
			
	//	}
		else if(username.length()>20){
			
			errMap.put("errUser", "用户名不能超过20个位!!!");
		}

		//后台验证tname
		if(tname == null ||tname==""){
			errMap.put("errName", "姓名不能为空!!!");
			
		}else if(tname.length()>20){
			errMap.put("errName", "姓名不能超过20个位!!!");

		}
		
		//后台验证mobile
		String regex = "1[3|4|5|8][0-9]{9}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		
		if(mobile == null ||mobile==""){
			errMap.put("errMobile", "手机号不能为空!!!");
			
		}else if(mobile.length()!=11){
			errMap.put("errMobile", "手机号必须11位!!!");
			
		}else if(!m.matches()){
			errMap.put("errMobile", "手机号格式不对!!!");
			
		}
		
		//后台验证idcard
		String regex1 = "[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)";
		Pattern p1 = Pattern.compile(regex1);

		Matcher m1 = p1.matcher(idcard);
		
		if(idcard == null ||idcard==""){
			errMap.put("errIdcard","身份证号不能为空!!!");
			
		}else if(idcard.length()!=18){
			errMap.put("errIdcard","身份证号不是18位!!!");
			
		}else if(!m1.matches()){
			errMap.put("errIdcard","身份证号格式不对!!!");
			
		}
		
		//后台验证birth
		String regex2 = "\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}";
		Pattern p2 = Pattern.compile(regex2);
		Matcher m2 = p2.matcher(birth);
		
		
		if(birth == null ||birth==""){
			errMap.put("errbirth","生日不能为空!!!");

		}else if(!m2.matches()){
			errMap.put("errbirth","生日格式不对!!!");

		}
		
		//后台验证password
		if(pwd == null ||pwd==""){
			errMap.put("errpwd","密码不能为空!!!");
		
		}else if(pwd.length()>20){
			errMap.put("errpwd","密码不能超过20个位!!!");
			
		}
		
		System.out.println("pwd-->"+pwd);
		System.out.println("regpwd-->"+regpwd);
		
		//后台验证regpwd
		if(regpwd == null ||regpwd==""){
			errMap.put("errregpwd","密码不能为空!!!");

		}else if(!regpwd.equals(pwd)){
			errMap.put("errregpwd","密码不一致!!!");

		}
		

		
		//判断是否正确，若正确，则跳转登陆界面，否则返回注册界面
		if(errMap.isEmpty()){
			//保存
				T_customer tc=new T_customer(username,tname,idcard,mobile,birth1,pwd);
				
				boolean judge=mobileService.RegSaveInfor(tc);
				
				if(judge==true){
					
					System.out.println("注册信息保存成功");
					
					System.out.println("跳转-->"+"login.jsp");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else{
					System.out.println("注册信息保存失败");
					System.out.println("错误-->"+"register.jsp");
				request.setAttribute("errMap", errMap);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				}

		}else{
		
			System.out.println("错误-->"+"register.jsp");
		request.setAttribute("errMap", errMap);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		System.out.println("后台验证注册已结束---------------------->>>>>>>>>>>>>>>>>>>>>>.");
	}

}
