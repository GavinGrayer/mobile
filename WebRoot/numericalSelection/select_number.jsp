<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.domain.T_mobile"%>
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




<script>
		

        /**
		 	选择城市，选中某个城市城市颜色变为背景颜色变为
			红色，边框变为黄色
		 */
		function chooseCity(ii){
			//ii代表选中的li对象
			var temp = document.getElementById('myul');
			var lis = temp.getElementsByTagName('li');  //获得ul下面所有的li对象
		    
		    
		    
            for(var i = 0; i < lis.length; i ++){       
			
				  if(lis[i].getAttribute("value")==ii.getAttribute("value")){ 
				  //遍历li对象，循环对比li对象value值是否和传入ii对象值是否一致
						lis[i].style.background="#FFDDDD";    //背景粉色
						lis[i].style.borderColor="#FFCC00";   //边框橙色
						console.log(":::-->"+ii.getAttribute("value"));
						
						document.getElementById("selcity").value=ii.getAttribute("value");
						
						console.log("转换后的"+document.getElementById("selcity").value);
						
				  }else{
				  		
				  		
						 lis[i].style.background="#E1E1E1";    
						 lis[i].style.borderColor="#BEBEBE";  //边框灰色
				  
				  }
					
				
		     }
	
		}
		
		/**
		*	预存话费
		*/
		
		function query_telfee(ii,ul_id){
		
		temp = document.getElementById(ul_id);
		lis = temp.getElementsByTagName('li');
	
			for(var i = 0; i < lis.length; i ++){
			
			if(lis[i].getAttribute("value")==ii.getAttribute("value")){
			   lis[i].style.background="#03AFEB";
			   lis[i].style.color="white";
			   
			   document.getElementById("seltelfee").value=ii.getAttribute("value");
			   console.log("转换后的"+document.getElementById("seltelfee").value);

			   
			   
			}else{
				lis[i].style.background="white";
			   lis[i].style.color="#666666";
			   
			   }
			   
			}
			
		
		}
		
		
		/**
		*	号段
		*/
		
		function query_telfeea(ii,ul_id){
		
		temp = document.getElementById(ul_id);
		lis = temp.getElementsByTagName('li');
	
			for(var i = 0; i < lis.length; i ++){
			
			if(lis[i].getAttribute("value")==ii.getAttribute("value")){
			   lis[i].style.background="#03AFEB";
			   lis[i].style.color="white";

			   document.getElementById("selnumb_form").value=ii.getAttribute("value");
			  

			   console.log("转换后的"+document.getElementById("selnumb_form").value);

			}else{
				lis[i].style.background="white";
			   lis[i].style.color="#666666";
			   
			   }
			   
			}
			
		
		}
		
		
		/**
		*	手机卡类别
		*/
		
		function query_telfeeb(ii,ul_id){
		
		temp = document.getElementById(ul_id);
		lis = temp.getElementsByTagName('li');
	
			for(var i = 0; i < lis.length; i ++){
			
			if(lis[i].getAttribute("value")==ii.getAttribute("value")){
			   lis[i].style.background="#03AFEB";
			   lis[i].style.color="white";

			   document.getElementById("selnumb_type").value=ii.getAttribute("value");
			   console.log("转换后的"+document.getElementById("selnumb_type").value);

			}else{
				lis[i].style.background="white";
			   lis[i].style.color="#666666";
			   
			   }
			   
			}

		}

</script>


</head>

<body>
	
	<%
		String seltelfee=(String)request.getAttribute("seltelfee");
		
		System.out.println(seltelfee);
	 %>

<div id="select_number_contain">
    <div id="select_number_main_main">
    	<ul class="loc" id="myul" >
        	<li  onclick="chooseCity(this)" value="南京" >南京</li>
            <li  onclick="chooseCity(this)" value="镇江">镇江</li>
            <li onclick="chooseCity(this)" value="常州">常州</li>
            <li onclick="chooseCity(this)"  value="无锡">无锡</li>
            <li onclick="chooseCity(this)" value="苏州">苏州</li>
            <li onclick="chooseCity(this)" value="南通" >南通</li>
            <li onclick="chooseCity(this)"  value="泰州">泰州</li>
            <li onclick="chooseCity(this)" value="扬州">扬州</li>
            <li onclick="chooseCity(this)" value="宿迁">宿迁</li>
            <li onclick="chooseCity(this)" value="淮安" >淮安</li>
            <li onclick="chooseCity(this)" value="徐州" >徐州</li>
            <li onclick="chooseCity(this)" value="连云港">连云港</li>
            <li onclick="chooseCity(this)" value="盐城">盐城</li>
        </ul>
        <div class="clear"></div>
        <ul class="fee" id="my-ul-fee">
            <li><span class="numb-form">预存话费</span></li>
            <li  onclick="query_telfee(this,'my-ul-fee')" value="" class="renyi">任意</li>
            <li  onclick="query_telfee(this,'my-ul-fee')" value="50">50元</li>
            <li onclick="query_telfee(this,'my-ul-fee')"  value="100">100元</li>
            <li onclick="query_telfee(this,'my-ul-fee')"  value="200">200元</li>
            <li onclick="query_telfee(this,'my-ul-fee')"  value="300">300元</li>
            <li onclick="query_telfee(this,'my-ul-fee')"  value="400">400元</li>
            <li onclick="query_telfee(this,'my-ul-fee')"  value="500">500元</li>
             <li onclick="query_telfee(this,'my-ul-fee')" value="600">600元</li>
            <li onclick="query_telfee(this,'my-ul-fee')"  value="800">800元</li>
        </ul>
     <div class="clear"></div>
        <ul id="dnseg">
            <li><span class="numb-form">号段</span></li>
            <li class="renyi" onclick="query_telfee(this,'dnseg')" value="">任意</li>
             <li onclick="query_telfeea(this,'dnseg')" value="13X" >13X</li>
             <li onclick="query_telfeea(this,'dnseg')" value="15X">15X</li>
             <li onclick="query_telfeea(this,'dnseg')" value="18X">18X</li>
        </ul>
     <div class="clear"></div>
        <ul id="type">
            <li><span class="numb-form">手机卡类别</span></li>
            <li class="renyi" onclick="query_telfee(this,'type')" value="">任意</li>
            <li onclick="query_telfeeb(this,'type')" value="4G">4G</li>
            <li onclick="query_telfeeb(this,'type')" value="3G">3G</li>
            <li onclick="query_telfeeb(this,'type')" value="GSM">GSM</li>
      </ul>
      
      
      <div class="clear"></div>
     
     
      <!-- 写入隐藏项存值 -->
