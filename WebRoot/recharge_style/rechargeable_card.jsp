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

<script type="text/javascript" src="myjs.js"></script>

<script type="text/javascript">
	
	function verify(){
		var result1=callback();
		var result2=callback_pwd();
		var result=result1&&result2;
		
		if(result==true){
			return result;
		}else{
			return false;
		}
	
	}
	
	
	function checkCardNum(){
				//获取参数请求
				

		var cardNum=document.getElementById("cardNum").value;
		var cardNumMsg=document.getElementById("cardNumMsg");
		
		//获得xmlHttpRequest对象
			getXMLHttpRequest();
			//打开URL地址
				
				//准备url
				var url = "servlet/RechargeCardAjaxServlet?cardNum="+cardNum;
				//var url = "servlet/RechargeCardAjaxServlet"；

				//打开
				xmlHttpRequest.open("post",url,true);
			
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback;
				
				//发出请求
				xmlHttpRequest.send(null);

	
	}
	
	function callback(){

						
				//获取参数请求
		var cardNum=document.getElementById("cardNum").value;
		var cardNumMsg=document.getElementById("cardNumMsg");
			
			if(xmlHttpRequest.readyState == 4){
				

				console.log(xmlHttpRequest.readyState);
				
				if(xmlHttpRequest.status == 200){
					
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status);
					//alert(xmlHttpRequest.responseText);
					
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					
	
					
						var values = result.split(",");
					//document.getElementById("discount").value = values[1];
					//document.getElementById("T4").value = parseInt(values[1])+parseInt(values[0]);
					
						
					// 根据结果输出
    				if(cardNum==null||cardNum==""){
    					var cardNumMsg = document.getElementById("cardNumMsg");
    					cardNumMsg.style.color = "red";
    					cardNumMsg.style.display = "inline";
    					cardNumMsg.innerHTML = "充值卡号不能为空——Ajax验证";
    					return false;
    				}else if (values[0] == "0"){
    					//location.href = "register.jsp";
    					var cardNumMsg = document.getElementById("cardNumMsg");
    					cardNumMsg.style.color = "red";
    					cardNumMsg.style.display = "inline";
    					cardNumMsg.innerHTML = "充值卡号不存在——Ajax验证";
    					
    					return true;
    				}else if(values[0] == "1" && values[1] == "1"){
    					var cardNumMsg = document.getElementById("cardNumMsg");
    					cardNumMsg.style.color = "green";
    					cardNumMsg.style.display = "inline";
    					cardNumMsg.innerHTML = "充值卡号可以使用--Ajax验证";
    					return true;
						//System.out.println("Ajax验证帐号成功-->");
    				}else{
    					var cardNumMsg = document.getElementById("cardNumMsg");
    					cardNumMsg.style.color = "red";
    					cardNumMsg.style.display = "inline";
    					cardNumMsg.innerHTML = "充值卡号不能使用,已作废--Ajax验证";
    					return false;
    				}
								
				}
				
			}
			
			
					
		}
		
		
		
		function checkCardMsg(){
			var mobile=document.getElementById("mobile").value;

				//获得xmlHttpRequest对象
			getXMLHttpRequest();
			//打开URL地址
				
				//准备url
				var url = "servlet/MobileIsRemainingAjaxServlet?mobile="+mobile;
				

				//打开
				xmlHttpRequest.open("post",url,true);
			
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback_pwd;
				
				//发出请求
				xmlHttpRequest.send(null);

	

		}
		function callback_pwd(){

						
				//获取参数请求
		var mobile=document.getElementById("mobile").value;
		var mobileMsg=document.getElementById("mobileMsg");
		 var reg1=/^1[3|4|5|8]\d{9}$/;
		 	
			if(xmlHttpRequest.readyState == 4){
				

				console.log(xmlHttpRequest.readyState);
				
				if(xmlHttpRequest.status == 200){
					
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status);
					//alert(xmlHttpRequest.responseText);
					
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					

					console.log("从servlet中取出的result--mobile"+result);
					
					// 根据结果输出
    				if(mobile==null||mobile==""){
    					mobileMsg.style.color = "red";
    					mobileMsg.style.display = "inline";
    					mobileMsg.innerHTML = "手机号不能为空——Ajax验证";
    					return false;
    				}else if (!reg1.test(mobile)){
    					mobileMsg.style.color = "red";
    					mobileMsg.style.display = "inline";
    					mobileMsg.innerHTML = "手机格式不对——Ajax验证";
    					return false;

    				}else if(result != "true"){
    					mobileMsg.style.color = "green";
    					mobileMsg.style.display = "inline";
    					mobileMsg.innerHTML = "手机号可以充值——Ajax验证";
    					return true;
    				}else{
    					mobileMsg.style.color = "red";
    					mobileMsg.style.display = "inline";
    					mobileMsg.innerHTML = "手机号不存在——Ajax验证";
    					return false;
    				}
								
				}
				
			}
			
			
		}

</script>




</head>

<body id="card-body">
<div id="card-contain">
	<div id="card-main">
    	<div id="card-procedure"></div>
        
<form method="POST" action="servlet/RechargeCardServlet" class="form-style" >
		<table >
		  <tr>
		    <td class="left-td-style">手机号码：</td>
		    <td class="right-td-style">
		    <input type="text" id="mobile" name="mobile" size="20" class="input-form-style"  onblur="checkCardMsg()"  value="<%=request.getParameter("mobile") %>" ></td>
		    <td><span id="mobileMsg" style="color:red">${errMsg.mobileMsg }</td>
		  </tr>
		  <tr>
		    <td class="left-td-style">充值卡卡号：</td>
		    <td class="right-td-style">
		    <input type="text" id="cardNum" name="cardNum" onblur="checkCardNum()" size="20"   class="input-form-style"  ></td>
		    <td><span id="cardNumMsg" style="color:red">${errMsg.cardNumMsg}</span></td>
		   
		   </tr>
		  <tr>
		  	 <td class="left-td-style">充值卡密码：</td>
		     <td class="right-td-style">
		     <input type="password" id="cardMsg" name="cardMsg" size="20" class="input-form-style" ></td>
		     <td><span id="cardMsgPwd" style="color:red">${errMsg.cardMsgPwd}</span></td>
		 		
		  </tr>
		   <tr align="center">
		  	 <td colspan="2" class="left-td-style" >
		     <input type="submit"  value="提交" class="button-sub"/>
		     <input type="reset" value="重置" class="button-res"/>
		     
		     </td>
		     <td><br></td>
		     </tr>
		  </table>
		 


          
 </form>
        
        
        
    
    </div>

</div>
</body>
</html>
