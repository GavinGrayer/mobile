package com.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class myFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器启动-----------");
		
		//有条件放行
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		
		HttpSession session = httpRequest.getSession();
		
		System.out.println(session.getAttribute("name"));
		
		if (session.getAttribute("name") == null){
			System.out.println("2222222222");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
		System.out.println("1111111111");
		
		String nameString=(String) session.getAttribute("name");
		String mobileString=(String)session.getAttribute("mobile");
		System.out.println("name"+nameString+"mobile"+mobileString);
		
		request.setAttribute("name", session.getAttribute("name"));
		request.setAttribute("mobile", session.getAttribute("mobile"));
		chain.doFilter(request, response);
		//request.getRequestDispatcher("../servlet/RecordServlet").forward(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("=============++++++++++");
	}

}
