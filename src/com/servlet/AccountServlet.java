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
		
		//��Ǯ������--------11.22
		String selfee=request.getParameter("selfee");
		
		boolean result2=mobileService.saveAccount(Integer.parseInt(selfee));
		
		if(result2){
			System.out.println("Ԥ֧�����Ѵ���ɹ�");
		}else{
			System.out.println("Ԥ֧���Ѵ���ʧ��");
		}
		
		System.out.println("�������ֻ���������issale"+mobile);
		
		
		//���ѹ�����ֻ��ŵ�issale�ĳ�1
		boolean result=mobileService.updateIsSale(mobile);
		
		if(result){
			
			System.out.println("����:::-->>is_sale:1");
			
		}else{
			
			System.out.println("δ��:::-->>is_sale:0");
		}
		
		
		//ϵͳʱ��
		Date d=new Date();
		int year1=d.getYear()+1900;
		String year=String.valueOf(year1);
		
		int month1=d.getMonth()+1;
		String month=String.valueOf(month1);
		
		int date1=d.getDate();
		String date=String.valueOf(date1);
		
		System.out.println("time2:"+d+":::");
		
		//��ͨʱ��-----------3
		String time=date.concat("-".concat(month.concat("-".concat(year))));

		System.out.println("��ǰϵͳʱ����::-->>"+time);
		
		
		
		
		//��mobile��ָ�����ײͷ���t_mobile_package����
		//�ֻ��ţ���ʼʱ�䣬pp_id,business_id��װ��TMobilePackage
		TMobilePackage tmp=new TMobilePackage(mobile,business_id,pp_id,time,null,null);
		
		boolean result1=mobileService.savetmobilepackage(tmp);
		
		System.out.println("result1::-->>�����ײͳɹ�Ϊtrue::-->>"+result1);
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
