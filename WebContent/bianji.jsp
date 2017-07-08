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
    var title_value = document.getElementById("biaoti").value;
    var description_value = document.getElementById("miaoshu").value;
    var inputArray = new Array([TextCounter]);
    var outputArray = new Array([TextCounter]);
    var caseCounter = 0;
    for (caseCounter = 0; caseCounter < TextCounter; caseCounter++) {
        inputArray[caseCounter] = document.getElementById("InputCase" + caseCounter).value;
        outputArray[caseCounter] = document.getElementById("OutputCase" + caseCounter).value;
    }
    dform.innerHTML += "输入用例" + (TextCounter + 1) + ":<input type=\"text\" id=\"InputCase" + TextCounter + "\"/> 输出用例" +
        (TextCounter + 1) + "<textarea class=\"outputcase\" id=\"OutputCase" + TextCounter + "\"/></textarea><br/>";
    // 把文本框的值返回
    document.getElementById("biaoti").value = title_value;
    document.getElementById("miaoshu").value = description_value;
    for (caseCounter = 0; caseCounter < TextCounter; caseCounter++) {
        document.getElementById("InputCase" + caseCounter).value = inputArray[caseCounter];
        document.getElementById("OutputCase" + caseCounter).value = outputArray[caseCounter];
    }
    ++TextCounter;
}
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
// 提交事件
function submitEvent(){
    var username = '<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
    var problemTitle = document.getElementById("biaoti").value;
    var problemDescription = document.getElementById("miaoshu").value;
    var caseCounter = 0;
    var inputCaseArray = "";
    var outputCaseArray = "";
    for (caseCounter = 0; caseCounter < TextCounter; caseCounter++) {
        inputCaseArray += "<input"+ caseCounter +">" + document.getElementById("InputCase" + caseCounter).value + "</input"+caseCounter+">";
        outputCaseArray += "<output" + caseCounter + ">" + document.getElementById("OutputCase" + caseCounter).value + "</output" + caseCounter + ">";
    }
	 createXmlHttpRequest();// 创建HttpRequest对象
	 xmlHttpReq.onreadystatechange=responseHandle;// 设置收到回复时的动作
	 var url = "jsp_action/add_problem_action.jsp?username=" + username + "&problem_title=" + problemTitle +
	     "&problem_description=" + problemDescription + "&problem_input_case=" + inputCaseArray + "&problem_output_case=" +
	     outputCaseArray;
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
			 	alert("创建成功!");
			 	window.location.href="liebiao.jsp";
			 }else{
			     alert(resultText);
			 }
		 }
	 }
}
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
<body>
    <div>
        <form method="post" id="dynamicForm">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目：<input id="biaoti" name="problem_title">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在此输入题目要求</p>
            <textarea id="miaoshu" name="problem_description"> </textarea>
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
            <input class="btn btn-warning" type="button" id="tijiaokuang" value="提交" onclick="submitEvent()">
        </form>

    </div>

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.js"></script>

</body>
</html>