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
	alert("start");
	var userName='<%=session.getAttribute("UserName")%>';

	alert(userName);
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
      <a class="navbar-brand" href="welcome.jsp">主页</a> </div>
    
    <div class="collapse navbar-collapse" id="myDefaultNavbar1">
      <ul class="nav navbar-nav">
        <li><a href="liebiao.jsp">在线答题</a></li>
        <li><a href="bianji.jsp">编辑题目</a></li>
       <li><a href="login.jsp">登录</a></li>      </ul>
</div> 
  </div>
</nav>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<div class="carousel slide" id="carousel-343676">
				<ol class="carousel-indicators">
					<li class="active" data-slide-to="0" data-target="#carousel-343676">
					</li>
					<li data-slide-to="1" data-target="#carousel-343676">
					</li>
					<li data-slide-to="2" data-target="#carousel-343676">
					</li>
				</ol>
				<div class="carousel-inner">
					<div class="item active">
						<img alt="" src="image/logo1.jpg" />
						<div class="carousel-caption">
							<h4>
								<span>。</span>
							</h4>
						</div>
					</div>
					<div class="item">
						<img alt="" src="image/logo2.jpg" />
						<div class="carousel-caption">
							<h4>
							</h4>
						</div>
					</div>
					<div class="item">
						<img alt="" src="image/logo3.jpg" />
						<div class="carousel-caption">
							<h4>
								
							</h4>
						</div>
					</div>
				</div> <a data-slide="prev" href="#carousel-343676" class="left carousel-control">‹</a> <a data-slide="next" href="#carousel-343676" class="right carousel-control">›</a>
			</div>
		</div>
	</div>
</div>
<div id="yejiao"><p id="biao">版权所属：牛逼的王瑞珏</p></div>



<script src="js/jquery-1.11.3.min.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.js"></script>
</center>
</body>
</html>