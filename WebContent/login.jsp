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
 // 实现不跳转页面获取反馈信息
 var xmlHttpReq;
 // 创建HttpRequest对象
 function createXmlHttpRequest(){
	 if(window.XMLHttpRequest){
		 xmlHttpReq = new XMLHttpRequest();// 非IE浏览器
	 }else{
		 xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");// IE浏览器
	 }
 }
 // 注册事件
 function loginEvent(){
	 var username = document.getElementById("username").value;
	 var password = document.getElementById("password").value;
	 createXmlHttpRequest();// 创建HttpRequest对象
	 xmlHttpReq.onreadystatechange=responseHandle;// 设置收到回复时的动作
	 var url = "jsp_action/login_action.jsp?username="+username+"&password="+password;
	 xmlHttpReq.open("post",url,true);
	 // 向服务器发送请求
	 xmlHttpReq.send(null);
 }
  // 登录事件
 function nevigateToLogin(){
 	alert("您尚未登录!");
 	window.location.href="login.jsp";
 }
 // 收到回复时的回调函数
 function responseHandle(){
	 if(xmlHttpReq.readyState==4){
		 // 响应码若为200，则代表一切正常
		 if(xmlHttpReq.status==200){
			 var resultText = xmlHttpReq.responseText;
			 if(resultText.indexOf("success") > 0){
			 	alert("登录成功!");
			 	window.parent.location.href="welcome.jsp";
			 }else{
			 	var resultLabel = document.getElementById("result");
			 	resultLabel.innerHTML = resultText;
			 }
		 }
	 }
 }
 function checkSession(){
	var userName='<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
	if(userName=="null"){
	}else{
		
	}
	
}
 </script>
 </head> 
   <body onload="checkSession()">
 <form action="jsp_action/login_action.jsp" method="post"> 
  <table id="login"> 
   <tr> 
    <td colspan="2">登录窗口</td> 
   </tr> 
   <tr> 
    <td>用户名：</td> 
    <td><input type="text" id="username" /> 
    </td> 
   </tr> 
   <tr> 
    <td>密码：</td> 
    <td><input type="password" id="password" /> 
    </td> 
   </tr> 
   <tr> 
    <td colspan="2"><input type="button" class="btn btn-primary" value="登录" onclick="loginEvent()"/> <a href="register.jsp">注册</a> 
    </td> 
   </tr>
   <tr><td></td><td><font color="#FF0000" id="result"></font></td></tr> 
  </table> 
 </form> 
</body> 