<form action="servlet/SelectNumberServlet" id="hidden_msg" method="get">
      <div id="search">
      <span class="numb-form">指定数字</span>
      <input type="text"  id="inputstyle" name="inputstyle" />
      
      
     	<input type="hidden" name="selcity" id="selcity" >
     	<input type="hidden" name="seltelfee" id="seltelfee" value="">
     	<input type="hidden" name="selnumb_form" id="selnumb_form" value=""> 
     	<input type="hidden" name="selnumb_type" id="selnumb_type" value="">
     
      <button type="submit" id="sousuo"></button>
 
      </div>
</form>
      <div class="clear"></div>
      
     
     
      
<table width="700" class="table-infor-record-style" >
  <tr>
    <th>号码</th>
    <th>号码归属地</th>
    <th>预存话费</th>
    <th>操作</th>
  </tr>
  
  
  
  
  
  <%
  	List<T_mobile> mobileList=(List<T_mobile>)request.getAttribute("mobileList");
  	
  	if(mobileList!=null){
  	
  	for(T_mobile tm : mobileList){
  %>
  	
  	 <tr>
  
    <td><%=tm.getTel_numb() %></td>
    <td><%=tm.getTel_add() %></td>
    <td><%=tm.getAcc_init_amount() %></td> 
    <td>
       <div  align="center">
        <input type="button" class="buy" value="立即购买" onclick="location.href='servlet/SetMealServlet?mobile=<%=tm.getTel_numb() %>&&place=<%=tm.getTel_add() %>&&selfee=<%=tm.getAcc_init_amount() %>' "/>
        </div>
        </td>
  </tr>
  	
  <%
  	}
  	
  	}
  	
  	else{
  	%>
  	
  	<tr>
    <td>----------------</td>
    <td>请选择</td>
    <td>----------------</td> 
    <td>
       <div  align="center">
        <input type="button" class="buy" value="<<<<<<<<" onclick="location.href='numericalSelection/select_number_bysetmeal.jsp' "/>
        </div>
        </td>
  </tr>
 
  	
  	
  	<% 
  	}
   %>
  
 
  

</table>


<div id="clear"></div>
<form action="servlet/SelectNumberServlet?selcity=${selcity }&&seltelfee=${seltelfee }&&selnumb_form=${strselnumb_form }&&selnumb_type=${selnumb_type }&&inputstyle=${inputstyle }" method="post">
<table   class="table-infor-record-style" id="page" >
  <tr>
    <th width="113" >第${currentPage }页/共${pages }页</th>
    <td ><a href="servlet/SelectNumberServlet?currentpage=1&&selcity=${selcity }&&seltelfee=${seltelfee }&&selnumb_form=${strselnumb_form }&&selnumb_type=${selnumb_type }&&inputstyle=${inputstyle }">首页</a>
    <a href="servlet/SelectNumberServlet?currentPage=${currentPage - 1}&&selcity=${selcity }&&seltelfee=${seltelfee }&&selnumb_form=${strselnumb_form }&&selnumb_type=${selnumb_type }&&inputstyle=${inputstyle }">上一页</a> 
    <a href="servlet/SelectNumberServlet?currentPage=${currentPage + 1}&&selcity=${selcity }&&seltelfee=${seltelfee }&&selnumb_form=${strselnumb_form }&&selnumb_type=${selnumb_type }&&inputstyle=${inputstyle }">下一页</a>
    <a href="servlet/SelectNumberServlet?currentPage=${pages}&&selcity=${selcity }&&seltelfee=${seltelfee }&&selnumb_form=${strselnumb_form }&&selnumb_type=${selnumb_type }&&inputstyle=${inputstyle }">尾页 </a>  
    <input type="text" name="currentPage" class="input-page-style">
    	<input type="submit" value="go" /></td>
  </tr>
</table>
</form>

  </div>
</div>



</body>
</html>
