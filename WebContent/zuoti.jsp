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
        var problemID;
        var userName;
    // 创建HttpRequest对象
    function createXmlHttpRequest(){
   	 if(window.XMLHttpRequest){
   		 xmlHttpReq = new XMLHttpRequest();// 非IE浏览器
   	 }else{
   		 xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");// IE浏览器
   	 }
    }
    // 获取题目详细信息事件
    function getProDetailEvent(){
   	 //alert(username);
   	 createXmlHttpRequest();// 创建HttpRequest对象
   	 xmlHttpReq.onreadystatechange=getDetailResHandle;// 设置收到回复时的动作
   	 var url = "jsp_action/get_problem_detail.jsp?problem_id=" + problemID;
   	 xmlHttpReq.open("post",url,true);
   	 // 向服务器发送请求
   	 xmlHttpReq.send(null);
    }
    // 收到回复时的回调函数
    function getDetailResHandle(){
   	 if(xmlHttpReq.readyState==4){
   		 // 响应码若为200，则代表一切正常
   		 if(xmlHttpReq.status==200){
   			 var resultText = xmlHttpReq.responseText;
   		     //alert(resultText);
   			 var pro_id = problemID;
   			 var pro_title = eval("(" + resultText + ")").title;
   			 var pro_description = eval("(" + resultText + ")").description;
   			 var pro_input_case = eval("(" + resultText + ")").inputCase;
   			 var pro_output_case = eval("(" + resultText + ")").outputCase;
   		     //alert(pro_title);
   			 document.getElementById("bianhao").innerHTML = "NO." + pro_id;
   			 document.getElementById("biaoti2").innerHTML = pro_title;
   			 document.getElementById("miaoshu2").innerHTML = pro_description;

   				getSolRecord();// 获取做题记录
   		 }
   	 }
    }
function getParamFromUrl(name){
	// 从URL中获取参数
	var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)");
	var result = window.location.search.substr(1).match(reg);
	if(result!=null)return unescape(result[2]);
	return null;
}
function getSolRecord(){
	// 获取做题记录
  	 createXmlHttpRequest();// 创建HttpRequest对象
  	 xmlHttpReq.onreadystatechange=getRecordResHandle;// 设置收到回复时的动作
  	 var url = "jsp_action/get_problem_record.jsp?problem_id=" + problemID + "&username=" + userName;
  	 xmlHttpReq.open("post",url,true);
  	 // 向服务器发送请求
  	 xmlHttpReq.send(null);
}
//收到做题记录时的回调函数
function getRecordResHandle() {
    if (xmlHttpReq.readyState == 4) {
        // 响应码若为200，则代表一切正常
        if (xmlHttpReq.status == 200) {
            var resultText = xmlHttpReq.responseText;
			if(resultText=="null"){
				
			}else{
				// json deserialize
				// undone
				var zuotiJieguo = eval("(" +resultText + ")").result;// 上次做题结果
				var submitTime = eval("(" +resultText + ")").time;// 上次做题时间
				//alert(submitTime);
				// 需要加一个显示上次做题结果的位置
			}
        }
    }
}
function checkSession(){
	userName='<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
	problemID = getParamFromUrl("problem_id");
	//alert(getParamFromUrl("problem_id"));
	if(userName=="null"){
		alert("请先登录!");
		window.location.href="login.jsp";
	}else{
		//alert(window.location.href);
		getProDetailEvent()
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
            <textarea id="shangchuan" name="daima"></textarea>
            <input type="submit" id="tijiaokuang" value="提交">
        </form>
    </div>


    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>