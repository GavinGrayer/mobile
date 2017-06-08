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


<script type="text/javascript">
		
		function card(){
			var T2=document.getElementById("T2").value;
			var cardMsg=document.getElementById("cardMsg");
			console.log("启动---------");
			
			if(T2 == ""){
				cardMsg.innerHTML = "银行卡号不能为空";
				cardMsg.style.display="inline";
				
				return false;			
			}else if(16>T2.length||T2.length>18){
				cardMsg.innerHTML = "银行卡号不在规定位数16-19范围内";
				cardMsg.style.display="inline";
				return false;	
			}else{
			cardMsg.innerHTML = "";
			//cardMsg.style.display="inline";
			return true;
			}
		}
		
		function pwd(){
		var T3=document.getElementById("T3").value;
			var pwdMsg=document.getElementById("pwdMsg");
			if(T3 == ""){
				pwdMsg.innerHTML = "密码不能为空";
				pwdMsg.style.display="inline";
				
				return false;			
			}else if(T3.length>6||T3.length<3){
				pwdMsg.innerHTML = "密码不在范围内";
				pwdMsg.style.display="inline";
				return false;	
			}else{
			pwdMsg.innerHTML = "";
			//pwdMsg.style.display="inline";
			return true;
			}
		
		}
		
</script>

</head>

<body id="new-operator-body">
<div id="new-operator-contain">
<div class="zhzf"></div>
<div id="new-operator-main">
  
<form method="POST" action="servlet/AccountServlet" class="form-style">

<input type="hidden" id="mobile" name="mobile" value="<%=request.getParameter("mobile") %>">
<input type="hidden" id="business_id" name="business_id" value="<%=request.getParameter("business_id") %>">
<input type="hidden" id="pp_id" name="pp_id" value="<%=request.getParameter("pp_id") %>">
<input type="hidden" id="selfee" name="selfee" value="<%=request.getParameter("selfee") %>">

<table  >
  <tr>
    <td class="left-td-style">银行卡号：</td>
    <td class="right-td-style"><input type="text" id="T2" name="T2" size="20" class="input-form-style" onblur="card()"></td>
    <td>
    <span id="cardMsg" style="color:red"></span>
    </td>
  </tr>
  <tr>
    <td class="left-td-style">密码：</td>
    <td class="right-td-style"><input type="password" id="T3" name="T3" size="20" class="input-form-style" onblur="pwd()" ></td>
    <td>
    <span id="pwdMsg" style="color:red"></span>
    </td>
   </tr>

    <tr class="button-tr-style" >
  	 <td colspan="2"class="right-td-style" >  
      <input type="submit" value="提交" name="B1" class="button-sub"  />
     <input type="reset" value="重置" name="B1" class="button-res" />
     
     </td>
     </tr>
 </table>

 </form>
      
  
    
   


</div>

 </div>

</body>
</html>
