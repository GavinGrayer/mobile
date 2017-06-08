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
		
		
		System.out.println("��̨��֤ע���ѿ���---------------------->>>>>>>>>>>>>>>>>>>>>>.");
		/**
		 * ��register.jsp��ȡ������ֵ
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
		 * ��register.jspȡ�����д���span
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
		 * ��Ŵ�����Ϣ
		 * --------------------------------------------------
		 */
		Map<String, String> errMap=new HashMap<String, String>();

		String customer_name = mobileService.RegUserfindPwd(username);

		
		//��̨��֤username
		if(username == null ||username==""){
			errMap.put("errUser", "�û�������Ϊ��!!!");
			
		}
		//else if(customer_name!=null){
		//	errMap.put("errUser", "���˻��Ѵ���!!!");
			
	//	}
		else if(username.length()>20){
			
			errMap.put("errUser", "�û������ܳ���20��λ!!!");
		}

		//��̨��֤tname
		if(tname == null ||tname==""){
			errMap.put("errName", "��������Ϊ��!!!");
			
		}else if(tname.length()>20){
			errMap.put("errName", "�������ܳ���20��λ!!!");

		}
		
		//��̨��֤mobile
		String regex = "1[3|4|5|8][0-9]{9}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		
		if(mobile == null ||mobile==""){
			errMap.put("errMobile", "�ֻ��Ų���Ϊ��!!!");
			
		}else if(mobile.length()!=11){
			errMap.put("errMobile", "�ֻ��ű���11λ!!!");
			
		}else if(!m.matches()){
			errMap.put("errMobile", "�ֻ��Ÿ�ʽ����!!!");
			
		}
		
		//��̨��֤idcard
		String regex1 = "[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)";
		Pattern p1 = Pattern.compile(regex1);

		Matcher m1 = p1.matcher(idcard);
		
		if(idcard == null ||idcard==""){
			errMap.put("errIdcard","���֤�Ų���Ϊ��!!!");
			
		}else if(idcard.length()!=18){
			errMap.put("errIdcard","���֤�Ų���18λ!!!");
			
		}else if(!m1.matches()){
			errMap.put("errIdcard","���֤�Ÿ�ʽ����!!!");
			
		}
		
		//��̨��֤birth
		String regex2 = "\\d{4}(\\-|\\/|\\.)\\d{1,2}\\1\\d{1,2}";
		Pattern p2 = Pattern.compile(regex2);
		Matcher m2 = p2.matcher(birth);
		
		
		if(birth == null ||birth==""){
			errMap.put("errbirth","���ղ���Ϊ��!!!");

		}else if(!m2.matches()){
			errMap.put("errbirth","���ո�ʽ����!!!");

		}
		
		//��̨��֤password
		if(pwd == null ||pwd==""){
			errMap.put("errpwd","���벻��Ϊ��!!!");
		
		}else if(pwd.length()>20){
			errMap.put("errpwd","���벻�ܳ���20��λ!!!");
			
		}
		
		System.out.println("pwd-->"+pwd);
		System.out.println("regpwd-->"+regpwd);
		
		//��̨��֤regpwd
		if(regpwd == null ||regpwd==""){
			errMap.put("errregpwd","���벻��Ϊ��!!!");

		}else if(!regpwd.equals(pwd)){
			errMap.put("errregpwd","���벻һ��!!!");

		}
		

		
		//�ж��Ƿ���ȷ������ȷ������ת��½���棬���򷵻�ע�����
		if(errMap.isEmpty()){
			//����
				T_customer tc=new T_customer(username,tname,idcard,mobile,birth1,pwd);
				
				boolean judge=mobileService.RegSaveInfor(tc);
				
				if(judge==true){
					
					System.out.println("ע����Ϣ����ɹ�");
					
					System.out.println("��ת-->"+"login.jsp");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}else{
					System.out.println("ע����Ϣ����ʧ��");
					System.out.println("����-->"+"register.jsp");
				request.setAttribute("errMap", errMap);
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				}

		}else{
		
			System.out.println("����-->"+"register.jsp");
		request.setAttribute("errMap", errMap);
		request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
		System.out.println("��̨��֤ע���ѽ���---------------------->>>>>>>>>>>>>>>>>>>>>>.");
	}

}
