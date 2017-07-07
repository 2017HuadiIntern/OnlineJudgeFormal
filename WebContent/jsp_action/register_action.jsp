<%@page import="java.io.PrintWriter"%>
<%@page import="user_management.UserFactory"%>
<%@page import="helper.ConfHelper"%>
<%@page import="helper.DBHelper.DBObjectType"%>
<%@page import="user_management.User"%>
<%@page import="helper.DBHelper"%>
<%@page import="helper.StringHelper"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 

<% 
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);


final String Input_UserName = "username"; 
final String Input_Password = "password1";
final String Input_ConfirmPassword = "password2";
%> 
 <% 
 /* 获取表单提交数据 */
 String userName = request.getParameter(Input_UserName);
 String password = request.getParameter(Input_Password);
 String confirmPassword = request.getParameter(Input_ConfirmPassword);
 %> 
 <%
 /* 检查两次输入的密码是否匹配 */
 if(!confirmPassword.equals(password)){
 	// 提示两次输入密码不匹配
 	response.getWriter().println("两次输入的密码不匹配!");
 	return;
 }
  %>
  <%
  /* 检验用户名和密码字符合法性 */
  if(userName.isEmpty()){
  	// 提示用户名不能为空
  	response.getWriter().println("用户名不能为空!");
  	return;
  }
  if(StringHelper.isContainChinese(userName)){
  	// 提示用户名中不能包含中文
  	response.getWriter().println("用户名不能包含中文!");
  	return;
  }
  if(StringHelper.isContainChinese(password)){
  	// 提示密码不能包含中文
  	response.getWriter().println("密码不能包含中文!");
  	return;
  }
   %>
   <%
   /* 检查用户是否已存在 */
   ConfHelper confHelper = new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH);
   DBHelper dbHelper = new DBHelper(confHelper);// 使用数据库助手
   ArrayList<Object> check_users = dbHelper.getDBObject(dbHelper.UserTable_Name, userName, DBObjectType.TYPE_USER);
   if(check_users!=null){
   		if(!check_users.isEmpty()){
   			// 提示相同用户名的用户已存在，请更换用户名
   			response.getWriter().println("该用户名已存在，请使用另一用户名!");
   			return;
   		}
   }
    %>
    <%
    /* 将该用户添加到数据库中 */
    User newUser = UserFactory.createUser();
    newUser.setUserName(userName);
    newUser.setPassword(password);
    dbHelper.createDBObject(newUser, DBObjectType.TYPE_USER);
    dbHelper.disconnectDB();
    // 提示注册成功，并跳转到登录页面
    response.getWriter().println("register_success");
     %>
