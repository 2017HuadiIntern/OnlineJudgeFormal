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
/* 提供获取题目详细信息的服务 */
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
%> 
 <% 
 /* 获取表单提交数据 */
 int pro_id = Integer.parseInt(request.getParameter(ConfHelper.REQUEST_PROBLEM_ID));
 %> 
 <%
 /* 从数据库中获取题目对象 */
 DBHelper dbHelper = new DBHelper(new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH));
 Problem problem = (Problem)dbHelper.getDBObject(dbHelper.ProblemTable_ID, pro_id, DBObjectType.TYPE_PROBLEM).get(0);
 dbHelper.disconnectDB();
 %>
 <%
 %>
 <%
 /* 封装为JSON对象并返回 */
 String json = JSONHelper.JSONSerialize(problem);
 System.out.print("problem detail:\r\n"+json+"\r\n");
 response.getWriter().print(json);
 %>
