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
<title>用户注册——移动网上营业厅</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="myjs.js"></script>


<!-- javascript脚本 -->
<script type="text/javascript">
	//账号验证结果
	var isUsernameOk=false;
	var isTnameOk=false;
	var isMoblieOk=false;
	var isIdCardOk=false;
	var isBirthOk=false;
	var isPwdOk=false;
	var isRegPwdOk=false;

	//表单验证是否为真，真则跳转
	function verify(){
		var result1=callback_username();
		
		var result2=checkname();
		var result3=callback_mobile();
		var result4=checkidcard();
		var result5=checkbirth();
		var result6=checkpwd();
		var result7=checkregpwd();

		
		var result=result1&&result2&&result3&&result4&&result5&&result6&&result7;
		console.log("verify表单验证-->"+result+"-----------");
		
		
		if(result==true){
			return result;
		}else{
			return false;
		}
			
	}


	//验证账户
	//-------------------------------------------------------
	function checkuser(){
		var username=document.getElementById("username").value;
		var errUser=document.getElementById("errUser");

	//验证账户——————Ajax验证
		getXMLHttpRequest();
    		

    	    var username = document.getElementById("username").value;
    	    var mobile = document.getElementById("mobile").value;
    	    

    	    var url = "servlet/UsernameIsRemainingAjaxServlet?username="+username+"&mobile="+mobile;

    	    xmlHttpRequest.open("post", url, true);
    	    
    	    // 3. 为xmlHttpRequest设置回调函数
    	    xmlHttpRequest.onreadystatechange = callback_username;	

    		 xmlHttpRequest.send(null);
		

	}
	
	//调回函数
    	function callback_username(){
    		console.log("callback");
    		 var username = document.getElementById("username").value;
    		 
    		 
    		if(xmlHttpRequest.readyState == 4){		// 接收服务器响应的前提：a
    			// test
    			
    			console.log(xmlHttpRequest.readyState);
    			console.log("1111111111");
    			console.log(xmlHttpRequest.status);
    			if (xmlHttpRequest.status == 200 || xmlHttpRequest.status == 0){	// 接收服务器响应的前提：b
    				// test
    				console.log(xmlHttpRequest.status);
    				
    				
    				// 1. responseText
    				//var res = xmlHttpRequest.responseText;
    				//console.log(res);
    				
    				// 2. responseXML
    				console.log("111111111111");
    				var res = xmlHttpRequest.responseXML.getElementsByTagName("result");
    				//console.log("-->"+res);
    				
    				var result;
    				
    				// 取值
    				for (var i = 0; i < res.length; i++){
    					result = res[i].firstChild.nodeValue;
    				}
    				
    				console.log("从servlet中取出的result"+result);
    				
    				// 根据结果输出
    				if(username==null||username==""){
    					var errUser = document.getElementById("errUser");
    					errUser.style.color = "red";
    					errUser.style.display = "block";
    					errUser.innerHTML = "账户不能为空——Ajax验证";
    					return false;
    				}else if (result == "true"){
    					//location.href = "register.jsp";
    					var errUser = document.getElementById("errUser");
    					errUser.style.color = "green";
    					errUser.style.display = "block";
    					errUser.innerHTML = "账户可以使用——Ajax验证";
    					
    					return true;
    				}else{
    					var errUser = document.getElementById("errUser");
    					errUser.style.color = "red";
    					errUser.style.display = "block";
    					errUser.innerHTML = "账户已存在--Ajax验证";
    					return false;
						//System.out.println("Ajax验证帐号成功-->");
    				}

    			}	// 200
    		}	// 4	
    		
		
    	}	// callback
    	
	
	
	//验证姓名
	//------------------------------------------------------------------
	function checkname(){
		var tname=document.getElementById("tname").value;
		var errName=document.getElementById("errName");
		//充值验证结果Tname
		var isTnameOk=false;
		
		if(tname==""){
			errName.innerHTML="姓名不能为空";
			errName.style.display="inline";
			return isTnameOk;
		}else if(tname.length>20){
			errName.innerHTML="姓名不能超过20个位";
			errName.style.display="inline";
			return isTnameOk;
		}else{
			errName.innerHTML="";
			errName.style.display="none";
			isTnameOk=true;
			return isTnameOk;
		}
		
	}
	
	
	//验证手机号---------------------------------------------------------
	function checkmobile(){
		var mobile=document.getElementById("mobile").value;
		var errMobile=document.getElementById("errMobile");
		
		var reg=/^1[3|4|5|8]\d{9}$/;
		//充值验证结果mobile
		var isMoblieOk=false;

		//验证手机号——————Ajax验证
		getXMLHttpRequest();
    		

    	    var username = document.getElementById("username").value;
    	    var mobile = document.getElementById("mobile").value;
    	    

    	    var url = "servlet/MobileIsRemainingAjaxServlet?username="+username+"&mobile="+mobile;

    	    xmlHttpRequest.open("post", url, true);
    	    
    	    // 3. 为xmlHttpRequest设置回调函数
    	    xmlHttpRequest.onreadystatechange = callback_mobile;	

    		 xmlHttpRequest.send(null);

	}
	
	//调回函数
    	function callback_mobile(){
    		console.log("callback1");
    		 var username = document.getElementById("username").value;
    		 var mobile = document.getElementById("mobile").value;
    		 var reg1=/^1[3|4|5|8]\d{9}$/;
    		 
    		 
    		if(xmlHttpRequest.readyState == 4){		// 接收服务器响应的前提：a
    			// test
    			
    			console.log(xmlHttpRequest.readyState);
    			
    			console.log(xmlHttpRequest.status);
    			if (xmlHttpRequest.status == 200 || xmlHttpRequest.status == 0){	// 接收服务器响应的前提：b
    				// test
    				console.log(xmlHttpRequest.status);
    				
    				
    				// 1. responseText
    				//var res = xmlHttpRequest.responseText;
    				//console.log(res);
    				
    				// 2. responseXML
    				
    				var res = xmlHttpRequest.responseXML.getElementsByTagName("result");
    				//console.log("-->"+res);
    				
    				var result;
    				
    				// 取值
    				for (var i = 0; i < res.length; i++){
    					result = res[i].firstChild.nodeValue;
    				}
    				
    				console.log("从servlet中取出的result--mobile"+result);
    				
    				// 根据结果输出
    				if(mobile==null||mobile==""){
    					var errMobile = document.getElementById("errMobile");
    					errMobile.style.color = "red";
    					errMobile.style.display = "block";
    					errMobile.innerHTML = "手机号不能为空——Ajax验证";
    					return false;
    				}else if(!reg1.test(mobile)){
    					var errMobile = document.getElementById("errMobile");
    					errMobile.style.color = "red";
    					errMobile.style.display = "block";
    					errMobile.innerHTML = "手机格式不对——Ajax验证";
    					return false;
    					
    				}else if (result == "true"){
    					//location.href = "register.jsp";
    					var errMobile = document.getElementById("errMobile");
    					errMobile.style.color = "green";
    					errMobile.style.display = "block";
    					errMobile.innerHTML = "手机号可以使用——Ajax验证";
    					return true;
    				}else{
    					var errMobile = document.getElementById("errMobile");
    					errMobile.style.color = "red";
    					errMobile.style.display = "block";
    					errMobile.innerHTML = "该手机号已使用--Ajax验证";
    					return false;
						//System.out.println("Ajax验证手机号成功-->");
    				}

    			}	// 200
    		}	// 4	
    		
	
    	}	// callback1
	
	
	
	
	
	
	
	
	
	
	
	
	//验证身份证号----------------------------------------------------
	function checkidcard(){
		var idcard=document.getElementById("idcard").value;
		var errIdcard=document.getElementById("errIdcard");
		
		var reg=/^(\d{18,18}|\d{15,15}x)$/;
		//充值验证结果idcard
		var isIdCardOk=false;
		
		if(idcard==""){
			errIdcard.innerHTML="身份证号不能为空";
			errIdcard.style.display="inline";
			return isIdCardOk;
		}else if(idcard.length!=18){
			errIdcard.innerHTML="身份证号不是18位";
			errIdcard.style.display="inline";
			return isIdCardOk;
		}else if(!reg.test(idcard)){
			errIdcard.innerHTML="身份证号格式不对";
			errIdcard.style.display="inline";
			return isIdCardOk;
		}else{
			errIdcard.innerHTML="";
			errIdcard.style.display="none";
			isIdCardOk=true;
			return isIdCardOk;
		}
	}
	
	
	//验证生日
	function checkbirth(){
		var birth=document.getElementById("birth").value;
		var errbirth=document.getElementById("errbirth");
		
		var reg=/^\d{4}(\-|\/|\.)\d{1,2}\1\d{1,2}$/;
		//充值验证结果birth
		var isBirthOk=false;
		
		if(birth==""){
			errbirth.innerHTML="生日不能为空";
			errbirth.style.display="inline";
			return isBirthOk;
		}else if(!reg.test(birth)){
			errbirth.innerHTML="生日格式不对";
			errbirth.style.display="inline";
			return isBirthOk;
		}else{
			errbirth.innerHTML="";
			errbirth.style.display="none";
			isBirthOk=true;
			return isBirthOk;
		}
		
	}
	
		//验证密码
	function checkpwd(){
		var pwd=document.getElementById("pwd").value;
		var errpwd=document.getElementById("errpwd");
		//充值验证结果password
		var isPwdOk=false;
		
		if(pwd==""){
			errpwd.innerHTML="密码不能为空";
			errpwd.style.display="inline";
			return isPwdOk;
		}else if(pwd.length>20){
			errpwd.innerHTML="密码不能超过20个位";
			errpwd.style.display="inline";
			return isPwdOk;
		}else{
			errpwd.innerHTML="";
			errpwd.style.display="none";
			isPwdOk=true;
			return isPwdOk;
		}
	}
	
			//重新验证密码
	function checkregpwd(){
		var regpwd=document.getElementById("regpwd").value;
		var errregpwd=document.getElementById("errregpwd");
		
		var pwd=document.getElementById("pwd").value;
		
		//充值验证结果password
		var isRegPwdOk=false;
		
		if(regpwd==""){
			errregpwd.innerHTML="密码不能为空";
			errregpwd.style.display="inline";
			return isRegPwdOk;
		}else if(regpwd!=pwd){
			errregpwd.innerHTML="密码不一致";
			errregpwd.style.display="inline";
			return isRegPwdOk;
		}else{
			errregpwd.innerHTML="";
			errregpwd.style.display="none";
			isRegPwdOk=true;
			return isRegPwdOk;
		}
	}

