package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.MobileSetMeal;
import com.domain.ReplaceBusiness;
import com.domain.TBusinessFee;
import com.domain.TMobilePackage;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class ReplaceBusinessServlet extends HttpServlet {
	
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public ReplaceBusinessServlet() {
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
		
		System.out.println("��ӭ����ReplaceBusinessServlet------------");
		
		//status  1:��ͨ  0:�ر�
		String status=request.getParameter("status")=="undefined" ? "0" : request.getParameter("status");
		
		String name=request.getParameter("name")==null? "" : request.getParameter("name");
		name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		//�ֻ���-----------1
		String mobile=request.getParameter("mobile")==null? "" : request.getParameter("mobile");
		
		System.out.println("name::-->>"+name+"mobile::-->>"+mobile);
		//ҵ�������-----------2
		String businessId=request.getParameter("businessId")==null ? "" : request.getParameter("businessId");;
		
		
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
		
		/**
		 * ������Чʱ������ʱ�仹�п�ͨ/�ر�״̬
		 * 
		 */
		//д���淽��
		TMobilePackage tmp=null;
//		if(status.equals("1")){//��ͨ
			
			
	//		tmp=new TMobilePackage(mobile,businessId,null,time,null,null);
//		}else{//�ر�
//			tmp=new TMobilePackage(mobile,businessId,null,null,time,status);
//		}
		
		/**
		 * �����Ƿ񱣴�ɹ�
		 */
//		boolean result1=mobileService.savetmobilepackage(tmp);
		
//		System.out.println(result1+"---------------------------------");

		/**
		 * 1.-------------
		 */
		//���ݴ��������ֻ��Ų�ѯ��ͨ����ҵ��----------
		//����ָ�����ֻ��Ų�ѯ��ѡ��ҵ����ײ�
		List<ReplaceBusiness> replaceBusinessList=mobileService.findBussiness(mobile);
		
//		for(ReplaceBusiness rb : replaceBusinessList){
//			System.out.println(rb.getBusiness_name()+rb.getShort_name()+rb.getStart_time()+"+++++++++");
//		}
		
		
		/**
		 * 2.---------------
		 */
		//��ѯ����t_business_fee���������
		//��ѯ����t_business_fee��Ķ�������list����

		List<TBusinessFee> findBusinessFeeList=mobileService.findTBussinessFeeList();
		
		//Map<String, String> msgMap=new HashMap<String, String>();
		
//		for(TBusinessFee a:findBusinessFeeList){
//			System.out.println(a.getBusiness_name()+"----------------------");
//		}
		
		
		//����Ч���ںͽ������ڷ���findBusinessFeeList����
		for(int i=0;i<findBusinessFeeList.size();i++){
			String a="";
			String b="";
			//System.out.println(replaceBusinessList.size());
			for(int j=0;j<replaceBusinessList.size();j++){
				//System.out.println(replaceBusinessList.size());
			if(findBusinessFeeList.get(i).getBusiness_id().equals(replaceBusinessList.get(j).getBusiness_id())){
				
				a=replaceBusinessList.get(j).getStart_time();
				b=replaceBusinessList.get(j).getEnd_time();
			
				System.out.println("end_time>>>>>>::::::"+b);
				
				findBusinessFeeList.get(i).setEffective_time(a);
				findBusinessFeeList.get(i).setEnd_time(b);
				
				
				}
			}
			System.out.println("-------------111111111111111111");
		}
		
		
		
		/**
		 * ���ײ�
		 * ��ʾ�����ײ�  �ײͰ������·��ģ�
		 */
		String flag=null; //����
		String business_name=null;
		List<MobileSetMeal>	setmealList=mobileService.setmeaList();
	//	List<MobileSetMeal>	setmealList1=mobileService.setmeaList("1008","1015");
		
		System.out.println("���Կ�ʼ----------------");
		for(MobileSetMeal msm : setmealList){
			
			flag=msm.getFlag();
			
			//System.out.println("flag::-->>11����"+flag);
			
			business_name=msm.getBusiness_name();
			
			//System.out.println("business_name::-->>11ʱ��"+business_name);
			
			
		}
		System.out.println("���Խ���----------------");
		
		
		
		
		request.setAttribute("setmealList", setmealList);
		request.setAttribute("status", status);
		request.setAttribute("mobile", mobile);
		request.setAttribute("replaceBusinessList", replaceBusinessList);
		request.setAttribute("findBusinessFeeList", findBusinessFeeList);
		
		
		request.getRequestDispatcher("/business/replacement_business.jsp").forward(request, response);
		
		
	}

}
