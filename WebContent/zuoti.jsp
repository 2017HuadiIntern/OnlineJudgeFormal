<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@page import="helper.ConfHelper"%>
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
 <head> 
 <base href="<%=basePath%>"> 
   <meta charset="utf-8">
 <title>牛逼的王瑞珏</title> 
<script type="text/javascript" src="bootstrap/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
<link href="bootstrap/style.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   
 <meta http-equiv="pragma" content="no-cache"> 
 <meta http-equiv="cache-control" content="no-cache"> 
 <meta http-equiv="expires" content="0">  
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
 <meta http-equiv="description" content="This is my page"> 
<script type="text/javascript">
function checkSession(){
	var userName='<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
	if(userName=="null"){
		alert("请先登录!");
		window.location.href="login.jsp";
	}else{
	}
}
</script>
 </head> 
   <body onload="checkSession()">
<script src="js/jquery-1.11.3.min.js"></script> 
<script src="js/bootstrap.js"></script>
<p id="bianhao">编号</p><p id="biaoti2">这是问题的标题</p>
<div id="dati"><p id="miaoshu2">这是问题的描述</p></div>
<div id="daima">
<form name="input" action="代码输入文件" method="get">
<textarea id="shangchuan" name="daima" ></textarea>
<input type="submit" id="tijiaokuang" value="提交"></form></div>


<script src="js/jquery-1.11.3.min.js"></script> 
<script src="js/bootstrap.js"></script>
</body>
</html>