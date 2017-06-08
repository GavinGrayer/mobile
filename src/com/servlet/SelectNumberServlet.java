package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.T_mobile;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class SelectNumberServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public SelectNumberServlet() {
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
		//PrintWriter out = response.getWriter();

		
		System.out.println("选号隐藏域提交后台的SelectNumberServlet已开始---------------------->>>>>>>>>>>>>>>>>>>>>>");	
		/**
		 * 前台传过来的值
		 */

		String selcity=request.getParameter("selcity")==null ? "":request.getParameter("selcity");		
		selcity=new String(selcity.getBytes("ISO8859-1"),"UTF-8");
		System.out.println("selcity:::-->"+selcity);
		
		String seltelfee=request.getParameter("seltelfee")==null? "" : request.getParameter("seltelfee");
		
		seltelfee=new String(seltelfee.getBytes("ISO8859-1"),"UTF-8");

		
		String strselnumb_form=request.getParameter("selnumb_form")==null? "" : request.getParameter("selnumb_form");
		
		String selnumb_form=null;
		if(strselnumb_form!=""){
			
			selnumb_form=strselnumb_form.substring(0,2);
		}else{
			selnumb_form="";
		}
		selnumb_form=new String(selnumb_form.getBytes("ISO8859-1"),"UTF-8");
		System.out.println("selnumb_form:::-->"+selnumb_form);

		String selnumb_type=request.getParameter("selnumb_type")==null? "" : request.getParameter("selnumb_type");

		selnumb_type=new String(selnumb_type.getBytes("ISO8859-1"),"UTF-8");
		System.out.println("selnumb_type:::-->"+selnumb_type);

		String inputstyle=request.getParameter("inputstyle")==null? "" : request.getParameter("inputstyle");

		inputstyle=new String(inputstyle.getBytes("ISO8859-1"),"UTF-8");
		System.out.println("inputstyle:::-->"+inputstyle);

		/**
		 * 通过选的值来进行查询-------------------
		 * 		
		 * //根据所选城市来查询手机号分页查询----
		 */

		int pageSize = 6;//每页记录数
		
		//将所选的传入selcity，seltelfee，selnumb_form，selnumb_type,inputstyle-------
		T_mobile tm1=new T_mobile(selnumb_form,selnumb_type,selcity,seltelfee,inputstyle);
		
		
		//记录总数
		int count=mobileService.T_mobileCount(tm1);
		
		int pages = 0;//总页数
		if(count % pageSize == 0){//计算总页数
			pages = count / pageSize;//总记录数能被每页记录数整除
		}else{
			
			pages = count / pageSize + 1; 
		}
		System.out.println("手机号总数count::-->>"+count);
		System.out.println("总页数pages::-->>"+pages);
		
		//查询当前所选的页数

		String strcurrentpage=request.getParameter("currentPage")==null ? "1" : request.getParameter("currentPage");
		
		int currentPage=Integer.parseInt(strcurrentpage);
		
		System.out.println("所选页数currentPageInt::-->>"+currentPage);

		//控制当前页数
		if(currentPage > pages){
			currentPage = pages;
		}else if(currentPage < 1){
			currentPage = 1;
		}
		
		//将所选页数和每页个数传入currentPage,pageSize------
		
		List<T_mobile> mobileList=mobileService.mobileList(currentPage, pageSize,tm1);
		
		/**
		 * 测试所有手机号显示
		 */

		
		System.out.println(mobileList+"mobileList");
		
		
		for(T_mobile tm : mobileList){

			System.out.println(":::--->>>"+tm.getTel_numb());
			System.out.println(":::--->>>"+tm.getAcc_init_amount());
			System.out.println(":::--->>>"+tm.getTel_add());
		}

		
		System.out.println("选号隐藏域提交后台的SelectNumberServlet已结束---------------------->>>>>>>>>>>>>>>>>>>>>>");		
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pages", pages);
		request.setAttribute("mobileList", mobileList);
		
		
		
		
		request.setAttribute("selcity", selcity);
		request.setAttribute("seltelfee", seltelfee);
		request.setAttribute("strselnumb_form", selnumb_form);
		request.setAttribute("selnumb_type", selnumb_type);
		request.setAttribute("inputstyle", inputstyle);
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
