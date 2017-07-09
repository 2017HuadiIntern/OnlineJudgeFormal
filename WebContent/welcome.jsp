<%@page import="helper.ConfHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>在线C语言判题系统</title>
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
        var userName = "null";
        var iframeMain;
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
 // 退出登录事件
 function logoutEvent(){
 if(confirm("确定要退出登录吗?")){
	 //alert(username);
	 createXmlHttpRequest();// 创建HttpRequest对象
	 xmlHttpReq.onreadystatechange=responseHandle;// 设置收到回复时的动作
	 var url = "jsp_action/loginout.jsp";
	 xmlHttpReq.open("post",url,true);
	 // 向服务器发送请求
	 xmlHttpReq.send(null);
	 }
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
			 	alert("成功退出登录!");
				window.location.href="welcome.jsp";
			 }
		 }
	 }
 }

function checkSession(){
    userName='<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
    iframeMain = document.getElementById("yemian")
	if(userName=="null"){
		document.getElementById("panlogin2").innerHTML="登录";
		// document.getElementById("edit_problem").href="javascript:toLogin()";
	}else{
		var pan2 = document.getElementById("panlogin2");
		pan2.innerHTML = "退出登录";
		pan2.href = "javascript:logoutEvent()";
		document.getElementById("panUser").innerHTML = userName;
	}

}
function toIndex() {
    //前往主页
    iframeMain.src = "welcome2.jsp";
}
function toLiebiao() {
    // 前往题目浏览列表
    iframeMain.src = "liebiao.jsp";
}
function toBianji() {
    // 前往编辑页面
    if (userName == "null") {
        // 用户未登录
        alert("请先登录!");
        iframeMain.src = "login.jsp";
    } else {
        iframeMain.src = "bianji.jsp";
    }
}
function toLogin() {
    // 前往登录
    iframeMain.src = "login.jsp";
}
function toUserManagement() {
    // 前往修改用户信息
    if (userName != "null") iframeMain.src = "guanli.jsp";
    else iframeMain.src = "login.jsp";
}
    </script>
</head>
<body onload="checkSession()">
    <center>
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myDefaultNavbar1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="javascript:toIndex()">主页</a>
                </div>

                <div class="collapse navbar-collapse" id="myDefaultNavbar1">
                    <ul class="nav navbar-nav">
                        <li><a href="javascript:toLiebiao()">在线答题</a></li>
                        <li><a href="javascript:toBianji()" id="edit_problem">编辑题目</a></li>
                        <li id="panlogin"><a href="javascript:toLogin()" id="panlogin2">登录</a></li>
                        <li><a href="javascript:toUserManagement()" id="panUser">您尚未登录</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <iframe id="yemian" src="welcome2.jsp" width="820px" height="1200px" SCROLLING="yes" frameborder="no"></iframe>

        <div id="yejiao"><p id="biao">版权所属：牛逼的王瑞珏</p></div>



        <script src="js/jquery-1.11.3.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
    </center>
</body>
</html>