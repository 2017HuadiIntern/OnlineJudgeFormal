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
 
 <%--该部分为手写登录过程 王瑞珏 --%>
 <%
 String UserName = request.getParameter("username");
 String Password = request.getParameter("password");
 boolean rs=false;
 String Temp="";
 
 if(UserName==null||Password==null||UserName.isEmpty())
 {
	 response.getWriter().println("用户名不能为空！");
	 return;
 }
 //链接数据库（待完成）
 /* 连接数据库 */
 DBHelper dbHelper = new DBHelper(new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH));
 ArrayList<Object> userList = dbHelper.getDBObject(dbHelper.UserTable_Name, UserName, DBObjectType.TYPE_USER);
 //查询用户名，如果查询到对应用户名将rs置为true
 User user = UserFactory.createUser();
 if(!userList.isEmpty()){
	 user = (User)userList.get(0);
	 if(user!=null)rs=true;
 }
 if(rs==false)
 {
	 response.getWriter().println("用户名或密码错误!");
	 return;
 }
 //将对应用户名的密码赋值给Temp
 Temp = user.getPassword();
 if(!Password.equals(Temp))
 {
	 response.getWriter().println("用户名或密码错误!");
	 return;
 }
 request.getSession().setAttribute("UserName", UserName);//使用用户名作为session的属性
 session.setMaxInactiveInterval(3600);
 //返回欢迎界面
 response.getWriter().println("login_success");
 %>