<%@page import="net.sf.json.JSONArray"%>
<%@page import="problem_management.Problem"%>
<%@page import="problem_management.ProblemFactory"%>
<%@page import="problem_management.ProblemList"%>
<%@page import="problem_management.ProblemListItem"%>
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
/* 提供获取题目列表的服务 */
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
 %>

<%
/* 从数据库中获取题目数量 */
DBHelper dbHelper = new DBHelper(new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH));
int problemCount = Integer.parseInt(dbHelper.execMySQLQuery("select count(*) from " + dbHelper.ProblemTable + ";", "count(*)").get(0).toString());
dbHelper.disconnectDB();
%>
<%
System.out.println("problem count = " + problemCount);
response.getWriter().println(problemCount);
%>