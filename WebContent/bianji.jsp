<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 
<html> 
 <head> 
 <base href="<%=basePath%>"> 
   
 <title>牛逼的王瑞珏</title> 
<script type="text/javascript" src="js/jquery-1.11.3min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
<link href="bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet">
<link href="bootstrap/style.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   
 <meta http-equiv="pragma" content="no-cache"> 
 <meta http-equiv="cache-control" content="no-cache"> 
 <meta http-equiv="expires" content="0">  
 <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 
 <meta http-equiv="description" content="This is my page"> 
 <!-- 
 <link rel="stylesheet" type="text/css" href="style.css"> 
 -->
 </head> 
   <body>
<nav class="navbar navbar-default">
  <div class="container"> 
    <div class="navbar-header">
  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#myDefaultNavbar1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
      <a class="navbar-brand" href="welcome.jsp">主页</a> </div>

    <div class="collapse navbar-collapse" id="myDefaultNavbar1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="liebiao.jsp">在线答题 <span class="sr-only">(current)</span></a></li>
        <li><a href="bianji.jsp">编辑题目</a></li>
       <li><a href="login.jsp">登录</a></li>      </ul>
</div>  
  </div> 
</nav>
<div>
<form action="bianji_action.jsp" method=get>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题目：<textarea  id="biaoti" > </textarea>
<textarea  id="miaoshu" >问题的详细描述： </textarea>
<textarea  id="yangli" >测试用的输入用例： </textarea>
<textarea  id="shuchu" >应有的输出响应：</textarea>
<input type="submit" id="tijiaokuang" value="提交"></form>
</div>



<div id="yejiao"><p id="biao">版权所属：牛逼的王瑞珏</p></div>


<script src="js/jquery-1.11.3.min.js"></script> 
<script src="js/bootstrap.js"></script>

</body>
</html>