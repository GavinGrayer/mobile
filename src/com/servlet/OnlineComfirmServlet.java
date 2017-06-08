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

public class OnlineComfirmServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public OnlineComfirmServlet() {
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

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//�ֻ�����
		String mobile=request.getParameter("T3");
		//��ֵ�Ż�
		String discount=request.getParameter("discount");
		//ʵ�ʵ���
		String T4=request.getParameter("T4");
		
		System.out.println("��ӭ����online_comfirm��servlet:::--->>>"+mobile);
		
		
		
		//ͨ���ֻ���������
		String name=mobileService.RegMobilefind(mobile);
		System.out.println("name::-->>>"+name);
		//ͨ���Ż����ײ�����
		
		//�����tel_charge
		String tel_charge=String.valueOf(Integer.parseInt(T4)-Integer.parseInt(discount));
		
		TPreferentialInfor t=mobileService.findTel_chargeAndDiscount_amount(tel_charge);
		
		String preferential_name=t.getPreferential_name();
		
		request.setAttribute("T4", T4);
		request.setAttribute("tel_charge", tel_charge);
		request.setAttribute("name", name);
		request.setAttribute("preferential_name", preferential_name);
		request.setAttribute("mobile", mobile);
		request.getRequestDispatcher("/recharge_style/online_comfirm.jsp").forward(request, response);
		
		
		
	}

}
