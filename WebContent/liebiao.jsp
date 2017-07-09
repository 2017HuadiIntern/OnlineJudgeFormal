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
            var pageSize = 10;    //每页显示的记录条数
             var curPage=1;        //当前页
             var lastPage;        //最后页
             var direct=0;        //方向
            var len;            //总行数
            var page;            //总页数
            var begin;
            var end;
	var userName = "null";

            function display(){
                //len =$("#mytable tr").length ;    // 求这个表的总行数
                //page=len % pageSize==0 ? len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
                // alert("page==="+page);
                //curPage=1;    // 设置当前为第一页
                //displayPage();//显示第一页

                document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页  ";    // 显示当前多少页
                document.getElementById("sjzl").innerHTML="共有" + len + "道题";   }     // 显示数据量
                function firstPage(){    // 首页
                    curPage=1;
                    direct = 0;
                    display();
                    fetchProblem();
                };
                function frontPage(){    // 上一页
                    direct=-1;
                    if (curPage <= 1) {
                        alert("已经是第一页了");
                        return;
                    }
                    --curPage;
                    display();
                    fetchProblem();
                };
                function nextPage() {    // 下一页
                    direct = 1;
                    if (curPage >= page) {
                        alert("已经是最后一页了");
                        return;
                    }
                    ++curPage;
                    display();
                    fetchProblem();
                };
                function lastPage(){    // 尾页
                    curPage=page;
                    direct = 0;
                    display();
                    fetchProblem();
                };

            function displayPage(){
                if(curPage <=1 && direct==-1){
                    direct=0;
                    alert("已经是第一页了");
                    return;
                } else if (curPage >= page && direct==1) {
                    direct=0;
                    alert("已经是最后一页了");
                    return ;
                }

                lastPage = curPage;

                // 修复当len=1时，curPage计算得0的bug
                if (len > pageSize) {
                    curPage = ((curPage + direct + len) % len);
                } else {
                    curPage = 1;
                }


                document.getElementById("btn0").innerHTML="当前 " + curPage + "/" + page + " 页    每页 ";        // 显示当前多少页

                begin=(curPage-1)*pageSize + 1;// 起始记录号
                end = begin + 1*pageSize - 1;    // 末尾记录号


                if(end > len ) end=len;
                $("#mytable tr").hide();    // 首先，设置这行为隐藏
                $("#mytable tr").each(function(i){    // 然后，通过条件判断决定本行是否恢复显示
                    if((i>=begin && i<=end) || i==0 )//显示begin<=x<=end的记录
                        $(this).show();
                });

             }
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
            function fetchProblem(){
            	// 获取题目数据
            	var url = "jsp_action/fetch_problem_list.jsp?problem_list_page=" + curPage;
            	createXmlHttpRequest();// 创建HttpRequest对象
           	 	xmlHttpReq.onreadystatechange=fetchResHandle;// 设置收到回复时的动作
           	 	xmlHttpReq.open("post",url,true);
           	 	// 向服务器发送请求
           	 	xmlHttpReq.send(null);
            }
         // 收到题目回复时的回调函数
            function fetchResHandle(){
           	 if(xmlHttpReq.readyState==4){
           		 // 响应码若为200，则代表一切正常
           		 if(xmlHttpReq.status==200){
           			 var resultText = xmlHttpReq.responseText;
           			 //alert(resultText);
           			 var RecText = eval(resultText);
           			 //alert(RecText[0].ID);
           		     // 对列表赋值
           			 var problemTable = document.getElementById("table_problem");
           			 problemTable.innerHTML = "<thead><tr><th>编号</th><th>标题</th><th>作者</th></tr></thead>";
                     /*
           			 for (var row = 1; row < RecText.length; row++) {
           			     problemTable.deleteRow(row);
           			 }
                     */
                     
           			 for (var row = 1; row <= RecText.length; row++) {

           			     var rowCell = problemTable.insertRow(row);
           			     rowCell.insertCell(0).innerHTML = "<a href=\"javascript:toZuoti("+RecText[row - 1].ID+")\">" + RecText[row - 1].ID + "</a>";
           			     rowCell.insertCell(1).innerHTML = "<a href=\"javascript:toZuoti("+RecText[row - 1].ID+")\">" + RecText[row - 1].title + "</a>";
           			     rowCell.insertCell(2).innerHTML = RecText[row - 1].proposer;
           			 }
                     
           		 }
           	 }
            }
         function toZuoti(pro_id){
        	 // 前往做题页面
    		if (userName == "null") {
        			// 用户未登录
        			alert("请先登录!");
        			window.location.href="login.jsp";
    		} else {
    			window.location.href="zuoti.jsp?problem_id=" + pro_id;
    		} 
         }
         function getProblemCount(){
        	 // 获取总题目数量
        	// 获取题目数据
         	var url = "jsp_action/get_problem_count.jsp";
         	createXmlHttpRequest();// 创建HttpRequest对象
        	xmlHttpReq.onreadystatechange=getCountResHandle;// 设置收到回复时的动作
        	xmlHttpReq.open("post",url,true);
        	// 向服务器发送请求
        	xmlHttpReq.send(null);
         }
      // 收到题目数量回复时的回调函数
         function getCountResHandle(){
        	 if(xmlHttpReq.readyState==4){
        		 // 响应码若为200，则代表一切正常
        		 if(xmlHttpReq.status==200){
        			 var resultText = xmlHttpReq.responseText;
        		     //alert(resultText);
        			 len = parseInt(resultText);
        			 page = parseInt(len / (pageSize + 1)) + 1;
        			 // 获取题目数统计
        			 display();
        			 fetchProblem();
        		 }
        	 }
         }
            function onloadAction(){
            	// 起始动作
            	checkSession();
            	getProblemCount();
            	//fetchProblem();
            }
            function checkSession(){
                userName='<%=session.getAttribute(ConfHelper.SESSION_USER_NAME)%>';
            }
    </script>

</head>
<body onload="onloadAction()">
    <table id="mytable" align="center">

        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span12">
                    <table class="table" id="table_problem">
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

                    </table>
                </div>
            </div>
        </div>
        <div id=fanye>
            <a id="btn0"></a>
            <a id="sjzl"></a>
            <a href="javascript:firstPage()" id="btn1">首页</a>
            <a href="javascript:frontPage()" id="btn2">上一页</a>
            <a href="javascript:nextPage()" id="btn3">下一页</a>
            <a href="javascript:lastPage()" id="btn4">尾页</a>
        </div>


        <script src="js/jquery-1.11.3.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
</body>
</html>