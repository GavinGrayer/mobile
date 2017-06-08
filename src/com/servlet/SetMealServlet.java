package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.MobileSetMeal;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class SetMealServlet extends HttpServlet {

	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public SetMealServlet() {
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
		
		/**
		 * ��ֵ------------------------------------------
		 */
		//����url������ֵ
		String mobile=request.getParameter("mobile")==null ? "" : request.getParameter("mobile");
		String place=request.getParameter("place")==null ? "" : request.getParameter("place");
		place=new String(place.getBytes("ISO8859-1"),"UTF-8");
		
		String selfee=request.getParameter("selfee")==null ? "" : request.getParameter("selfee");
		
		System.out.println("mobile::-->>"+mobile+"place::-->>"+place+"selfee::-->>"+selfee);
		
		
		
		
		
		
		
		String flag=null; //����
		String business_name=null;
		String pp_name=null;
		/**
		 * ���ײ�
		 * ��ʾ�����ײ�
		 */
		List<MobileSetMeal>	setmealList=mobileService.setmeaList();
	//	List<MobileSetMeal>	setmealList1=mobileService.setmeaList("1008","1015");
		
		System.out.println("���Կ�ʼ----------------");
		for(MobileSetMeal msm : setmealList){
			
			flag=msm.getFlag();
			
			System.out.println("flag::-->>11����"+flag);
			
			business_name=msm.getBusiness_name();
			
			System.out.println("business_name::-->>11ʱ��"+business_name);
			
			pp_name=msm.getPp_name();
			
			System.out.println("pp_name::-->>11ʱ��"+pp_name);
			
		}
		System.out.println("���Խ���----------------");

		request.setAttribute("setmealList", setmealList);
		
		
		request.setAttribute("mobile", mobile);
		request.setAttribute("place", place);
		request.setAttribute("selfee", selfee);
		
		request.getRequestDispatcher("/numericalSelection/select_number_bysetmeal.jsp").forward(request, response);
		
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
