<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.domain.RechargeInfor"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>

<link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/reset.css" rel="stylesheet" type="text/css" />
</head>

<body id="record-body"  >
<div id="record-contain">
<div id="record-main">
    

    <div class="record-tel">号码<span class="tel-account">${mobile }</span>的充值记录如下：</div>
    
    <table width="700px"  class="table-infor-record-style2">
  <tr >
    <th>充值时间</th>
    <th>充值金额（元）</th>
    <th>充值方式</th>
    <th>充值卡编号</th>
    <th>银行卡编号</th>
    <th>优惠金额</th>
  </tr>
  
  <%
  
  	List<RechargeInfor> rechargeInforList=(List<RechargeInfor>)request.getAttribute("rechargeInforList");
  	
  	for(RechargeInfor rcInfor : rechargeInforList){
  %>	
  	<tr>
    <td><%=rcInfor.getRecharge_time() %></td>
    <td><%=rcInfor.getRecharge_money() %></td>
    
    <%
    	if(rcInfor.getCard_id().equals("--")){
    %>
    	 <td>银行卡充值</td>
    <%
    	}else{
    %>
    	 <td>充值卡充值</td>
    <% 
    	}
     %>
    
   
    
    
    <td><%=rcInfor.getCard_id() %></td>
    <td><%=rcInfor.getBank_card_numb() %></td>
    <td><%=rcInfor.getDiscount_amout() %></td>
  </tr>
  	
  	
  	
  <%
  
  	}
  %>	

    <tr>
    <td style="background:#79c8E6">总计</td>
    <td>${money_count }</td>
    <td>--</td>
    <td>${card_count }次</td>
    <td>${bc_count }次</td>
    <td>${discount_count }</td>
  </tr>


  
</table>

<form action="servlet/RecordServlet?&mobile=${mobile }" method="post">
  <table   class="table-infor-record-style2" id="page2">
	  <tr>
	    <th width="113">第${currentPage }页/共${pages }页</th>
	    <td id="page-skip"> <a href="servlet/RecordServlet?currentPage=1&mobile=${mobile }">首页</a> 
	    <a href="servlet/RecordServlet?currentPage=${currentPage - 1}&mobile=${mobile }">上一页</a>
	    <a href="servlet/RecordServlet?currentPage=${currentPage + 1}&mobile=${mobile }">下一页 </a>
	    <a href="servlet/RecordServlet?currentPage=${pages}&mobile=${mobile }">尾页</a> 
	    <input type="text"  name="currentPage" class="input-page-style">	    	
	    	<input type="submit" value="go" /> </td>
	  </tr>
	</table>
</form>

</div>

 </div>

</body>
</html>
