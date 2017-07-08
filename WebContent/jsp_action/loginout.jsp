<%@page import="helper.ConfHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%> 
 <% 
 System.out.println("session:" + session.getAttribute(ConfHelper.SESSION_USER_NAME));
 session.removeAttribute(ConfHelper.SESSION_USER_NAME); 
 response.getWriter().println("logout_success");
 System.out.println("session:" + session.getAttribute(ConfHelper.SESSION_USER_NAME));
 response.sendRedirect("../welcome.jsp");
 %> 
