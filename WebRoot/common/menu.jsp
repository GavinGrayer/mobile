<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">


		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>江苏移动网上营业厅首页</title>

		<link href="<%=basePath%>/css/index.css" rel="stylesheet"
			type="text/css" />

		<style>
</style>
	</head>

	<body>

		<div class="left">
			<div id="tit1">
				<div class="tit_nav">
					<span class="menu-title">选&nbsp;&nbsp; 号</span>
				</div>
				<ul class="tit_con">
					<li>
						<span class="menu-infor"> <a
							href="<%=basePath%>/numericalSelection/select_number.jsp"
							target="content1">号码办理</a> <span>
					</li>
				</ul>

			</div>

			<div class="tit">
				<div class="tit_nav">
					<span class="menu-title">业&nbsp;&nbsp; 务</span>
				</div>
				<ul class="tit_con">

					<li>
						<span class="menu-infor"> <a
							href="servlet/OnlineRechargeServlet?name=${name }&mobile=${mobile }"
							target="content1">在线充值</a> <span>
					</li>

					<li>
						<span class="menu-infor"> <a
							href="<%=basePath%>/recharge_style/rechargeable_card.jsp?name=${name }&mobile=${mobile }"
							target="content1">充值卡充值</a> <span>
					</li>

					<li>
						<span class="menu-infor"> <a
							href="<%=basePath%>/servlet/RecordServlet?name=${name }&mobile=${mobile }" target="content1">充值缴费记录</a>
							<span>
					</li>

					<li>
						<span class="menu-infor"> <a
							href="<%=basePath%>/servlet/ReplaceBusinessServlet?name=${name }&mobile=${mobile }"
							target="content1">我的业务</a> <span>
					</li>



				</ul>




			</div>


		</div>

	</body>
</html>
