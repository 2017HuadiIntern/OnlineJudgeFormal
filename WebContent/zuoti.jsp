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
//实现不跳转页面获取反馈信息
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
function logoutEvent(){
	 //alert(username);
	 createXmlHttpRequest();// 创建HttpRequest对象
	 xmlHttpReq.onreadystatechange=responseHandle;// 设置收到回复时的动作
	 var url = "jsp_action/loginout.jsp";
	 xmlHttpReq.open("post",url,true);
	 // 向服务器发送请求
	 xmlHttpReq.send(null);
}
// 收到回复时的回调函数
function responseHandle(){
	 if(xmlHttpReq.readyState==4){
		 // 响应码若为200，则代表一切正常
		 if(xmlHttpReq.status==200){
			 var resultText = xmlHttpReq.responseText;
			 if(resultText.indexOf("success") > 0){
			 	alert("成功退出登录!");
				window.location.href="welcome.jsp";
			 }
		 }
	 }
}
// 登录事件
function nevigateToLogin(){
	alert("您尚未登录!");
	window.location.href="login.jsp";
}
function checkSession(){
	var userName='<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
	if(userName=="null"){
		document.getElementById("panlogin2").innerHTML="登录";
		alert("您尚未登录!");
		window.location.href="login.jsp";
		document.getElementById("edit_problem").href="javascript:nevigateToLogin()";
	}else{
		var pan2 = document.getElementById("panlogin2");
		pan2.innerHTML = userName + "退出登录";
		pan2.href="javascript:logoutEvent()";
	}
}
</script>
 </head> 
   <body onload="checkSession()">
 <nav class="navbar navbar-default">
  <div class="container"> 
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myDefaultNavbar1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand" href="welcome.jsp">主页</a> </div>
    
    <div class="collapse navbar-collapse" id="myDefaultNavbar1">
      <ul class="nav navbar-nav">
        <li><a href="liebiao.jsp">在线答题</a></li>
        <li><a href="bianji.jsp" id="edit_problem">编辑题目</a></li>
       <li><a href="login.jsp" id="panlogin2">登录</a></li>      </ul>
</div> 
  </div>
</nav>
<script src="js/jquery-1.11.3.min.js"></script> 
<script src="js/bootstrap.js"></script>
<p id="biaoti2">这是问题的标题</p>
<div id="dati"><p id="miaoshu2">这是问题的描述</p></div>
<div id="daima">
<form name="input" action="代码输入文件" method="get">
<textarea id="shangchuan" name="daima" ></textarea>
<input type="submit" id="tijiaokuang" value="提交"></form></div>
<div id="yejiao"><p id="biao">版权所属：牛逼的王瑞珏</p></div>


<script src="js/jquery-1.11.3.min.js"></script> 
<script src="js/bootstrap.js"></script>
</body>
</html>