<%@page import="record_management.Record"%>
<%@page import="problem_management.Problem"%>
<%@page import="helper.JSONHelper"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="user_management.UserFactory"%>
<%@page import="helper.ConfHelper"%>
<%@page import="helper.DBHelper.DBObjectType"%>
<%@page import="user_management.User"%>
<%@page import="helper.DBHelper"%>
<%@page import="helper.StringHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<% 
/* 提供获取做题记录的服务 */
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
%> 
 <% 
 /* 获取表单提交数据 */
 int pro_id = Integer.parseInt(request.getParameter(ConfHelper.REQUEST_PROBLEM_ID));
 String UserName = request.getParameter(ConfHelper.REQUEST_USER_NAME);
 // undone
 %> 
<%
/* 在数据库中查找记录 */
DBHelper dbHelper = new DBHelper(new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH));
String sqlString = "select * from " + dbHelper.RecordTable + " where " + dbHelper.RecordTable_Solver + 
"=\'" + UserName + "\' and " + dbHelper.RecordTable_ProblemID + "=" + pro_id + ";";
System.out.println("sql exec:" + sqlString);
ArrayList<Object> recordList = dbHelper.execMySQLQuery(sqlString, DBObjectType.TYPE_RECORD);
if(recordList.isEmpty()){
	response.getWriter().println("null");
	return;
}
Record record = (Record)recordList.get(0);
%>
<%
dbHelper.disconnectDB();
/* 发送json */
String json = JSONHelper.JSONSerialize(record);
System.out.print("Record json:\r\n" + json + "\r\n");
response.getWriter().print(json);
%>