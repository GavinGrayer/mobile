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
<title>欢迎登录移动网上营业厅</title>
<link href="css/reset.css" rel="stylesheet" type="text/css" />
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript">
    
	 function userOnClick(){
       document.getElementById('operator').style.color="#037DC9";
	   document.getElementById('operator').style.backgroundImage="url(1.jpg)";
	   document.getElementById('register').style.display="";
	   document.getElementById('current').style.color="white";
	  document.getElementById('current').style.backgroundImage="url(image/hd_title_bg1.gif)";
	    
	 }
	 
	  function userOnClick2(){
	   document.getElementById('register').style.display="none";
	   document.getElementById('current').style.color="#005BAF";
	   document.getElementById('current').style.backgroundImage="url(1.jpg)";
	   document.getElementById('operator').style.color="white";
	   document.getElementById('operator').style.backgroundImage="url(image/hd_title_bg1.gif)";
	    
	 }
	 

</script>

<body>
<div id="contain">
  <div id="head">
    <img src="image/logo.gif"  />
  </div>
    <div id="main">
      <ul class="main-recommend-list">
        <li><a href="">在线充值</a>
            <p>冲100送5，冲200送12，多冲多送</p>
        </li>
        <li><a  href="">选号购机</a>
            <p>海量靓号免费选，在线购机优惠多</p>
        </li>
        <li><a href="">优惠活动</a>
            <p>话费免费领，登录有惊喜！缤纷活动尽在促销 优惠专区</p>
        </li>
      
        
        <li><a href=""> 查询办理</a>
            <p>千余项业务查询办理，让您轻松掌握、自在选择！</p>
        </li>
      </ul>
      <div id="main-loginBox">
       	
       <ul id="main-loginBox-tab" >
          <li><span class="current" id="current" >用户登录</span></li>
           <!--<li><span class="operator" id="operator" onmouseover="userOnClick2()" >业务员登录</span></li>-->
       </ul>
 
      
      
    
       <form class="main-loginBox-center" action="index.jsp">
       	
       		<div class="tusername">
            	<span>账户</span>
                <input type="text" name="username" />&nbsp;</div>
            <div class="tpassword"> <span>密码</span>
                <input type="password" name="pwd" /></div>
             <div class="submitbutt">
               <button type="submit" ><font color="#ffffff" size="4">登录</font></button>
               <a href="register.jsp">
               		<span id="register" style="display:'';font-size:17px" >立即注册！</span>
               	
               </a>
             </div>
       </form>
       </div>
    </div>


</div>
 </body>
</html>
