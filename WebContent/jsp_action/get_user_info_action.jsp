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
/* 提供获取用户信息的服务 */
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);


final String Input_UserName = ConfHelper.REQUEST_USER_NAME; 
%> 
 <% 
 /* 获取表单提交数据 */
 String userName = request.getParameter(Input_UserName);
 %> 
 <%
 /* 从数据库中获取用户对象 */
 DBHelper dbHelper = new DBHelper(new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH));
 User user = (User)dbHelper.getDBObject(dbHelper.UserTable_Name, userName, DBObjectType.TYPE_USER).get(0);// 获取用户对象
 dbHelper.disconnectDB();
 %>
 <%
 /*将用户对象封装为json报文*/
 if(user!=null){
 	String jsonStr = JSONHelper.JSONSerialize(user);
 	/*返回json报文*/
 	response.getWriter().print(jsonStr);
 }else{
 	response.getWriter().println("未能找到用户" + userName + "的信息!");
 }
 %>
