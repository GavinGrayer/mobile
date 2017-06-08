package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.TBusinessFee;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;
import com.sun.xml.internal.bind.v2.model.core.ID;

public class BusinessOpenCloseServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public BusinessOpenCloseServlet() {
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
		
		System.out.println("------��ӭ����open close--------");
		
		String status=request.getParameter("status");
		String judge=null;
		System.out.println("status"+status+":::judge::"+judge);
		//status  1:��ͨ   0���ر�
//		if(status.equals("1")){
//			
//			judge="��ͨ";
//		}else{
//			judge="�ر�";
//		}
		
		
		
		
		
		
		//��ѯ����t_business_fee���������
		//��ѯ����t_business_fee��Ķ�������list����
		List<TBusinessFee> findBusinessFeeList=mobileService.findTBussinessFeeList();
		
		request.setAttribute("findBusinessFeeList", findBusinessFeeList);
		
		request.getRequestDispatcher("/business/replacement_business.jsp").forward(request, response);
		
	}

}