</script>


</head>

<body>



<div id="register-contain">
	<div id="register-main">
<img src="image/register.jpg" id="reg-img" />


   <form class="add-customer" id="register_form" action="servlet/RegisterServlet" onsubmit="return verify()">
   	
   	<table style="text-align:right;font-size:12px"  >
   		
   		<tr>
   			<td class="regtitle" >账户：</td>
   			<td class="reginput">
	   			
	   			<input type="text" id="username" name="username" onblur="checkuser()">
	   			
   			</td>
   			<td>
   				<span id="errUser" style="color:red;">${errMap.errUser} 
	   			</span>
   			</td>
   		</tr>
   		
   		
   		<tr>
   			<td><span class="regtitle">姓名：</span></td>
   			
   			<td>
   				<input type="text" id="tname" name="tname" onblur="checkname()"/>
   				
   			</td>
   			<td>
   				<span id="errName" style="color:red;">${errMap.errName}</span>
   			</td>
   		</tr>
   		
   		
   		<tr>
   			<td><span class="regtitle">手机号码：</span></td>
   			
   			
   			<td>
   			<input type="text" id="mobile" name="mobile" onblur="checkmobile()"/>

   			</td>
   			
   			<td>
   			 <span id="errMobile" style="color:red;">${errMap.errMobile}</span>
   			</td>
   		</tr>
   		
   		
   		<tr>
   			<td><span class="regtitle">身份证号码：</span></td>
   			
   			<td>
   				<input type="text" id="idcard" name="idcard" onblur="checkidcard()"/>

   			</td>
   			
   			<td>
   				<span id="errIdcard" style="color:red;">${errMap.errIdcard}</span>
   			</td>
   		</tr>
   		
   		
   		<tr>
   			<td><span class="regtitle">出生日期:</span></td>
   			
   			<td>
   			<input type="text" id="birth" name="birth" onblur="checkbirth()"/>

   			
   			</td>
   			<td>
    			<span id="errbirth" style="color:red;">${errMap.errbirth}</span>  				
   			</td>
   		</tr>
   		<tr>
   			<td><span class="regtitle">登录密码：</span></td>
   			
   			<td>
   				<input type="password" id="pwd" name="pwd" onblur="checkpwd()"/>

   			
   			</td>
   			<td>
   				<span id="errpwd" style="color:red;">${errMap.errpwd }</span>
   			</td>
   		</tr>
   		
   		
   		<tr>
   			<td><span class="regtitle">确认密码：</span></td>
   			
   			<td>
   				<input type="password" id="regpwd" name="regpwd" onblur="checkregpwd()"/>

   			
   			</td>
   			<td>
   				<span id="errregpwd" style="color:red;">${errMap.errregpwd }</span>
   			</td>
   		</tr>
   		<tr>
   			<td></td>
   			<td> <button type="submit" id="reg-sub">立即注册</button></td>
   			<td></td>
   		</tr>
   	</table>

   </form>
    </div>
</div>
</body>
</html>
