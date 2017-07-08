<%@page import="user_management.UserFactory"%>
<%@page import="helper.DBHelper.DBObjectType"%>
<%@page import="helper.ConfHelper"%>
<%@page import="helper.DBHelper"%>
<%@page import="user_management.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
%> 
 
 <%--题目编辑服务 --%>
 <%
 String UserName = request.getParameter(ConfHelper.REQUEST_USER_NAME);
 String Password = request.getParameter(ConfHelper.REQUEST_LOGIN_PASSWORD);
 
 %>