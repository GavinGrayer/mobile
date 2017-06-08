package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.RechargeInfor;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class RecordServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public RecordServlet() {
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
		
		String name=request.getParameter("name")==null ? "" : request.getParameter("name");
		name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		
		String mobile=request.getParameter("mobile") ==null ? "" : request.getParameter("mobile");
		
		
		
		System.out.println("name::-->>"+name+":::--mobile::-->>"+mobile);
		
//		if(mobile.equals("")){
//			request.getRequestDispatcher("/loginerror.jsp").forward(request, response);
//		}else{
			
			
		
		
		
		int pageSize = 4;//ÿҳ��¼��
		
		//��¼����
		int count=mobileService.countRecords(mobile);
		System.out.println(count+"<<--::count");
		int pages = 0;//��ҳ��
		
		if(count % pageSize == 0){//������ҳ��
			pages = count / pageSize;//�ܼ�¼���ܱ�ÿҳ��¼������
		}else{
			
			pages = count / pageSize + 1; 
		}
		
		System.out.println(mobile+"�ֻ��ų�ֵ��¼����count::-->>"+count);
		System.out.println("��ҳ��pages::-->>"+pages);
		
		//��ѯ��ǰ��ѡ��ҳ��
		String strcurrentpage=request.getParameter("currentPage")==null ? "1" : request.getParameter("currentPage");
		
		int currentPage=Integer.parseInt(strcurrentpage);
		
		System.out.println("��ѡҳ��currentPageInt::-->>"+currentPage);
		
		
		//���Ƶ�ǰҳ��
		if(currentPage > pages){
			currentPage = pages;
		}else if(currentPage < 1){
			currentPage = 1;
		}
		System.out.println("pages::-->>"+pages+"currentPage:::>>>"+currentPage);
		//���ҳ��ѯ
		//��currentPage��pageSize
		//������ָ�����ֻ�������ѯ���г�ֵ��¼
		List<RechargeInfor> rechargeInforList=mobileService.rechargeInforList(currentPage,pageSize,mobile);
		
		int count1=0;//��¼����
		for(RechargeInfor rcInfor : rechargeInforList){
			count1++;
			System.out.println("�Ż��ܽ��Ϊ------��"+rcInfor.getDiscount_count()+"++++++++");
			System.out.println("��ֵ������"+rcInfor.getCard_count());
			System.out.println("���п�����"+rcInfor.getBc_count());
			System.out.println("�ܳ�ֵ���"+rcInfor.getMoney_count());
		}
		
		System.out.println("�ܴ���"+count1);
		
		int money_count=rechargeInforList.get(count1-1).getMoney_count();
		System.out.println(money_count);		
		int discount_count=rechargeInforList.get(count1-1).getDiscount_count();
		int bc_count=rechargeInforList.get(count1-1).getBc_count();
		int card_count=rechargeInforList.get(count1-1).getCard_count();
		
		
		System.out.println(money_count+":::"+discount_count+":::"+bc_count+":::"+card_count);
		
		
		request.setAttribute("money_count", money_count);
		request.setAttribute("discount_count", discount_count);
		request.setAttribute("bc_count", bc_count);
		request.setAttribute("card_count", card_count);
		
		request.setAttribute("mobile", mobile);
		request.setAttribute("rechargeInforList", rechargeInforList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pages", pages);
		
		request.getRequestDispatcher("/recharge_style/record.jsp").forward(request, response);
		//}
	}

}
