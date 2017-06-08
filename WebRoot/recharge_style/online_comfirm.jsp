<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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



<body>
<div id="online-contain">
	<div id="online-head">
    </div>
    <div class="clear"></div>
    	<div id="card-procedure3"></div>
    <div id="online-main">
    
       
        <form method="POST" action="--WEBBOT-SELF--" class="form-style">
<table  class="table-style" >
  <tr>
    <td class="left-td-style">充值方式：</td>
    <td class="right-td-style">在线充值</td>
  </tr>
 <tr>
    <td class="left-td-style">客户姓名：</td>
    <td class="right-td-style">${name }</td>
  </tr>
  <tr>
    <td class="left-td-style">充值号码：</td>
    <td class="right-td-style"><span id="numb">${mobile }</span><span>请认真核对</span></td>
   </tr>
  <tr>
  	 <td class="left-td-style">充值金额：</td>
     <td class="right-td-style">${tel_charge }元</td>
  </tr>
   <tr>
  	 <td class="left-td-style">充值优惠：</td>
     <td class="right-td-style"><span id="cheap">${preferential_name }</span></td>
  </tr>
   
    <tr>
  	 <td class="left-td-style">实际到账：</td>
     <td class="right-td-style"><span id="acc">${T4 }</span>元</td>
  </tr>
   
  
     <tr class="button-tr-style" >

  	 <td colspan="2" class="left-td-style" >

     <input type="button"  value="支付" class="button-sub"  onclick="location.href='recharge_style/SecondAccount.jsp?name=${name }&mobile=${mobile }&tel_charge=${tel_charge }&T4=${T4}'" />

     <input type="reset" value="上一步" class="button-res" onclick="location.href='recharge_style/online_recharge.jsp'"/>

     

     </td>

     </tr>

 </table>
 

             

          
 </form>
      
    	
    
    </div>

</div>
</body>
</html>
