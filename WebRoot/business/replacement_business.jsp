<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.domain.TBusinessFee"%>
<%@page import="com.domain.MobileSetMeal"%>
<%@page import="com.domain.ReplaceBusiness"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=basePath%>/css/index.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath%>/css/reset.css" rel="stylesheet" type="text/css" />
<title>无标题文档</title>


<script type="text/javascript" src="myjs.js"></script>

<script type="text/javascript">
	function switchStatus(businessId,target){
		var status = target.parentNode.childNodes[0].value;
		var status1 = target.parentNode.childNodes[1].value;

		if(status == 1){
			target.value="开通";
			//切换业务状态
			target.parentNode.childNodes[0].value=0;
			
		}else{
			target.value="关闭";
			//切换业务状态
			target.parentNode.childNodes[0].value=1;
		}
			//business.submit();
		
		if(status1 == 0){
			status1=1;
		}else{
			status1=0;
		}
		
		
		//验证账户——————Ajax验证
		getXMLHttpRequest();
		console.log("+++11111111111");
    	    var url = "servlet/BusinessOpenCloseAjaxServlet?status1="+status1+"&businessId="+businessId+"&mobile="+${mobile};


    	    xmlHttpRequest.open("post", url, true);

    	    // 3. 为xmlHttpRequest设置回调函数
    	    xmlHttpRequest.onreadystatechange = callback_openclose;	

    		 xmlHttpRequest.send(null);
	}

//调回函数
    	function callback_openclose(){
    		console.log("callback_openclose");
			
			
			
    		if(xmlHttpRequest.readyState == 4){		// 接收服务器响应的前提：a
    			// test
    			console.log(xmlHttpRequest.readyState);
    			console.log("1111111111");
    			console.log(xmlHttpRequest.status);
    			if (xmlHttpRequest.status == 200 || xmlHttpRequest.status == 0){	// 接收服务器响应的前提：b
    				// test
    				console.log(xmlHttpRequest.status);
    				
    				
    				// 1. responseText
    				var res = xmlHttpRequest.responseText;

    				
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
    				
    				//var values = result.split(",");

    				
    				
    				// 根据结果输出
					if(result.trim()=="true"){
						location.href="servlet/ReplaceBusinessServlet?mobile=${mobile}&name=${name}";


						
					
					}else{

					}
					

    			}	// 200
    		}	// 4	
    		
		
    	}	// callback
    	


</script>

</head>

<body id="changebus-body">
<div id="changebus-contain">
	<div id="changebus-main">
   
     <div id="hello" class="ywbl"></div>
   
		   <table  id="tab" class="table-infor-record-style2" width="700px" >
			  
			  <tr>
			    <th width="20%">业务名称</th>
			    <th width="10%">资费</th>
			  
			    <th width="25%">启用时间</th>
			    <th  width="25%">终止时间</th>
			    <th width="20%">操作</th>
			  </tr>
			  
			  
			 <%
			 	List<TBusinessFee> findBusinessFeeList=(List<TBusinessFee>)request.getAttribute("findBusinessFeeList");

			  	for(TBusinessFee tbf : findBusinessFeeList){
			  		//for(ReplaceBusiness rb : replaceBusinessList){
			 %> 	
			  	
			  <tr >
			    <td><%=tbf.getBusiness_name() %></td>
			    <td><%=tbf.getBusiness_charge() %></td>
			   
			    <td id="st"><%=tbf.getEffective_time() %></td>
			    <td id="ed"><%=tbf.getEnd_time() %></td>
			    	
			    	<%
			    		if(tbf.getIs_optional().equals("1")){
			    		out.println(tbf.getIs_optional()+"---------");
			    		if(tbf.getEffective_time().equals("--")||!tbf.getEnd_time().equals("--")){
			    	%>
			    	
			    <td>
			    	<form  id="business" action="">
			    		
			    		<input type="hidden" name="status" value="0"/>
			    		<input type="button"  id="open" name="open" class="blywkt" value="开通" 
			    		onclick="switchStatus(<%=tbf.getBusiness_id()%>,this)"/>
			    	</form>
			    </td>
			    	
			    	<% 	
			    		}else{
			    	%>	
			    <td>
			    	<form  id="business" action="">
			    		
			    		<input type="hidden" name="status" value="1"/>
			    		<input type="button"  id="close" name="close" class="blywkt" value="关闭" 
			    		onclick="switchStatus(<%=tbf.getBusiness_id()%>,this)"/>
			    	</form>
			    </td>
			    		
			    		
			    	<% 	
			    		}
			    	%>	
			    		
			    	<%	
			    		}else{
			    	%>	
			    		<td></td>
			    	<% 	
			    		//}
			    		}
			    	 %>
			  </tr>
			  	
			  <%
			  	}
			  %> 
			  
			
		</table>
		
		  <div class="tcbl"></div>
		  
		   <table class="table-infor-record-style2"  width="700px">
			  <tr>
			    <th>套餐名称</th>
			    <th>套餐资费</th>
			    <th>套餐详情</th>
			    <th>操作</th>
			  </tr>
			  
			    <form  >

		 
		 <%
		 	List<MobileSetMeal>	setmealList=(List<MobileSetMeal>)request.getAttribute("setmealList");
		  	for(MobileSetMeal msm : setmealList){
		 %> 	
		  	
			  <form>
			  	 <tr>
				    <td>神州行<%=msm.getPp_fee() %>元套餐</td>
				    <td><%=msm.getPp_fee() %>元</td>
				    <td><%=msm.getBusiness_name() %>,<%=msm.getFlag() %></td>
				    
				    <%
				    	if(msm.getFlag().equals("国内数据流量10M")){
				    %>	
				    	<td><input type="submit" id='dqtc' name="meal" class="dqtc" value= "当前套餐"/></td>
				    <%	
				    	}else{
				    %>	
				 	<td><input type="submit" id='dqtc' name="meal" class="dqtc" value= "开通"/></td>
				    <%	
				    	}
				     %>
				    
				  </tr>
			  </form>
		  <% 	
		  	}
		  %>

		</table>

	</div>
	</div>
            
    </body>
</html>

