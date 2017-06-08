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

<script>
	function setDiscount(i){
		
		console.log(i);
		//document.getElementById("discount").value = values[1];
		//document.getElementById("T4").value = parseInt(values[1])+parseInt(values[0]);	
		
		
		//获得xmlHttpRequest对象
			getXMLHttpRequest();
			//打开URL地址
			
				//获取参数请求

				
				//准备url
				var url = "servlet/OnlineRechargeAjaxServlet?tel_charge="+i;

				//打开
				xmlHttpRequest.open("post",url,true);
			
				//为xmlHttpRequst对象设置回调函数
				xmlHttpRequest.onreadystatechange = callback;
				
				//发出请求
				xmlHttpRequest.send(null);

	 }
	 
	 function callback(){

			
			
				//获取参数请求
				var tel_charge = document.getElementById("tel_charge").value;
				
			
			if(xmlHttpRequest.readyState == 4){
				

				console.log(xmlHttpRequest.readyState);
				console.log("ajax已开启-------------");
				if(xmlHttpRequest.status == 200){
					
					//alert(xmlHttpRequest.status);   //200
					console.log(xmlHttpRequest.status);
					
					
					var res = xmlHttpRequest.responseXML.getElementsByTagName("result"); //null
					
					var result;
									
					for(var i = 0;i < res.length;i++){
						result = res[i].firstChild.nodeValue;
					}
					
		
				
					//discount.innerHTML=result;
					var values = result.split(",");
					document.getElementById("discount").value = values[1];
					document.getElementById("T4").value = parseInt(values[1])+parseInt(values[0]);
					
					console.log(i+"----------");
					//document.getElementById("T4").value=
								
				}
				
			}
			
			
					
		}
	
</script>
</head>



<body>
<div id="online-contain">

    	<div id="card-procedure2"></div>
    <div id="online-main">
    
       
<form method="POST" action="servlet/OnlineComfirmServlet" class="form-style">
<table  class="table-style-online" >

  <tr>
    <td class="left-td-style">充值号码：</td>
    <td class="right-td-style"><input type="text"  name="T3" size="20" class="input-form-style" value="${mobile }" ></td>
   </tr>
  <tr>
  	 <td class="left-td-style">充值金额：</td>
     <td class="right-td-style"><input type="radio" id="tel_charge" name="value" value="10" onclick="setDiscount(this.value)"/>10元
                 <input type="radio" id="tel_charge" name="value" value="30" onclick="setDiscount(this.value)">30元
                 <input type="radio" id="tel_charge"  name="value" value="50" onclick="setDiscount(this.value)"/>50元
                 <input type="radio" id="tel_charge"  name="value" value="100" checked="checked" onclick="setDiscount(this.value)"/>100元
                 <input type="radio" id="tel_charge" name="value" value="200" onclick="setDiscount(this.value)">200元
                 <input type="radio" id="tel_charge" name="value" value="500" onclick="setDiscount(this.value)"/>500元
                 <input type="radio" id="tel_charge" name="value" value="1000" onclick="setDiscount(this.value)"/>1000元
                 </td>
  </tr>
   <tr>
  	 <td class="left-td-style">充值优惠：</td>
     <td class="right-td-style"><input type="text" readOnly="readOnly" name="discount" id="discount" size="20" value="8" class="input-form-style" ></td>
  </tr>
  <tr>
  	 <td class="left-td-style">实际到账：</td>
     <td class="right-td-style"><input type="text" name="T4" id="T4" size="20" value="108" class="input-form-style"></td>
  </tr>
   
     <tr class="button-tr-style" >
  	 <td colspan="2" class="left-td-style"> 
     
    
     
     
       <input type="submit"  value="下一步" class="button-sub" onclick="location.href=''"/>
       <input type="reset" value="重置" class="button-res"/>
     </td>
     </tr>
  
 </table>
 

            
          
 </form>
   
    
    </div>

</div>
</body>
</html>
