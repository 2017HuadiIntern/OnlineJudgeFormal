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

</script>
 </head> 
   <body>
 
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							标题
						</th>
						<th>
							作者
						</th>
					
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							<a href="zuoti.jsp">题1</a>
						</td>
						<td>
							01/04/2012
						</td>
						
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>



<script src="js/jquery-1.11.3.min.js"></script> 
<!-- Include all compiled plugins (below), or include individual files as needed --> 
<script src="js/bootstrap.js"></script>
</body>
</html>