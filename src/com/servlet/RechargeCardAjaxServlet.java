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
		
		System.out.println("��ӭ����rechargeCardAjaxServlet::-->>"+cardNum);
		
		
		
		//�жϳ�ֵ���Ƿ����
		//string
		String pwd=mobileService.cardNumFind(cardNum);
		
		System.out.println("=++++++++++++++"+pwd);
		
		String result1="0";//�Ƿ���ڳ�ʼ��
		String result2="3";//�Ƿ����ó�ʼ��
		
		if(pwd!=null){
			result1="1";//���ڣ������ж��Ƿ����
		
		//���ݳ�ֵ��������ѯis_available
		//��װ
		TRechargeCard t=mobileService.cardNumFindInfor(cardNum);
		System.out.println("-----+++++++++++++");
		String is_available=t.getIs_available();
		
		System.out.println("--------------"+is_available);
	
				////��ֵ��״̬  1�������á���0���������á�
				if(is_available.equals("0")){
					
					result2="0";
				}else{
					result2="1";
				}
		}else{
			result1="0";//������
		}
		
		String result=result1.concat(",".concat(result2));
		
		System.out.println("result-->"+result);
		
		out.print("<root><result>"+result+"</result></root>");
	
	}

}
