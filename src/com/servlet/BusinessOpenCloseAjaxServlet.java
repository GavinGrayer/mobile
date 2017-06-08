package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.ReplaceBusiness;
import com.domain.TBusinessFee;
import com.domain.TMobilePackage;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class BusinessOpenCloseAjaxServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public BusinessOpenCloseAjaxServlet() {
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

		System.out.println("Ajax验证----business:::open/close已开启------欢迎来到open close-------->>>>>>>>>>>");
		//status  1:开通  0:关闭  
		String status=request.getParameter("status")=="undefined" ? "" : request.getParameter("status1");
		System.out.println("在Ajax里取到的status的值:"+status);
		//业务办理编号-----------2
		String businessId=request.getParameter("businessId")==null ? "" : request.getParameter("businessId");;
		//手机号-----------1
		String mobile=request.getParameter("mobile")==null ? "" : request.getParameter("mobile");;
		
		System.out.println("status::-->>"+status+"businessId::-->>"+businessId+"mobile::-->>"+mobile);

		//系统时间
		Date d=new Date();
		int year1=d.getYear()+1900;
		String year=String.valueOf(year1);
		
		int month1=d.getMonth()+1;
		String month=String.valueOf(month1);
		
		int date1=d.getDate();
		String date=String.valueOf(date1);
		
		System.out.println("time2:"+d+":::");
		
		//开通时间-----------3   /   或关闭时间
		String time=date.concat("-".concat(month.concat("-".concat(year))));

		System.out.println("当前系统时间是::-->>"+time);
		//写保存方法
		TMobilePackage tmp=null;
		boolean result1=false;
		if(status.equals("1")){//开通
			
			System.out.println(">>>>>>>>开通");
			tmp=new TMobilePackage(mobile,businessId,null,time,null,status);
			
			
			result1=mobileService.savetmobilepackage(tmp);
			
			
		}else{//关闭

			System.out.println(">>>>>>>>关闭");
			//根据business_id,mobile,status来填写确定写结束时间的位置,即tel_package_id
			//根据开通状态  1  来找
			String tel_package_id=mobileService.findEndTime(mobile, businessId, "1");
			System.out.println("tel_package_id:::::>>>>>>>"+tel_package_id);
			//将关闭时间放入该条记录里
			result1 = mobileService.saveEndTime(tel_package_id, time);
		}
		
		
		
		
		
		
		
		
		System.out.println(result1+"---------------------------------");
		
		/**
		 * 刷新点击按钮后的局部刷新生效日期和结束日期---------已报废
		 */
		
		//根据指定的 手机号 和 businessId 来查询已选的业务和套餐-------重新写，单表查询t_mobile_package
		//List<ReplaceBusiness> replaceBusinessList=mobileService.findBussiness(mobile);
		ReplaceBusiness rb=mobileService.findEffectiveAndEndTime(mobile, businessId);
		
		String business_id=rb.getBusiness_id()==null?"":rb.getBusiness_id();
		String start_time=rb.getStart_time()==null?"--":rb.getStart_time();
		String end_time=rb.getEnd_time()==null?"--":rb.getEnd_time();
		
		System.out.println(business_id+"::::::"+start_time+":::::"+end_time);
		
		String resulString="";
		if(result1==true){
			resulString="true";
		}else{
			resulString="false";
		}
		//-----------------------------------------------------------
//		//组合result
//		String result=resulString.concat(",".concat(businessId.concat(",".concat(start_time.concat(",".concat(end_time))))));
//		

		System.out.println("result-->"+resulString);
		
		//out.print(result);
		out.print("<root><result>"+resulString+"</result></root>");
	}


}
