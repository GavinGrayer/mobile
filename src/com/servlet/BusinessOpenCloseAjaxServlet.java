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

		System.out.println("Ajax��֤----business:::open/close�ѿ���------��ӭ����open close-------->>>>>>>>>>>");
		//status  1:��ͨ  0:�ر�  
		String status=request.getParameter("status")=="undefined" ? "" : request.getParameter("status1");
		System.out.println("��Ajax��ȡ����status��ֵ:"+status);
		//ҵ�������-----------2
		String businessId=request.getParameter("businessId")==null ? "" : request.getParameter("businessId");;
		//�ֻ���-----------1
		String mobile=request.getParameter("mobile")==null ? "" : request.getParameter("mobile");;
		
		System.out.println("status::-->>"+status+"businessId::-->>"+businessId+"mobile::-->>"+mobile);

		//ϵͳʱ��
		Date d=new Date();
		int year1=d.getYear()+1900;
		String year=String.valueOf(year1);
		
		int month1=d.getMonth()+1;
		String month=String.valueOf(month1);
		
		int date1=d.getDate();
		String date=String.valueOf(date1);
		
		System.out.println("time2:"+d+":::");
		
		//��ͨʱ��-----------3   /   ��ر�ʱ��
		String time=date.concat("-".concat(month.concat("-".concat(year))));

		System.out.println("��ǰϵͳʱ����::-->>"+time);
		//д���淽��
		TMobilePackage tmp=null;
		boolean result1=false;
		if(status.equals("1")){//��ͨ
			
			System.out.println(">>>>>>>>��ͨ");
			tmp=new TMobilePackage(mobile,businessId,null,time,null,status);
			
			
			result1=mobileService.savetmobilepackage(tmp);
			
			
		}else{//�ر�

			System.out.println(">>>>>>>>�ر�");
			//����business_id,mobile,status����дȷ��д����ʱ���λ��,��tel_package_id
			//���ݿ�ͨ״̬  1  ����
			String tel_package_id=mobileService.findEndTime(mobile, businessId, "1");
			System.out.println("tel_package_id:::::>>>>>>>"+tel_package_id);
			//���ر�ʱ����������¼��
			result1 = mobileService.saveEndTime(tel_package_id, time);
		}
		
		
		
		
		
		
		
		
		System.out.println(result1+"---------------------------------");
		
		/**
		 * ˢ�µ����ť��ľֲ�ˢ����Ч���ںͽ�������---------�ѱ���
		 */
		
		//����ָ���� �ֻ��� �� businessId ����ѯ��ѡ��ҵ����ײ�-------����д�������ѯt_mobile_package
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
//		//���result
//		String result=resulString.concat(",".concat(businessId.concat(",".concat(start_time.concat(",".concat(end_time))))));
//		

		System.out.println("result-->"+resulString);
		
		//out.print(result);
		out.print("<root><result>"+resulString+"</result></root>");
	}


}
