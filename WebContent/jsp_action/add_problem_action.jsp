<%@page import="helper.StringHelper"%>
<%@page import="problem_management.ProblemFactory"%>
<%@page import="user_management.UserFactory"%>
<%@page import="helper.DBHelper.DBObjectType"%>
<%@page import="helper.ConfHelper"%>
<%@page import="helper.DBHelper"%>
<%@page import="user_management.User"%>
<%@page import="problem_management.Problem" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<% 
String path = request.getContextPath(); 
String basePath = request.getSession().getServletContext().getRealPath("/");
System.out.println("absolute path: " + basePath);
%> 
 
 <%--题目添加服务 --%>
 <%
 String UserName = request.getParameter(ConfHelper.REQUEST_USER_NAME);
 String ProblemTitle = request.getParameter(ConfHelper.REQUEST_PROBLEM_TITLE);
 String ProblemDescription = request.getParameter(ConfHelper.REQUEST_PROBLEM_DESCRIPTION);
 String ProblemInputCase = request.getParameter(ConfHelper.REQUEST_PROBLEM_INPUT_CASE);
 String ProblemOutputCase = request.getParameter(ConfHelper.REQUEST_PROBLEM_OUTPUT_CASE);
 
 %>
 <%
 /* 判断提交项是否包含特殊字符 */

 %>
 <%
 /* 从数据库中寻找一个未使用的题目编号 */
 DBHelper dbHelper = new DBHelper(new ConfHelper(basePath + "\\" + ConfHelper.CONF_FILE_RELATED_PATH));
 ArrayList<Object> problemList = dbHelper.execMySQLQuery("select * from " + dbHelper.ProblemTable);
 int newID = 1;
 int tempID;
for(Object problem : problemList){
	tempID = ((Problem)problem).getID();
	if(tempID >= newID)newID = tempID + 1;
}
 %>
 <%
 /* 将题目存入数据库 */
 Problem problem = ProblemFactory.createProblem();
 problem.setID(newID);
 problem.setTitle(ProblemTitle);
 problem.setDescription(ProblemDescription);
 problem.setInputCase(ProblemInputCase);
 problem.setOutputCase(ProblemOutputCase);
 problem.setProposer(UserName);
 dbHelper.createDBObject(problem, DBObjectType.TYPE_PROBLEM);
 dbHelper.disconnectDB();
 %>
 <%
 /* 发送消息 */
 response.getWriter().println("add_problem_success");
 %>