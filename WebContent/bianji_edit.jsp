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
var TextCounter = 0;
function addText() {
    var dform = document.getElementById("dynamicForm");
    dform.innerHTML += "输入用例" + (TextCounter + 1) + ":<input type=\"text\" id=\"InputCase" + TextCounter + "\"/> 输出用例" +
        (TextCounter + 1) + "<textarea id=\"OutputCase" + TextCounter + "\"/></textarea><br/>";
    ++TextCounter;
}
function checkSession(){
	var userName='<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
	if(userName=="null"){
		alert("您尚未登录!");
		window.location.href="login.jsp";
	}else{
	}
}
    </script>
</head>
<body>
    <div>
        <form action="bianji_action.jsp" method=get>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目：<input id="biaoti">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在此输入题目要求</p>
            <textarea id="miaoshu"> </textarea>
            <div id="dynamicForm">
                <br />
            </div>
            <div id="tishi" class="alert alert-success">
                <button type="button" class="close" data-dismiss="alert">×</button>
                <h4>
                    温馨提示!
                </h4>  在输入用例信息时请细心检查其准确性。
            </div>
            <input id="zengjia" class="btn btn-info" type="button" value="增加用例" onclick="addText()" />
            <input class="btn btn-warning" type="submit" id="tijiaokuang" value="提交">
        </form>

    </div>

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.js"></script>

</body>
</html>