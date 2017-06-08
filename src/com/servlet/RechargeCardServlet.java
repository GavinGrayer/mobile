package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.RechargeInfor;
import com.domain.TRechargeCard;
import com.service.MobileService;
import com.service.iface.MobileServiceIface;

public class RechargeCardServlet extends HttpServlet {
	
	private MobileServiceIface mobileService;
	/**
	 * Constructor of the object.
	 */
	public RechargeCardServlet() {
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
		
		System.out.println("------------------------------��ӭ������rechargecardservlet--------------");
		
		//�ֻ���-------1
		String mobile=request.getParameter("mobile")==null?"":request.getParameter("mobile");
		//��ֵ������--------2
		String cardNum=request.getParameter("cardNum")==null?"":request.getParameter("cardNum");
		//����
		String cardMsg=request.getParameter("cardMsg")==null?"":request.getParameter("cardMsg");
		
		System.out.println("mobile:"+mobile+"cardnum:"+cardNum+"cardmsg:"+cardMsg);
		
		//������Ϣ
		String mobileMsg=request.getParameter("mobileMsg");
		String cardNumMsg=request.getParameter("cardNumMsg");
		String cardMsgPwd=request.getParameter("cardMsgPwd");
		
		Map<String, String>errMsg=new HashMap<String, String>();
		
		//��̨��֤mobile
		String regex = "1[3|4|5|8][0-9]{9}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(mobile);
		if(mobile==""||mobile==null){
			
			errMsg.put("mobileMsg", "�ֻ��Ų���Ϊ��!!!!");
		}else if(mobile.length()!=11){
			
			errMsg.put("mobileMsg", "�ֻ���λ������!!!");
		}else if(!m.matches()){
			errMsg.put("mobileMsg", "�ֻ��Ÿ�ʽ����!!!");
			
		}
		
		//��̨��֤cardNum
		if(cardNum==""||cardNum==null){
			
			errMsg.put("cardNumMsg", "��ֵ���Ų���Ϊ��!!!!");
		}else if(cardNum.length()!=10){
			
			errMsg.put("cardNumMsg", "��ֵ����λ������!!!");
		}
		
		//��̨��֤����
		if(cardMsg==""||cardMsg==null){
			
			errMsg.put("cardMsgPwd", "���벻��Ϊ��!!!!");
		}else if(cardMsg.length()>10){
			
			errMsg.put("cardMsgPwd", "����λ������!!!");
		}
		
		
		
		String pwd=null;
		TRechargeCard t=mobileService.cardNumFindInfor(cardNum);
		
		if(t!=null){
		pwd=t.getCard_pwd();
		}
		
		//��ֵ�Ľ��------3
		String card_charge=null;
		if(t!=null){
		card_charge=t.getCard_charge();
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
		
		//��ֵʱ��----------------4
		String time=date.concat("-".concat(month.concat("-".concat(year))));

		System.out.println("��ǰϵͳʱ����::-->>"+time);
		
		//��ֵ����ֵ��ʽ���----------------5
		String recharge_type_id="1002";
		
		//�Żݽ��--------------------6
		String discount_amout="0";
	if(errMsg.isEmpty()){
		if(pwd.equals(cardMsg)){
			
			System.out.println("��ֵ���ѳɹ���ֵ");
			
			//���潫��ֵ��¼   1,2,3,4,5,6------------------
			RechargeInfor rcInfor=new RechargeInfor(mobile,time,recharge_type_id,cardNum,"","",discount_amout,card_charge);

			boolean result=mobileService.saveRechargeInforCard(rcInfor);
			
			//����ֵ����is_available  ��1-->>0
			boolean result1=mobileService.rechargeCardIsAvailable(cardNum);
			
			System.out.println("��ֵ����ʹ�ã�����������---------");
			
			//ͨ����ֵ���Ų�ѯ��ֵ���
			int card_charge1=mobileService.findCardCharge(cardNum);
			
			//������
			boolean a=mobileService.saveAccount(card_charge1);
			
			if(result==true&&result1==true&&a==true){
				
				request.getRequestDispatcher("/numericalSelection/select_number.jsp").forward(request, response);
			}else{
				System.out.println("����ʧ��:::--->>>������");
				errMsg.put("cardMsgPwd", "���治�ɹ����ѱ��˻�");
				request.setAttribute("errMsg", errMsg);
				request.getRequestDispatcher("/recharge_style/rechargeable_card.jsp").forward(request, response);
			}
		}else{
			errMsg.put("cardMsgPwd", "���벻��ȷ������������");
			request.setAttribute("errMsg", errMsg);
			request.getRequestDispatcher("/recharge_style/rechargeable_card.jsp").forward(request, response);
		}
		
	}else{
		
		request.setAttribute("errMsg", errMsg);
		request.getRequestDispatcher("/recharge_style/rechargeable_card.jsp").forward(request, response);
	}	
}
}

